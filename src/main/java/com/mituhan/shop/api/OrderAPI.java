package com.mituhan.shop.api;

import com.mituhan.shop.dto.OrderDTO;
import com.mituhan.shop.dto.ProductDTO;
import com.mituhan.shop.entity.OrderEntity;
import com.mituhan.shop.entity.ProductEntity;
import com.mituhan.shop.service.IOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class OrderAPI {

    public static final Logger logger = LoggerFactory.getLogger(OrderAPI.class);

    @Autowired
    private IOrderService orderService;

    @PostMapping(value = "/orders")
    public ResponseEntity<OrderDTO> createProduct(@RequestBody OrderDTO model) {
        logger.info("Creating Order : {}", model);
        try {
            OrderDTO orderDTO = orderService.save(model);
            return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/orders/{orderId}")
    public ResponseEntity<OrderDTO> editProduct(@PathVariable(name = "orderId") Long orderId,
                                                  @RequestBody OrderDTO model) {
        try {
            Optional<OrderEntity> orderEntity = orderService.findById(orderId);
            if (orderEntity.isPresent()){
                model.setId(orderId);
                // Trả về đối tượng sau khi đã edit
                return new ResponseEntity<>(orderService.save(model), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/orders")
    public ResponseEntity<HttpStatus> deleteProduct(@RequestBody Long[] ids) {
        try {
            orderService.delete(ids);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
