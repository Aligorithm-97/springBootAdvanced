package com.example.springadvanced.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExample {


    @Pointcut("execution(* com.example.springadvanced.aop.CounterService.*(String)) && args(xyz)")
    public void interceptor(String xyz) {

    }

    @Before("interceptor(xyz)")
    public void bmethod2(JoinPoint joinPointParam,
                         String xyz) {
        System.out.println("@Before Çalıştım. Parametre : " + xyz + " - " + joinPointParam.toLongString());
    }

    @After("interceptor(xyz)")
    public void amethod2(JoinPoint joinPointParam,
                         String xyz) {
        System.out.println("@After Çalıştım. Parametre : " + xyz + " - " + joinPointParam.toLongString());
    }

    @Before("execution(* com.example.springadvanced.aop.CounterService.*(String)) && args(xyz)")
    public void bmethod(JoinPoint joinPointParam,
                        String xyz) {
        System.out.println("@Before Çalıştım. Parametre : " + xyz + " - " + joinPointParam.toLongString());
    }

    @After("execution(* com.example.springadvanced.aop.CounterService.*(String)) && args(xyz)")
    public void amethod(JoinPoint joinPointParam,
                        String xyz) {
        System.out.println("@After Çalıştım. Parametre : " + xyz + " - " + joinPointParam.toLongString());
    }

    @AfterReturning(value = "execution(* com.example.springadvanced.aop.CounterService.*(String)) && args(xyz)",
            returning = "retLong")
    public void armethod(JoinPoint joinPointParam,
                         String xyz,
                         long retLong) {
        System.out.println("@AfterReturning Çalıştım. Parametre : "
                + xyz
                + " return : "
                + retLong
                + " - "
                + joinPointParam.toLongString());
    }

    @Around("execution(* com.example.springadvanced.aop.CounterService.*(String))")
    public Object aroundMethod(ProceedingJoinPoint joinPointParam) {
        try {
            Object[] argsLoc    = joinPointParam.getArgs();
            Object[] newArgsLoc = new Object[1];
            newArgsLoc[0] = "mehmet";
            Object proceedLoc = joinPointParam.proceed(newArgsLoc);
            if (proceedLoc instanceof String) {
                String stringLoc = (String) proceedLoc;
                System.out.println("Method returned String : " + stringLoc);
            } else if (proceedLoc instanceof Long) {
                Long longLoc = (Long) proceedLoc;
                System.out.println("Method returned Long : " + longLoc);
                return 10000;
            }
            return proceedLoc;
        } catch (Throwable eParam) {
            throw new RuntimeException(eParam);
        }
    }

    @Around("@annotation(deltaTime)")
    public Object aroundMethod2(ProceedingJoinPoint joinPointParam,
                                DeltaTime deltaTime) {
        try {
            long   delta      = System.nanoTime();
            Object proceedLoc = joinPointParam.proceed();
            delta = System.nanoTime() - delta;
            System.out.println("Delta for : " + joinPointParam.toShortString() + " delta : " + delta);
            return proceedLoc;
        } catch (Throwable eParam) {
            throw new RuntimeException(eParam);
        }
    }

}
