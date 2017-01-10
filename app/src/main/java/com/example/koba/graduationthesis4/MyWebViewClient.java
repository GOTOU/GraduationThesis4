package com.example.koba.graduationthesis4;

/**
 * Created by koba on 2016/12/25.
 */
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


class Param{
    WebView webView = null;
    String url = "";
    String htmlSource = "";
    String ua = "";
}

class MyWebViewClient extends WebViewClient{

    boolean firstLoad = true;
    Param param = new Param();

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {

        if (firstLoad) {
            // 初めてページが読み込まれたら，ここの処理を行う
            Log.d("Debug", "onPageStarted: "+url);
            param.url = url;
            param.webView = view;


            //モバイルサイトの表示
            param.ua = view.getSettings().getUserAgentString();

            //DOM編集スレッドを起動する
            DownloadTask task = new DownloadTask();
            task.execute(param);

            //無限ループ対策
            firstLoad = false;

        } else {
            // DOM編集後のページ読み込みでここの編集をおこなう
            firstLoad = true;
        }
    }

}

class DownloadTask extends AsyncTask<Param, Integer, Param> {
    @Override
    protected Param doInBackground(Param... params) {
        Param param = params[0];

        try {
            // ここでJsoup使ってDOMの編集を行う
            Document document = Jsoup.connect(param.url).userAgent(param.ua).get();

            Element body = document.select("body").first();
            Elements alls = body.getAllElements();
            Log.d("Debug", "AllElements: "+ alls);
            Elements links = body.getElementsByTag("a");  //aタグを取得
            Elements googles = body.getElementsByTag("ins");
            Elements divs = body.getElementsByTag("div");
            Elements scripts = body.getElementsByTag("script");
            Elements zucks = body.getElementsByTag("img");
            Elements elements = body.children();

            for (Element script : scripts){
                String src = script.attr("src");


                if (src.contains("nend")){
                    script.remove();
                }

                if (src.contains("amoad")){
                    script.remove();
                }

                if (src.contains("zucks")){
                    script.remove();
                }

            }



            for(Element div : divs){
//                String className = div.attr("class");
                String className = div.className();
//                Log.d("debug", "className: "+className);
                String id = div.id();
//                Log.d("debug", "id: "+id);


                if(className.contains("amoad")){  //amoad広告
                    div.remove();
                }

                if (id.contains("zucksad")){  //zucks広告
                    div.remove();
                }

                if(id.contains("nend_adspace")){  //nend広告
                    div.remove();
                }
            }

            for(Element div : divs){
                String scriptName = div.attr("script");

                if(scriptName.contains("unthem.com")){
                    div.remove();
                }
            }

            for(Element google : googles){
                String className = google.attr("class");

                if(className.contains("adsbygoogle")){  //google広告
                    google.remove();
                }
            }

            for(Element link : links){
                String href= link.attr("href");

                if(href.contains("i-mobile.co.jp")){
                    link.remove();
                }

                if(href.contains("/images/bannar")){
                    link.remove();
                }

                if(href.contains("tapone")){ //tapone広告
                    link.remove();
                }

            }




            param.htmlSource = document.html();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return param;
    }

    @Override
    protected void onPostExecute(Param result) {
        if (result.htmlSource.equals("")){
            Log.d("Debug", "htmlSource is empty");
        } else {
            Log.d("Debug", "loadDataWithBaseURL");

            result.webView.loadDataWithBaseURL(result.url, result.htmlSource, "text/html", "UTF-8", result.url);
        }
    }

}