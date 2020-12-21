package repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;
import javax.validation.*;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import model.Produit;
import service.CategoryService;
import service.ProductService;

@Controller
public class AdminProductController {

    private Path path;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/Admin/Product")
    public void setEditProduct(Produit product, Model model){
    	model.addAttribute("categoryList", categoryService.getAllCategory()); 
        model.addAttribute("product", product);
        model.addAttribute("title", "Edit Product");
    }
    public void setCreateProduct(Produit product, Model model){
    	model.addAttribute("categoryList", categoryService.getAllCategory());
        model.addAttribute("product", product);
        model.addAttribute("title", "Add Product");
    }
    
    @RequestMapping(value="/s", method=RequestMethod.GET)
    public String addProduct(@RequestParam(value="id", required=false) Long productId, Model model) {
    	// edit product

    	if(productId != null){
        	Produit product = productService.getProductById(productId);
    		setEditProduct(product, model);
    	}else{
        	// create product
            Produit  product = new Produit();
    		setCreateProduct(product, model);
    	}

        return "admin/saveProduct";
    }

    @RequestMapping(value="/s", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Produit product, BindingResult result,
                                 HttpServletRequest request, Model model) throws IOException {
        if (result.hasErrors()) {
        	if(product.getIdProduit() != null){
        		setEditProduct(product, model);
        	}else{
        		setCreateProduct(product, model);
        	}
            return "admin/saveProduct";
        }
        
      
        
        // product image
        String productImage = product.getPhoto();
        String rootDirectory = new File("").getAbsolutePath();
        
        // create product
        if(product.getIdProduit() == null){
        	productService.save(product);
            File theDir = new File(rootDirectory + "\\src\\main\\resources\\static\\images\\"
            							+ String.valueOf(product.getIdProduit()));
            FileUtils.forceMkdir(theDir);
        }else{
        	// update product
        	productService.save(product);
        }
        
        path = Paths.get(rootDirectory + "\\src\\main\\resources\\static\\images\\" 
        								+ product.getIdProduit() + "\\" + "0.png");

        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transform((Function<? super String, ? extends R>) new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }

        return "redirect:/Admin/Product";
    }

    @RequestMapping("/d")
    public String deleteProduct(@RequestParam(value="id", required=true) Long productId, 
    							Model model, HttpServletRequest request){
        String rootDirectory = new File("").getAbsolutePath();
        File theDir = new File(rootDirectory + "\\src\\main\\resources\\static\\images\\" + productId);

        if(theDir.exists()){
            try {
                FileUtils.deleteDirectory(theDir);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        productService.delete(productId);

        return "redirect:/Admin/Product";
    }
    
    @RequestMapping("/m")
    public  String productInventory(Model model){
        List<Produit> products = productService.getAllProducts();
        model.addAttribute("products", products);

        return "Admin/Product";
    }
}