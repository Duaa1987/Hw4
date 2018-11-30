package com.project.duaa.hw4;


import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerStatusFragment extends Fragment {


    public PlayerStatusFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v1 = inflater.inflate(R.layout.fragment_player_status, container, false);

        final DataBaseHelper myDb;
        Button btnviewAll;
        final TextView Txt_Display;
        //

        myDb = new DataBaseHelper(getActivity());
        btnviewAll=(Button)v1.findViewById(R.id.button_viewAll);
        Txt_Display=(TextView) v1.findViewById(R.id.textView);
       //

        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        String info="";
                        while (res.moveToNext()) {
                            //buffer.append("Id :"+ res.getString(0)+"\n");
                           // buffer.append("Name :"+ res.getString(1)+"\n");
                          //  buffer.append("Gold :"+ res.getString(2)+"\n");
                          //  buffer.append("Marks :"+ res.getString(3)+"\n\n");

                            String id=Integer.toString(res.getInt(res.getColumnIndex(DataBaseHelper.COL_1)));
                            String name=res.getString(res.getColumnIndex(DataBaseHelper.COL_2));
                            String gold=res.getString(res.getColumnIndex(DataBaseHelper.COL_3));
                            String pack=res.getString(res.getColumnIndex(DataBaseHelper.COL_4));
                            info=info+"\n\n"+"ID : "+id+"\nName : "+name+"\nGold : "+gold+"\nPack : "+pack;
                        }
                              Txt_Display.setText(info);
                        // Show all data
                       // showMessage("Data",buffer.toString());

                    }
                }
        );


        return v1;
    }
    private void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}