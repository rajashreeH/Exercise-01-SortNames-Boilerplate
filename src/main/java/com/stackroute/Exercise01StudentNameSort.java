package com.stackroute;

import java.util.Scanner;

import javax.xml.bind.helpers.ParseConversionEventImpl;

//Complete the code below as given in the problem.md file
public class Exercise01StudentNameSort {
	public static String[] sortStudents(String[] studentNames, int[] percentage) {
		
		for(int i=0;i<percentage.length-1;i++) {
			for(int j=0;j<percentage.length-1-i;j++) {
				if(percentage[j]>percentage[j+1]) {
					int temp=percentage[j];
					percentage[j]=percentage[j+1];
					percentage[j+1]=temp;
					
					String tempString=studentNames[j];
					studentNames[j]=studentNames[j+1];
					studentNames[j+1]=tempString;
				}
			}
		}
		return studentNames;
	}
	
	//Do not print anything other than what's expected/asked in problem
	public static void main(String[] args) {
		//Use Scanner to get input from console
		
		Scanner scan=new Scanner(System.in);
		String inputData=scan.nextLine();
		
		String[] studentName = null;
		int[] studentMarks = null;
		
		//System.out.println("inputData: "+inputData);
		String[] studentinfo=inputData.split(";");
		for(int i=0;i<studentinfo.length;i++) {
			String[] studentDetail=studentinfo[i].split(":");
			studentName[i]=studentDetail[0];
			studentMarks[i]= Integer.parseInt(studentDetail[1]);
		}
		String[] studentNames=sortStudents(studentName,studentMarks);
		
		System.out.println(studentNames.toString());
	}
}