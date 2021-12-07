package com.example.quizapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.Random;


public class SecondFragment extends Fragment {


    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    int ran,Q2,Q1,result;

    String questions[] = {
            "Which method can be defined only once in a program?",
            "Which of these is not a bitwise operator?",
            "Which keyword is used by method to refer to the object that invoked it?",
            "Which of these keywords is used to define interfaces in Java?",
            "Which of these access specifiers can be used for an interface?",
            "Which of the following is correct way of importing an entire package ‘pkg’?",
            "What is the return type of Constructors?",
            "Which of the following package stores all the standard java classes?",
            "Which of these method of class String is used to compare two String objects for their equality?",
            "An expression involving byte, int, & literal numbers is promoted to which of these?"
    };
    String answers[] = {"main method","<=","this","interface","public","import pkg.*","None of the mentioned","java","equals()","int"};
    String opt[] = {
            "finalize method","main method","static method","private method",
            "&","&=","|=","<=",
            "import","this","catch","abstract",
            "Interface","interface","intf","Intf",
            "public","protected","private","All of the mentioned",
            "Import pkg.","import pkg.*","Import pkg.*","import pkg.",
            "int","float","void","None of the mentioned",
            "lang","java","util","java.packages",
            "equals()","Equals()","isequal()","Isequal()",
            "int","long","byte","float"
    };





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_second, container, false);
        final CheckBox cb1, cb2, cb3, cb4;
        TextView question;
        Button submit;
        cb1 = (CheckBox) view.findViewById(R.id.cb1);
        cb2 = (CheckBox) view.findViewById(R.id.cb2);
        cb3 = (CheckBox) view.findViewById(R.id.cb3);
        cb4 = (CheckBox) view.findViewById(R.id.cb4);
        submit=view.findViewById(R.id.secondSub);
        question=view.findViewById(R.id.secquestion);

        Bundle bundle=this.getArguments();
         Q1=bundle.getInt("Q1");
            result=bundle.getInt("result");

        while(true)
        {
            Random random = new Random();
            ran=random.nextInt(10);
            if(ran == Q1)
                continue;
            else
            {
                Q2=ran;
                break;
            }
        }


        question.setText(questions[ran]);
        cb1.setText(opt[(ran*4)]);
        cb2.setText(opt[(ran*4)+1]);
        cb3.setText(opt[(ran*4)+2]);
        cb4.setText(opt[(ran*4)+3]);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if(cb1.isChecked())
            {
                String ans=cb1.getText().toString();
                if(ans.equals(answers[ran]))
                {
                    result++;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("Q2",Q2);
                bundle.putInt("Q1",Q1);
                bundle.putInt("result",result);
                Fragment second = new ThirdFragment();
                second.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.layout,second).commit();

            }
              else  if(cb2.isChecked())
            {
                String ans=cb2.getText().toString();
                if(ans.equals(answers[ran]))
                {
                    result++;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("Q2",Q2);
                bundle.putInt("Q1",Q1);
                bundle.putInt("result",result);
                Fragment second = new ThirdFragment();
                second.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.layout,second).commit();

            }
            else  if(cb3.isChecked())
            {
                String ans=cb3.getText().toString();
                if(ans.equals(answers[ran]))
                {
                    result++;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("Q2",Q2);
                bundle.putInt("Q1",Q1);
                bundle.putInt("result",result);
                Fragment second = new ThirdFragment();
                second.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.layout,second).commit();

            }
            else  if(cb4.isChecked())
            {
                String ans=cb4.getText().toString();
                if(ans.equals(answers[ran]))
                {
                    result++;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("Q2",Q2);
                bundle.putInt("Q1",Q1);
                bundle.putInt("result",result);
                Fragment second = new ThirdFragment();
                second.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.layout,second).commit();

            }



            }
        });

        return view;
    }
}