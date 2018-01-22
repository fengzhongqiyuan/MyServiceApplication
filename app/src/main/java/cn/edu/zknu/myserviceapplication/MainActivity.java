package cn.edu.zknu.myserviceapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnStartService,btnBindService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService=(Button)findViewById(R.id.btn_startService);
        btnBindService=(Button)findViewById(R.id.btn_bindService);
        btnStartService.setOnClickListener(this);
        btnBindService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_startService:
                start();
                break;
            case R.id.btn_bindService:
                bind();
                break;
        }
    }

    private void start() {
        startActivity(new Intent(this,StartActivity.class));
    }
    private void bind(){
        startActivity(new Intent(this,BindActivity.class));
    }
}
