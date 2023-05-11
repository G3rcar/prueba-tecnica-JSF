/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerardo.pruebatecnicajava.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gerardo.calderon
 */
@Entity
@Table(name = "blogs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Blogs.findAll", query = "SELECT b FROM Blogs b")
    , @NamedQuery(name = "Blogs.findById", query = "SELECT b FROM Blogs b WHERE b.id = :id")
    , @NamedQuery(name = "Blogs.findByTitle", query = "SELECT b FROM Blogs b WHERE b.title = :title")
    , @NamedQuery(name = "Blogs.findByDescription", query = "SELECT b FROM Blogs b WHERE b.description = :description")})
public class Blogs implements Serializable {

    @OneToMany(mappedBy = "bId")
    private List<BlogsReaders> blogsReadersList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "title")
    private String title;
    @Size(max = 4000)
    @Column(name = "description")
    private String description;
    @JoinTable(name = "blogs_readers", joinColumns = {
        @JoinColumn(name = "b_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "r_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Readers> readersList;

    public Blogs() {
    }

    public Blogs(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Readers> getReadersList() {
        return readersList;
    }

    public void setReadersList(List<Readers> readersList) {
        this.readersList = readersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Blogs)) {
            return false;
        }
        Blogs other = (Blogs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gerardo.pruebatecnicajava.entities.Blogs[ id=" + id + " ]";
    }

    @XmlTransient
    public List<BlogsReaders> getBlogsReadersList() {
        return blogsReadersList;
    }

    public void setBlogsReadersList(List<BlogsReaders> blogsReadersList) {
        this.blogsReadersList = blogsReadersList;
    }
    
}
