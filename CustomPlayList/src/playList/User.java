package playList;

import java.util.LinkedList;

public class User {
	
	
	LinkedList<String> song = new LinkedList<String> ();
	String name;
	int playListSize;
	
	public User(String name)
	{
		this.name = name;
	}
	
	  void addSong(String newSong)
	{
		song.add(newSong);
	}
	 
	  boolean replaceSong(String s)
	 {
		 String temp;
		 for (int i = 0; i < song.size(); i++)
			{
				temp = song.get(i);
				if(temp.equals(s))
				{
					song.remove(i);
					song.addLast(s);
					return true;
				}
			}
		 return false;
	 }
	
	 void playSong(String s)
	{
		String temp;
		if(song.size() < playListSize)
		{	
			if (replaceSong(s) == false)
			{
				addSong(s);
			}
		}
		else
		{
			if (replaceSong(s) == false)
			{
				temp = song.getLast();
				if (temp != s)
				{
					song.removeFirst();
					song.addLast(s);
				}
			}
		}
	}

}
