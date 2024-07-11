package com.bucket.boardserver.service;

import com.bucket.boardserver.dto.CategoryDto;

public interface CategoryService {

    void register(String accountId, CategoryDto categoryDTO);
    void update(CategoryDto categoryDTO);
    void delete(int categoryId);
}
