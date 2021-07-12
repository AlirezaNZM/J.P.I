package UIDesign;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AdminUI{
    
        protected static JPanel adminWorkingPanel;
        protected static CardLayout adminLayoutManager;
    
        protected static void setAdminUI () {

            JPanel mainTitleBar = SharedComponents.TitleBar.getTitleBar(750, 100);
            JPanel sideBar = SharedComponents.SideBar.getSideBar(200, 650, false);
            
            JFrame mainFrame = SharedComponents.Frame.getFrame(750, 750);
            mainFrame.setVisible(true);
    
            JPanel mainPanel = new JPanel();
            mainPanel.setPreferredSize(new Dimension(750, 650));
            mainPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
            
            adminLayoutManager = new CardLayout();
            adminWorkingPanel = new JPanel();
            adminWorkingPanel.setBackground(Color.GRAY);
            adminWorkingPanel.setPreferredSize(new Dimension(550, 650));
            adminWorkingPanel.setLayout(adminLayoutManager);
            adminWorkingPanel.add(UserUI.WelcomePage.getWelcomePage(), "Welcome");
            adminWorkingPanel.add(HomePage.setHomePage(), "Home");
            adminWorkingPanel.add(BookManagement.getBookManagement(), "BookManagement");
            adminWorkingPanel.add(UserManagement.getUserManagement(), "UserManagement");
    
            
    
            mainPanel.add(sideBar);
            mainPanel.add(adminWorkingPanel);
            mainFrame.add(mainTitleBar);
            mainFrame.add(mainPanel);
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
    
                return homePanel;
    
            }
    
    
        };
    
        
        protected static class UserManagement {
            
            
            protected static CardLayout userManagementLayoutManager = new CardLayout();
            protected static JPanel singleButtonPanel, mainPanel, userManagementPanel, addBookNUserPage, deleteBookNUserPage, borrowTimeExtendPage;
            protected static JLabel addBookNUserMessagePopup, deleteBookNUserBookMessagePopup, borrowTimeExtendMessagePopup, tempLabel;
            protected static JButton deleteBookNUserButton, addBookNUserButton, addBookNUserMenuButton, borrowTimeExtendMenuButton, deleteBookNUserMenuButton, borrowTimeExtendButton;
            private  static Dimension popupDimension;
            public static JTextField getUsername, tempTextField;
            
            private static JPanel setUserManagement() {
                
                popupDimension = new Dimension(300, 100);
                
                
                mainPanel = new JPanel();
                mainPanel.setBackground(Color.DARK_GRAY);
                mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
                
                addBookNUserMenuButton = SharedComponents.Buttons.getButton("Add Book Or User");
                addBookNUserButton = SharedComponents.Buttons.getButton("Add Book Or User");
                addBookNUserMessagePopup = SharedComponents.Labels.getLabel("", 20);
                addBookNUserMessagePopup.setPreferredSize(popupDimension);


                deleteBookNUserMenuButton = SharedComponents.Buttons.getButton("Delete Book Or User");
                deleteBookNUserButton = SharedComponents.Buttons.getButton("Delete Book Or User");
                deleteBookNUserBookMessagePopup = SharedComponents.Labels.getLabel("", 20);
                deleteBookNUserBookMessagePopup.setPreferredSize(popupDimension);


                borrowTimeExtendMenuButton = SharedComponents.Buttons.getButton("Borrow Time Extend");
                borrowTimeExtendButton = SharedComponents.Buttons.getButton("Extend Borrow Time");
                borrowTimeExtendMessagePopup = SharedComponents.Labels.getLabel("", 20);
                borrowTimeExtendMessagePopup.setPreferredSize(popupDimension);
                
                mainPanel.add(Box.createVerticalGlue());
                mainPanel.add(addBookNUserMenuButton);
                mainPanel.add(Box.createVerticalGlue());
                mainPanel.add(deleteBookNUserMenuButton);
                mainPanel.add(Box.createVerticalGlue());
                mainPanel.add(borrowTimeExtendMenuButton);
                mainPanel.add(Box.createVerticalGlue());

                tempLabel = SharedComponents.Labels.getLabel("Password", 20);
                tempLabel.setPreferredSize(new Dimension(100, 100));
                tempTextField = SharedComponents.TextFields.getTextField();
                getUsername = SharedComponents.TextFields.getTextField();

                addBookNUserPage = singleButtonPage("Book Or User Name");
                addBookNUserPage.add(tempLabel);
                addBookNUserPage.add(tempTextField);
                addBookNUserPage.add(addBookNUserMessagePopup);
                addBookNUserPage.add(addBookNUserButton);


                deleteBookNUserPage = singleButtonPage("Book Or User Name");
                deleteBookNUserPage.add(deleteBookNUserBookMessagePopup);
                deleteBookNUserPage.add(deleteBookNUserButton);


                borrowTimeExtendPage = singleButtonPage("Book Name");
                borrowTimeExtendPage.add(borrowTimeExtendMessagePopup);
                borrowTimeExtendPage.add(borrowTimeExtendButton);
                
                
                userManagementPanel = new JPanel();
                userManagementPanel.setBackground(Color.GRAY);
                userManagementPanel.setPreferredSize(new Dimension(550, 650));
                userManagementPanel.setLayout(userManagementLayoutManager);
                
                
                userManagementPanel.add(mainPanel, "MainPanel");
                userManagementPanel.add(addBookNUserPage, "addBookNUserPage");
                userManagementPanel.add(deleteBookNUserPage, "deleteBookNUserPage");
                userManagementPanel.add(borrowTimeExtendPage, "borrowTimeExtendPage");
                
                
                return userManagementPanel;
                
            };
            
            protected static JPanel getUserManagement() {
        
                JPanel panel = setUserManagement();
                return panel;
        
            }
    
            protected static JPanel singleButtonPage (String labelName) {
                
                getUsername = SharedComponents.TextFields.getTextField();

                singleButtonPanel = new JPanel();
                singleButtonPanel.setBackground(Color.DARK_GRAY);
                singleButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 70));
                singleButtonPanel.add(SharedComponents.Labels.getLabel(labelName + ":", 20));
                singleButtonPanel.add(getUsername);
                
                return singleButtonPanel;
                
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
                
                addOrBorrowBookMenuButton = SharedComponents.Buttons.getButton("AddBook");
                addOrBorrowBookButton = SharedComponents.Buttons.getButton("Add");
                addMessagePopup = SharedComponents.Labels.getLabel("", 20);
                addMessagePopup.setPreferredSize(popupDimension);
    
                
                returnBookMenuButton = SharedComponents.Buttons.getButton("Delete Book");
                returnBookButton = SharedComponents.Buttons.getButton("Delete");
                returnBookMessagePopup = SharedComponents.Labels.getLabel("", 20);
                returnBookMessagePopup.setPreferredSize(popupDimension);
    
    
                returnDateMenuButton = SharedComponents.Buttons.getButton("Borrow Time Extend");
                returnDateButton = SharedComponents.Buttons.getButton("Extend");
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
        }
        
}
