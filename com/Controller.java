package com;


import java.awt.event.*;


public class Controller {

	private Model model;
	private View view;
	private ActionListener generateListener;
	private ActionListener clearListener;

	private MouseListener mouseListener;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void control() {
		generateListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				showData();
			}
		};
		
		clearListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				model.clear();
				showData();
			}
		};
		
		mouseListener = new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				Point point = new Point(e.getX(), e.getY());
				model.addPoint(point);

				view.setData(new Point[0], model.getPoints());
				view.repaint();
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
		};
		view.addMouseListener(mouseListener);
		view.getGenerateButton().addActionListener(generateListener);
		view.getClearButton().addActionListener(clearListener);
	}

	public void showData() {
		view.setData(model.getConvexHull(), model.getPoints());
		view.repaint();
	}

}
