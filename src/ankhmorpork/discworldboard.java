package ankhmorpork;
import java.awt.AWTEvent;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import ankhmorpork.Game.Game;
import ankhmorpork.GameLoad.GameLoad;
import ankhmorpork.GameLoad.GameSave;
import ankhmorpork.GameLoad.GameStart;
import ankhmorpork.GameObjects.Area;
import ankhmorpork.GameObjects.Demon;
import ankhmorpork.GameObjects.Minion;
import ankhmorpork.GameObjects.Player;
import ankhmorpork.GameObjects.Troll;
import ViewFile.SaveFileAmbg;
import ViewFile.ViewFileAmbg;

public class discworldboard extends Component {
	
	private int Width  = 1200;
	private int Height = 900;
	private discworld discworld;
	static final Frame quit = new Frame("Are you sure?");
	public boolean rolled = false;
		private int Dice1 = 0;


		public discworldboard( ) {


		enableEvents( AWTEvent.MOUSE_EVENT_MASK );
		enableEvents( AWTEvent.KEY_EVENT_MASK );
		repaint();
	}


	
	public void paint( Graphics g ) {
		//Draw the board
//		g.drawImage(board,1,1,this);
		g.setColor( new Color( (80), (180), (210) ) ); 		

//		g.setColor(Color.lightGray);

		g.setColor( new Color( (100), (30), (100) ) );
		g.fill3DRect( 10, 10, 200, 200, true );				//12
		g.fill3DRect( 210, 10, 250, 100, true );				//12


		//g.setColor( new Color( (80), (180), (210) ) ); //blue color
		g.setColor( new Color( (100), (50), (50) ) );
		g.fill3DRect( 460, 10, 200, 200, true );				//1
		g.fill3DRect( 10, 210, 200, 200, true );				//11
		
		g.setColor( new Color( (80), (180), (110) ) ); 
		g.fill3DRect( 210, 110, 250, 150, true );				//2
		
		g.setColor( new Color( (80), (100), (210) ) ); 
		g.fill3DRect( 210, 260, 150, 200, true );				//10
		

		g.setColor( new Color( (200), (30), (200) ) );
		g.fill3DRect( 360, 210, 150, 160, true );				//4
		g.fill3DRect( 510, 210, 150, 140, true );				//3.
		g.setColor( new Color( (120), (30), (200) ) );

		g.fill3DRect( 10, 410, 200, 250, true );				//9
		g.setColor( new Color( (70), (50), (140) ) );

		g.fill3DRect( 210, 460, 150, 200, true );				//8	

		g.setColor( new Color( (160), (30), (100) ) );
		g.fill3DRect( 360, 370, 150, 150, true );				//5	
		
		g.setColor( new Color( (200), (30), (200) ) );
		g.fill3DRect( 360, 520, 150, 140, true );				//7
		
		g.setColor( new Color( (200), (50), (200) ) );
		g.fill3DRect( 510, 350, 150, 310, true );				//6

		//Draw the dice
		g.setColor(Color.black);
		g.setFont( new Font( "verdana", Font.BOLD, 20) );
		g.drawString("1",465, 35);
		g.drawString("2",215, 135);
		g.drawString("3",515, 235);
		g.drawString("4",365, 235);
		g.drawString("5",365, 395);
		g.drawString("6",515, 375);
		g.drawString("7",365, 545);
		g.drawString("8",215, 485);
		g.drawString("9",15, 435);
		g.drawString("10",215, 285);
		g.drawString("11",15, 235);
		g.drawString("12",15, 35);



		g.setColor( new Color( (230), (230), (230) ) );
		g.setFont( new Font( "verdana", Font.BOLD, 20 ) );


	}
	

	
	//The usual component methods
	public boolean contains( int x, int y ) {
		if( x>0  &&  x<Width  &&  y>0  &&  y<Height ) 
			return true;
		return false;
	}
	public Dimension getPreferredSize() {
		return new Dimension( Width, Height );
	}
	public Dimension getMinimumSize() {
		return new Dimension( Width, Height );
	}
	

		
	//quiting the program;
	public void quit() {
	final Frame quit = new Frame();
		final Label question = new Label("Are you sure you want to end this game?" );
		final Button yes = new Button("Yes" );
		final Button no = new Button( "NO" );
		quit.setSize( 400, 90 );
		quit.setBackground( Color.lightGray );
		quit.setLayout( new FlowLayout(FlowLayout.CENTER) );
		quit.add( question);
		quit.add( yes );
		quit.add( no );
		quit.setVisible( true );
		no.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				quit.setVisible(false);
				}
				
		});
		yes.addActionListener ( new ActionListener() {
		    public void actionPerformed ( ActionEvent e) {
			//System.out.println("quit");
			quit.setVisible(false);
			discworld.AnkhmorporkFrame.setVisible(false);//System.exit(0);
			}
			});
		quit.addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent e ) {
				quit.setVisible( false );
				repaint();
			}
		});
		repaint();
	}
	//either the 'roll' button was clicked or 'r' was pressed.
	public void Roll() {
		Dice1 = ( int )( Math.random() * 12 + 1 );
			rolled = true;

		repaint();
	}
	
	public void ViewGameState(){
		String viewStateData = ViewFileAmbg.ViewState();
		SaveFileAmbg abc = new SaveFileAmbg();
		abc.Viewer(viewStateData);
	}
	
	public void SaveGame(FileWriter objFileWriter, Game PlayedGame) throws IOException, JSONException{
		GameSave.SaveGame(objFileWriter, PlayedGame);
	}
	
	public void Loadgamefetch(FileReader objFileReader) throws IOException, ParseException
	{
		 GameLoad.LoadGame(objFileReader);
	}
	
	public void InitialiseGame(int iNoOfPlayers, Game AnkhMorpork)
	{					
		String[] Players = new String[10];
		String[] Colors = new String[10];
		for(int i=1;i<=iNoOfPlayers;i++)
		{
		Players[i]= JOptionPane.showInputDialog("Please input Name for Player:" + i);
		Colors[i] = JOptionPane.showInputDialog("Please input Color for Player:" + i);
		}
	
		GameStart.StartNewGame(Players, Colors, iNoOfPlayers, AnkhMorpork);
	}
	
	
	

	//start a new game
	public void New() {
		final Frame a = new Frame();
		final TextField tf1 = new TextField("Player 1", 20 );
		final TextField tf2 = new TextField("Player 2", 20 );
		final Button b = new Button( "Save Game");
		a.setSize( 800, 200 );
		a.setBackground( Color.lightGray );
		a.setLayout( new FlowLayout(FlowLayout.CENTER) );
		a.add( tf1);
		a.add( b );
		a.add( tf2 );
		a.setVisible( true );

		a.addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent e ) {
				a.setVisible( false );
				repaint();
			}
		});
		repaint();
	}
	
}

