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
    private UserRepository userRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public Optional<User> findById(int id) {
        return userRepo.findById(id);
    }

    public User save(User user) {
        return userRepo.save(user);
    }
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

}
