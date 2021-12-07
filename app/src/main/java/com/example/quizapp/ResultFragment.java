package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ResultFragment extends Fragment {


    public ResultFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_result, container, false);
        TextView tvres=view.findViewById(R.id.resulttv);
        Button quit,retry;

        quit=view.findViewById(R.id.quit);
        retry=view.findViewById(R.id.retry);


        int result;

        Bundle bundle=this.getArguments();
        result=bundle.getInt("result");

        if(result == 0 || result==1 || result==2) {
            tvres.setText(" Your Score Is : " + result+"\n\n Please Try Again...");
            retry.setVisibility(View.VISIBLE);

        }
        else if(result==3){
            tvres.setText(" Your Score Is : " + result+"\n\n Good Job!");

        }
        else if(result==4){
            tvres.setText(" Your Score Is : " + result+"\n\n Excellent Work !");

        } else if(result==5){
            tvres.setText(" Your Score Is : " + result+"\n\n You Are a Genius!!");
        }

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii=new Intent(getContext(),MainActivity.class);
                startActivity(ii);
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




        return view;
    }
}