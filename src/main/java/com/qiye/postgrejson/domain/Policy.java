package com.qiye.postgrejson.domain;

import java.util.UUID;

public class Policy {
	
	private String appId;
	private String policy;
	
//	public Policy(String appId, String policy) {
//		super();
//		this.appId = appId;
//		this.policy = policy;
//	}
//	public Policy(UUID appId, Object policy) {
//		super();
//		this.appId = appId.toString();
//		this.policy = (String)policy;
//	}
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	@Override
	public String toString() {
		return "Policy [appId=" + appId + ", policy=" + policy + "]";
	}
	
	

}
