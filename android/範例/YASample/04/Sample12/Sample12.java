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
      tv.setText("�w����{�C");

      tl.addView(tv);
    }
   public boolean onCreateOptionsMenu(Menu menu)
   {
       menu.add(Menu.NONE, 0, 0, "�T��");     
       menu.add(Menu.NONE, 1, 1, "�p�{��");
       menu.add(Menu.NONE, 2, 2, "�Ԩ�");
       menu.add(Menu.NONE, 3, 3, "���O��");
       return super.onCreateOptionsMenu(menu);
   }
   public boolean onOptionsItemSelected(MenuItem mi)
   {
      String str = null;
      switch(mi.getItemId())
      {
         case 0:
        	 str = "�T��";
        	 break; 
         case 1:
        	 str = "�p�{��";
        	 break;   	 
         case 2:
        	 str = "�Ԩ�";
        	 break;         	 
         case 3:
        	 str = "���O��";
        	 break;  
      }
      tv.setText("�O" + str + "��a�C");
      
      return true;   
   }
}
