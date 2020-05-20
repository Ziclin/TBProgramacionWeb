package pe.progra.tb.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.progra.tb.entity.Pelicula;
import pe.progra.tb.service.IPeliculaService;

@Named
@RequestScoped
public class PeliculaController implements Serializable{
    @Inject
    private IPeliculaService pService;  
    
    private Pelicula pelicula;
    List<Pelicula> listaPelicula;
    
    @PostConstruct
    public void init() {
    	
    }
   
}
