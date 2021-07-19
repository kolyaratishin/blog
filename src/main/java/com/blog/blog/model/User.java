package com.blog.blog.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private Set<Post> posts;

    public User() {
    }

    public void addPost(Post post){
        posts.add(post);
        post.setAuthor(this);
    }

    public void removePost(Post post){
        posts.remove(post);
        post.setAuthor(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
