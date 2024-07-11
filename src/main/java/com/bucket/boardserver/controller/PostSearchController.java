package com.bucket.boardserver.controller;

import com.bucket.boardserver.dto.PostDTO;
import com.bucket.boardserver.dto.request.PostSearchRequest;
import com.bucket.boardserver.service.impl.PostSearchServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@Log4j2
@RequiredArgsConstructor
public class PostSearchController {

    private final PostSearchServiceImpl postSearchService;

    @PostMapping
    public PostSearchReponse search(@RequestBody PostSearchRequest postSearchRequest){
        List<PostDTO> postDTOList = postSearchService.getPosts(postSearchRequest);
        return new PostSearchReponse(postDTOList);
    }

    // -- response 객체 --

    @Getter
    @AllArgsConstructor
    private static class PostSearchReponse {
        private List<PostDTO> postDTOList;

    }
}
