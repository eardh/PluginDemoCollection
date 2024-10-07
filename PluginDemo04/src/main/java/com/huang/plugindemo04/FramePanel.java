package com.huang.plugindemo04;

import javax.swing.*;
import java.awt.*;

public class FramePanel extends JFrame {

	public FramePanel() throws HeadlessException {
		this.setTitle("Hello World");//设置标题
		this.setSize(500, 500);//设置宽高
		this.setLocationRelativeTo(null);//水平垂直居中       设置相对位置
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口时退出程序       设置默认关闭操作
		this.setResizable(false);//设置禁止窗口拖拽     设置可改变的窗口size
		this.setVisible(true);//让窗口显示     设置可视化的  
	}
}