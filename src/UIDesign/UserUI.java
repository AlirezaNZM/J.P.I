package UIDesign;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;


public class UserUI {

    // protected static JButton addBookButton, bookStatusButton, returnBookButton;
    protected static JPanel workingPanel;
    protected static CardLayout layoutManager;

    protected static void setUserUI () {
        JPanel mainTitleBar = SharedComponents.TitleBar.getTitleBar(750, 100);
        JPanel sideBar = SharedComponents.SideBar.getSideBar(200, 650, false);
        
        JFrame mainFrame = SharedComponents.Frame.getFrame(750, 750);
        mainFrame.setVisible(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(750, 650));
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        
        layoutManager = new CardLayout();
        workingPanel = new JPanel();
        workingPanel.setBackground(Color.GRAY);
        workingPanel.setPreferredSize(new Dimension(550, 650));
        workingPanel.setLayout(layoutManager);
        workingPanel.add(WelcomePage.setWelcomePage(), "Welcome");
        workingPanel.add(HomePage.setHomePage(), "Home");
        workingPanel.add(BookManagement.setBookManagement(), "BookManagement");

        

        mainPanel.add(sideBar);
        mainPanel.add(workingPanel);
        mainFrame.add(mainTitleBar);
        mainFrame.add(mainPanel);
    }
    
    protected static class WelcomePage {
        
        private static JPanel setWelcomePage() {
            
            JPanel welcomePanel = new JPanel();
            welcomePanel.setBackground(Color.DARK_GRAY);
            welcomePanel.setPreferredSize(new Dimension(550, 650));
            welcomePanel.setLayout(new BorderLayout());
            JLabel welcomeTxt = SharedComponents.Labels.getLabel("<html>Welcome To The <BR> HUT Integrated <BR> Library System</html>", 30);
            welcomeTxt.setHorizontalAlignment(SwingConstants.CENTER);
            welcomePanel.add(welcomeTxt, BorderLayout.CENTER);
            
            return welcomePanel;
            
        }
        protected static JPanel getWelcomePage() {
    
            JPanel panel = WelcomePage.setWelcomePage();
            return panel;
    
        }
    }

    protected static class HomePage {

        private static JPanel setHomePage () {

            JLabel userCount = SharedComponents.Labels.getLabel("UserCount ", 30);
            JLabel booksCount = SharedComponents.Labels.getLabel("BooksCount ", 30);

            JPanel homePanel = new JPanel();
            homePanel.setBackground(Color.DARK_GRAY);
            homePanel.setPreferredSize(new Dimension(550, 650));
            homePanel.setLayout(new BorderLayout());

            homePanel.add(Box.createVerticalGlue());
            homePanel.add(userCount, BorderLayout.LINE_START);
            homePanel.add(booksCount, BorderLayout.LINE_END);
            homePanel.add(Box.createVerticalGlue());
            homePanel.add(setStatsTable(), BorderLayout.PAGE_END);

            return homePanel;

        }

        protected static JScrollPane setStatsTable() {


            String[][] data = { {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"} };

            String column[] = {"ID","NAME","SALARY"};       

            JTable statsTable = new JTable(data, column);
            statsTable.setPreferredSize(new Dimension (400, 400));
            statsTable.setFocusable(false);
            statsTable.setBackground(Color.DARK_GRAY);
            statsTable.setForeground(Color.WHITE);
            statsTable.setSelectionBackground(Color.DARK_GRAY);
            statsTable.setSelectionForeground(Color.WHITE);
            JTableHeader header = statsTable.getTableHeader();
            header.setBackground(Color.DARK_GRAY);
            header.setForeground(Color.WHITE);
            JScrollPane scrollPane = new JScrollPane(statsTable);
            scrollPane.setBackground(Color.DARK_GRAY);

            return scrollPane;

        };

    };

    
    protected static class BookManagement {
        
        
        protected static CardLayout bookManagementLayoutManager = new CardLayout();
        protected static JPanel singleButtonPanel, mainPanel, bookManagementPanel, addOrBorrowPage, returnBookPage, returnDatePage;
        protected static JLabel addMessagePopup, returnBookMessagePopup, returnDateMessagePopup;
        protected static JButton returnBookButton, addOrBorrowBookButton, addOrBorrowBookMenuButton, returnDateMenuButton, returnBookMenuButton, returnDateButton;
        private  static Dimension popupDimension;
        
        private static JPanel setBookManagement() {
            
            popupDimension = new Dimension(300, 100);
            
            
            mainPanel = new JPanel();
            mainPanel.setBackground(Color.DARK_GRAY);
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
            
            addOrBorrowBookMenuButton = SharedComponents.Buttons.getButton("Add Or Borrow Book");
            addOrBorrowBookButton = SharedComponents.Buttons.getButton("Add Or Borrow");
            addMessagePopup = SharedComponents.Labels.getLabel("", 20);
            addMessagePopup.setPreferredSize(popupDimension);

            
            returnBookMenuButton = SharedComponents.Buttons.getButton("Return Book");
            returnBookButton = SharedComponents.Buttons.getButton("Return Book");
            returnBookMessagePopup = SharedComponents.Labels.getLabel("", 20);
            returnBookMessagePopup.setPreferredSize(popupDimension);


            returnDateMenuButton = SharedComponents.Buttons.getButton("Return Date");
            returnDateButton = SharedComponents.Buttons.getButton("See Return Date");
            returnDateMessagePopup = SharedComponents.Labels.getLabel("", 20);
            returnDateMessagePopup.setPreferredSize(popupDimension);
            
            addOrBorrowPage = singleButtonPage("Book Name");
            addOrBorrowPage.add(addMessagePopup);
            addOrBorrowPage.add(addOrBorrowBookButton);
            returnBookPage = singleButtonPage("Book Name");
            returnBookPage.add(returnBookMessagePopup);
            returnBookPage.add(returnBookButton);
            returnDatePage = singleButtonPage("Book Name");
            returnDatePage.add(returnDateMessagePopup);
            returnDatePage.add(returnDateButton);
            
            
            mainPanel.add(Box.createVerticalGlue());
            mainPanel.add(addOrBorrowBookMenuButton);
            mainPanel.add(Box.createVerticalGlue());
            mainPanel.add(returnBookMenuButton);
            mainPanel.add(Box.createVerticalGlue());
            mainPanel.add(returnDateMenuButton);
            mainPanel.add(Box.createVerticalGlue());
            
            bookManagementPanel = new JPanel();
            bookManagementPanel.setBackground(Color.GRAY);
            bookManagementPanel.setPreferredSize(new Dimension(550, 650));
            bookManagementPanel.setLayout(bookManagementLayoutManager);
            
            
            bookManagementPanel.add(mainPanel, "MainPanel");
            bookManagementPanel.add(addOrBorrowPage, "AddOrBorrowBookPage");
            bookManagementPanel.add(returnBookPage, "ReturnBookPage");
            bookManagementPanel.add(returnDatePage, "ReturnDatePage");
            
            
            return bookManagementPanel;
            
        };
        
        protected static JPanel getBookManagement() {
    
            JPanel panel = BookManagement.setBookManagement();
            return panel;
    
        }

        protected static JPanel singleButtonPage (String labelName) {
            
            singleButtonPanel = new JPanel();
            singleButtonPanel.setBackground(Color.DARK_GRAY);
            singleButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 100));
            singleButtonPanel.add(SharedComponents.Labels.getLabel(labelName + ":", 20));
            singleButtonPanel.add(SharedComponents.TextFields.getTextField());
            
            return singleButtonPanel;
            
        };
        
        
    };

}
