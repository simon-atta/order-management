package com.dev.frontend.panels.edit;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.dev.frontend.services.Services;

import io.swagger.client.model.Product;

public class EditProduct extends EditContentPanel {
    private static final long serialVersionUID = -8971249970444644844L;
    private JTextField txtCode = new JTextField();
    private JTextField txtDescription = new JTextField();
    private JTextField txtQuantity = new JTextField();
    private JTextField txtPrice = new JTextField();
    private JTextField id;

    public EditProduct() {
        id = new JTextField();
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Code"), gbc);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtCode, gbc);
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        txtCode.setColumns(10);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Description"), gbc);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        add(txtDescription, gbc);
        txtDescription.setColumns(28);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Price"), gbc);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        add(txtPrice, gbc);
        txtPrice.setColumns(10);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 2;
        gbc.gridy = 2;
        add(new JLabel("Quantity"), gbc);

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 15);
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        add(txtQuantity, gbc);
        txtQuantity.setColumns(10);

        id.setVisible(false);
    }

    @Override
    public boolean bindToGUI(Object object) {
        if (object instanceof String) {
            JOptionPane.showMessageDialog(this, object.toString());
        } else {
            Product prod = (Product) object;
            txtCode.setText(prod.getCode().toString());
            txtDescription.setText(prod.getDesc());
            txtPrice.setText(prod.getPrice().toString());
            txtQuantity.setText(prod.getQuantity().toString());
            id.setText(prod.getId().toString());
        }

        return true;
    }

    @Override
    public Object guiToObject() {
        Product prod = new Product();
        prod.setCode(Integer.parseInt(txtCode.getText()));
        prod.setDesc(txtDescription.getText());
        prod.setPrice(Double.parseDouble(txtPrice.getText()));
        prod.setQuantity(Integer.parseInt(txtQuantity.getText()));

        if (!id.getText().isEmpty()) {
            prod.setId(Long.parseLong(id.getText()));
        }

        return prod;
    }

    @Override
    public int getObjectType() {
        return Services.TYPE_PRODUCT;
    }

    @Override
    public String getCurrentCode() {
        return txtCode.getText();
    }

    @Override
    public void clear() {
        txtCode.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
        txtQuantity.setText("");
    }

    @Override
    public void onInit() {
        id.setText("");
    }
}
