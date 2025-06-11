package com.producer.dto;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Consumer implements Serializable {

	private static final long serialVersionUID = 1L;

	int id;
	String name;
	String email;
	String contactNo;

}
