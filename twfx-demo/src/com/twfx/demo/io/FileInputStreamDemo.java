/**
 * 文件名：@FileInputStreamDemo.java <br/>
 * 包名：com.twfx.demo.io <br/>
 * 项目名：twfx-demo <br/>
 * @author twfx <br/>
 */
package com.twfx.demo.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 类名：FileInputStreamDemo <br />
 *
 * 功能：读取文件内容，以字节方式读取
 *
 * @author twfx <br />
 *         创建时间：2019年8月14日 上午10:29:49 <br />
 * @version 2019年8月14日
 */
public class FileInputStreamDemo {

	/**
	 * 功能：<br/>
	 *
	 * @author twfx
	 * @version 2019年8月14日 上午10:30:11 <br/>
	 */
	public static String read(String filePath) {
		StringBuilder sb = new StringBuilder();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
//			int fileLength = fis.available(); // 获取文件内容长度，当文件不大的时可以将文件长度作为byte数组的长度，一次性将文件内容读取出来
//			byte[] bs = new byte[fileLength];
			byte[] bs = new byte[1024];
			int count = 0;
			while ((count = fis.read(bs)) != -1) {
				sb.append(new String(bs, 0, count));
			}
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (null != fis) {
				try {
					fis.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(read("F:/text.txt"));
	}
}
