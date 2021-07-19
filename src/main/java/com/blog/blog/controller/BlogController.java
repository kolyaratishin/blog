package com.blog.blog.controller;

import com.blog.blog.model.Post;
import com.blog.blog.service.PostService;
import com.blog.blog.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
public class BlogController {
    @Autowired
    private PostService postService;

    @GetMapping("/blog")
    public String blogMain(Model model){
        List<Post> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }
    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogSave(Post post, Model model){
        postService.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model,Principal principal){
        Post post = postService.getById(id);
        model.addAttribute("post", post);
        model.addAttribute("principal", principal);
        return "blog-details";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model){
        Post post = postService.getById(id);
        model.addAttribute("post", post);
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogUpdate(@RequestBody Post post, @PathVariable(value = "id")long id,Model model){
        Post sourcePost = postService.getById(id);
        ObjectMapper.mapPost(sourcePost,post);
        postService.save(post);
        return "redirect:/blog";
    }

    @PostMapping("/blog/{id}/remove")
    public String blogRemove(@PathVariable(value = "id")long id,Model model){
        postService.delete(id);
        return "redirect:/blog";
    }

}
