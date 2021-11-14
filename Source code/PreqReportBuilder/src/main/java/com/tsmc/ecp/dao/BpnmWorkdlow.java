/**
 * 
 */
package com.tsmc.ecp.dao;

import org.springframework.stereotype.Component;

import com.tsmc.ecp.model.User;

/**
 *
 */
@Component
public class BpnmWorkflow {


	public Map<String, String> setParamF18Lorry() {

		Map<String, String> rtnParam = HashMap<String, String> (); 
		
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

	 }

	 public Map<String, String> setParamF15BLorry() {

		Map<String, String> rtnParam = HashMap<String, String> (); 
		
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


	 }

	 public Map<String, String> setParamAutoPirun() {

		Map<String, String> rtnParam = HashMap<String, String> (); 
		
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

	 }


	public User getUserById(Integer id) {
		
		return null;
	}

	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return Integer.MIN_VALUE; 
	}
}
