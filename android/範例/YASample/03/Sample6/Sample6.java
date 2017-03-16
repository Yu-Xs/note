package ya.Sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Sample6 extends Activity
{
   TextView tv;
	
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);
      
      tv = new TextView(this);
      tv.setText("�w����{�C");

      ll.addView(tv);
   }
   public boolean onTouchEvent(MotionEvent e)
   {
      if(e.getAction() == MotionEvent.ACTION_DOWN)
      {
         tv.setText("�z�n");
      }
      else if(e.getAction() == MotionEvent.ACTION_UP)
      {
         tv.setText("�A��");
      }
      return true;
   }
}
