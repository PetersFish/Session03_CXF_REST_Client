package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@RequestMapping(value = "/index")
	public String toIndex(){
		return "index";
	}

	@ResponseBody
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public void getUser(@PathVariable("id") Integer id, PrintWriter writer, HttpServletResponse response) throws Exception {
		// 第一步：创建服务地址，不是WSDL地址
		URL url = new URL("http://localhost:8080/cxf/ws/server/user/query/"+id+"?_type=json");
		// 第二步：打开一个通向服务地址的连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// 第三步：设置参数
		// 3.1发送方式设置：POST必须大写
		connection.setRequestMethod("GET");
		// Post 请求不能使用缓存
		connection.setUseCaches(false);
		connection.setInstanceFollowRedirects(true);
		// 3.2设置数据格式：content-type
		// 3.3设置输入输出，因为默认新创建的connection没有读写权限，
		connection.setDoInput(true);
		connection.setDoOutput(true);
		// 第五步：接收服务端响应，打印
		int responseCode = connection.getResponseCode();
		if (200 == responseCode) {// 表示服务端响应成功
			InputStream is = connection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			StringBuilder sb = new StringBuilder();
			String temp = null;
			while (null != (temp = br.readLine())) {
				sb.append(temp);
			}
			temp = sb.toString();
			System.out.println(temp);
			// dom4j解析返回数据，课下作业
			is.close();
			isr.close();
			br.close();
			writer.write(temp);
		}
	}
}
