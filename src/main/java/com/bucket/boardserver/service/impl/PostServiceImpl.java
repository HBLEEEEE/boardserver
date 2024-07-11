package com.bucket.boardserver.service.impl;

import com.bucket.boardserver.dto.PostDTO;
import com.bucket.boardserver.dto.UserDTO;
import com.bucket.boardserver.mapper.PostMapper;
import com.bucket.boardserver.mapper.UserProfileMapper;
import com.bucket.boardserver.service.PostService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Log4j2
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private UserProfileMapper userProfileMapper;

    @Override
    public void register(String id, PostDTO postDTO) {
        UserDTO memberInfo = userProfileMapper.getUserProfile(id);
        postDTO.setUserId(memberInfo.getId());
        postDTO.setCreateTime(new Date());

        if(memberInfo != null) {
            postMapper.register(postDTO);
        }else{
            log.error("registerPost ERROR! {}", postDTO);
            throw new RuntimeException("register ERROR! 게시글 등록 메서드를 확인해주세요" + postDTO);
        }

    }

    @Override
    public List<PostDTO> getMyPosts(int accountId) {
        List<PostDTO> postDtoList = postMapper.selectMyPosts(accountId);
        return postDtoList;
    }

    @Override
    public void updatePosts(PostDTO postDTO) {
        if(postDTO!= null && postDTO.getId() != 0){
            postMapper.updatePosts(postDTO);
        }else{
            log.error("updatePost ERROR! {}", postDTO);
            throw new RuntimeException("register ERROR! 게시글 수정 메서드를 확인해주세요" + postDTO);
        }
    }

    @Override
    public void deletePosts(int userId, int postId) {
        if(userId != 0 && postId != 0){
            postMapper.deletePosts(postId);
        }else{
            log.error("deletePost ERROR! {}", postId);
            throw new RuntimeException("register ERROR! 게시글 삭제 메서드를 확인해주세요" + postId);
        }
    }
}
