package my_demo.tx.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

//定时器功能，这个不需要切面，在启动时就找到对应的带@Scheduled注解的方法定时执行
@EnableScheduling
//异步执行功能，切面
@EnableAsync(proxyTargetClass = true)
@ComponentScan
@Configuration
//源码实现的拦截器是AnnotationAsyncExecutionInterceptor
public class AsyncConfig {

    private int corePoolSize = 10;
    private int maxPoolSize = 200;
    private int queueCapacity = 10;
    private String ThreadNamePrefix = "GaoExecutor-";

    @Bean
    public Executor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(ThreadNamePrefix);

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}