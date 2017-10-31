package org.smart4j.client.service;

import org.smart4j.client.model.Customer;
import org.smart4j.framework.annotation.Service;
import org.smart4j.framework.annotation.Transaction;
import org.smart4j.framework.bean.FileParam;
import org.smart4j.framework.helper.DatabaseHelper;
import org.smart4j.framework.helper.UploadHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yuezhang on 17/10/6.
 */
@Service
public class CustomerService {

    /**
     * 获取客户列表
     * @return
     */
    public List<Customer> getCustomerList(){
        String sql = "SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class,sql);
    }

    /**
     * 获取客户
     * @param id
     * @return
     */
    public Customer getCustomer(long id){
        String sql = "SELECT * FROM customer WHERE id=" + id;
        return DatabaseHelper.getEntity(Customer.class,sql);
    }

    /**
     * 创建客户
     * @param fieldMap
     * @return
     */
    @Transaction
    public boolean createCustomer(Map<String,Object> fieldMap,FileParam fileParam){
        boolean result = DatabaseHelper.insertEntity(Customer.class,fieldMap);
        if(result){
            UploadHelper.uploadFile("/tmp/upload",fileParam);
        }
        return result;
    }

    /**
     * 更新客户
     * @param id
     * @param fieldMap
     * @return
     */
    public boolean updateCustomer(long id , Map<String,Object> fieldMap){
        return DatabaseHelper.updateEntity(Customer.class,id,fieldMap);
    }

    /**
     * 删除客户
     * @param id
     * @return
     */
    public boolean deleteCustomer(long id){
        return DatabaseHelper.deleteEntity(Customer.class,id);
    }
}
