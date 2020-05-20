package pe.progra.tb.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.progra.tb.entity.Serie;
import pe.progra.tb.service.ISerieService;

@Named
@RequestScoped
public class SerieController implements Serializable{
    @Inject
    private ISerieService sService;  
    
    private Serie serie;
    List<Serie> listaSerie;
    
    @PostConstruct
    public void init() {
    	
    }
   
}
