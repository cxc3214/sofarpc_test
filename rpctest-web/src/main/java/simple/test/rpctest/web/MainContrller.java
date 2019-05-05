package simple.test.rpctest.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;

import simple.test.rpctest.common.MenuService;

@RestController
public class MainContrller {
	@SofaReference(interfaceType = MenuService.class,  binding = @SofaReferenceBinding(bindingType = "bolt"))
	private MenuService menuService;
	
	
	@RequestMapping("/")
	public String main() {
		return menuService.getMenuString();
	}
	
	
}
