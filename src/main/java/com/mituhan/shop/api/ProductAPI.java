package com.mituhan.shop.api;

import com.mituhan.shop.dto.ProductDTO;
import com.mituhan.shop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductAPI {
    @Autowired
    private IProductService productService;

    @PostMapping(value = "/product")
    public ProductDTO createProduct(@RequestBody ProductDTO model) {
        return productService.save(model);
    }

    @PutMapping(value = "/product/{productId}")
    public ProductDTO editProduct(@PathVariable(name = "productId") Long productId,
                                  @RequestBody ProductDTO model){
        model.setId(productId);
        // Trả về đối tượng sau khi đã edit
        return productService.save(model);
    }

    @DeleteMapping("/product")
    public void deleteProduct(@RequestBody Long[] productIds){
        productService.delete(productIds);
    }

    @GetMapping("/products")
    public List<ProductDTO> getProductList() {
        return null;
    }

    /*
    phần path URL bạn muốn lấy thông tin sẽ để trong ngoặc kép {}
     */
    @GetMapping("/product/{productId}")
    public ProductDTO getProduct(@PathVariable(name = "productId") Long productId){
        // @PathVariable lấy ra thông tin trong URL
        // dựa vào tên của thuộc tính đã định nghĩa trong ngoặc kép /product/{productId}
        return null;
    }

    /*
    @RequestBody nói với Spring Boot rằng hãy chuyển Json trong request body
    thành đối tượng productDTO
     */







}
