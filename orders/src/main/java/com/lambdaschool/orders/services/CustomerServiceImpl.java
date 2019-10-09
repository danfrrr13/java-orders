package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository custrepos;

    @Override
    public List<Customer> findAll() {
        List<Customer> rtnList = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(rtnList::add);

        return rtnList;
    }

//    private String custcity;
//    private String workingarea;
//    private String custcountry;
//    private String grade;
//    private double openingamt;
//    private double receiveamt;
//    private double paymentamt;
//    private double outstandingamt;
//    private String phone;
//    private List<Order> orders = new ArrayList<>();

    @Transactional
    @Override
    public Customer save(Customer customer) {
        Customer newCustomer = new Customer();

        newCustomer.setAgent(customer.getAgent());
        newCustomer.setCustname(customer.getCustname());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPhone(customer.getPhone());

        for (Order o : customer.getOrders()) {
            newCustomer.getOrders().add(new Order(o.getOrdamount(), o.getAdvanceamount(), o.getCustomer(), o.getOrderscription()));
        }

        return custrepos.save(newCustomer);
    }

    @Override
    public Customer update(Customer customer, long id) {
        return custrepos.save(customer);
    }

    @Override
    public void delete(long id) {
        custrepos.deleteById(id);
    }
}
