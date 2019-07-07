package club.javalearn.mapper;

import club.javalearn.entity.TUser;

public interface TUserMapper {
	
    TUser selectByPrimaryKey(Integer id);
    
}