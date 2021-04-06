package ch26_IO;

import java.io.File;
import java.util.Date;

//mainly directory
public class FileSample {
	public static void main(String[] args) {
		FileSample sample = new FileSample();
		//String pathName="C:\\upload\\tmp";
		String pathName=File.separator+"upload"+File.separator+"tmp";
//		sample.checkPath(pathName);
//		sample.makeDir(pathName);
//		sample.checkFileMethods(pathName);
//		sample.canFileMethods(pathName);
		sample.lastModified(pathName);
	}
	
	//존재하는 경로인지 확인
	public void checkPath(String pathName) {
		File file = new File(pathName);
		System.out.println(pathName +" is exists? = "+file.exists());
	}
	
	public void makeDir(String pathName) {
		File file = new File(pathName);
		System.out.println("make "+pathName+" result ="+file.mkdir());
	}
	
	//디렉토리인지 파일인지. 파일이라면 숨김파일인지
	public void checkFileMethods(String pathName) {
		File file = new File(pathName);
		System.out.println(pathName +" is directory ? "+file.isDirectory());
		System.out.println(pathName +" is file? "+file.isFile());
		System.out.println(pathName +" is hidden file ? "+file.isHidden());
	}
	
	//디렉토리,파일의 권한 확인하기
	public void canFileMethods(String pathName) {
		File file = new File(pathName);
		System.out.println("can read? "+file.canRead());
		System.out.println("can write? "+file.canWrite());
		System.out.println("can execute? "+file.canExecute());
	}
	
	public void lastModified(String pathName) {
		File file = new File(pathName);
		System.out.println(pathName +" last modified : "+new Date(file.lastModified()));
	}
	
	
}
