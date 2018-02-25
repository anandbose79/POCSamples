package io.swagger.api;

import io.swagger.model.MemberInformation;
import io.swagger.service.ServiceRepository;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-02-25T21:55:56.404Z")

@Controller
public class MemberApiController implements MemberApi {

	@Autowired
	ServiceRepository service;

    public ResponseEntity<Void> createMemberInfo(@ApiParam(value = ""  )  @Valid @RequestBody MemberInformation memberinfo) {
        // do some magic!
    	    service.createMember(memberinfo);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteMemberInfo(@ApiParam(value = ""  )  @Valid @RequestBody MemberInformation memberinfo) {
        // do some magic!
    	    service.deleteMemberInformation(memberinfo);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<MemberInformation>> getMemberInfo(@ApiParam(value = "member ID",required=true ) @PathVariable("memberId") String memberId) {
        // do some magic!
    	 
    	    MemberInformation meminfo = service.getByMemberId(memberId);
    	    List<MemberInformation> memList = new ArrayList<MemberInformation>();
    	    memList.add(meminfo);
    	    if (memList !=null)
    	        return new ResponseEntity<List<MemberInformation>>(memList,HttpStatus.OK);

    	    else
        return new ResponseEntity<List<MemberInformation>>(HttpStatus.OK);
    }

    public ResponseEntity<List<MemberInformation>> getMemberInfobyName( @NotNull@ApiParam(value = "name of the memberId", required = true) @RequestParam(value = "memberName", required = true) String memberName) {
        // do some magic!
    		List<MemberInformation> meminfo = service.getByMemberName(memberName);
    		
    		if (meminfo!=null)
        return new ResponseEntity<List<MemberInformation>>(meminfo,HttpStatus.OK);
    		else return null;
    }

    public ResponseEntity<Void> updateMemberInfo(@ApiParam(value = ""  )  @Valid @RequestBody MemberInformation memberinfo) {
        // do some magic!
    	   service.updateMember(memberinfo);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
