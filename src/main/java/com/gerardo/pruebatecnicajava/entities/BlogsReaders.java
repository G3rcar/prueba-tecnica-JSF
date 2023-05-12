/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerardo.pruebatecnicajava.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gerardo.calderon
 */
@Entity
@Table(name = "blogs_readers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BlogsReaders.findAll", query = "SELECT b FROM BlogsReaders b")
    , @NamedQuery(name = "BlogsReaders.findById", query = "SELECT b FROM BlogsReaders b WHERE b.id = :id")})
public class BlogsReaders implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false, name = "id")
    private Integer id;
    @JoinColumn(name = "b_id", referencedColumnName = "id")
    @ManyToOne
    private Blogs bId;
    @JoinColumn(name = "r_id", referencedColumnName = "id")
    @ManyToOne
    private Readers rId;

    public BlogsReaders() {
    }

    public BlogsReaders(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Blogs getBId() {
        return bId;
    }

    public void setBId(Blogs bId) {
        this.bId = bId;
    }

    public Readers getRId() {
        return rId;
    }

    public void setRId(Readers rId) {
        this.rId = rId;
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
        if (!(object instanceof BlogsReaders)) {
            return false;
        }
        BlogsReaders other = (BlogsReaders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gerardo.pruebatecnicajava.entities.BlogsReaders[ id=" + id + " ]";
    }
    
}
