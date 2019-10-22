package com.mymur.myprotocolapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

public class ProtocolActivity extends AppCompatActivity {

    private ArrayList<String> trialsArray;
    private MyDataClass myDataClass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myDataClass = MainActivity.getMyDataClass();
        myDataClass.getMyDbSaver().setACTIVITY_TITLE(Constants.PROTOCOL_ACTIVITY_TITLE);

        setContentView(R.layout.activity_protocol);

        trialsArray = getIntent().getStringArrayListExtra("TrialsArray");

        Bundle bundle = new Bundle();
        bundle.putInt("CurrentChildPosition", 0);
        ListFragment fragment = new ListFragment(trialsArray, Constants.PROTOCOL_ACTIVITY_TITLE, myDataClass, R.id.placeholderForList, trialsArray);
        fragment.setArguments(bundle);
        fragment.postFragment(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        myDataClass.getMyDbSaver().saveTrialsToDb();
        //myDataClass.getMyDbSaver().saveStudentsToDb();
    }
}


