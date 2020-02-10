package com.jb421.chapter2;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class GuidedDois extends SpringRouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:guided/chapt2/part3/entrada?include=order.*xml")
			.filter(xpath("/order/orderId/text() > 99"))
			.to("file:guided/chapt2/part3/saida")
		.log("${body}");
	}

}
