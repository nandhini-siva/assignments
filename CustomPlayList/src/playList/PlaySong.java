package playList;

import java.util.ArrayList;
import java.util.Scanner;

public class PlaySong {
	
	static ArrayList<User> Users = new ArrayList<User>();
	static int num_users = 0;
	static Scanner sc= new Scanner(System.in);
	
	public static User AddUser(String name)
	{
		int num_users = Users.size();
		if (num_users > 0 && num_users <= 2)
		{
		    for (int u = 0; u <= num_users-1; u++)
		    {
		    	if (Users.get(u).name.equals(name))
		    		return Users.get(u);
		    }
		}
		if (num_users == 2)
		{
			System.out.println("Unable to add user");
			return null;
		}
		User user = new User(name);
		Users.add(user);
		return user;
	}

	public  static void main(String[] args) 
	{
		User obj;
		String s,stopSong,stopUser,user;
		while(true)
		{
			System.out.print("Enter User : ");
			user = sc.next();
			obj = AddUser(user);
			if (obj == null)
			{
				break;
			}
			if (obj.playListSize == 0)
			{
				System.out.println("Enter playListSize : ");  
				obj.playListSize = sc.nextInt();
			}
			else
			{
				System.out.println("Existing user "+obj.name+" playListSize : "+obj.playListSize);
			}
			while(true)
			{
				System.out.print("Enter Songs : ");
				s = sc.next();
				obj.playSong(s);
				System.out.println(obj.song);
				System.out.println("Do you wish to play songs for the user "+user+" ?(y/n)?");
				stopSong = sc.next();
				if(stopSong.equalsIgnoreCase("N"))
				{
					break;
				}
			
			}
		
			System.out.println("Do you wish to add another user?(y/n)?");
			stopUser = sc.next();
			if(stopUser.equalsIgnoreCase("N"))
			{
				break;
				
			}	
			
			System.out.println("Playlist for User "+user+" is :"+obj.song);		
		}
		
	}
}

