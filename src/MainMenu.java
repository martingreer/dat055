import java.awt.FlowLayout;

import javax.swing.*;

public class MainMenu extends JFrame {

	public MainMenu() {
		initUI();
	}
	
	public final void initUI(){
		setTitle("A Maze Quest");
		setSize(700, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void HelloWorld(){
		System.out.println("Hello world!");
	}
	
	public void Johannes(){
		System.out.println("The thug life chose me");
	}
	
	public static void main(String[] args) {
		MainMenu mainmenu = new MainMenu();
		mainmenu.setVisible(true);
	}
    
}