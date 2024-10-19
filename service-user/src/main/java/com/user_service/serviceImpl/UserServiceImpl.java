package com.user_service.serviceImpl;

import com.user_service.entity.User;
import com.user_service.repository.UserRepository;
import com.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> searchUser(int idUser) {
        return userRepository.findById(idUser);
    }

    @Override
    public User registerUser(User objUser) {
        String encodedPassword = passwordEncoder.encode(objUser.getPassword());
        objUser.setPassword(encodedPassword);
        objUser.setDateRegister(new Date());
        return userRepository.save(objUser);    }

    @Override
    public void deleteUser(int idUser) {
        userRepository.deleteById(idUser);
    }

    @Override
    public List<User> findByAllAdmin() {
        return userRepository.findAllAdmin();
    }

    @Override
    public List<User> findByAllWorker() {
        return userRepository.findAllWorker();
    }

    @Override
    public List<User> finByAllCustomer() {
        return userRepository.findAllCustomer();
    }

    @Override
    public List<User> finByEmail(String email) {
        return userRepository.listByEmail(email);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.listUserByName(name);
    }

    @Override
    public List<User> findByLastName(String lastname) {
        return userRepository.listUserByLastName(lastname);
    }

    @Override
    public List<User> finByDni(String dni) {
        return userRepository.listByDni(dni);
    }
}
