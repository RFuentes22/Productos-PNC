package com.uca.capas.productos.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.uca.capas.productos.domain.Producto;


@Controller
public class ProductConctroller {
	
	
	@RequestMapping("/producto")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("producto", new Producto());
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/validar")
	public ModelAndView procesar(@Valid @ModelAttribute Producto product, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) { //Hay errores, redirigimos a la pantalla del formulario
			mav.setViewName("index");
		}
		else { //Si no hay, flujo normal
			mav.addObject("Saved_product", product.getNombreProducto());
			mav.setViewName("resultado");
		}
		return mav;
	}
}
