package my_demo.tx.dynamicdatasource.config;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface TargetDataSource {
	String value() default "ds1";
}
