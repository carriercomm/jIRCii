package rero.gui.dialogs;

import rero.gui.SessionManager;

import javax.swing.*;
import java.io.File;

public class DialogUtilities {
	private static JFileChooser chooser = null;

	public static File showFileDialog(String title, String acceptButton, File startin) {
		if (chooser == null)
			chooser = new JFileChooser();

		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		chooser.setDialogTitle(title);

		if (startin != null)
			chooser.setCurrentDirectory(startin);

		if (acceptButton != null)
			chooser.setApproveButtonText(acceptButton);

		int returnVal = chooser.showOpenDialog(SessionManager.getGlobalCapabilities().getFrame());

		if (returnVal == JFileChooser.APPROVE_OPTION)
			return chooser.getSelectedFile();

		return null;
	}

	public static File showSaveDialog(String title) {
		if (chooser == null)
			chooser = new JFileChooser();

		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		chooser.setDialogTitle(title);

		int returnVal = chooser.showSaveDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION)
			return chooser.getSelectedFile();

		return null;
	}
}
