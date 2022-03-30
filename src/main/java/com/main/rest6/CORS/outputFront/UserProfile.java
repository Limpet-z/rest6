package com.main.rest6.CORS.outputFront;

import com.main.rest6.model.Status;
import com.main.rest6.model.XUser;
import lombok.Data;
import java.util.Locale;
@Data
public class UserProfile extends XUser {

    public UserProfile() {

    }

    private long id;
    private String email;
    private String username;
    private Locale ip;
    private String country;
    private Status status;
    private String subscriber;
    private int subscribeExpiration;

    public UserProfile(Long id,
                       String email,
                       String username,
                       Locale ip,
                       String country,
                       Status status,
                       String subscriber,
                       int subscribeExpiration
                      ) {

            this.id = id;
            this.username = username;
            this.email = email;
            this.ip = ip;
            this.country = country;
            this.status = status;
            this.subscriber = subscriber;
            this.subscribeExpiration = subscribeExpiration;


    }
}
