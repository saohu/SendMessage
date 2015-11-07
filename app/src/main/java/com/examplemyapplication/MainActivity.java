package com.examplemyapplication;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class MainActivity extends ActionBarActivity {
    private ArrayList<String> mItems;
    private IndexableListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mItems = new ArrayList<String>();
        mItems.add("123456");
        mItems.add("A");
        mItems.add("B"); mItems.add("C");
        mItems.add("D"); mItems.add("E");
        mItems.add("F"); mItems.add("G");
        mItems.add("E"); mItems.add("H");
        mItems.add("E"); mItems.add("I");
        mItems.add("E"); mItems.add("TT");
        mItems.add("E"); mItems.add("C");
        mItems.add("E"); mItems.add("");
        mItems.add("E"); mItems.add("D");
        mItems.add("E");

        Collections.sort(mItems);
        ContentAdapter adapter = new ContentAdapter(this,android.R.layout.simple_list_item_1,mItems );
        mListView = (IndexableListView)findViewById(R.id.listView);
        mListView.setFastScrollEnabled(true);


    }
    private class ContentAdapter extends ArrayAdapter implements SectionIndexer{

        private String mSections = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        public ContentAdapter(Context context, int resource, List objects) {
            super(context, resource, objects);
        }


        @Override
        public Object[] getSections() {
            String[] sections = new String[mSections.length()];
            for (int i = 0;i<mSections.length();i++){
                sections[i] = String.valueOf(mSections.charAt(i));
            }
            return sections;
        }

        @Override
        public int getPositionForSection(int sectionIndex) {
            //从当前位置往前茶
            for (int i = sectionIndex;i>=0;i++){
                for (int j = 0;j<getCount();j++){
                    if (i==0){
                                for (int k = 0;k<=9;k++){
                                    if (StringMatcher.match(String.valueOf(String.valueOf(getItem(j ).charAt(0))),String.valueOf(k)));{
                                        return j;
                                    }
                                }
                    }else {
                        if (StringMatcher.match(String.valueOf(getItem(j).charAt(0)),String.valueOf(mSections.charAt(i))));

                    }
                }
            }
            return 0;
        }

        @Override
        public int getSectionForPosition(int position) {
            return 0;
        }
    }
}
