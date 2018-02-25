package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.PersonType;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * MemberInformation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-02-25T02:13:20.511Z")
@Document(collection="MemberData")
public class MemberInformation   {
  @JsonProperty("memberId")
  @Id
  private String memberId = null;

  @JsonProperty("memberDetails")
  private PersonType memberDetails = null;

  @JsonProperty("dependentDetails")
  private List<PersonType> dependentDetails = null;

  public MemberInformation memberId(String memberId) {
    this.memberId = memberId;
    return this;
  }

   /**
   * id of the member which is unique
   * @return memberId
  **/
  @ApiModelProperty(value = "id of the member which is unique")


  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  public MemberInformation memberDetails(PersonType memberDetails) {
    this.memberDetails = memberDetails;
    return this;
  }

   /**
   * Get memberDetails
   * @return memberDetails
  **/
  @ApiModelProperty(value = "")

  @Valid

  public PersonType getMemberDetails() {
    return memberDetails;
  }

  public void setMemberDetails(PersonType memberDetails) {
    this.memberDetails = memberDetails;
  }

  public MemberInformation dependentDetails(List<PersonType> dependentDetails) {
    this.dependentDetails = dependentDetails;
    return this;
  }

  public MemberInformation addDependentDetailsItem(PersonType dependentDetailsItem) {
    if (this.dependentDetails == null) {
      this.dependentDetails = new ArrayList<PersonType>();
    }
    this.dependentDetails.add(dependentDetailsItem);
    return this;
  }

   /**
   * Get dependentDetails
   * @return dependentDetails
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PersonType> getDependentDetails() {
    return dependentDetails;
  }

  public void setDependentDetails(List<PersonType> dependentDetails) {
    this.dependentDetails = dependentDetails;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MemberInformation memberInformation = (MemberInformation) o;
    return Objects.equals(this.memberId, memberInformation.memberId) &&
        Objects.equals(this.memberDetails, memberInformation.memberDetails) &&
        Objects.equals(this.dependentDetails, memberInformation.dependentDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(memberId, memberDetails, dependentDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MemberInformation {\n");
    
    sb.append("    memberId: ").append(toIndentedString(memberId)).append("\n");
    sb.append("    memberDetails: ").append(toIndentedString(memberDetails)).append("\n");
    sb.append("    dependentDetails: ").append(toIndentedString(dependentDetails)).append("\n");
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

