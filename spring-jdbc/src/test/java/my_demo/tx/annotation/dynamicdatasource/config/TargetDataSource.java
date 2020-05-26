package my_demo.tx.annotation.dynamicdatasource.config;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface TargetDataSource {
	String value() default "ds1";
}
