package com.cg.onlinegrocery.domain;
/**
 * Pojo for role
 * 
 * @author Rupsi
 *
 */

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String role;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id", nullable = false)
	private User user;
   
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", role=" + role + ", user=" + user + "]";
	}

	public Role() {
		super();
	}

	public Role( String role) {
		super();
		this.role = role;
	}
	

}
