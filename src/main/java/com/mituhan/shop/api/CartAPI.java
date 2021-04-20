package com.mituhan.shop.api;

import com.mituhan.shop.dto.CartDTO;
import com.mituhan.shop.entity.CartEntity;
import com.mituhan.shop.service.ICartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CartAPI {

    public static final Logger logger = LoggerFactory.getLogger(CartAPI.class);

    @Autowired
    private ICartService cartService;

    @PostMapping(value = "/carts")
    public ResponseEntity<CartDTO> createProduct(@RequestBody CartDTO model) {
        logger.info("Creating Cart : {}", model);
        try {
            CartDTO cartDTO = cartService.save(model);
            return new ResponseEntity<>(cartDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/carts/{cartId}")
    public ResponseEntity<CartDTO> editProduct(@PathVariable(name = "cartId") Long cartId,
                                                  @RequestBody CartDTO model) {
        Optional<CartEntity> cartEntity = cartService.findById(cartId);
        if (cartEntity.isPresent()){
            model.setId(cartId);
            // Trả về đối tượng sau khi đã edit
            return new ResponseEntity<>(cartService.save(model), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/carts")
    public ResponseEntity<HttpStatus> deleteProduct(@RequestBody Long[] ids) {
        try {
            cartService.delete(ids);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
