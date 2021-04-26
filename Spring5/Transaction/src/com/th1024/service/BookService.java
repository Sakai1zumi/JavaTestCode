package com.th1024.service;

import com.th1024.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author TuHong
 * @create 2021-04-19 15:54
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    /*
    事务细节
    isolation-Isolation：事务的隔离级别

    noRollbackFor-Class[]：哪些异常事务可以不回滚
    noRollbackForClassName-String[]：String异常的全类名

    rollbackFor-Class[]：哪些异常事务需要回滚
    rollbackForClassName-String[]

    异常分类：
        运行时异常（非检查异常）：可以不处理，默认都回滚
        编译时异常（检查异常）：需要处理--try-catch或者throws，默认不回滚
   noRollbackFor = {ArithmeticException.class,NullPointerException.class}
   rollbackFor：原本不回滚的异常指定让其回滚

   readOnly-boolean：设置事务为只读事务
       readOnly=true--进行事务优化，加快查询速度

   timeout-int（以秒为单位）：设置超时属性，事务超出指定执行时长后自动终止并回滚

   propagation-Propagation：事务的传播行为
   传播行为（事务的传播+事务行为）；
       如果有多个事务嵌套运行，子事务是否要和大事务共用一个事务
       REQUIRES_NEW：开启一个新事务（直接使用新的connection）
       REQUIRED：与大事务共用一个事务，并且继承大事务的属性

       AService{
           tx_a(){
                //a的一些方法
                tx_b(){
                }
                tx_c(){
                }
           }
       }

     */

    //结账，传入哪个顾客购买了哪本书
    @Transactional(propagation = Propagation.REQUIRES_NEW) //添加事务控制注解
    public void checkout(String username,String isbn){
        //1. 修改库存
        bookDao.updateStock(isbn);
        //2. 获取书本价格
        int price = bookDao.getPrice(isbn);

        //模拟网络阻塞
//        int i = 10/0;

        //2. 修改用户余额
        bookDao.updateBalance(username,price);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updatePrice(String isbn,int price){
        bookDao.updatePrice(isbn,price);
    }
}
