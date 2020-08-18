package com.wsl.flight.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * @ClassName: File Utils类.
 * @Description:
 * @author demliu
 * @date 2016-08-05 下午3:04:32
 */
@Slf4j
public class FileUtils {
	/***
	 * 系统跟路径
	 */
	private static String basePath;

	private FileUtils() {
	}

	/**
	 * @Description 追加写入文件
	 * @param path
	 *            文件绝对路径
	 * @param text
	 *            要追加的文件内容
	 * @return
	 */
	public static boolean appendText(String path, String text) {
		BufferedWriter writer = null;
		try {
			File file = new File(path);
			writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(text);
			return true;
		} catch (Exception e) {
			log.error("写文件出错", e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
					writer = null;
				} catch (IOException e) {
					log.error("写文件出错", e);
				}
			}
		}
		return false;
	}

	/** 获取项目根路径 **/
	public static String getRootPath() {
		String classPath = null;
		// toURI() 20% to 空格
		classPath = FileUtils.class.getClassLoader().getResource("/").getPath()
				.replaceAll("%20", " ");
		String rootPath = "";
		// windows下
		if ("\\".equals(File.separator)) {
			rootPath = classPath.substring(1,
					classPath.indexOf("/WEB-INF/classes"));
			rootPath = rootPath.replace("/", "\\");
		}
		// linux下
		if ("/".equals(File.separator)) {
			rootPath = classPath.substring(0,
					classPath.indexOf("/WEB-INF/classes"));
			rootPath = rootPath.replace("\\", "/");
		}
		return rootPath + File.separator;
	}

	/**
	 * @Description 系统的默认目录为当前用户目录，可通过此函数重新设置
	 * @param basePath
	 * @throws FileNotFoundException
	 */
	public static void setBasePath(String basePath)
			throws FileNotFoundException {
		if (UtilAPI.isEmpty(basePath)) {
			throw new FileNotFoundException("不能指定空路径！");
		}
		if (!File.separator.endsWith(basePath.trim())) {
			basePath += File.separator;
		}
		FileUtils.basePath = basePath;
	}

	/**
	 * @Description 获取web根目录下面的资源的绝对路径 *
	 * @param path
	 *            相对应WEB根目录的路径
	 * @return 绝对路径
	 */
	public static String getAbsolutePath(String path) {
		if (UtilAPI.isEmpty(path)) {
			return "";
		}
		// 在windows下，如果路径包含：,为绝对路径，则不进行转换
		if (path.contains(":")) {
			return path;
		}
		log.debug("转换路径:" + path);
		if (path != null && path.trim().length() == 1) {
			return basePath;
		}
		if (path.startsWith("/")) {
			path = path.substring(1);
		}
		path = basePath + path.replace("/", File.separator);
		log.debug("返回路径:" + path);
		return path;
	}

	/**
	 * 文件复制
	 * 
	 * @param inFile
	 * @param outFile
	 * @throws IOException
	 */
	public static void copyFile(File inFile, File outFile) throws IOException {
		try {
			copyFile(new FileInputStream(inFile), outFile);
		} catch (FileNotFoundException ex) {
			log.error("文件不存在", ex);
			throw ex;
		}
	}

	/**
	 * 文件复制
	 * 
	 * @param inFile
	 * @param outFile
	 * @throws IOException
	 */
	public static void copyFile(MultipartFile inFile, File outFile) throws IOException {
		try {
			copyFile(inFile.getInputStream(), outFile);
		} catch (FileNotFoundException ex) {
			log.error("文件不存在", ex);
			throw ex;
		}
	}

	/**
	 * 文件流拷贝
	 * 
	 * @param in
	 * @param outFile
	 * @throws IOException
	 */
	public static void copyFile(InputStream in, File outFile)
			throws IOException {
		OutputStream out = null;
		try {
//			byte[] data = readAll(in);
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}
			out = new FileOutputStream(outFile);
			byte[] buf = new byte[4096];
			int bytesRead = in.read(buf);
			while (bytesRead >= 0) {
				out.write(buf, 0, bytesRead);
				bytesRead = in.read(buf);
			}
//			out.write(data, 0, data.length);
			out.close();
		} catch (Exception ex) {
			log.error("文件操作失败!", ex);
			throw new IOException("文件操作失败!");
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				log.error("文件操作失败", ex);
			}
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException ex) {
				log.error("文件操作失败", ex);
			}
		}
	}

	public static byte[] readAll(File file) throws IOException {
		try {
			return readAll(new FileInputStream(file));
		} catch (IOException ex) {
			log.error("读取文件失败", ex);
			throw ex;
		}
	}

	/**
	 * 文件流读入内存
	 * 
	 * @param in
	 * @return
	 * @throws IOException 
	 */
	public static byte[] readAll(InputStream in) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			byte[] buffer = new byte[1024];
			for (int n; (n = in.read(buffer)) > 0;) {
				out.write(buffer, 0, n);
			}
		} catch (IOException ex) {
			log.error("读取文件失败", ex);
			throw ex;
		}
		return out.toByteArray();
	}

	/**
	 * 根据文件名返回文件扩展名（大写）
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getExtName(String fileName, boolean toUpperFlg) {
		if (fileName == null || fileName.trim().length() ==0) {
			return "";
		}

		if (fileName.indexOf(".") < 0) {
			return "";
		}

		// 扩展名，不带.
		String extName = fileName.substring(fileName.lastIndexOf(".") + 1);
		if (toUpperFlg) {
			return extName.toUpperCase();
		} else {
			return extName;
		}
	}
	public static FileInputStream getInputStream(String path) throws FileNotFoundException {
		try {
			return new FileInputStream(getAbsolutePath(path));
		} catch (FileNotFoundException ex) {
			log.error("文件没有找到", ex);
			throw ex;
		}
	}
	
	/**
	 * 将字符串写入文件
	 * @param file
	 * @param line
	 * @param isAppend
	 */
	public static void writeFile(File file,String line,boolean isAppend){
		FileWriter fw;
		BufferedWriter bw;
		try {
			fw = new FileWriter(file,isAppend);
			bw = new BufferedWriter(fw);
			if(!file.exists()){
				file.createNewFile();
			}
			bw.write(line);
			bw.write("\r\n");
			bw.flush();
			fw.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 读取文件到字符串
	 * @param filePath
	 * @return
	 */
	public static String readFile(String filePath, String encoding){
		File file = new File(filePath);
		FileInputStream fis;
		InputStreamReader isr;
		BufferedReader br;
		StringBuffer stringBuffer = new StringBuffer();
		
		try{
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis, encoding);
			br = new BufferedReader(isr);
			String line ="";
			while((line = br.readLine())!=null){
				stringBuffer.append(line);
//					break;
			}
			br.close();
			isr.close();
			fis.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		return stringBuffer.toString();
	}
	
	/**
	 * 读取文件到字符串
	 * @param filePath
	 * @return
	 */
	public static String readFile(String filePath){
		File file = new File(filePath);
		FileInputStream fis;
		InputStreamReader isr;
		BufferedReader br;
		StringBuffer stringBuffer = new StringBuffer();
		
		try{
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			String line ="";
			while((line = br.readLine())!=null){
				stringBuffer.append(line);
//					break;
			}
			br.close();
			isr.close();
			fis.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		return stringBuffer.toString();
	}

	public static File createAndWriteFile(String path, byte[] data) {
		try {
			File file = new File(getAbsolutePath(path));
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
			OutputStream out = new FileOutputStream(file);
			out.write(data, 0, data.length);
			out.close();
			return file;
		} catch (Exception ex) {
			log.error("文件操作失败", ex);
		}
		return null;
	}

	public static File createAndWriteFile(String path, String text, String enCode) throws Exception {
		try {
			File file = new File(getAbsolutePath(path));
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file), enCode));
			writer.write(text);
			writer.flush();
			writer.close();
			return file;
		} catch (Exception ex) {
			log.error("文件操作失败", ex);
			throw ex;
		}
	}

	/**
	 * 文件删除
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static boolean removeFile(String path) throws Exception {
		File file = new File(path);
		boolean ret = true;
		//文件是否存在
		if (file.exists()) {
			//是否是文件
			if(file.isFile()){				
				//是，删除文件
				ret = file.delete();
				//不是，是目录
			} else if(file.isDirectory()){
				//获取目录下文件的list
				String[] filelist = file.list();
				//目录是否为空
				if(filelist.length > 0 ){	
					//不为空，循环删除目录下的文件
					for (int i = 0; i < filelist.length; i++) {		
						//递归
						ret = removeFile(path + "\\" + filelist[i]);
					}
					//循环完毕，删除目录
					ret = file.delete();
				} else {
					//为空，删除目录
					ret = file.delete();
				}
			}
			if (ret) {
				return true;
			} else {
				log.error("文件【" + path + "】删除失败！");
				throw new Exception("文件【" + path + "】删除失败！");
			}
		}
		return true;
	}

	public static Collection<String> getTextFileContent(String path) throws FileNotFoundException {
		return getTextFileContent(getInputStream(path));
	}

	public static Collection<String> getTextFileContent(InputStream in) {
		Collection<String> result = new LinkedHashSet<String>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
			String line = reader.readLine();
			while (line != null) {
				// 忽略空行和以#号开始的注释行
				if (!"".equals(line.trim()) && !line.trim().startsWith("#")) {
					result.add(line);
				}
				line = reader.readLine();
			}
		} catch (UnsupportedEncodingException ex) {
			log.error("不支持的编码", ex);
		} catch (IOException ex) {
			log.error("文件操作失败", ex);
		} finally {
			try {
				reader.close();
			} catch (IOException ex) {
				log.error("文件操作失败", ex);
			}
		}
		return result;
	}

	public static Collection<String> getClassPathTextFileContent(String path) {
		try {
			ClassPathResource cr = new ClassPathResource(path);
			return getTextFileContent(cr.getInputStream());
		} catch (IOException ex) {
			log.error("文件操作失败", ex);
		}
		return null;
	}


	/**
	 * 转换文件的编码格式
	 * 
	 * @param filePath
	 * @param codeFrom
	 * @param codeTo
	 * @return
	 */
	public static boolean convFileEncode(String filePath, String codeFrom, String codeTo) {
		File file = new File(filePath);
		//文件不存在
		if (!file.exists()) {
			return false;
		}

		String content = "";
		InputStreamReader isr = null;
		FileInputStream fs = null;
		BufferedReader br = null;
		try {
			fs = new FileInputStream(filePath);
			isr = new InputStreamReader(fs, codeFrom);
			br = new BufferedReader(isr);
			String s = null;
			while ((s = br.readLine()) != null) {
				content = content + "\n" + s;
			}
			br.close();

			createAndWriteFile(filePath, content, codeTo);
		} catch (Exception e) {
			log.error("文件编码转换发生异常！", e);
			return false;
		} finally {
			try {
				if (isr != null) {
					isr.close();
				}
				if (fs != null) {
					fs.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				log.error("文件编码转换发生异常！", e);
			}
		}
		return true;
	}


	public static String txt2String(String filePath) {
		String result = "";
		InputStreamReader isr = null;
		FileInputStream fs = null;
		BufferedReader br = null;
		try {
			fs = new FileInputStream(filePath);
			isr = new InputStreamReader(fs, "UTF-8");
			br = new BufferedReader(isr);
			String s = null;
			while ((s = br.readLine()) != null) {
				result = result + s;
			}
		} catch (Exception e) {
			log.error("文件读写发生异常！", e);
		} finally {
			try {
				if (isr != null) {
					isr.close();
				}
				if (fs != null) {
					fs.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				log.error("文件读写发生异常！", e);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// System.out.println(getAbsolutePath("a.xsl"));
//		String fileName = "d:\\123123.txt";
//		fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
//		fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
//		System.out.println(getExtName(fileName, false));
		
		
//		List<String> oldList = new ArrayList<String>();
//		oldList.add("1");
//		oldList.add("2");
//		oldList.add("3");
//		oldList.add("4");
//		oldList.add("5");
//
//		List<String> newList = new ArrayList<String>();
//		newList.add("1");
//		newList.add("2");
//		newList.add("3");
//		newList.add("6");
//		newList.add("7");
//		
//		List<String> sameList = new ArrayList<String>();
//		if (newList != null && newList.size() > 0) {
//			for (String item: newList) {
//				if (oldList != null && oldList.size() > 0) {
//					if (oldList.contains(item)) {
//						sameList.add(item);
//					}
//				}
//			}
//		}
//		
//		newList.removeAll(sameList);
//		oldList.removeAll(sameList);
//		
//		System.out.println(oldList);
//		System.out.println(newList);
		

		try {
			FileReader fr = new FileReader("F:\\综合演练系统帮助文档v1.0.doc");
			StreamTokenizer st = new StreamTokenizer(new BufferedReader(fr));
			st.ordinaryChar('\'');
			st.ordinaryChar('\"');
			st.ordinaryChar('/');

			String s = "";
			int numSum = 0;
			int wordSum = 0;
			int symbolSum = 0;
			while (st.nextToken() != StreamTokenizer.TT_EOF) {
				switch (st.ttype) {
					case StreamTokenizer.TT_EOL:
						break;

					case StreamTokenizer.TT_NUMBER:
						s = String.valueOf(st.nval);
						numSum += s.length();
						break;
						
					case StreamTokenizer.TT_WORD:
						s = st.sval;
						wordSum += s.length();
						break;
	
					default:
						s = String.valueOf((char)st.ttype);
						symbolSum += s.length();
						break;
				}
			}
			
			System.out.println("numSum==" + numSum);
			System.out.println("wordSum==" + wordSum);
			System.out.println("symbolSum==" + symbolSum);
			System.out.println("total==" + (numSum + wordSum + symbolSum));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}