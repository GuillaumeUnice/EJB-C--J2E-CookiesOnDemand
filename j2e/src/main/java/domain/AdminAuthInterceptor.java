package domain;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Created by Tom Veniat on 17/05/15.
 */
public class AdminAuthInterceptor {
    @EJB
    private Authentifier authentifierBean;

    @AroundInvoke
    public Object connect(InvocationContext context) throws Exception{
        System.out.println("# - Intercepted Call to : " + context.getMethod().getName());
        for (Object obj : context.getParameters())
            System.out.println("+arg : "+obj);
        if(authentifierBean.connect("ADMIN",(String)context.getParameters()[context.getParameters().length-1]))
            return context.proceed();
        else
            return null;
    }
}
