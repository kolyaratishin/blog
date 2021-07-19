package com.blog.blog.service.impl;

import com.blog.blog.dao.PostRepository;
import com.blog.blog.model.Post;
import com.blog.blog.model.User;
import com.blog.blog.service.AuthenticationService;
import com.blog.blog.service.PostService;
import com.blog.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public Post getById(Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Couldn't find a post with id=" + id));
    }

    @Override
    public void save(Post post) {
        User user = authenticationService.getPrincipal();
        user.addPost(post);
        postRepository.save(post);
    }

    @Override
    public void delete(Long id) {
        Post post = getById(id);
        User user = authenticationService.getPrincipal();
        user.removePost(post);
        postRepository.delete(post);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }
}
