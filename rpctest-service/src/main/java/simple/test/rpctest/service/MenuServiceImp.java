package simple.test.rpctest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alipay.sofa.rpc.context.RpcInvokeContext;
import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;

import simple.test.rpctest.common.MenuService;

@Service
@SofaService(interfaceType = MenuService.class, bindings = { @SofaServiceBinding(bindingType = "bolt") })
public class MenuServiceImp implements MenuService {
	@Autowired
	private UserService userService;
		
	public String getMenuString() {
		
		return userService.getCurUser();
	}

}
