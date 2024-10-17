package com.user_service.security.service;

import com.user_service.entity.Role;
import com.user_service.entity.User;
import com.user_service.repository.UserRepository;
import com.user_service.security.MainUser;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CommonsLog
@Qualifier("userSecurityServiceImpl")
public class UserSecurityServiceImpl implements UserDetailsService {
//service para gestionar la autenticacion y carga de usuarios
    //implementacion de userdetailsservice, cargar y proporciona detalles del un usuario durante la autenticacion

    @Autowired
    private UserRepository userRepository;

    //metodo para cargar los detalles del usuario
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info(">> loadUserByUsername >> " + email);
        try {
            // Búsqueda del usuario en la BD usando el repositorio
            User objUser = userRepository.findByEmail(email);

            if (objUser != null) {
                log.info("=> Login == " + objUser);

                List<Role> listRole = userRepository.getRolesUser(objUser.getId());
                log.info("=> Role == " + listRole);

                // Construye y retorna el UserDetails usando MainUser
                return MainUser.build(objUser, listRole);
            } else {
                throw new UsernameNotFoundException("Usuario no encontrado con el nombre de usuario: " + email);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new UsernameNotFoundException("Usuario incorrecto: " + email);
        } catch (DataAccessException e) {
            log.error("Error de acceso a datos", e);
            throw new UsernameNotFoundException("Error en la base de datos");
        } catch (Exception e) {
            log.error("Error desconocido", e);
            throw new UsernameNotFoundException("Error desconocido");
        }
    }

}