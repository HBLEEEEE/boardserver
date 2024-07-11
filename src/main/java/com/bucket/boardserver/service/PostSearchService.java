package com.bucket.boardserver.service;


import com.bucket.boardserver.dto.PostDTO;
import com.bucket.boardserver.dto.request.PostSearchRequest;

import java.util.List;

public interface PostSearchService {
    List<PostDTO> getPosts(PostSearchRequest postSearchRequest);
}
