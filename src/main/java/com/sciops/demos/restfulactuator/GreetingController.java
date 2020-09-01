package com.sciops.demos.restfulactuator;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {
	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	@ResponseBody
	public Greeting greet(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
