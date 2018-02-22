package chooseFile;


	import java.awt.Dimension;
	import javax.swing.JButton;
	import javax.swing.JFileChooser;
	import javax.swing.JPanel;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class browse extends JPanel implements ActionListener{
		
	        private JButton openButton;
	       
	        public browse(){
	                openButton = new JButton("Browse");
	               
	                setPreferredSize(new Dimension(278, 120));
	                setLayout(null);
	               
	                add(openButton);
	               
	                openButton.setBounds(84, 80, 100, 25);
	                openButton.addActionListener(this);
	        }
	       
	        public void actionPerformed(ActionEvent e){
	                if(e.getSource() == openButton){
	                	JButton open = new JButton();
	            		JFileChooser fc = new JFileChooser();
	            		fc.setCurrentDirectory(new java.io.File("C:/Users/Galapagos/Pictures"));
	            		fc.setDialogTitle("Hello World");
	            		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	            		if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
	            			//
	            		}
	            		System.out.println(fc.getSelectedFile().getAbsolutePath());
	                }
	        }
	}

