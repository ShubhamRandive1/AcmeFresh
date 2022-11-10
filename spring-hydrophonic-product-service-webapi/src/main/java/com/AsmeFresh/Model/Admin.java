package com.AsmeFresh.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	@NotNull
	@Pattern(regexp="[a-zA-Z]{3,12}", message = "First Name must not contains numbers or special characters and should not be less than 3 and more than 12.")
	private String firstName;
	
	@NotNull
	@Pattern(regexp="[a-zA-Z]{3,12}", message = "Last Name must not contains numbers or special characters and should not be less than 3 and more than 12.")
	private String lastName;
	
	@NotNull
	@Pattern(regexp="[6-9]{1}[0-9]{9}", message = "Mobile number must be in proper format.")
	private String mobile;



	
	@NotNull
	private String password;
	
	@Email
	@NotNull
	private String email;

}
