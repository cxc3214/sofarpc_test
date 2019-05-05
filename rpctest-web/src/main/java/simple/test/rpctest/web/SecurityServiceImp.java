package simple.test.rpctest.web;

import org.springframework.stereotype.Service;

import com.alipay.sofa.rpc.context.RpcInvokeContext;
import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;

import simple.test.rpctest.common.SecurityService;

@Service
@SofaService(interfaceType = SecurityService.class, bindings = { @SofaServiceBinding(bindingType = "bolt") })
public class SecurityServiceImp implements SecurityService{

	public String getCurUser() {
		RpcInvokeContext ctx = RpcInvokeContext.getContext();
		ctx.putRequestBaggage("userid", "cxc");
		return "当前用户信息";
	}

}
