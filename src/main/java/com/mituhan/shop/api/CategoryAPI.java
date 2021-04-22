package com.mituhan.shop.api;

import com.mituhan.shop.dto.CategoryDTO;
import com.mituhan.shop.entity.CategoryEntity;
import com.mituhan.shop.service.ICategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CategoryAPI {

    public static final Logger logger = LoggerFactory.getLogger(CategoryAPI.class);

    @Autowired
    private ICategoryService categoryService;

    @PostMapping(value = "/categories")
    public ResponseEntity<CategoryDTO> createProduct(@RequestBody CategoryDTO model) {
        logger.info("Creating Category : {}", model);
        try {
            CategoryDTO categoryDTO = categoryService.save(model);
            return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> editProduct(@PathVariable(name = "categoryId") Long categoryId,
                                                  @RequestBody CategoryDTO model) {
        try {
            Optional<CategoryEntity> categoryEntity = categoryService.findById(categoryId);
            if (categoryEntity.isPresent()){
                model.setId(categoryId);
                // Trả về đối tượng sau khi đã edit
                return new ResponseEntity<>(categoryService.save(model), HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/categories")
    public ResponseEntity<HttpStatus> deleteProduct(@RequestBody Long[] ids) {
        try {
            categoryService.delete(ids);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
