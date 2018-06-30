package com.example.zain.chatapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.zain.chatapplication.Common.Common;
import com.example.zain.chatapplication.Fragments.ChatFragment;
import com.example.zain.chatapplication.Fragments.ContactsFragment;
import com.example.zain.chatapplication.Fragments.StatusFragment;
import com.example.zain.chatapplication.Model.ChatItem;
import com.example.zain.chatapplication.Model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public static List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        toolbar.setTitle("CHAT APP");
        setSupportActionBar(toolbar);

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.session), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        editor.putBoolean(getString(R.string.isAuth), true);
        // Change later
        Common.isAuthenticated = true;
        Common.user = new User("Zain", "7205929025");
        Common.user.isAuthenticated = true;

        setupViewPager();

        tabLayout.setupWithViewPager(viewPager);
        AsyncTaskRunner runner = new AsyncTaskRunner();
        runner.execute();
    }

    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChatFragment(), "CHATS");
        adapter.addFragment(new StatusFragment(), "STATUS");
        adapter.addFragment(new ContactsFragment(), "CONTACTS");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    //AND " + ContactsContract.CommonDataKinds.Phone.IN_VISIBLE_GROUP + "'=1'"
    private List<User> getContacts() {
        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        List<String> list = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        while (phones.moveToNext())
        {
            String name=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            list.add(phoneNumber);
            if (Collections.binarySearch(list, phoneNumber) > 0) {
                userList.add(new User(name, phoneNumber));
            }
        }
        phones.close();
//        Set<User> uniqueUser = new HashSet<>(userList);
//
//        List<User> newList = new ArrayList<>(uniqueUser);
//        Collections.sort(newList, new Comparator<User>() {
//
//            public int compare(User o1, User o2) {
//                return o2.getPhoneNo().compareTo(o1.getPhoneNo());
//            }
//        });
        return userList;
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp;

        @Override
        protected String doInBackground(String... params) {
            try {
                users = getContacts();
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }
    }
}

