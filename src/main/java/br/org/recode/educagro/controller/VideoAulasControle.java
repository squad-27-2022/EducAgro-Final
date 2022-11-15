package br.org.recode.educagro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VideoAulasControle {
	
	@GetMapping("/video-aulas")
	public String videoAulas() {
		return "video-aulas";
	}

}
