package com.springboot.blog.service;

import com.springboot.blog.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> findCommentsByPostId(long postId);

    CommentDto findCommentById(long postId, long commentId);

    CommentDto updateCommment(long postId, long commentId, CommentDto commentDto);

    void deleteComment(long postId, long commentId);
}
