package playList;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongTest {
		
	User userClassObj;
	
	public void testAddSong()
	{
		 userClassObj = PlaySong.AddUser("Nandhini");
		 userClassObj.playListSize = 3;
		 userClassObj.addSong("s1");
		 userClassObj.addSong("s2");
		 userClassObj.addSong("s3");
	}
	
	
  @Test(priority = 0)
  public void checkOrderOfAddSong() 
  {
	  testAddSong();
	  Assert.assertEquals(userClassObj.song, Arrays.asList("s1", "s2", "s3"), "Expected and Actual Song Addition Order Matched");  
  }
  
  @Test(priority = 1)
  public void checkOrderOfAddSongNegative() 
  {
	  userClassObj.song.clear();
	  testAddSong();
	  Assert.assertNotEquals(userClassObj.song, Arrays.asList("s2", "s1", "s3"), "Expected and Actual Song Addition Order Not Matched");
  }
  
  @Test(priority = 2)
  public void checkPlayingExistingSong() 
  {
	  userClassObj.playSong("s1");
	  Assert.assertEquals(userClassObj.song, Arrays.asList("s2", "s3", "s1"), "Expected and Actual Matched");
  }
  
  @Test(priority = 3)
  public void checkPlayingExistingSongNegative() 
  {
	  userClassObj.playSong("s1");
	  Assert.assertNotEquals(userClassObj.song, Arrays.asList("s1", "s2", "s3"), "Expected and Actual Not Matched");
  }
  
  @Test(priority = 4)
  public void checkPlayingNewSong() 
  {
	  userClassObj.song.clear();
	  testAddSong();
	  userClassObj.playSong("s4");
	  Assert.assertEquals(userClassObj.song, Arrays.asList("s2", "s3", "s4"), "Expected and Actual Matched");
  }
  
  @Test(priority = 5)
  public void checkPlayingNewSongNegative() 
  {
	  userClassObj.playSong("s4");
	  Assert.assertNotEquals(userClassObj.song, Arrays.asList("s1", "s2", "s3"), "Expected and Not Actual Matched");
  }
  
  @Test(priority = 6)
  public void checkPlayListSize() 
  {
	  userClassObj.playSong("s5");
	  Assert.assertEquals(userClassObj.playListSize, 3, "Expected and Actual PlayList Size Matched");
  }
  
  @Test(priority = 7)
  public void checkPlayListSizeNegative() 
  {
	  userClassObj.playSong("s5");
	  Assert.assertNotEquals(userClassObj.playListSize, 4, "Expected and Actual PlayListSize Not Matched");
  }
  
  @Test(priority = 8)
  public void checkUserSong() 
  {
	  userClassObj.song.clear();
	  testAddSong();
	  Assert.assertEquals(userClassObj.name+userClassObj.song, "Nandhini"+Arrays.asList("s1", "s2", "s3"), "Expected and Actual User with Song Matched");
	  
  }
  
  @Test(priority = 9)
  public void checkUserSongNegative() 
  {
	  userClassObj.song.clear();
	  testAddSong();
	  Assert.assertNotEquals(userClassObj.name+userClassObj.song, "Test"+Arrays.asList("s1", "s2", "s3"), "Expected and Actual User with Song Not Matched");

  }
  
  @Test(priority = 10)
  public void checkAddExistingUserNegative() 
  {	
	  User userClassObj1 =  PlaySong.AddUser("Varshini");
	  Assert.assertNotEquals(userClassObj1.name, userClassObj.name, "Expected and Actual User Name Not Matched.This is New User.");  
  }
  
  @Test(priority = 11)
  public void checkAddExistingUser() 
  {
	  User userClassObj2 =  PlaySong.AddUser("Nandhini");
	 Assert.assertEquals(userClassObj.name, userClassObj2.name, "Expected and Actual User Name Matched.So the User Exists Already");
	  
  }
  
  @Test(priority = 12)
  public void checkSongRemoval() 
  {
	  userClassObj.playSong("s4");
	  Assert.assertEquals(userClassObj.song, Arrays.asList("s2", "s3", "s4"), "Expected and Actual Matched");
  }
  
  
  @Test(priority = 13)
  public void checkSongAddNotFull() 
  {
	  userClassObj.song.clear();
	  userClassObj.playSong("s1");
	  userClassObj.playSong("s2");
	  Assert.assertEquals(userClassObj.song, Arrays.asList("s1", "s2"), "Expected and Actual Matched");
	  userClassObj.playSong("s3");
	  Assert.assertEquals(userClassObj.song, Arrays.asList("s1", "s2", "s3"), "Expected and Actual Matched");
  }  
}
