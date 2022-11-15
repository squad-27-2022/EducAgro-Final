package br.org.recode.educagro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControle {

	@GetMapping("/login")
	public String login() {
		return "usuario/login";
	}
}
