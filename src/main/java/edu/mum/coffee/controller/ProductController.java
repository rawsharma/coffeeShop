package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Raw on 6/17/2017.
 */

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @RequestMapping(value = "/products/{id}",method = RequestMethod.GET)
    public Product getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/products")
    public void addProduct(@RequestBody Product product) {
        productService.save(product);

    }

   @RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
    public void updateProduct(@RequestBody Product product, @PathVariable int id) {
        product.setId(id);
        productService.save(product);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/product/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        productService.delete(productService.getProduct(id));
    }




}
