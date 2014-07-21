import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.lang.*;

public class Frame1 extends JFrame
{
          
          double net;
          double profit;
          double usd = 0;
          double btcPrice;
          
          double btc_holding=0;
          double ltc_holding=0;//114.17100006
          double nmc_holding=0;//30.57386444
          double xpm_holding=0;//153.58847244
          double ppc_holding=0;
          double nvc_holding=0;
          double ftc_holding=0;
          
          
          boolean btcb = true;
          boolean ltcb;
          boolean ltcb_b;
          boolean nmcb;
          boolean nmcb_b;
          boolean xpmb;
          boolean ppcb;
          boolean nvcb;
          boolean ftcb;
          
          Ticker btc = new Ticker("https://btc-e.com/api/2/btc_usd/ticker","BTC", btc_holding);
          Ticker ltc = new Ticker("https://btc-e.com/api/2/ltc_usd/ticker","LTC", ltc_holding);
          Ticker nmc = new Ticker("https://btc-e.com/api/2/nmc_usd/ticker","NMC", nmc_holding);
          BtcBasedTicker xpm = new BtcBasedTicker("https://btc-e.com/api/2/xpm_btc/ticker","XPM",xpm_holding, btcPrice);
          BtcBasedTicker ltc_b = new BtcBasedTicker("https://btc-e.com/api/2/ltc_btc/ticker","LTC",ltc_holding, btcPrice);
          BtcBasedTicker nmc_b = new BtcBasedTicker("https://btc-e.com/api/2/nmc_btc/ticker","NMC",nmc_holding, btcPrice);
          BtcBasedTicker ppc = new BtcBasedTicker("https://btc-e.com/api/2/ppc_btc/ticker","PPC",ppc_holding, btcPrice);
          BtcBasedTicker nvc = new BtcBasedTicker("https://btc-e.com/api/2/nvc_btc/ticker","NVC",nvc_holding, btcPrice);
          BtcBasedTicker ftc = new BtcBasedTicker("https://btc-e.com/api/2/ftc_btc/ticker","FTC",ftc_holding, btcPrice);


     JPanel pane = new JPanel();
     JPanel btc_pane = new JPanel();
     JPanel ltc_pane = new JPanel();
     JPanel ltc_b_pane = new JPanel();
     JPanel nmc_pane = new JPanel();
     JPanel nmc_b_pane = new JPanel();
     JPanel xpm_pane = new JPanel();
     JPanel ppc_pane = new JPanel();
     JPanel nvc_pane = new JPanel();
     JPanel ftc_pane = new JPanel();
     
     
     
     
     JScrollPane jsp;

     
     public JLabel BTC = new JLabel();
     public JLabel LTC = new JLabel();
     public JLabel LTC_b = new JLabel();     
     public JLabel NMC = new JLabel();
     public JLabel NMC_b = new JLabel();
     public JLabel XPM = new JLabel();
     public JLabel PPC = new JLabel();
     public JLabel NVC = new JLabel();
     public JLabel FTC = new JLabel();
     
     
     public JTextField BTC_hold = new JTextField(btc_holding+"",5);
     public JTextField LTC_hold = new JTextField(ltc_holding+"",5);
     public JTextField NMC_hold = new JTextField(nmc_holding+"",5);
     public JTextField XPM_hold = new JTextField(xpm_holding+"",5);
     public JTextField PPC_hold = new JTextField(ppc_holding+"",5);
     public JTextField NVC_hold = new JTextField(nvc_holding+"",5);
     public JTextField FTC_hold = new JTextField(ftc_holding+"",5);

     
     
     public JLabel BTC_holdLab = new JLabel("BTC Holdings");
     public JLabel LTC_holdLab = new JLabel("LTC Holdings");
     public JLabel NMC_holdLab = new JLabel("NMC Holdings");
     public JLabel XPM_holdLab = new JLabel("XPM Holdings");
     public JLabel PPC_holdLab = new JLabel("PPC Holdings");
     public JLabel NVC_holdLab = new JLabel("NVC Holdings");
     public JLabel FTC_holdLab = new JLabel("FTC Holdings");
     

     
     JMenuBar menubar = new JMenuBar();
     
     JToggleButton btc_button = new JToggleButton("BTC",btcb);
     JToggleButton ltc_button = new JToggleButton("LTC",ltcb);
     JToggleButton ltc_b_button = new JToggleButton("LTC / BTC",ltcb_b);
     JToggleButton nmc_button = new JToggleButton("NMC",nmcb);
     JToggleButton nmc_b_button = new JToggleButton("NMC / BTC",nmcb_b);
     JToggleButton xpm_button = new JToggleButton("XPM",xpmb);
     JToggleButton ppc_button = new JToggleButton("PPC",ppcb);
     JToggleButton nvc_button = new JToggleButton("NVC",nvcb);
     JToggleButton ftc_button = new JToggleButton("FTC",ftcb);
     

     
     
     Frame1() throws Exception
     {
          super("BTC Ticker");
          readState();
          
          
          pane.add(menubar);
          setJMenuBar(menubar);
          
          
          menubar.add(btc_button);
          menubar.add(ltc_button);
          menubar.add(ltc_b_button);
          menubar.add(nmc_button);
          menubar.add(nmc_b_button);
          menubar.add(xpm_button);
          menubar.add(ppc_button);
          menubar.add(nvc_button);
          menubar.add(ftc_button);
          
          
          btc_button.setSelected(btcb);
          ltc_button.setSelected(ltcb);
          ltc_b_button.setSelected(ltcb_b);          
          nmc_button.setSelected(nmcb);
          nmc_b_button.setSelected(nmcb_b);
          xpm_button.setSelected(xpmb);
          ppc_button.setSelected(ppcb);
          nvc_button.setSelected(nvcb);
          ftc_button.setSelected(ftcb);
          
          
          BTC_hold.setText(btc_holding+"");
          LTC_hold.setText(ltc_holding+"");
          NMC_hold.setText(nmc_holding+"");
          XPM_hold.setText(xpm_holding+"");          
          PPC_hold.setText(ppc_holding+"");          
          NVC_hold.setText(nvc_holding+"");          
          FTC_hold.setText(ftc_holding+"");          
                    
                    

          
          jsp = new JScrollPane(pane,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

          
          
          //Container container = this.getContentPane();
          //container.add(jsp);
          btc_pane.setLayout(new WrapLayout());
          ltc_pane.setLayout(new WrapLayout());
          ltc_b_pane.setLayout(new WrapLayout());
          nmc_pane.setLayout(new WrapLayout());
          nmc_b_pane.setLayout(new WrapLayout());
          xpm_pane.setLayout(new WrapLayout());
          ppc_pane.setLayout(new WrapLayout());
          nvc_pane.setLayout(new WrapLayout());
          ftc_pane.setLayout(new WrapLayout());
          
          pane.add(btc_pane);
          pane.add(ltc_pane);
          pane.add(ltc_b_pane);
          pane.add(nmc_pane);
          pane.add(nmc_b_pane);
          pane.add(xpm_pane);
          pane.add(ppc_pane);
          pane.add(nvc_pane);
          pane.add(ftc_pane);
          
          this.add(jsp);
    pane.setLayout(new GridLayout());     
    menubar.setLayout(new WrapLayout());
          
          //Adding BTC
          
                    btc_pane.add(BTC_holdLab);          
                    btc_pane.add(BTC_hold);
                    BTC_hold.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                         btc_holding=Double.parseDouble(BTC_hold.getText());
                    }
               });
                    btc_pane.add(BTC);
                    if(btc_button.isSelected())
                    {
                         BTC.setVisible(true);
                         BTC_holdLab.setVisible(true);
                         BTC_hold.setVisible(true);
                    }
                    else
                    {
                         BTC.setVisible(false);
                         BTC_holdLab.setVisible(false);
                         BTC_hold.setVisible(false);
                    }
                         
          //Showing  btc
          btc_button.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                    if(btc_button.isSelected())
                    {
                         btcb = true;
                         BTC.setVisible(true);
                         BTC_holdLab.setVisible(true);
                         BTC_hold.setVisible(true);
                         
                    }
                    else
                    {
                         btcb=false;
                         BTC.setVisible(false);
                         BTC_holdLab.setVisible(false);
                         BTC_hold.setVisible(false);
                    }
               }
          });
          
          //Adding LTC
          
                    ltc_pane.add(LTC_holdLab);          
                    ltc_pane.add(LTC_hold);
                    LTC_hold.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                         ltc_holding=Double.parseDouble(LTC_hold.getText());
                    }
               });
                    ltc_pane.add(LTC);
                    if(ltc_button.isSelected())
                    {
                         LTC.setVisible(true);
                         LTC_holdLab.setVisible(true);
                         LTC_hold.setVisible(true);
                    }
                    else
                    {
                         LTC.setVisible(false);
                         LTC_holdLab.setVisible(false);
                         LTC_hold.setVisible(false);
                    }
                         
          //Showing  LTC
          ltc_button.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                    if(ltc_button.isSelected())
                    {
                         ltcb = true;
                         LTC.setVisible(true);
                         LTC_holdLab.setVisible(true);
                         LTC_hold.setVisible(true);
                         
                    }
                    else
                    {
                         ltcb=false;
                         LTC.setVisible(false);
                         LTC_holdLab.setVisible(false);
                         LTC_hold.setVisible(false);
                    }
               }
          });
          
          //Adding LTC_BTC
                    ltc_b_pane.add(LTC_b);
                    if(ltc_b_button.isSelected())
                    {
                         LTC_b.setVisible(true);
                    }
                    else
                    {
                         LTC_b.setVisible(false);
                    }
                         
          //Showing  LTC_BTC
          ltc_b_button.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                    if(ltc_b_button.isSelected())
                    {
                         ltcb_b = true;
                         LTC_b.setVisible(true);                         
                    }
                    else
                    {
                         ltcb_b=false;
                         LTC_b.setVisible(false);
                    }
               }
          });          
          
          //Adding NMC
          
                    nmc_pane.add(NMC_holdLab);          
                    nmc_pane.add(NMC_hold);
                    NMC_hold.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                         nmc_holding=Double.parseDouble(NMC_hold.getText());
                    }
               });
                    nmc_pane.add(NMC);
                    if(nmc_button.isSelected())
                    {
                         NMC.setVisible(true);
                         NMC_holdLab.setVisible(true);
                         NMC_hold.setVisible(true);
                    }
                    else
                    {
                         NMC.setVisible(false);
                         NMC_holdLab.setVisible(false);
                         NMC_hold.setVisible(false);
                    }
                         
          //Showing  NMC
          nmc_button.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                    if(nmc_button.isSelected())
                    {
                         nmcb = true;
                         NMC.setVisible(true);
                         NMC_holdLab.setVisible(true);
                         NMC_hold.setVisible(true);
                         
                    }
                    else
                    {
                         nmcb=false;
                         NMC.setVisible(false);
                         NMC_holdLab.setVisible(false);
                         NMC_hold.setVisible(false);
                    }
               }
          });
          
          //Adding NMC_BTC
                    nmc_b_pane.add(NMC_b);
                    if(nmc_b_button.isSelected())
                    {
                         NMC_b.setVisible(true);
                    }
                    else
                    {
                         NMC_b.setVisible(false);
                    }
                         
          //Showing  NMC_BTC
          nmc_b_button.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                    if(nmc_b_button.isSelected())
                    {
                         nmcb_b = true;
                         NMC_b.setVisible(true);                         
                    }
                    else
                    {
                         nmcb_b=false;
                         NMC_b.setVisible(false);
                    }
               }
          });                
          
          
          //Adding XPM
          
                    xpm_pane.add(XPM_holdLab);          
                    xpm_pane.add(XPM_hold);
                    XPM_hold.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                         xpm_holding=Double.parseDouble(XPM_hold.getText());
                    }
               });
                    xpm_pane.add(XPM);
                    if(xpm_button.isSelected())
                    {
                         XPM.setVisible(true);
                         XPM_holdLab.setVisible(true);
                         XPM_hold.setVisible(true);
                    }
                    else
                    {
                         XPM.setVisible(false);
                         XPM_holdLab.setVisible(false);
                         XPM_hold.setVisible(false);
                    }
                         
          //Showing  XPM
          xpm_button.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                    if(xpm_button.isSelected())
                    {
                         xpmb = true;
                         XPM.setVisible(true);
                         XPM_holdLab.setVisible(true);
                         XPM_hold.setVisible(true);
                         
                    }
                    else
                    {
                         xpmb=false;
                         XPM.setVisible(false);
                         XPM_holdLab.setVisible(false);
                         XPM_hold.setVisible(false);
                    }
               }
          });


          
          //Adding PPC
          
                    ppc_pane.add(PPC_holdLab);          
                    ppc_pane.add(PPC_hold);
                    PPC_hold.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                         ppc_holding=Double.parseDouble(PPC_hold.getText());
                    }
               });
                    ppc_pane.add(PPC);
                    if(ppc_button.isSelected())
                    {
                         PPC.setVisible(true);
                         PPC_holdLab.setVisible(true);
                         PPC_hold.setVisible(true);
                    }
                    else
                    {
                         PPC.setVisible(false);
                         PPC_holdLab.setVisible(false);
                         PPC_hold.setVisible(false);
                    }
                         
          //Showing  PPC
          ppc_button.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                    if(ppc_button.isSelected())
                    {
                         ppcb = true;
                         PPC.setVisible(true);
                         PPC_holdLab.setVisible(true);
                         PPC_hold.setVisible(true);
                         
                    }
                    else
                    {
                         ppcb=false;
                         PPC.setVisible(false);
                         PPC_holdLab.setVisible(false);
                         PPC_hold.setVisible(false);
                    }
               }
          });          
          
          
          //Adding NVC
          
                    nvc_pane.add(NVC_holdLab);          
                    nvc_pane.add(NVC_hold);
                    NVC_hold.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                         nvc_holding=Double.parseDouble(NVC_hold.getText());
                    }
               });
                    nvc_pane.add(NVC);
                    if(nvc_button.isSelected())
                    {
                         NVC.setVisible(true);
                         NVC_holdLab.setVisible(true);
                         NVC_hold.setVisible(true);
                    }
                    else
                    {
                         NVC.setVisible(false);
                         NVC_holdLab.setVisible(false);
                         NVC_hold.setVisible(false);
                    }
                         
          //Showing  NVC
          nvc_button.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                    if(nvc_button.isSelected())
                    {
                         nvcb = true;
                         NVC.setVisible(true);
                         NVC_holdLab.setVisible(true);
                         NVC_hold.setVisible(true);
                         
                    }
                    else
                    {
                         nvcb=false;
                         NVC.setVisible(false);
                         NVC_holdLab.setVisible(false);
                         NVC_hold.setVisible(false);
                    }
               }
          });            
          
          
          //Adding FTC
          
                    ftc_pane.add(FTC_holdLab);          
                    ftc_pane.add(FTC_hold);
                    FTC_hold.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e)
                    {
                         ftc_holding=Double.parseDouble(FTC_hold.getText());
                    }
               });
                    ftc_pane.add(FTC);
                    if(ftc_button.isSelected())
                    {
                         FTC.setVisible(true);
                         FTC_holdLab.setVisible(true);
                         FTC_hold.setVisible(true);
                    }
                    else
                    {
                         FTC.setVisible(false);
                         FTC_holdLab.setVisible(false);
                         FTC_hold.setVisible(false);
                    }
                         
          //Showing FTC
          ftc_button.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){
                    if(ftc_button.isSelected())
                    {
                         ftcb = true;
                         FTC.setVisible(true);
                         FTC_holdLab.setVisible(true);
                         FTC_hold.setVisible(true);
                         
                    }
                    else
                    {
                         ftcb=false;
                         FTC.setVisible(false);
                         FTC_holdLab.setVisible(false);
                         FTC_hold.setVisible(false);
                    }
               }
          });            
          
          
          
          
          
          //Save on Close
          this.addWindowListener(new WindowAdapter(){
               public void windowClosing(WindowEvent e)
               {
                    saveState();
               }
          });          


                         
     }
     


     public void update() throws Exception
     {           
          for(int i = 0; i < 50; )
          {
               Thread.sleep(100);
               Ticker btc = new Ticker("https://btc-e.com/api/2/btc_usd/ticker","BTC", btc_holding);
               btcPrice = btc.getPrice();          
               Ticker ltc = new Ticker("https://btc-e.com/api/2/ltc_usd/ticker","LTC", ltc_holding);
               Ticker nmc = new Ticker("https://btc-e.com/api/2/nmc_usd/ticker","NMC", nmc_holding);
               BtcBasedTicker xpm = new BtcBasedTicker("https://btc-e.com/api/2/xpm_btc/ticker","XPM",xpm_holding, btcPrice);
               BtcBasedTicker ltc_b = new BtcBasedTicker("https://btc-e.com/api/2/ltc_btc/ticker","LTC",ltc_holding, btcPrice);
               BtcBasedTicker nmc_b = new BtcBasedTicker("https://btc-e.com/api/2/nmc_btc/ticker","NMC",nmc_holding, btcPrice);
               BtcBasedTicker ppc = new BtcBasedTicker("https://btc-e.com/api/2/ppc_btc/ticker","PPC",ppc_holding, btcPrice);
               BtcBasedTicker nvc = new BtcBasedTicker("https://btc-e.com/api/2/nvc_btc/ticker","NVC",nvc_holding, btcPrice);
               BtcBasedTicker ftc = new BtcBasedTicker("https://btc-e.com/api/2/ftc_btc/ticker","FTC",ftc_holding, btcPrice);
          
               BTC.setText(""+btc);
               LTC.setText(""+ltc);
               LTC_b.setText(""+ltc_b);
               NMC.setText(""+nmc);
               XPM.setText(""+xpm);
               NMC_b.setText(""+nmc_b);
               PPC.setText(""+ppc);
               NVC.setText(""+nvc);
               FTC.setText(""+ftc);
               
          }
     }     
     
     public void saveState()
     {
          try{              
          FileOutputStream saveFile=new FileOutputStream("Ticker.sav", false);
          ObjectOutputStream save = new ObjectOutputStream(saveFile);
          
          save.writeObject(btc_holding);
          save.writeObject(ltc_holding);
          save.writeObject(nmc_holding);
          save.writeObject(xpm_holding);
          save.writeObject(ppc_holding);
          save.writeObject(nvc_holding);
          save.writeObject(ftc_holding);
          
          save.writeObject(btcb);
          save.writeObject(ltcb);
          save.writeObject(ltcb_b);
          save.writeObject(nmcb);
          save.writeObject(nmcb_b);          
          save.writeObject(xpmb);
          save.writeObject(ppcb);
          save.writeObject(nvcb);
          save.writeObject(ftcb);
          
          
          save.close();
          }catch(Exception e){
          e.printStackTrace();}
               
     }
     
     public void readState()
     {
          try{
          FileInputStream saveFile = new FileInputStream("Ticker.sav");
          ObjectInputStream save = new ObjectInputStream(saveFile);
          btc_holding = (Double) save.readObject();
          ltc_holding = (Double) save.readObject();
          nmc_holding = (Double) save.readObject();
          xpm_holding = (Double) save.readObject();     
          ppc_holding = (Double) save.readObject();     
          nvc_holding = (Double) save.readObject();     
          ftc_holding = (Double) save.readObject();     
          
          btcb = (boolean) save.readObject();
          ltcb = (boolean) save.readObject();
          ltcb_b = (boolean) save.readObject();
          nmcb = (boolean) save.readObject();
          nmcb_b = (boolean) save.readObject();
          xpmb = (boolean) save.readObject();
          ppcb = (boolean) save.readObject();
          nvcb = (boolean) save.readObject();
          ftcb = (boolean) save.readObject();
          
          
          save.close();
          }catch(Exception e){
          e.printStackTrace();}
     }
     
}