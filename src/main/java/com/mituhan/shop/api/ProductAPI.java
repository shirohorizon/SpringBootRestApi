package com.mituhan.shop.api;

import com.mituhan.shop.dto.ProductDTO;
import com.mituhan.shop.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductAPI {
    @Autowired
    private IProductService productService;

    @PostMapping("/product")
    public ProductDTO createProduct(@RequestBody ProductDTO model) {
        // Trả về response với STATUS CODE = 200 (OK)
        // Body sẽ chứa thông tin về đối tượng product vừa được tạo.
        return productService.save(model);
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
    @PutMapping("/product/{productId}")
    public ProductDTO editProduct(@PathVariable(name = "productId") Integer productId,
                         @RequestBody ProductDTO product){
        // Trả về đối tượng sau khi đã edit
        return null;    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity deleteTodo(@PathVariable(name = "productId") Integer productId){

        return null;
    }




}
