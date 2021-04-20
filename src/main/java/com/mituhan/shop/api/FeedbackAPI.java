package com.mituhan.shop.api;

import com.mituhan.shop.dto.FeedbackDTO;
import com.mituhan.shop.dto.ProductDTO;
import com.mituhan.shop.entity.FeedbackEntity;
import com.mituhan.shop.entity.ProductEntity;
import com.mituhan.shop.service.IFeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class FeedbackAPI {

    public static final Logger logger = LoggerFactory.getLogger(FeedbackAPI.class);

    @Autowired
    private IFeedbackService feedbackService;

    @PostMapping(value = "/products")
    public ResponseEntity<FeedbackDTO> createProduct(@RequestBody FeedbackDTO model) {
        logger.info("Creating Feedback : {}", model);
        try {
            FeedbackDTO feedbackDTO = feedbackService.save(model);
            return new ResponseEntity<>(feedbackDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/products/{productId}")
    public ResponseEntity<FeedbackDTO> editProduct(@PathVariable(name = "productId") Long productId,
                                                  @RequestBody FeedbackDTO model) {
        Optional<FeedbackEntity> feedbackEntity = feedbackService.findById(productId);
        if (feedbackEntity.isPresent()){
            model.setId(productId);
            // Trả về đối tượng sau khi đã edit
            return new ResponseEntity<>(feedbackService.save(model), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products")
    public ResponseEntity<HttpStatus> deleteProduct(@RequestBody Long[] ids) {
        try {
            feedbackService.delete(ids);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
