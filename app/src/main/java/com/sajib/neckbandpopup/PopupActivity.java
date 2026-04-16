package com.sajib.neckbandpopup;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
public class PopupActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout lay = new LinearLayout(this); lay.setOrientation(LinearLayout.VERTICAL);
        lay.setPadding(50, 50, 50, 50);
        TextView txt = new TextView(this); txt.setText("realme Buds Found!");
        ImageView img = new ImageView(this);
        Button btn = new Button(this); btn.setText("CLOSE");
        btn.setOnClickListener(v -> finish());
        lay.addView(txt); lay.addView(img); lay.addView(btn);
        setContentView(lay);
        Glide.with(this).load("https://image01.realme.net/general/20240805/1722842712584.png").into(img);
    }
}
