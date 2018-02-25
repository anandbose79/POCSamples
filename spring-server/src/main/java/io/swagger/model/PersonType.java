package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PersonType
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-02-25T02:13:20.511Z")

public class PersonType   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("Name")
  private String name = null;

  @JsonProperty("Age")
  private BigDecimal age = null;

  @JsonProperty("Address")
  private String address = null;

  @JsonProperty("Phonenumber")
  private String phonenumber = null;

  public PersonType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PersonType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")

// @Pattern(regexp="^[a-z ,.'-]+$/i")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PersonType age(BigDecimal age) {
    this.age = age;
    return this;
  }

   /**
   * Get age
   * @return age
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getAge() {
    return age;
  }

  public void setAge(BigDecimal age) {
    this.age = age;
  }

  public PersonType address(String address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public PersonType phonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
    return this;
  }

   /**
   * Get phonenumber
   * @return phonenumber
  **/
  @ApiModelProperty(value = "")

// @Pattern(regexp="^[1-9]\\d{2}-\\d{3}-\\d{4}")
  public String getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonType personType = (PersonType) o;
    return Objects.equals(this.id, personType.id) &&
        Objects.equals(this.name, personType.name) &&
        Objects.equals(this.age, personType.age) &&
        Objects.equals(this.address, personType.address) &&
        Objects.equals(this.phonenumber, personType.phonenumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, age, address, phonenumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    phonenumber: ").append(toIndentedString(phonenumber)).append("\n");
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

