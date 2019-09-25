package com.banyuan.test01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) throws IOException{
		File src=getDir();
		File dest=getDir();
		if(src.equals(dest)) {
			System.out.println("文件夹相同");
		}else {
			copy(src,dest);
		}

	}
public static File getDir() {
	Scanner sc=new Scanner(System.in);
	System.out.println("请输入文件夹路径：");
	while(true) {
		String line=sc.nextLine();
		File dir=new File(line);
		if(!dir.exists()) {
			System.out.println("文件夹不存在，请重新输入：");
		}else if(dir.isFile()){
			System.out.println("您输入的是文件路径，请输入文件夹路径");
			
		}else {
			return dir;
		}
		}
}
public static void copy(File src,File dest)throws IOException{
	File newDir=new File(dest,src.getName());
	newDir.mkdir();
	File[] subFiles=src.listFiles();
	for(File subFile:subFiles) {
		if(subFile.isFile()) {
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(subFile));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(new File(newDir,subFile.getName())));
		int b;
		while((b=bis.read())!=-1) {
			bos.write(b);
		}
		bis.close();
		bos.close();
	}else {
		copy(subFile,newDir);
	}
}
}
}
