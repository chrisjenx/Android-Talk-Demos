package com.jenxsol.custom.listview.frags;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jenxsol.custom.listview.R;
import com.mobeta.android.dslv.DragSortController;
import com.mobeta.android.dslv.DragSortListView;
import com.mobeta.android.dslv.DragSortListView.DropListener;
import com.mobeta.android.dslv.DragSortListView.RemoveListener;

public class CustomListViewFragment extends Fragment
{

    private static final String[] initStrings = new String[] { "1. one", "2. two", "3. three",
            "4. four", "5. five", "6. six", "7. seven", "8. eight", "9. nine", "10. ten" };
    private static int mNumberCount = 10;

    private final List<String> mStrings = new ArrayList<String>(mNumberCount);
    private DragSortListView mListView;
    private DragAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_listview, container, false);
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState)
    {
        super.onViewCreated(v, savedInstanceState);
        mListView = (DragSortListView) v.findViewById(android.R.id.list);
        mAdapter = new DragAdapter(mStrings);
        mListView.setAdapter(mAdapter);

        buildController(mListView);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.activity_main, menu);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        initData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_add:
                mNumberCount++;
                final String newNumber = mNumberCount + ". "
                        + EnglishNumberToWords.convert(mNumberCount);

                mAdapter.addItem(newNumber);
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Set up the list view with the controller and defined controls
     * 
     * @param dslv
     * @return
     */
    private DragSortController buildController(DragSortListView dslv)
    {
        // defaults are
        // dragStartMode = onDown
        // removeMode = flingRight
        DragSortController dragCon = new DragSortController(dslv);
        dragCon.setDragHandleId(R.id.list_drag_handle);
        dragCon.setDragInitMode(DragSortController.ON_DRAG);
        dragCon.setRemoveEnabled(true);
        dragCon.setRemoveMode(DragSortController.FLING_LEFT_REMOVE);
        dragCon.setSortEnabled(true);
        dragCon.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
        // Next two are important!!
        dslv.setFloatViewManager(dragCon);
        dslv.setOnTouchListener(dragCon);
        //
        dslv.setDragEnabled(true);
        dslv.setDropListener(onDropListener);
        dslv.setRemoveListener(onRemoveListener);
        return dragCon;
    }

    private void initData()
    {
        for (String s : initStrings)
        {
            addRow(s);
        }
    }

    private void addRow(String newString)
    {
        mAdapter.addItem(newString);
    }

    /**
     * What happens when you drop the item
     */
    private DragSortListView.DropListener onDropListener = new DropListener()
    {

        @Override
        public void drop(int from, int to)
        {
            final String removed = mAdapter.removeItemAt(from);
            mAdapter.addItemAt(removed, to);
        }
    };

    /**
     * Fired when the item is removed from the list view
     */
    private DragSortListView.RemoveListener onRemoveListener = new RemoveListener()
    {

        @Override
        public void remove(int which)
        {
            mAdapter.removeItemAt(which);
        }
    };

    /**
     * Standard custom adapter for the list view
     * 
     * @author chris
     * 
     */
    private class DragAdapter extends BaseAdapter
    {
        private final List<String> mData;
        private final LayoutInflater mInflater;

        public DragAdapter(List<String> data)
        {
            if (data == null)
                mData = new ArrayList<String>(0);
            else
                mData = data;

            mInflater = LayoutInflater.from(getActivity());
        }

        public void addItem(String text)
        {
            mData.add(text);
            notifyDataSetChanged();
        }

        public void addItemAt(String text, int pos)
        {
            mData.add(pos, text);
            notifyDataSetChanged();
        }

        public String removeItemAt(int position)
        {
            final String removed = mData.remove(position);
            notifyDataSetChanged();
            return removed;
        }

        @Override
        public int getCount()
        {
            return mData.size();
        }

        @Override
        public Object getItem(int position)
        {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            final View v;
            if (convertView == null)
            {
                v = mInflater.inflate(R.layout.element_draggable_listitem, parent, false);
            } else
            {
                v = convertView;
            }

            final TextView tv = (TextView) v.findViewById(android.R.id.text1);
            tv.setText(mData.get(position));

            return v;
        }
    }

}
