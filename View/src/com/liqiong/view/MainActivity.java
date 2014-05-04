package com.liqiong.view;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    private  TextView textView;
	private  Button button;
	private  View fragmentView;
    private  int count = 0;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public  class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
        	fragmentView = inflater.inflate(R.layout.fragment_main, container, false);
            

            textView = (TextView)fragmentView.findViewById(R.id.textView);
            textView.setBackgroundColor(Color.CYAN);
//            textView.setText(R.string.hhh);
            textView.setTextColor(Color.RED);
            textView.setTextSize(80);
            
            button = (Button)fragmentView.findViewById(R.id.button);
            
            ButtonListener buttonListener = new ButtonListener();
            button.setOnClickListener(buttonListener);

            return fragmentView;
        }
    }
    
    class ButtonListener implements OnClickListener
    {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			count++;
			textView.setText(count+"");
		}
    	
    }

}
