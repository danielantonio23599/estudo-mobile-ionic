package com.backendestudo.backend.service.dto;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UsuarioDTO implements UserDetails {

    private final Optional<UsuarioCadastroDTO> usuario;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    public List<String> getRole(){
        return usuario.orElse(new UsuarioCadastroDTO()).getPerfis().stream().map(PerfilDTO::getNome).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return usuario.orElse(new UsuarioCadastroDTO()).getSenha();
    }

    @Override
    public String getUsername() {
        return usuario.orElse(new UsuarioCadastroDTO()).getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
