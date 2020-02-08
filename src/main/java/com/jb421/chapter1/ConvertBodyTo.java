package com.jb421.chapter1;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ConvertBodyTo extends SpringRouteBuilder{

	@Override
	public void configure() throws Exception {

		//TODO: MARSHAL XML JSON JSON XML!
		from("file:entradaXml?noop=true")
        .to("log:?level=INFO&showBody=true");
		
	}

}
