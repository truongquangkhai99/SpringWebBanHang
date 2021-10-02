package com.tuyennguyen.serivce;

import com.tuyennguyen.entity.User;
import com.tuyennguyen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public Optional<User> findById(int id) {
        return repository.findById(id);
    }

    public User save(User user) {
        return repository.save(user);
    }
    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
