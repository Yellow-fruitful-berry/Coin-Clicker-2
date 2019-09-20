import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;


class MouseListener {


    public static void main(String[] args) {
        JFrame frame = new JFrame("Coin Clicker");
        final int[] coins = {0};
        final int[] factory = {0};
        final int[] plantation = {0};

        Component Button = new Button(String.valueOf("Coins: "+coins[0]+"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nf"));
        Component Button1 = new Button(String.valueOf("Factories: "+factory[0]+"\n"+"You can buy a factory for 25 coins."+"\n"+"It produces 2 coins per second."));
        Component Button2 = new Button(String.valueOf("Plantations: "+plantation[0]+"\n"+"You can buy a plantation for 1000 coins and 50 factories."+"\n"+"It produces 3 factories per second."));
        frame.add(Button, BorderLayout.NORTH);
        frame.add(Button1, BorderLayout.CENTER);
        frame.add(Button2, BorderLayout.SOUTH);
        frame.setSize(600, 600);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (; ; ) {

            ((java.awt.Button) Button).setLabel(String.valueOf("Coins: "+coins[0]));
            ((java.awt.Button) Button1).setLabel("Factories: "+factory[0]);
            ((java.awt.Button) Button2).setLabel("Plantations: "+String.valueOf(plantation[0]));


        Button.addMouseListener(new MouseAdapter() {
            //final int[] coins = {0};

            public void mouseReleased(MouseEvent evt) {

                Button source = (Button) evt.getSource();
                //Button source1 = (Button) evt.getSource();
                coins[0]+=1;
                source.setLabel(String.valueOf("Coins: "+coins[0]));
                source.repaint();
                //source1.setText(String.valueOf(coins[0]));

            }


        });
        Button1.addMouseListener(new MouseAdapter() {
            //final int[] factory = {0};

            public void mouseReleased(MouseEvent evt) {

                Button source1 = (Button) evt.getSource();
                if (coins[0] >= 25) {

                coins[0] -= 25;
                factory[0] += 1;
                //System.out.println(factory[0] + " factroies");
                source1.setLabel(String.valueOf("Factories: "+factory[0]));

                }

            }


        });
            Button2.addMouseListener(new MouseAdapter() {
                //final int[] factory = {0};

                public void mouseClicked(MouseEvent evt) {

                    Button source2 = (Button) evt.getSource();
                    if (factory[0] >= 50 && coins[0] >= 1000) {

                        coins[0] -= 1000;
                        factory[0] -= 50;
                        plantation[0]++;
                        //System.out.println(factory[0] + " factroies");
                        source2.setLabel("Plantations: "+String.valueOf(plantation[0]));

                    }

                }


            });
            coins[0] += factory[0]*2;
            factory[0] += plantation[0]*3;

//            ((java.awt.Button) Button).setLabel(String.valueOf("Coins: "+coins[0]));
//            ((java.awt.Button) Button1).setLabel("Factories: "+factory[0]);
//            ((java.awt.Button) Button2).setLabel("Plantations: "+String.valueOf(plantation[0]));
//            //System.out.println(coins[0]+" "+factory[0]+" "+plantation[0]);
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