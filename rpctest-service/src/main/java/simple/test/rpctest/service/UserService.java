package simple.test.rpctest.service;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alipay.sofa.rpc.context.RpcInvokeContext;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;

import simple.test.rpctest.common.SecurityService;

@Service
public class UserService {
	
	
	@SofaReference(interfaceType = SecurityService.class, jvmFirst = false, binding = @SofaReferenceBinding(bindingType = "bolt"))
	private SecurityService securityService;
	
	
	
	public String getCurUser() {
		final String curUser = securityService.getCurUser();
		RpcInvokeContext ctx = RpcInvokeContext.getContext();
		
		String msg  = JSON.toJSONString(RpcInvokeContext.getContext().getAllRequestBaggage());
		String msg1  = JSON.toJSONString(RpcInvokeContext.getContext().getAllResponseBaggage());
		System.out.println(msg);
		System.out.println(msg1);
		
		String user = ctx.getResponseBaggage("userid");
		String fuserid = ctx.getRequestBaggage("b");
		return curUser +"rpcuser:"+user +", fuserId: "  + fuserid;
	}
	
}
