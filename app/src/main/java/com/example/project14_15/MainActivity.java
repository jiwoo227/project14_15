package com.example.project14_15;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] fruitsArr={"복숭아", "딸기", "무화과"};
    int[] imgsArr = {R.drawable.berry, R.drawable.fruits, R.drawable.peach};
    Button btnFruits;
    ImageView imgv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnDialog = findViewById(R.id.btn_dialog);
        btnFruits = findViewById(R.id.btn_fruits);
        btnDialog.setOnClickListener(btnListener);
        btnFruits.setOnClickListener(btnListener);
        imgv = findViewById(R.id.imgv);
    }

    View.OnClickListener btnListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switch (v.getId()) {
                case R.id.btn_dialog:
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(R.string.dialog_title)
                            .setMessage((R.string.dialog_message))
                            .setIcon(R.drawable.error1)
                            .setPositiveButton(R.string.btn_positive, btnPositiveListener)
                            .show();
                    break;
                case R.id.btn_fruits:
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(R.string.btn_fruits)
                            .setSingleChoiceItems(fruitsArr, 0, fruitsItemListener)
                            .setIcon(R.drawable.peach)
                            .setPositiveButton("닫기", null)
                            .show();
                    break;
            }
        }
    };
        DialogInterface.OnClickListener fruitsItemListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                btnFruits.setText(fruitsArr[which]);
                imgv.setImageResource(imgsArr[which]);
            }
        };
    DialogInterface.OnClickListener btnPositiveListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this, "대화 상자ㅏ 확인 버튼을 클릭하셨어요", Toast.LENGTH_SHORT).show();
        }
    };
}