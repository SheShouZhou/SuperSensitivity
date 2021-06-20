
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Track;

public class PianoRoll {
    public PianoRoll(int bpm,int loopCount) {
        //����BPM
        MidiUtil.getSequencer().setTempoInBPM(bpm);
        //ѭ������ -1����ѭ�� 0ѭ��һ��
        MidiUtil.getSequencer().setLoopCount(loopCount);
    }
    //���track
    private Track track = MidiUtil.getSequence().createTrack();

    /**
     * д����
     * @param notes ��������
     * @param chan  Ƶ��
     * @param vol   ����/����
     * @param ticks ʱֵ
     * @throws InvalidMidiDataException
     */

    public void setNote(Note[] notes,int chan,int vol,int[] ticks) throws InvalidMidiDataException {
        int tickTime=0;
        for (int i=0;i<notes.length;i++){
            tickTime+=ticks[i];
            track.add(MidiUtil.makeMidiEvent(144,chan,notes[i],vol,tickTime));
        }
    }
    public void run(){
        MidiUtil.start();
        System.out.println("playing...");
    }
}
