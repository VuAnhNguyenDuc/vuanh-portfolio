package com.vuanhnguyenduc;

/**
 * Hello world!
 *
 * To initiate a default user in the database, please do as follow:
 * Populate USER_PROFILE Table
        INSERT INTO USER_PROFILE(type)
        VALUES ('USER');

        INSERT INTO USER_PROFILE(type)
        VALUES ('ADMIN');

        INSERT INTO USER_PROFILE(type)
        VALUES ('DBA');

 * Populate one Admin User which will further create other users for the application using GUI
        INSERT INTO APP_USER(sso_id, password, first_name, last_name, email)
 VALUES ('sam','$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'Sam','Smith','samy@xyz.com');

 * Populate JOIN Table
        INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
 SELECT user.id, profile.id FROM APP_USER user, USER_PROFILE profile
 where user.sso_id='sam' and profile.type='ADMIN';

 Tutorial :
 Free MYSQL Hosting Service on Heroku with ClearDB tutorial
 https://www.youtube.com/watch?v=mBCH9OTVaGw

 how to store and retrieve the HTML text Editor contents
 https://stackoverflow.com/questions/18378742/how-to-store-and-retrieve-the-html-text-editor-contents-to-sql-server-db-in-asp

 How to convert String to JSONObject in Java
 https://stackoverflow.com/questions/5245840/how-to-convert-string-to-jsonobject-in-java
 */

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
