package pe.progra.tb.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.progra.tb.entity.ResenaPelicula;
import pe.progra.tb.service.IResenaPeliculaService;

@Named
@RequestScoped
public class ResenaPeliculaController implements Serializable{
    @Inject
    private IResenaPeliculaService rpService;  
    
    private ResenaPelicula resenapelicula;
    List<ResenaPelicula> listaResenaPelicula;
    
    @PostConstruct
    public void init() {
    	
    }
   
}
