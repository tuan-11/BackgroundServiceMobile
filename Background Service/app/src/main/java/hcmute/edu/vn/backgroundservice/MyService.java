package hcmute.edu.vn.backgroundservice;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

public class MyService extends IntentService {
    public MyService(){
        super("my_intent_thread");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Toast.makeText(MyService.this, "service started", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy(){
        Toast.makeText(MyService.this, "service destroyed", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(Intent intent){
        synchronized (this){
            try{
                wait(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
