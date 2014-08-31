package de.globalposeidon.Qualitaet.gui;
import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import de.globalposeidon.Qualitaet.Strings;

/**
 * InfoDialog.
 * @author Hadschii
 *
 */
public class InfoDialog extends JDialog {

	private static final long serialVersionUID = -549984974943771798L;

	/**
	 * Konstruktor.
	 * @param title title
	 * @param text text
	 */
	public InfoDialog(String title, String text) {
		
		super(null, ModalityType.APPLICATION_MODAL);
		setTitle(title);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
		setSize(200, 75);
		
		JLabel lblInfoText = new JLabel(text);
		JButton btnOK = new JButton(Strings.OK);
		btnOK.addActionListener(new ActionListener(){
	    	  @Override
	    	  public void actionPerformed(final ActionEvent e){
	    		  dispose();
	    	  }
	      });
		
		add(lblInfoText, BorderLayout.CENTER);
		add(btnOK, BorderLayout.SOUTH);
		
//		pack();
		setVisible(true);
	}

}
