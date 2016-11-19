package com.common.core;

import java.io.BufferedReader;
import java.util.List;

import com.common.utils.JsonUtil;
import com.google.gson.reflect.TypeToken;
import com.jfinal.core.Controller;
import com.mvc.request.Req_Login;

/**
 * ��;��controller���࣬����controller����̳� ˵����
 */
public class BaseController extends Controller {

	protected String getControllerKey() {
		return this.getAttr("ControllerKey");
	}
	protected boolean isPost(){		
		return "post".equals(getRequest().getMethod().toLowerCase());
	}
	protected void goBack() {
		goBack(-1);
	}
	protected void goBack(int step) {
		renderJS("history.go(" + step + ")");
	}
	protected void alertAndGoback(String msg) {
		alertAndGoback(msg,-1);
	}
	protected void alertAndGoback(String msg,int step) {
		renderJS("alert('"+msg+"');history.go(" + step + ")");
	}
	protected void renderJS(String jsContent){
		renderHtml("<script type=\"text/javascript\">"+jsContent+"</script>");
	}
	
	/**
	 * ȡRequest�е����ݶ���
	 * @param valueType
	 * @return
	 * @throws Exception 
	 */
	protected <T> T getRequestObject(Class<T> valueType) throws Exception {
	    StringBuilder json = new StringBuilder();
	    BufferedReader reader = this.getRequest().getReader();
	    String line = null;
	    while((line = reader.readLine()) != null){
	        json.append(line);
	    }
	    reader.close();
	    return JsonUtil.fromJson(json.toString(), new TypeToken<List<Req_Login>>(){}.getType());
	}
}
