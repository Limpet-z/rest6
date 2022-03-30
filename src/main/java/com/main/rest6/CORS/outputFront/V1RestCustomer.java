package com.main.rest6.CORS.outputFront;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.main.rest6.methods.BinanceCoinInfo;
import com.main.rest6.model.ModelX;
import com.main.rest6.model.ModelY;
import com.main.rest6.model.XUser;
import com.main.rest6.repository.UserRepositoryJPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"/api/v1/"}, produces = APPLICATION_JSON_VALUE)
public class V1RestCustomer {
    private static final Logger logger = LoggerFactory.getLogger(V1RestCustomer.class);
    private final UserRepositoryJPA userRepositoryJPA;
    private final BinanceCoinInfo binanceCoinInfo;

    public V1RestCustomer(UserRepositoryJPA userRepositoryJPA, BinanceCoinInfo binanceCoinInfo) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.binanceCoinInfo = binanceCoinInfo;
    }

    @GetMapping(value = "/binanceAssets/{email}")
    public ResponseEntity<Map<String, Object>> binanceAssets(@PathVariable(name = "email") String email) {
        XUser user = userRepositoryJPA.findByEmail(email);

        Map<String, Object> bodyJson1 = binanceCoinInfo.coinInfoMethod(email, user);
        String s = bodyJson1.toString();
        logger.info("Application started");
        logger.info(s);

        Gson gson = new Gson();
        ModelY c = gson.toJson(bodyJson1., ModelY.class);

        return ResponseEntity.ok(bodyJson1);

    }
}