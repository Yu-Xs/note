package ya.Sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class Sample12 extends Activity
{
   TextView tv;
	
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      TableLayout tl = new TableLayout(this); 
      setContentView(tl);

      tv = new TextView(this);
      tv.setText("歡迎光臨。");

      tl.addView(tv);
    }
   public boolean onCreateOptionsMenu(Menu menu)
   {
       menu.add(Menu.NONE, 0, 0, "汽車");     
       menu.add(Menu.NONE, 1, 1, "計程車");
       menu.add(Menu.NONE, 2, 2, "戰車");
       menu.add(Menu.NONE, 3, 3, "敞篷車");
       return super.onCreateOptionsMenu(menu);
   }
   public boolean onOptionsItemSelected(MenuItem mi)
   {
      String str = null;
      switch(mi.getItemId())
      {
         case 0:
        	 str = "汽車";
        	 break; 
         case 1:
        	 str = "計程車";
        	 break;   	 
         case 2:
        	 str = "戰車";
        	 break;         	 
         case 3:
        	 str = "敞篷車";
        	 break;  
      }
      tv.setText("是" + str + "對吧。");
      
      return true;   
   }
}
