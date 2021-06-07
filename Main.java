package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

class User {
    int user_id;
    enum disability {BLD, DF, WLK, NO}
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
    enum access {Y, N}
}


class Volunteer extends com.company.User {
    int vol_id;
    enum active {Y, N}
}


class Amea extends com.company.User {
    int amea_id;
    String message;
    com.company.Contact emergency_contacts;
    com.company.Contact doctors;
}

class Itinerary {
    int it_id;
    int it_vol_id;
    DateTimeFormatter date_and_time;
    String location;
    enum to_or_from{UNI, CENTER}
    int num_seats;
    com.company.Amea passenger_ids;

}

class Request {
    int req_id;
    int from_id;
    enum status{A, D}
}

class Request_Itinerary {
    int req_it_id;
    String pick_up_location;
}

class Request_help {
    int req_vol_id;
    com.company.User vol_id;
}

class Event {
    int event_id;
    int e_user_id;
    DateTimeFormatter date_and_time;
    String description;
    String title;
}

class Drug_event extends com.company.Event {
    int drg_ev_id;
    String drug_name;
    int pack_tables;
    float dosage;
    com.company.Contact prescripted_by;
}

class Doctor_event extends com.company.Event {
    int dr_ev_id;
    String doctor_location;
    com.company.Contact doctor;
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

class Passenger_list{
    int it_id_list;
    int it_amea_id;
}

class Doctor_list{
    int d_amea_id;
    int d_cont_id;
}

class Emergency_contact_list{
    int e_amea_id;
    int e_cont_id;
}