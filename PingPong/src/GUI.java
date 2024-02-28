

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;


public class GUI implements KeyListener, MouseListener{
	JFrame frame=new JFrame();
	
	JLabel LaserLabel1=new JLabel();
	JLabel LaserLabel2=new JLabel();
	
	
	JLabel BallLabel=new JLabel();
	
	JLabel player1Label=new JLabel();
	JLabel player2Label=new JLabel();
	
	JLabel RedColorLabel1=new JLabel();
	JLabel GreenColorLabel1=new JLabel();
	JLabel BlueColorLabel1=new JLabel();
	
	JLabel RedColorLabel2=new JLabel();
	JLabel GreenColorLabel2=new JLabel();
	JLabel BlueColorLabel2=new JLabel();
	
	JLabel notReadyLabel1=new JLabel();
	JLabel readyLabel1=new JLabel();
	
	JLabel notReadyLabel2=new JLabel();
	JLabel readyLabel2=new JLabel();
	
	JLabel centerLabel=new JLabel();

	JLabel loadingLabel=new JLabel();

	JLabel spaceLabel=new JLabel();
	
	JLabel winLabel=new JLabel();

	ImageIcon RedLaserImage=new ImageIcon("RedLaser.png");
	ImageIcon GreenLaserImage=new ImageIcon("GreenLaser.png");
	ImageIcon BlueLaserImage=new ImageIcon("BlueLaser.png");
	
	ImageIcon BallImage=new ImageIcon("Ball.png");
	ImageIcon BallImage2=new ImageIcon("Ball2.png");
	ImageIcon BallImage3=new ImageIcon("Ball3.png");
	ImageIcon BallImage4=new ImageIcon("Ball4.png");

	ImageIcon[]ballImages=new ImageIcon[4];
		
	ImageIcon winImage=new ImageIcon("winImage.png");
	
	
	
	ImageIcon player1Image=new ImageIcon("Player1.png");
	ImageIcon player2Image=new ImageIcon("Player2.png");
	
	ImageIcon colorGreenImage=new ImageIcon("green.png");
	ImageIcon colorBlueImage=new ImageIcon("blue.png");
	ImageIcon colorRedImage=new ImageIcon("red.png");
	
	ImageIcon notReadyImage=new ImageIcon("ready.png");
	ImageIcon readyImage=new ImageIcon("notReady.png");
	

	ImageIcon loadingImage=new ImageIcon("loading.png");
	
	ImageIcon spaceImage=new ImageIcon("space.png");

	
	File LaserSound1File=new File("LaserSound1.wav");
	File LaserSound2File=new File("LaserSound2.wav");
	File LaserSound4File=new File("LaserSound4.wav");
	File LaserSound5File=new File("LaserSound5.wav");
	File clickFile=new File("click.wav");
	File readySoundFile=new File("readySound.wav");
	
	File gameSoundFile=new File("gameSound.wav");
	
	File loadingSoundFile=new File("loadingSound.wav");
	
	Clip LaserSound1Clip;
	Clip LaserSound2Clip;
	Clip LaserSound3Clip;
	Clip LaserSound4CLip;
	Clip LaserSound5Clip;
	Clip clickClip;
	Clip readySoundClip;
	Clip gameSoundClip;
	Clip loadingSoundClip;
	
	Clip winSound1Clip;
	Clip winSound2Clip;
	Clip winSound3Clip;
	Clip winSound4Clip;
	Clip winSound5Clip;
	
	Clip[]winSounds=new Clip[5];
	Random random=new Random();
	
	boolean[]Player1Ready=new boolean[2];
	boolean[]Player2Ready=new boolean[2];
	
	int cycle1;
	int cycle2;
	
	ImageIcon color1=new ImageIcon("BlueLaser.png");
	ImageIcon color2=new ImageIcon("RedLaser.png");
	
	boolean pass=true;
	
	Border border=BorderFactory.createLineBorder(Color.white, 5);
	
	boolean[]released=new boolean[4];
	
static int x=1;

static int turn=0;

int addition=0;

boolean pass5sec=true;
boolean pass10sec=true;
boolean pass15sec=true;
boolean pass20sec=true;

int[]plusMinus=new int[2];

static int value=1;

long start=System.currentTimeMillis();

int valueY=0;
Clip[]sounds=new Clip[4];

boolean endPass=true;
Timer timer=new Timer();


static int loadingCount=1;


public	GUI() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
	
	winSounds[0]=winSound1Clip;
	winSounds[1]=winSound2Clip;
	winSounds[2]=winSound3Clip;
	winSounds[3]=winSound4Clip;
	winSounds[4]=winSound5Clip;
	
	plusMinus[0]=2;
	plusMinus[1]=-2;
	
	ballImages[0]=BallImage;
	ballImages[1]=BallImage2;
	ballImages[2]=BallImage3;
	ballImages[3]=BallImage4;
	
	released[0]=true;
	released[1]=true;
	released[2]=true;
	released[3]=true;
	
	AudioInputStream audio1=AudioSystem.getAudioInputStream(LaserSound1File);
	LaserSound1Clip=AudioSystem.getClip();
	LaserSound1Clip.open(audio1);
	sounds[0]=LaserSound1Clip;
	
	AudioInputStream audio2=AudioSystem.getAudioInputStream(LaserSound2File);
	LaserSound2Clip=AudioSystem.getClip();
	LaserSound2Clip.open(audio2);
	sounds[1]=LaserSound2Clip;
	
//	AudioInputStream audio3=AudioSystem.getAudioInputStream(LaserSound3File);
//	LaserSound3Clip=AudioSystem.getClip();
//	LaserSound3Clip.open(audio3);
//	sounds[2]=LaserSound3Clip;

	AudioInputStream audio4=AudioSystem.getAudioInputStream(LaserSound4File);
	LaserSound4CLip=AudioSystem.getClip();
	LaserSound4CLip.open(audio4);
	sounds[2]=LaserSound4CLip;
	
	AudioInputStream audio5=AudioSystem.getAudioInputStream(LaserSound5File);
	LaserSound5Clip=AudioSystem.getClip();
	LaserSound5Clip.open(audio5);
	sounds[3]=LaserSound5Clip;
	
	AudioInputStream audio6=AudioSystem.getAudioInputStream(clickFile);
	clickClip=AudioSystem.getClip();
	clickClip.open(audio6);
	
	AudioInputStream audio7=AudioSystem.getAudioInputStream(readySoundFile);
	readySoundClip=AudioSystem.getClip();
	readySoundClip.open(audio7);
	
	AudioInputStream audio8=AudioSystem.getAudioInputStream(gameSoundFile);
	gameSoundClip=AudioSystem.getClip();
	gameSoundClip.open(audio8);

	AudioInputStream audio9=AudioSystem.getAudioInputStream(loadingSoundFile);
	loadingSoundClip=AudioSystem.getClip();
	loadingSoundClip.open(audio9);
	
	
	
	Player1Ready[1]=true;
	Player2Ready[1]=true;
    
	cycle1=0;
	cycle2=0;
	
	frame.setVisible(true);
	frame.setSize(1440,1000);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(new Color(0,0,0));
	frame.setLayout(null);
	frame.addKeyListener(this);
	
	winLabel.setIcon(winImage);
	
	LaserLabel1.setIcon(color1);
	LaserLabel2.setIcon(color2);
	
	BallLabel.setIcon(BallImage);
	
	RedColorLabel2.setIcon(colorRedImage);
	RedColorLabel2.setBounds(1040+85, 250, 50, 50);
	RedColorLabel2.addMouseListener(this);

	
	GreenColorLabel2.setIcon(colorGreenImage);
	GreenColorLabel2.setBounds(1040+85+85, 250, 50, 50);
	GreenColorLabel2.addMouseListener(this);

	
	BlueColorLabel2.setIcon(colorBlueImage);
	BlueColorLabel2.setBounds(1040, 250, 50, 50);
	BlueColorLabel2.addMouseListener(this);

	
	RedColorLabel1.setIcon(colorRedImage);
	RedColorLabel1.setBounds(245, 250, 50, 50);
	RedColorLabel1.addMouseListener(this);

	
	GreenColorLabel1.setIcon(colorGreenImage);
	GreenColorLabel1.setBounds(330, 250, 50, 50);
	GreenColorLabel1.addMouseListener(this);

	
	BlueColorLabel1.setIcon(colorBlueImage);
	BlueColorLabel1.setBounds(160, 250, 50, 50);
	BlueColorLabel1.addMouseListener(this);
	
	readyLabel1.setIcon(notReadyImage);
	readyLabel1.setBounds(120, 500, 260, 110);
	readyLabel1.addMouseListener(this);
	
	readyLabel2.setIcon(notReadyImage);
	readyLabel2.setBounds(1440-(440), 500, 260, 110);
	readyLabel2.addMouseListener(this);
	
	player1Label.setIcon(player1Image);
	player1Label.setBounds(160, 50, 240, 50);
	
	
	player2Label.setIcon(player2Image);
	player2Label.setBounds(1440-400, 50, 240, 50);
	
	loadingLabel.setIcon(loadingImage);
	
	spaceLabel.setIcon(spaceImage);
	
	frame.add(player1Label);
	frame.add(player2Label);
	frame.add(RedColorLabel1);
	frame.add(RedColorLabel2);
	frame.add(GreenColorLabel1);
	frame.add(GreenColorLabel2);
	frame.add(BlueColorLabel1);
	frame.add(BlueColorLabel2);
	frame.add(notReadyLabel1);
	frame.add(readyLabel1);
	frame.add(notReadyLabel2);
	frame.add(readyLabel2);
	

	
	
	
	
	
//	RedLaserLabel.setLocation(1440-52, 500-110);
//	BlueLaserLabel.setLocation(69, 500-110);
//	
	
	
}
private void directionChanger1() {
	

	 if(released[0]==false) {
		 
		
		 if(valueY<0) {
			 valueY=-1*((int)(Math.abs(x)/2) +1);
		 }
		 else if(valueY>0) {
			 valueY=-1*((int)(Math.abs(x)/5) +1);
		 }
		 else {
			 valueY=-1*((int)(Math.abs(x)/4) + 1);
		 }
		
	 }
	 if(released[1]==false) {
		 
			
		 if(valueY<0) {
			 valueY=1*((int)(Math.abs(x)/2) +1);
		 }
		 else if(valueY>0) {
			 valueY=1*((int)(Math.abs(x)/5) +1);
		 }
		 else {
			 valueY=(int)(Math.abs(x)/4) + 1;
		 }
		 
	 }
	
}

private void directionChanger2() {
	

	 if(released[3]==false) {
		 
		 if(valueY<0) {
			 
			 
			 valueY=-1*((int)(Math.abs(x)/2) +1);
		 }
		 else if(valueY>0) {
			 valueY=-1*((int)(Math.abs(x)/5) +1);
		 }
		 else {
			 valueY=-1*((int)(Math.abs(x)/4) + 1);
		 }
	 }
	if(released[2]==false) {
		 
		if(valueY<0) {
			 valueY=((int)(Math.abs(x)/2) +1);
		 }
		 else if(valueY>0) {
			 valueY=((int)(Math.abs(x)/5) +1);
		 }
		 else {
			 valueY=((int)(Math.abs(x)/4) + 1);
		 }
		 
	 }
	
}
private void soundEffectPLayer() {
	Random random=new Random();
	int index=random.nextInt(0,4);
	sounds[index].setMicrosecondPosition(0);
	sounds[index].start();
}
private void speedingUp() {
	if(System.currentTimeMillis()-start>5000 && pass5sec) {
		 addition++;
		 pass5sec=false;
	 }
	 else if(System.currentTimeMillis()-start>10000 && pass10sec) {
		 addition=addition+2;
		 pass10sec=false;
	 }
	 else if(System.currentTimeMillis()-start>15000 && pass15sec) {
		 addition=addition+3;
		 pass15sec=false;
	 }
	 else if(System.currentTimeMillis()-start>20000 && pass20sec) {
		 addition=addition+4;
		 pass20sec=false;
	 }
	 else if(pass20sec!=true && System.currentTimeMillis()-start>addition*2000)
		 addition++;
}

//void collisionEffectDisplayer1(){
//	if(LaserLabel1)
//}
//void collisionEffectDisplayer2(){
//	if()
//}

void directionChangerOnEdge1() {
	
	
	
	if(released[0]==false) {
		 
		
		 if(valueY<0) {
			 valueY*=-x;
			 x=x/5;
		 }
	
		 else {
			 valueY*=-x/2;
			 x=x/3;
			 
		 }
		
	 }
	 if(released[1]==false) {
		 
			
		 
		  if(valueY>0) {
			 valueY-=addition/2;
			 x+=addition/2;
		 }
		 else {
			 valueY-=addition/3;
			 x+=addition/3;
			 
		 }
		 
	 }
	
}

void directionChangerOnEdge2() {
	
}

 private void collisions() {
	 
	 int ballLocationX1=BallLabel.getX();              
	 int ballLocationX2=BallLabel.getX()+50;
	 int ballLocationY1=BallLabel.getY();
	 int ballLocationY2=BallLabel.getY()+54;
	 
	 int laser1LocationX1=LaserLabel1.getX();           
	 int laser1LocationX2=LaserLabel1.getX()+200;
	 int laser1LocationY1=LaserLabel1.getY()-26;
	 int laser1LocationY2=LaserLabel1.getY()+200;
	 
	 int laser2LocationX1=LaserLabel2.getX();              
	 int laser2LocationX2=LaserLabel2.getX()+200;
	 int laser2LocationY1=LaserLabel2.getY()-26;
	 int laser2LocationY2=LaserLabel2.getY()+200;
	 
	 if(laser1LocationX2>=ballLocationX1+92 &&
		laser1LocationY1<=ballLocationY1 && laser1LocationY2>=ballLocationY1  ) {
		 
		 soundEffectPLayer();
		 
//		 if(laser1LocationY1>=ballLocationY2-15) {
//			 
//			 x*=-1;
//			 if(x<0)x-=value;
//			 else x+=value;
//			 
//			
//			 
//			 
//			 
//			 directionChangerOnEdge1();
//			 
//			
//			 
//		 }
			 
//	 else {
		 // speedingUp();
		
		 x*=-1;
		 if(x<0)x-=value;
		 else x+=value;
		 
		 directionChanger1();
		 
//		 }
		 
	 }
	 if(laser2LocationX1<=ballLocationX2-92 &&
  	    laser2LocationY1<=ballLocationY1 && laser2LocationY2>=ballLocationY1        ) {
		 soundEffectPLayer();
		// speedingUp();
		 
		 x*=-1;
		 if(x<0)x-=value;
		 else x+=value;
		 
		 directionChanger2();
		
	 }
	
	 if(ballLocationY1<=-8) {
		//int error= -8 - BallLabel.getY();
		//BallLabel.setLocation(BallLabel.getX(), BallLabel.getY()+error);
		valueY*=-1;
	 }
	 
	 if(ballLocationY2>=793) {
		//	int error= 793 - ballLocationY2;
		//	BallLabel.setLocation(BallLabel.getX(), BallLabel.getY()+error);
			valueY*=-1;
		 }
	 
	 
	 if(ballLocationX1<=-20 && endPass) {
		 player2Label.setIcon(new ImageIcon("Player2Big.png"));
		endGameScreen(player2Label);
		endPass=false;
		 }
	 
	 if(ballLocationX2>=1460 && endPass) {
		 player1Label.setIcon(new ImageIcon("Player1Big.png"));
		 endGameScreen(player1Label);
		 endPass=false;
			 }
	 
}


void updaterHelper() throws InterruptedException {
	
	x=plusMinus[random.nextInt(0,2)];


TimerTask task=new TimerTask() {
	
	@Override
	public void run() {
		updater();
	}
};
	 
	 timer.schedule(task, 0, 1000/60);
	 
	 
}



void updater() {
	
	 BallLabel.setLocation(BallLabel.getX()-x, BallLabel.getY()+valueY);
	 collisions();

	 
//System.out.println(x);
	
	 
}

void endGameScreen(JLabel label) {
	timer.cancel();
	frame.getContentPane().removeAll();
	frame.setVisible(false);
	frame.setVisible(true);
	
	gameSoundClip.close();
	
	frame.add(label);
	label.setBounds(550, 0, 500, 500);
	frame.add(winLabel);
	winLabel.setBounds(550,500,500,160);
	
	int index=random.nextInt(0,5);
	
	
	Timer timer=new Timer();
	TimerTask task=new TimerTask() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.exit(1);
		}
		
	};
	timer.schedule(task, 10000);
	
	
}
void loadingScreen() throws InterruptedException {
	frame.getContentPane().removeAll();
	frame.setVisible(false);
	frame.setVisible(true);
	JLabel guideLabel=new JLabel();
	guideLabel.setText("PLAYER 1 KEYS: A --> UP  D--> DOWN/N PLAYER 2 KEYS: RIGHT ARROW--> UP  LEFT ARROW--> DOWN");
	guideLabel.setFont(new Font("Pixel Coleco",50,50));
	frame.add(guideLabel);
	guideLabel.setBounds(500,30,200,200);
	
	frame.add(loadingLabel);
	loadingLabel.setBounds(500, 400, 466, 154);
	
	Timer timer=new Timer();
	
	TimerTask task=new TimerTask() {

		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			String fullPath=("loading"+loadingCount+".png");
			
			
			
			
            loadingLabel=new JLabel(fullPath);
            frame.add(loadingLabel); 
            loadingLabel.setBounds(100, 100, 750, 442);
        
           
            loadingCount++;
			if(loadingCount>=10) {
				
				loadingSoundClip.close();
				
				timer.cancel();
				
				frame.getContentPane().removeAll();
				frame.setVisible(false);
				frame.setVisible(true);
				
				
				
				try {
					gameScreen();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	};
	
	timer.schedule(task, 0, 500);
	
	
}

	

void gameScreen() throws InterruptedException {
	clickClip.close();
	readySoundClip.close();
	
gameSoundClip.start();
	

//	frame.remove(player1Label);
//	frame.remove(player2Label);
//	frame.remove(RedColorLabel1);
//	frame.remove(RedColorLabel2);
//	frame.remove(GreenColorLabel1);
//	frame.remove(GreenColorLabel2);
//	frame.remove(BlueColorLabel1);
//	frame.remove(BlueColorLabel1);
//	frame.remove(notReadyLabel1);
//	frame.remove(readyLabel1);
//	frame.remove(notReadyLabel2);
//	frame.remove(readyLabel2);
	
//	frame.getContentPane().removeAll();
	
    
	frame.add(BallLabel);
	BallLabel.setBounds(675 , 418, 50, 54);
	frame.add(centerLabel);
	centerLabel.setBounds(455, -20, 490, 700);
	
	frame.add(LaserLabel1);
	LaserLabel1.setBounds(-90 , 355, 200, 300);
	frame.add(LaserLabel2);
	LaserLabel2.setBounds(1440-110 , 355, 200, 300);
	
	frame.add(spaceLabel);
	spaceLabel.setBounds(0, 0, 1440, 1000);
	
	updaterHelper();
	
//	int milisInAMinute = 1000/2;
//	long time = System.currentTimeMillis();
//
//	Runnable update = new Runnable() {
//	    public void run() {
//	        // Do whatever you want to do when the minute changes
//	    }
//	};
//
//	Timer timer = new Timer();
//	timer.schedule(new TimerTask() {
//	    public void run() {
//	        update.run();
//	    }*\
//	}, time % milisInAMinute, milisInAMinute);
//
//	// This will update for the current minute, it will be updated again in at most one minute.
//	update.run();
	
}

int readyChanger(int cycle) {
	if(cycle==0)cycle=1;
	else if(cycle==1)cycle=0;
	return cycle;
}

@Override
public void keyTyped(KeyEvent e) {
	
	
//	if(pass==false)
//		switch(e.getKeyChar()) {
//		case 'A': LaserLabel1.setLocation(LaserLabel1.getX(),LaserLabel1.getY()-30);
//			break;
//		case 'D': LaserLabel1.setLocation(LaserLabel1.getX(),LaserLabel1.getY()+30);
//		break;
//		}
//	
	
}

@Override
public void keyPressed(KeyEvent e) {
	 //37-->left arrow(2)  39-->right arrow (3)  65--> a(0) 68--> d(1)
	
	
	if(e.getKeyCode()==37 && pass==false && LaserLabel2.getY()<570) {
		LaserLabel2.setLocation(LaserLabel2.getX(), LaserLabel2.getY()+15);
		
		released[2]=false;
	}
	if(e.getKeyCode()==39 && pass==false && LaserLabel2.getY()>-30) {
		LaserLabel2.setLocation(LaserLabel2.getX(), LaserLabel2.getY()-15);
		
		released[3]=false;
	}
	if(e.getKeyCode()==65 && pass==false && LaserLabel1.getY()>-30) {
		LaserLabel1.setLocation(LaserLabel1.getX(), LaserLabel1.getY()-15);
		
		released[0]=false;
	}
	if(e.getKeyCode()==68 && pass==false && LaserLabel1.getY()<570) {
		LaserLabel1.setLocation(LaserLabel1.getX(), LaserLabel1.getY()+15);
		
		released[1]=false;
	}
	
	
	
	
	if(released[2]==false && e.getKeyCode()!=37 && LaserLabel2.getY()<570) {
		LaserLabel2.setLocation(LaserLabel2.getX(), LaserLabel2.getY()+15);
	}
	if(released[3]==false && e.getKeyCode()!=39 && LaserLabel2.getY()>-30) {
		LaserLabel2.setLocation(LaserLabel2.getX(), LaserLabel2.getY()-15);
	}
	if(released[0]==false && e.getKeyCode()!=65 && LaserLabel1.getY()>-30) {
		LaserLabel1.setLocation(LaserLabel1.getX(), LaserLabel1.getY()-15);
	}
	if(released[1]==false && e.getKeyCode()!=68 && LaserLabel1.getY()<570) {
		LaserLabel1.setLocation(LaserLabel1.getX(), LaserLabel1.getY()+15);
	}
	
}

@Override
public void keyReleased(KeyEvent e) {
	if(e.getKeyCode()==37 && pass==false) {
		
		released[2]=true;
	}
	if(e.getKeyCode()==39 && pass==false) {
	
		released[3]=true;
	}
	if(e.getKeyCode()==65 && pass==false) {
		
		released[0]=true;
	}
	if(e.getKeyCode()==68 && pass==false) {
		
		released[1]=true;
	}
	
}


@Override
public void mouseClicked(MouseEvent e) {
	
	if(e.getSource()==readyLabel1) {
		clickClip.setMicrosecondPosition(0);
		readySoundClip.start();
		cycle1=readyChanger(cycle1);
		if(cycle1==1)readyLabel1.setIcon(readyImage);
		else if(cycle1==0)readyLabel1.setIcon(notReadyImage);
		
	}
	
	if(e.getSource()==readyLabel2) {
		clickClip.setMicrosecondPosition(0);
		readySoundClip.start();
		cycle2=readyChanger(cycle2);
		if(cycle2==1)readyLabel2.setIcon(readyImage);
		else if(cycle2==0)readyLabel2.setIcon(notReadyImage);
	}
	
	
if(e.getSource()==RedColorLabel1) {
	clickClip.setMicrosecondPosition(0);
	clickClip.start();
		color1=new ImageIcon("RedLaser.png");
		LaserLabel1.setIcon(color1);
		RedColorLabel1.setBorder(border);
		GreenColorLabel1.setBorder(null);
		BlueColorLabel1.setBorder(null);
	
	}
if(e.getSource()==GreenColorLabel1) {
	clickClip.setMicrosecondPosition(0);
	clickClip.start();
		color1=new ImageIcon("GreenLaser.png");
		LaserLabel1.setIcon(color1);
		GreenColorLabel1.setBorder(border);
		BlueColorLabel1.setBorder(null);
		RedColorLabel1.setBorder(null);
		
	}
if(e.getSource()==BlueColorLabel1) {
	clickClip.setMicrosecondPosition(0);
	clickClip.start();
	color1=new ImageIcon("BlueLaser.png");
	LaserLabel1.setIcon(color1);
	BlueColorLabel1.setBorder(border);
	GreenColorLabel1.setBorder(null);
	RedColorLabel1.setBorder(null);
}
if(e.getSource()==RedColorLabel2) {
	clickClip.setMicrosecondPosition(0);
	clickClip.start();
	color2=new ImageIcon("RedLaser.png");
	
	LaserLabel2.setIcon(color2);
	RedColorLabel2.setBorder(border);
	GreenColorLabel2.setBorder(null);
	BlueColorLabel2.setBorder(null);
	
}
if(e.getSource()==BlueColorLabel2) {
	clickClip.setMicrosecondPosition(0);
	clickClip.start();
	color2=new ImageIcon("BlueLaser.png");
	LaserLabel2.setIcon(color2);
	BlueColorLabel2.setBorder(border);
	GreenColorLabel2.setBorder(null);
	RedColorLabel2.setBorder(null);
	
}
if(e.getSource()==GreenColorLabel2) {
	clickClip.setMicrosecondPosition(0);
	clickClip.start();
	color2=new ImageIcon("GreenLaser.png");
	LaserLabel2.setIcon(color2);
	GreenColorLabel2.setBorder(border);
	BlueColorLabel2.setBorder(null);
	RedColorLabel2.setBorder(null);
}

if(Player1Ready[cycle1]&&Player2Ready[cycle2]&&pass) {
	pass=false;
	try {
		loadingScreen();
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
	
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}





}
