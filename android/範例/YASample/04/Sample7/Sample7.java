package ya.Sample;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;

public class Sample7 extends Activity
{
   TextView tv;
   ListView lv;
	
   public void onCreate(Bundle savedInstanceState)
   {
	  super.onCreate(savedInstanceState);
      LinearLayout ll = new LinearLayout(this); 
      ll.setOrientation(LinearLayout.VERTICAL);
      setContentView(ll);
      
      tv = new TextView(this);
      tv.setText("歡迎光臨。");
            
      lv = new ListView(this);
      String[] str = {"汽車","卡車","敞篷車",
    		          "計程車","跑車","金龜車",
    		          "腳踏車","三輪車","摩托車",
    		          "飛機","直升機","火箭"};
      ArrayAdapter<String> ad = new ArrayAdapter<String>
            (this, android.R.layout.simple_list_item_1, str);
      lv.setAdapter(ad);
      
      ll.addView(tv);
      ll.addView(lv);
      
      lv.setOnItemClickListener(new SampleItemClickListener());
   }
   class SampleItemClickListener implements OnItemClickListener
   {
      public void onItemClick(AdapterView<?>v, View iv, int pos, long id)
      {
         TextView tmp = (TextView) iv;
         tv.setText("是" + tmp.getText() + "對吧。");
      }
   }
}
