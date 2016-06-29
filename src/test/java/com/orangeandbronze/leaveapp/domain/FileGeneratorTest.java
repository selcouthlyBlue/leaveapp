package com.orangeandbronze.leaveapp.domain;

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashSet;

import org.junit.Test;

public class FileGeneratorTest {
	@Test
	public void testLwopFileGeneration() {
		
		Calendar startDate = new GregorianCalendar(2016,11,5);
		Calendar endDate = new GregorianCalendar(2016,11,12);
		Employee emp1 = new Employee("Jason", "Bajade");
		Employee emp2 = new Employee("Jerome", "Gonzalvo");
		Employee emp3 = new Employee("Rochelle", "Sisa");
		Collection<Employee> allEmployee = new HashSet<Employee>();
		allEmployee.add(emp1);
		allEmployee.add(emp2);
		allEmployee.add(emp3);
		FileGenerator fileGenerator= new FileGenerator();
		fileGenerator.generateLWOPReport(startDate, endDate, allEmployee);
	}
}
