package login;
import student.StudentManagementSystem;

import javax.swing.*;
import java.awt.*;
//登陆界面设计

public class Login{

    public static void main(String[] args) {

        //创建一个主要框架
        JFrame jFrame = new JFrame("学生登录");
        //设置窗口大小
        jFrame.setSize(800,500);

        //先将布局管理器置为null
        //防止对象相互覆盖，遮挡，影响使用
        jFrame.setLayout(null);

        //添加标签【学生管理系统】
        JLabel LabelStudentManage = new JLabel("学生管理系统");//创建一个标签,并命名为“学生管理系统“
        LabelStudentManage.setForeground(new Color(0x000000));//设置字体颜色
        LabelStudentManage.setFont(new Font("粗体", Font.BOLD,50));//设置字体
        LabelStudentManage.setBounds(260,50,800,100);//设置标签的绝对位置
        jFrame.add(LabelStudentManage);//向框架中添加组件【标签(学生管理系统)】

        //添加标签【用户名】
        JLabel labelUser = new JLabel("用户名:");
        labelUser.setForeground(new Color(0xFF000000));
        labelUser.setFont(new Font("黑体", Font.PLAIN,30));
        labelUser.setBounds(200,140,200,100);
        jFrame.add(labelUser);

        //添加输入框【用户名输入框】
        JTextField user = new JTextField(20);
        user.setFont(new Font("黑体", Font.PLAIN,18));
        user.setSelectedTextColor(new Color(0xFF000000));
        user.setBounds(330,170,280,40);
        jFrame.add(user);

        //添加标签【密码】
        JLabel textPassword = new JLabel("密码  :");
        textPassword.setForeground(new Color(0xFF000000));
        textPassword.setFont(new Font("黑体", Font.PLAIN,30));
        textPassword.setBounds(200,200,200,100);
        jFrame.add(textPassword);

        //添加密码输入框【密码】
        JPasswordField password = new JPasswordField(20);
        password.setBounds(330,230,280,40);
        jFrame.add(password);

        //添加按钮【登录】
        JButton jButton = new JButton("登录");
        jButton.setForeground(new Color(0x023BF6));
        jButton.setBackground(new Color(0x38FF00));
        jButton.setFont(new Font("黑体", Font.PLAIN,20));
        jButton.setBorderPainted(false);
        jButton.setBounds(270,330,100,50);
        jFrame.add(jButton);

        //添加按钮【注册】
        JButton register = new JButton("注册");
        register.setForeground(new Color(0x0029FF));
        register.setBackground(new Color(0xECA871));
        register.setFont(new Font("黑体", Font.PLAIN,20));
        register.setBorderPainted(false);
        register.setBounds(475,330,100,50);
        jFrame.add(register);

        //对按钮事件进行处理
        jButton.addActionListener((e -> {

            /*
                账号：admin
                密码：123456
             */

            //设定条件
            String pwd = new String(password.getPassword());
            if(user.getText().equals("admin")){
                if(pwd.equals("123456")){
                    //密码账号正确,进入学生管理系统
                    //进入学生管理系统
                    jFrame.setVisible(false);//将登录界面设定为不可见
                    new Frome1().StudentMainInterface();
                }else{
                    //密码不正确
                    JOptionPane.showMessageDialog(jFrame,"密码错误","提示",JOptionPane.INFORMATION_MESSAGE);
                    //将密码框置空
                    password.setText("");
                }
            }else{
                //用户名错误
                JOptionPane.showMessageDialog(jFrame,"用户名不存在","提示",JOptionPane.INFORMATION_MESSAGE);
                //将用户名和密码置空
                user.setText("");
                password.setText("");
            }
        }));

        //设置相对位置：屏幕中间
        jFrame.setLocationRelativeTo(null);

        //确保使用窗口关闭按钮，能够正常退出，结束进程！
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //禁止对窗口大小进行缩放处理
        jFrame.setResizable(false);

        //设置可见
        jFrame.setVisible(true);
    }

}