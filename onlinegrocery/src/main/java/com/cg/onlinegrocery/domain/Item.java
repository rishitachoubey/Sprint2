package com.cg.onlinegrocery.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_master")
public class Item implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "item_id")
	private Integer id;
	@Column(name = "item_model")
	private String model;

	private Double cost;

	@Column(name = "company_name")
	private String company;

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(Integer id, String model, Double cost, String company) {
		super();
		this.id = id;
		this.model = model;
		this.cost = cost;
		this.company = company;
	}

	public Item(String model, Double cost, String company) {
		super();
		this.model = model;
		this.cost = cost;
		this.company = company;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "item [id=" + id + ", model=" + model + ", cost=" + cost + ", company=" + company + "]";
	}

}
