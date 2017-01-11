package com.example.koba.graduationthesis4;

import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by koba on 2017/01/11.
 */
public class StringOperation {  //jsoupのscriptタグの中身を受け取り処理するクラス
    String url;

    public String removeAds(String str){ //scriptタグの中身のjavascriptの文字列中にあるURLを抽出、広告と思わしきURLの削除もしくはreplace

        final Pattern urlPattern = Pattern.compile("(http://|https://){1}[\\w\\.\\-/:\\#\\?\\=\\&\\;\\%\\~\\+]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = urlPattern.matcher(str);


        while (matcher.find()){
            url = matcher.group();
            Log.d("Debug", "url : "+url);
        }

        final String[] array = {
                "premium.2ch.net",
                "microad.jp",
                "nend.net",
                "amoad.com",
                "adimg.net",
                "adingo.jp",
                "i-mobile.co.jp",
                "doubleclick.net",
                "spstaticimg.ameba.jp",
                "akamai.net",
                "ad-v.jp",
                "image.click.livedoor.com",
                "behaviad.net",
                "medibaad.com",
                "unthem.com",
                "i2i.jp",
                "iadsdk.apple.com",
                "iadc.qwapi.com",
                "ichi-ni-san.net",
                "app-adforce.jp",
                "kochava.com",
                "socdm.com",
                "adlantis.jp",
                "a8.net",
                "im.ov.yahoo.co.jp",
                "yads.yahoo.co.jp",
                "ads.yahoo.com",
                "maist.jp",
                "kau.li",
                "advg.jp",
                "zimg.jp",
                "zucks.net",
                "app-adfce.jp",
                "ad-stir.com",
                "mtburn.com",
                "astrsk.net",
                "ghnosy.com"


        };


        for (int i = 0; i < array.length; i++){
            if(str.contains(array[i])){
 //               url.replace(url, " ");
                break;
            }
        }


        return str;
    }

}
