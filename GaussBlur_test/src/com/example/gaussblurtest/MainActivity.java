package com.example.gaussblurtest;

import com.example.gaussblur_test.R;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity 
{
	ImageView imageView1 = null;
	ImageView imageView2 = null;
	
	TextView textView1 = null;
	TextView textView2 = null;
	
	Button button = null;
	
	GaussBlur gaussBlur = null;
	
	Bitmap bitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        imageView1 = (ImageView)findViewById(R.id.imageView1);
        imageView2 = (ImageView)findViewById(R.id.imageView2);
        
        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        
        button = (Button)findViewById(R.id.button1);
        
        gaussBlur = new GaussBlur();
        
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        
        imageView1.setImageBitmap(bitmap);
        imageView2.setImageBitmap(bitmap);
        
        button.setOnClickListener(new View.OnClickListener() 
        {
			@Override
			public void onClick(View v) 
			{
				int radius = 30;
				
				//-------------------------------------------------------
				//高斯模糊
				//textView1.setText("高斯模糊中....，模糊半径：10");
				
				//记录时间
				long time1 = System.currentTimeMillis();
				
				Bitmap out1 = gaussBlur.gaussBlur1(bitmap, radius);
				
				long time = System.currentTimeMillis() - time1;
				
				textView1.setText("高斯模糊，半径" + radius + "，用时：" + time + "ms");
				imageView1.setImageBitmap(out1);
				
				
				//--------------------------------------------
				//利用均值模糊逼近高斯模糊
				//textView2.setText("3次均值模糊中....，模糊半径：10");
				
				time1 = System.currentTimeMillis();
				
				Bitmap out2 = gaussBlur.gaussBlur2(bitmap, radius);
				
				time = System.currentTimeMillis() - time1;
				
				textView2.setText("3次均值模糊，半径" + radius + "，用时：" + time + "ms");
				imageView2.setImageBitmap(out2);
			}
		});
    }
}




























