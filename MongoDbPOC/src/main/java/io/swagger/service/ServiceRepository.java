package io.swagger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.MemberInformation;
import io.swagger.repo.MemberRepo;

@Service
public class ServiceRepository implements ServiceInterface{
    @Autowired
    MemberRepo repository;
	@Override
	public String createMember(MemberInformation info) {
		// TODO Auto-generated method stub
	  	repository.insert(info);
	  	System.out.println("Data inserted");
		return null;
	}

	@Override
	public void updateMember(MemberInformation info) {
		// TODO Auto-generated method stub
		repository.save(info);

	}

	@Override
	public void deleteMemberInformation(MemberInformation info) {
		// TODO Auto-generated method stub
		repository.delete(info);
		
	}

	@Override
	public MemberInformation getByMemberId(String memberId) {
		// TODO Auto-generated method stub
		return repository.findOne(memberId);
	}

	@Override
	public List<MemberInformation> getByMemberName(String memberName) {
		// TODO Auto-generated method stub
	    List<MemberInformation> info = repository.findByMemberDetails_Name(memberName);

		return info;
	}

}
