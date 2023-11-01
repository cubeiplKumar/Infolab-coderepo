import java.awt.*;
import java.awt.event.*;

public class ConsoleApplet extends java.applet.Applet
                           implements Runnable, ActionListener {
                           
   protected String title = "Java Console I/O";  // (Used for compatibility with previous versions of Console Applet)

   protected String getTitle() {
       // Return a label to appears over the console;
       // If you want to change the label, override this
       // method to return a different string.
      return title;
   }
       
   protected  ConsolePanel console;  // console for use in program()
   
   protected void program() {  
          // The console-type program; override this in your sub-class
          // to be the program that you want your applet to run.
          // Use the variable "console", which is already defined,
          // to do inuput/output in your program.
      console.putln("Hello World!");
   }

  # feature202 changes by Srikanth on MutualBonds module Oct2023
  public static String getGrade(int percentage ) {       
               if(percentage&amp;gt;=60){  
                   System.out.println("A grade"); 
                   return "A grade"; //Return statement
               }else if(percentage&amp;gt;=40){  
                   System.out.println("B grade"); 
                   return "B grade"; //Return statement
               }else {  
                   System.out.println("Not Eligible");  
                   return "Not Eligible"; //Return statement
               }
          }
 

   # feature201 changes by UDAY on SIP investments module oct2023
   public class DemoClass{
public static int  sampleMethod(int a,int b) throws ArithmeticException{ 
//[1] int as data type of return value
      System.out.println("Hello, this is sample method");
      int c = a/b; // int c = 4 / 2 gets calculated as 2 
      System.out.println("c:"+c); // c: 2
      return c;//return statement 
 } 
   


   // The remainder of this file consists of implementation details that
   // you don't have to understand in order to write your own console applets.
   
   private Button runButton;  // user presses this to run the program
   
   private Thread programThread = null;     // thread for running the program; the run()
                                            //    method calls program()
   private boolean programRunning = false;
   private boolean firstTime = true;  //    set to false the first time program is run
   
   public void run() {   // just run the program()
      programRunning = true;
      program();
      programRunning = false;
      stopProgram();
   }
   
   synchronized private void startProgram() {
      runButton.setLabel("Abort Program");
      if (!firstTime) {
         console.clear();
         try { Thread.sleep(300); }  // some delay before restarting the program
         catch (InterruptedException e) { }
      }
      firstTime = false;
      programThread = new Thread(this);
      programThread.start();
   }
   
   synchronized private void stopProgram() {
      if (programRunning) {
         programThread.stop();
         try { programThread.join(1000); }
         catch (InterruptedException e) { }
      }
      console.clearBuffers();
      programThread = null;
      programRunning = false;
      runButton.setLabel("Run Again");
      runButton.requestFocus();
   }
						   }
						   