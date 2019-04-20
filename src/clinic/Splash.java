/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic;
public class Splash {
    public static void main(String[]arg) throws InterruptedException{
        SplashScreen splash= new SplashScreen();
        for(int i=0;i<=100;i++){
            Thread.sleep(40);
            splash.setVisible(true);
            splash.loading.setText("Loading..."+i+"%");
            splash.load.setValue(i);
            
            if(i==100){
                splash.dispose();
                Login mf=new Login();
                   mf.setVisible(true);
                   mf.pack();
                   
                   
                   
                   
                  // mf.setExtendedState(JFrame.MAXIMIZED_BOTH);
                  // mf.setLocationRelativeTo(null);
                  // this.dispose();
            }
                
        }
    }
}
