package ch26_IO;

import java.io.File;

public class FileFilterSample {
	public static void main(String[] args) {
		FileFilterSample sample = new FileFilterSample();
		String pathName = File.separator+"upload"+File.separator+"tmp";
		sample.checkList(pathName);
	}
	
	public void checkList(String pathName) {
		File file;
		try {
			file = new File(pathName);
//			File []FileList = file.listFiles();
			
			//cppFileNameFilter에서 구현한  accept 메서드에 따라 파일들을 필터해준다!
			// 단 FileNameFilter는 파일명만 보고 디렉토리인지 파일인지 구분은 못함 
			//File []FileList = file.listFiles(new cppFileNameFilter());
			
			// FileFilter()의 accept를 구현한 필터는 디랙토리,파일을 구분 가능!
			File []FileList = file.listFiles(new cppFilter());
			
			for(File f:FileList) System.out.println(f.getName());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
