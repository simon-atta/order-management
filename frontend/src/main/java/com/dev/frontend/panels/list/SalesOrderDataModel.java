package com.dev.frontend.panels.list;

import java.util.List;

import com.dev.frontend.services.Services;

import io.swagger.client.model.SalesOrder;

public class SalesOrderDataModel extends ListDataModel {
    private static final long serialVersionUID = 7526529951747614655L;

    public SalesOrderDataModel() {
        super(new String[] { "Order Number", "Customer", "Total Price" }, 0);
    }

    @Override
    public int getObjectType() {
        return Services.TYPE_SALESORDER;
    }

    @Override
    public String[][] convertRecordsListToTableModel(List<Object> list) {
        String[][] sampleData = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            SalesOrder salesOrder = (SalesOrder) list.get(i);
            sampleData[i] = new String[] { salesOrder.getOrderId().toString(), salesOrder.getCustomer().getName(),
                    salesOrder.getTotalPrice().toString() };
        }

        return sampleData;
    }
}
