package ya.Sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample6 extends Activity
{
   TextView tv;
   EditText et;
	
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);
      
      tv = new TextView(this);
      tv.setText("歡迎光臨。");

      et = new EditText(this);

      ll.addView(tv);
      ll.addView(et);
      
      et.setOnKeyListener(new SampleKeyListener());
   }
   class SampleKeyListener implements OnKeyListener
   {
      public boolean onKey(View v, int keycode, KeyEvent e)
      {
         EditText tmp = (EditText) v;
         tv.setText("是" + tmp.getText() + "對吧。");

         return true;
      }
   }  
}
