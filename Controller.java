import javafx.event.ActionEvent;

public class Controller {
    char users_choise;
    boolean values; //Menei proxeiro ws int
    enum category {Doctor_Event, Drug_Event, Event}
    Scanner myObj = new Scanner(System.in);
    
    public static void check_values(){}
    
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
            notify_help();
        }
        else{
            System.out.println("There are no available volunteers");
        }
       return 0;         
    }
    public void help_button(ActionEvent event){
        get_active_volunteers();
        if (volunteers =! null){
            System.out.println("Active volunteers");
            for(Volunteer volunteer : volunteers){
                System.out.println(volunteer.get_active_volunteers());
            }
        }
        else {
            System.out.println("There are no active volunteers");
            return home;
        }
        get_amea_location();
        create_request_help();
        send_help_mmessage();
        if (event = Accept){ //event or action, θα το δούμε.
            System.out.println("Request Accepted");
            return main_screen;
        }
        else {
            System.out.println("Request Denied");
            
            return main_screen;
        }    
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
     return 0;   
     }
    
    public void add_new_event(ActionEvent event){

        Category allCategories [] Category.values();

        for(Category c : allCategories){
            System.out.println(c);
        }
        System.out.println("Select category:\n Doctor_Event\n Drug_Event\n Event");
        String answer = myObj.nextLine();
        while(check_values() == false) {
            if (users_choise == Doctor_event) {
                return Doc_form;

            } else if (users_choise == Drug_event) {
                return Drug_form;

            } else if (users_choise == Event) {
                return Gen_form;
            }
        }
        if(users_choise == Doctor_event) {
            enum doctor_contact {Select_doctor, Insert_new_Doctor}

            if (users_choise == Select_doctor) {
                get_contacts();
            }
            while (check_values() == false) {
                else if (users_choise == Insert_new_doctor) {
                     create_contact();
                }
            }
        }

        System.out.println("Confirm?");
        boolean answer = myObj.nextBoolean();
        if(answer == true){
            create_event();
            call_show_callendar();
        }
        else if(answer == false){
            //go to diary
        }
    }
    
        public void modify_delete_event(ActionEvent event) {
        get_user_events(){
        }

        for (int i = 0; i < Event.size(); i++) {
            System.out.println(Event.get(i).get_all_Events());
        }
        //selects an event
        enum form_choise {Modify, Delete}
        System.out.println("Modify or Delete?");
        String form_choise = myObj.nextLine();

        while(check_values() == false){
            if(form_choise == Modify){
                return event_form;
                //modifies
            }
            else if(form_choise == Delete){
                //delets event
            }
            System.out.println("Confirm?");
            boolean answer = myObj.nextBoolean();
            if(answer == true){
                update_event();
            }
            else if(answer == false){
                //go to list
            }
        }
        if(check_if_its_doctors_event() == true){
            notify_doctor();
            call_show_callendar();
        }
        else {call_show_callendar();}
    }
    
    public void countdown(ActionEvent event){

    }
    
    public void requesting_itinerary(ActionEvent event){
        get_all_itineraries();
        if (itineraries =! null){
            for(int i = 0; i < itineraries.size(); i++){
                System.out.println(itineraries.get(i).get_all_itineraries());
            }
        }
        else {
            System.out.println("There aren't any itineraries");
            return home;
        }
        //picks itinerary
        get_volunteer_info();
        if (event = Auto){
            create_request_itinerary();
            notify_itinerary();
            return home;
        }
        //make a call
        else{
            redirect_to();
        }
    }
    public void create_itinerary(AcitveEvent event){
        
    }
    
    public void edit_itinerary(ActiveEvent event){
        //show options?
        check_user_itineraries();
        if (itineraries = null){
            System.out.println("There aren't any itineraries"); //either way with an error
            //confirms
            return home;
        }
        else {
            //show user's itineraries (Sorry I am really smoothed brain -.-)
        }
        //chooses itinerary
        get_itinerary_info();
        while (event = Confirm){
            if (event = Edit){
                //edits
                while (/*values is invalid*/){
                        check_validility_values();
                    } 
            }
            else if (event = Delete){
                //deletes 
            }
        }
        System.out.println("Are you sure that you want to complete this action?");
        if (event = Confirm){
            //confirms
            update_itinerary();
        }
        else if (event = Deny){
            //denies
            return itinerary_form;
        }
        notify_passengers();
        return home;
    }
    
    public void notify_itinerary(ActionEvent event){
        get_request_itinerary_info();
        System.out.printf("%s",request_info.get_request_itinerary_info()); //The same for the other getter, must be done later
        //opens
        get_amea_info();
        
        System.out.printf("%s /n%s/n %s",request_info.get_request_itinerary_info(), amea_info.get_amea_info());
        //new UI 
        get_itinerary_info();
        System.out.println("%s/n", itinfo.get_itinerary_info());
        if (event = Accept){
            update_request_successful();
            update_itinerary();
            return requesting_itinerary;
        }
        else if(event = Deny){
            update_request_successful();
            return requesting_itinerary;
        }
    }
    
    public void notify_help(ActionEvent event){
        System.out.printf("%s",request_help.get_request_help_info());
        //opens
        System.out.ptintf("%s",amea_location.get_amea_location());
        System.out.printf("%s",vol_location.get_volunteer_location());
        if (event = Accept){
            boolean optimal_route;
            find_optimal_route();
            oproute = optimal_route;
            //open Maps
            while(vol_loc =! amea_loc || time_passes = false){
                get_volunteer_location();
            }
            if (vol+lov == amea_loc){
                update_request_succesful();
            }
            else if (time_passes = true){
                update_request_unsuccesful();
            }
            
        }
        else if (event = Deny){
            //denies
            update_request_unsuccesful();
            return help_button;
        }
        return home;
    }
    
 
    
    
}
    return 0;
}


public void setUserevents
return events;
set_user_events(){
  Events
}
get_user_events()
public void setMyLife()
