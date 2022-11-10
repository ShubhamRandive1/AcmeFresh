package com.AsmeFresh.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import antlr.collections.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;

	@NotNull
	@Pattern(regexp="{3,12}", message = "First Name must not contains numbers or special characters")
	private String firstName;
	
	@NotNull
	@Pattern(regexp="{3,12}", message = "Last Name must not contains numbers or special characters")
	private String lastName;
	

	@NotNull
	@Pattern(regexp="[6-9]{1}[0-9]{9}", message = "Mobile number must have 10 digits")
	private String mobile;

	
	@NotNull

	private String password;
	
	@Email
	@NotNull
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	private java.util.List<Orders> orderList;

}
