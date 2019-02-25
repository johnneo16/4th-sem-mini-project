import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SimpleAni
{
	static SimpleAni ani = new SimpleAni();
    boolean GameOver = false, WallTouch = false;
    int x = 258, y = 285, ix=1, iy=1, fx = 516, fy = 570, mov; 
    public static void main(String[] args)
    {
    	ani.start1();
    }
    
    public void start1()
    {
    	ani.finish();
    	GameOver=false;
    	WallTouch=false;
    	x = 0;
    	y = 0;
    	ani.go();
    	
    }
    public void go()
    {
        JButton down = new JButton("DOWN");
        JButton up = new JButton("UP");
        JButton left = new JButton("LEFT");
        JButton right = new JButton("RIGHT");
       
        JFrame frame = new JFrame("A-MAZE-IN");
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myDrawPanel drawPanel = new myDrawPanel();
        drawPanel.setSize(400,400);
        drawPanel.repaint();

        frame.getContentPane().add(BorderLayout.SOUTH, down);
        frame.getContentPane().add(BorderLayout.NORTH, up);
        frame.getContentPane().add(BorderLayout.EAST, right);
        frame.getContentPane().add(BorderLayout.WEST, left);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

        frame.setSize(700, 700);
        frame.setVisible(true);        
        
        down.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionEvent)
            {

                iy = 1;
                mov = 2;
            }
        });        
        

        up.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionEvent)
            {

                iy = 1;
                mov = 8;
            }
        });
        

        

        left.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionEvent) {

                ix = 1;
                mov = 4;
            }
            });
        

        right.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionEvent)
                {

                    ix = 1;
                    mov = 6;
                }
        });
        
        
             
        while(!GameOver)
        {
        	


                if (mov == 2) {
                    y = y+iy;
                }

                if (mov == 6) {
                    x = x+ix;
                }

                if (mov == 4) {
                    x= x-ix;
                }

                if (mov == 8) {
                    y = y-iy;
                }
                
                
                drawPanel.repaint();

                try {
                    Thread.sleep(20);
                } catch (Exception ex) {
                    //Can't do anything now. Can we?
                }

        }//while
    }//go
    
    class myDrawPanel extends JPanel
    {
    	   	
        public void paintComponent(Graphics g)
        {
        	int m = 0;
        	if (x < 0 ||x > (this.getWidth()-40)) {
                ix*=0;
            }
            if (y < 0 ||y > (this.getHeight()-40)) {
                iy*=0;
            }
            if(x==fx&&y==fy)
            {
                try
                { 
                	GameOver=true;
                	JOptionPane.showMessageDialog(this,  "HOORAY\nYOU MADE IT!!!");
                	                	          
                } catch (Exception ex)
                {
                    //Can't do anything now. Can we?
                }
            }
            
            if (x>20 && x<516&& y<40)
            {
                ix=0;
                iy=0;
                WallTouch = true;
            	GameOver=true;
            }//first wall
           if(x<40 && y>70 && y<570)
           { ix=0;
           iy=0;
           WallTouch = true;
       	GameOver=true;
           }//left wall
           if(x>40 && x<250 && y<160 && y>70)
           {
        	   ix=0;
               iy=0;
               WallTouch = true;
           	GameOver=true;   
           }//wall 1
           if(x<130 && x>90 && y<310 && y>110)
           {
        	    ix=0;
                iy=0;
                WallTouch = true;
            	GameOver=true;   
           }//wall 2
           if(x>40 && x<240 && y>460 && y<540)
           {
        	   ix=0;
               iy=0;
               WallTouch = true;
           	GameOver=true;   
           }//wall 3
           if(x>200 && x<460 && y>390 && y<460)
           {
        	   ix=0;
               iy=0;
               WallTouch = true;
           	GameOver=true;   
           }//wall 4
           if(x>260 && x<340 && y>460 && y<550)
           {
        	   ix=0;
               iy=0;
               WallTouch = true;
           	GameOver=true;    
           }//wall 5
           if(x>240 && x<490 && y>290 && y<370)
           {
        	   ix=0;
               iy=0;
               WallTouch = true;
           	GameOver=true;    
           }//wall 6
           if(x>270 && x<350 && y>40 && y<260)
           {
        	   ix=0;
               iy=0;
               WallTouch = true;
           	GameOver=true;    
           }//wall 7
           if(x>350 && x<480 && y>190 && y<260)
           {
        	   ix=0;
               iy=0;
               WallTouch = true;
           	GameOver=true;  
           }//wall 8
           if(x>450 && x<516 && y>470 && y<540)
           {
         	  ix=0;
               iy=0;
               WallTouch = true;
           	GameOver=true;    
           }//wall 9
           if(x>410 && x<516 && y>70 && y<170)
           {
        	   ix=0;
               iy=0;
               WallTouch = true;
           	GameOver=true;    
           }//wall 10
           if(x>40 && x<170 && y>370 && y<410)
           {
        	   ix=0;
               iy=0;
               WallTouch = true;
           	GameOver=true;    
           }//wall 11
           
            if(WallTouch)
            {
            	JOptionPane.showMessageDialog(this, "YOU LOST!!!\nYou touched the wall");
            }
            
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            
            g.setColor(Color.RED);
            g.fillRect(516, 570, 556, 610);
            g.setColor(Color.DARK_GRAY);
            g.fillRect(520, 574, 552, 606);
            
            g.setColor(Color.blue);
            g.fillRect(60, 0, 496, 40); //first wall
            g.fillRect(0, 110, 40, 560);//left wall
            
            g.setColor(Color.GREEN);
            g.fillRect(40,  110,  210,  50);//wall 1
            g.fillRect(90,  110,  40,  200);//wall 2
            g.fillRect(40, 500, 200, 40);//wall 3
            g.fillRect(240,  430,  220, 30);//wall 4
            
            g.setColor(Color.YELLOW);
            g.fillRect(300,  460,  40,  110);//wall 5
            g.fillRect(280,  330,  210,  40);//wall 6
            g.fillRect(310,  40,  40,  220);//wall 7
            
            g.setColor(Color.PINK);
            g.fillRect(350,  230,  130,  30);//wall 8
            g.fillRect(450, 510,  110,  30);//wall 9
            g.fillRect(450,  70, 110,  100);//wall 10
            g.fillRect(40, 410, 130, 40);//wall 11
            g.setColor(Color.red);
            g.fillOval(x, y, 40, 40);
        }
		
    }
   //myDrawPanel
    public void finish()
    {
			fx=516;
			fy=570;
	}
}//SimpleAni

