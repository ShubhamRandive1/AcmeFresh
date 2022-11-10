package com.AsmeFresh.Model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCurrentSessionDTO {
	
	private Integer customerId;
		
	private String uuid;
		
	private LocalDateTime localDateTime;

}
