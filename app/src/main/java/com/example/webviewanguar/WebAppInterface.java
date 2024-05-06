package com.example.webviewanguar;


import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;

import android.os.Build;
import android.provider.MediaStore;
import android.webkit.JavascriptInterface;
import android.net.Uri;
import android.widget.Toast;


import androidx.core.app.NotificationCompat;


public class WebAppInterface {
    private Activity _activity;
    private Context _context;


    public WebAppInterface(Context context, Activity activity){
        _context = context;
        _activity = activity;
    }
        @JavascriptInterface
        public void showNotification(String title, String message) {
            Toast.makeText(_context, "Title: " + title + "\nMessage: " + message, Toast.LENGTH_SHORT).show();
        }

    @JavascriptInterface
    public void showCall(){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:nomor_telepon"));
        _context.startActivity(intent);
    }

    @JavascriptInterface
    public void showWhatsApp() {
        String phoneNumber = "";
        Uri uri = Uri.parse("https://wa.me/" + phoneNumber);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        _context.startActivity(intent);
    }

    @JavascriptInterface
    public void showCamera() {
        Intent xiaomiCameraIntent = _context.getPackageManager().getLaunchIntentForPackage("com.android.camera");
        if (xiaomiCameraIntent != null) {
            _activity.startActivityForResult(xiaomiCameraIntent, 0);
        } else {
            Intent defaultCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            _activity.startActivityForResult(defaultCameraIntent, 0);
        }
    }
}