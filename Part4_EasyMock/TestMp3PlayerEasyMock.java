import junit.framework.*;
import static org.easymock.EasyMock.*;

import java.util.ArrayList;

public class TestMp3PlayerEasyMock extends TestCase {

  private Mp3Player mockMp3;
  private Mp3Player mockMp3_control;
  protected ArrayList list = new ArrayList();


  @Override
  public void setUp() {
	//Create a control handle to the Mock object
	mockMp3_control = createMock(Mp3Player.class);

	// And create the mock object itself
	mockMp3 = mockMp3_control;
    list = new ArrayList();
    list.add("Bill Chase -- Open Up Wide");
    list.add("Jethro Tull -- Locomotive Breath");
    list.add("The Boomtown Rats -- Monday");
    list.add("Carl Orff -- O Fortuna");
  }
  
  public void testPlay(){
	  	mockMp3.loadSongs(list);
	  	expect(mockMp3.isPlaying()).andReturn(false);
	  	replay( mockMp3_control );
	  	assertFalse(mockMp3.isPlaying());
	    
	  	reset(mockMp3_control);
	  	mockMp3.play();
	  	expect(mockMp3.isPlaying()).andReturn(true);
	  	expect(mockMp3.currentPosition()).andReturn(0.2);
	  	replay( mockMp3_control );
	    assertTrue(mockMp3.isPlaying());
	    assertTrue(mockMp3.currentPosition() != 0.0);
	    
	    reset(mockMp3_control);
	    mockMp3.pause();
	    expect(mockMp3.currentPosition()).andReturn(0.2);
	    replay( mockMp3_control );
	    assertTrue(mockMp3.currentPosition() != 0.0);
	    
	    reset(mockMp3_control);
	    mockMp3.stop();
	    expect(mockMp3.currentPosition()).andReturn(0.0);
	    replay( mockMp3_control );
	    assertEquals(mockMp3.currentPosition(), 0.0, 0.1);
	    
  }
  
  public void testPlayNoList() {

	    // Don't set the list up
	  	expect(mockMp3.isPlaying()).andReturn(false);
	  	replay( mockMp3_control );
	    assertFalse(mockMp3.isPlaying());
	    
	    reset(mockMp3_control);
	    mockMp3.play();
		expect(mockMp3.isPlaying()).andReturn(false);
		expect(mockMp3.currentPosition()).andReturn(0.0);
		replay( mockMp3_control );
	    assertFalse(mockMp3.isPlaying());
	    assertEquals(mockMp3.currentPosition(), 0.0, 0.1);
	   
	    reset(mockMp3_control);
	    mockMp3.pause();
	    expect(mockMp3.currentPosition()).andReturn(0.0);
	    expect(mockMp3.isPlaying()).andReturn(false);
		replay( mockMp3_control );
	    assertEquals(mockMp3.currentPosition(), 0.0, 0.1);
	    assertFalse(mockMp3.isPlaying());
	    
	    reset(mockMp3_control); 
	    mockMp3.stop();	
	    expect(mockMp3.currentPosition()).andReturn(0.0);
	    expect(mockMp3.isPlaying()).andReturn(false);
	    replay( mockMp3_control );
	    assertEquals(mockMp3.currentPosition(), 0.0, 0.1);
	    assertFalse(mockMp3.isPlaying());
	  }
  
  public void testAdvance() {

	    mockMp3.loadSongs(list);
	    
	    
	    mockMp3.play();
	    expect(mockMp3.isPlaying()).andReturn(true);
	    replay( mockMp3_control );
	    assertTrue(mockMp3.isPlaying());

	    reset(mockMp3_control); 
	    mockMp3.prev();
	    expect(mockMp3.currentSong()).andReturn((String)list.get(0));
	    expect(mockMp3.isPlaying()).andReturn(true);
	    replay( mockMp3_control );
	    assertEquals(mockMp3.currentSong(), (String)list.get(0));
	    assertTrue(mockMp3.isPlaying());

	    reset(mockMp3_control); 
	    mockMp3.next();
	    expect(mockMp3.currentSong()).andReturn((String)list.get(1));
	    replay( mockMp3_control );
	    assertEquals(mockMp3.currentSong(),(String) list.get(1));
	    
	    reset(mockMp3_control); 
	    mockMp3.next();
	    expect(mockMp3.currentSong()).andReturn((String)list.get(2));
	    replay( mockMp3_control );
	    assertEquals(mockMp3.currentSong(), (String)list.get(2));
	    
	    reset(mockMp3_control); 
	    mockMp3.prev();
	    expect(mockMp3.currentSong()).andReturn((String)list.get(1));
	    replay( mockMp3_control );
	    assertEquals(mockMp3.currentSong(),(String) list.get(1));
	    
	    reset(mockMp3_control);
	    mockMp3.next();
	    expect(mockMp3.currentSong()).andReturn((String)list.get(2));
	    replay( mockMp3_control );
	    assertEquals(mockMp3.currentSong(), (String)list.get(2));
	    
	    reset(mockMp3_control);
	    mockMp3.next();
	    expect(mockMp3.currentSong()).andReturn((String)list.get(3));
	    replay( mockMp3_control );
	    assertEquals(mockMp3.currentSong(), (String)list.get(3));
	    
	    
	    reset(mockMp3_control);
	    mockMp3.next();
	    expect(mockMp3.isPlaying()).andReturn(true);
	    expect(mockMp3.currentSong()).andReturn((String)list.get(3));
	    replay( mockMp3_control );
	    assertEquals(mockMp3.currentSong(), (String)list.get(3));
	    assertTrue(mockMp3.isPlaying());
	  }
  
  

  
 


}
