package com.feng.service;

import com.feng.entity.MenuEntity;

public interface MenuService {

	/**
	 * 根据MenuId查找菜单信息
	 * @param menuId
	 * @return
	 */
	MenuEntity findMenuById(Long menuId);

}
