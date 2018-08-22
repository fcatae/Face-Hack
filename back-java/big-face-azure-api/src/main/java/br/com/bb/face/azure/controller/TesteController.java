package br.com.bb.face.azure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

	@GetMapping
    public String teste(){
		return "Api's para o banco do Brasil, utilizando as api's do Azure.";
	}
	
}