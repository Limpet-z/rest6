package com.main.rest6.CORS.outputFront;

import com.main.rest6.model.Status;
import com.main.rest6.model.XUser;

import java.util.HashMap;
import java.util.Map;

public class UserProfileFactory {
    public UserProfileFactory() {
    }

    public static UserProfile create(XUser user) {
        return new UserProfile(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                user.getIp(),
                user.getCountry(),
                user.getStatus(),
                user.getSubscriber(),
                user.getSubscribeExpiration()
        );
    }

    public static Map<String,Object> create1(XUser user) {
        Map<String,Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("email", user.getEmail());
        map.put("username", user.getUsername());
        map.put("ip", user.getIp());
        map.put("country", user.getCountry());
        map.put("status", user.getStatus());
        return map;

    }
}
