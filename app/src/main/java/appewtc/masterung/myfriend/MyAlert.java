package appewtc.masterung.myfriend;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by masterUNG on 2/18/2017 AD.
 */

public class MyAlert {

    //Explicit
    private Context context;

    public MyAlert(Context context) {
        this.context = context;
    }

    public void myDialog(String strTitle, String strMessage) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.doremon48);
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();


    }   // myDialog

}   // Main Class
