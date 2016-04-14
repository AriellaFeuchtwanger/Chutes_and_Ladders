package chutesAndLadders;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerInfo extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private JLabel[] labels;
	private JTextField[] fields;
	private JButton submit;
	private JPanel players;
	private String[] playerNames;
	private GameMenu menu;

	@Inject
	public PlayerInfo() {

		Dimension d = new Dimension(300, 600);
		setPreferredSize(d);
		setMinimumSize(d);
		setMaximumSize(d);
		setBackground(null);
		setOpaque(false);

		players = new JPanel();
		players.setBackground(null);
		players.setOpaque(false);
		players.setLayout(new GridLayout(0, 1));

		submit = new JButton("PLAY");
		submit.addMouseListener(this);
		submit.setContentAreaFilled(false);
		submit.setBorderPainted(false);
		submit.setOpaque(false);
		submit.setBackground(null);
		submit.setFont(new Font("Arial", Font.BOLD, 15));
		submit.setAlignmentX(Component.CENTER_ALIGNMENT);
		submit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				playerNames = new String[fields.length];
				for (int i = 0; i < fields.length; i++) {
					playerNames[i] = fields[i].getText().toUpperCase();
				}

				menu.playGame(playerNames);

			}
		});

		JLabel instructions = new JLabel("ENTER PLAYER NAMES", JLabel.CENTER);
		instructions.setFont(new Font("Arial", Font.BOLD, 20));
		d = new Dimension(300, 100);
		instructions.setPreferredSize(d);
		instructions.setMinimumSize(d);
		instructions.setMaximumSize(d);

		JButton newGame = new JButton("MAIN MENU");
		newGame.addMouseListener(this);
		newGame.setContentAreaFilled(false);
		newGame.setBorderPainted(false);
		newGame.setOpaque(false);
		newGame.setBackground(null);
		newGame.setFont(new Font("Arial", Font.BOLD, 15));
		newGame.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				menu.newGame();
			}

		});

		add(instructions);
		add(players);
		add(submit);
		add(newGame);
	}

	public void setNumPlayers(int num) {
		labels = new JLabel[num];
		fields = new JTextField[num];

		Font font = new Font("Arial", Font.BOLD, 20);
		for (int i = 1; i <= num; i++) {
			JPanel player = new JPanel();
			player.setBackground(null);
			player.setOpaque(false);
			JLabel l = new JLabel("Player " + i);
			l.setFont(font);
			l.setVerticalAlignment(JLabel.BOTTOM);
			labels[i - 1] = l;
			player.add(l);

			Dimension d = new Dimension(200, 35);

			JTextField f = new JTextField();
			f.setFont(font);
			f.setPreferredSize(d);
			f.setMinimumSize(d);
			f.setMaximumSize(d);

			fields[i - 1] = f;
			player.add(f);
			players.add(player);
		}
	}

	public void setGameMenu(GameMenu m) {
		menu = m;
	}

	public void mouseClicked(MouseEvent arg0) {

	}

	public void mouseEntered(MouseEvent e) {
		JButton b = (JButton) e.getSource();
		b.setForeground(Color.WHITE);
	}

	public void mouseExited(MouseEvent e) {
		JButton b = (JButton) e.getSource();
		b.setForeground(Color.BLACK);

	}

	public void mousePressed(MouseEvent arg0) {

	}

	public void mouseReleased(MouseEvent arg0) {

	}

}
