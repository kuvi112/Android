package com.example.ongnauvi.thongtincanhan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText edten, edcmnd, edbs;
    CheckBox bao, sach, coding;
    Button gui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edten = (EditText)findViewById(R.id.dtten);
        edcmnd = (EditText)findViewById(R.id.dtcmnd);
        edbs = (EditText)findViewById(R.id.dtbs);
        bao = (CheckBox)findViewById(R.id.checkbao);
        sach = (CheckBox)findViewById(R.id.checksach);
        coding = (CheckBox)findViewById(R.id.checkcoding);
        gui = (Button)findViewById(R.id.btngui);
        gui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });

    }
    public void show()
    {
        //Kiểm tra tên hợp lệ
        String ten = edten.getText()+"";
        ten = ten.trim();
        if(ten.length()<3)
        {
            edten.requestFocus();
            edten.selectAll();
            Toast.makeText(this, "Tên phải >= 3 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        //kiểm tra CMND hợp lệ
        String cmnd = edcmnd.getText()+"";
        cmnd=cmnd.trim();
        if(cmnd.length()!=9)
        {
            edcmnd.requestFocus();
            edcmnd.selectAll();
            Toast.makeText(this, "CMND phải đúng 9 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        //Kiểm tra bằng cấp
        String bang="";
        RadioGroup group=(RadioGroup) findViewById(R.id.rgrbangcap);
        int id=group.getCheckedRadioButtonId();
        if(id==-1)
        {
            Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_LONG).show();
            return;
        }
        RadioButton rad=(RadioButton) findViewById(id);
        bang=rad.getText()+"";
        //Kiểm tra sở thích
        String sothich="";
        if(bao.isChecked())
            sothich+=bao.getText()+"\n";
        if(sach.isChecked())
            sothich+=sach.getText()+"\n";
        if(coding.isChecked())
            sothich+=coding.getText()+"\n";
        String bosung=edbs.getText()+"";
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
// TODO Auto-generated method stub
                dialog.cancel();
            }
        });
//tạo nội dung
        String msg=ten+"\n";
        msg+=cmnd+"\n";
        msg+=bang+"\n";
        msg+=sothich;
        msg+="—————————–\n";
        msg+="Thông tin bổ sung:\n";
        msg+=bosung+ "\n";
        msg+="—————————–";
        builder.setMessage(msg);//thiết lập nội dung
        builder.create().show();//hiển thị Dialog
    }


}
