package com.hbsf.controller;

import javax.servlet.http.HttpServletRequest;

import com.hbsf.websocket.SocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {
	@RequestMapping("sockettest")
	public String sockettest(){
		System.out.println("来到了sockettest");
		return "sockettest";
	}
	
	@RequestMapping("tongji")
	public String tongji(Model model){
		model.addAttribute("num", SocketServer.getOnlineNum());
		model.addAttribute("users", SocketServer.getOnlineUsers());
		return "tongji";
	}
	
	@RequestMapping("sendmsg")
	@ResponseBody
	public String sendmsg(HttpServletRequest request){
		String username = request.getParameter("username");
		String msg = request.getParameter("msg");
		SocketServer.sendMessage(msg, username);
		return "success";
	}
	
	@RequestMapping("sendAll")
	@ResponseBody
	public String sendAll(HttpServletRequest request){
		String msg = request.getParameter("msg");
		SocketServer.sendAll(msg);
		return "success";
	}
}
