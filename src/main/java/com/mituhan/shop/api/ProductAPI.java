package com.mituhan.shop.api;

import com.mituhan.shop.api.output.ProductOutput;
import com.mituhan.shop.dto.ProductDTO;
import com.mituhan.shop.entity.ProductEntity;
import com.mituhan.shop.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class ProductAPI {

    public static final Logger logger = LoggerFactory.getLogger(ProductAPI.class);

    @Autowired
    private IProductService productService;

    @GetMapping(value = "/products")
    public ProductDTO showProductList() {
        ProductOutput result = new ProductOutput();
        return null;
    }
    @GetMapping(value = "/products1")
    public ResponseEntity rootResponse() {
        String welcomeMessage = "Welcome to the spring boot integration test sample api";
        return new ResponseEntity<String>(welcomeMessage, HttpStatus.OK);
    }


    @PostMapping(value = "/products")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO model) {
        logger.info("Creating Product : {}", model);
        try {
            ProductDTO productDTO = productService.save(model);
            return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/products/{productId}")
    public ResponseEntity<ProductDTO> editProduct(@PathVariable(name = "productId") Long productId,
                                  @RequestBody ProductDTO model) {
        Optional<ProductEntity> productDTO = productService.findById(productId);
        if (productDTO.isPresent()){
            model.setId(productId);
            // Trả về đối tượng sau khi đã edit
            return new ResponseEntity<>(productService.save(model), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products")
    public ResponseEntity<HttpStatus> deleteProduct(@RequestBody Long[] productIds) {
        try {
            productService.delete(productIds);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
