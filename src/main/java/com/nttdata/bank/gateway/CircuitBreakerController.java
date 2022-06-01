package com.nttdata.bank.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {
	
	@GetMapping("/fallback")
	public String defaultMethod() {
		return "El sistema no se encuentra disponible, reintentelo en unos momentos";
	}

}
