package com.nonicafe.service;

import com.nonicafe.dto.RoleDTO;

import java.util.List;
import java.util.Map;

public interface IRoleService {
	List<RoleDTO> findAll();
	Map<String,String> getRoles();
}
