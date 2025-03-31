package com.example;

import org.testng.annotations.Test;

public class Smoke {
	@Test
	public static void T01_addition_positive() {
		int a=15;
		int b=5;
		int c=a+b;
		System.out.println("The sum  of 2 numbers: "+c);
	}
	@Test
	public static void T02_subraction_positive() {
		int a=15;
		int b=5;
		int c=a-b;
		System.out.println("The sub of 2 numbers: "+c);
		}

	
	@Test
	public static void T02_mul_positive() {
		int a=15;
		int b=5;
		int c=a*b;
		System.out.println("The Mul of 2 numbers: "+c);
	}
}
