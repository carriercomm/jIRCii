package rero.gui.toolkit;

import rero.config.ClientDefaults;
import rero.config.Config;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.TabbedPaneUI;
import java.awt.*;

public class MinimalTabUI extends TabbedPaneUI implements ChangeListener {
	public MinimalTabUI() {
		// don't do anything :)
	}

	private static class MinimalLayout extends CardLayout {
		public void addLayoutComponent(Component c, Object constraints) {
			super.addLayoutComponent(c.hashCode() + "", c);
		}

		public void addLayoutComponent(String cons, Component c) {
			super.addLayoutComponent(c.hashCode() + "", c);
		}
	}

	public Dimension getMinimumSize() {
		return null;
	}

	public Dimension getMaximumSize() {
		return null;
	}

	public Dimension getPreferredSize() {
		return null;
	}

//    public boolean contains(JComponent c, int x, int y) { return true; }

	public Rectangle getTabBounds(JTabbedPane pane, int index) {
		return new Rectangle(0, 0, 0, 0);
	}

	public int getTabRunCount(JTabbedPane pane) {
		return 0;
	}

	public int tabForCoordinate(JTabbedPane pane, int x, int y) {
		return 0;
	}

	public void installUI(JComponent c) {
		JTabbedPane temp = (JTabbedPane) c;
		c.setLayout(new MinimalLayout());

		int size = Config.getInstance().getInteger("notabs.border", ClientDefaults.notabs_border);

		c.setBorder(BorderFactory.createEmptyBorder(size, size, size, size));
		temp.addChangeListener(this);
	}

	public void stateChanged(ChangeEvent ev) {
		JTabbedPane temp = (JTabbedPane) ev.getSource();

		if (temp.getSelectedComponent() != null) {
			((CardLayout) temp.getLayout()).show(temp, temp.getSelectedComponent().hashCode() + "");
		}
		temp.revalidate();
		temp.repaint();
	}
}


