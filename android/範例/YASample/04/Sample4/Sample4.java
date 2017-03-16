package ya.Sample;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.widget.CompoundButton.*;

public class Sample4 extends Activity
{
   TextView tv;
   CheckBox cb1, cb2;
	
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);
      
      tv = new TextView(this);
      tv.setText("歡迎光臨。");
 
      cb1 = new CheckBox(this);
      cb2 = new CheckBox(this);
      cb1.setText("汽車");
      cb2.setText("卡車");
      
      ll.addView(tv);
      ll.addView(cb1);
      ll.addView(cb2);
      
      cb1.setOnCheckedChangeListener(new SampleCheckedChangeListener());
      cb2.setOnCheckedChangeListener(new SampleCheckedChangeListener());
   }
   class SampleCheckedChangeListener implements OnCheckedChangeListener
   {
      public void onCheckedChanged(CompoundButton cb, boolean isChecked)
      {
         if(isChecked == true)
         {
            tv.setText("我要買" + cb.getText() + "。");
         }
         else if(isChecked == false)
         {
            tv.setText("我不買" + cb.getText() + "了。");
         }         
      }
   }  
}
