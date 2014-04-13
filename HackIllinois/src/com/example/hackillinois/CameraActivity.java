package com.example.hackillinois;

import java.io.IOException;
import java.io.InputStream;

import com.google.android.gms.internal.iv;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class CameraActivity extends Activity {

	private Camera mCamera;
	private CameraPreview mPreview;
	//private ViewSwitcher switcher;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.camera_preview);
		

        //switcher = (ViewSwitcher) findViewById(R.id.viewSwitcher1);
		Button mapButton = (Button) findViewById(R.id.mapButton);
		mapButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//Refresh.sendEmptyMessage(1);
				//MainActivity.switcher.showPrevious();
				//setContentView(R.layout.activity_main);
				mCamera.stopPreview();
				startActivity(new Intent(CameraActivity.this, MainActivity.class));
				finish();
			}
		});

		// Create an instance of Camera
		mCamera = getCameraInstance();

		// Create our Preview view and set it as the content of our activity.
		mPreview = new CameraPreview(this, mCamera);
		SurfaceHolder holder = mPreview.getHolder();

		FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
		mCamera.setDisplayOrientation(90);
		preview.addView(mPreview);

		ImageView img = (ImageView) findViewById(R.id.pointer_overlay); // or
																		// (ImageView)
																		// findViewById(R.id.myImageView);
		img.setImageResource(R.drawable.hack_illinois_arrow);
		img.setRotation(180);

		/*
		 * //Create the PointerView and set it as the content of its container.
		 * ImageView imageView = new ImageView(getApplicationContext());
		 * LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,
		 * LayoutParams.WRAP_CONTENT); //String path =
		 * Environment.getExternalStorageDirectory() + "/HackIllinoisArrow.png";
		 * //String path = "HackIllinoisArrow.png";
		 * System.out.println("about to load image"); InputStream is = null; try
		 * { is = getAssets().open("hack_illinois_arrow.png",
		 * AssetManager.ACCESS_STREAMING); } catch (IOException e) { // TODO
		 * Auto-generated catch block
		 * System.out.println("File Doesn't Exist BITCH!!! FTW !"); }
		 * System.out.println("loaded image"); //java.io.FileInputStream in =
		 * openFileInput("HackIllinoisArrow.png");
		 * imageView.setImageBitmap(BitmapFactory.decodeStream(is)); Drawable
		 * arrow = Drawable.createFromStream(is, "hack_illinois_arrow.png");
		 * imageView.setImageDrawable(arrow); //Bitmap image =
		 * BitmapFactory.decodeFile(path); //imageView.setImageBitmap(image);
		 * FrameLayout arrowContainer = (FrameLayout)
		 * findViewById(R.id.pointer_overlay_container);
		 * arrowContainer.addView(imageView, lp);
		 */
	}

	/** A safe way to get an instance of the Camera object. */
	public static Camera getCameraInstance() {
		Camera c = null;
		try {
			c = Camera.open(); // attempt to get a Camera instance
		} catch (Exception e) {
			// Camera is not available (in use or does not exist)
		}
		return c; // returns null if camera is unavailable
	}

	// Refresh handler, necessary for updating the UI in a/the thread
	/*
	Handler Refresh = new Handler() {
		public void handleMessage(Message msg) {

			switch (msg.what) {
			case 1:
				MainActivity.switcher.showPrevious();
				// cam.stopPreview();
				System.out.println("Turning Off Camera");
			default:
				break;
			}
		}
	};*/
}