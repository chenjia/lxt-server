package com.lxt.service;

import java.util.List;

import com.lxt.model.Organization;

public interface OrganizationService {
	
	public Organization getOrganizationById(String orgId) throws ServiceException;
	
	public List<Organization> getSubOrganizationById(String orgId) throws ServiceException;
}
