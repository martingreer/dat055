package View;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import Model.Enemy;
import Model.ImageResources;
import Model.Player;


@SuppressWarnings("serial")
public class StatusPanel extends JPanel {
	private static final int INVPANELHEIGHT = 150;
	private JProgressBar healthBar;
	private JProgressBar experienceBar;
	private JProgressBar enemyHealthBar;
	private JLabel portraitLabel;
	private JLabel playerLevelLabel;
	private JLabel playerAttackLabel;
	private JLabel playerHealthLabel;
	private JLabel enemyLevelLabel;
	private JLabel enemyAttackLabel;
	private JLabel enemyHealthLabel;
	private JLabel enemyPortrait;
	
	private ImageResources res = new ImageResources();
	
	public StatusPanel(){
		Dimension size = getPreferredSize();
	    size.height = INVPANELHEIGHT;
	    setPreferredSize(size);
	    setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
	    
	    setLayout(new GridBagLayout());
	    
	    
	    experienceBar = new JProgressBar(0,100);
	    experienceBar.setForeground(new Color(125, 0, 255));
	    experienceBar.setValue(30);
	    healthBar = new JProgressBar();
	    healthBar.setForeground(Color.RED);
	    enemyHealthBar = new JProgressBar();
	    enemyHealthBar.setForeground(Color.RED);
	    
	    JPanel playerBarContainer = new JPanel();
	    playerBarContainer.setLayout(new GridLayout(3,1,0,2));
	    JLabel playerLabel = new JLabel("Player");
	    playerBarContainer.add(playerLabel);
	    playerBarContainer.add(healthBar);
	    playerBarContainer.add(experienceBar);

	    JPanel enemyBarContainer = new JPanel();
	    enemyBarContainer.setLayout(new GridLayout(3,1,0,2));    
	    JLabel enemyLabel = new JLabel("Enemy\n");
	    enemyBarContainer.add(enemyLabel);
	    enemyBarContainer.add(enemyHealthBar);
	    
	    JPanel playerPortraitContainer = new JPanel();	    
	    portraitLabel = new JLabel(res.getImgIcon("playerPortrait2"));
	    playerPortraitContainer.add(portraitLabel);
	    
	    JPanel playerStatusContainer = new JPanel();
	    playerStatusContainer.setLayout(new GridLayout(3,1));	    
	    playerLevelLabel = new JLabel("");
	    playerStatusContainer.add(playerLevelLabel);
	    playerAttackLabel = new JLabel("");
	    playerStatusContainer.add(playerAttackLabel);
	    playerHealthLabel = new JLabel("");
	    playerStatusContainer.add(playerHealthLabel);
	    
	    JPanel enemyStatusContainer = new JPanel();
	    enemyStatusContainer.setLayout(new GridLayout(3,1));	  
	    enemyLevelLabel = new JLabel("");
	    enemyStatusContainer.add(enemyLevelLabel);
	    enemyAttackLabel = new JLabel("");
	    enemyStatusContainer.add(enemyAttackLabel);
	    enemyHealthLabel = new JLabel("");
	    enemyStatusContainer.add(enemyHealthLabel);
	    
	    JPanel enemyPortraitContainer = new JPanel();	    
	    enemyPortrait = new JLabel(res.getImgIcon(""));//Den h�r ska tas bort n�r vi kan kolla vilken fiende vi sl�ss mot
	    enemyPortraitContainer.add(enemyPortrait);
	    
	    GridBagConstraints gc = new GridBagConstraints();

	    gc.insets = new Insets(3,3,3,3);
	    gc.anchor = GridBagConstraints.WEST;
	    gc.weightx = 1;
	    gc.weighty = 1;
	    
	    gc.gridwidth = 2;
	    
        gc.gridx = 0;
        gc.gridy = 0;
        add(playerBarContainer, gc);
        
        gc.anchor = GridBagConstraints.EAST;
        gc.gridx = 2;
        gc.gridy = 0;
        add(enemyBarContainer, gc);
        
	    gc.gridwidth = 1;
	    gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0;
        gc.gridy = 1; 
        add(playerPortraitContainer, gc);
        
        gc.gridx = 1;
        gc.gridy = 1; 
        add(playerStatusContainer, gc);
        
        gc.anchor = GridBagConstraints.EAST;
        gc.gridx = 2;
        gc.gridy = 1; 
        add(enemyStatusContainer, gc);
        
        gc.gridx = 3;
        gc.gridy = 1; 
        add(enemyPortraitContainer, gc);

	}
	

	public void updatePanel(Player player, Enemy enemy){
		healthBar.setMaximum(player.getMaxHp());
		healthBar.setValue(player.getHp());
		experienceBar.setValue(player.getExp());
		playerAttackLabel.setText("Attack: "+player.getAttack());
		playerLevelLabel.setText("Level: "+player.getLevel());
		playerHealthLabel.setText("Health: "+player.getHp()+"/"+player.getMaxHp());
		if(enemy != null){
			enemyHealthBar.setMaximum(enemy.getMaxHp());
			enemyHealthBar.setValue(enemy.getHp());
			enemyAttackLabel.setText("Attack: "+enemy.getAttack());
			enemyLevelLabel.setText("Level: "+enemy.getLevel());
			enemyPortrait.setIcon(res.getImgIcon(enemy.getName() + "Portrait"));
			enemyHealthLabel.setText("Health: "+enemy.getHp()+"/"+enemy.getMaxHp());
		}
		else{
			enemyHealthBar.setValue(0);
			enemyHealthLabel.setText("Health: 0/0");
		}
	}
}