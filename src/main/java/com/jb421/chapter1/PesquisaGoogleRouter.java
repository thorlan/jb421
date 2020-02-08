package com.jb421.chapter1;

import java.io.InputStream;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.spring.SpringRouteBuilder;

//@Component
public class PesquisaGoogleRouter extends SpringRouteBuilder {

	@Override
	public void configure() throws Exception {

		from("timer:testeGoogle?period=50s").setExchangePattern(ExchangePattern.InOut).streamCaching()
				.setBody(simple("CORPO DO IN"))
				.setHeader(Exchange.HTTP_METHOD, constant(org.apache.camel.component.http4.HttpMethods.GET))
				.to("http4://www.github.com/thorlan").log("${in.headers.CamelHttpResponseCode}").process(new Processor() {

					@Override
					public void process(Exchange exchange) throws Exception {
						// TODO Auto-generated method stub
						exchange.getIn().getHeaders().forEach((k, v) -> System.out.println(k + " | " + v));

						try (final InputStream in = exchange.getIn().getBody(InputStream.class)) {
							
							byte[] buffer = new byte[1024];
							int len = in.read(buffer);
							while (len != -1) {
							    System.out.write(buffer, 0, len);
							    len = in.read(buffer);
							}
						}

					}
				});
	}

	private Processor processorShowBody() {
		return new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("Corpo in");
				System.out.println(exchange.getIn().getBody().toString());

				System.out.println("Corpo Out");

				System.out.println("codigo");
				Message out = exchange.getOut();
				System.out.println(out.getHeader(Exchange.HTTP_RESPONSE_CODE, Integer.class));

			}
		};
	}

}
