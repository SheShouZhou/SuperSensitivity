
import javax.sound.midi.*;
public class MidiUtil {

    //������
    private static Sequencer sequencer;
    //����
    private static Sequence sequence;
    //��ʼ��
    static {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ,4);

        } catch (MidiUnavailableException|InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    public static Sequencer getSequencer() {
        return sequencer;
    }
    public static Sequence getSequence() {
        return sequence;
    }

    public static void start(){
        try {
            sequencer.setSequence(sequence);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        sequencer.start();
    }

    /**
     * MIDI�¼� / д����
     * @param command MIDI���� 144
     * @param chan  ͨ��
     * @param note ����
     * @param vol   ����/����
     * @param tick  ʱֵ
     * @return
     * @throws InvalidMidiDataException
     */
    public static MidiEvent makeMidiEvent(int command, int chan, Note note, int vol, int tick) throws InvalidMidiDataException {
        ShortMessage message = new ShortMessage();
        message.setMessage(command,chan,note.getValue(),vol);
        MidiEvent event = new MidiEvent(message, tick);
        return event;
    }
}

