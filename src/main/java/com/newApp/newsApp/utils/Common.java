package com.newApp.newsApp.utils;

import lombok.Getter;


@Getter

public enum Common {
//    apiKey{
//        @Override
//        public String message(){
//            return "d84eb811656b43e9831c2f85598dc261";
//        }
//    }
//  d84eb811656b43e9831c2f85598dc261

    apiKey("d84eb811656b43e9831c2f85598dc261");
    private String value;

    Common(String value) {
        this.value = value;
    }
}
