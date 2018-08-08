package com.example.dpit.beehive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.ListView;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    ListView simpleList;

    private List<Product> hiveList = new ArrayList<>();
    private EditText textNou;
    private EditText numarNou;
    private Button btAdd;
    private ImageView image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), hiveList, R.mipmap.ic_launcher);
        simpleList = (ListView) findViewById(R.id.simpleListView);

        simpleList.setAdapter(customAdapter);
        Button mShowDialog = (Button) findViewById(R.id.add);

        mShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.alertdialog_view, null);
                final EditText mName = (EditText) mView.findViewById(R.id.hiveName);
                final EditText mDate = (EditText) mView.findViewById(R.id.hiveDate);
                Button save = (Button) mView.findViewById(R.id.btnSave);

                prepareProduse(mView);
               customAdapter.notifyDataSetChanged();
                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();

                prepareProduse(mView);
                customAdapter.notifyDataSetChanged();
                dialog.show();

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       // if(!mName.getText().toString().isEmpty() && !mPassword.getText().toString().isEmpty()){
                            Toast.makeText(MainActivity.this,
                                    " bvbv ",
                                    Toast.LENGTH_SHORT).show();

                            dialog.dismiss();
                        //}else{
                            //Toast.makeText(MainActivity.this,
                                 //  "nu ati adaugat nici o nota ",
                                  //  Toast.LENGTH_SHORT).show();
                            //dialog.dismiss();
                        //}
                    }
                });
//
            }
        });
    }

    private void prepareProduse(View convertView) {
        textNou = (EditText) convertView.findViewById(R.id.hiveName);
        numarNou = (EditText) convertView.findViewById(R.id.hiveDate);
        image= (ImageView) convertView.findViewById(R.id.icon);
        btAdd = (Button) convertView.findViewById(R.id.btnSave);
        numarNou.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    addLineToListView();
                }
                return false;
            }
        });


        btAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addLineToListView();
            }
        });

    }

    private void addLineToListView() {
        if (textNou.getText().toString() != null && !"".equals(textNou.getText().toString())) {
            {
                String newItems = textNou.getText().toString();
                String nota= numarNou.getText().toString();
              int poza= image.getImageAlpha();

                Product product = new Product(newItems, nota, poza);
                hiveList.add(product);




            }

        } else {
            Toast.makeText(MainActivity.this, "Denumiti stupul ", Toast.LENGTH_SHORT).show();

        }

    }


}
