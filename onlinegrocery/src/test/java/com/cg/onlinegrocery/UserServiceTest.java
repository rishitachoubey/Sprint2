package com.cg.onlinegrocery;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlinegrocery.domain.User;
import com.cg.onlinegrocery.repository.UserRepository;
import com.cg.onlinegrocery.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {
	
	
	@Autowired
	private UserService userservice;
	
	@MockBean
	private UserRepository userRepo;
	

//	@Test
//	void contextLoads() {
//	}
	
	@Test
	public void saveOrUpdateTest()
	{
		User user=new User();
		user.setId((long) 674);
		user.setName("Subu");
		user.setEmail("subu@gmail.com");
		user.setAddress("Ranchi");
		user.setPassword("Abc@57687");
		user.setPhone("9876467577");
		user.setRole("customer");
		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user,userservice.saveOrUpdate(user));
	}
	@Test
	public void loginUserTest()
	{
		User user=new User();
		user.setId((long) 674);
		user.setName("Subu");
		user.setEmail("subu@gmail.com");
		user.setAddress("Ranchi");
		user.setPassword("Abc@57687");
		user.setPhone("9876467577");
		user.setRole("customer");
		when(userRepo.findByEmail("subu@gmail.com")).thenReturn(user);
		assertEquals(user,userservice.loginUser("subu@gmail.com","Abc@57687"));
	
	}
	@Test
	public void findUserByEmailTest()
	{
		User user=new User();
		user.setId((long) 674);
		user.setName("Subu");
		user.setEmail("subu@gmail.com");
		user.setAddress("Ranchi");
		user.setPassword("Abc@57687");
		user.setPhone("9876467577");
		user.setRole("customer");
		when(userRepo.findByEmail("subu@gmail.com")).thenReturn(user);
		assertEquals(user,userservice.findUserByEmail("subu@gmail.com"));
		
	}

}
