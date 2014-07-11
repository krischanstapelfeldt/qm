package de.globalposeidon.Qualitaet.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.UIManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MainWindow extends JFrame {
	final Logger logger = LoggerFactory.getLogger(MainWindow.class);
	private JSplitPane treeTableSplit;	
	private JTree treeView;
	private JTable tableView;
	
	private JPanel buttonPanel;	
	private JButton addBuildingButton;
	private JButton removeBuildingButton;
	
	public MainWindow(){
		super("Global Poseidon");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Global Poseidon");
		} catch (final Exception e) {
		}
		logger.info("Startup ok");
		setPreferredSize(new Dimension(1000, 700));
		setMinimumSize(new Dimension(600, 600));
		setLocationRelativeTo(null);
		setLayout(new BorderLayout(5, 5));
		
		treeTableSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		treeView = new JTree();
		treeView.setPreferredSize(new Dimension(200,600));
		
		tableView = new JTable();
	
		treeTableSplit.add(treeView);
		treeTableSplit.add(tableView);
		
		buttonPanel = new JPanel(new GridLayout(1,2,5,5));
		
		addBuildingButton = new JButton("+");
		removeBuildingButton = new JButton("-");
	
		buttonPanel.add(addBuildingButton);
		buttonPanel.add(removeBuildingButton);
	
		add(buttonPanel, BorderLayout.SOUTH);
		add(treeTableSplit, BorderLayout.CENTER);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
