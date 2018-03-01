package retrogdx.games.earth2140.readers;

import retrogdx.utils.SmartByteBuffer;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import java.io.ByteArrayInputStream;

public class Smp {
    public Clip clip;

    public Smp(SmartByteBuffer buffer) {
        buffer.position(0);

        byte[] audioData = buffer.readBytes(buffer.capacity());

        // TODO values are guessed! Find real values, or verify that they are correct!
        AudioFormat format = new AudioFormat(16000, 8, 1, false, false);
        AudioInputStream input = new AudioInputStream(new ByteArrayInputStream(audioData), format, audioData.length);

        try {
            this.clip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, input.getFormat()));
            this.clip.open(input);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
