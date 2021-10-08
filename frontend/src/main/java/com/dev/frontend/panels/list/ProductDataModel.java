package com.dev.frontend.panels.list;

import java.util.List;

import com.dev.frontend.services.Services;

import io.swagger.client.model.Product;

public class ProductDataModel extends ListDataModel {
    private static final long serialVersionUID = 7526529951747614655L;

    public ProductDataModel() {
        super(new String[] { "Code", "Description", "Price", "Quantity" }, 0);
    }

    @Override
    public int getObjectType() {
        return Services.TYPE_PRODUCT;
    }

    @Override
    public String[][] convertRecordsListToTableModel(List<Object> list) {

        String[][] sampleData = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            Product product = (Product) list.get(i);
            sampleData[i] = new String[] { product.getCode().toString(), product.getDesc(), product.getPrice().toString(),
                    product.getQuantity().toString() };
        }

        return sampleData;
    }
}
