package ya.Sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Rensyu1 extends Activity
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
      tv.setText("�w����{�C");
      bt = new Button(this);
      bt.setText("�ʶR");

      ll.addView(tv);
      ll.addView(bt);
 
      bt.setOnClickListener(new SampleClickListener());
   }
   
   class SampleClickListener implements OnClickListener
   {
      public void onClick(View v)
      {
         bt.setText("Thanks!");
      }
   }  
}
