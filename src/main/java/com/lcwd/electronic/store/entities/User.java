package com.lcwd.electronic.store.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

       @Id
      // @GeneratedValue(strategy = GenerationType.IDENTITY)
       private  String userId;

       @Column(name = "user_name",unique = true)
       private  String name;

       @Column(name = "user_email")
       private  String email;

       @Column(name="user_password",length = 10)
       private String password;

       @Column(name="user_gender")
       private String gender;

       @Column(name="user_about",length = 100)
       private String about;


        @Column(name="user_image_name")
        private String imageName;



}
