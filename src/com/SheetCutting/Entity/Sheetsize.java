package com.SheetCutting.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
@Entity
@Table(name="sheetsize", catalog="sheetcutting")
public class Sheetsize
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Integer id;
  private String sheetName;
  private double height;
  private double width;
  private double thikness;
  private int noOfSheets;
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id", unique=true, nullable=false)
  public Integer getId()
  {
    return this.id;
  }
  
  public void setId(Integer id)
  {
    this.id = id;
  }
  
  @Column(name="SheetName", length=30)
  public String getSheetName()
  {
    return this.sheetName;
  }
  
  public void setSheetName(String sheetName)
  {
    this.sheetName = sheetName;
  }
  
  @Column(name="Height", length=10)
  public double getHeight()
  {
    return this.height;
  }
  
  public void setHeight(double height)
  {
    this.height = height;
  }
  
  @Column(name="Width", length=10)
  public double getWidth()
  {
    return this.width;
  }
  
  public void setWidth(double width)
  {
    this.width = width;
  }
  
  @Column(name="Thikness", length=10)
  public double getThikness()
  {
    return this.thikness;
  }
  
  public void setThikness(double thikness)
  {
    this.thikness = thikness;
  }
  
  public int getNoOfSheets()
  {
    return this.noOfSheets;
  }
  
  @Column(name="NoOfSheets", length=10)
  public void setNoOfSheets(int noOfSheets)
  {
    this.noOfSheets = noOfSheets;
  }
}
