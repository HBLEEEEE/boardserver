package com.bucket.boardserver.controller;

import com.bucket.boardserver.aop.LoginCheck;
import com.bucket.boardserver.dto.CategoryDto;
import com.bucket.boardserver.service.impl.CategoryServiceImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@Log4j2
public class CategoryController {

    private CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @LoginCheck(type = LoginCheck.UserType.ADMIN)
    public void registerCategory(String accountId, @RequestBody CategoryDto categoryDTO){
        categoryService.register(accountId, categoryDTO);
    }

    @PatchMapping("{categoryId}")
    @LoginCheck(type = LoginCheck.UserType.ADMIN)
    public void updateCategories(String accountId,
                               @PathVariable(name = "categoryId") int categoryId,
                               @RequestBody CategoryRequest categoryRequest){
        CategoryDto categoryDTO = new CategoryDto(categoryId, categoryRequest.getName(), CategoryDto.SortStatus.NEWEST, 10, 1);
        categoryService.update(categoryDTO);
    }

    @DeleteMapping("{categoryId}")
    @LoginCheck(type = LoginCheck.UserType.ADMIN)
    public void deleteCategories(String accountId,
                                 @PathVariable(name = "categoryId") int categoryId){
        categoryService.delete(categoryId);
    }

    @Getter
    @Setter
    private static class CategoryRequest{
        private int id;
        private String name;
    }



}
