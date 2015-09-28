package com.example.angel.seekbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SeekBarActivity extends AppCompatActivity {

    public static final String EXTRA_SEEKBAR_PROGRESS = "extra seekbar progress";
    private static final int SQUARE_REQUEST_CODE = 0;
    TextView seekbarValueTV;
    SeekBar seekBar;
    Button showSquare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        showSquare = (Button) findViewById(R.id.display_square_button);
        showSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchSquareActivity = new Intent(SeekBarActivity.this, SquareActivity.class);
                int seekBarProgress = seekBar.getProgress();

                launchSquareActivity.putExtra(EXTRA_SEEKBAR_PROGRESS, seekBarProgress);
                startActivityForResult(launchSquareActivity, SQUARE_REQUEST_CODE);
            }
        });

        seekbarValueTV = (TextView) findViewById(R.id.seek_bar_value_textview);
        seekBar = (SeekBar) findViewById(R.id.seek_bar);

        String pStr = Integer.toString(seekBar.getProgress());
        seekbarValueTV.setText("The seekbar value is " + pStr);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
        public void onProgressChanged (SeekBar seekBar, int progress, boolean fromUser)
            {
                String pStr = Integer.toString(progress);
                seekbarValueTV.setText("The seekbar value is " + pStr);


            }

            @Override
        public void onStartTrackingTouch(SeekBar seekBar)
            {

            }
            @Override
                public void onStopTrackingTouch (SeekBar seekBar)
                {

                }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == SQUARE_REQUEST_CODE && resultCode == RESULT_OK){
            boolean tappedSquare = data.getBooleanExtra(SquareActivity.EXTRA_INSIDE_SQUARE, false);

            if (tappedSquare){
                Toast.makeText(this, "You tapped inside the square", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "You tapped the background", Toast.LENGTH_LONG).show();
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_seek_bar, menu);
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
