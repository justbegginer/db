package com.example.db.services.interfaces;

import com.example.db.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService extends CrudService<User>{
}
