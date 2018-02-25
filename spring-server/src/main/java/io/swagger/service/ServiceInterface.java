package io.swagger.service;

import java.util.List;

import io.swagger.model.MemberInformation;

public interface ServiceInterface {
  public String  createMember(MemberInformation info );
  public void updateMember(MemberInformation info);
  public void deleteMemberInformation(MemberInformation info);
  public MemberInformation getByMemberId(String memberId);
  public List<MemberInformation> getByMemberName(String memberName);
  

}
