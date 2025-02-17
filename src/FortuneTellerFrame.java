import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    JPanel mainPnl;
    JPanel iconPnl;  // Top
    JPanel displayPnl; // Center
    JPanel controlPnl; // Bottom

    JTextArea displayTA;
    JScrollPane scroller;

    JLabel titleLbl;
    ImageIcon icon;

    JButton fortuneBtn;

    JButton quitBtn;


    Random rnd = new Random();
    int previousFortune = 14;
    int currentFortune = 0;
    ArrayList<String> fortunes = new ArrayList<>();



    public FortuneTellerFrame()
    {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
// center frame in screen


        fortunes.add("You will experience a kernel panic in the middle of something important this year.");
        fortunes.add("You will encounter an unexpected EOF while reading a fortune.");
        fortunes.add("Tomorrow, your code will compile with zero warnings and errors.");
        fortunes.add("A wild bug will appear in production, but you shall catch it swiftly.");
        fortunes.add("Your favorite framework will receive a major update—brace yourself!");
        fortunes.add("You will master the art of writing documentation that others will actually read.");
        fortunes.add("Beware of off-by-one errors lurking in your loops.");
        fortunes.add("You will experience a merge conflict of epic proportions.");
        fortunes.add("The next commit message you write will be worthy of a legend.");
        fortunes.add("Your future holds a never-ending while(true) loop of success.");
        fortunes.add("One day, your code will be so elegant that even Linus Torvalds will applaud.");
        fortunes.add("The Stack Overflow fairy will grant you the perfect answer to your toughest question.");
        fortunes.add("Your next refactor will reduce your codebase by 50% and increase readability by 200%.");






        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createIconPanel();
        mainPnl.add(iconPnl, BorderLayout.NORTH);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.CENTER);

        createControlPanel();
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        add(mainPnl);

        setSize((screenWidth / 4) *3, (screenHeight / 4) *3);
        setLocation(screenWidth / 8, screenHeight / 8);
        //setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createIconPanel()
    {
        iconPnl = new JPanel();
        icon = new ImageIcon("src/Wizard.png");
        titleLbl = new JLabel("Welcome to The Gundam Fortune Teller", icon, JLabel.CENTER);
        titleLbl.setFont(new Font("Ubuntu", Font.PLAIN, 36));
        // Obscure code to align the text to the Icon!
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        iconPnl.add(titleLbl);
    }

    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        displayTA = new JTextArea(10, 86);
        displayTA.setFont(new Font("Ubuntu Mono", Font.PLAIN, 15));


        displayTA.setEditable(false);
        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
    }


    private void createControlPanel()
    {
        controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 4));

        fortuneBtn = new JButton("Read My Fortune!");
        fortuneBtn.setFont(new Font("Ubuntu Bold", Font.PLAIN, 20));
        fortuneBtn.addActionListener((ActionEvent ae) ->
        {
            currentFortune = rnd.nextInt(fortunes.size());
            do {
                currentFortune = rnd.nextInt(fortunes.size());
            }while (currentFortune == previousFortune);

            displayTA.append(fortunes.get(currentFortune) + "\n");
            previousFortune = currentFortune;
        });


        quitBtn = new JButton("Quit!");
        quitBtn.setFont(new Font("Ubuntu Thin", Font.PLAIN, 20));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        controlPnl.add(fortuneBtn);
        controlPnl.add(quitBtn);

    }
}
