package com.lxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxt.dao.mapper.OrganizationMapper;
import com.lxt.model.Organization;
import com.lxt.model.OrganizationExample;
import com.lxt.service.OrganizationService;
import com.lxt.service.ServiceException;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationMapper organizationMapper;
	
	public Organization getOrganizationById(String orgId) throws ServiceException {
		Organization org = organizationMapper.selectByPrimaryKey(orgId);
		return org;
	}

	public List<Organization> getSubOrganizationById(String orgId) throws ServiceException {
		OrganizationExample example = new OrganizationExample();
		example.or().andParentIdEqualTo(orgId);
		List<Organization> subOrgs = organizationMapper.selectByExample(example);
		return subOrgs;
	}

}
