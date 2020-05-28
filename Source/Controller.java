package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Controller implements ActionListener{
    JFrame jFrame;
    JLabel encrypt_label;
    JLabel normal_label;
    JLabel decrypt_label;
    JButton Encrypt1;
    JButton Decrypt1;
    JButton Encrypt2;
    JButton Decrypt2;
    JTextArea encrypt;
    JTextArea decrypt;
    JTextArea Enter_Text;


    public void collections(){
        gui();
        actions();
    }

    public void gui(){
        jFrame = new JFrame();
        normal_label = new JLabel("Enter Your Text");
        encrypt_label = new JLabel("Encrypted Text");
        decrypt_label = new JLabel("Decrypted Text");
        Enter_Text = new JTextArea();
        encrypt = new JTextArea();
        decrypt = new JTextArea();
        Encrypt1 = new JButton("Caesar Encrypt");
        Decrypt1 = new JButton("Caesar Decrypt");
        Encrypt2 = new JButton("Key Encrypt");
        Decrypt2 = new JButton("Key Decrypt");
        jFrame.setSize(600,750);
        jFrame.setTitle("Crypto Tool");
        jFrame.getContentPane().setLayout(null);
        jFrame.getContentPane().setBackground(Color.WHITE);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        Enter_Text.setBounds(50,50,200,250);
        Enter_Text.setBackground( new Color(11,230,44));
        Enter_Text.setForeground(Color.WHITE);
        jFrame.add(Enter_Text);
        encrypt.setBounds(300,50, 200,250);
        encrypt.setBackground(new Color(11,230,44));
        encrypt.setForeground(Color.WHITE);
        jFrame.add(encrypt);
        decrypt.setBounds(300,350,200,250);
        decrypt.setBackground(new Color(11,230,44));
        decrypt.setForeground(Color.WHITE);
        jFrame.add(decrypt);
        Encrypt1.setBounds(60,350,  150,30);
        Encrypt1.setBackground(new Color(222,23,2));
        Encrypt1.setForeground(Color.WHITE);
        jFrame.add(Encrypt1);
        Decrypt1.setBounds(60,420,150,30);
        Decrypt1.setBackground(new Color(222,23,2));
        Decrypt1.setForeground(Color.WHITE);
        jFrame.add(Decrypt1);
        normal_label.setBounds(50,30,120,15);
        jFrame.add(normal_label);
        encrypt_label.setBounds(300,30,120,15);
        jFrame.add(encrypt_label);
        decrypt_label.setBounds(300,620,120,15);
        jFrame.add(decrypt_label);
        Encrypt2.setBounds(60,490,150,30);
        Encrypt2.setBackground(new Color(222,23,2));
        Encrypt2.setForeground(Color.WHITE);
        jFrame.add(Encrypt2);
        Decrypt2.setBounds(60,560,150,30);
        Decrypt2.setBackground(new Color(222,23,2));
        Decrypt2.setForeground(Color.WHITE);
        jFrame.add(Decrypt2);
    }
    public void actions() {
        Encrypt1.addActionListener(this);
        Decrypt1.addActionListener(this);
        Encrypt2.addActionListener(this);
        Decrypt2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
             String data = Enter_Text.getText();

        String str =" ";
        for (int i=0;i<data.length();i++){
             int temp = (int) (Math.random() * (127-0+1) +0);
             char c = (char) temp;
             str += String.valueOf(c);
        }
        if(e.getSource() == Encrypt1){
              String result = "";
              for(int i=0;i<data.length();i++){
                  Character c = data.charAt(i);
                  int j = c;
                  j++;
                  char output = (char) j;
                  result += String.valueOf(output);
              }
              encrypt.setText("");
              encrypt.setText(result);
        }

        String temp = Enter_Text.getText();
        if(e.getSource() == Encrypt2){


            String result2 = "";
            for (int i=0;i<temp.length();i++){
                int j = (temp.charAt(i)+str.charAt(i))/2;
                char c = (char) j;
                result2 += String.valueOf(c);
            }
            encrypt.setText("");
           encrypt.setText(result2);

        }
        if(e.getSource() == Decrypt1 || e.getSource()== Decrypt2){
            decrypt.setText(" ");
            decrypt.setText(data);
        }

    }
}
