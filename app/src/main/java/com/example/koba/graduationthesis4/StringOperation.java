package com.example.koba.graduationthesis4;

import android.util.Log;

import java.util.Arrays;
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
//        Log.d("Debug", "str : "+str);
        List<String> list = Arrays.asList(
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
                "ghnosy.com",
                "maist.jp",
                "iogous.com",
                "trax-ad.jp",
                "4clvr.jp",
                "formulas.jp",
                "iand2ch.net",
                "-ad.jp",
                "prism.pandora.tv",
                "adms-ad.com",
                "ad.gunosy.com",
                "adjust.com",
                "adtdp.com",
                "caprofitx.com",
                "conv.gunosy.com",
                "logs.gunosy.com",
                "platform.gunosy.com",
                "stimg.iand2ch.net",
                "stimgc.iand2ch.net",
                "blogsys.jp",
                "assys01.fc2.com"


        );

        String result = str;
/*
        String urls = "(";

        for (String url : list) {
            urls = urls + url + "|";
        }
        String url_pattern = urls.substring(0, urls.length()-1);
        url_pattern += ")";

        final Pattern urlPattern = Pattern.compile(url_pattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = urlPattern.matcher(result);
        result = matcher.replaceAll("hoge");

        String temp = matcher.toString();

        for (String item : list) {
            final Pattern urlPattern = Pattern.compile("(http://|https://){1}[\\w\\.\\-/:\\#\\?\\=\\&\\;\\%\\~\\+]+", Pattern.CASE_INSENSITIVE);
            Matcher matcher = urlPattern.matcher(result);
            result = matcher.replaceAll("hoge");

            String temp = matcher.toString();
        }
*/

        Log.d("Debug", "result: "+result);
        return str;
    }

}
