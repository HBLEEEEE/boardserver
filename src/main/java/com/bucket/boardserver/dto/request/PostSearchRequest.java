package com.bucket.boardserver.dto.request;

import com.bucket.boardserver.dto.CategoryDto;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostSearchRequest {
    private int id;
    private String name;
    private String contents;
    private int views;
    private int categoryId;
    private int userId;
    private CategoryDto.SortStatus sortStatus;
}
