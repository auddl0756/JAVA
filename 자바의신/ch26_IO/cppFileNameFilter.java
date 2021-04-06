package ch26_IO;

import java.io.File;
import java.io.FilenameFilter;

public class cppFileNameFilter implements FilenameFilter{
	@Override
	public boolean accept(File dir, String name) {
		if(name.endsWith(".cpp")) return true;
		else return false;
	}
}
