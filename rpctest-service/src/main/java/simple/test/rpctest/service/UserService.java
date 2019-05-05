package simple.test.rpctest.service;

import org.springframework.stereotype.Service;

import com.alipay.sofa.rpc.context.RpcInvokeContext;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;

import simple.test.rpctest.common.SecurityService;

@Service
public class UserService {
	
	
	@SofaReference(interfaceType = SecurityService.class, jvmFirst = false, binding = @SofaReferenceBinding(bindingType = "bolt"))
	private SecurityService securityService;
	
	
	
	public String getCurUser() {
		RpcInvokeContext ctx = RpcInvokeContext.getContext();
		String user = ctx.getRequestBaggage("userid");
		return securityService.getCurUser()+"rpcuser:"+user;
	}
	
}
