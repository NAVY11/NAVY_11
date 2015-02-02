package ankhmorpork;
import java.applet.Applet;
import java.awt.event.*;
import java.awt.image.*;
import java.lang.*;
import java.util.*;
import java.net.*;
import java.awt.*;
import java.io.*;

public class BufferPanel extends Container {
	private static final long serialVersionUID = 1L;

	Image background;
	BufferPanel() {}
	public void update(Graphics g) {
		paint(g);
	}
	public void paint(Graphics g) {
		super.paint(g); 
	}
}