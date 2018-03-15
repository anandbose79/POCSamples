package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.model.Output;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import java.util.concurrent.TimeUnit;

@Service
public class TestService {

    @Value("${config.percentage:20}")	 
    private int numReq ;

	@HystrixCommand(fallbackMethod = "fallbackMethoddemo",commandKey = "testKey", threadPoolKey = "testKey")
	public Output getMerge(String input) throws Exception
	{
		int random = (int)(Math.random() * 100 + 1);
		System.out.println("Threshold percentage is ::"+numReq);
		if (random <numReq)
		{
			System.out.println("+ve flow");
		 return new Output("+veflow",input);
		}
		else
		{
			System.out.println("Throw exception");
			try {
				TimeUnit.SECONDS.sleep(2);
				throw new RuntimeException("This is a generated exception from the happy path");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}
			
		// return new Output("+veflow - timeout",input);
		}
	}
	public int getNumReq() {
		return numReq;
	}
	public void setNumReq(int numReq) {
		this.numReq = numReq;
	}
	
	public Output fallbackMethoddemo(String input, Throwable t)
	{
		System.out.println("inside fallback");
		System.out.println("Exception thrown :: " + t.getMessage());

		return new Output("fallbackflow",input);
	}
}
