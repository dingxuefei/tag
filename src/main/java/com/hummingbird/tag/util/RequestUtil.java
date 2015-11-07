package com.hummingbird.tag.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestUtil {

	private static Logger log = LoggerFactory.getLogger(RequestUtil.class);

	/**
	 * 获取post的请求数据
	 * 
	 * @param request
	 * @return
	 * @throws DataInvalidException
	 * @throws IOException
	 */
	public static String getRequestPostData(HttpServletRequest request) throws IOException {
		if (log.isDebugEnabled()) {
			log.debug("使用inputStream从请求中获取数据");
		}
		InputStream is = null;
		try {
			is = request.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			// 读取HTTP请求内容
			String buffer = null;
			StringBuffer sb = new StringBuffer();
			while ((buffer = br.readLine()) != null) {
				sb.append(buffer);
			}
			log.debug("post请求参数为:" + sb.toString());
			return sb.toString();
		} catch (IOException e) {
			log.error("获取请求的数据出错", e);
			throw e;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
