package com.hangaram.hellgaram.Fragment.MealFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hangaram.hellgaram.R;


public class MealFragment extends Fragment {
    private String log = "MealFragment";

    private String Schoolcode = "B100000549"; //한가람고 학교코드

    private View view;
    private TextView changedMealText;
    private TextView menu;
    private RelativeLayout mealToggle;

    private String lunch = "급식 정보가 없어요~";
    private String dinner = "급식 정보가 없어요~";

    private Boolean islunchChecked = true;

    private MealTask mealTask;

    private String url;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_meal, container, false);
        init(view.getContext());
        return view;
    }

    public void init(Context context){
        menu = view.findViewById(R.id.menu);
        mealToggle = view.findViewById(R.id.mealToggle);
        changedMealText = view.findViewById(R.id.chandedMealText);

//        String str = "https://schoolmenukr.ml/api/high/" + Schoolcode
//                + "?year=" + TimeGiver.getYear()
//                + "&month=" + TimeGiver.getMonth()
//                + "&date=" + TimeGiver.getDate();

        url = "https://schoolmenukr.ml/api/high/" + Schoolcode
                + "?year=" + "2019"
                + "&month=" + "01"
                + "&date=" + "24";

        mealTask = new MealTask(this);
        mealTask.execute(url);

        mealToggle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    islunchChecked = !islunchChecked;
                    if(islunchChecked){
                        changedMealText.setText("점심");
                        Log.d(log,lunch);
                        setMenu(lunch);
                    }else{
                        changedMealText.setText("저녁");
                        Log.d(log,dinner);
                        setMenu(dinner);
                    }
                }
                return true;
            }
        });
    }

    public void setMenu(String str) {
        menu.setText(str);
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
        Log.d(log,lunch);
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
        Log.d(log,dinner);
    }

    public Boolean getIslunchChecked() {
        return islunchChecked;
    }
}
