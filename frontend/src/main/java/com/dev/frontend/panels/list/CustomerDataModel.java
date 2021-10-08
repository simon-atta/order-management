package com.dev.frontend.panels.list;

import java.util.List;

import com.dev.frontend.services.Services;

import io.swagger.client.model.Customer;

public class CustomerDataModel extends ListDataModel
{
	private static final long serialVersionUID = 7526529951747613655L;

	public CustomerDataModel()
	{
		super(new String[] { "Code", "Name", "Phone", "Current Credit" }, 0);
	}

	@Override
	public int getObjectType()
	{
		return Services.TYPE_CUSTOMER;
	}

	@Override
	public String[][] convertRecordsListToTableModel(List<Object> list)
	{
	    String[][] sampleData = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            Customer customer = (Customer) list.get(i);
            sampleData[i] = new String[] { customer.getCode().toString(), customer.getName(), customer.getPhoneOne().toString(),
                    customer.getCurrentCredit().toString() };
        }

		return sampleData;
	}
}
