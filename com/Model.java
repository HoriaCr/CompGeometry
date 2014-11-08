package com;


import java.util.ArrayList;
import java.util.Arrays;


public class Model {
	private ArrayList<Point> points;

	
	public Model() {
		/*
		points = new Point[]{
				new Point(100.5, 200.3),
				new Point(300.7, 400.6),
				new Point(200.5, 100.6),
				new Point(150.5, 150.6),
				new Point(160.5, 75.6),
				new Point(190.0, 360.6),
				new Point(95.5, 166.6),
				new Point(70.5, 70.6),
				new Point(65.5, 115.6),
				new Point(65.5, 150.6),
				new Point(255.5, 115.6)
		};
		*/
		points = new ArrayList<Point>();
	}

	private int ccw(Point a, Point b, Point c) {
		double uarea = Point.unsignedArea(a, b, c);
		if (Math.abs(uarea) < 1e-7) return 0;

		return uarea < 1e-7 ? -1 : 1;
	}

	private Point[] convexHull(Point []points) {
		if (points.length < 3) {
			return new Point[0];
		}
		Point []ret;
		Arrays.sort(points);
		int n = points.length;
		boolean []used = new boolean[n];
		int []stack = new int[n + 1];
		int k = 2;
		stack[0] = 0;
		stack[1] = 1;
		Arrays.fill(used, false);
		used[1] = true;
		for (int i = 2, d = 1; used[0] == false; i += d) {
			if (i == n - 1) {
				d = -1;
			}
			if (used[i]) 
				continue;
			while (k >= 2 && ccw(points[stack[k - 2]], points[stack[k - 1]], points[i]) != -1) {
				used[stack[--k]] = false;
			}

			used[stack[k++] = i] = true;

		}

		ret = new Point[k];
		for (int i = 0; i < k; i++) {
			ret[i] = points[stack[i]];
		}

		return ret;

	}

	public Point []getConvexHull() {
		return convexHull(getPoints());
	}

	public Point[] getPoints() {
		Point[] ret = new Point[points.size()];
		int i = 0;
		for (Point point : points) {
			ret[i++] = point;
		}
		return ret;
	}
	
	public void clear() {
		points.clear();
	}

	public void addPoint(Point point) {
		points.add(point);
	}
}
