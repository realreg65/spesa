package provaGrafica;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;



import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;

public class ProvaGrafica {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ProvaGrafica window = new ProvaGrafica();
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
		
		Button btnApriFile = new Button(shell, SWT.NONE);
		btnApriFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				FileDialog fileDialog = new FileDialog(shell);
				fileDialog.setFilterExtensions(new String[]{"*.txt", "*.csv", "*.*"}); //opzionale
		        String fileScelto = fileDialog.open();

		        if(fileScelto != null) {
		          	MessageDialog.openInformation(shell, "File scelto", fileScelto);
		        	MessageDialog.openInformation(shell, "File scelto (solo nome)", fileDialog.getFileName());
		        }
		      }
		});
		btnApriFile.setBounds(22, 21, 75, 25);
		btnApriFile.setText("Apri file");
		
		List list = new List(shell, SWT.BORDER);
		list.setBounds(26, 66, 196, 165);

	}
}


//MessageDialog.openInformation(shell, "tit", "MSG");
/*//modo 1
JFileChooser scelta= new JFileChooser();
int s = scelta.showOpenDialog(null);
if(s == JFileChooser.APPROVE_OPTION){
	File fileScelto = scelta.getSelectedFile();
	MessageDialog.openInformation(shell, "File scelto", fileScelto.getName());
	//System.out.println(fileScelto.getName());
}
if (s == JFileChooser.CANCEL_OPTION){
	System.out.println("operazione annullata");
}
*/

/*//modo 2
FileDialog fileDialog = new FileDialog(shell);

//fileDialog.setFilterPath(fileFilterPath);

fileDialog.setFilterExtensions(new String[]{"*.txt", "*.csv", "*.*"}); //opzionale

//fileDialog.setFilterExtensions(new String[]{"*.rtf", "*.html", "*.*"});
//fileDialog.setFilterNames(new String[]{ "Rich Text Format", "HTML Document", "Any"});
//fileDialog.setFilterNames(new String[]{ "Rich Text Format", "HTML Document", "Any"});

String fileScelto = fileDialog.open();

if(fileScelto != null) {
  //String fileFilterPath = fileDialog.getFilterPath();
  //MessageDialog.openInformation(shell, "File scelto", fileDialog.getFileName());
	MessageDialog.openInformation(shell, "File scelto", fileScelto);
	MessageDialog.openInformation(shell, "File scelto (solo nome)", fileDialog.getFileName());
  /*String[] selectedFiles = fileDialog.getFileNames();
  StringBuffer sb = new StringBuffer("Selected files under dir " + fileDialog.getFilterPath() +  ": \n");
  for(int i=0; i<selectedFiles.length; i++) {
    sb.append(selectedFiles[i] + "\n");
  }
  label.setText(sb.toString());
  */