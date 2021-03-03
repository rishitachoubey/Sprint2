package com.cg.onlinegrocery.domain;
/**
 * This class will create users table in database and get all the user details
 * POJO Class
 * @author Rupsi
 */
import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(name="email",unique=true,nullable = false, length = 45)
    @Pattern(
    	    regexp = "^(.+)@(\\S+)$", 
    	    message = "Enter a valid email id"
    	    ) 
    
    private String email;
     
    @Column(nullable = false, length = 64)
    @Pattern(
    	    regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", 
    	    message = "Enter a valid password"
    	    ) 
    
    private String password;
     
    @Column(name = "name", nullable = false, length = 30)
    
    private String name;
   @Column(name="address",nullable=false,length=200)
    private String address;
    
    @Column(name="phone",nullable=false,length=10)
    private String phone;
    @Column(name = "role", nullable = false, length = 30)
    private String role;
    
    //Getters and setters

	public Long getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", address="
				+ address + ", phone=" + phone + ", role=" + role + "]";
	}

	
    

	
	
	
	
}
