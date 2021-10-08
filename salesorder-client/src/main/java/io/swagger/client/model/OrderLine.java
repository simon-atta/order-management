package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.OrderLineId;
import io.swagger.client.model.Product;


/**
 * OrderLine
 */
public class OrderLine   {
  
  private OrderLineId orderLineId = null;
  private Product product = null;
  private Integer quantity = null;

  
  /**
   **/
  public OrderLine orderLineId(OrderLineId orderLineId) {
    this.orderLineId = orderLineId;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("orderLineId")
  public OrderLineId getOrderLineId() {
    return orderLineId;
  }
  public void setOrderLineId(OrderLineId orderLineId) {
    this.orderLineId = orderLineId;
  }


  /**
   **/
  public OrderLine product(Product product) {
    this.product = product;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("product")
  public Product getProduct() {
    return product;
  }
  public void setProduct(Product product) {
    this.product = product;
  }


  /**
   **/
  public OrderLine quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderLine orderLine = (OrderLine) o;
    return Objects.equals(this.orderLineId, orderLine.orderLineId) &&
        Objects.equals(this.product, orderLine.product) &&
        Objects.equals(this.quantity, orderLine.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderLineId, product, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderLine {\n");
    
    sb.append("    orderLineId: ").append(toIndentedString(orderLineId)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
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

