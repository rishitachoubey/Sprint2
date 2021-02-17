package com.cg.onlinegrocery.domain;


import java.util.Collection;

import javax.persistence.*;



@Entity
@Table(name="users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(name="email",unique=true,nullable = false, length = 45)
   
    private String email;
     
    @Column(nullable = false, length = 64)
    
    private String password;
     
    @Column(name = "firstName", nullable = false, length = 20)
    
    private String firstName;
   
    @Column(name = "lastName", nullable = false, length = 20)
    private String lastName;
    
    @Column(name="address",nullable=false,length=200)
    
    private String address;
    
    @Column(name="phone",nullable=false,length=10)
    private String phone;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable( name = "users_roles",joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
            name = "role_id", referencedColumnName = "id"))
   private Collection<Role> roles;
    
    public User()
    {}
    
//	public User(Long id, String email, String password, String firstName, String lastName, String address,
//			String phone) {
//		super();
//		this.id = id;
//		this.email = email;
//		this.password = password;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.address = address;
//		this.phone = phone;
//	}

	public User(Long id, String email, String password, String firstName, String lastName, String address, String phone,
			Collection<Role> roles) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.roles = roles;
	}



	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", address=" + address + ", phone=" + phone + ", roles=" + roles + "]";
	}
	
}
