package com.blog.blog.service;

import com.blog.blog.model.Post;

import java.util.List;

public interface PostService {
    Post getById(Long id);
    void save(Post post);
    void delete(Long id);
    List<Post> getAll();
}
