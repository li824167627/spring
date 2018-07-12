package cn.itcast.mybatis.po;
//包装类型
public class UserQueryVo {
	
	//这里包装所需要的查询条件
	private UserCustom userCustom;
	//用户查询条件

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	
	
}
