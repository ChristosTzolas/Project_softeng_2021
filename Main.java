package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

class User {
    int user_id;
    String username;
    String password;
    String surname;
    String name;
    int phone;
    String email;
    Date birth_date;
}


class Admin {
    int adm_id;
    String username;
    String password;
    String email;
}

class Location {
    int loc_id;
    String name;
    String address;
    boolean access;
}


class Volunteer extends com.company.User {
    String itineraries;
    boolean active;
}


class Amea extends com.company.User {
    enum disability{}
    String message;
    Contact emergency_contacts;
    Contact doctors;
}

class Itinerary {
    int it_id;
    int user_id;
    Date date_and_time;
    String location;
    enum to_or_from{}
    int num_seats;
    com.company.Amea passenger_ids;

}

class Request {
    int req_id;
    com.company.User from_id;
    enum status{}
}

class Request_Itinerary {
    int it_id;
    String pick_up_location;
}

class Request_help {
    com.company.User vol_id;
}

class Event {
    int event_id;
    int user_id;
    Date date_and_time;
    String description;
    String title;
}

class Drug_event {
    String drug_name;
    int pack_tables;
    float dosage;
    Contact prescripted_by;
}

class Doctor_event {
    Contact doctor;
    String doctor_location;
}

class Pharmacy {
    int ph_id;
    String name;
    String location;
    String schedule;
}

class Contact {
    int cont_id;
    String surname;
    String name;
    int phone;
    String email;
}