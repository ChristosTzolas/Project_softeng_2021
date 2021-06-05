import javafx.event.ActionEvent;

public class Controller {
    
    public void emergency_button(ActionEvent event){
        char automated_message;
        int i=0;
        get_saved_numbers();
        if (numbers =! null){
            gps();
            get_message();
            message = automated_message;
            while (response = false){
                send_to_first_number();
                // need to fix the timer here
                // something with response
            }
        } 
        else {
                System.out.println("There are no saved numbers in this device");
        }
        send_sos_to_112();
        get_active_volunteers();
        if (volunteers =! null){
            System.out.println("Available volunteers in the area: %something", volunteers);
        }
                
    }
    public void help_button(ActionEvent event){
        
    }
    
    public void show_calendar(ActionEvent event){
      char event_holder;
      int k;
      get_user_events();
      events = event_holder;
      k = that_number(events); 
      int i = 0;
      while (i<k){
         countdown();
         System.out.println("I want to die");
         k++;
      }
     }
    public void countdown(ActionEvent event){
      
    }
    
}

public void setUserevents
return events;
set_user_events(){
  Events
}
get_user_events()
public void setMyLife()
