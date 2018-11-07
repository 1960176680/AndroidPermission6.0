package com.example.administrator.androidpermission60;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    PermissionApply apply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apply = new PermissionApply(this);
        ImageView img1 = findViewById(R.id.imageView);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apply.requestPhonePermission(new PermissionApply.OnPermissResponse() {
                    @Override
                    public void onPermissionSuccess() {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:10086"));
                        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(callIntent);
                    }
                });
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        apply.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }
}
