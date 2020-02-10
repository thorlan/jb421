package com.jb421.chapter2;

import org.apache.camel.LoggingLevel;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class GuidedUm extends SpringRouteBuilder{

	@Override
	public void configure() throws Exception {
		from("file:guided/chapt2/part1/entrada?include=pessoa.*xml").routeId("ROTA DE TESTE")
		.log(LoggingLevel.INFO, "New file ${header.CamelFileName} picked up")
		.log(LoggingLevel.INFO,"Got a message\n ${body}")
		.to("file:guided/chapt2/part1/saida?fileExist=Append");
	}

}
