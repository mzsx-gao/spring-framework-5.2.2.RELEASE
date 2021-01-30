package my_demo.tx.autoconfig.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.ConnectionHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;

@Service("cashier")
public class CashierImpl {

    @Autowired
    private BookShopServiceImpl bookShopService;
    @Autowired
    private DataSource dataSource;

    @Transactional
    public void checkout(String username, String isbn) {
        ConnectionHolder connectionHolder = (ConnectionHolder) TransactionSynchronizationManager.getResource(dataSource);
        System.err.println("连接对象ConnectionHolder的hashCode:"+connectionHolder.hashCode());
        bookShopService.updateBookStock2(isbn);//更新库存
    }

    @Transactional
    public void checkout2(String username, String isbn) {
        try{
            bookShopService.updateBookStock(isbn);//更新库存
            bookShopService.updateUserAccount(username, isbn);//更新账户余额
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional
    public void checkout3(String username, String isbn) {
        try{
            bookShopService.updateBookStock3(isbn);//更新库存
            bookShopService.updateUserAccount3(username, isbn);//更新账户余额
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
