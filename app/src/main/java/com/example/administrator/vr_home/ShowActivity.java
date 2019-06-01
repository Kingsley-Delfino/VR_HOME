package com.example.administrator.vr_home;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.google.vr.sdk.widgets.common.VrWidgetView;
import com.google.vr.sdk.widgets.pano.VrPanoramaEventListener;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import java.io.IOException;
import java.io.InputStream;
import android.graphics.Bitmap;

public class ShowActivity extends AppCompatActivity {

    private  ImagerLoaderTask imagerLoaderTask;
    private VrPanoramaView mVrPanoramaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        mVrPanoramaView = (VrPanoramaView) findViewById(R.id.VRP);
        mVrPanoramaView.setInfoButtonEnabled(false);
        mVrPanoramaView.setFullscreenButtonEnabled(false);
        mVrPanoramaView.setDisplayMode(VrWidgetView.DisplayMode.FULLSCREEN_STEREO);
        mVrPanoramaView.setEventListener(new MVREventListener());

        imagerLoaderTask = new ImagerLoaderTask();
        imagerLoaderTask.execute();

    }

    private class ImagerLoaderTask extends AsyncTask<Void,Void,Bitmap>{
        @Override
        protected Bitmap doInBackground(Void... params) {
            try {
                InputStream inputStream = getAssets().open("I-100.jpg");
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            VrPanoramaView.Options options = new VrPanoramaView.Options();
            options.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER;
            mVrPanoramaView.loadImageFromBitmap(bitmap,options);
            super.onPostExecute(bitmap);
        }
    }

    @Override
    protected void onPause() {
        mVrPanoramaView.pauseRendering();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mVrPanoramaView.resumeRendering();
    }

    @Override
    protected void onDestroy() {
        mVrPanoramaView.shutdown();
        if (imagerLoaderTask!=null){
            if (imagerLoaderTask.isCancelled()){
                imagerLoaderTask.cancel(true);
            }
        }
        super.onDestroy();
    }

    private class MVREventListener extends VrPanoramaEventListener{

        @Override
        public void onLoadSuccess() {
            super.onLoadSuccess();
            Toast.makeText(ShowActivity.this, "加载成功！", Toast.LENGTH_SHORT).show();
        }

        public void onLoadError(String errorMessage){
            super.onLoadError(errorMessage);
            Toast.makeText(ShowActivity.this, "加载失败！", Toast.LENGTH_SHORT).show();
        }
    }
}