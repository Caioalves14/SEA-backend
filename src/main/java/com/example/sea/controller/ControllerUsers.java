package com.example.sea.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sea.dtos.UsersRecordDto;
import com.example.sea.model.ModelUsers;
import com.example.sea.repository.RepostoryUsers;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;

@RestController
public class ControllerUsers {
	@Autowired
	RepostoryUsers repostoryUsers; 
	
	@PostMapping(value = "/user")
	public ResponseEntity<ModelUsers> saveUsers(@RequestBody @Valid UsersRecordDto usersRecordDto){
		var modelUsers = new ModelUsers();
		BeanUtils.copyProperties(usersRecordDto, modelUsers);
		return ResponseEntity.status(HttpStatus.CREATED).body(repostoryUsers.save(modelUsers));
	}
	
	@GetMapping(value = "/listusers")
	public ResponseEntity<List<ModelUsers>> getAllUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(repostoryUsers.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable(value="id") Integer id){
		Optional<ModelUsers> user = repostoryUsers.findById(id);
		System.out.println("Entrou na função");
		if(user.isEmpty()) {
//			System.out.println("entrou no if");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(user.get());
	}
}