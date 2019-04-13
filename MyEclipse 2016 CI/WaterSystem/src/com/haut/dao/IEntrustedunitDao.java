package com.haut.dao;

import java.util.List;
import java.util.Map;

import com.haut.beans.Entrusted_unit;

public interface IEntrustedunitDao {
	List<Entrusted_unit> showunit(Map<String, Object> map);//获取所有的项目单位信息
	Long selunitCount();//计算所有项目单位数量
}
