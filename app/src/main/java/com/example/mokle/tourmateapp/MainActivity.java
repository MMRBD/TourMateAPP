package com.example.mokle.tourmateapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mvc.imagepicker.ImagePicker;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    ImageView imgView;
    TextView textView;
    EditText etxFullName, etxEmail, etxUserName, etxPassword, etxContactNo, etxAddress;
    Button btnLogin, btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImagePicker.setMinQuality(600, 600);

        imgView = (ImageView) findViewById(R.id.imageView);


        textView = (TextView) findViewById(R.id.textView);

        etxFullName = (EditText) findViewById(R.id.etx_fullname);
        etxEmail = (EditText) findViewById(R.id.etx_email);
        etxUserName = (EditText) findViewById(R.id.etx_username);
        etxPassword = (EditText) findViewById(R.id.etx_password);
        etxContactNo = (EditText) findViewById(R.id.etx_contact);
        etxAddress = (EditText) findViewById(R.id.etx_address);

        btnLogin = (Button) findViewById(R.id.btn_login);
        btnReg = (Button) findViewById(R.id.btn_reg);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byte[] imageInByte = null;
                Bitmap bitmap = ((BitmapDrawable) imgView.getDrawable()).getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                if(bitmap != null) {
                    imageInByte = stream.toByteArray();
                }
                String fullName = etxFullName.getText().toString();
                String email = etxEmail.getText().toString();
                String userName = etxUserName.getText().toString();
                String pass = etxPassword.getText().toString();
                String contact = etxContactNo.getText().toString();
                String address = etxAddress.getText().toString();

                if(imageInByte.equals(null) || fullName.equals("") || email.equals("") || userName.equals("") || pass.equals("") || contact.equals("") || address.equals("")){
                    Toast.makeText(MainActivity.this, "PLEASE FILL THE ALL INFORMATION", Toast.LENGTH_SHORT).show();
                }else {

                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap bitmap = ImagePicker.getImageFromResult(this, requestCode, resultCode, data);

        if (bitmap != null) {
            imgView.setImageBitmap(bitmap);
        }
        InputStream is = ImagePicker.getInputStreamFromResult(this, requestCode, resultCode, data);
        if (is != null) {
            textView.setText("Got input stream!");
            try {
                is.close();
            } catch (IOException ex) {
                // ignore
            }
        } else {
            textView.setText("Failed to get input stream!");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onPickImage(View view) {
        // Click on image button
        ImagePicker.pickImage(this, "Select your image:");
    }
}
