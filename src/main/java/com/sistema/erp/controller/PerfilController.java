package com.sistema.erp.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.sistema.erp.entidad.User;
import com.sistema.erp.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PerfilController {
	
		final UserRepository repos;
		
		public PerfilController(UserRepository repos) {
			this.repos = repos;
		}
			
		 @Value("${imagen.ruta}")
		  private String rutaImagen;
		
		@GetMapping("/perfil")
		public String index(Model modelo) {

			return "usuario/index";
		}
		@PostMapping("/perfil")
		public String save(HttpServletRequest request,@RequestParam("imagen") MultipartFile imagen) {
			   try {
		            // Guarda la imagen en el directorio
		            byte[] bytes = imagen.getBytes();
		            Path ruta = Paths.get(rutaImagen, imagen.getOriginalFilename());
		            Files.write(ruta, bytes);
		            User user = new User();
		            user.setEmail(request.getParameter("email"));
		            //Actualiza la ruta de la imagen en el usuario
		            user.setImagen(imagen.getOriginalFilename());
		            
		            // Guarda el usuario en la base de datos
		            repos.save(user);
		            //return "ID:"+rutaImagen	
		            return "redirect:perfil/" + user.getId();
		        } catch (IOException e) {
		            // Manejar el error
		            return "error";
		        }
		}
		
		@GetMapping("/perfil/{id}")
		public String perfil(@PathVariable Long id, Model model) {
		    User user = repos.findById(id).get();
		    model.addAttribute("user", user);
		    return "usuario/perfil";
		}

}
