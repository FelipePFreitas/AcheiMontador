package com.felipefreitas.rhexpress.infra.controller;

import com.felipefreitas.rhexpress.app.dto.autenticacao.AuthTokenResponseDTO;
import com.felipefreitas.rhexpress.app.dto.autenticacao.LoginRequestDTO;
import com.felipefreitas.rhexpress.app.usecase.AutenticacaoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Autenticação", description = "Endpoints de autenticação e emissão de token JWT")
public class AutenticacaoController {

    private final AutenticacaoUseCase autenticacaoUseCase;


    @PostMapping("/login")
    @Operation(summary = "Realizar login", description = "Autentica o usuário e retorna um token JWT no padrão Bearer.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso",
                    content = @Content(schema = @Schema(implementation = AuthTokenResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados de login inválidos", content = @Content),
            @ApiResponse(responseCode = "401", description = "Credenciais inválidas", content = @Content)
    })
    public ResponseEntity<AuthTokenResponseDTO> login(@RequestBody @Valid LoginRequestDTO request) {
        return ResponseEntity.ok(autenticacaoUseCase.authenticate(request));
    }
}
