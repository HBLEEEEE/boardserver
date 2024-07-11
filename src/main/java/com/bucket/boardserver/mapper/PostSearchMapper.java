package com.bucket.boardserver.mapper;

import com.bucket.boardserver.dto.PostDTO;
import com.bucket.boardserver.dto.request.PostSearchRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostSearchMapper {
    public List<PostDTO> selectPosts(PostSearchRequest postSearchRequest);
}
