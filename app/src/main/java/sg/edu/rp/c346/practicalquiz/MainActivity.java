package sg.edu.rp.c346.practicalquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView tvChoose;
    Spinner spUrl;
    WebView wbvw;

    ArrayList<String> alURL;
    ArrayAdapter<String> aaURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvChoose=findViewById(R.id.textViewChs);
        spUrl=findViewById(R.id.spinnerURL);
        wbvw=findViewById(R.id.wbView);


        alURL=new ArrayList<>();
        String[] strNumbers = getResources().getStringArray(R.array.url);
        alURL.addAll(Arrays.asList(strNumbers));


        aaURL=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, alURL);
        spUrl.setAdapter(aaURL);

        spUrl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int pos=spUrl.getSelectedItemPosition();
                alURL.clear();

                        if (pos==0) {
                            String url = "https://www.facebook.com/";
                            wbvw.loadUrl(url);
                        }

                        else {
                            String url = "https://twitter.com/login?lang=en";
                            wbvw.loadUrl(url);
                        }
                        aaURL.notifyDataSetChanged();
                }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                };

        });
    };



}
