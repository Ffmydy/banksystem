package com.haut.service;

import com.haut.beans.Entrusted_unit;
import com.haut.beans.PageInfo;

public interface IEntrustedunitService {
	PageInfo showunit(int pageSize, int pageNumber);
	Entrusted_unit check_current_unit(String unit_number);
}
