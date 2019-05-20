package com.yyc.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyc.dao.UserInfoMapper;
import com.yyc.entity.UserInfo;
import com.yyc.service.UserService;

/**************************************
* @author 尹以操 E-mail:34782655@qq.com
* @version 创建时间：2017年6月23日 下午10:10:43
* 类说明:
***************************************
*/
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserInfoMapper userInfoDao;
	
	/**
	 * create by yyc 2017年6月23日下午10:10:43
	 */
	@Override
	public UserInfo getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userInfoDao.selectByPrimaryKey(userId);
	}

}
