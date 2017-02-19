package appewtc.masterung.myfriend;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.speech.tts.Voice;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by Administrator on 19/2/2560.
 */

public class AddnewUser extends AsyncTask<Void,Void,String>{
    private Context context;
    private static final String urlphp = "http://swiftcodingthai.com/19feb/addUserklod.php";
    private String nameString,userString,passString, imageString;

    public AddnewUser(Context context, String nameString, String userString, String passString, String imageString) {
        this.context = context;
        this.nameString = nameString;
        this.userString = userString;
        this.passString = passString;
        this.imageString = imageString;
    }

    @Override
    protected String doInBackground(Void... voids) {

        try{

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("name", nameString)
                    .add("User", userString)
                    .add("Password", passString)
                    .add("Image", imageString)
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlphp).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();



        }catch (Exception e){
            Log.d("19febV1", "e doin ==>" + e.toString());
            return null;
        }


    }
}//Main Class
