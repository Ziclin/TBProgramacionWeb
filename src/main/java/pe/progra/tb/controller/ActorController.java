package pe.upc.tf.controller;

import java.io.File;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.upc.tf.entities.Actor;
import pe.upc.tf.entities.Pelicula;
import pe.upc.tf.service.ActorService;

@Controller
@RequestMapping("/actores")
public class ActorController {

	@Autowired
	private ActorService aService;
	

	@GetMapping("/actoresList")
	public String lista(Model model) {
		try {
			model.addAttribute("actor", new Actor());
			model.addAttribute("listActores", aService.ListarActores());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "actor/listActores";
	}
	
	@RequestMapping("/add-actor")
	public String nuevoActor(Model model) {
		model.addAttribute("actor", new Actor());
		model.addAttribute("listActores", aService.ListarActores());
		return "actor/actor";
	}
	
	@PostMapping("/actor")
	public String savePelicula(@Valid Actor actor, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			return "actor/actor";
		} else {
			int rpta = aService.RegistrarActor(actor);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return "actor/actor";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("listActores", aService.ListarActores());

		return "actor/listActores";
	}
	
	@RequestMapping("/delete")
	public String deleteActor(Map<String, Object> model, @RequestParam(value = "idActor") Integer idActor) {
		try {
			if (idActor != null && idActor > 0) {
				aService.EliminarActor(idActor);
				model.put("mensaje", "Se eliminó correctamente");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "No se puede eliminar el actor");
		}
		model.put("listActores", aService.ListarActores());

		return "actor/listActores";
	}
	
	 @GetMapping("/edit-{idActor}")
	    public String showUpdateForm(@PathVariable("idActor") Integer idActor, Model model) {
	        Actor actor = aService.buscar(idActor);
	        model.addAttribute("actor", actor);
	        model.addAttribute("listActores", aService.ListarActores());
	        return "actor/update-actor";
	    }
	   
	   
	    
	    @PostMapping("/update-{idActor}")
	    public String updateActor(@PathVariable("idActor") Integer idActor, @Valid Actor actor, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	        	actor.setIdActor(idActor);
	            return "update-actor"; 
	        }
	        
	        aService.ActualizarActor(actor);
	        model.addAttribute("listActores", aService.ListarActores());
	        return "actor/listActores";
	    }
	
}
