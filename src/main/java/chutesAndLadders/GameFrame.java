package chutesAndLadders;

import java.awt.BorderLayout;

import javax.inject.Inject;
import javax.swing.JFrame;

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

		gameMenu = menu;
		setLayout(new BorderLayout());
		add(this.gameMenu, BorderLayout.CENTER);
		gameMenu.setFrame(this);

		setVisible(true);
	}

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new GameModule());
		injector.getInstance(GameFrame.class);

	}



}
