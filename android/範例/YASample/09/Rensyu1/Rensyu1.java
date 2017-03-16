package ya.Sample;

import java.util.*;
import android.app.*;
import android.appwidget.*;
import android.content.*;
import android.graphics.*;
import android.os.Bundle;
import android.widget.*;

public class Rensyu1 extends AppWidgetProvider
{
   String filter = "ya.Sample.09_Rensyu1.CLICK";
 
   public void onUpdate(Context cn, AppWidgetManager am, int[] ids)
   {
      RemoteViews rv = new RemoteViews(cn.getPackageName(), R.layout.widget);

      rv.setTextViewText(R.id.SampleTextView, "招呼");
      rv.setTextColor(R.id.SampleTextView, Color.BLACK);
      am.updateAppWidget(ids, rv);
      
      for(int i=0; i<ids.length; i++)
      {
         Intent it = new Intent(filter);
         it.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, ids[i]);
         PendingIntent pi = PendingIntent.getBroadcast(cn, ids[i], it, 0);
         rv.setOnClickPendingIntent(R.id.SampleTextView, pi);
      }
      am.updateAppWidget(ids, rv);
   }
   public void onReceive(Context cn, Intent it)
   {
      super.onReceive(cn, it);
      String ac = it.getAction();
	  if(ac.equals(filter))
	  {
         Bundle ex = it.getExtras();
         int id = ex.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID);
		  
         RemoteViews rv = new RemoteViews(cn.getPackageName(),R.layout.widget);

         int f = 0;
         Random r = new Random();
         f = r.nextInt(4);
         String str = "招呼";
         int c = 0;
         switch(f)
         {
            case 0:
               str = "早安";
               c = Color.RED; 
               break;
            case 1:
                str = "您好";
                c = Color.BLUE;
                break;
            case 2: 	
                str = "我很好";
                c = Color.GREEN;
                break; 
            case 3: 	
                str = "不錯喔";
                c = Color.BLACK;
                break; 
          }
         
         rv.setTextViewText(R.id.SampleTextView, str);
         rv.setTextColor(R.id.SampleTextView, c);
         AppWidgetManager am = AppWidgetManager.getInstance(cn);
         am.updateAppWidget(id, rv);
      }
   }
}
