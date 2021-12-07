package com.example.quizapp;

import android.content.Intent;
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
import android.widget.Toast;

import java.util.Random;


public class ThirdFragment extends Fragment {

    public ThirdFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    int ran,Q1,Q2,Q3,result;
    String ansText;

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
        final View view= inflater.inflate(R.layout.fragment_third, container, false);

        TextView question=view.findViewById(R.id.question);
        final RadioGroup radiogp=view.findViewById(R.id.gp1);
        final RadioButton op1=(RadioButton) view.findViewById(R.id.A);
        final RadioButton op2=view.findViewById(R.id.B);
        final RadioButton op3=view.findViewById(R.id.C);
        final RadioButton op4=view.findViewById(R.id.D);
        Button submit=view.findViewById(R.id.thirdsub);

        Bundle bundle=this.getArguments();
         Q1=bundle.getInt("Q1");
        Q2=bundle.getInt("Q2");
        result=bundle.getInt("result");

        while(true)
        {
            Random random = new Random();
            ran=random.nextInt(10);
            if(ran == Q1 || ran==Q2)
                continue;
            else
            {
                Q3=ran;
                break;
            }
        }

        question.setText(questions[ran]);
        op1.setText(opt[(ran*4)]);
        op2.setText(opt[(ran*4)+1]);
        op3.setText(opt[(ran*4)+2]);
        op4.setText(opt[(ran*4)+3]);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(radiogp.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(op1.isChecked()) {
                    ansText = op1.getText().toString();
                }
                else if(op2.isChecked()) {
                     ansText = op2.getText().toString();
                }
                else if(op3.isChecked()) {
                     ansText = op3.getText().toString();
                }
                else {
                     ansText = op4.getText().toString();
                }


                if(ansText.equals(answers[ran])) {
                    result++;
                }

                Bundle bundle = new Bundle();
                bundle.putInt("Q2",Q2);
                bundle.putInt("Q1",Q1);
                bundle.putInt("Q3",Q3);
                bundle.putInt("result",result);
                Fragment second = new FourthFragment();
                second.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.layout,second).commit();


                radiogp.clearCheck();
            }
        });

        return view;
        }




    }
