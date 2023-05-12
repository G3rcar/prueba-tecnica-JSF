/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerardo.pruebatecnicajava.controllers;

import com.gerardo.pruebatecnicajava.ejb.BlogsFacadeLocal;
import com.gerardo.pruebatecnicajava.entities.Blogs;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author gerardo.calderon
 */
@Named
@ViewScoped
public class BlogsController implements Serializable {
    
    @EJB
    private BlogsFacadeLocal blogsFL;
    private List<Blogs> blogsList;
    private Blogs blog;

    
    
    public List<Blogs> getBlogsList() {
        this.blogsList = this.blogsFL.findAll();
        return blogsList;
    }

    public void setBlogsList(List<Blogs> blogsList) {
        this.blogsList = blogsList;
    }

    public Blogs getBlog() {
        return blog;
    }

    public void setBlog(Blogs blog) {
        this.blog = blog;
    }
    
    
    
    
    @PostConstruct
    public void init() {
        clean();
    }
    
    public void edit(Blogs blog) {
        this.blog = blog;
    }
    
    public void save() {
        if(blog.getId() != null){
            blogsFL.edit(blog);
        } else {
            blogsFL.create(blog);
        }
        blog = new Blogs();
    }
    
    public void clean() {
        blog = new Blogs();
    }
    
    public void delete() {
        blogsFL.remove(blog);
        clean();
    }
    
    
}
