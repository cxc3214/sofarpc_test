package simple.test.rpctest.filter;

import java.util.HashMap;
import java.util.Map;

import com.alipay.sofa.rpc.context.RpcInvokeContext;
import com.alipay.sofa.rpc.core.request.SofaRequest;
import com.alipay.sofa.rpc.core.response.SofaResponse;
import com.alipay.sofa.rpc.ext.Extension;
import com.alipay.sofa.rpc.filter.AutoActive;
import com.alipay.sofa.rpc.filter.Filter;
import com.alipay.sofa.rpc.filter.FilterInvoker;

@Extension("userExt")
@AutoActive(providerSide = true, consumerSide = true)
public class UserFilter extends Filter {

    @Override
    public SofaResponse invoke(FilterInvoker invoker, SofaRequest request) {
    	RpcInvokeContext context = RpcInvokeContext.getContext();
    	Map<String,String> tmap = new HashMap<String, String>();
    	tmap.put("a", "aaaaaaaaaaaaaaaaaaa");
    	tmap.put("b", "bbbbbbbbbbbbbbbbb");
    	context.putAllRequestBaggage(tmap);
    	context.putAllResponseBaggage(tmap);
    	SofaResponse response = invoker.invoke(request);
    	return response;
//        RpcInternalContext context = RpcInternalContext.getContext();
//        if (context.isProviderSide()) {
//        	
//            String token = (String) request.getRequestProp("token");
//            if ("123456".equals(token)) {
//                return invoker.invoke(request);
//            } else {
//                SofaResponse resp = new SofaResponse();
//                resp.setErrorMsg("ERR-403");
//                return resp;
//            }
//        } else {
//            request.addRequestProp("token", "123456");
//            SofaResponse response = invoker.invoke(request);
//            if ("ERR-403".equals(response.getErrorMsg())) {
//                throw new SofaRpcException(RpcErrorType.UNKNOWN, "Token not found");
//            }
//            return response;
//        }
    }
}
