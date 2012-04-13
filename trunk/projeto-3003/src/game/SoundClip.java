package game;


import javax.sound.sampled.*;
import java.io.*;
import java.net.*;
import java.util.LinkedList;

public class SoundClip {

	static LinkedList<Clip> clipList = new LinkedList<Clip>();
    private AudioInputStream sample;

    private Clip clip;
    public Clip getClip() { return clip; }
    
    private boolean looping = false;
    public void setLooping(boolean _looping) { looping = _looping; }
    public boolean getLooping() { return looping; }

    private int repeat = 0;
    public void setRepeat(int _repeat) { repeat = _repeat; }
    public int getRepeat() { return repeat; }

    private String filename = "";
    public void setFilename(String _filename) { filename = _filename; }
    public String getFilename() { return filename; }

    public SoundClip() {
        try {
            clip = AudioSystem.getClip();

        } catch (LineUnavailableException e) { }
    }

    public SoundClip(String filename, int loopCount) {
        this();
        load(filename, loopCount);
    }

    private URL getURL(String filename) {
        URL url = null;
        try {
            url = this.getClass().getResource(filename);
        }
        catch (Exception e) { }
        return url;
   }

    public void load(String audiofile, int loop) {
        try {

            setFilename(audiofile);
            sample = AudioSystem.getAudioInputStream(getURL(filename));
            clip.open(sample);
            clip.loop(loop);
            clip.start();
            clipList.add(clip);
            
        } catch (IOException e) {
        } catch (UnsupportedAudioFileException e) {
        } catch (LineUnavailableException e) {
        }
    }

    public void stop() {
        clip.stop();
    }
    
    public static void StopAll()
    {
    	for (Clip clip: clipList)
    		clip.stop();
    	
    	clipList.clear();
    }

}
