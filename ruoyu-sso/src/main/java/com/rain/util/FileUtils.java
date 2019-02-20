package com.rain.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @Title FileUtils.java
 * @Description 文件工具类：读取文件采取的reader.readLine()，此方法会将行都存入内存，如果文件过大则使用scanner，每次只会加载一行引用
 * @author rain
 * @date 2018年12月20日
 */
public class FileUtils {
	private final static Logger logger = LoggerFactory.getLogger(FileUtils.class);
	/**
	 * 获取文件内容，以行为单位读取，返回行的集合
	 * @param filePath 文件的全路径
	 * @return
	 * @throws IOException 
	 */
	public static List<String> getFileLines(String filePath) {
		List<String> lines= new ArrayList<String>();
		BufferedReader reader = null;
		try {
			FileInputStream fis = new FileInputStream(filePath);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			reader = new BufferedReader(isr);
			
			String line = "";
			while((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getFileLines 出错，filePath为{}", filePath);
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return lines;
	}
	
	/**
	 * 移动文件到另一个目录
	 * @param source 源文件
	 * @param targetFolder 目标目录
	 */
	public static void moveFile(String sourcePath, String targetFolder) {
		File source = new File(sourcePath);
		File target = new File(targetFolder);
		if(!target.exists()) {
			target.mkdirs();
		}
		File destFile = new File(targetFolder + source.getName());
		source.renameTo(destFile);
	}
	
	/**
	 * 获取目录下所有文件
	 * @param path
	 * @return
	 */
	public static File[] listFolder(String path){
		File folder = new File(path);
		if(!folder.exists()) {
			return null;
		}
		return folder.listFiles();
	}
	
	/**
     * 删除文件或者文件夹通用方法
     * @param path
     */
    public static boolean deleteFileOrFolder(String path) {
    	boolean flag = false;
    	try {
			File file = new File(path);
			//判断文件或者目录是否存在
			if(!file.exists()) {
				return false;
			} else {
				//判断是否为文件
				if(file.isFile()) {
					return deleteFile(path);
				} else {
					deleteFolder(path);
				}
			}
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return flag;
    }
    
    /**
     * 删除单个文件
     * @param path
     * @return
     */
    private static boolean deleteFile(String path) {
    	boolean flag = false;
    	try {
    		File file = new File(path);
    		if(file.isFile() && file.exists()) {
    			file.delete();
    			flag = true;
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return flag;
    }
    
    /**
     * 删除文件夹
     * @param path
     * @return
     */
    private static boolean deleteFolder(String path) {
    	boolean flag = false;
    	//如果path不以分隔符结尾，自动添加文件分隔符
    	if(!path.endsWith(File.separator)) {
    		path += File.separator;
    	}
    	File dirFile = new File(path);
    	if(!dirFile.exists() || !dirFile.isDirectory()) {
    		return false;
    	}
    	flag = true;
    	File[] files = dirFile.listFiles();
    	for (int i = 0; i < files.length; i++) {
			if(files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if(!flag) {
					break;
				}
			} else {
				flag = deleteFolder(files[i].getAbsolutePath());
				if(!flag) {
					break;
				}
			}
		}
    	if(!flag) {
			return false;
		}
    	//删除当前目录
    	if(dirFile.delete()) {
    		return true;
    	} else {
    		return false;
    	}
    }
}