package com.aceman.fakenews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by Lionel JOFFRAY - on 30/01/2019.
 */
public class WebViewActivity extends AppCompatActivity {
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);

        mWebView = findViewById(R.id.web_view1);
        mWebView.loadData(MyAdapter.mGetContent, "text/html; charset=UTF-8", null);

    }
     public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                Toast.makeText(getApplication(),"En cours de dev...",Toast.LENGTH_SHORT ).show();
                return true;
            case R.id.share:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Je regarde cette news et j'ai penser a toi ! ";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Fake News");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                return true;
            case R.id.snapshot:

                Toast.makeText(getApplication(),"En cours de dev...",Toast.LENGTH_SHORT ).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
