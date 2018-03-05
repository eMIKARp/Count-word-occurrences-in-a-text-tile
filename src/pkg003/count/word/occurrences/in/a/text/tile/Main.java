package pkg003.count.word.occurrences.in.a.text.tile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.*;

/**
 * Pro/g/ramming Challenges v 3.0
 * 003 - Count word occurrences in a text tile
 * @author Emil.Karpowicz
 */

public class Main extends JFrame 
{
    private static double sWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static double sHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    
    private static int cubit = 100;
    
    private static JPanel mainPanel = new JPanel();
    private JPanel textPanel = new JPanel();
    private JTextArea textArea = new  JTextArea();
    private JScrollPane scrollTextArea = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    private JPanel outcomePanel = new JPanel();
    private JPanel controlPanel = new JPanel();
    
    private int counter = 0;
    
    private CustomLabel countingResultStatement = new CustomLabel("The phrase you are looking for occured " + counter + " times in bellow document.");
    
    private CustomButton uploadFileButton = new CustomButton("Upload File");
    private CustomButton countWordOccurance = new CustomButton("Count Word Occurance");
    private CustomTextField wordToLookFor = new CustomTextField();
    private static File fileToUpload;
    
    
    public Main()
    {
        this.setTitle("PCv3.0: 003 - Count word occurrences in a text tile");
        this.setBounds((int)((sWidth - 8*cubit)/ 2), (int)((sHeight-5*cubit) / 2), 8*cubit, 5*cubit);
        this.getContentPane().add(mainPanel);
            mainPanel.setLayout(new BorderLayout());
            outcomePanel.setBorder(BorderFactory.createBevelBorder(0));
            outcomePanel.setPreferredSize(new Dimension(this.getWidth(), cubit / 2));
            outcomePanel.add(countingResultStatement);
            mainPanel.add(outcomePanel, BorderLayout.NORTH);
            scrollTextArea.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
            mainPanel.add(scrollTextArea, BorderLayout.CENTER);
            controlPanel.setBorder(BorderFactory.createBevelBorder(0));
            controlPanel.setPreferredSize(new Dimension(this.getWidth(), cubit / 2));
            mainPanel.add(controlPanel, BorderLayout.SOUTH);
            
            uploadFileButton.setPreferredSize(new Dimension(2*cubit,cubit / 3));
            countWordOccurance.setPreferredSize(new Dimension(2*cubit,cubit / 3));
            wordToLookFor.setPreferredSize(new Dimension(2*cubit,cubit / 3));
            controlPanel.add(uploadFileButton);
            controlPanel.add(countWordOccurance);
            controlPanel.add(wordToLookFor);
            
            
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) 
    {
        new Main().setVisible(true);
    }
    
    public static void uploadFile()
    {
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("."));
        if (fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) fileToUpload = fc.getSelectedFile();
        System.out.println("File you choose to upload: " + fc.getSelectedFile().getPath());
    }
    
    public static void coundWordOccurance()
    {
        System.out.println("Count Word Occurance");
    }
    
}

class CustomTextField extends JTextField
{
    public CustomTextField()
    {
        super();
        
    }
}

class CustomButton extends JButton
{
    public CustomButton(String buttonName)
    {
        super(buttonName);
        
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if (((JButton)e.getSource()).getText()== "Upload File") 
                {
                    Main.uploadFile();
                }
                else if (((JButton)e.getSource()).getText() == "Count Word Occurance") 
                {
                    Main.coundWordOccurance();
                }
            }
        });
    }    
}

class CustomLabel extends JLabel
{
    public CustomLabel(String labelText)
    {
        super(labelText);
        this.setFont(new Font("Arial", TOP, 20));
    }
}
