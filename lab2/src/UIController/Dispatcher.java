/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIController;

/**
 *
 * @author Admin
 */
public class Dispatcher {
   private DealerView dealerview;
   private DeliveryView deliveryview;
   private BossView bossview;

    public Dispatcher() {
        dealerview = new DealerView();
        deliveryview = new DeliveryView();
        bossview = new BossView();
    }
   
   

    
    public void call(String request){
        if(request.equalsIgnoreCase("dealerview")){
            dealerview.display();
        }else if(request.equalsIgnoreCase("boss")){
            bossview.display();
        }else 
            deliveryview.display();
    }
   
   
}
