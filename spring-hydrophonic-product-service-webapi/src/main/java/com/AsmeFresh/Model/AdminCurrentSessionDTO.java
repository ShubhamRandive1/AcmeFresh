package com.AsmeFresh.Model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminCurrentSessionDTO {
	
	
	private Integer adminId;
	
	private String uuid;
	
	private LocalDateTime localDateTime;
	

}
