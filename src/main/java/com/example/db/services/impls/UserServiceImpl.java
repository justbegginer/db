package com.example.db.services.impls;

import com.example.db.models.User;
import com.example.db.repo.UserRepo;
import com.example.db.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public void delete(User elem) {
        this.userRepo.delete(elem);
    }

    @Override
    public void save(User elem) {
        this.userRepo.save(elem);
    }

    @Override
    public Optional<User> findById(int id) {
        return this.userRepo.findById(id);
    }

    @Override
    public List<User> findAll() {
        return this.userRepo.findAll();
    }
}
