package domain;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Created by Tom Veniat on 16/05/15.
 */
public class AuthInterceptor {

    @EJB
    private Authentifier authentifierBean;

    @AroundInvoke
    public Object connect(InvocationContext context) throws Exception{
        System.out.println("# - Intercepted Call to : " + context.getMethod().getName());
        for (Object obj : context.getParameters())
            System.out.println("+arg : "+obj);
        Object[] params = context.getParameters();
        if(authentifierBean.connect((String)params[params.length-2],(String)params[params.length-1]))
            return context.proceed();
        else
            return null;
    }
}
