package com.guideforwinjo.winzogoldwin.tipswinzo.Activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.guideforwinjo.winzogoldwin.R;

import es.dmoral.toasty.Toasty;

@SuppressLint("WrongConstant")
public class WebActivity extends AppCompatActivity {
    private static final String TAG = WebActivity.class.getSimpleName();
    private ProgressBar progressBar;
    String url;
    private WebView webView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_m_web);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.addFlags(1024);
        }
        this.webView = (WebView) findViewById(R.id.webviewm);
        this.progressBar = (ProgressBar) findViewById(R.id.progressbarm);
        Bundle extras = getIntent().getExtras();
        this.url = extras.getString("url1");
        extras.getString("url1");
        this.webView.setSoundEffectsEnabled(true);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.webView.getSettings().setGeolocationEnabled(true);
        this.webView.getSettings().setUseWideViewPort(true);
        this.webView.getSettings().setLoadWithOverviewMode(true);
        this.webView.getSettings().setAllowContentAccess(true);
        this.webView.getSettings().setDatabaseEnabled(true);
        this.webView.getSettings().setLoadsImagesAutomatically(true);
        CookieManager.getInstance().setAcceptCookie(true);
        this.webView.setBackgroundColor(Color.argb(1, 0, 0, 0));
        this.webView.getSettings().setDomStorageEnabled(true);
        this.webView.getSettings().setDatabaseEnabled(true);
        this.webView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.webView.setLongClickable(false);
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.webView, true);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.webView.getSettings().setMixedContentMode(0);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.webView.getSettings().setAllowFileAccessFromFileURLs(true);
            this.webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(false);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.webView.setLayerType(2, null);
        } else {
            this.webView.setLayerType(1, null);
        }
        this.webView.setWebViewClient(new MyWebviewClient());
        loadHomePage();
    }

    public void loadHomePage() {
        navigateToURL(getIntent().getExtras().getString("url"));
    }

    private void navigateToURL(String str) {
        this.webView.loadUrl(str);
    }

    @Override
    public void onBackPressed() {
        if (!this.webView.isFocused() || !this.webView.canGoBack()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Confirm Exit..!!");
            builder.setIcon(R.drawable.ic_baseline_exit_to_app_24);
            builder.setMessage("Do You Want To Exit This Game?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                   WebActivity.this.webView.stopLoading();
                    WebActivity.this.webView.destroy();
                    WebActivity.this.webView.removeAllViews();
                    WebActivity.this.finish();
                }
            }).setNegativeButton("Continue", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            }).setNeutralButton("Play Again", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    WebActivity.this.webView.reload();
                }
            });
            builder.create().show();
            return;
        }
        this.webView.goBack();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
    }

    private class MyWebviewClient extends WebViewClient {
        private MyWebviewClient() {
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            Toasty.error(WebActivity.this.getApplicationContext(), (CharSequence) "Check Your Internet Connection", 1, true).show();
        }

        @SuppressLint("WrongConstant")
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebActivity.this.progressBar.setVisibility(0);
            super.onPageStarted(webView, str, bitmap);
        }

        public void onPageFinished(WebView webView, String str) {
            WebActivity.this.progressBar.setVisibility(8);
            super.onPageFinished(webView, str);
        }
    }

    private void internet() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("No Internet Connection");
        builder.setIcon(R.drawable.no_internet);
        builder.setMessage("Do You Want To Exit This Game?").setCancelable(false).setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                WebActivity.this.webView.reload();
                dialogInterface.dismiss();
            }
        }).setNegativeButton("Open Settings", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogInterface, int i) {
                WebActivity.this.startActivity(new Intent("android.settings.SETTINGS"));
            }
        });
        builder.create().show();
    }
}