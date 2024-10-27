package edu.kh.toyProject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
	private int stuNo;
	private String stuName;
	private int stuAge;
	private String gender;
	private String score;
	
}
