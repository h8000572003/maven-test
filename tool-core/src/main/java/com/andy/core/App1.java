package com.andy.core;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.andy.java.CommonUtil;

/**
 * Hello world!
 *
 */
@Component
public class App1 extends JFrame {

	private static final long serialVersionUID = 1L;
	@Autowired
	private transient CommonUtil commonUtil;
	private JTextField textField;
	private JButton btnNewButton;
	private JTextField textField_1;

	public App1() {
		this.setBounds(100, 100, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textField = new JTextField();
		getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(10);

		btnNewButton = new JButton("New button");
		getContentPane().add(btnNewButton, BorderLayout.CENTER);

		textField_1 = new JTextField();
		getContentPane().add(textField_1, BorderLayout.WEST);
		textField_1.setColumns(10);

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				textField.setText(commonUtil.say(textField.getText()));
			}
		});

	}

	/**
	 * 
	 */

	public static void main(String[] args) {
		Spring.run();
	}

	public static class Spring {
		public static void run() {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("tool-applicationContext.xml");
			App1 app = (App1) ctx.getBean(App1.class);
			app.show();

		}
	}

}
