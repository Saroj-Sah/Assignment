package com.klizo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.klizo.entites.User;
import com.klizo.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	 @Autowired
	    private TestEntityManager entityManager;
	     
	    @Autowired
	    private UserRepository repo;
	    
	    @Test
	    public void testCreateUser() {
	        User user = new User();
	        user.setFirstName("Saroj");
	        user.setLastName("Sah");
	        user.setUsername("sahsaroj615@gmail.com");
	        user.setPassword("saroj2022");
	        
	         
	        User savedUser = repo.save(user);
	         
	        User existUser = entityManager.find(User.class, savedUser.getId());
	         
	        assertThat(user.getUsername()).isEqualTo(existUser.getUsername());
	         
	    }
	    public void testFindUserByUsername() {
	    	String username="sahsaroj615@gmail.com";
	    	User user = repo.findByUsername(username);
	    	assertThat(user).isNotNull();
	    }
	    

}
