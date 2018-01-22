package cn.edu.zknu.myserviceapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BindActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnBind,btnUnBind,btnAdd;
    private MyBindService bindService;
    private boolean isBind=false;
    private ServiceConnection serviceConnect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind);
        btnBind=(Button)findViewById(R.id.btn_bind);
        btnUnBind=(Button)findViewById(R.id.btn_unbind);
        btnAdd=(Button)findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(this);
        btnBind.setOnClickListener(this);
        btnUnBind.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bind:
                bind();
                break;
            case R.id.btn_unbind:
                unbind();
                break;
            case R.id.btn_add:
                add();
                break;
        }
    }

    private void bind() {
        Intent intent=new Intent(this,MyBindService.class);
        serviceConnect=new ServiceConnection(){

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                bindService=((MyBindService.MyBinder)service).getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                bindService=null;
            }
        };
        bindService(intent,serviceConnect, Context.BIND_AUTO_CREATE);
        isBind=true;
    }
    private void unbind() {
        if(isBind){
            unbindService(serviceConnect);
            isBind=false;
        }
    }
    private void add() {
        if(isBind){
            if (isBind){
                int result=bindService.add(1,1);
                Toast.makeText(this,""+result,Toast.LENGTH_LONG).show();
            }
        }
    }
}
