package com.ufc.projetoTcc2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ModelSearchService {
	
	private static String token = "AIzaSyBEqxqylCl-ppAEm0OVTLtNZ--1pwdcmYc";
	
	@Autowired
	private Model3DSearcher modelSearch;
	
	@GetMapping("/model/{name}")
	public ResponseEntity<String> getModel( @PathVariable("name") String name ){
		return new ResponseEntity<String>(modelSearch.get3DModels( name , token ), HttpStatus.OK );
	}
}
