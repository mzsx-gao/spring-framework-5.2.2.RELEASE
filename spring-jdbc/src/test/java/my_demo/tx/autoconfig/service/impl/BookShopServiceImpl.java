package my_demo.tx.autoconfig.service.impl;

import my_demo.tx.autoconfig.dao.BookShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.ConnectionHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;

@Service("bookShopServiceImpl")
public class BookShopServiceImpl {

    @Autowired
    private BookShopDao bookShopDao;
    @Autowired
    private DataSource dataSource;

    //循环依赖
    @Autowired
    private BookShopServiceImpl bookShopService;

    /**
        添加事务注解
        1.使用 propagation 指定事务的传播行为, 即当前的事务方法被另外一个事务方法调用时如何使用事务;
            REQUIRED(默认值):使用调用方法的事务
            REQUIRES_NEW:使用自己的事务, 调用事务方法的事务被挂起
        2.使用 isolation 指定事务的隔离级别, 最常用的取值为 READ_COMMITTED
        3.默认情况下 Spring 的声明式事务对所有的运行时异常进行回滚. 也可以通过对应的属性进行设置. 通常情况下去默认值即可.
        4.使用 readOnly 指定事务是否为只读. 表示这个事务只读取数据但不更新数据,这样可以帮助数据库引擎优化事务. 若真的是一个
        只读取数据库值的方法, 应设置 readOnly=true
        5.使用 timeout 指定强制回滚之前事务可以占用的时间
     */
    /*@Transactional(propagation=Propagation.REQUIRED,
            isolation= Isolation.READ_COMMITTED,
            readOnly=false,
            timeout=3)*/
    @Transactional(propagation= Propagation.REQUIRED)
    public void purchase(String username, String isbn) {
        //1. 获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);
        //2. 更新书的库存
        bookShopDao.updateBookStock(isbn);
        //3. 更新用户余额
        bookShopDao.updateUserAccount(username, price);
    }

    //测试嵌套事务
//    @Transactional(propagation= Propagation.REQUIRED)
//    @Transactional(propagation= Propagation.REQUIRES_NEW)
    @Transactional(propagation= Propagation.NESTED)
    public void updateBookStock2(String isbn) {
        ConnectionHolder connectionHolder = (ConnectionHolder) TransactionSynchronizationManager.getResource(dataSource);
        System.err.println("连接对象ConnectionHolder的hashCode:"+connectionHolder.hashCode());
        //更新书的库存
        bookShopDao.updateBookStock(isbn);
        //添加事务同步回调接口，这样在事务执行的各个阶段，spring会控制回调对应的方法
        TransactionSynchronizationManager.registerSynchronization(
                new TransactionSynchronizationAdapter() {
                    @Override
                    public void beforeCompletion() {
                        System.out.println("beforeCompletion========");
                    }
                    @Override
                    public void afterCompletion(int status) {
                        System.out.println("afterCompletion========");
                    }
                    @Override
                    public void beforeCommit(boolean readOnly) {
                        System.out.println("beforeCommit========");
                    }
                    @Override
                    public void afterCommit() {
                        System.out.println("afterCommit========");
                    }
                }
        );
    }

    /**
     * 测试外层事务try-catch问题,内层事务是REQUIRED
     */
    @Transactional(propagation= Propagation.REQUIRED)
    public void updateBookStock(String isbn) {
        ConnectionHolder connectionHolder = (ConnectionHolder) TransactionSynchronizationManager.getResource(dataSource);
        System.err.println("连接对象ConnectionHolder的hashCode:"+connectionHolder.hashCode());
        //更新书的库存
        bookShopDao.updateBookStock(isbn);
    }
    //更新用户余额
    @Transactional(propagation= Propagation.REQUIRED)
    public void updateUserAccount(String username, String isbn) {
        ConnectionHolder connectionHolder = (ConnectionHolder) TransactionSynchronizationManager.getResource(dataSource);
        System.err.println("连接对象ConnectionHolder的hashCode:"+connectionHolder.hashCode());
        //获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);
        //更新用户余额
        bookShopDao.updateUserAccount(username, price);
        if(true){
            throw new RuntimeException("模拟异常");
        }
    }

    /**
     * 测试外层事务try-catch问题,内层事务是NESTED
     */
    @Transactional(propagation= Propagation.NESTED)
    public void updateBookStock3(String isbn) {
        ConnectionHolder connectionHolder = (ConnectionHolder) TransactionSynchronizationManager.getResource(dataSource);
        System.err.println("连接对象ConnectionHolder的hashCode:"+connectionHolder.hashCode());
        //更新书的库存
        bookShopDao.updateBookStock(isbn);
    }
    //更新用户余额
    @Transactional(propagation= Propagation.NESTED)
    public void updateUserAccount3(String username, String isbn) {
        ConnectionHolder connectionHolder = (ConnectionHolder) TransactionSynchronizationManager.getResource(dataSource);
        System.err.println("连接对象ConnectionHolder的hashCode:"+connectionHolder.hashCode());
        //获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);
        //更新用户余额
        bookShopDao.updateUserAccount(username, price);
        if(true){
            throw new RuntimeException("模拟异常");
        }
    }
}