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
public class ImageController {

	@Autowired
	private ImageSearcher imageSearcher;
	
	@Autowired
	private Model3DSearcher modelSearch;
	
	@GetMapping("/image/{q}")
	public ResponseEntity<SearchResults> searchImage( @PathVariable("q") String q) {
		return new ResponseEntity<SearchResults>(imageSearcher.getPhotos("Client-ID "+Constants.UNSLASH_ACESS_KEY, q ), HttpStatus.OK );
	}
	
	@GetMapping("/models/{keyword}")
	public ResponseEntity<String> searchModels(@PathVariable("keyword") String keyword){
		return new ResponseEntity<String>(modelSearch.get3DModels(keyword, "AIzaSyBEqxqylCl-ppAEm0OVTLtNZ--1pwdcmYc"), HttpStatus.OK);
	}
}
