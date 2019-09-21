import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;


class MouseListener {
    public static int coin = 0;
    public static int factory = 0;
    public static int plantation = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Coin Clicker");
//        final int[] coins = {0};
//        final int[] factory = {0};
//        final int[] plantation = {0};


        Component Button = new Button("Coins: 0");
        Component Button1 = new Button("Factories: 0");
        Component Button2 = new Button("Plantations: 0");
        frame.add(Button);
        frame.add(Button1);
        frame.add(Button2);
        frame.setSize(1000, 1000);
        Button.setBounds(0, 0, 600, 200);
        Button1.setBounds(0, 200, 600, 200);
        Button2.setBounds(0, 400, 600, 200);


        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (; ; ) {


            ((java.awt.Button) Button).setLabel("Coins: " + String.valueOf(coin));
            ((java.awt.Button) Button1).setLabel("Factories: " + String.valueOf(factory));
            ((java.awt.Button) Button2).setLabel("Plantations: " + String.valueOf(plantation));


            Button.addMouseListener(new MouseAdapter() {
                //final int[] coins = {0};

                public void mouseClicked(MouseEvent evt) {

                    Button source = (Button) evt.getSource();
                    //Button source1 = (Button) evt.getSource();
                    //coin = coin + 1;

                    coin++;
                    //source.setLabel("Coins: "+String.valueOf(coin));
                    source.setLabel(String.valueOf(coin));
                    source.repaint();
                    //source1.setText(String.valueOf(coin));

                }


            });
            Button1.addMouseListener(new MouseAdapter() {
                //final int[] factory = {0};

                public void mouseReleased(MouseEvent evt) {

                    Button source1 = (Button) evt.getSource();

                    if (coin >= 25) {

                        coin -= 25;
                        factory += 1;
                        //System.out.println(factory + " factroies");
                        source1.setLabel(String.valueOf("Factories: " + factory));

                    }

                }


            });
            Button2.addMouseListener(new MouseAdapter() {
                //final int[] factory = {0};

                public void mouseClicked(MouseEvent evt) {
                    Button source2 = (Button) evt.getSource();
                    if (factory >= 50 && coin >= 1000) {

                        coin -= 1000;
                        factory -= 50;
                        plantation++;
                        //System.out.println(factory + " factroies");
                        source2.setLabel("Plantations: " + String.valueOf(plantation));

                    }

                }


            });
//            coin += factory * 2;
//            factory += plantation * 3;

//            ((java.awt.Button) Button).setLabel(String.valueOf("Coins: "+coin));
//            ((java.awt.Button) Button1).setLabel("Factories: "+factory);
//            ((java.awt.Button) Button2).setLabel("Plantations: "+String.valueOf(plantation));
//            //System.out.println(coin+" "+factory+" "+plantation);
//            //frame.dispose();
////            frame.remove(Button);
////            frame.remove(Button1);
////            frame.remove(Button2);
//            Button.repaint();
//            Button1.repaint();
//            Button2.repaint();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}