package login;

import javax.swing.*;
import java.awt.*;

public class Frome1 {
    public void StudentMainInterface(){

        //创建一个窗口,并设置窗口名称为”登录”
        JFrame jFrame = new JFrame("学生管理系统");

        //设置窗口大小
        jFrame.setSize(1000,700);

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





