package com.security.component;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.security.model.Product;
import com.security.model.User;
import com.security.repository.ProductRepository;
import com.security.repository.RoleRepository;
import com.security.repository.UserRespository;
import com.security.role.Role;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRespository userRespository;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        
        if (productRepository.count() == 0) {
            Product product1 = new Product(1l, "Cafeteira");
            Product product2 = new Product(2l, "Café torrado");
            Product product3 = new Product(3l, "Café moido");
            Product product4 = new Product(4l, "Garrafa de café 1 litro");
            
            productRepository.saveAll(Arrays.asList(product1, product2, product3, product4));
        }

        if (roleRepository.count() == 0) {
            Role role1 = new Role(1l, "PRODUCT_SELECT");
            Role role2 = new Role(2l, "PRODUCT_INSERT");
            Role role3 = new Role(3l, "PRODUCT_UPDATE");
            Role role4 = new Role(4l, "PRODUCT_DELETE");

            roleRepository.saveAll(Arrays.asList(role1, role2, role3, role4));
        }

        if (userRespository.count() == 0) {

            Role role1 = roleRepository.findById(1L).orElseThrow(() -> new RuntimeException("Role not found"));
            Role role2 = roleRepository.findById(2L).orElseThrow(() -> new RuntimeException("Role not found"));
            Role role3 = roleRepository.findById(3L).orElseThrow(() -> new RuntimeException("Role not found"));
            Role role4 = roleRepository.findById(4L).orElseThrow(() -> new RuntimeException("Role not found"));

            List<Role> permissao1 = Arrays.asList(role1, role2, role3, role4);
            List<Role> permissao2 = Arrays.asList(role1, role2);

            String password = passwordEncoder().encode("123456");

            User user1 = new User(1l, "teste1@gmail.com", "teste1@gmail.com",password, permissao1);
            User user2 = new User(2l, "teste2@gmail.com", "teste2@gmail.com",password, permissao2);

            userRespository.saveAll(Arrays.asList(user1, user2));
        }

    }
    
}
