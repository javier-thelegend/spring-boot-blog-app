package com.springboot.blog.repository;

import com.springboot.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

//No necessary @Repository annotation because JpaRepository already has it
//Post is the Entity and Long the Primary Key Type
public interface PostRepository extends JpaRepository<Post, Long> {
    //Only custom code is required here
    //Generic code is provided by JpaRepository
}
