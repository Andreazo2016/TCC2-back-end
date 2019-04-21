package com.ufc.projetoTcc2;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url="https://poly.googleapis.com/v1",name="3DSearcher")
public interface Model3DSearcher {
	
	@RequestMapping( method=RequestMethod.GET, value="/assets?keywords={keywords}&format=OBJ&key={key}")
	String get3DModels(@PathVariable("keywords") String keyword, @PathVariable("key") String key );

}
