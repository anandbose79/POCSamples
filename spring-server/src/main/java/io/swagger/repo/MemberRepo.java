package io.swagger.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.MemberInformation;



public interface MemberRepo extends MongoRepository<MemberInformation, String> 
{
	public MemberInformation findOne(String memberId);
	public void delete(MemberInformation memberInfo);
	
	public List<MemberInformation> findByMemberDetails_Name(String name);
}
