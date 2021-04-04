package my_demo.tx.dynamicdatasource;

import my_demo.tx.dynamicdatasource.config.TargetDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@TargetDataSource("ds1")
	public void test(String isbn) {
		String sql = "SELECT price FROM book WHERE isbn = ?";
		System.out.println(jdbcTemplate.queryForObject(sql, Integer.class, isbn));
	}

}
