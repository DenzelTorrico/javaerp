package com.sistema.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.apache.commons.io.IOUtils;

import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.resource.Resource;

import java.io.ByteArrayOutputStream;
import com.sistema.erp.entidad.Cliente;
import com.sistema.erp.service.ClienteService;
import com.sistema.erp.service.ExportPdfService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ClienteController {

	@Autowired
	ClienteService servicio;

	@Autowired
	private ExportPdfService exportPdfService;

	@GetMapping("/cliente")
	public String index(Model modelo) {

		var cliente = servicio.Listar();

		modelo.addAttribute("cliente", cliente);
		return "/cliente/index";
	}

	@GetMapping("/cliente/{id}")
	public String getUpdate(Model modelo, @PathVariable long id) {
		var cliente = servicio.ListId(id);
		if (cliente.isPresent()) {
			modelo.addAttribute("cliente", cliente.get());
			return "cliente/clienteedit";
		} else {
			modelo.addAttribute("error", "El cliente con ID " + id + " no existe");
			return "cliente/error";
		}

	}

	@PostMapping("/cliente")
	public String setUpdate(@ModelAttribute Cliente cliente) {
		servicio.Edit(cliente);
		return "redirect:/cliente";
		// return "ID:"+cliente.id;
	}

	@GetMapping("/cliente/delete/{id}")
	public String setDelete(@PathVariable long id) {

		servicio.eliminarCliente(id);
		return "redirect:/cliente";
	}

	@PostMapping("/cliente/add")
	public String add(@ModelAttribute Cliente cliente) {
		servicio.AgregarCliente(cliente);
		return "redirect:/cliente";
	}

	@GetMapping("/cliente/pdf")
	public void downloadReceipt(HttpServletResponse response) {
	    try {
	        // Configurar la respuesta para un archivo PDF
	        response.setContentType("application/pdf");
	        response.setHeader("Content-Disposition", "attachment; filename=generated.pdf");

	        // Lógica para cargar el contenido de la plantilla HTML desde un archivo
	        ClassPathResource templateResource = new ClassPathResource("templates/cliente/pdf.html");
	        String htmlContent = new String(Files.readAllBytes(templateResource.getFile().toPath()), StandardCharsets.UTF_8);

	        // Lógica para generar el contenido del PDF aquí
	        ITextRenderer renderer = new ITextRenderer();
	        renderer.setDocumentFromString(htmlContent);

	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        renderer.layout();
	        renderer.createPDF(outputStream);

	        // Escribir el contenido del PDF en el flujo de salida de la respuesta
	        response.getOutputStream().write(outputStream.toByteArray());
	    } catch (Exception e) {
	        // Manejar errores aquí
	        e.printStackTrace();
	    }
	}
}
