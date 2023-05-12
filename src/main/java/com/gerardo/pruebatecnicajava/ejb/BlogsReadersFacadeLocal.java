/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerardo.pruebatecnicajava.ejb;

import com.gerardo.pruebatecnicajava.entities.BlogsReaders;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gerardo.calderon
 */
@Local
public interface BlogsReadersFacadeLocal {

    void create(BlogsReaders blogsReaders);

    void edit(BlogsReaders blogsReaders);

    void remove(BlogsReaders blogsReaders);

    BlogsReaders find(Object id);

    List<BlogsReaders> findAll();

    List<BlogsReaders> findRange(int[] range);

    int count();
    
}
