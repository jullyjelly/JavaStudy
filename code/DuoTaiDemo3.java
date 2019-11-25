package test;

interface UserInfo
{
	public void add(User user);
	public void delect(User user);
}


class MainInfo
{
	public void useUserInfo(UserInfo u,User user)
	{
		if(u!=null)
		{
			u.add(user);
			u.delect(user);
		}		
	}
}

public class DuoTaiDemo3 
{
	public static void main(String[] args)
	{
		UserInfo ui = new UserInfoBJ();
		UserInfo vi = new UserInfoBH();
		User user = new User();
		ui.add(user);
		ui.delect(user);
		
		MainInfo m=new MainInfo();
		m.useUserInfo(new UserInfoBJ(), user);
	}
}

class UserInfoBJ implements UserInfo
{
	public void add(User user)
	{
		System.out.println("openJ");
		System.out.println("addJ");
		System.out.println("closeJ");
	}
	public void delect(User user)
	{
		System.out.println("openJ");
		System.out.println("delectJ");
		System.out.println("closeJ");
	}
}

class UserInfoBH implements UserInfo
{
	public void add(User user)
	{
		System.out.println("openH");
		System.out.println("addH");
		System.out.println("closeH");
	}
	public void delect(User user)
	{
		System.out.println("openH");
		System.out.println("delectH");
		System.out.println("closeH");
	}
}
class User
{
	int age=4;
}