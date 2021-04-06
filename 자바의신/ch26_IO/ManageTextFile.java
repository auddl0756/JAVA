package ch26_IO;

import static java.io.File.separator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ManageTextFile {
	public static void main(String[] args) {
		ManageTextFile manager = new ManageTextFile();
		int cnt=10;
		String fullPath = separator+"upload"+separator+"tmp"+separator+"test_fileWrite.cpp";
//		manager.writeFile(fullPath, cnt);
//		manager.readFile(fullPath);
		
		manager.readFile_FILES(fullPath);
	}

	// java 7에서부터 Files클래스에서 1줄로 파일 읽기 가능!!!!!!!!
	public void readFile_FILES(String fileName) {
		try {
			String data = new String(Files.readAllBytes(Paths.get(fileName)));
			
			System.out.println(data);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	
	//Scanner 로 파일 읽기
	public void readFile_Scanner(String fileName) {
		File file = new File(fileName);
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
			System.out.println("read successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(scanner !=null) scanner.close();
		}
	}
	
	public void readFile(String fileName) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			String data;
			while((data=bufferedReader.readLine())!= null) {
				System.out.println(data);
			}
			System.out.println("read successfully");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(bufferedReader !=null) {
				try {
					bufferedReader.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			if(fileReader!=null) {
				try {
					fileReader.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void writeFile(String fileName,int cnt) {
		FileWriter fileWriter=null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter(fileName);
			bufferedWriter = new BufferedWriter(fileWriter);
			for(int i=0;i<cnt;i++) {
				bufferedWriter.write(Integer.toString(i));
				bufferedWriter.newLine();
			}
			System.out.println("write successfully! ");	
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(bufferedWriter !=null) {
				try {
					bufferedWriter.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			if(fileWriter !=null) {
				try {
					fileWriter.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
