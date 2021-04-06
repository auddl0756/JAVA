package ch26_IO;

import java.io.File;
import java.io.IOException;

public class FileManageClass {
	public static void main(String[] args) {
		FileManageClass sample = new FileManageClass();
		String pathName =File.separator+"upload"+File.separator+"tmp";
		String fileName ="test.txt";
		sample.createFile(pathName, fileName);
			
	}
	
	public void createFile(String pathName,String fileName) {
		File file = new File(pathName,fileName);
		File file2= new File(pathName);
		try {
			System.out.println("create result = "+file.createNewFile());
			getFileInfo(file);
			
			String[] fileList = file2.list();
			System.out.println("====================\nfiles in this directory");
			for(String s:fileList) System.out.println(s);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getFileInfo(File file) throws IOException{
		System.out.println("absolute paht = "+file.getAbsolutePath());
		System.out.println("absoulte file = "+file.getAbsoluteFile());
		System.out.println("canonical path = "+file.getCanonicalPath());
		System.out.println("canonical file = "+file.getCanonicalFile());
		
		System.out.println("path ="+file.getPath());
		System.out.println("name = "+file.getName());
	}
}
