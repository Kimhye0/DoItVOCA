package com.example.doitvoca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    private WebView webView;
    private ImageButton AddWordList_button;
    private static String dictionaryUrl = "https://alldic.daum.net/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //웹 뷰 세팅
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebJavascriptInterface(), "Android");
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClientClass());

        //버튼
        AddWordList_button = findViewById(R.id.button);
        AddWordList_button.setVisibility(Button.INVISIBLE);
        //단어 저장 리스너
        AddWordList_button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplication(),"단어 저장 완료!",Toast.LENGTH_LONG).show();
            }
        });

        //뷰 실행
        webView.loadUrl(dictionaryUrl);
    }

    public class WebJavascriptInterface {
        @JavascriptInterface
        public void getHtml(String html) {
            String source = html;
            Log.d("TAG",html);
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //백키를 누르면 액티비티를 종료하지 않고 이전 페이지로 돌아간다.
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            AddWordList_button.setVisibility(Button.GONE);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {//페이지 이동
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            String url = request.getUrl().toString();
            Log.d("check URL",url);

            //요청받은 url 띄우기
            view.loadUrl(url);

            //단어 추가 버튼 활성화
            AddWordList_button.setVisibility(Button.VISIBLE);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            view.loadUrl("javascript:window.Android.getHtml(document.getElementsByTagName('html')[0].innerHTML);");
        }
    }
}
