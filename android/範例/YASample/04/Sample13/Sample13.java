package ya.Sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample13 extends Activity
{
   TextView tv;
   Button bt;
	
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);
      
      tv = new TextView(this);
      tv.setText("歡迎光臨。");
      bt = new Button(this);
      bt.setText("購買");

      ll.addView(tv);
      ll.addView(bt);
 
      bt.setOnClickListener(new SampleClickListener());
   }
   class SampleClickListener implements OnClickListener
   {
      public void onClick(View v)
      {
         new AlertDialog.Builder(Sample13.this)
             .setTitle("購買")
             .setMessage("謝謝惠顧。")
             .setPositiveButton("OK", null).show();
      }
   }  
}
