package pe.progra.tb.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.progra.tb.entity.ResenaSerie;
import pe.progra.tb.service.IResenaSerieService;

@Named
@RequestScoped
public class ResenaSerieController implements Serializable{
    @Inject
    private IResenaSerieService rsService;  
    
    private ResenaSerie resenaserie;
    List<ResenaSerie> listaResenaSerie;
    
    @PostConstruct
    public void init() {
    	
    }
   
}
