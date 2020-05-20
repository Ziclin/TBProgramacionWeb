package pe.progra.tb.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.progra.tb.entity.Actor;
import pe.progra.tb.service.IActorService;

@Named
@RequestScoped
public class ActorController implements Serializable{
    @Inject
    private IActorService aService;  
    
    private Actor actor;
    List<Actor> listaActores;
    
    @PostConstruct
    public void init() {
    	
    }
   
}
