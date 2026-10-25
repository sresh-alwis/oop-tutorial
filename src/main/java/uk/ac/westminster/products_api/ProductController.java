package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@RequestMapping("/products")
public class ProductController {

    //Spring Creates the ProductService and hands it over.
    @Autowired
    private ProductService productService;


// Since these are Hardcoded, they have been commented.

//    @GetMapping("/{id}")
//        public Product getById(@PathVariable Long id){
//            return new Product (id,"Laptop",999.99);
//        }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();

    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id).orElse(null);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PostMapping("/products/digital")
    public Product addProduct(@RequestBody DigitalProduct product){
        return productService.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/products/search")
    public List<Product> searchProducts (@RequestParam String name){
        return productService.findByName(name); 
    }
}