package org.smart4j.client.controller;

import org.smart4j.client.model.Customer;
import org.smart4j.client.service.CustomerService;
import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.bean.Data;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.bean.View;

import java.util.List;

/**
 * 处理客户管理相关请求
 * Created by yuezhang on 17/10/6.
 */
@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;

    /**
     * 客户列表
     * @param param
     * @return
     */
    @Action("get:/customer")
    public View index(Param param){
        List<Customer> customerList = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList",customerList);
    }

    /**
     * 处理创建客户请求
     * @param param
     * @return
     */
    @Action("post:/customer_create")
    public Data createSubmit(Param param){
        Customer c1 = new Customer();
        c1.setId(1L);
        c1.setName("customer1");
        c1.setContact("Jack");
        c1.setTelephone("13918648191");
        c1.setEmail("jack@gmail.com");
        return new Data(c1);
    }

}