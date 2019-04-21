package com.ufc.projetoTcc2;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url="https://api.unsplash.com",name="imageSearcher")
public interface ImageSearcher {
	
	@RequestMapping( method=RequestMethod.GET, value="/search/photos?query={photoQuery}" )
	SearchResults getPhotos(@RequestHeader( "Authorization" ) String authToken, @PathVariable("photoQuery") String photoQuery );

	@RequestMapping(method=RequestMethod.GET, value="/photos/{id}")
	Photo getPhoto( @RequestHeader( "Authorization" ) String authToken,  @PathVariable("id") Integer id );
}
