package com.fzu.meetsystem.tools;

import org.apache.logging.log4j.message.Message;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HttpTools {
	public static Map<String,Object> buildSuccessResp(Object data,String path,String message){
		HashMap<String, Object> resp = new LinkedHashMap<>();
		resp.put("timestamp",new Timestamp(System.currentTimeMillis()));
		resp.put("status",200);
		resp.put("data",data);
		resp.put("message",message);
		resp.put("path",path);
		return resp;
	}
	public static Map<String,Object> buildSuccessResp(Object data,String path){
	    return buildSuccessResp(data,path,"");
	}

}
