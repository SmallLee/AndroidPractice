package practice.lxn.cn.androidpractice.activity;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import practice.lxn.cn.androidpractice.R;

/**
 * webview和js交互
 */
public class WebJsActivity extends AppCompatActivity {
    private static final String TAG = "WebJsActivity";
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_js);
        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/demo.html");
        webView.addJavascriptInterface(new JavaScriptInterface(),"android");
        //WebChromeClient主要处理js的对话框
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }

            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }
        });
        //WebViewClient主要处理各种通知，事件
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                checkUri(Uri.parse(url));
                return true;
            }
        });
    }

    public void checkUri(Uri uri){
        Log.d(TAG, "shouldOverrideUrlLoading: " + uri.getScheme());
        Log.d(TAG, "shouldOverrideUrlLoading: " + uri.getAuthority());//webview
        String age = uri.getQueryParameter("age");//1
        String name = uri.getQueryParameter("name");//lxn
        Log.d(TAG, "shouldOverrideUrlLoading: " + age +"--"+name);
        if (uri.getScheme().equals("abc")) {
            //这里调用android的方法
            Toast.makeText(this, "通过url调用", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateJs(View view) {
//        webView.loadUrl("javascript:updateHtml()");//js方法无返回值
        //有返回值处理
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            webView.evaluateJavascript("javascript:updateHtml()", new ValueCallback<String>() {
                @Override
                public void onReceiveValue(String value) {
                    System.out.println("==========" + value);
                }
            });
        } else {
            //19之前java调用js方法，js在调用java方法把返回值传过来
        }

    }

    public class JavaScriptInterface{
        @JavascriptInterface
        public void showToast(){
            Toast.makeText(WebJsActivity.this, "被JS调用了", Toast.LENGTH_SHORT).show();
        }
    }
}
