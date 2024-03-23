package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

public class UI {
	
	GameManagerMain ge;
	JFrame window;
	public JTextArea messageText;
	public JPanel bgPanel[] = new JPanel[10];
	public JLabel bgLabel[] = new JLabel[10];
	
	public UI(GameManagerMain ge) {
		this.ge = ge;
		
		createMainField();
		generateScreen();
		
		window.setVisible(true);
		
	}

	public void createMainField() {
		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		messageText = new JTextArea("What a nature");
		messageText.setBounds(50,400,700,150);
		messageText.setBackground(Color.gray);
		messageText.setForeground(Color.white);
		messageText.setEditable(false);
		messageText.setLineWrap(true);
		messageText.setWrapStyleWord(true);
		messageText.setFont(new Font("Book Antiqua", Font.PLAIN,26));
		
		window.add(messageText);
	}
	
	public void createBackground(int bgNumber, String objFileName){
		bgPanel[bgNumber] = new JPanel();
		bgPanel[bgNumber].setBounds(50,50,700,350);
		bgPanel[bgNumber].setBackground(Color.blue);
		bgPanel[bgNumber].setLayout(null);
		window.add(bgPanel[1]);
		
		bgLabel[bgNumber] = new JLabel();
		bgLabel[bgNumber].setBounds(0,0,700,350);
		
		ImageIcon bgIcon = new ImageIcon(getClass()
										.getClassLoader()
										.getResource(objFileName));
		bgLabel[bgNumber].setIcon(bgIcon);
	}
	
	public void createObject(int bgNumber, int objx, int objy, int objWidth, int objHeight, String objFileName, 
			String choice1name, String choice2name, String choice3name) {
		
		//Create PopMenu
		JPopupMenu popMenu = new JPopupMenu();
		JMenuItem menuItem[] = new JMenuItem[4]; 
		
		//Create List PopMenu (PopName)
		menuItem[1] = new JMenuItem(choice1name);
		popMenu.add(menuItem[1]);
		
		menuItem[2] = new JMenuItem(choice2name);
		popMenu.add(menuItem[2]);
		
		menuItem[3] = new JMenuItem(choice3name);
		popMenu.add(menuItem[3]);
		
		//Create Object
		JLabel ObjectLabel = new JLabel();
		//ObjectLabel.setBounds(400,150,200,200);
		ObjectLabel.setBounds(objx, objy, objWidth, objHeight);
		
		ImageIcon objectIcon = new ImageIcon(getClass()
											.getClassLoader()
											.getResource(objFileName));
		ObjectLabel.setIcon(objectIcon);
		
		ObjectLabel.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				popMenu.show(ObjectLabel,e.getX(),e.getY());
			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		bgPanel[bgNumber].add(ObjectLabel);
		bgPanel[bgNumber].add(bgLabel[bgNumber]);
	}
	
	public void generateScreen() {
		//Screen1
		createBackground(1,"wallpaperflare.com_wallpaper.jpg");
		createObject(1,440,140,200,200,"ishowspeed-200x200.jpg","Look","Talk","Dance");
		createObject(1,70,140,200,200,"Flower.jpg","Look","Talk","Smell");
		createObject(1,200,10,200,200,"image_processing20210806-29480-ykbqf0.gif","Look","Talk","Dance");
	}
}
