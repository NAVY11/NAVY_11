package ankhmorpork;

import java.applet.Applet;
import java.awt.event.*;
import java.awt.image.*;
import java.lang.*;
import java.util.*;
import java.net.*;
import java.awt.*;
import java.io.*;

public class DoubleBufferPanel extends Panel {
	
	private static final long serialVersionUID = 1L;

	Image offscreen;
	public void invalidate() {
		super.invalidate();
		offscreen = null;
	}
	public void update(Graphics g) {
		paint(g);
	}
	public void paint(Graphics g) {
		if(offscreen == null) {
			offscreen = createImage(getSize().width, getSize().height);
		}
		Graphics og = offscreen.getGraphics();
		og.setClip(0,0,getSize().width, getSize().height);
		super.paint(og);
		g.drawImage(offscreen, 0, 0, null);
		og.dispose();
	}
}
