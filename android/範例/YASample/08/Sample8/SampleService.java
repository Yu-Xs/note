package ya.Sample;

import java.util.*;
import android.app.*;
import android.content.*;
import android.os.*;
import android.widget.*;

public class SampleService extends Service
{
	NotificationManager nm;
	Random r;
 	String[] str = {"您好", "謝謝", "再見", "明天見",
		            "謝謝招待", "精神真好", "請多指教", "真高興"};
	
   public IBinder onBind(Intent it)
   {
      return null; 
   }
   public void onCreate()
   {
   	  nm = (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
   	  
   	  r = new Random();
   }
   public void onStart(Intent it, int id)
   {
      Notification nf = new Notification(R.drawable.icon, "範本",System.currentTimeMillis());
      Intent i = new Intent(this, Sample8.class);
      PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);
      nf.setLatestEventInfo(getApplicationContext(), "範本", "移動到設定畫面。", pi);
      nm.notify(0, nf);
      
      int m  = r.nextInt(str.length);
     
      Toast.makeText(this, str[m], Toast.LENGTH_LONG).show();
   }
   public void onDestroy()
   {
      nm.cancel(0);
   }  
}