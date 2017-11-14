package com.SheetCutting.Entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
@Entity
@Table(name = "circlestripsize", catalog = "sheetcutting")
public class Circlestripsize implements java.io.Serializable {

	 
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Double dimeter;
	private Double thikness;
	private String productName;

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Dimeter", length = 10)
	public Double getDimeter() {
		return this.dimeter;
	}

	public void setDimeter(Double dimeter) {
		this.dimeter = dimeter;
	}

	@Column(name = "Thikness", length = 10)
	public Double getThikness() {
		return this.thikness;
	}

	public void setThikness(Double thikness) {
		this.thikness = thikness;
	}

	@Column(name = "ProductName", length = 60)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}