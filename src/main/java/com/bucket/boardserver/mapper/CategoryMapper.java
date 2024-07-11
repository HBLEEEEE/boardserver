package com.bucket.boardserver.mapper;

import com.bucket.boardserver.dto.CategoryDto;

public interface CategoryMapper {
    public int register(CategoryDto categoryDTO);
    public void updateCategory(CategoryDto categoryDTO);
    public void deleteCategory(int categoryId);
}
