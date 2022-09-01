package com.springboot.blog.controller;

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.payload.DeleteResponse;
import com.springboot.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //Create Comment Post API
    @PostMapping("/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId, @Valid @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    //Get All Comments by Post Id
    @GetMapping("/{postId}/comments")
    public List<CommentDto> findCommentsByPostId(@PathVariable(value = "postId") long postId){
        return commentService.findCommentsByPostId(postId);
    }

    //Get Comment by Id and Post Id
    @GetMapping("/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> findCommentById(@PathVariable(value = "postId") long postId, @PathVariable(value = "id") long commentId) {
        return new ResponseEntity<>(commentService.findCommentById(postId, commentId), HttpStatus.OK);
    }

    //Update Comment by Id and Post Id
    @PutMapping("/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> updateCommentById(@PathVariable(value = "postId") long postId, @PathVariable(value = "id") long commentId,
                                                        @Valid @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.updateCommment(postId, commentId, commentDto), HttpStatus.OK);
    }

    //Delete Comment by Id and Post Id
    @DeleteMapping ("/{postId}/comments/{id}")
    public ResponseEntity<DeleteResponse> deletePost(@PathVariable(name = "postId") long postId, @PathVariable(name = "id") long commentId) {
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>(new DeleteResponse("Comment " + commentId + " Deleted Successfully"), HttpStatus.OK);
    }
}
