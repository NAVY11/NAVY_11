package ankhmorpork;
import java.applet.Applet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import ankhmorpork.GameLoad.*;
import ankhmorpork.GameObjects.*;

import java.applet.AudioClip;
import java.awt.event.*;
import java.awt.image.*;
import java.lang.*;
import java.util.*;
import java.net.*;
import java.awt.*;
import java.io.*;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import ankhmorpork.Game.Game;
import ankhmorpork.GameObjects.Area;

public class discworld extends Applet implements ActionListener, WindowListener {
	
	
	// object declaration
	Game AnkhMorpork = new Game();
	private static final long serialVersionUID = 1L;
	static Frame AnkhmorporkFrame = new Frame( " Ank Morpork " );
	static discworldboard discworldboard = new discworldboard( );
	static final DoubleBufferPanel doublebufferpane = new DoubleBufferPanel();
	static final BufferPanel bufferpane = new BufferPanel();
	static final Frame initframe = new Frame();
	private Button Roll  = new Button( "Roll Dice" );

	static final Button start2 = new Button( "Two Player" );		
	static final Button start3 = new Button( "Three Player" );
	static final Button start4 = new Button( "Four Player" );
	static final Button load = new Button( "Load Game!" );
	static final Button Quit = new Button ("Close");
	static final Button Exit = new Button ("Exit Game"); 
	static final Button ViewState = new Button ("View State"); 
	static final Button Save = new Button ("Save Game"); 
	static final Button Info = new Button ("Rules");
	Image back;
	
	public static void main(String argv[]) 
    {
    	new discworld();
    }

	//init function
	public void init() {

		initframe.setSize( 380, 390 );
		initframe.setBackground(new Color( (20), (100), (90) ));
		initframe.setLayout(new FlowLayout(FlowLayout.CENTER));
		initframe.setResizable(false);
		Panel initpanel = new Panel(new GridLayout(0,1));
		initpanel.add(new Label ("            "));
		initpanel.add(new Label ("            "));
		initpanel.add(start2);
		initpanel.add(start3);
		initpanel.add(start4);
		initpanel.add(load);
		initpanel.add(Exit);
		initframe.add(initpanel);
		initframe.setVisible( true );
		
		load.addActionListener(this);
		Exit.addActionListener(this);
		Info.addActionListener(this);
		start2.addActionListener( this );
		start3.addActionListener( this );
		start4.addActionListener( this );
		
		AnkhmorporkFrame.addWindowListener( this );
	}
	public void paint(Graphics g){
		g.drawImage(back,15,15,this);
	}
	public void actionPerformed( ActionEvent e) {
			if (e.getSource() == Exit){
				initframe.setVisible(false);    
			}
			
			if (e.getSource() == load){
				
					try {
						JFileChooser chooser = new JFileChooser();
					    chooser.setCurrentDirectory(new File("/home/me/Documents"));
					    int retrival = chooser.showSaveDialog(null);
					    if (retrival == JFileChooser.APPROVE_OPTION) {
					        
					            FileReader objFileReader = new FileReader(chooser.getSelectedFile());
					            discworldboard.Loadgamefetch(objFileReader);
								int i=1;
								for(Player objPlayer: AnkhMorpork.lstPlayers)
								{		
									System.out.println("Player "+ i + " Details");
									System.out.println("Player ID: "+objPlayer.getPlayer_id()+" Player Name:"+objPlayer.getPlayer_name()+" Player Color:"+objPlayer.getPlayer_color());
									System.out.println("Player ID:"+objPlayer.getPlayer_id()+" Gold Coin Details: "+objPlayer.objGoldCoin.getCoin_Available());
									i++;
								}
								Framebuilder();

					    } 
						
						
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
			}
					    
			if (e.getSource() == start2 || e.getSource() == start3 || e.getSource() == start4 ){
				//discworldboard = new discworldboard( );
				if(e.getSource() == start2){
				
					discworldboard.InitialiseGame(2,AnkhMorpork);
											
				}else if(e.getSource() == start3){	
				
					discworldboard.InitialiseGame(3,AnkhMorpork);
				
				}else if(e.getSource() == start4){
				
					discworldboard.InitialiseGame(4,AnkhMorpork);
			}
				
				Framebuilder();
				
				
					}
 		
	}
	Button exit = new Button ("<< Return Back");

 		public void Framebuilder(){
			
 			initframe.setVisible( false );
 			doublebufferpane.setLayout(new BorderLayout());
 			bufferpane.setLayout( new BorderLayout() );	
 			AnkhmorporkFrame.setSize( 2000,1500 );
 			AnkhmorporkFrame.setBackground(new Color( (100), (180), (150) ) ); //blue color
 			AnkhmorporkFrame.setLayout( new FlowLayout(FlowLayout.CENTER));
 			AnkhmorporkFrame.add(doublebufferpane );
 			doublebufferpane.add( "Center", bufferpane );
 			bufferpane.add( discworldboard);
 			
 			
 			Panel buttons = new Panel(new GridLayout(0,1));
 									
 					buttons.add(Roll);
 					Roll.addActionListener(new ActionListener() {
 						public void actionPerformed( ActionEvent e ) {
 								if( !discworldboard.rolled ) {
 									discworldboard.Roll();
 								}
 						}});

 					buttons.add(Save);
 					Save.addActionListener(new ActionListener() {
 						public void actionPerformed( ActionEvent e ) {
 							try {
 								
 								JFileChooser chooser = new JFileChooser();
 							    chooser.setCurrentDirectory(new File("/home/me/Documents"));
 							    int retrival = chooser.showSaveDialog(null);
 							    if (retrival == JFileChooser.APPROVE_OPTION) {
 							        
 							            FileWriter objFileWriter = new FileWriter(chooser.getSelectedFile()+".txt");
 							            discworldboard.SaveGame(objFileWriter,AnkhMorpork);

 							    } 
 							} catch (IOException e1) {
 								// TODO Auto-generated catch block
 								e1.printStackTrace();
 							} catch (JSONException e1) {
 								// TODO Auto-generated catch block
 								e1.printStackTrace();
 							}
 						}});	
 					buttons.add(ViewState);
 					ViewState.addActionListener(new ActionListener() {
 						public void actionPerformed( ActionEvent e ) {
 							discworldboard.ViewGameState();
 						}});
 					buttons.add(Quit);
 					Quit.addActionListener(new ActionListener() {
 						public void actionPerformed( ActionEvent e ) {
 							discworldboard.quit();
 						}});
 						
 								
 					AnkhmorporkFrame.add(buttons);
 					AnkhmorporkFrame.setVisible( true );
 			}

 		 		
	public void windowClosing( WindowEvent e ) {
		System.exit( 0 );
	}
	public void windowIconified( WindowEvent e ) {}
	public void windowClosed( WindowEvent e ) {}
	public void windowActivated( WindowEvent e ) {}
	public void windowDeactivated( WindowEvent e ) {}
	public void windowDeiconified( WindowEvent e ) {}
	public void windowOpened( WindowEvent e ) {}
	public void processKeyEvent (KeyEvent e) {
		if( e.getKeyChar() =='q' || e.getKeyChar() == 'Q'){
			AnkhmorporkFrame.setVisible (false);
		    System.exit(0);}
		}
}
