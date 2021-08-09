package ui;

import model.CaseInfo;
import model.CaseList;
import model.Condition;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class CaseFrame extends JFrame implements ActionListener, ChangeListener {
    JPanel panel0;
    JPanel panel;
    private static JPanel textpanel;

    JMenuBar menubar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenu searchMenu;
    JMenu printMenu;
    JMenuItem saveItem;
    JMenuItem loadItem;
    JMenuItem exitItem;
    JMenuItem inputItem;
    JMenuItem deleteItem;
    JMenuItem searchLocationItem;
    JMenuItem searchTimeItem;
    JMenuItem searchCaseItem;
    JMenuItem renderItem;
    JLabel labellocationSlider;
    JLabel labelcaseIDSlider;
    JLabel labelTimeSlider;
    JSlider locationSlider;
    JSlider caseIDSlider;
    JSlider timeSlider;
    JButton locationSliderbutton;
    JButton caseIDSliderbutton;
    JButton timeSliderbutton;
    JButton inputSliderbutton;
    JButton deleteSliderbutton;

    List<CaseInfo> answer;
    LinkedList<ImageIcon> images = new LinkedList<>();
    LinkedList<JLabel> labels = new LinkedList<>();
    LinkedList<JPanel> panels = new LinkedList<>();

    public void labelinit() {
        setTitle("Case Tracker APP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(2000, 1100);

        panel0 = new JPanel();
        panel = new JPanel();
        textpanel = new JPanel();

        ImageIcon image = new ImageIcon("src/image/main_icon.png");
        ImageIcon image2 = new ImageIcon("src/image/background.tif");
        setIconImage(image.getImage());

        JLabel label = new JLabel();
        label.setText("Welcome to Case map!");
        label.setFont(new Font("MV Boli", Font.PLAIN, 45));
        label.setIcon(image2);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);

        panel.add(label);
        panel.setBounds(0, 0, 500, 850);
        textpanel.setBounds(0, 850, 2000, 300);
        textpanel.setBackground(Color.gray);
        add(panel);
        add(textpanel);
        add(panel0);
    }

    public void menuinit() {
        menubar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        searchMenu = new JMenu("Search");
        printMenu = new JMenu("Print");
        saveItem = new JMenuItem("Save");
        loadItem = new JMenuItem("Load");
        exitItem = new JMenuItem("Exit");
        inputItem = new JMenuItem("Input");
        deleteItem = new JMenuItem("Delete");
        searchLocationItem = new JMenuItem("Search by Location");
        searchTimeItem = new JMenuItem("Search by TimeItem");
        searchCaseItem = new JMenuItem("Search by CaseItem");
        renderItem = new JMenuItem("Render");
    }


    public void addtomenuinit() {
        saveItem.addActionListener(this);
        loadItem.addActionListener(this);
        exitItem.addActionListener(this);
        inputItem.addActionListener(this);
        deleteItem.addActionListener(this);
        searchLocationItem.addActionListener(this);
        searchTimeItem.addActionListener(this);
        searchCaseItem.addActionListener(this);
        renderItem.addActionListener(this);
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        fileMenu.add(exitItem);
        editMenu.add(inputItem);
        editMenu.add(deleteItem);
        searchMenu.add(searchLocationItem);
        searchMenu.add(searchTimeItem);
        searchMenu.add(searchCaseItem);
        printMenu.add(renderItem);
        menubar.add(fileMenu);
        menubar.add(editMenu);
        menubar.add(searchMenu);
        menubar.add(printMenu);
    }

    //EFFECTS: initializes the CaseFrame
    public CaseFrame() {
        labelinit();
        menuinit();
        addtomenuinit();
        setJMenuBar(menubar);
        setVisible(true);
    }

    public void locationSlider() {
        labellocationSlider = new JLabel();

        locationSlider = new JSlider(1, 100, 50);
        locationSlider.setPreferredSize(new Dimension(400, 200));
        locationSlider.setPaintTicks(true);
        locationSlider.setMinorTickSpacing(10);
        locationSlider.setPaintTrack(true);
        locationSlider.setMajorTickSpacing(25);
        locationSlider.setPaintLabels(true);
        locationSlider.setFont(new Font("MV Boli", Font.PLAIN, 35));
        locationSlider.addChangeListener(this);

        labellocationSlider.setText("Location: " + locationSlider.getValue());
        labellocationSlider.setVerticalTextPosition(labellocationSlider.CENTER);
        labellocationSlider.setHorizontalTextPosition(labellocationSlider.CENTER);

        panel.add(locationSlider);
        panel.add(labellocationSlider);
    }

    public void locationSliderButton() {
        locationSliderbutton = new JButton();

        locationSliderbutton.setText("submit");
        locationSliderbutton.setFont(new Font("MV Boli", Font.PLAIN, 35));
        locationSliderbutton.setFocusable(false);
        locationSliderbutton.setBounds(200, 100, 100, 50);
        locationSliderbutton.addActionListener(this);

        panel.add(locationSliderbutton);
    }

    public void caseIDSlider() {
        labelcaseIDSlider = new JLabel();

        caseIDSlider = new JSlider(500, 999, 750);
        caseIDSlider.setPreferredSize(new Dimension(400, 200));
        caseIDSlider.setPaintTicks(true);
        caseIDSlider.setMinorTickSpacing(50);
        caseIDSlider.setPaintTrack(true);
        caseIDSlider.setMajorTickSpacing(125);
        caseIDSlider.setPaintLabels(true);
        caseIDSlider.setFont(new Font("MV Boli", Font.PLAIN, 35));
        caseIDSlider.addChangeListener(this);

        labelcaseIDSlider.setText("caseID: " + caseIDSlider.getValue());

        panel.add(caseIDSlider);
        panel.add(labelcaseIDSlider);
    }

    public void caseIDSliderButton() {
        caseIDSliderbutton = new JButton();
        caseIDSliderbutton.setText("submit");
        caseIDSliderbutton.setFont(new Font("MV Boli", Font.PLAIN, 15));
        caseIDSliderbutton.setFocusable(false);
        caseIDSliderbutton.setBounds(200, 100, 100, 50);
        caseIDSliderbutton.addActionListener(this);
        panel.add(caseIDSliderbutton);
    }

    public void timeSlider() {
        labelTimeSlider = new JLabel();

        timeSlider = new JSlider(0, 24, 12);
        timeSlider.setPreferredSize(new Dimension(400, 200));
        timeSlider.setPaintTicks(true);
        timeSlider.setMinorTickSpacing(2);
        timeSlider.setPaintTrack(true);
        timeSlider.setMajorTickSpacing(6);
        timeSlider.setPaintLabels(true);
        timeSlider.setFont(new Font("MV Boli", Font.PLAIN, 35));
        timeSlider.addChangeListener(this);

        labelTimeSlider.setText("Time: " + timeSlider.getValue());

        panel.add(timeSlider);
        panel.add(labelTimeSlider);

    }

    public void timeSliderButton() {
        timeSliderbutton = new JButton();

        timeSliderbutton.setText("submit");
        timeSliderbutton.setFont(new Font("MV Boli", Font.PLAIN, 35));
        timeSliderbutton.setFocusable(false);
        timeSliderbutton.setBounds(200, 100, 100, 50);
        timeSliderbutton.addActionListener(this);

        panel.add(timeSliderbutton);
    }


    public void inputSliderButton() {
        inputSliderbutton = new JButton();

        inputSliderbutton.setText("submit");
        inputSliderbutton.setFont(new Font("MV Boli", Font.PLAIN, 35));
        inputSliderbutton.setFocusable(false);
        inputSliderbutton.setBounds(200, 100, 100, 50);
        inputSliderbutton.addActionListener(this);

        panel.add(inputSliderbutton);
    }

    public void deleteSliderButton() {
        deleteSliderbutton = new JButton();

        deleteSliderbutton.setText("submit");
        deleteSliderbutton.setFont(new Font("MV Boli", Font.PLAIN, 35));
        deleteSliderbutton.setFocusable(false);
        deleteSliderbutton.setBounds(200, 100, 100, 50);
        deleteSliderbutton.addActionListener(this);

        panel.add(deleteSliderbutton);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == locationSlider) {
            labellocationSlider.setText("Location: " + locationSlider.getValue());
        }
        if (e.getSource() == caseIDSlider) {
            labelcaseIDSlider.setText("caseID: " + caseIDSlider.getValue());
        }
        if (e.getSource() == timeSlider) {
            labelTimeSlider.setText("Time: " + timeSlider.getValue());
        }
    }

    public void updated(JPanel jpanel) {
        jpanel.removeAll();
        jpanel.revalidate();
        jpanel.repaint();
    }

    int location = 1;
    int time = 0;
    int caseID = 500;

    public void fileAction(ActionEvent e) {
        if (e.getSource() == saveItem) {
            CaseTracker.saveRecord();
        }
        if (e.getSource() == loadItem) {
            CaseTracker.loadRecord();
        }
        if (e.getSource() == exitItem) {
            System.exit(-1);
        }
    }

    public void editAction(ActionEvent e) {
        if (e.getSource() == inputItem) {
            updated(panel);
            locationSlider();
            timeSlider();
            caseIDSlider();
            inputSliderButton();
        }

        if (e.getSource() == deleteItem) {
            updated(panel);
            locationSlider();
            deleteSliderButton();
        }
    }

    public void searchAction(ActionEvent e) {
        if (e.getSource() == searchLocationItem) {
            updated(panel);
            locationSlider();
            locationSliderButton();
        }
        if (e.getSource() == searchTimeItem) {
            updated(panel);
            timeSlider();
            timeSliderButton();
        }
        if (e.getSource() == searchCaseItem) {
            updated(panel);
            caseIDSlider();
            caseIDSliderButton();
        }
    }

    public void renderActionInit() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                labels.add(new JLabel());
                panels.add(new JPanel());
                images.add(new ImageIcon("src/image/0.png"));
            }
        }
    }

    public void renderActionforloopCon(int i, int j) {
        panels.get(i * 10 + j).removeAll();
        panels.get(i * 10 + j).revalidate();
        panels.get(i * 10 + j).repaint();
        labels.get(i * 10 + j).setText("");
        images.set(i * 10 + j, new ImageIcon("src/image/0.png"));
        labels.get(i * 10 + j).setText(" ");
        int[][] numberofRepeat = new int[10][10];
        for (CaseInfo a : answer) {
            if (i * 10 + j == a.getLocation() - 1 && numberofRepeat[i][j] < 3) {
                numberofRepeat[i][j]++;
            }
            images.set(i * 10 + j, new ImageIcon("src/image/" + numberofRepeat[i][j] + ".png"));
            //labels.get(i * 10 + j).setText("time: " + a.getTime());
        }
        labels.get(i * 10 + j).setIcon(images.get(i * 10 + j));
        labels.get(i * 10 + j).setFont(new Font("MV Boli", Font.PLAIN, 12));
        labels.get(i * 10 + j).setHorizontalTextPosition(JLabel.CENTER);
        labels.get(i * 10 + j).setVerticalTextPosition(JLabel.TOP);
        panels.get(i * 10 + j).add(labels.get(i * 10 + j));
        panels.get(i * 10 + j).setBounds(j * 75 + 550, i * 75 + 100, 75, 75);
        add(panels.get(i * 10 + j));
    }

    public void renderfunction() {
        renderActionInit();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                renderActionforloopCon(i, j);
            }
        }
        add(panel0);
        setVisible(true);
    }

    public void renderAction(ActionEvent e) {
        if (e.getSource() == renderItem) {
            answer = CaseTracker.getRecord().getCaseInfo();
            renderfunction();
        }

    }

    public void editSliderbutton(ActionEvent e) {
        if (e.getSource() == inputSliderbutton) {
            location = locationSlider.getValue();
            time = timeSlider.getValue();
            caseID = caseIDSlider.getValue();
            Condition.inputInfoCon(CaseTracker.getRecord(), location, time, caseID);
            answer = CaseTracker.getRecord().getCaseInfo();
            renderfunction();
        }

        if (e.getSource() == deleteSliderbutton) {
            location = locationSlider.getValue();
            Condition.removeInfoCon(CaseTracker.getRecord(), location, time, caseID);
            answer = CaseTracker.getRecord().getCaseInfo();
            renderfunction();
        }
    }


    public void searchSliderbutton(ActionEvent e) {
        if (e.getSource() == locationSliderbutton) {
            location = locationSlider.getValue();
            Condition.searchLocationCon(CaseTracker.getRecord(), location, time, caseID);
            answer = CaseList.getanswer();
            renderfunction();
        }

        if (e.getSource() == caseIDSliderbutton) {
            caseID = caseIDSlider.getValue();
            Condition.searchIDCon(CaseTracker.getRecord(), location, time, caseID);
            answer = CaseList.getanswer();
            renderfunction();
        }

        if (e.getSource() == timeSliderbutton) {
            time = timeSlider.getValue();
            Condition.searchTimeCon(CaseTracker.getRecord(), location, time, caseID);
            answer = CaseList.getanswer();
            renderfunction();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fileAction(e);
        editAction(e);
        searchAction(e);
        renderAction(e);
        editSliderbutton(e);
        searchSliderbutton(e);
    }
}
