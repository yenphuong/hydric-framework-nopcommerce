package javaBasic;

import commons.GlobalConstants;

public class Topic_05_Upload {
	
	static String[] fileNames = {"da_lat.jpeg", "ha_giang.jpeg", "hai_phong.jpeg"};
	
	static String fullFileName = "";
	
	public static void main(String[] args) {
		String filePath = GlobalConstants.UPLOAD_PATH;
		System.out.println(filePath);
		
		for (String file : fileNames) {
			System.out.println(file);
			fullFileName = fullFileName + filePath + file + "\n";
			System.out.println(fullFileName);
		}
		System.out.println("full file name: " + fullFileName);
		fullFileName = fullFileName.trim();
		System.out.println("full file name: " + fullFileName);
	}
}
