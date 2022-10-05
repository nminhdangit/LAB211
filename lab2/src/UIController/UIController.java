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
public class UIController {
   private Dispatcher dispatcher;

   public UIController(){
      dispatcher = new Dispatcher();
   }
   
   public void dispatchRequest(String request){      
      dispatcher.call(request);
   }
}
