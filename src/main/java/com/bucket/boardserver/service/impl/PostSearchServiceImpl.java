package com.bucket.boardserver.service.impl;

import com.bucket.boardserver.dto.PostDTO;
import com.bucket.boardserver.dto.request.PostSearchRequest;
import com.bucket.boardserver.mapper.PostSearchMapper;
import com.bucket.boardserver.service.PostSearchService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class PostSearchServiceImpl implements PostSearchService {

    @Autowired
    private PostSearchMapper postSearchMapper;

    
    @Cacheable(value = "getPosts", key = "'getPosts' + #postSearchRequest.getName() + #postSearchRequest.getCategoryId()" )
    @Override
    public List<PostDTO> getPosts(PostSearchRequest postSearchRequest) {
        List<PostDTO> postDTOList = null;
        try {
            postDTOList = postSearchMapper.selectPosts(postSearchRequest);
            System.out.println(postDTOList.size());
        }catch (RuntimeException e) {
            log.error("selectPosts 메서드 실패", e.getMessage());
        }


        return postDTOList;
    }
}
