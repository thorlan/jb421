package com.jb421.chapter1;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ConvertBodyTo extends SpringRouteBuilder{

	@Override
	public void configure() throws Exception {

		
		from("file:entradaXml?noop=true")
		 	.marshal().jacksonxml()
        .to("log:?level=INFO&showBody=true");
		
	}

}
