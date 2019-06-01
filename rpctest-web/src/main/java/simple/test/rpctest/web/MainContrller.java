package simple.test.rpctest.web;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;

import simple.test.rpctest.common.MenuService;
import simple.test.rpctest.common.OrgService;
import simple.test.rpctest.entity.Org;

@RestController
public class MainContrller {
	
	@SofaReference(interfaceType = MenuService.class,  binding = @SofaReferenceBinding(bindingType = "bolt"))
	private MenuService menuService;
	
	@SofaReference(interfaceType = OrgService.class,  binding = @SofaReferenceBinding(bindingType = "bolt"))
	private OrgService orgService;
	
	
	@RequestMapping("/")
	public String main() {
		return menuService.getMenuString();
	}
	
	@RequestMapping("/orgs")
    public List<Org> getOrgs() {
    	return orgService.getOrgs();
    }
	
	
	@RequestMapping("/add")
    public String addOrg() {
		orgService.addOrg("3204", "常州", null);
		orgService.addOrg("3202", "无锡", null);
    	return "ok";
    }
	
}
