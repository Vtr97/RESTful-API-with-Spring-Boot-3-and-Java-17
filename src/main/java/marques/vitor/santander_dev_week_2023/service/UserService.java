package marques.vitor.santander_dev_week_2023.service;

import marques.vitor.santander_dev_week_2023.domain.User;

public interface  UserService {
    User findById(Long id);
    
    User create(User userToCreate);
}
