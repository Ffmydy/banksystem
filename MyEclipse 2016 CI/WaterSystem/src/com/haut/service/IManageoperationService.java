package com.haut.service;

import com.haut.beans.PageInfo;

public interface IManageoperationService {
	PageInfo show_manageoperation(int pageSize, int pageNumber);
	PageInfo queryoperationbyoperation_managename(int pageSize, int pageNumber, String operation_managename);
}
