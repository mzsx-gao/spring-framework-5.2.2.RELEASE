package my_demo.tx.autoconfig.service.impl;

import my_demo.tx.autoconfig.service.BookShopService;
import my_demo.tx.autoconfig.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.ConnectionHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.util.List;

@Service("cashier")
public class CashierImpl implements Cashier {

	@Autowired
	private BookShopService bookShopService;
	@Autowired
	private DataSource dataSource;
	
	@Transactional
	@Override
	public void checkout(String username, List<String> isbns) {
		ConnectionHolder connectionHolder = (ConnectionHolder) TransactionSynchronizationManager.getResource(dataSource);
		System.out.println("连接对象ConnectionHolder的hashCode:"+connectionHolder.hashCode());
		for(String isbn: isbns){
			bookShopService.purchase(username, isbn);
		}
	}

}
