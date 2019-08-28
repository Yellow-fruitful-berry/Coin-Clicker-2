import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;


class MouseListener {


    public static void main(String[] args) {
        final int[] coins = {0};
        final int[] factory = {0};
        final int[] plantation = {0};
        for (; ; ) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            JFrame frame = new JFrame("Coin Clicker");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //addKeyListener(this);

// Create a component to add to the frame; in this case a text area with sample text



            Component textArea = new TextArea(String.valueOf(coins[0]));
            Component textArea1 = new TextArea(String.valueOf(factory[0]));
            Component textArea2 = new TextArea(String.valueOf(plantation[0]));

// Create frame with specific title



// Add a mouse listener to capture click events

        textArea.addMouseListener(new MouseAdapter() {
            //final int[] coins = {0};

            public void mouseClicked(MouseEvent evt) {

                TextArea source = (TextArea) evt.getSource();
                //TextArea source1 = (TextArea) evt.getSource();
                coins[0]++;
                source.setText(String.valueOf(coins[0]));
                //source1.setText(String.valueOf(coins[0]));

            }


        });
        textArea1.addMouseListener(new MouseAdapter() {
            //final int[] factory = {0};

            public void mouseClicked(MouseEvent evt) {

                TextArea source1 = (TextArea) evt.getSource();
                if (coins[0] >= 25) {

                coins[0] -= 25;
                factory[0] += 1;
                System.out.println(factory[0] + " factroies");
                source1.setText(String.valueOf(factory[0]));

                }

            }


        });
            textArea2.addMouseListener(new MouseAdapter() {
                //final int[] factory = {0};

                public void mouseClicked(MouseEvent evt) {

                    TextArea source2 = (TextArea) evt.getSource();
                    if (factory[0] >= 50 && coins[0] >= 1000) {

                        coins[0] -= 1000;
                        factory[0] -= 50;
                        plantation[0]++;
                        //System.out.println(factory[0] + " factroies");
                        source2.setText(String.valueOf(plantation[0]));

                    }

                }


            });
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_F && coins[0] >= 25) {
//
//                    coins[0]-=25;
//                    factory[0]++;
//                    System.out.println(factory[0]+" factroies");
//                    factories.setText(String.valueOf(factory[0]));
//
//                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

// Add the components to the frame; by default, the frame has a border layout

            frame.add(textArea, BorderLayout.NORTH);
            frame.add(textArea1, BorderLayout.WEST);
            frame.add(textArea2, BorderLayout.EAST);
            coins[0] += factory[0]*2;
            factory[0] += plantation[0]*3;
            System.out.println("Coins: "+coins[0]);
            System.out.println("Factories: "+factory[0]);
            System.out.println("Plantations: "+plantation[0]);


// Show the frame

            int width = 1000;

            int height = 1000;

            frame.setSize(width, height);

            frame.setVisible(true);


        }
    }
    // }

}