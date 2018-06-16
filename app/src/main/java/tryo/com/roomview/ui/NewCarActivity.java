package tryo.com.roomview.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import tryo.com.roomview.R;

public class NewCarActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    private EditText editText;

    public static final int NEW_CAR_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_car);
         editText = findViewById(R.id.edit_word);

         final Button button = findViewById(R.id.button_save);
         button.setOnClickListener((View view) -> {

             Intent replyIntent = new Intent();
             if(TextUtils.isEmpty(editText.getText())){
                 setResult(RESULT_CANCELED, replyIntent);

             } else {
                 String text = editText.getText().toString();
                 replyIntent.putExtra(EXTRA_REPLY, text);
                 setResult(RESULT_OK,replyIntent);
             }
             finish();
         });




    }


}
