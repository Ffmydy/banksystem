package com.haut.service;

import com.haut.beans.PageInfo;

public interface IWatertestService {
	PageInfo showitem(int pageSize, int pageNumber);
	void deleteitem(int item_number);
}
