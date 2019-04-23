package com.haut.dao;

import java.util.List;
import java.util.Map;

import com.haut.beans.Entrusted_unit;

public interface IEntrustedunitDao {
	List<Entrusted_unit> showunit(Map<String, Object> map);//获取所有的项目单位信息
	Long selunitCount();//计算所有项目单位数量
	Entrusted_unit check_current_unit(String unit_number);//查看当前的单位信息
}
