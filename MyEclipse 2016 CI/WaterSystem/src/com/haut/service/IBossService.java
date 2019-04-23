package com.haut.service;

import com.haut.beans.Boss;
import com.haut.beans.PageInfo;

public interface IBossService {
	PageInfo showboss(int pageSize, int pageNumber);
	Boss check_current_boss(String boss_number);
}
