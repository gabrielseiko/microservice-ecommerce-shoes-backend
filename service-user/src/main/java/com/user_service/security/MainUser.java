package com.user_service.security;

import com.user_service.entity.Role;
import com.user_service.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@CommonsLog
@ToString
public class MainUser implements UserDetails {
    /**
     * Clase que implementa la interfaz UserDetails de Spring Security.
     * Esta clase sirve como un adaptador entre la entidad User del sistema
     * y el modelo de seguridad utilizado por Spring Security.
     *
     * Proporciona los detalles de autenticación del usuario, como su nombre de usuario,
     * contraseña y roles (authorities), necesarios para el proceso de autenticación
     * y autorización. Además, incluye información adicional sobre el estado de la cuenta
     * como si está bloqueada, expirada o habilitada.
     *
     * El método estático `build` transforma un objeto User y sus roles en una instancia de
     * MainUser, que es el formato que Spring Security utiliza para manejar la autenticación.
     */

    private int iduser;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public static MainUser build(User user, List<Role> roles){
        log.info("> Usuario Principal >> " + user);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role x : roles){
            authorities.add(new SimpleGrantedAuthority(x.getRole()));
        }
        return new MainUser(user.getId(), user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
