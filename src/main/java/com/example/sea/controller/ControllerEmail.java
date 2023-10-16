package com.example.sea.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sea.dtos.EmailDto;
import com.example.sea.dtos.RecuperaraSenhaDto;
import com.example.sea.model.ModelUsers;
import com.example.sea.repository.RepostoryUsers;
import com.example.sea.service.EmailService;

@RestController
public class ControllerEmail {
	@Autowired
	RepostoryUsers repostoryUsers; 
	@Autowired
	private  EmailService emailService;
	
	@PostMapping(value = "/enviaremial")
	public ResponseEntity<Object> confirmmarEmail(@RequestBody EmailDto emailDto){
		try {
			emailService.sendEmail(emailDto);
			return ResponseEntity.status(HttpStatus.OK).body("deu bom");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("deu ruim");
		}
	} 
	
	@PostMapping(value = "/recuperarSenha")
	public ResponseEntity<?> recuperarSenhaEmail(@RequestBody RecuperaraSenhaDto recuperarSenha){
		ModelUsers user = repostoryUsers.findByEmail(recuperarSenha.getTo());
		if(user == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email Nao encontrado");
		} 
		emailService.recuperarSenha(recuperarSenha);
		return ResponseEntity.status(HttpStatus.OK).body("Email enviado");
	}
}
