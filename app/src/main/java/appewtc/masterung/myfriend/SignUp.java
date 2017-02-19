package appewtc.masterung.myfriend;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SignUp extends AppCompatActivity {

    //Explicit
    private EditText nameEditText, userEditText, passEditText;
    private ImageView imageView;
    private Button button;
    private String nameString, userString, passString,pathImageString,nameImageString;

    private Uri uri;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Bind Widget
        bindWidget();

        //Button Controller
        buttonController();

        //Image Controller
        imageController();


    }   // Main Method


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            //Success Choose Image
            Log.d("18febV1", "Result OK");

            //Choose Image Show
            uri = data.getData();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                imageView.setImageBitmap(bitmap);



            } catch (Exception e) {
                e.printStackTrace();
            }

            //Find image path
            String[] strings = new String[]{MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(uri,strings,null,null,null);
            if (cursor !=null) {
                cursor.moveToFirst();
                int index = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
                pathImageString = cursor.getString(index);
            } else {
                pathImageString = uri.getPath();
            }
            Log.d("19feb1","pathImage ==>" + pathImageString);





        }   //if

    }   // onActivity

    private void imageController() {

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Move to Choose Image
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "โปรเลือก แอฟเลือกรูป"), 1);

            }   // onClick
        });

    }   // imageController

    private void buttonController() {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get Value from Edit Text
                nameString = nameEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passString = passEditText.getText().toString().trim();

                //Check Space
                if (nameString.length() == 0 ||
                        userString.length() == 0 ||
                        passString.length() == 0) {
                    Log.d("18febV1", "Have Space");
                    MyAlert myAlert = new MyAlert(SignUp.this);
                    myAlert.myDialog("Have Space", "Please Fill All Every Blank");

                }

            }   // onClick
        });

    }   // buttonController

    private void bindWidget() {

        nameEditText = (EditText) findViewById(R.id.editText);
        userEditText = (EditText) findViewById(R.id.editText2);
        passEditText = (EditText) findViewById(R.id.editText3);
        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button3);

    }

}   // Main Class
