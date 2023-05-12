/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gerardo.pruebatecnicajava.controllers;

import com.gerardo.pruebatecnicajava.ejb.UsersFacadeLocal;
import com.gerardo.pruebatecnicajava.entities.Users;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author gerardo.calderon
 */
@Named
@ViewScoped
public class LoginController implements Serializable {
    
    private static final String USER_LOGGED = "user-logged";
    
    private String errorMessage = "";
    
    @EJB
    private UsersFacadeLocal usersFL;
    private Users user;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    
    
    
    
    
    
    @PostConstruct
    public void init() {
        user = new Users();
    }
    
    public void doLogin() {

        Users foundUser;
        try {
            foundUser = usersFL.doLogin(user);
            if (foundUser != null) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().getSessionMap().put(USER_LOGGED, foundUser);
                context.getExternalContext().redirect("blogs.xhtml?faces-redirect=true");
            } else {
                this.errorMessage = "Credenciales incorrectas";
            }

        } catch (Exception e) {
            this.errorMessage = "Credenciales incorrectas";
        }
    }
    
    
    
    
    
    public void checkIfLoggedIn() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Users userInSession = (Users) context.getExternalContext().getSessionMap().get(USER_LOGGED);

            if (userInSession == null) {
                context.getExternalContext().redirect("login.xhtml?faces-redirect=true");
            }
        } catch (Exception e) { }
    }
    
    public String getUsername() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Users userInSession = (Users) context.getExternalContext().getSessionMap().get(USER_LOGGED);

            return userInSession.getUsername();
        } catch (Exception e) { }
        return "";
    }
    
    public void logout(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        try {
            context.getExternalContext().redirect("login.xhtml?faces-redirect=true");
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
