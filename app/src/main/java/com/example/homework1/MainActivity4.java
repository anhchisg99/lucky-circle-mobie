package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity4 extends AppCompatActivity {
    //    ArrayList<Users> mUsers;
    ImageView wheelimg;

    String[] sectors = {"01","02","03","04","05","06","07","08","09","10","11","12"};
    TextView textView;
    TextView popup_tv1;
    ArrayList<String> data_copy_random_number;
    ArrayList<String> data_copy_names;
    ArrayList<String> data_random_number;
    ArrayList<String> data_names;
//    LinearLayout layout = new LinearLayout(this);
    //function popup

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        wheelimg = findViewById(R.id.wheel);
        textView = findViewById(R.id.txtv);
        popup_tv1 = findViewById(R.id.popup_tv1);
        Collections.reverse(Arrays.asList(sectors));
        data_random_number = new ArrayList<String>();
        data_names = new ArrayList<String>();

        ArrayList<Users> mUsers = getIntent().getParcelableArrayListExtra("data");
        for(int i =0; i< mUsers.size();i++){
            String x = mUsers.get(i).getId();
            String y = mUsers.get(i).getName();
            data_random_number.add(x);
            data_names.add(y);
        }

//        ArrayList<String> data_random_number = (ArrayList<String>) getIntent().getSerializableExtra("data_random_number");
//        ArrayList<String> data_names = (ArrayList<String>) getIntent().getSerializableExtra("data_names");
        data_copy_random_number=data_random_number;
        data_copy_names = data_names;
    }
    public void onButtonShowPopupWindowClick(View view,String str) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup, null);
        TextView tvId=(TextView) popupView.findViewById(R.id.popup_tv1);
        tvId.setText(str);
        // create the popup windowsa
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);



        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
    public void spinWheel(View view){

        Random rr = new Random();
        final int degree = rr.nextInt(360);

        RotateAnimation rotateAnimation = new RotateAnimation(0,degree + 720,RotateAnimation.RELATIVE_TO_SELF,
                0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(3000);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());

        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                CalculatePoint(degree);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        wheelimg.startAnimation(rotateAnimation);


    }
    public void CalculatePoint(int degree){
        int initialPoint =0;
        int endPoint = 30;
        int i =0;
        String res = null;
        int n = -1;
        int test_copy;

        do{
            if(degree> initialPoint && degree < endPoint){
                res = sectors[i];
                String aString = Integer.toString(degree);
//                Toast.makeText(MainActivity4.this, aString,
//                        Toast.LENGTH_LONG).show();
//                Toast.makeText(MainActivity4.this, data_copy_names.get(1),
//                        Toast.LENGTH_LONG).show();
            }
            initialPoint +=30; endPoint +=30;
            i++;
//


        }while(res == null);
        test_copy = data_copy_random_number.indexOf(res);

        if(test_copy == -1){

            textView.setText("quay lai");
//            popup_tv1.setText("quay lai");
//            LayoutInflater inflater = (LayoutInflater)
//                    getSystemService(LAYOUT_INFLATER_SERVICE);
//            View popupView = inflater.inflate(R.layout.popup, null);
//
//            // create the popup window
//            int width = LinearLayout.LayoutParams.WRAP_CONTENT;
//            int height = LinearLayout.LayoutParams.WRAP_CONTENT;
//            boolean focusable = true; // lets taps outside the popup also dismiss it
//            final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
////            ((TextView)popupWindow.getContentView().findViewById(R.id.popup_tv1)).setText("quay lai");
//            // show the popup window
//            // which view you pass in doesn't matter, it is only used for the window tolken
//            popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
//
//            // dismiss the popup window when touched
//            popupView.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    popupWindow.dismiss();
//                    return true;
//                }
//            });


        }else{

            //ket qua
            String test_copy1 = data_copy_names.get(test_copy);
            textView.setText(test_copy1);

            LayoutInflater inflater = (LayoutInflater)
                    getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.popup, null);

            // create the popup window
            int width = LinearLayout.LayoutParams.WRAP_CONTENT;
            int height = LinearLayout.LayoutParams.WRAP_CONTENT;
            boolean focusable = true; // lets taps outside the popup also dismiss it
            final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
//            ((TextView)popupWindow.getContentView().findViewById(R.id.popup_tv1)).setText(test_copy1);
            // show the popup window
            // which view you pass in doesn't matter, it is only used for the window tolken
            popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

            // dismiss the popup window when touched
            popupView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    popupWindow.dismiss();
                    return true;
                }
            });



        }

//        textView.setText(res);


    }
    public void ClickPopup() {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup, null);
//        popup_tv1.setText("con ga");
        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

}