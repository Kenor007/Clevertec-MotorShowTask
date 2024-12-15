package ru.clevertec.motor_show.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.motor_show.dto.CategoryRequestDto;
import ru.clevertec.motor_show.dto.CategoryResponseDto;
import ru.clevertec.motor_show.error_handling.exception.CategoryNotFoundException;
import ru.clevertec.motor_show.service.CategoryService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/showrooms")
@RequiredArgsConstructor
@Validated
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public CategoryResponseDto createCategory(@Validated @RequestBody CategoryRequestDto categoryRequestDto) {
        return categoryService.createCategory(categoryRequestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        try {
            categoryService.deleteCategory(id);
            return ResponseEntity.ok("Category successfully deleted with id: " + id);
        } catch (CategoryNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found with id: " + id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateCategory(@PathVariable Long id,
                                                              @Validated @RequestBody CategoryRequestDto categoryRequestDto) {
        CategoryResponseDto categoryResponseDto = categoryService.updateCategory(categoryRequestDto, id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Category successfully updated.");
        response.put("updatedCategory", categoryResponseDto);
        return ResponseEntity.ok(response);
    }

}
