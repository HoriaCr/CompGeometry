package com;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JButton generateButton;
	private JButton clearButton;
	private JPanel buttonPanel;
	private Point[] points;
	private Point[] polygon;

	public View() {
		points = new Point[0];
		polygon = new Point[0];
		frame = new JFrame("Convex hull");
		generateButton = new JButton("Generate Convex Hull");
		clearButton = new JButton("Clear Points");
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(generateButton);
		buttonPanel.add(clearButton);

		setBackground(Color.white);
		setForeground(Color.white);
		
		frame.getContentPane().setLayout(new BorderLayout());
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		frame.getContentPane().add("Center", this);
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setSize(new Dimension(800, 600));
		frame.setVisible(true);
	}

	public JButton getGenerateButton() {
		return generateButton;
	}

	public JButton getClearButton() {
		return clearButton;
	}

	public void setData(Point[] a, Point[] b) {
		polygon = a;
		points = b;
	}

	public void paint(Graphics graphics) {
		super.paint(graphics);
		Graphics2D g = (Graphics2D) graphics;
		g.setBackground(Color.white);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setPaint(Color.red);
		for (int i = 0; i < polygon.length - 1; i++) {
			g.draw(Point.getLine(polygon[i], polygon[i + 1]));
		}

		g.setPaint(Color.blue);
		g.setStroke(new BasicStroke(4));
		for (int i = 0; i < points.length; i++) {
			g.draw(Point.getLine(points[i], points[i]));
		}
	}

}
