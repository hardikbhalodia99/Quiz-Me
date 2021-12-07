package com.example.quizapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class FourthFragment extends Fragment {


int ran,Q1,Q2,Q3,Q4,result;
    public FourthFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

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
        View view= inflater.inflate(R.layout.fragment_fourth, container, false);

        final TextView tv1,tv2,tv3,tv4,question;
        ImageView img1,img2,img3,img4;

        question=view.findViewById(R.id.fourquestion);
        tv1=view.findViewById(R.id.img1tv);
        tv2=view.findViewById(R.id.img2tv);
        tv3=view.findViewById(R.id.img3tv);
        tv4=view.findViewById(R.id.img4tv);

        img1=view.findViewById(R.id.img1);
        img2=view.findViewById(R.id.img2);
        img3=view.findViewById(R.id.img3);
        img4=view.findViewById(R.id.img4);

        Bundle bundle=this.getArguments();
        Q1=bundle.getInt("Q1");
        Q2=bundle.getInt("Q2");
        Q3=bundle.getInt("Q3");
        result=bundle.getInt("result");

        while(true)
        {
            Random random = new Random();
            ran=random.nextInt(10);
            if(ran == Q1 || ran==Q2 || ran == Q3)
                continue;
            else
            {
                Q4=ran;
                break;
            }
        }

        question.setText(questions[ran]);
        tv1.setText(opt[(ran*4)]);
        tv2.setText(opt[(ran*4)+1]);
        tv3.setText(opt[(ran*4)+2]);
        tv4.setText(opt[(ran*4)+3]);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ans=tv1.getText().toString();
                if(ans.equals(answers[ran]))
                {
                    result++;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("Q1",Q1);
                bundle.putInt("Q2",Q2);
                bundle.putInt("Q3",Q3);
                bundle.putInt("Q4",Q4);
                bundle.putInt("result",result);
                Fragment second = new FifthFragment();
                second.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.layout,second).commit();

            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ans=tv2.getText().toString();
                if(ans.equals(answers[ran]))
                {
                    result++;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("Q1",Q1);
                bundle.putInt("Q2",Q2);
                bundle.putInt("Q3",Q3);
                bundle.putInt("Q4",Q4);
                bundle.putInt("result",result);
                Fragment second = new FifthFragment();
                second.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.layout,second).commit();

            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ans=tv3.getText().toString();
                if(ans.equals(answers[ran]))
                {
                    result++;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("Q1",Q1);
                bundle.putInt("Q2",Q2);
                bundle.putInt("Q3",Q3);
                bundle.putInt("Q4",Q4);
                bundle.putInt("result",result);
                Fragment second = new FifthFragment();
                second.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.layout,second).commit();

            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ans=tv4.getText().toString();
                if(ans.equals(answers[ran]))
                {
                    result++;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("Q1",Q1);
                bundle.putInt("Q2",Q2);
                bundle.putInt("Q3",Q3);
                bundle.putInt("Q4",Q4);
                bundle.putInt("result",result);
                Fragment second = new FifthFragment();
                second.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.layout,second).commit();

            }
        });



        return view;
    }
}