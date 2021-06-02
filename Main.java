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

