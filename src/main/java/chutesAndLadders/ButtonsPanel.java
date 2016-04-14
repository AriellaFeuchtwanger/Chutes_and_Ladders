package chutesAndLadders;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ButtonsPanel extends JPanel implements ActionListener {
	private GameMenu menu;
	private boolean buttonClicked;
	private int numPlayers;

	@Inject
	public ButtonsPanel() {
		setLayout(new BorderLayout());
		Dimension d = new Dimension(300, 600);
		setPreferredSize(d);
		setMinimumSize(d);
		setMaximumSize(d);
		setBackground(null);
		setOpaque(false);


		JPanel buttons = new JPanel();
		buttons.setBackground(null);
		buttons.setOpaque(false);
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));

		JPanel instructions = setInstructions();

		JButton[] bs = new JButton[] { 
				new JButton("2"), 
				new JButton("3"),
				new JButton("4"), 
				new JButton("5"), 
				new JButton("6") };

		bs[0].setBackground(new Color(255, 41, 106));
		bs[1].setBackground(new Color(102, 75, 145));
		bs[2].setBackground(new Color(252, 238, 33));
		bs[3].setBackground( new Color(0, 191, 12));
		bs[4].setBackground(new Color(41, 171, 226));

		Dimension dim = new Dimension(150, 75);
		for (JButton b : bs) {
			b.addActionListener(this);
			b.setAlignmentX(Component.CENTER_ALIGNMENT);			
			b.setPreferredSize(dim);
			b.setMinimumSize(dim);
			b.setMaximumSize(dim);
			b.setFont(new Font("Arial", Font.BOLD, 33));

			buttons.add(b);
		}

		add(instructions, BorderLayout.NORTH);
		add(buttons, BorderLayout.CENTER);
	}

	private JPanel setInstructions() {
		Dimension d = new Dimension(300, 130);
		JLabel line1 = new JLabel("SELECT HOW MANY", JLabel.CENTER);
		line1.setFont(new Font("Arial", Font.BOLD, 20));
		JLabel line2 = new JLabel("PLAYERS WOULD", JLabel.CENTER);
		line2.setFont(new Font("Arial", Font.BOLD, 20));
		JLabel line3 = new JLabel("LIKE TO PLAY", JLabel.CENTER);
		line3.setFont(new Font("Arial", Font.BOLD, 20));

		JPanel instructions = new JPanel();
		instructions.setBorder(new EmptyBorder(20, 0, 0, 0));
		instructions.setPreferredSize(d);
		instructions.setMinimumSize(d);
		instructions.setMaximumSize(d);
		instructions.setBackground(null);
		instructions.setOpaque(false);

		instructions.add(line1);
		instructions.add(line2);
		instructions.add(line3);

		return instructions;
	}

	public void actionPerformed(ActionEvent event) {
		JButton g = (JButton) event.getSource();
		numPlayers = Integer.parseInt(g.getText());
		menu.setPlayers(numPlayers);
	}

	public boolean isButtonClicked() {
		return buttonClicked;
	}

	public int getNumPlayers() {
		return numPlayers;
	}

	public void setButtonClicked(boolean buttonClicked) {
		this.buttonClicked = buttonClicked;
	}

	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}

	public void setMenu(GameMenu menu) {
		this.menu = menu;
	}

}
