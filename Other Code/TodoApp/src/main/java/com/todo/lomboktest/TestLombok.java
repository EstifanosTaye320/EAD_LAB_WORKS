package com.todo.lomboktest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TestLombok {
	private String name = "Estif";
	
	public static void main(String[]args) {
		TestLombok lombok = new TestLombok();
		System.out.println(lombok.getName());
		System.out.println("kdfkablkdflkj".contains("ab"));
		
	}
}