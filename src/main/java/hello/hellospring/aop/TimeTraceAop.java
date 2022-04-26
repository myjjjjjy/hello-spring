package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    // joinPoint가 호출될떄마마다 중간에서 시간 찍어줌
    @Around("execution(* hello.hellospring..*(..))") // 원하는 조건 넣어주면 됨. 지금은 하위패키지에 다 적용되게 해놓은것.
    // 만약 서비스에만 측정하고 싶다? (* hello.hellospring.service..*(..))"
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START : "+joinPoint.toString());
        try{
            return joinPoint.proceed();
    }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : "+joinPoint.toString()+" "+timeMs+"ms");
        }
    }
}
