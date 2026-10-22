public class InstrumentPlayability {
    interface Playable{
        void play();
    }

    class Piano implements Playable{
        @Override
        public void play() {
            System.out.println("Playing 'Fur Elise'.");
        }
    }

    class Guitar implements Playable{
        @Override
        public void play() {
            System.out.println("Playing 'Stairway to Heaven'.");
        }
    }

    void main(String[] args) {
        Guitar guitar = new Guitar();
        guitar.play();

        Piano piano = new Piano();
        piano.play();
    }
}
