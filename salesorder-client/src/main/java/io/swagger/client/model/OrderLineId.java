package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * OrderLineId
 */
public class OrderLineId   {
  
  private Long prodId = null;
  private Long salesOrderId = null;

  
  /**
   **/
  public OrderLineId prodId(Long prodId) {
    this.prodId = prodId;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("prodId")
  public Long getProdId() {
    return prodId;
  }
  public void setProdId(Long prodId) {
    this.prodId = prodId;
  }


  /**
   **/
  public OrderLineId salesOrderId(Long salesOrderId) {
    this.salesOrderId = salesOrderId;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("salesOrderId")
  public Long getSalesOrderId() {
    return salesOrderId;
  }
  public void setSalesOrderId(Long salesOrderId) {
    this.salesOrderId = salesOrderId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderLineId orderLineId = (OrderLineId) o;
    return Objects.equals(this.prodId, orderLineId.prodId) &&
        Objects.equals(this.salesOrderId, orderLineId.salesOrderId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prodId, salesOrderId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderLineId {\n");
    
    sb.append("    prodId: ").append(toIndentedString(prodId)).append("\n");
    sb.append("    salesOrderId: ").append(toIndentedString(salesOrderId)).append("\n");
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

