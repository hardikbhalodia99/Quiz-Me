package com.example.quizapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FifthFragment extends Fragment {

    public FifthFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

int result,Q1,Q2,Q3,Q4,Q5,ran;
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
        View view= inflater.inflate(R.layout.fragment_fifth, container, false);

        final ListView listView=view.findViewById(R.id.listview);
        List<String> optionlist=new ArrayList<String>();

        TextView question=view.findViewById(R.id.fivequestion);
        Bundle bundle=this.getArguments();
        Q1=bundle.getInt("Q1");
        Q2=bundle.getInt("Q2");
        Q3=bundle.getInt("Q3");
        Q4=bundle.getInt("Q4");
        result=bundle.getInt("result");

        while(true)
        {
            Random random = new Random();
            ran=random.nextInt(10);
            if(ran == Q1 || ran==Q2 || ran == Q3 || ran==Q4)
                continue;
            else
            {
                Q5=ran;
                break;
            }
        }


        question.setText(questions[ran]);
        optionlist.add(opt[ran*4]);
        optionlist.add(opt[(ran*4)+1]);
        optionlist.add(opt[(ran*4)+2]);
        optionlist.add(opt[(ran*4)+3]);

        ArrayAdapter ad=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,optionlist);
        listView.setAdapter(ad);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                String ans=listView.getItemAtPosition(i).toString();
                if(ans.equals(answers[ran]))
                {
                    result++;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("Q1",-1);
                bundle.putInt("Q2",-1);
                bundle.putInt("Q3",-1);
                bundle.putInt("Q4",-1);
                bundle.putInt("Q5",-1);
                bundle.putInt("result",result);
                Fragment second = new ResultFragment();
                second.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.layout,second).commit();
            }
        });


        return view;
    }
}