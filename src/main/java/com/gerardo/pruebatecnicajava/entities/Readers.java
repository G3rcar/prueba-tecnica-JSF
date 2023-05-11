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
@Table(name = "readers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Readers.findAll", query = "SELECT r FROM Readers r")
    , @NamedQuery(name = "Readers.findById", query = "SELECT r FROM Readers r WHERE r.id = :id")
    , @NamedQuery(name = "Readers.findByName", query = "SELECT r FROM Readers r WHERE r.name = :name")})
public class Readers implements Serializable {

    @OneToMany(mappedBy = "rId")
    private List<BlogsReaders> blogsReadersList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 8)
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "readersList")
    private List<Blogs> blogsList;

    public Readers() {
    }

    public Readers(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Blogs> getBlogsList() {
        return blogsList;
    }

    public void setBlogsList(List<Blogs> blogsList) {
        this.blogsList = blogsList;
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
        if (!(object instanceof Readers)) {
            return false;
        }
        Readers other = (Readers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gerardo.pruebatecnicajava.entities.Readers[ id=" + id + " ]";
    }

    @XmlTransient
    public List<BlogsReaders> getBlogsReadersList() {
        return blogsReadersList;
    }

    public void setBlogsReadersList(List<BlogsReaders> blogsReadersList) {
        this.blogsReadersList = blogsReadersList;
    }
    
}
