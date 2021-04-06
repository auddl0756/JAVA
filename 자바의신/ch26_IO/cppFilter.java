package ch26_IO;

import java.io.File;
import java.io.FileFilter;

public class cppFilter implements FileFilter{
	@Override
	public boolean accept(File file) {
		if(file.isFile()) {
			String fileName=file.getName();
			if(fileName.endsWith(".cpp")) return true;
		}
		return false;
	}
}
