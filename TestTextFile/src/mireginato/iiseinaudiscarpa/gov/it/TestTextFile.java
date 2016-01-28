package mireginato.iiseinaudiscarpa.gov.it;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TestTextFile {

	protected Shell shell;
	private Text txtRiga;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TestTextFile window = new TestTextFile();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		txtRiga = new Text(shell, SWT.BORDER);
		txtRiga.setBounds(10, 39, 205, 21);
		
		Label lblRiga = new Label(shell, SWT.NONE);
		lblRiga.setBounds(10, 18, 55, 15);
		lblRiga.setText("Riga");
		
		Button btnScrivi = new Button(shell, SWT.NONE);
		btnScrivi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String message;
				message = txtRiga.getText();
				MessageDialog.openInformation(shell, "Testo Riga", message);
				//scrittura sul file
				BufferedWriter fWrite;
				try {
					fWrite=new BufferedWriter(new FileWriter("michele.txt", true));
					fWrite.write(message);
					fWrite.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					MessageDialog.openInformation(shell, "Testo Riga", "ERRORE");
				}
				
			}
		});
		btnScrivi.setBounds(236, 39, 75, 25);
		btnScrivi.setText("Scrivi");

	}
}
