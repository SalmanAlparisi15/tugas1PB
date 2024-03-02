package com.example.tugaspemogramanbergerak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvlittle, tvResult;
    private ImageView imgFFXVI, imgSof, imgSpidermen;
    private EditText etSofQty, etFFXVIQty, etSpiderQty;
    private RadioGroup  etGroup3;
    private RadioButton  btnGold, btnDiamond, btnnoMember;
    private CheckBox btnSof, btnFFXVI, btnSpidermen;
    private Button btnDone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvlittle = findViewById(R.id.tvlittle);
        tvResult = findViewById(R.id.tvResult);
        imgFFXVI = findViewById(R.id.imgFFXVI);
        imgSof = findViewById(R.id.imgSof);
        imgSpidermen = findViewById(R.id.imgSpidermen);
        etSofQty = findViewById(R.id.etSofQty);
        etFFXVIQty = findViewById(R.id.etFFXVIQty);
        etSpiderQty = findViewById(R.id.etSpiderQty);
        etGroup3 = findViewById(R.id.etGroup3);
        btnSof = findViewById(R.id.btnSof);
        btnFFXVI = findViewById(R.id.btnFFXVI);
        btnSpidermen = findViewById(R.id.btnSpidermen);
        btnGold = findViewById(R.id.btnGold);
        btnDiamond = findViewById(R.id.btnDiamond);
        btnnoMember = findViewById(R.id.btnnoMember);
        btnDone = findViewById(R.id.btnDone);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int qtySof = 0;
                int qtyFFXVI = 0;
                int qtySpidermen = 0;
                int memberGold = 50000;
                int memberDiamond = 100000;

                if (!TextUtils.isEmpty(etSofQty.getText().toString())) {
                    qtySof = Integer.parseInt(etSofQty.getText().toString());
                }
                if (!TextUtils.isEmpty(etFFXVIQty.getText().toString())) {
                    qtyFFXVI = Integer.parseInt(etFFXVIQty.getText().toString());
                }
                if (!TextUtils.isEmpty(etSpiderQty.getText().toString())) {
                    qtySpidermen = Integer.parseInt(etSpiderQty.getText().toString());

                }
                int total = procesHarga(qtySof, qtyFFXVI, qtySpidermen);
                int diskon = (int) (total*0.10);
                if (total > 2000000) {
                    total = (int) (total * 0.90);
                    tvResult.setText("TOTAL PEMBELIAN: Rp " + total);
                }
                int idMember = etGroup3.getCheckedRadioButtonId();
                if (idMember == R.id.btnGold) {
                    total -= memberGold;

                } else if (idMember == R.id.btnDiamond) {
                    total -= memberDiamond;
                }
                String nota = "NOTA \n";
                nota += "---------------------------\n";
                if (qtySof > 0) {
                    nota += "STREET OF FIGHTER x  " + qtySof + "\n";
                }
                if (qtyFFXVI > 0) {
                    nota += "FINAL FANTASY XVI x " + qtyFFXVI + "\n";
                }
                if (qtySpidermen > 0) {
                    nota += "SPIDERMEN MILES MORALES x " + qtySpidermen + "\n";
                }
                nota += "DISKON 10% : Rp" +diskon + "\n";
                nota += "DISKON GOLD: Rp 50000\n";
                nota += "DISKON DIAMOND: Rp 100000\n";
                nota += "TOTAL YANG DIPILIH  : Rp " + total;

                tvResult.setText(nota);
            };
        });
    }
    private int procesHarga(int qtySof, int qtyFFXVI, int qtySpidermen) {
        int priceSof = 520000;
        int priceFFXVI = 580000;
        int priceSpidermen = 630000;
        int total = (qtySof * priceSof) + (qtyFFXVI * priceFFXVI) + (qtySpidermen * priceSpidermen);

        return total;
    }

}