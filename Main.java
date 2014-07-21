import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.lang.*;

class Main
{

     public static void main(String[] args) throws Exception
     {          
          Frame1 window = new Frame1();
               
          window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          window.setSize(700,650/*1050,625*/);
          window.setVisible(true);
          
          window.update();
          


     }


     
}
