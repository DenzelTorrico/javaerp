package com.sistema.erp.controller;

import java.io.IOException;
import java.io.OutputStream;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.erp.entidad.Producto;
import com.sistema.erp.repository.ProductoRepository;
import com.sistema.erp.service.ProductoService;

@Controller
public class ProductoController {
	
	  private final ProductoService productoservice;
	  
	  public ProductoController(ProductoService ProductoService) {
		  this.productoservice = ProductoService;
	  }

	
	@GetMapping("/producto")
	public String index(Model modelo) {
		modelo.addAttribute("producto", productoservice.Load());
		return "producto/index";
	}
	@PostMapping("/producto")
	public String add(@ModelAttribute Producto producto) {
		productoservice.Guardar(producto);
		return "redirect:/producto";
	}
	  /*@GetMapping("/producto/pdf")
	  public void generatePdf(Model model, OutputStream outputStream) throws IOException {
	        // Datos que se pasarán a la plantilla Thymeleaf
	        model.addAttribute("title", "PDF Title");
	        model.addAttribute("content", "PDF Content");

	        // Procesa la plantilla Thymeleaf a HTML
	        String htmlContent = ThymeleafUtil.processTemplate("pdf-template", model);

	        // Convierte el HTML a PDF con Flying Saucer
	        PdfGenerator.generatePdf(htmlContent, outputStream);
	    }*/
}
