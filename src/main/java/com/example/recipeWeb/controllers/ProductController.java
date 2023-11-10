package com.example.recipeWeb.controllers;

import com.example.recipeWeb.models.Product;
import com.example.recipeWeb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService)
    {
       this.productService = productService;
    }
    @GetMapping("/allProducts")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/recipeForProduct")
    @ResponseBody
    public List<Product> getRecipeForProduct() {
        return null;
    }
    @GetMapping("/product/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) throws IOException {
        File fileObject =  new File("./src/main/resources/assets/"+id+".jpg");
        byte[] base64encodedData = FileUtils.readFileToByteArray(fileObject);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
                        fileObject.getName() + "\"")
                .body(base64encodedData);
    }
}
