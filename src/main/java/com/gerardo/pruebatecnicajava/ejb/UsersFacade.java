/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerardo.pruebatecnicajava.ejb;

import com.gerardo.pruebatecnicajava.entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author gerardo.calderon
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> implements UsersFacadeLocal {

    @PersistenceContext(unitName = "com.gerardo_PruebaTecnicaJava_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }

    @Override
    public Users doLogin(Users user) {
        Users foundUser = null;
        try {
            String queryStr = "FROM Users u WHERE u.username=?1 and u.password=?2 ";
            Query query = em.createQuery(queryStr);
            query.setParameter(1, user.getUsername());
            query.setParameter(2, user.getPassword());

            List<Users> list = query.getResultList();
            if (!list.isEmpty() && list.size() == 1) {
                foundUser = list.get(0);
            }

        } catch (Exception e) {
            throw e;
        }
        return foundUser;
    }
    
    
    
}
