package com.testbackjava.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Setter
@RedisHash("Category")
public class Category {

    private @Id String id;
    private @Indexed String description;

    public Category() {
    }

	public String getId() {
		return id;
	}

	public Category(String id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
