package com.example.quizapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;


public class FirstFragment extends Fragment {

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


int result=0;
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
            "intface","interface","inf","Intf",
            "public","protected","private","All of the mentioned",
            "Import pkg.","import pkg.*","Importpkg.*","import pkg*.",
            "int","float","void","None of the mentioned",
            "lang","java","util","java.packages",
            "equals()","Equal()","isequals()","Isequal()",
            "int","long","byte","float"
    };







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_first, container, false);
        TextView question=view.findViewById(R.id.question);

        final Button ans1=view.findViewById(R.id.ans1);
        final Button ans2=view.findViewById(R.id.ans2);
        final Button ans3=view.findViewById(R.id.ans3);
        final Button ans4=view.findViewById(R.id.ans4);

        Random random = new Random();
        final int ran=random.nextInt(10);
        final int Q1=ran;
        question.setText(questions[ran]);
        ans1.setText(opt[(ran*4)]);
        ans2.setText(opt[(ran*4)+1]);
        ans3.setText(opt[(ran*4)+2]);
        ans4.setText(opt[(ran*4)+3]);



        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ans=ans1.getText().toString();
                if(ans.equals(answers[ran]))
                {
                    result++;
                }


                Bundle bundle = new Bundle();
                bundle.putInt("Q1",Q1);
                bundle.putInt("result",result);

                Fragment second = new SecondFragment();
                second.setArguments(bundle);
               getFragmentManager().beginTransaction().replace(R.id.layout,second).commit();
            }
        });

        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ans=ans2.getText().toString();
                if(ans.equals(answers[ran]))
                {
                    result++;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("Q1",Q1);
                bundle.putInt("result",result);

                Fragment second = new SecondFragment();
                second.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.layout,second).commit();
            }
        });

        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ans=ans3.getText().toString();
                if(ans.equals(answers[ran]))
                {
                    result++;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("Q1",Q1);
                bundle.putInt("result",result);

                Fragment second = new SecondFragment();
                second.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.layout,second).commit();
            }
        });

        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ans=ans4.getText().toString();
                if(ans.equals(answers[ran]))
                {
                    result++;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("Q1",Q1);
                bundle.putInt("result",result);
                Fragment second = new SecondFragment();
                second.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.layout,second).commit();
            }
        });

        return view;
    }
}