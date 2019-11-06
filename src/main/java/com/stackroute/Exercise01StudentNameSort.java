package com.stackroute;

import java.util.Arrays;
import java.util.Scanner;

import javax.xml.bind.helpers.ParseConversionEventImpl;

//Complete the code below as given in the problem.md file
public class Exercise01StudentNameSort {
	private static Scanner scan;

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
	
		
		scan = new Scanner(System.in);
		String inputData=scan.nextLine();
		
		String[] studentName;
		int[] studentMarks;
		String[] studentinfo=inputData.split(";");
		studentName=new String[studentinfo.length];
		studentMarks=new int[studentinfo.length];
		//System.out.println("inputData: "+inputData);
		
		for(int i=0;i<studentinfo.length;i++) {
			
			String[] studentDetail=studentinfo[i].split(":");
			studentName[i]=studentDetail[0];
			studentMarks[i]= Integer.parseInt(studentDetail[1]);
		}
		String[] studentNames=sortStudents(studentName,studentMarks);
		
		System.out.println(Arrays.toString(studentName));
	}
}