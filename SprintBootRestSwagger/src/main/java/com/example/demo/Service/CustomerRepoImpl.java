package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.CustomerEntity;

@Service
public class CustomerRepoImpl implements CustomerRepo {

	List<CustomerEntity> custList;

	public CustomerRepoImpl() {

		custList = new ArrayList<>();

		custList.add(new CustomerEntity(1, "Amir", "IT Analyst"));
		custList.add(new CustomerEntity(2, "Adil", "System Engineer"));
		custList.add(new CustomerEntity(3, "Urmi", "Software Developer"));

	}

	@Override
	public List<CustomerEntity> getAllCustomer() {
		return custList;
	}

	@Override
	public CustomerEntity getCustomer(int cid) {

		CustomerEntity c = null;
		System.out.println(cid);

		for (CustomerEntity clist : custList) {
			if (clist.getCid() == cid) {
				c = clist;
				break;
			}
		}

		return c;
	}

	@Override
	public CustomerEntity postCustomer(CustomerEntity cust) {

		custList.add(cust);

		return cust;
	}

	@Override
	public CustomerEntity updateCustomer(CustomerEntity cust) {
		
		int flag=0;
		for(CustomerEntity lst:custList)
		{
			if(lst.getCid() == cust.getCid())
			{
				lst.setCname(cust.getCname());
				lst.setCjob(cust.getCjob());
				flag=1;
				break;
			}

		}
		
		if (flag == 0)
			custList.add(cust);
		
		return cust;
	}

	@Override
	public String deleteCustomer(int cid) {
		
		int flag=0; int i=0;
		for(CustomerEntity lst : custList)
		{
			if(lst.getCid() == cid)
			{
				custList.remove(lst);
				i++;
				flag=1;
				break;
			}
			
		}
		
		if(flag == 0)
			return "Value Not Found";
		else
			return "Value successfully deleted";
	}

}
