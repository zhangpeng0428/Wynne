package com.common.utils;

import java.io.File;

public class FileUtil {
	/**
	 * ����ļ�? ����ļ�����·�������������·��
	 * 
	 * @param fileName
	 *            �ļ��� ��·��
	 * @param isDirectory
	 *            �Ƿ�Ϊ·��
	 * @return
	 * @author yayagepei
	 * @date 2008-8-27
	 */
	public static File buildFile(String fileName, boolean isDirectory) {
		System.out.println("filename:"+fileName);
		File target = new File(fileName);
		if (isDirectory) {
			target.mkdirs();
		} else {
			if (!target.getParentFile().exists()) {
				target.getParentFile().mkdirs();
				target = new File(target.getAbsolutePath());
			}
		}
		return target;
	}

}
