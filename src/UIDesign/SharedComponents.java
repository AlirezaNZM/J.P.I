package UIDesign;

import java.awt.geom.RoundRectangle2D;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import library.Member;
import libraryManager.AdminManager;
import libraryManager.MemberManager;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;



public class SharedComponents {


    protected static class Frame extends JFrame {

        protected static JFrame frame;

        private static JFrame setFrame(int width, int height) {

            frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(width, height);
            frame.setUndecorated(true);
            frame.setLocationRelativeTo(null);
            frame.setShape(new RoundRectangle2D.Double(0, 0, width, height, 75, 75));
            frame.setIconImage(new ImageIcon("lib/HUT-logo.png").getImage());
            frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

            return frame;

        };

        protected static JFrame getFrame(int width, int height) {

            frame = setFrame(width, height);
            return frame;
            
        };

    };

    protected static class TitleBar extends JPanel{

        protected static JButton minimizeButton, closeButton;
        protected static JPanel titleBar;
        protected static JLabel titleTxt;
        

        private static JPanel setTitleBar(int width, int height) {
            
            titleBar = new JPanel();
            titleBar.setBackground(Color.BLACK);
            titleBar.setLayout(new BoxLayout(titleBar, BoxLayout.LINE_AXIS));
            titleBar.setPreferredSize(new Dimension(width, height));

            closeButton = getTitleBarButton("X");
            
            minimizeButton = getTitleBarButton("-");
            minimizeButton.setFont(new Font("Dialog", Font.BOLD, 40));

            titleTxt = Labels.getLabel("Integrated Library System", 20);

            JLabel titleImg = new JLabel();
            titleImg.setIcon(new ImageIcon("lib/HUT-logo.png"));

            titleBar.add(titleImg);
            titleBar.add(Box.createHorizontalGlue());
            titleBar.add(titleTxt);
            titleBar.add(Box.createHorizontalGlue());
            titleBar.add(minimizeButton);
            titleBar.add(closeButton);
            Listeners.setMouseListener(titleBar);
            Listeners.setMouseMotionListener(titleBar);

            return titleBar;

        };

        protected static JPanel getTitleBar(int width, int height) {
            
            titleBar = setTitleBar(width, height);
            return titleBar;
        };

        private static JButton setTitleBarButton(String txt) {

            JButton button = new JButton();
            button = new JButton(txt);
            button.setFont(new Font("Dialog", Font.BOLD, 20));
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
            button.setForeground(Color.WHITE);
            Listeners.setActionListener(button);
            
            return button;

        };
        protected static JButton getTitleBarButton(String txt) {

            JButton button = setTitleBarButton(txt);
            return button;

        }

    };

    protected static class SideBar extends JPanel{

        protected static JLabel home, bookMgr, logout, userMgr, report;

        private static JPanel setSideBar (int width, int height, boolean adminLogin) {

            JPanel sidePanel = new JPanel();
            sidePanel.setBackground(Color.BLACK);
            sidePanel.setPreferredSize(new Dimension(width, height));
            sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.PAGE_AXIS));
            
            home = setSideBarLabel("Home");
            bookMgr = setSideBarLabel("Book Management");
            userMgr = setSideBarLabel("User Management");
            report = setSideBarLabel("Report");
            logout = setSideBarLabel("Logout");

            sidePanel.add(home);
            sidePanel.add(Box.createVerticalGlue());
            sidePanel.add(bookMgr);
            sidePanel.add(Box.createVerticalGlue());
            if(Listeners.adminLogin) {
                sidePanel.add(userMgr);
                sidePanel.add(Box.createVerticalGlue());
                sidePanel.add(report);
                sidePanel.add(Box.createVerticalGlue());
            };
            sidePanel.add(logout);

            
            
            return sidePanel;


        };

        protected static JPanel getSideBar (int width, int height, boolean adminLogin) {

            JPanel sidePanel = setSideBar(width, height, adminLogin);
            return sidePanel;

        };

        protected static JLabel setSideBarLabel (String txt) {

            JLabel sideBarLabel = new JLabel(txt);
            Dimension dimension = new Dimension(200, 100);
            sideBarLabel = Labels.getLabel(txt, 20);
            sideBarLabel.setOpaque(true);
            sideBarLabel.setBackground(Color.BLACK);
            sideBarLabel.setMinimumSize(dimension);
            sideBarLabel.setPreferredSize(dimension);
            sideBarLabel.setMaximumSize(dimension);
            sideBarLabel.setHorizontalAlignment(SwingConstants.CENTER);
            Listeners.setMouseListener(sideBarLabel);

            return sideBarLabel;

        }
        
    };

    protected static class Buttons extends JButton{

        private static JButton setButton (String txt) {

            Dimension dimension = new Dimension(300, 100);
            JButton button = new JButton(txt);
            button.setPreferredSize(new Dimension(dimension));
            button.setMaximumSize(new Dimension(dimension));
            button.setMinimumSize(new Dimension(dimension));
            button.setFont(new Font("ink free", Font.BOLD, 30));
            button.setForeground(Color.BLACK);
            button.setBackground(Color.LIGHT_GRAY);
            button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));
            button.setFocusPainted(false);
            button.setContentAreaFilled(false);
            button.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
            Listeners.setActionListener(button);
            Listeners.setMouseListener(button);

            return button;

        };

        protected static JButton getButton (String txt) {

            JButton button = setButton(txt);
            return button;

        };

    };
    
    protected static class TextFields extends JTextField{

        private static JTextField setTextField ()  {

            JTextField txtField = new JTextField();
            txtField.setPreferredSize(new Dimension(200, 50));
            txtField.setFont(new Font("ink free", Font.BOLD, 30));
            Listeners.setActionListener(txtField);
            

            return txtField;

        };

        protected static JTextField getTextField () {

            JTextField txtField = setTextField();
            return txtField;

        };

    };

    protected static class Labels extends JLabel{

        private static JLabel setLabel (String txt , int fontSize) {

                JLabel label = new JLabel();
                label.setText(txt);
                label.setForeground(Color.WHITE);
                label.setFont(new Font("ink free", Font.BOLD, fontSize));
                label.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
                label.setAlignmentY(java.awt.Component.CENTER_ALIGNMENT);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);
                Listeners.setMouseListener(label);
                Listeners.setMouseMotionListener(label);
    
                return label;
            };
            
            protected static JLabel getLabel (String txt, int fontSize) {
                JLabel label = setLabel(txt, fontSize);
            return label;
        };

    };
    
    public static class Listeners implements ActionListener,
                                                MouseListener,
                                                MouseMotionListener {

        private static int xPos, yPos, secondXPos, secondYPos;
        public static boolean addSuccessful = false, returnSuccessful = true, returnDateSuccessful = true, adminLogin = true, adminInformation = false;
        private static String search,id="",password,Name,Family;

        
        public static void setActionListener(JButton toListen) {
            
            toListen.addActionListener(new Listeners());
            
        };
        public static void setActionListener(JTextField toListen) {
            
            toListen.addActionListener(new Listeners());
            
        };
        
        public static void setMouseListener(Container toListen) {
            
            toListen.addMouseListener(new Listeners());
            
        };
        
        public static void setMouseMotionListener(Container toListen) {
            
            toListen.addMouseMotionListener(new Listeners());
            
        };
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == LoginPage.adminButton) {

                LoginPage.adminButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));
                LoginPage.userButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.BLACK));
                adminLogin = true;
                
            } else if (e.getSource() == LoginPage.userButton) {
                
                LoginPage.userButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));
                LoginPage.adminButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.BLACK));
                adminLogin = false;
                
            };
    
            if (e.getSource() == SharedComponents.TitleBar.closeButton) {

                System.exit(0);

            } else if (e.getSource() == SharedComponents.TitleBar.minimizeButton) {

                SharedComponents.Frame.frame.setState(JFrame.ICONIFIED);
            };   
            
            if (e.getSource() == LoginPage.loginButton) {
    
                LoginPage.username = LoginPage.usernameField.getText();
                LoginPage.password = LoginPage.passwordField.getPassword();


                if(adminLogin) {

                    System.out.print("Enter ID:");
                    id=LoginPage.username;
                    System.out.print("Enter Password:");
                    password=String.valueOf(LoginPage.password);
                    search="ID=" + id + "," + "Password=" + password;
                    System.out.println(search);
                    AdminManager admin=new AdminManager();
                    admin.search(search);
                    if(admin.indexA()==0)
                        System.out.println("The information entered is not valid !");
                    else if(admin.indexA()==1)
                    {
                        System.out.println("You are logged in...");
                        adminInformation=true;
                    }
                }
    
                

                if(adminInformation && adminLogin) {
    
                    LoginPage.loginInfo.setText("Admin Login Succesful");
                    SharedComponents.Frame.frame.dispose();
                    AdminUI.setAdminUI();
                    
                } else if (adminInformation && !adminLogin) {
                    
                    LoginPage.loginInfo.setText("User Login Succesful");
                    SharedComponents.Frame.frame.dispose();
                    UserUI.setUserUI();
                    
                } else if (!LoginPage.adminInformation){
                    
                    LoginPage.loginInfo.setText("Invalid Credentials");
                    
                }
                
            };

            if (e.getSource() == UserUI.BookManagement.addOrBorrowBookMenuButton) {

                UserUI.BookManagement.bookManagementLayoutManager.show(UserUI.BookManagement.bookManagementPanel, "AddOrBorrowBookPage");

            }

            if (e.getSource() == AdminUI.BookManagement.addOrBorrowBookMenuButton) {

                AdminUI.BookManagement.bookManagementLayoutManager.show(AdminUI.BookManagement.bookManagementPanel, "AddOrBorrowBookPage");

            }

            if (e.getSource() == UserUI.BookManagement.returnBookMenuButton) {

                UserUI.BookManagement.bookManagementLayoutManager.show(UserUI.BookManagement.bookManagementPanel, "ReturnBookPage");

            }

            if (e.getSource() == AdminUI.BookManagement.returnBookMenuButton) {

                AdminUI.BookManagement.bookManagementLayoutManager.show(AdminUI.BookManagement.bookManagementPanel, "ReturnBookPage");

            }

            if (e.getSource() == UserUI.BookManagement.returnDateMenuButton) {

                UserUI.BookManagement.bookManagementLayoutManager.show(UserUI.BookManagement.bookManagementPanel, "ReturnDatePage");

            }

            if (e.getSource() == AdminUI.BookManagement.returnDateMenuButton) {

                AdminUI.BookManagement.bookManagementLayoutManager.show(AdminUI.BookManagement.bookManagementPanel, "ReturnDatePage");

            }

            if (e.getSource() == AdminUI.UserManagement.addBookNUserMenuButton) {

                AdminUI.UserManagement.userManagementLayoutManager.show(AdminUI.UserManagement.userManagementPanel, "addBookNUserPage");

            }
            

            if (e.getSource() == AdminUI.UserManagement.deleteBookNUserMenuButton) {

                AdminUI.UserManagement.userManagementLayoutManager.show(AdminUI.UserManagement.userManagementPanel, "deleteBookNUserPage");

            }

            if (e.getSource() == AdminUI.UserManagement.borrowTimeExtendMenuButton) {

                AdminUI.UserManagement.userManagementLayoutManager.show(AdminUI.UserManagement.userManagementPanel, "borrowTimeExtendPage");

            }


            if(e.getSource() == UserUI.BookManagement.addOrBorrowBookButton && addSuccessful) {

                UserUI.BookManagement.addMessagePopup.setText("Added Successfully");

            } else if (e.getSource() == UserUI.BookManagement.addOrBorrowBookButton) {

                UserUI.BookManagement.addMessagePopup.setText("Add Failed");

            };

            
            if(e.getSource() == AdminUI.BookManagement.addOrBorrowBookButton && addSuccessful) {

                AdminUI.BookManagement.addMessagePopup.setText("Added Successfully");

            } else if (e.getSource() == AdminUI.BookManagement.addOrBorrowBookButton) {

                AdminUI.BookManagement.addMessagePopup.setText("Add Failed");

            };

            if(e.getSource() == UserUI.BookManagement.returnBookButton && returnSuccessful){
             
                UserUI.BookManagement.returnBookMessagePopup.setText("Book Returned Successfully");

            }else if (e.getSource() == UserUI.BookManagement.returnBookButton) {

                UserUI.BookManagement.returnBookMessagePopup.setText("Book Return Failed");

            };

            if(e.getSource() == AdminUI.BookManagement.returnBookButton && returnSuccessful){
             
                AdminUI.BookManagement.returnBookMessagePopup.setText("Book Deleted Successfully");

            }else if (e.getSource() == AdminUI.BookManagement.returnBookButton) {

                AdminUI.BookManagement.returnBookMessagePopup.setText("Book Delete Failed");

            };

            if(e.getSource() == UserUI.BookManagement.returnDateButton && returnDateSuccessful){
             
                UserUI.BookManagement.returnDateMessagePopup.setText("Date Returned Successfully");

            }else if (e.getSource() == UserUI.BookManagement.returnDateButton) {

                UserUI.BookManagement.returnDateMessagePopup.setText("Date Return Failed");

            };

            if(e.getSource() == UserUI.BookManagement.returnDateButton && returnDateSuccessful){
             
                UserUI.BookManagement.returnDateMessagePopup.setText("Borrow Time Extended Successfully");

            }else if (e.getSource() == UserUI.BookManagement.returnDateButton) {

                UserUI.BookManagement.returnDateMessagePopup.setText("Borrow Time Extend Failed");

            };

            if(e.getSource() == AdminUI.UserManagement.addBookNUserButton) {


                System.out.println("You selected Add Member");
				System.out.print("Enter Name:");
				Name = AdminUI.UserManagement.getUsername.getText();
				System.out.print("Enter Family:");
				// Family = input.next();
				System.out.print("Enter Password:");
				password = AdminUI.UserManagement.tempTextField.getText();
				Member member = new Member();
				member.setID();
				member.setName(Name);
				// member.setFamily(Family);
				member.setPassword(password);
				MemberManager mm = new MemberManager();
				mm.AddMember(member);
                AdminUI.UserManagement.addBookNUserMessagePopup.setText("Enter Password");
                
                if(addSuccessful) {

                    AdminUI.UserManagement.addBookNUserMessagePopup.setText("Added Successfully");
                    
                }

            } else if (e.getSource() == AdminUI.UserManagement.addBookNUserButton) {

                AdminUI.UserManagement.addBookNUserMessagePopup.setText("Add Failed");

            };

            if(e.getSource() == AdminUI.UserManagement.deleteBookNUserButton && addSuccessful) {

                AdminUI.UserManagement.addBookNUserMessagePopup.setText("Deleted Successfully");

            } else if (e.getSource() == AdminUI.UserManagement.deleteBookNUserButton) {

                AdminUI.UserManagement.addBookNUserMessagePopup.setText("Delete Failed");

            };

            if(e.getSource() == AdminUI.UserManagement.borrowTimeExtendButton && addSuccessful) {

                AdminUI.UserManagement.addBookNUserMessagePopup.setText("Extended Successfully");

            } else if (e.getSource() == AdminUI.UserManagement.borrowTimeExtendButton) {

                AdminUI.UserManagement.addBookNUserMessagePopup.setText("Extending Failed");

            };
 
        };
                                                
        @Override
        public void mousePressed(MouseEvent e) {
            
            if(e.getSource() == SharedComponents.TitleBar.titleBar || e.getSource() == SharedComponents.TitleBar.titleTxt) {
                
                xPos = e.getX();
                yPos = e.getY();
                
            };
            
            if(e.getSource() == LoginPage.loginButton) {
                
                LoginPage.loginButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.BLACK));
                
            };
            
            if(e.getSource() == UserUI.BookManagement.addOrBorrowBookMenuButton) {
                
                UserUI.BookManagement.addOrBorrowBookMenuButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.BLACK));
                
            }

            if(e.getSource() == UserUI.BookManagement.returnBookMenuButton) {

                UserUI.BookManagement.returnBookMenuButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.BLACK));

            }

            if(e.getSource() == UserUI.BookManagement.returnDateMenuButton) {

                UserUI.BookManagement.returnDateMenuButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.BLACK));

            }
            if(e.getSource() == UserUI.BookManagement.addOrBorrowBookButton) {

                UserUI.BookManagement.addOrBorrowBookButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.BLACK));

            };

            if(e.getSource() == UserUI.BookManagement.returnBookButton){
             
            UserUI.BookManagement.returnBookButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.BLACK));

            };

            if(e.getSource() == UserUI.BookManagement.returnDateMenuButton) {

                UserUI.BookManagement.returnDateMenuButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.BLACK));

            };
            if(e.getSource() == UserUI.BookManagement.returnDateButton) {

                UserUI.BookManagement.returnDateButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.BLACK));

            };

        }

        
        @Override
        public void mouseReleased(MouseEvent e) {
    
            if(e.getSource() == LoginPage.loginButton) {

                LoginPage.loginButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));

            }

            if(e.getSource() == UserUI.BookManagement.addOrBorrowBookMenuButton) {

                UserUI.BookManagement.addOrBorrowBookMenuButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));

            }

            if(e.getSource() == UserUI.BookManagement.returnBookMenuButton) {

                UserUI.BookManagement.returnBookMenuButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));

            }

            if(e.getSource() == UserUI.BookManagement.returnDateMenuButton) {

                UserUI.BookManagement.returnDateMenuButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));

            }

            if(e.getSource() == UserUI.BookManagement.addOrBorrowBookButton) {

                UserUI.BookManagement.addOrBorrowBookButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));

            };

            if(e.getSource() == UserUI.BookManagement.returnBookButton){
             
            UserUI.BookManagement.returnBookButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));

            };

            if(e.getSource() == UserUI.BookManagement.returnDateMenuButton) {

                UserUI.BookManagement.returnDateMenuButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));

            }

            if(e.getSource() == UserUI.BookManagement.returnDateButton) {

                UserUI.BookManagement.returnDateButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));

            };

            if(e.getSource() == AdminUI.UserManagement.addBookNUserMenuButton) {

                AdminUI.UserManagement.addBookNUserMenuButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));

            }

            if(e.getSource() == AdminUI.UserManagement.deleteBookNUserMenuButton) {

                AdminUI.UserManagement.deleteBookNUserMenuButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));

            }

            if(e.getSource() == AdminUI.UserManagement.borrowTimeExtendMenuButton) {

                AdminUI.UserManagement.borrowTimeExtendMenuButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));

            }
            if(e.getSource() == AdminUI.UserManagement.addBookNUserButton) {

                AdminUI.UserManagement.addBookNUserButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));

            }

            if(e.getSource() == AdminUI.UserManagement.deleteBookNUserButton) {

                AdminUI.UserManagement.deleteBookNUserButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));

            }

            if(e.getSource() == AdminUI.UserManagement.borrowTimeExtendButton) {

                AdminUI.UserManagement.borrowTimeExtendButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.BLACK));

            }
    
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            
            if(e.getSource() == SharedComponents.TitleBar.titleBar || e.getSource() == SharedComponents.TitleBar.titleTxt) {
                
                
                secondXPos = e.getXOnScreen() - xPos;
                secondYPos = e.getYOnScreen() - yPos;
    
                SharedComponents.Frame.frame.setLocation(secondXPos,secondYPos);
    
            };
            
        }
    
        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }
    
        @Override
        public void mouseClicked(MouseEvent e) {


            if(adminLogin) {

                if(e.getSource() == SideBar.home) {

                    SideBar.home.setBackground(Color.DARK_GRAY);
                    SideBar.bookMgr.setBackground(Color.BLACK);
                    SideBar.userMgr.setBackground(Color.BLACK);
                    SideBar.report.setBackground(Color.BLACK);
                    SideBar.logout.setBackground(Color.BLACK);
                    AdminUI.adminLayoutManager.show(AdminUI.adminWorkingPanel, "Home");
                    
                }
                
                if(e.getSource() == SideBar.bookMgr && adminLogin) {
                    
                    SideBar.home.setBackground(Color.BLACK);
                    SideBar.bookMgr.setBackground(Color.DARK_GRAY);
                    SideBar.userMgr.setBackground(Color.BLACK);
                    SideBar.report.setBackground(Color.BLACK);
                    SideBar.logout.setBackground(Color.BLACK);
                    AdminUI.adminLayoutManager.show(AdminUI.adminWorkingPanel, "BookManagement");
                    AdminUI.BookManagement.bookManagementLayoutManager.show(AdminUI.BookManagement.bookManagementPanel, "MainPanel");

                    
                } else if (e.getSource() == SideBar.bookMgr && !adminLogin) {

                    UserUI.BookManagement.bookManagementLayoutManager.show(UserUI.BookManagement.bookManagementPanel, "MainPanel");

                }



                if(e.getSource() == SideBar.userMgr) {

                    SideBar.home.setBackground(Color.BLACK);
                    SideBar.bookMgr.setBackground(Color.BLACK);
                    SideBar.userMgr.setBackground(Color.DARK_GRAY);
                    SideBar.report.setBackground(Color.BLACK);
                    SideBar.logout.setBackground(Color.BLACK);
                    AdminUI.adminLayoutManager.show(AdminUI.adminWorkingPanel, "UserManagement");
                    AdminUI.UserManagement.userManagementLayoutManager.show(AdminUI.UserManagement.userManagementPanel, "MainPanel");

                    
                }

                if(e.getSource() == SideBar.report) {

                    SideBar.home.setBackground(Color.BLACK);
                    SideBar.bookMgr.setBackground(Color.BLACK);
                    SideBar.userMgr.setBackground(Color.BLACK);
                    SideBar.report.setBackground(Color.DARK_GRAY);
                    SideBar.logout.setBackground(Color.BLACK);
                    
                }
                
                if(e.getSource() == SideBar.logout) {
                    
                    SharedComponents.Frame.frame.dispose();
                    new LoginPage();
                }
                    
            }else if (!adminLogin) {
                if(e.getSource() == SideBar.home) {

                    SideBar.home.setBackground(Color.DARK_GRAY);
                    SideBar.bookMgr.setBackground(Color.BLACK);
                    SideBar.userMgr.setBackground(Color.BLACK);
                    SideBar.report.setBackground(Color.BLACK);
                    SideBar.logout.setBackground(Color.BLACK);
                    UserUI.layoutManager.show(UserUI.workingPanel, "Home");
                    
                }
                
                if(e.getSource() == SideBar.bookMgr) {
                    
                    SideBar.home.setBackground(Color.BLACK);
                    SideBar.bookMgr.setBackground(Color.DARK_GRAY);
                    SideBar.userMgr.setBackground(Color.BLACK);
                    SideBar.report.setBackground(Color.BLACK);
                    SideBar.logout.setBackground(Color.BLACK);
                    UserUI.layoutManager.show(UserUI.workingPanel, "BookManagement");
                    UserUI.BookManagement.bookManagementLayoutManager.show(UserUI.BookManagement.bookManagementPanel, "MainPanel");
                    UserUI.BookManagement.addMessagePopup.setText("");
                    UserUI.BookManagement.returnBookMessagePopup.setText("");
                    UserUI.BookManagement.returnDateMessagePopup.setText("");
                    
                }
                
                if(e.getSource() == SideBar.logout) {
                    
                    SharedComponents.Frame.frame.dispose();
                    new LoginPage();
                    
                }
            }
            
        }
    
    
        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }
    
        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }


    };
};
