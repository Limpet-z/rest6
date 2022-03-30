package com.main.rest6.methods;

import com.binance.connector.client.impl.SpotClientImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.main.rest6.model.BinanceAccount;
import com.main.rest6.model.ModelX;
import com.main.rest6.model.XUser;
import com.main.rest6.repository.BinanceRepository;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Type;
import java.util.*;

@Controller
public class BinanceCoinInfo {

    private final BinanceRepository binanceRepository;

    public BinanceCoinInfo(BinanceRepository binanceRepository) {
        this.binanceRepository = binanceRepository;
    }

    public Map<String, Object> coinInfoMethod(String email, XUser user) {
        var keyList2 = binanceRepository.findByUsersId(user.getId());
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<>();
        Map<String, Object> map = new HashMap<>();
        Date date = new Date();

        for (var s : keyList2) {
            SpotClientImpl client = new SpotClientImpl(s.getPublic_key(), s.getSecret());
            String result = client.createWallet().coinInfo(parameters);

            Gson gson = new Gson();
            Type type = new TypeToken<List<ModelX>>() {
            }.getType();
            List<ModelX> c = gson.fromJson(result, type);

            c.stream() /*Java8 - замена forEach*/
                    .filter(modelX -> {
                        String coin = modelX.getCoin();
                        double free = modelX.getFree();
                        if (free > 0.001 && !Objects.equals(coin, "0.001")) {
                            return true;
                        } else {
                            return false;
                        }
                    })
                    /*терминальная операция - последняя*/
                    .forEach(modelX -> {
                        String coin = modelX.getCoin();
                        double free = modelX.getFree();
                        if (!map.containsKey(coin)) {
                            map.put(coin, free);
                        } else {
                            Double aDouble = (Double) map.get(coin);
                            map.put("timestamp", date.getTime());
                            map.put("exchange", "binance");
                            map.put("exchange-email", s.getBinance_email());
                            map.put(coin, aDouble + free);
                        }
                    });
        }
        return map;
    }


}
