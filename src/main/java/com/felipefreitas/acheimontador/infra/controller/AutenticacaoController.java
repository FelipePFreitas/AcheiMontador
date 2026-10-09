package com.felipefreitas.acheimontador.infra.controller;

import com.felipefreitas.acheimontador.app.command.autenticacao.AutenticarUsuarioCommand;
import com.felipefreitas.acheimontador.infra.controller.dto.request.LoginRequestDTO;
import com.felipefreitas.acheimontador.app.port.input.AutenticarUsuarioInputPort;
import com.felipefreitas.acheimontador.infra.controller.dto.response.AuthTokenResponseDTO;
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

    private final AutenticarUsuarioInputPort autenticacaoUseCase;


    @PostMapping("/login")
    @Operation(summary = "Realizar login", description = "Autentica o usuário e retorna um token JWT no padrão Bearer.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login realizado com sucesso",
                    content = @Content(schema = @Schema(implementation = AuthTokenResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados de login inválidos", content = @Content),
            @ApiResponse(responseCode = "401", description = "Credenciais inválidas", content = @Content)
    })
    public ResponseEntity<AuthTokenResponseDTO> login(@RequestBody @Valid LoginRequestDTO request) {
        var command = new AutenticarUsuarioCommand(request.login(), request.senha());
        var result = autenticacaoUseCase.authenticate(command);
        var response = new AuthTokenResponseDTO(
                result.tokenType(),
                result.accessToken(),
                result.expiresInMillis()
        );
        return ResponseEntity.ok(response);
    }
}
