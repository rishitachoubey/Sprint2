package com.cg.onlinegrocery.repository;

/**
 * Repository for user
 * @author Rupsi
 *
 */
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cg.onlinegrocery.domain.User;


@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	
	User findByEmail(String email);	
    
}
