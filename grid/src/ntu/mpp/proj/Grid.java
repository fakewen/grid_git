package ntu.mpp.proj;

import java.util.ArrayList;
import java.util.HashMap;



import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class Grid extends Activity {
	private GridView Calendar;
	private SimpleAdapter listItemAdapter;
	private ArrayList<HashMap<String, Object>> listItem;
	private int[] TextViewID;
	final String day[]={"","早上","中午","下午"};
	final String count[]={"Mon","5","2","4",
			"Tue","6","3","10",
			"Wed","7","2","4",
			"Thu","6","4","3",
			"Fri","5","3","6",
			"Sat","1","4","6",
			"Sun","4","6","3",
			};
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid);
		girdview();
		Calendar.setNumColumns(4);
		for(int i = 0 ; i<4 ; i++){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ItemText", day[i]);
            listItem.add(map);  
		}
		for(int i = 0 ; i<count.length ; i++){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ItemText", count[i]);
            listItem.add(map);  
		}
		Calendar.setAdapter(listItemAdapter);
	}  
	private void girdview(){
		Calendar = (GridView) findViewById(R.id.gridView1);
		TextViewID = new int[] { R.id.ItemText};
		listItem = new ArrayList<HashMap<String, Object>>();  
        listItemAdapter = new SimpleAdapter(this,listItem,R.layout.items,  
                new String[] {"ItemText"},TextViewID);
	}

}
