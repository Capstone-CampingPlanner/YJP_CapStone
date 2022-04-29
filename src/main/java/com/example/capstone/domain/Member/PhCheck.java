package com.example.capstone.domain.Member;


import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
public class PhCheck {
    private String apiKey = "NCSDTHSIVOT3LMPC";
    private String apiSecret = "9GV4FM9LIV9BMJIPKEYDL08UITI6AMVI";
    private String toServer = "01052336289";
    private int authCode;
    private String fromClient;
    Random ran = new Random();

    public int sendAuth(){
        Message message = new Message(apiKey, apiSecret);
        HashMap<String, String> params = new HashMap<String,String>();
        this.authCode = this.ran.nextInt(100000);
        params.put("to",fromClient);
        params.put("from",toServer);
        params.put("type","SMS");
        params.put("text","인증 번호 : "+authCode);
        try {
            message.send(params);
        }catch (CoolsmsException e){
            e.printStackTrace();
        }

        return this.authCode;
    }

    public PhCheck(){

    }

    public String getFromClient() {
        return fromClient;
    }

    public void setFromClient(String fromClient) {
        this.fromClient = fromClient;
    }
}
