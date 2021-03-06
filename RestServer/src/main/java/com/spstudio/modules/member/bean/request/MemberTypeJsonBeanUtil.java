package com.spstudio.modules.member.bean.request;

import com.spstudio.modules.member.entity.MemberType;

import java.util.Date;

/**
 * Created by Soul on 2016/12/1.
 */
public class MemberTypeJsonBeanUtil {
    public static MemberTypeJsonBean toJsonBean(MemberType member){
        MemberTypeJsonBean memberTypeJsonBean = new MemberTypeJsonBean();
        memberTypeJsonBean.setMember_type_id(member.getMemberTypeId());
        memberTypeJsonBean.setMember_type_name(member.getTypeName());
        memberTypeJsonBean.setMember_type_description(member.getDescription());
        return memberTypeJsonBean;
    }

    public static MemberType toEntityBean(MemberTypeJsonBean memberTypeJsonBean){
        MemberType member = new MemberType();
        member.setTypeName(memberTypeJsonBean.getMember_type_name());
        member.setDescription(memberTypeJsonBean.getMember_type_description());
        member.setCreationDate(new java.sql.Date(new Date().getTime()));
        return member;
    }
}
