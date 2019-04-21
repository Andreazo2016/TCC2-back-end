package com.ufc.projetoTcc2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wrapper.spotify.model_objects.specification.Track;

@RestController
@RequestMapping("/api")
public class MusicController {
	
	@Autowired
	private MusicService musicService;
	
	@GetMapping("/music?{name}")
	public ResponseEntity<Track []> getMusicByType(@PathVariable("name") String name){
		return new ResponseEntity<Track []>( musicService.getMusic( name ), HttpStatus.OK );
	}
	@GetMapping("/music/{id}")
	public ResponseEntity<Track>  getMusicById( @PathVariable("id") String id){
		return new ResponseEntity<Track>(musicService.getMusicById(id), HttpStatus.OK );
	}
	

}
