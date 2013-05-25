import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowStateListener;


public class About extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public About() {
		setTitle("About");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JSplitPane splitPane = new JSplitPane();
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			contentPanel.add(splitPane);
			{
				JLabel lblcEmperorOf = new JLabel("(C) Emperor of The Sea aka Lord Voldemort Tyrannus Farquad");
				splitPane.setLeftComponent(lblcEmperorOf);
			}
			{
				JTextPane text = new JTextPane();
				text.setEditable(false);
				text.setText("XORCrypter a digression into XORness by Lord Voldemort Tyrannus Farquad aka Noah\r\n\r\nXORCrypter is like a qubit, it can decrypt and encrypt with one operation.\r\nXOR Encryption is a type of encryption that uses the logical XOR\r\non a string along with a key. For example: string XOR key, this\r\n then produces the ciphertext.\r\nThe interesting thing about this form of encryption is that it is\r\n reversible; simply perform the same operation with the ciphertext.\r\n Hope you enjoy the program.");
				splitPane.setRightComponent(text);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Dialog.getWindows()[1].dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
