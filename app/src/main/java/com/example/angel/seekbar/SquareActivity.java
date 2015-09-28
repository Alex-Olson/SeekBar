package com.example.angel.seekbar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class SquareActivity extends AppCompatActivity {

    public static final String EXTRA_INSIDE_SQUARE= "extra in square";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        Intent launchIntent = getIntent();

        int squareSize = launchIntent.getIntExtra(SeekBarActivity.EXTRA_SEEKBAR_PROGRESS, 100);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.square_activity_layout);
        ShapeDrawable square = new ShapeDrawable(new RectShape());

        square.setIntrinsicHeight(squareSize);
        square.setIntrinsicWidth(squareSize);
        square.getPaint().setColor(Color.GREEN);

        ImageView squareView = new ImageView(this);
        squareView.setImageDrawable(square);

        layout.addView(squareView);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_INSIDE_SQUARE, false);
                setResult(RESULT_OK, resultIntent);
                finish();

            }
        });

        squareView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_INSIDE_SQUARE, true);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_square, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
