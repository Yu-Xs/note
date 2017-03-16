package ya.Sample;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class Sample14 extends Activity
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
         AlertDialog.Builder db 
            = new AlertDialog.Builder(Sample14.this);
         db.setTitle("�T�{");
         db.setMessage("�u���n�R�ܡH");
         db.setPositiveButton("�n", new SampleDialogClickListener());
         db.setNegativeButton("���n", null).show();
      }
      class SampleDialogClickListener implements DialogInterface.OnClickListener
      {
         public void onClick(DialogInterface d, int w)
         {
            new AlertDialog.Builder(Sample14.this)
                 .setTitle("�ʶR")
                 .setMessage("���´f�U�C")
                 .setPositiveButton("OK", null).show();
         } 
      }
   }  
}
