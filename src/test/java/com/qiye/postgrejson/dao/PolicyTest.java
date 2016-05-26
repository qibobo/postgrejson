package com.qiye.postgrejson.dao;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.junit.Test;

import com.qiye.postgrejson.domain.Policy;
import com.qiye.postgrejson.mybatis.util.SessionFactoryManager;

public class PolicyTest {

//	@Test
//	public void getPolicy() {
//		SqlSession session = SessionFactoryManager.getSqlSessionFactory().openSession();
//		try {
//
//			String id = "A0EEBC99-9C0B-4EF8-BB6D-6BB9BD380A11";
//			Policy policy = session.selectOne("com.qiye.postgrejson.policyMapper.selectOnePolicy", id);
//			System.out.println("---" + policy);
//		} finally {
//			session.close();
//		}
//	}

	@Test
	public void addPolicyJsonb() {
		SqlSession session = SessionFactoryManager.getSqlSessionFactory().openSession();
		try {
			long start = System.currentTimeMillis();
			for(int i = 0; i< 1000000; i++){
				session.insert("com.qiye.postgrejson.policyMapper.insertPolicyJsonb", this.getPolicy());
				if(i % 500 == 0){
					session.commit();
				}
			}
			session.commit();
			long end = System.currentTimeMillis();
			System.out.println("jsonb duration:" + (end - start) / 1000);
		} finally {
			session.close();
		}
	}
	@Test
	public void addPolicyVarchar() {
		SqlSession session = SessionFactoryManager.getSqlSessionFactory().openSession();
		try {
			long start = System.currentTimeMillis();
			for(int i = 0; i< 1000000; i++){
				session.insert("com.qiye.postgrejson.policyMapper.insertPolicyVarchar", this.getPolicy());
				if(i % 500 == 0){
					session.commit();
				}
			}
			session.commit();
			long end = System.currentTimeMillis();
			System.out.println("varchar duration:" + (end - start) / 1000);
		} finally {
			session.close();
		}
	}
	@Test
	public void addPolicyJson() {
		SqlSession session = SessionFactoryManager.getSqlSessionFactory().openSession();
		try {
			long start = System.currentTimeMillis();
			for(int i = 0; i< 1000000; i++){
				session.insert("com.qiye.postgrejson.policyMapper.insertPolicyJson", this.getPolicy());
				if(i % 500 == 0){
					session.commit();
				}
			}
			session.commit();
			long end = System.currentTimeMillis();
			System.out.println("json duration:" + (end - start) / 1000);
		} finally {
			session.close();
		}
	}
	@Test
	public void addPolicyText() {
		SqlSession session = SessionFactoryManager.getSqlSessionFactory().openSession();
		try {
			long start = System.currentTimeMillis();
			for(int i = 0; i< 1000000; i++){
				session.insert("com.qiye.postgrejson.policyMapper.insertPolicyText", this.getPolicy());
				if(i % 500 == 0){
					session.commit();
				}
			}
			session.commit();
			long end = System.currentTimeMillis();
			System.out.println("text duration:" + (end - start) / 1000);
		} finally {
			session.close();
		}
	}
	private Policy getPolicy(){
		String id = UUID.randomUUID().toString();
		JSONObject jo = new JSONObject("{\"id\":\"03c6aaf9-cf97-49ab-b672-21bc492b5198\",\"_rev\":\"1-04d744366af69e7ff1f78f2a75389823\",\"type\":\"AutoScalerPolicy\",\"policyId\":\"03c6aaf9-cf97-49ab-b672-21bc492b5198\",\"policyName\":\"ScalingHistoryTest\",\"instanceMinCount\":1,\"instanceMaxCount\":5,\"policyTriggers\":[{\"metricType\":\"HEAPMEMORY\",\"statType\":\"avg\",\"statWindow\":60,\"breachDuration\":60,\"lowerThreshold\":30,\"upperThreshold\":80,\"instanceStepCountDown\":-1,\"instanceStepCountUp\":1,\"stepDownCoolDownSecs\":30,\"stepUpCoolDownSecs\":30,\"startTime\":0,\"endTime\":0,\"startSetNumInstances\":10,\"endSetNumInstances\":10,\"unit\":\"percent\",\"scaleInAdjustmentType\":\"changeCapacity\",\"scaleOutAdjustmentType\":\"changeCapacity\"}],\"scheduledPolicies\":{}}");
		jo.put("id", UUID.randomUUID().toString());
		String policy = jo.toString();
		Policy p = new Policy();
		p.setAppId(id);
		p.setPolicy(policy);
		return p;
	}

}
