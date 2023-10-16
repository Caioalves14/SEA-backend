package com.example.sea.dtos;

import jakarta.validation.constraints.NotBlank;

public record UsersRecordDto(@NotBlank String nome, @NotBlank String email, @NotBlank String senha,@NotBlank String cpf, @NotBlank String dataNascimento) {

}


