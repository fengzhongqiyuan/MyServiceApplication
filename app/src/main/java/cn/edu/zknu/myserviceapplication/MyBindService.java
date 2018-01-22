package cn.edu.zknu.myserviceapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class MyBindService extends Service {
    private static final String TAG ="MyBindService" ;
    public MyBindService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.i(TAG,"MyBindService----------->>onBind");
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"MyBindService----------->>onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"MyBindService----------->>onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"MyBindService----------->>onDestroy");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG,"MyBindService----------->>onUnbind");
        return super.onUnbind(intent);
    }
    public class MyBinder extends Binder{
        public MyBindService getService(){
            return MyBindService.this;
        }
    }
    public int add(int a,int b){
        return a+b;
    }
}
