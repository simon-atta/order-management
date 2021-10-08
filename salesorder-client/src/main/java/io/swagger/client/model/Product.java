package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Product
 */
public class Product   {
  
  private Integer code = null;
  private String desc = null;
  private Long id = null;
  private Double price = null;
  private Integer quantity = null;

  
  /**
   **/
  public Product code(Integer code) {
    this.code = code;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("code")
  public Integer getCode() {
    return code;
  }
  public void setCode(Integer code) {
    this.code = code;
  }


  /**
   **/
  public Product desc(String desc) {
    this.desc = desc;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("desc")
  public String getDesc() {
    return desc;
  }
  public void setDesc(String desc) {
    this.desc = desc;
  }


  /**
   **/
  public Product id(Long id) {
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
  public Product price(Double price) {
    this.price = price;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }
  public void setPrice(Double price) {
    this.price = price;
  }


  /**
   **/
  public Product quantity(Integer quantity) {
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
    Product product = (Product) o;
    return Objects.equals(this.code, product.code) &&
        Objects.equals(this.desc, product.desc) &&
        Objects.equals(this.id, product.id) &&
        Objects.equals(this.price, product.price) &&
        Objects.equals(this.quantity, product.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, desc, id, price, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    desc: ").append(toIndentedString(desc)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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

