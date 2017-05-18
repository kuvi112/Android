package com.example.ongnauvi.bai12_vidutonghop;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    Button btnTT,btnTiep,btnTK;

    ImageButton btnThoat;

    EditText editTen,editSl,editTongKh,editTongKhVip,ediTongTT;

    TextView txtTT;

    CheckBox chkVip;

    DanhSachKhachHang danhsach=new DanhSachKhachHang();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getControls();

        addEvents();
    }

    private void getControls()

    {

        btnTT=(Button) findViewById(R.id.btntinh);

        btnTiep=(Button) findViewById(R.id.btntiep);

        btnTK=(Button) findViewById(R.id.btntk);

        btnThoat=(ImageButton) findViewById(R.id.imthoat);

        editTen=(EditText) findViewById(R.id.edten);

        editSl=(EditText) findViewById(R.id.edsl);

        editTongKh=(EditText) findViewById(R.id.edskh);

        editTongKhVip=(EditText) findViewById(R.id.edsvip);

        ediTongTT=(EditText) findViewById(R.id.eddt);

        txtTT=(TextView) findViewById(R.id.txtthanhtien);

        chkVip =(CheckBox) findViewById(R.id.cbvip);

    }

    private void addEvents()

    {

        btnTT.setOnClickListener(new ProcessMyEvent());

        btnTiep.setOnClickListener(new ProcessMyEvent());

        btnTK.setOnClickListener(new ProcessMyEvent());

        btnThoat.setOnClickListener(new ProcessMyEvent());

    }

    private void doTinhTien()

    {
        KhachHang kh=new KhachHang();

        kh.setTenKh(editTen.getText()+"");

                kh.setSlmua(Integer.parseInt(editSl.getText()+""));

                        kh.setVip(chkVip.isChecked());

        txtTT.setText(kh.tinhThanhTien()+"");

                danhsach.addKhachHang(kh);

    }

    private void doTiep()

    {

        editTen.setText("");

        editSl.setText("");

        txtTT.setText("");

        editTen.requestFocus();

    }

    private void doThongKe()

    {

        editTongKh.setText(danhsach.tongKhachHang()+"");

                editTongKhVip.setText(danhsach.tongKhachHangVip()+"");

                        ediTongTT.setText(danhsach.tongDoanhThu()+"");

    }

    private void doThoat()

    {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        builder.setTitle("hỏi thoát chương trình");
        builder.setMessage("Muốn thoát chương trình này hả?");

        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();

            }

        });

        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                finish();

            }

        });

        builder.create().show();

    }

    private class ProcessMyEvent implements OnClickListener

    {

        @Override

        public void onClick(View arg0) {

            switch(arg0.getId())

            {

                case R.id.btntinh:

                    doTinhTien();

                    break;
                case R.id.btntiep:

                    doTiep();

                    break;

                case R.id.btntk:

                    doThongKe();

                    break;

                case R.id.imthoat:

                    doThoat();

                    break;

            }

        }



    }
}
