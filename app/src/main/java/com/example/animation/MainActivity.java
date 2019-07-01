package com.example.animation;

import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    int[] a={2,2,2,2,2,2,2,2,2};
    int[][] b={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int chance=0;
    boolean flag=true;
    public void Putsin(View view) {
        //ruby:0,amethyst:1

        ImageView counter=(ImageView) view;
        int i=Integer.parseInt(counter.getTag().toString());
       // Toast.makeText(this, counter.getTag().toString(), Toast.LENGTH_SHORT).show();

        if(a[i]==2&&flag) {
            a[i]=chance;

            if (chance == 0) {
                counter.setImageResource(R.drawable.ruby);
                //counter.animate().translationYBy(1500).setDuration(300);
                chance = 1;

            } else {
                counter.setImageResource(R.drawable.amethyst);
                chance = 0;

            }
            String l = "";
            for (int[] b : b) {
                if (a[b[0]] == a[b[1]] && a[b[0]] == a[b[2]] && a[b[0]] != 2) {

                    if (chance == 0) {
                        l = "Amethyst Has Won!";
                    }
                    if (chance == 1) {
                        l = "Ruby Has Won";
                    }
                    Toast.makeText(this, l, Toast.LENGTH_SHORT).show();
                    flag=false;
                    Button button = (Button) findViewById(R.id.button);
                    button.setVisibility(View.VISIBLE);
                }
            }

        }

    }
    public void playAgain(View view)
    {
        Button button = (Button) findViewById(R.id.button);
        button.setVisibility(View.INVISIBLE);
        TableLayout tab = (TableLayout) findViewById(R.id.tab);
        for(int i=0;i<tab.getChildCount();i++)
        {
            TableRow row= (TableRow) tab.getChildAt(i);
            for(int j=0;j<row.getChildCount();j++) {
                ImageView counter = (ImageView) row.getChildAt(j);
                counter.setImageDrawable(null);
            }
        }
        for(int i=0;i<a.length;i++)
        {
            a[i]=2;
        }
        chance=0;
        flag=true;
        //int n=1;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

}
}
