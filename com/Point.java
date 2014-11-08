package com;

import java.awt.geom.Line2D;


public final class Point implements Comparable<Point> {
	private double x, y;

	public Point(double X,double Y) {
		x = X;
		y = Y;
	}

	public int compareTo(Point p) {
		if (Math.abs(x - p.x) < 1e-7) {
			if (Math.abs(y - p.y) < 1e-7) {
				return 0;
			}
			return y < p.y ? -1 : 1;
		}
		return x < p.x ? -1 : 1;
	}
	
	public static double unsignedArea(Point a, Point b, Point c) {
		return ((b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y)) / 2.0;
	}
	
	public static Line2D.Double getLine(Point a,Point b) {
		return new Line2D.Double(a.x,a.y, b.x, b.y);
	}

}