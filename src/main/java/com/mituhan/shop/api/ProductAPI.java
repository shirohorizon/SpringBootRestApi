package com.mituhan.shop.api;

import com.mituhan.shop.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api")
public class ProductAPI {

    List<ProductDTO> productList = new CopyOnWriteArrayList<>();

    @PostConstruct
    public void init(){
        // Thêm null vào List để bỏ qua vị trí số 0;
        productList.add(null);
    }

    @GetMapping("/products")
    public List<ProductDTO> getTodoList() {
        return productList;
    }

    /*
    phần path URL bạn muốn lấy thông tin sẽ để trong ngoặc kép {}
     */
    @GetMapping("/product/{productId}")
    public ProductDTO getTodo(@PathVariable(name = "productId") Integer productId){
        // @PathVariable lấy ra thông tin trong URL
        // dựa vào tên của thuộc tính đã định nghĩa trong ngoặc kép /product/{productId}
        return productList.get(productId);
    }

    /*
    @RequestBody nói với Spring Boot rằng hãy chuyển Json trong request body
    thành đối tượng productDTO
     */
    @PutMapping("/product/{productId}")
    public ProductDTO editTodo(@PathVariable(name = "productId") Integer productId,
                         @RequestBody ProductDTO product){
        productList.set(productId, product);
        // Trả về đối tượng sau khi đã edit
        return product;    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity deleteTodo(@PathVariable(name = "productId") Integer productId){
        productList.remove(productId.intValue());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> addTodo(@RequestBody ProductDTO product) {
        productList.add(product);
        // Trả về response với STATUS CODE = 200 (OK)
        // Body sẽ chứa thông tin về đối tượng product vừa được tạo.
        return ResponseEntity.ok().body(product);
    }


}
