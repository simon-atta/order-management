package io.swagger.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;


/**
 * Customer
 */
public class Customer   {
  
  private String adress = null;
  private Integer code = null;
  private Double creditLimit = null;
  private Double currentCredit = null;
  private Long id = null;
  private String name = null;
  private String phoneOne = null;
  private String phoneTwo = null;

  
  /**
   **/
  public Customer adress(String adress) {
    this.adress = adress;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("adress")
  public String getAdress() {
    return adress;
  }
  public void setAdress(String adress) {
    this.adress = adress;
  }


  /**
   **/
  public Customer code(Integer code) {
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
  public Customer creditLimit(Double creditLimit) {
    this.creditLimit = creditLimit;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("creditLimit")
  public Double getCreditLimit() {
    return creditLimit;
  }
  public void setCreditLimit(Double creditLimit) {
    this.creditLimit = creditLimit;
  }


  /**
   **/
  public Customer currentCredit(Double currentCredit) {
    this.currentCredit = currentCredit;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("currentCredit")
  public Double getCurrentCredit() {
    return currentCredit;
  }
  public void setCurrentCredit(Double currentCredit) {
    this.currentCredit = currentCredit;
  }


  /**
   **/
  public Customer id(Long id) {
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
  public Customer name(String name) {
    this.name = name;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }


  /**
   **/
  public Customer phoneOne(String phoneOne) {
    this.phoneOne = phoneOne;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("phoneOne")
  public String getPhoneOne() {
    return phoneOne;
  }
  public void setPhoneOne(String phoneOne) {
    this.phoneOne = phoneOne;
  }


  /**
   **/
  public Customer phoneTwo(String phoneTwo) {
    this.phoneTwo = phoneTwo;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "")
  @JsonProperty("phoneTwo")
  public String getPhoneTwo() {
    return phoneTwo;
  }
  public void setPhoneTwo(String phoneTwo) {
    this.phoneTwo = phoneTwo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(this.adress, customer.adress) &&
        Objects.equals(this.code, customer.code) &&
        Objects.equals(this.creditLimit, customer.creditLimit) &&
        Objects.equals(this.currentCredit, customer.currentCredit) &&
        Objects.equals(this.id, customer.id) &&
        Objects.equals(this.name, customer.name) &&
        Objects.equals(this.phoneOne, customer.phoneOne) &&
        Objects.equals(this.phoneTwo, customer.phoneTwo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(adress, code, creditLimit, currentCredit, id, name, phoneOne, phoneTwo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer {\n");
    
    sb.append("    adress: ").append(toIndentedString(adress)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    creditLimit: ").append(toIndentedString(creditLimit)).append("\n");
    sb.append("    currentCredit: ").append(toIndentedString(currentCredit)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    phoneOne: ").append(toIndentedString(phoneOne)).append("\n");
    sb.append("    phoneTwo: ").append(toIndentedString(phoneTwo)).append("\n");
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

