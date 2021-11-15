/**
 * 
 */
package com.tsmc.ecp.dao;

import org.springframework.stereotype.Component;

import com.tsmc.ecp.model.User;

import java.util.Map;
import java.util.HashMap;

/**
 *
 */
@Component
public class BpnmWorkflow {


	public Map<String, String> setParamF18Lorry
			(String caseId, String pkgType, String matNo, String batchId, String facEqpId, String phase,
			 String toolId, String chamber, String modelIdList, String cwcpOrderId) {

		Map<String, String> rtnParam = new HashMap<>();
		
		rtnParam.put("fabName", ""); //
		//rtnParam.put("areaName", areaName); /// Lorry
		rtnParam.put("caseId", caseId);
		rtnParam.put("pkgType", pkgType);
		rtnParam.put("matNo", matNo); //
		rtnParam.put("batchId", batchId);
		rtnParam.put("facEqpId", facEqpId);
		rtnParam.put("phase", phase);
		rtnParam.put("toolId", toolId);
		rtnParam.put("chamberId", chamber); 
		rtnParam.put("modelIdList", modelIdList);
		rtnParam.put("cwcpOrderId", cwcpOrderId); //
		rtnParam.put("", "0"); 
		return rtnParam;
	 }

	 public Map<String, String> setParamF15BLorry
			 (String caseId, String pkgType, String matNo, String batchId, String facEqpId, String phase,
			  String toolId, String chamber, String modelIdList, String cwcpOrderId) {

		Map<String, String> rtnParam = new HashMap<>();
		
		rtnParam.put("fabName", ""); //
		//rtnParam.put("areaName", areaName); /// Lorry
		rtnParam.put("caseId", caseId);
		rtnParam.put("pkgType", pkgType);
		rtnParam.put("matNo", matNo); //
		rtnParam.put("batchId", batchId);
		rtnParam.put("facEqpId", facEqpId);
		rtnParam.put("phase", phase);
		rtnParam.put("toolId", toolId);
		rtnParam.put("chamberId", chamber); 
		rtnParam.put("modelIdList", modelIdList);
		rtnParam.put("cwcpOrderId", cwcpOrderId); //
		rtnParam.put("", "0");
		 return rtnParam;
	 }

	 public Map<String, String> setParamAutoPirun(
			 String caseId, String pkgType, String matNo, String batchId, String facEqpId, String phase,
			 String toolId, String chamber, String modelIdList, String cwcpOrderId) {

		Map<String, String> rtnParam = new HashMap<>();
		
		rtnParam.put("fabName", ""); //
		//rtnParam.put("areaName", areaName); /// Lorry
		rtnParam.put("caseId", caseId); 
		rtnParam.put("pkgType", pkgType);
		rtnParam.put("matNo", matNo); //
		rtnParam.put("batchId", batchId);
		// ////////////////// This is Sherry //////////////////////////
		rtnParam.put("facEqpId", facEqpId);
		rtnParam.put("phase", phase);
		rtnParam.put("toolId", toolId);
		rtnParam.put("chamberId", chamber); 
		rtnParam.put("modelIdList", modelIdList);
		rtnParam.put("cwcpOrderId", cwcpOrderId); //
		rtnParam.put("", "0");
		 return rtnParam;
	 }


	public User getUserById(Integer id) {
		
		return null;
	}

	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return Integer.MIN_VALUE; 
	}
}
