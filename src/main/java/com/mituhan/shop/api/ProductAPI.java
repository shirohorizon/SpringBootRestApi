package com.mituhan.shop.api;

import com.mituhan.shop.api.input.ProductRequest;
import com.mituhan.shop.api.output.ProductResponse;
import com.mituhan.shop.converter.ProductConverter;
import com.mituhan.shop.dto.FilterNameDTO;
import com.mituhan.shop.dto.ProductDTO;
import com.mituhan.shop.entity.ProductEntity;
import com.mituhan.shop.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class ProductAPI {

    public static final Logger logger = LoggerFactory.getLogger(ProductAPI.class);

    @Autowired
    private IProductService productService;

    @Autowired
    private ProductConverter productConverter;

    @GetMapping(value = "/products")
    public ResponseEntity<ProductResponse> showProductList(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "page_size",defaultValue = "10") int page_size,
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "id") String sortBy) {
        try {
            Pageable paging = PageRequest.of(page-1,page_size, Sort.by(sortBy));
            ProductResponse response = productService.findAll(keyword, paging);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/products/{productId}")
    public ResponseEntity<ProductResponse> showProduct(@PathVariable(name = "productId") Long productId) {
        try {
            return new ResponseEntity<ProductResponse>(productService.findById(productId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/products")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest model) {
        logger.info("Creating Product : {}", model);
        try {
            return new ResponseEntity<>(productService.save(model) , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/products/{productId}")
    public ResponseEntity<ProductResponse> editProduct(@PathVariable(name = "productId") Long productId,
                                  @RequestBody ProductRequest model) {
        try {
            ProductResponse isProductExist = productService.findById(productId);
            if (isProductExist.getProducts() != null){
                model.getProduct().setId(productId);
                return new ResponseEntity<>(productService.save(model), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
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
