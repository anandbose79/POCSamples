package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Output;
import com.example.service.TestService;

@RestController
public class Apicontroller {

	private final   TestService myservice;
	@Autowired
	public  Apicontroller(TestService myservice)
	{
		this.myservice = myservice;
		// TODO Auto-generated constructor stub
	}
	@RequestMapping("/demorequest/{input}")

	public Output getOutput(@PathVariable  String input) throws Exception
	{
	  return myservice.getMerge(input);
	}
	@RequestMapping("/random/{numreq}")
	public String setRandom(@PathVariable int numreq)
	{
		myservice.setNumReq(numreq);
		return "success";
	}
	



}
