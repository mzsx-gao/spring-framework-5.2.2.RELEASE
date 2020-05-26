package my_demo.tx.annotation.dynamicdatasource.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@ComponentScan(value="my_demo.tx.annotation")
@PropertySource("classpath:my-demo/jdbc.properties")
@EnableAspectJAutoProxy
public class MyRootConfig {

	@Value("${driver}")
	private String driverClass;
	@Value("${url}")
	private String jdbcUrl;
	@Value("${username}")
	private String user;
	@Value("${password}")
	private String password;

	@Bean
	public DataSource dynamicDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(jdbcUrl);
		dataSource.setUsername(user);
		dataSource.setPassword(password);

		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put("ds1",dataSource);

		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		dynamicDataSource.setTargetDataSources(targetDataSources);
		dynamicDataSource.setDefaultTargetDataSource(dataSource);
		return dynamicDataSource;
	}

	@Bean
	JdbcTemplate jdbcTemplate(DataSource dataSource){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;
	}
}
