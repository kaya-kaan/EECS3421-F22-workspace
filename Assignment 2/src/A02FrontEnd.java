import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class A02FrontEnd extends JFrame implements ItemListener, ActionListener{

	/**
	 * The purpose of this class is to create the FrontEnd/GUI and provide listener functions.
	 * You cannot write/perform any database interaction functions/actions in this class.
	 * You can only invoke a suitable function from A02MiddleTier class on the click event of Submit button. 
	 */
	ButtonGroup eventGroup = new ButtonGroup();
	JRadioButton eventConference;
    JRadioButton eventJournal;
    JRadioButton eventBook;
    JTextArea queryOutput;
	JLabel evNameL;
	JLabel evDateL;
	JLabel jourNameL;
    JTextField evNameT;
    JTextField evDateT;
    JTextField jourNameT;
    JButton submitQuery;
    
	public A02FrontEnd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		eventConference = new JRadioButton("EventConference");
		eventGroup.add(eventConference);
		eventJournal = new JRadioButton("EventJournal");
		eventGroup.add(eventJournal);
		eventBook = new JRadioButton("EventBook");
		eventGroup.add(eventBook);        
		eventConference.addItemListener(this);
		eventJournal.addItemListener(this);
		eventBook.addItemListener(this);
		JPanel eventPanel = new JPanel(new GridLayout(0, 1));
		eventPanel.add(eventConference);
		eventPanel.add(eventJournal);
		eventPanel.add(eventBook);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
        this.add(eventPanel, c);

        JLabel emptyLabel1 = new JLabel("                    \n          ");
        JPanel emptyPanel1 = new JPanel(new GridLayout(0, 1));
        emptyPanel1.add(emptyLabel1);
        c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
        this.add(emptyPanel1, c);

        
		JPanel datePanel = new JPanel(new GridLayout(0, 1));
		
        evNameL = new JLabel("       Event Name ");
        evNameL.setEnabled(true);
        evDateL = new JLabel("       Event Date ");
        evDateL.setEnabled(true);
        jourNameL = new JLabel("       Journal Name ");
        jourNameL.setEnabled(true);
		evNameT = new JTextField();
        evNameT.setEnabled(true);
        evDateT = new JTextField();
        evDateT.setEnabled(true);
		jourNameT = new JTextField();
        jourNameT.setEnabled(true);
        JPanel dataPanel = new JPanel(new GridLayout(0, 2));
		dataPanel.add(evNameL );
		dataPanel.add(evNameT);
		dataPanel.add(evDateL );
		dataPanel.add(evDateT );
		dataPanel.add(jourNameL );
		dataPanel.add(jourNameT );
		datePanel.add(dataPanel);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
        this.add(datePanel, c);
        
        JLabel emptyLabel2 = new JLabel("                    \n          ");
        JPanel emptyPanel2 = new JPanel(new GridLayout(0, 1));
        emptyPanel2.add(emptyLabel2);
        c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
        this.add(emptyPanel2, c);

        submitQuery = new JButton("Insert");
        submitQuery.addActionListener(this);
		JPanel submitPanel = new JPanel(new GridLayout(0, 1));
		submitPanel.add(submitQuery);
		c.fill = GridBagConstraints.NONE;
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 2;
		c.gridy = 2;
        this.add(submitPanel, c);

        JLabel emptyLabel3 = new JLabel("                    \n          ");
        JPanel emptyPanel3 = new JPanel(new GridLayout(0, 1));
        emptyPanel3.add(emptyLabel3);
        c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
        this.add(emptyPanel3, c);

        queryOutput = new JTextArea(18,50);
        queryOutput.setText("The\nQuery\nOutput\nwill\nAppear\nhere.");
		JScrollPane outputPanel = new JScrollPane(queryOutput);
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 4;
        this.add(outputPanel, c);
        

		this.setBounds(50, 50, 600, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//this function is the listener for three check boxes and two radio buttons
	public void itemStateChanged(ItemEvent e) {

	    Object source = e.getItemSelectable();

	    if (source == eventConference) {
	    	System.out.println("1");

	    } else if (source == eventJournal) {
	    	System.out.println("2");

	    } else if (source == eventBook) {
	    	System.out.println("3");

	    }	    
	}
	
    /** Listens to the submit button click */
    public void actionPerformed(ActionEvent e) {
    	queryOutput.setText("Show the output of the query here!");
    }

}
