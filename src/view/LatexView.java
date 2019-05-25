package view;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.*;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.wb.swt.SWTResourceManager;

import controller.LatexEditorController;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class LatexView {

	protected Shell shlTexEditor;
	private LatexEditorController controller;
	private StyledText styledText;
	private MenuItem mntmLatexCommands;
	private MenuItem mntmNewItem_10;
	private MenuItem mntmEnableTracking;
	private Button btnSaveFile;
	private Text txtInsertTheName;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			LatexView window = new LatexView();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlTexEditor.open();
		shlTexEditor.layout();
		while (!shlTexEditor.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlTexEditor = new Shell();
		shlTexEditor.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
		shlTexEditor.setSize(1280, 720);
		shlTexEditor.setText("TEX Editor");
		shlTexEditor.setLayout(null);
		
		
		Menu menu = new Menu(shlTexEditor, SWT.BAR);
		shlTexEditor.setMenuBar(menu);
		
		MenuItem mntmCreate = new MenuItem(menu, SWT.CASCADE);
		mntmCreate.setText("Create");
		
		Menu menu_1 = new Menu(mntmCreate);
		mntmCreate.setMenu(menu_1);
		
		
		MenuItem mntmNewItem = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				styledText.setEnabled(true);
				mntmEnableTracking.setEnabled(true);
				mntmLatexCommands.setEnabled(true);
				btnSaveFile.setEnabled(true);
				Text txtInsertTheName = new Text(shlTexEditor, SWT.BORDER);
				txtInsertTheName.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
				txtInsertTheName.setText("Insert the name of your new\r\nDocument. Type only \r\na-z characters");
				txtInsertTheName.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				txtInsertTheName.setBounds(420, 107, 665, 35);
				txtInsertTheName.moveAbove(styledText);
				txtInsertTheName.setBackground(SWTResourceManager.getColor(128, 191, 255));
				
				Button btnOk = new Button(shlTexEditor, SWT.NONE);
				btnOk.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				btnOk.moveAbove(styledText);
				btnOk.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						controller = new LatexEditorController(txtInsertTheName.getText());
						controller.enact("empty");
						txtInsertTheName.dispose();
						btnOk.dispose();
						
					}
				});
				btnOk.setBounds(420, 148, 90, 30);
				btnOk.setText("OK");
				btnOk.setBackground(SWTResourceManager.getColor(128, 191, 255));
			}
		});
		mntmNewItem.setText("Empty Document");
		
		MenuItem mntmNewItem_1 = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				styledText.setEnabled(true);
				mntmEnableTracking.setEnabled(true);
				mntmLatexCommands.setEnabled(true);
				btnSaveFile.setEnabled(true);
				Text txtInsertTheName = new Text(shlTexEditor, SWT.BORDER);
				txtInsertTheName.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
				txtInsertTheName.setText("Insert the name of your new\r\nDocument. Type only \r\na-z characters");
				txtInsertTheName.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				txtInsertTheName.moveAbove(styledText);
				txtInsertTheName.setBounds(420, 107, 665, 35);
				txtInsertTheName.setBackground(SWTResourceManager.getColor(128, 191, 255));
				
				Button btnOk = new Button(shlTexEditor, SWT.NONE);
				btnOk.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				btnOk.moveAbove(styledText);
				btnOk.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						controller = new LatexEditorController(txtInsertTheName.getText());
						controller.enact("article");
						styledText.setText(controller.writeContents());
						txtInsertTheName.dispose();
						btnOk.dispose();
					}
				});
				btnOk.setBounds(420, 148, 90, 30);
				btnOk.setText("OK");
				btnOk.setBackground(SWTResourceManager.getColor(128, 191, 255));
				
			}
		});
		mntmNewItem_1.setText("Article");
		
		MenuItem mntmNewItem_2 = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				styledText.setEnabled(true);
				mntmEnableTracking.setEnabled(true);
				mntmLatexCommands.setEnabled(true);
				btnSaveFile.setEnabled(true);
				Text txtInsertTheName = new Text(shlTexEditor, SWT.BORDER);
				txtInsertTheName.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
				txtInsertTheName.setText("Insert the name of your new\r\nDocument. Type only \r\na-z characters");
				txtInsertTheName.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				txtInsertTheName.moveAbove(styledText);
				txtInsertTheName.setBounds(420, 107, 665, 35);
				txtInsertTheName.setBackground(SWTResourceManager.getColor(128, 191, 255));
				
				Button btnOk = new Button(shlTexEditor, SWT.NONE);
				btnOk.moveAbove(styledText);
				btnOk.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				btnOk.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						controller = new LatexEditorController(txtInsertTheName.getText());
						controller.enact("book");
						styledText.setText(controller.writeContents());
						txtInsertTheName.dispose();
						btnOk.dispose();
					}
				});
				btnOk.setBounds(420, 148, 90, 30);
				btnOk.setText("OK");
				btnOk.setBackground(SWTResourceManager.getColor(128, 191, 255));
				
			}
		});
		mntmNewItem_2.setText("Book");
		
		MenuItem mntmNewItem_12 = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem_12.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				styledText.setEnabled(true);
				mntmEnableTracking.setEnabled(true);
				mntmLatexCommands.setEnabled(true);
				btnSaveFile.setEnabled(true);
				Text txtInsertTheName = new Text(shlTexEditor, SWT.BORDER);
				txtInsertTheName.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
				txtInsertTheName.setText("Insert the name of your new\r\nDocument. Type only \r\na-z characters");
				txtInsertTheName.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				txtInsertTheName.moveAbove(styledText);
				txtInsertTheName.setBounds(420, 107, 665, 35);
				txtInsertTheName.setBackground(SWTResourceManager.getColor(128, 191, 255));
				
				Button btnOk = new Button(shlTexEditor, SWT.NONE);
				btnOk.moveAbove(styledText);
				btnOk.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				btnOk.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						controller = new LatexEditorController(txtInsertTheName.getText());
						controller.enact("letter");
						styledText.setText(controller.writeContents());
						txtInsertTheName.dispose();
						btnOk.dispose();
					}
				});
				btnOk.setBounds(420, 148, 90, 30);
				btnOk.setText("OK");
				btnOk.setBackground(SWTResourceManager.getColor(128, 191, 255));
				
			}
		});
		mntmNewItem_12.setText("Letter");
		
		MenuItem mntmNewItem_11 = new MenuItem(menu_1, SWT.NONE);
		mntmNewItem_11.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				styledText.setEnabled(true);
				mntmEnableTracking.setEnabled(true);
				mntmLatexCommands.setEnabled(true);
				btnSaveFile.setEnabled(true);
				Text txtInsertTheName = new Text(shlTexEditor, SWT.BORDER);
				txtInsertTheName.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
				txtInsertTheName.setText("Insert the name of your new\r\nDocument. Type only \r\na-z characters");
				txtInsertTheName.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				txtInsertTheName.moveAbove(styledText);
				txtInsertTheName.setBounds(420, 107, 665, 35);
				txtInsertTheName.setBackground(SWTResourceManager.getColor(128, 191, 255));
				
				Button btnOk = new Button(shlTexEditor, SWT.NONE);
				btnOk.moveAbove(styledText);
				btnOk.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
				btnOk.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseDown(MouseEvent e) {
						controller = new LatexEditorController(txtInsertTheName.getText());
						controller.enact("report");
						styledText.setText(controller.writeContents());
						txtInsertTheName.dispose();
						btnOk.dispose();
					}
				});
				btnOk.setBounds(420, 148, 90, 30);
				btnOk.setText("OK");
				btnOk.setBackground(SWTResourceManager.getColor(128, 191, 255));
				
			}
		});
		mntmNewItem_11.setText("Report");
		
		mntmLatexCommands = new MenuItem(menu, SWT.CASCADE);
		mntmLatexCommands.setEnabled(false);
		mntmLatexCommands.setText("LaTeX commands");
		
		Menu menu_2 = new Menu(mntmLatexCommands);
		mntmLatexCommands.setMenu(menu_2);
		
		
		mntmNewItem_10 = new MenuItem(menu_2, SWT.NONE);
		mntmNewItem_10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String temp = "";
				controller.enact(styledText.getText());
				if (controller.getVersionsManager().isEnabled()) {
					controller.enact("keep");
				}
				controller.enact("chapter");
				temp += controller.writeContents();
				styledText.setText(temp);
			}
		});
		mntmNewItem_10.setText("Chapter");
		
		MenuItem mntmNewItem_3 = new MenuItem(menu_2, SWT.NONE);
		mntmNewItem_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String temp = "";
				controller.enact(styledText.getText());
				if (controller.getVersionsManager().isEnabled()) {
					controller.enact("keep");
				}
				controller.enact("section");
				temp += controller.writeContents();
				styledText.setText(temp);
			}
		});
		mntmNewItem_3.setText("Section");
		
		MenuItem mntmNewItem_4 = new MenuItem(menu_2, SWT.NONE);
		mntmNewItem_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String temp = "";
				controller.enact(styledText.getText());
				if (controller.getVersionsManager().isEnabled()) {
					controller.enact("keep");
				}
				controller.enact("subsection");
				temp += controller.writeContents();
				styledText.setText(temp);
			}
		});
		mntmNewItem_4.setText("Subsection");
		
		MenuItem mntmNewItem_5 = new MenuItem(menu_2, SWT.NONE);
		mntmNewItem_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String temp = "";
				controller.enact(styledText.getText());
				if (controller.getVersionsManager().isEnabled()) {
					controller.enact("keep");
				}
				controller.enact("subsubsection");
				temp += controller.writeContents();
				styledText.setText(temp);
			}
		});
		mntmNewItem_5.setText("Subsubsection");
		
		MenuItem mntmNewItem_6 = new MenuItem(menu_2, SWT.NONE);
		mntmNewItem_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String temp = "";
				controller.enact(styledText.getText());
				if (controller.getVersionsManager().isEnabled()) {
					controller.enact("keep");
				}
				controller.enact("enumlist");
				temp += controller.writeContents();
				styledText.setText(temp);
			}
		});
		mntmNewItem_6.setText("Enumeration List");
		
		MenuItem mntmNewItem_7 = new MenuItem(menu_2, SWT.NONE);
		mntmNewItem_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String temp = "";
				controller.enact(styledText.getText());
				if (controller.getVersionsManager().isEnabled()) {
					controller.enact("keep");
				}
				controller.enact("bulletlist");
				temp += controller.writeContents();
				styledText.setText(temp);
			}
		});
		mntmNewItem_7.setText("Bullet List");
		
		MenuItem mntmNewItem_8 = new MenuItem(menu_2, SWT.NONE);
		mntmNewItem_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String temp = "";
				controller.enact(styledText.getText());
				if (controller.getVersionsManager().isEnabled()) {
					controller.enact("keep");
				}
				controller.enact("table");
				temp += controller.writeContents();
				styledText.setText(temp);
			}
		});
		mntmNewItem_8.setText("Table");
		
		MenuItem mntmNewItem_9 = new MenuItem(menu_2, SWT.NONE);
		mntmNewItem_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String temp = "";
				controller.enact(styledText.getText());
				if (controller.getVersionsManager().isEnabled()) {
					controller.enact("keep");
				}
				controller.enact("figure");
				temp += controller.writeContents();
				styledText.setText(temp);
			}
		});
		mntmNewItem_9.setText("Figure");
		
		mntmEnableTracking = new MenuItem(menu, SWT.NONE);
		mntmEnableTracking.setEnabled(false);
		mntmEnableTracking.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
				mntmNewSubmenu.setText("Type of Tracking");
				
				Menu menu_3 = new Menu(mntmNewSubmenu);
				mntmNewSubmenu.setMenu(menu_3);
				
				MenuItem mntmNewItem_13 = new MenuItem(menu_3, SWT.NONE);
				mntmNewItem_13.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						controller.enact("volatile");
					}
				});
				mntmNewItem_13.setText("Volatile");
				
				MenuItem mntmNewItem_14 = new MenuItem(menu_3, SWT.NONE);
				mntmNewItem_14.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						controller.enact("stable");
					}
				});
				mntmNewItem_14.setText("Stable");
				
				MenuItem mntmNewItem_15 = new MenuItem(menu, SWT.NONE);
				mntmNewItem_15.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						controller.enact(styledText.getText());
						controller.enact("keep");
						
					}
					
				});
				mntmNewItem_15.setText("Keep current content");
				
				
				MenuItem mntmNewItem_16 = new MenuItem(menu, SWT.NONE);
				mntmNewItem_16.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						controller.enact("rollback");
						styledText.setText(controller.writeContents());
					}
					
				});
				mntmNewItem_16.setText("Rollback");
				
				MenuItem disableTracking = new MenuItem(menu, SWT.NONE);
				disableTracking.setText("Disable Tracking");
				disableTracking.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						controller.enact("disable");
						mntmNewSubmenu.dispose();
						mntmNewItem_15.dispose();
						mntmNewItem_16.dispose();
						mntmEnableTracking.setEnabled(true);
						disableTracking.dispose();
					}
					
				});
				
				mntmEnableTracking.setEnabled(false);
				controller.enact("enable");

			}
		});
		mntmEnableTracking.setText("Enable Tracking");
		
		styledText = new StyledText(shlTexEditor, SWT.BORDER);
		styledText.setEnabled(false);
		styledText.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.NORMAL));
		styledText.setBackground(SWTResourceManager.getColor(240, 248, 255));
		styledText.setBounds(246, 0, 1006, 612);
		
		btnSaveFile = new Button(shlTexEditor, SWT.NONE);
		btnSaveFile.setEnabled(false);
		btnSaveFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				controller.enact(styledText.getText());
				controller.enact("save");
			}
		});
		btnSaveFile.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnSaveFile.setBounds(0, 10, 240, 30);
		btnSaveFile.setBackground(SWTResourceManager.getColor(128, 191, 255));
		btnSaveFile.setText("Save file");
		
		Button btnLoadFile = new Button(shlTexEditor, SWT.NONE);
		btnLoadFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				styledText.setEnabled(true);
				mntmEnableTracking.setEnabled(true);
				mntmLatexCommands.setEnabled(true);
				btnSaveFile.setEnabled(true);
				String browserPath = new File("").getAbsolutePath() + "\\user_documents";
				JFileChooser jfc = new JFileChooser(browserPath);

				int returnValue = jfc.showOpenDialog(null);
				
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jfc.getSelectedFile();
					controller = new LatexEditorController(selectedFile.getName());
					controller.enact("load");
					styledText.setText(controller.writeContents());
				}
			}
		});
		btnLoadFile.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnLoadFile.setBounds(0, 57, 240, 30);
		btnLoadFile.setBackground(SWTResourceManager.getColor(128, 191, 255));
		btnLoadFile.setText("Load file");
		
		Label lblTheAddedLatex = new Label(shlTexEditor, SWT.NONE);
		lblTheAddedLatex.setBounds(10, 618, 1242, 20);
		lblTheAddedLatex.setBackground(SWTResourceManager.getColor(250, 250, 250));
		lblTheAddedLatex.setText("The added Latex commands will be at the bottom of the Document");
		
		Label logo = new Label(shlTexEditor, SWT.NONE);
		logo.setBounds(0, 279, 240, 240);
		logo.setImage(SWTResourceManager.getImage(LatexView.class, "/org/eclipse/wb/swt/texLogo.png"));
		logo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		
		
		
	}
}
