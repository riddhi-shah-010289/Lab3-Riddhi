import java.util.ArrayList;
import java.util.Date;

	
public class MockMp3Player implements Mp3Player {
	
	protected ArrayList list = new ArrayList();
	protected String current_song = null;
	protected boolean isPlaying = false;
	protected int cur_song_index = -1;
	protected double cur_pos=0.0;
	
	@Override
	public void play() {
		if (list.size()!=0){
			current_song = (String)list.get(0);
			cur_song_index = 0;
			isPlaying = true;
			cur_pos = 0.2;
		}
		else
			return;
	}

	@Override
	public void pause() {
		if (isPlaying){
			isPlaying = false;
			cur_pos = 0.2;
		}
		
	}

	@Override
	public void stop() {
		if (isPlaying){
			isPlaying = false;
		}
		if (list.size()!=0){
			current_song = (String)list.get(0);
			
		}
		cur_pos = 0.0;
	}

	@Override
	public double currentPosition() {
		if (cur_pos!=0.0){
			return cur_pos;
		}
		return 0;
	}

	@Override
	public String currentSong() {
		if (current_song!=null){
			return current_song;
		}
		return null;
	}

	@Override
	public void next() {
		int next_pos = cur_song_index + 1;
		if (next_pos < list.size())
			{
				current_song = (String)list.get(next_pos);
				cur_song_index = next_pos;
			}
		
	}

	@Override
	public void prev() {
		int prev_pos = cur_song_index - 1;
		if (prev_pos > -1){
			current_song = (String)list.get(prev_pos);
			cur_song_index = prev_pos;
		}
	}

	@Override
	public boolean isPlaying() {
		if (isPlaying){
			return true;
		}
		return false;
	}

	@Override
	public void loadSongs(ArrayList names) {
		this.list = names;
	}
	
}
