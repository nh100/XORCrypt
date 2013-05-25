/*
 * (c) 2013 Lord Voldemort Tyrannus Farquad
 * Fellow sentient beings you are free to use this software freely in anything forever as long as you or I live throughout the universe
 * regardless of species and of location in time or space even if you happen to murder someone and the cops are after you.
 */

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;


public class MainWindow {

	private JFrame frmXorcrypt;
	private JTextField textField;
	private JTextField encryptedField;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	
	
	public static void main(String[] args) throws IOException {
		XORCrypt xrcry = new XORCrypt();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmXorcrypt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	public void copyToClipboard(String str){
		Toolkit t = Toolkit.getDefaultToolkit();
		StringSelection s = new StringSelection(str);
		t.getSystemClipboard().setContents(s, null);
	}
	
	public String getFromClipboard(){
		Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
		return null;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmXorcrypt = new JFrame();
		frmXorcrypt.setTitle("XORCrypt");
		frmXorcrypt.setBounds(100, 100, 450, 200);
		frmXorcrypt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmXorcrypt.setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menuFile.add(menuExit);
		
		JMenuItem mntmEncryptFile = new JMenuItem("Encrypt File");
		mntmEncryptFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				XORCrypt t = new XORCrypt();
				JFileChooser f = new JFileChooser();
				f.setDialogTitle("Encrypt File");
				if(f.showOpenDialog(null) == f.APPROVE_OPTION){
					File file = f.getSelectedFile();
					f.setDialogTitle("Save to File");
					if(f.showSaveDialog(null) == f.APPROVE_OPTION){
						File saveFile = f.getSelectedFile();
							try {
								t.xorcryptFile(file.getAbsolutePath(), saveFile.getAbsolutePath());
								JOptionPane.showMessageDialog(null, "Encryption sucess");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					}
				}
			}
		});
		menuFile.add(mntmEncryptFile);
		
		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		
		JMenuItem menuAbout = new JMenuItem("About");
		menuAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					About dialog = new About();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		menuHelp.add(menuAbout);
		frmXorcrypt.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblPlainText = new JLabel("Plain Text");
		frmXorcrypt.getContentPane().add(lblPlainText, "16, 4");
		
		textField = new JTextField();
		frmXorcrypt.getContentPane().add(textField, "1, 6, 16, 1, fill, default");
		textField.setColumns(10);
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		addPopup(textField, popupMenu_1);
		
		JMenuItem mntmCopy_1 = new JMenuItem("Copy");
		mntmCopy_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mntmCopy_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.copy();
			}
		});
		popupMenu_1.add(mntmCopy_1);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mntmCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mntmCut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.cut();
			}
		});
		popupMenu_1.add(mntmCut);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mntmPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mntmPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.paste();
			}
		});
		popupMenu_1.add(mntmPaste);
		
		JLabel lblPassword = new JLabel("Encrypted Text");
		frmXorcrypt.getContentPane().add(lblPassword, "16, 8");
		encryptedField = new JTextField();
		encryptedField.setEditable(false);
		frmXorcrypt.getContentPane().add(encryptedField, "1, 10, 16, 1, fill, default");
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(encryptedField, popupMenu);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mntmCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mntmCopy.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				encryptedField.copy();
			}
		});
		popupMenu.add(mntmCopy);
		
		JButton btnXorcrypt = new JButton("XORCrypt");
		btnXorcrypt.addActionListener(new ActionListener() {
			XORCrypt xrcr = new XORCrypt();
			public void actionPerformed(ActionEvent arg0) {
				if(!textField.equals("")){
					encryptedField.setText(xrcr.xorcrypt(textField.getText()));
				}
			}
		});
		frmXorcrypt.getContentPane().add(btnXorcrypt, "12, 12");
		
		JLabel lblNoteCanOnly = new JLabel("Note: Can only work for <27 characters");
		frmXorcrypt.getContentPane().add(lblNoteCanOnly, "16, 12");
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
