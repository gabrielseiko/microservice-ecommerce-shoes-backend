package com.product.service.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8091")
public interface UserServiceClient {

    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") int idUser);
}
