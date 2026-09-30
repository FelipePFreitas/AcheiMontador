package com.felipefreitas.rhexpress.infra.security;

import com.felipefreitas.rhexpress.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Autenticacao implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(username)
                        .map(usuario -> User.builder()
                                .username(usuario.getEmail())
                                .password(usuario.getSenha())
                                .build())
                        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}
