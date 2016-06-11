package com.example.dhimandasgupta.autoscale;

import android.os.Bundle;
import android.support.percent.PercentRelativeLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private static final int MAX_HEIGHT = 400;

    private PercentRelativeLayout mPercentRelativeLayout;
    private SeekBar mSeekBar;
    private ScaleImageView mScaleImageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPercentRelativeLayout = (PercentRelativeLayout) findViewById(R.id.percent_relative_layout);
        mScaleImageView = (ScaleImageView) findViewById(R.id.view_image);
        mSeekBar = (SeekBar) findViewById(R.id.seek_bar);
        if (mSeekBar != null && mPercentRelativeLayout != null) {
            mSeekBar.setOnSeekBarChangeListener(this);
        }
        if (mScaleImageView != null) {
            mScaleImageView.setImageResource(R.drawable.test);
            mScaleImageView.setBoundWidth(mScaleImageView.getLayoutParams().width);
            mScaleImageView.scaleImage(mScaleImageView);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        ViewGroup.LayoutParams layoutParams = mPercentRelativeLayout.getLayoutParams();
        layoutParams.height = (dpToPx(MAX_HEIGHT) * progress) / 100;
        mPercentRelativeLayout.requestLayout();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    private int dpToPx(int dp) {
        float density = getApplicationContext().getResources().getDisplayMetrics().density;
        return Math.round((float)dp * density);
    }
}
