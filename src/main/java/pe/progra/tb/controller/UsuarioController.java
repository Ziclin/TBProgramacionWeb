package pe.progra.tb.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.progra.tb.entity.Usuario;
import pe.progra.tb.service.IUsuarioService;

@Named
@RequestScoped
public class UsuarioController implements Serializable{
    @Inject
    private IUsuarioService uService;  
    
    private Usuario usuario;
    List<Usuario> listaUsuario;
    
    @PostConstruct
    public void init() {
    	
    }
   
}
