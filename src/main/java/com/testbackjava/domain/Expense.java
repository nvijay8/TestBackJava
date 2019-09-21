package com.testbackjava.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@RedisHash("Expense")
public class Expense implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private @Id         String expenseId;
    private             String description;
    private             Double value;
    private @Indexed    Long alias;
    private @Indexed    Date date;
    private             Category category;


    public Expense() {
    }


	public Expense(String expenseId, String description, Double value, Long alias, Date date, Category category) {
		super();
		this.expenseId = expenseId;
		this.description = description;
		this.value = value;
		this.alias = alias;
		this.date = date;
		this.category = category;
	}


	public String getExpenseId() {
		return expenseId;
	}


	public void setExpenseId(String expenseId) {
		this.expenseId = expenseId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getValue() {
		return value;
	}


	public void setValue(Double value) {
		this.value = value;
	}


	public Long getAlias() {
		return alias;
	}


	public void setAlias(Long alias) {
		this.alias = alias;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
    
    


}
