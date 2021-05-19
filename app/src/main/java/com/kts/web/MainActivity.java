package com.kts.web;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {

    //위젯에 대응되는 변수 선언
    EditText editURL;
    Button btnGo, btnBack;
    WebView web;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_web);

        //각 4개의 변수에 위젯을 대입
        editURL = (EditText) findViewById(R.id.edtUrl);
        btnGo = (Button) findViewById(R.id.btnGo);
        btnBack = (Button) findViewById(R.id.btnBack);
        web = (WebView) findViewById(R.id.webView1);

        web.setWebViewClient(new SubWebViewClient()); //클래스를 생성하여 웹 뷰에 대입

        WebSettings webSet = web.getSettings(); //WebSettings 클래스를 사용
        webSet.setBuiltInZoomControls(true); //줌 버튼 컨트롤이 화면에 보이게 함
        webSet.setJavaScriptEnabled(true); //JS 작동하게 함

        btnGo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web.loadUrl(editURL.getText().toString()); //EditText에 입력한 URL 웹페이지가 나오게 함
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                web.goBack(); //이전버튼
            }
        });

    }

    //webViewClient의 상속을 받는 SubWebViewClient 클래스를 정의한다.
    //WebViewClient를 상속받아 자신의 WebViewClient 클래스를 만든다.
    class SubWebViewClient extends WebViewClient {
        //자동으로 오버라이딩 된 메소드
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

}