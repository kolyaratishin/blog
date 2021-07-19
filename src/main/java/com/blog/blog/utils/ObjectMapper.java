package com.blog.blog.utils;

import com.blog.blog.model.Post;

public class ObjectMapper {

    public static void mapPost(Post sourcePost, Post targetPost){
        targetPost.setAnons(sourcePost.getAnons());
        targetPost.setTitle(sourcePost.getTitle());
        targetPost.setFull_text(sourcePost.getFull_text());
    }
}
