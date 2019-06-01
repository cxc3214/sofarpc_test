package simple.test.rpctest.common;

import java.util.List;

import simple.test.rpctest.entity.Org;

public interface OrgService {
	public List<Org> getOrgs();
	
	public void addOrg(String code,String name,Long parentId);
}
