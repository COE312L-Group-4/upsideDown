import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.DataLine.Info;

public class Sound {
	// -------------Nadeen-----------Sound--------------------------------
	File yourFile;
	AudioInputStream stream;
	AudioFormat format;
	DataLine.Info info;
	Clip clip;
	
	public Sound(String filename) {
		try {
			this.yourFile = new File(filename);
			this.stream = AudioSystem.getAudioInputStream(yourFile);
			this.format = stream.getFormat();
			this.info = new DataLine.Info(Clip.class, format);
			this.clip = (Clip) AudioSystem.getLine(info);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void playSound() {
		try {
			clip.open(stream);
			clip.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
