
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;


@SuppressWarnings("serial")
public class InventoryPanel extends JPanel {
	private static final int INVPANELHEIGHT = 100;
	private JProgressBar healthBar;
	private JProgressBar experienceBar;
	
	public InventoryPanel(){
		// set the size of the inventoryPanel
		Dimension size = getPreferredSize();
	    size.height = INVPANELHEIGHT;
	    setPreferredSize(size);
	    setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
	    
	    //Set layout manager
	    setLayout(new GridBagLayout());
	  
	    //create swing component
	    
	   
	    //PLACEHOLDER
	    JPanel PLACEHOLDER = new JPanel();
	    PLACEHOLDER.setLayout(new GridLayout(2,3));
	    //empty
	    
	    //	invButtonContainer
	    JPanel invButtonContainer = new JPanel();
	    invButtonContainer.setLayout(new GridLayout(2,3));
	    JButton itemButton1 = new JButton("ib1");
	    JButton itemButton2 = new JButton("ib2");
	    JButton itemButton3 = new JButton("ib3");
	    JButton itemButton4 = new JButton("ib4");
	    JButton itemButton5 = new JButton("ib5");
	    JButton itemButton6 = new JButton("ib6");
	    
	    invButtonContainer.add(itemButton1);
	    invButtonContainer.add(itemButton2);
	    invButtonContainer.add(itemButton3);
	    invButtonContainer.add(itemButton4);
	    invButtonContainer.add(itemButton5);
	    invButtonContainer.add(itemButton6);
	    
	    // playerStatusContainer // comment
	    JPanel playerStatusContainer = new JPanel();
	    playerStatusContainer.setLayout(new GridLayout(4,1));
	    JLabel label1 = new JLabel("Experience");
	    JLabel label2 = new JLabel("Health");

	    experienceBar = new JProgressBar(0,100);
	    experienceBar.setForeground(new Color(125, 0, 255));
	    experienceBar.setValue(30);
	    healthBar = new JProgressBar(0,100);
	    healthBar.setForeground(Color.RED);
	    healthBar.setValue(80);
	    
	    playerStatusContainer.add(label1);
	    playerStatusContainer.add(experienceBar);
	    playerStatusContainer.add(label2);
	    playerStatusContainer.add(healthBar);
	    
	    
	    //add Panel components to content pane
	    
	    ///////////////////// GridBagConstraints //////////////////////
	    GridBagConstraints gc = new GridBagConstraints();
	    
	    /*	gridlayout:
	     * -------------------------------------------------------------------
	     *  0  				|  			1   			|    2
	     *  PLACEHOLDER		|	invButtonContainer		|	attack : 
	     * 					|							|	attackbar:
	     * 					|							|	health :
	     * 					|							|	healthbar
	     * 	------------------------------------------------------------------								
	     * 	
	     */

	    //gc.ipady = 20;	//scale thickness in Y axis
	    gc.weightx = 1;
        gc.weighty = 1;
        
        //gc.anchor = GridBagConstraints.LINE_START;

        gc.gridx = 0;
        gc.gridy = 0;
        add(PLACEHOLDER, gc);
       
        gc.gridx = 1;
        gc.gridy = 0;
        add(invButtonContainer, gc);
        
        gc.gridx = 2;
        gc.gridy = 0; 
        add(playerStatusContainer, gc);
      
        
	    
	    ///////////////////////////////////////////////////////////////
	    
	    
	}
	
}
