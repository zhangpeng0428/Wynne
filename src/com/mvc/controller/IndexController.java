package com.mvc.controller;

import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;

public class IndexController extends Controller{
	/*
	 * ϵͳ��½��ҳ system/login
	 *
	*/
	@Clear
	public void index() {
		redirect("/system/login");
	}

}
