package simple.test.rpctest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;

import simple.test.rpctest.common.OrgService;
import simple.test.rpctest.dao.OrgDao;
import simple.test.rpctest.entity.Org;

@Service
@SofaService(interfaceType = OrgService.class, bindings = { @SofaServiceBinding(bindingType = "bolt") })
public class OrgServiceImp implements OrgService{
	@Autowired
	private OrgDao dao;
	
	
	public List<Org> getOrgs() {
		return  dao.findAll(Arrays.asList(1L,2L));
	}


	public void addOrg(String code, String name, Long parentId) {
		Org newOrg = new Org();
		newOrg.setOrgCode(code);
		newOrg.setOrgName(name);
		newOrg.setActived(true);
		if(parentId!=null) {
			Org porg = dao.findOne(parentId);
			newOrg.setParent(porg);
		}
		System.out.println(JSON.toJSON(newOrg));
		dao.save(newOrg);
	}

}
