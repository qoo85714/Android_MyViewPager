package tw.jason.app.helloworld.myviewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private ArrayList<View> views;
    private ViewFlipper flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager)findViewById(R.id.pager);

        initViewPager();
    }

    private void initViewPager(){
        views = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(this);

        View view0 = inflater.inflate(R.layout.page0,null);
        View view1 = inflater.inflate(R.layout.page1,null);
        View view2 = inflater.inflate(R.layout.page2,null);
        View view3 = inflater.inflate(R.layout.page3,null);
        View view4 = inflater.inflate(R.layout.page4,null);

        views.add(view0);
        views.add(view1);views.add(view2);views.add(view3);
        views.add(view4);

        flipper = (ViewFlipper) view2.findViewById(R.id.flipper);
        View f0 = flipper.getChildAt(0);
        View f1 = flipper.getChildAt(1);
        View f2 = flipper.getChildAt(2);
        f0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipper.showNext();
            }
        });



        pager.setAdapter(new MyPagerAdapter());
        pager.setOnPageChangeListener(new MyPagerListener());
        pager.setCurrentItem(1);
    }

    private  class  MyPagerAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = views.get(position);
            pager.addView(view);
            Log.i("brad","now:"+position);
            Log.i("brad","pager child:"+pager.getChildCount());
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
            pager.removeView(views.get(position));
            Log.i("brad","remove:"+position);
            Log.i("brad","pager child:"+pager.getChildCount());
        }


    }
    private class  MyPagerListener extends ViewPager.SimpleOnPageChangeListener{
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            if(position ==0){
                pager.setCurrentItem(1);

            }else if(position ==4){
                pager.setCurrentItem(3);
            }
        }
    }
}
