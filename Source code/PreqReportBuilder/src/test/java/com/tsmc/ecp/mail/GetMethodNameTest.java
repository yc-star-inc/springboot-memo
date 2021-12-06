package com.tsmc.ecp.mail;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsmc.ecp.model.ReqInputObject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Method;

public class GetMethodNameTest {

    private static Logger logger;

    static {
        logger = LoggerFactory.getLogger(GetMethodNameTest.class);
    }

    /// The fastest way I found is that:
    // save it static to have it available on every call
    private static Method m;

    /// Getting the name of the currently executing method
    static {
        try {
            m = Throwable.class.getDeclaredMethod("getStackTraceElement",
                    int.class);
            m.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getMethodName(final int depth) {
        try {
            StackTraceElement element = (StackTraceElement) m.invoke(
                    new Throwable(), depth + 1);
            return element.getMethodName();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void test() throws JsonProcessingException {


        logger.info("Testing");

        reqObj.setParams(params);

        ObjectMapper mapper = new ObjectMapper();
        String fRslt = mapper.writeValueAsString(reqObj);


    }

    /// Thread.currentThread().getStackTrace()[1].getMethodName()

    /// 188
    // ==> Thread.currentThread().getStackTrace()
    // will usually contain the method you’re calling it from but there are pitfalls (see Javadoc):
    // Some virtual machines may, under some circumstances, omit one or more stack frames from the stack trace.
    // In the extreme case, a virtual machine that has no stack trace information concerning this thread is permitted to return a zero-length array from this method.



    // /Java Reflection Performance
    //    191
//    Yes - absolutely. Looking up a class via reflection is, by magnitude, more expensive.
//    Quoting Java's documentation on reflection:
//    Because reflection involves types that are dynamically resolved, certain Java virtual machine optimizations can not be performed. Consequently, reflective operations have slower performance than their non-reflective counterparts, and should be avoided in sections of code which are called frequently in performance-sensitive applications.
//    Here's a simple test I hacked up in 5 minutes on my machine, running Sun JRE 6u10:

    public static void main(String[] args) throws Exception
    {
        doRegular();
        doReflection();
    }

    public static void doRegular() throws Exception
    {
        long start = System.currentTimeMillis();
        for (int i=0; i<1000000; i++)
        {
            A a = new A();
            a.doSomeThing();
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void doReflection() throws Exception
    {
        long start = System.currentTimeMillis();
        for (int i=0; i<1000000; i++)
        {
            A a = (A) Class.forName("misc.A").newInstance();
            a.doSomeThing();
        }
        System.out.println(System.currentTimeMillis() - start);
    }

}
