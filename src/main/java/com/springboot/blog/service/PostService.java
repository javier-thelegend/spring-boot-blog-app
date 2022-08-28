package com.springboot.blog.service;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.payload.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse findAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto findPostById(Long id);

    PostDto udpatePost(PostDto postDto, Long id);

    void deletePostById(Long id);
}
