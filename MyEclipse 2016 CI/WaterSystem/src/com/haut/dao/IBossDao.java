package com.haut.dao;

import java.util.List;
import java.util.Map;

import com.haut.beans.Boss;

public interface IBossDao {
	List<Boss> showboss(Map<String, Object> map);
	Long selbossCount();
	Boss check_current_boss(String boss_number);
}
