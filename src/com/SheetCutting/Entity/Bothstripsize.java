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
@Table(name = "bothstripsize", catalog = "sheetcutting")
public class Bothstripsize implements java.io.Serializable {

	 

	 
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String productName;
	private Double height;
	private Double width;
	private Double thikness;

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "ProductName", length = 60)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "Height")
	public Double getHeight() {
		return this.height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	@Column(name = "Width")
	public Double getWidth() {
		return this.width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	@Column(name = "Thikness")
	public Double getThikness() {
		return this.thikness;
	}

	public void setThikness(Double thikness) {
		this.thikness = thikness;
	}

}