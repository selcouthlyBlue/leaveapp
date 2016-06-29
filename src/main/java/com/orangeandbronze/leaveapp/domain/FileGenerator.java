package com.orangeandbronze.leaveapp.domain;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;

public class FileGenerator {
	
	public final static String DELIMITER = ",";
	public final static String NEW_LINE = "\n";
	
	public void generateLWOPReport(Calendar startDate, Calendar endDate, Collection<Employee> employee) {
		String fileName = ""; 
		//SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		//String formatted = format1.format(cal.getTime());
		String header = "";
		generateReport(fileName, header, ReportType.LWOP, employee);
	}
	
	public void generateReport(String fileName, String header, ReportType reportType, Collection<Employee> employee) {
		FileWriter fileWriter = null;
		String content = "";
		try {
			fileWriter = new FileWriter(fileName);
			fileWriter.append(header);
			
			if(reportType == ReportType.LWOP)
				content = generateLwopContent(employee);
			if(reportType == ReportType.SICK_LEAVE)
				content = generateSickLeaveContent(employee);
			if(reportType == ReportType.CONVERSION)
				content = generateConversionContent(employee);
			
			fileWriter.append(content);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private String generateLwopContent(Collection<Employee> employees) {
		String content = "";
		/*for(Employee employee : employees) {
			
		}*/
		return content;
	}
	
	private String generateSickLeaveContent(Collection<Employee> employee) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String generateConversionContent(Collection<Employee> employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
