package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.Customer;
import io.swagger.client.model.OrderLine;
import java.util.ArrayList;
import java.util.List;


/**
 * SalesOrder
 */
public class SalesOrder   {
  
  private Customer customer = null;
  private Long id = null;
  private String orderId = null;
  private List<OrderLine> orderLines = new ArrayList<OrderLine>();
  private Double totalPrice = null;

  
  /**
   **/
  public SalesOrder customer(Customer customer) {
    this.customer = customer;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("customer")
  public Customer getCustomer() {
    return customer;
  }
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }


  /**
   **/
  public SalesOrder id(Long id) {
    this.id = id;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("id")
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }


  /**
   **/
  public SalesOrder orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("orderId")
  public String getOrderId() {
    return orderId;
  }
  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }


  /**
   **/
  public SalesOrder orderLines(List<OrderLine> orderLines) {
    this.orderLines = orderLines;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("orderLines")
  public List<OrderLine> getOrderLines() {
    return orderLines;
  }
  public void setOrderLines(List<OrderLine> orderLines) {
    this.orderLines = orderLines;
  }


  /**
   **/
  public SalesOrder totalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("totalPrice")
  public Double getTotalPrice() {
    return totalPrice;
  }
  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SalesOrder salesOrder = (SalesOrder) o;
    return Objects.equals(this.customer, salesOrder.customer) &&
        Objects.equals(this.id, salesOrder.id) &&
        Objects.equals(this.orderId, salesOrder.orderId) &&
        Objects.equals(this.orderLines, salesOrder.orderLines) &&
        Objects.equals(this.totalPrice, salesOrder.totalPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customer, id, orderId, orderLines, totalPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SalesOrder {\n");
    
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    orderLines: ").append(toIndentedString(orderLines)).append("\n");
    sb.append("    totalPrice: ").append(toIndentedString(totalPrice)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

