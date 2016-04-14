package chutesAndLadders;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GameFrame extends JFrame {

	private GameMenu gameMenu;

	@Inject
	public GameFrame(GameMenu menu) {
		setTitle("CHUTES AND LADDERS");
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.gameMenu = menu;
		setLayout(new BorderLayout());
		add(this.gameMenu, BorderLayout.CENTER);
		this.gameMenu.setFrame(this);
		
		JButton newGame = new JButton("Main Menu");
//		Dimension d = new Dimension(100, 50);
//		newGame.setPreferredSize(d);
//		newGame.setMinimumSize(d);
//		newGame.setMaximumSize(d);
//		newGame.setFont(new Font("Arial", Font.PLAIN, 18));
		
		newGame.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				gameMenu.newGame();
			}
			
		});
		
		add(newGame, BorderLayout.NORTH);
		setVisible(true);
	}

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new GameModule());
		injector.getInstance(GameFrame.class);

	}



}
