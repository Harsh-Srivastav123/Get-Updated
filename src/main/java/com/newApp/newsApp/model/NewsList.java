
package com.newApp.newsApp.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class NewsList {

    @SerializedName("articles")
    private List<News> newsList;
    @SerializedName("status")
    private String mStatus;


}
