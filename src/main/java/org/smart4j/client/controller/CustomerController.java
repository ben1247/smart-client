package org.smart4j.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Inject
    private CustomerService customerService;

    /**
     * 客户列表页面
     * @param param
     * @return
     */
    @Action("get:/customer")
    public View customerListPage(Param param){
        List<Customer> customerList = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList",customerList);
    }

    /**
     * 进入客户编辑页面
     * @return
     */
    @Action("get:/customer_edit_page")
    public View customerEditPage(Param param){
        return new View("customerEdit.jsp");
    }

    /**
     * 处理创建客户请求
     * @param param
     * @return
     */
    @Action("post:/customer_create")
    public Data createSubmit(Param param){

        try {
            customerService.createCustomer(param.getMap());
        }catch (Exception e){
            LOGGER.error(e.getMessage(),e);
        }

        Customer customer = new Customer();
//        customer.setId(param.getLong("id"));
        customer.setName(param.getString("name"));
        customer.setContact(param.getString("contact"));
        customer.setTelephone(param.getString("telephone"));
        customer.setEmail(param.getString("email"));
        return new Data(customer);
    }

}
