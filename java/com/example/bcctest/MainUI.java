/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.bcctest;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.util.Log;

import vendor.renesas.graphics.cms.V1_0.ICms;

public class MainUI extends Activity {

    private static final String TAG = "CMS_APP";
    private ICms cms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* Retrieve our TextView and set its content.
         * the text is retrieved by calling a native
         * function.
         */
        setContentView(R.layout.activity_cms_test);

        try {
            cms = ICms.getService(true);
        } catch (RemoteException ex) {
            Log.e(TAG, "ICms not available");
            finish();
        }

        // contrast
        {
            final TextView text = (TextView) findViewById(R.id.contrast_text);
            SeekBar bar = (SeekBar) findViewById(R.id.contrast_bar);
            try {
                cms.cmsSetContrast(50);
                bar.setProgress(50);
            } catch (RemoteException ex) {
                Log.e(TAG, "Failed to set contrast");
            }

            bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                    try {
                        cms.cmsSetContrast(i);
                        text.setText(String.format("Contrast: %d", i));
                    } catch (RemoteException ex) {
                        Log.e(TAG, "Failed to set contrast");
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
        }
        // brightness
        {
            final TextView text = (TextView) findViewById(R.id.brightness_text);
            SeekBar bar = (SeekBar) findViewById(R.id.brightness_bar);
            try {
                cms.cmsSetBrightness(50);
                bar.setProgress(50);
            } catch (RemoteException ex) {
                Log.e(TAG, "Failed to set contrast");
            }

            bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                    try {
                        cms.cmsSetBrightness(i);
                        text.setText(String.format("Brightness: %d", i));
                    } catch (RemoteException ex) {
                        Log.e(TAG, "Failed to set brightness");
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
        }
        // tint
        {
            final TextView text = (TextView) findViewById(R.id.tint_text);
            SeekBar bar = (SeekBar) findViewById(R.id.tint_bar);
            try {
                cms.cmsSetTint(50);
                bar.setProgress(50);
            } catch (RemoteException ex) {
                Log.e(TAG, "Failed to set contrast");
            }

            bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                    try {
                        cms.cmsSetTint(i);
                        text.setText(String.format("Tint: %d", i));
                    } catch (RemoteException ex) {
                        Log.e(TAG, "Failed to set tint");
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
        }
        // color
        {
            final TextView text = (TextView) findViewById(R.id.color_text);
            SeekBar bar = (SeekBar) findViewById(R.id.color_bar);
            try {
                cms.cmsSetColor(50);
                bar.setProgress(50);
            } catch (RemoteException ex) {
                Log.e(TAG, "Failed to set contrast");
            }

            bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                    try {
                        cms.cmsSetColor(i);
                        text.setText(String.format("Color: %d", i));
                    } catch (RemoteException ex) {
                        Log.e(TAG, "Failed to set color");
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
        }
        // reset
        {
            Button btn = (Button)findViewById(R.id.reset_btn);

            final SeekBar bar1 = (SeekBar) findViewById(R.id.contrast_bar);
            final SeekBar bar2 = (SeekBar) findViewById(R.id.brightness_bar);
            final SeekBar bar3 = (SeekBar) findViewById(R.id.tint_bar);
            final SeekBar bar4 = (SeekBar) findViewById(R.id.color_bar);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        cms.cmsReset();
                        bar1.setProgress(50);
                        bar2.setProgress(50);
                        bar3.setProgress(50);
                        bar4.setProgress(50);
                    } catch (RemoteException ex) {
                        Log.e(TAG, "Failed to reset");
                    }
                }
            });
        }
    }
}
