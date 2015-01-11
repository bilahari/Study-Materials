package test.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
	/**
	 * 	If the file 'filePathName' is not there
	 * 		the method will create all the parent folders and the file inside them
	 * 	and will append the msg to the file
	 */
	public static boolean appendToFile(String msg,String filePathName, boolean shouldPrintInConsole){
		if(shouldPrintInConsole){
			System.out.println(msg);
		}
		//	Creating folders if not exists
		File tempFile=new File(filePathName);
		String destinationFolder=tempFile.getParent().toString();
		File newdir = new File(destinationFolder);
		if(!newdir.exists()){
			try{
				newdir.mkdirs();
			}catch(Exception e){
			}
		}
		//	Writing to file
		File file = new File(filePathName);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			//	'true' arg for appending
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(msg);
			bw.close();
			fw.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
}
