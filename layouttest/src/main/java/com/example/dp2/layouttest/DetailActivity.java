package com.example.dp2.layouttest;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.AttendanceItem;
import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.DocumentsItem;
import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.DrawerItem;
import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.DrawerAdapter;
import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.KidItem;
import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.NewsArticleItem;
import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.NewsItem;
import com.example.dp2.layouttest.com.example.dp2.layouttest.lists.SessionItem;
import com.example.dp2.layouttest.fragments.AttendanceFragment;
import com.example.dp2.layouttest.fragments.DocumentsFragment;
import com.example.dp2.layouttest.fragments.KidsFragment;
import com.example.dp2.layouttest.fragments.LoginFragment;
import com.example.dp2.layouttest.fragments.NewsArticleFragment;
import com.example.dp2.layouttest.fragments.NewsFragment;
import com.example.dp2.layouttest.fragments.SessionFragment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;

/**
 * Created by Fernando on 16/09/2015.
 */
public class DetailActivity extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    ActionBarDrawerToggle mDrawerToggle;
    int selectedLayout;

    private FragmentManager.OnBackStackChangedListener backStackListener = new FragmentManager.OnBackStackChangedListener() {
        @Override
        public void onBackStackChanged() {
            setNavIcon();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base);

        ArrayList<Integer> layoutsList = new ArrayList<>();
        ArrayList<DrawerItem> list = new ArrayList<>();
        list.add(new DrawerItem(getResources().getString(R.string.menu_login), android.R.drawable.ic_menu_info_details));
        list.add(new DrawerItem(getResources().getString(R.string.menu_noticias), android.R.drawable.ic_menu_gallery));
        list.add(new DrawerItem(getResources().getString(R.string.menu_sesiones), android.R.drawable.ic_menu_agenda));
        list.add(new DrawerItem(getResources().getString(R.string.menu_documentos), android.R.drawable.ic_menu_view));
        list.add(new DrawerItem(getResources().getString(R.string.menu_blog), android.R.drawable.ic_menu_delete));
        list.add(new DrawerItem(getResources().getString(R.string.menu_pagos), android.R.drawable.ic_menu_my_calendar));
        list.add(new DrawerItem(getResources().getString(R.string.menu_noticias), android.R.drawable.ic_menu_gallery));
        list.add(new DrawerItem("Asistencia", android.R.drawable.ic_menu_agenda));
        list.add(new DrawerItem("Comentarios", android.R.drawable.ic_menu_agenda));

        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerList.setAdapter(new DrawerAdapter(this, list));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,  mDrawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportFragmentManager().addOnBackStackChangedListener(backStackListener);

        selectItem(0, "Login");
    }

    protected void setNavIcon() {
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        mDrawerToggle.setDrawerIndicatorEnabled(backStackEntryCount == 0);
        mDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mDrawerToggle.isDrawerIndicatorEnabled()) {
                    onBackPressed();
                }
            }
        });
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        menu.clear();
        int newMenu;
        switch(selectedLayout){
            case 1: newMenu = R.menu.news_menu_toolbar; break;
            case 3: newMenu = R.menu.docs_menu_toolbar; break;
            case 6: newMenu = R.menu.news_article_menu_toolbar; break;
            default: newMenu = 0; break;
        }
        if(newMenu != 0) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(newMenu, menu);
        }
        return true;
    }

    public void selectItem(int position, CharSequence title){
        Bundle args = null;
        Fragment fragment;
        switch(position){
            default:
                fragment = new LoginFragment();
                break;
            case 1:
                args = new Bundle();
                ArrayList<NewsItem> news = new ArrayList<>();
                Calendar calendar = new GregorianCalendar(2015, 8, 25, 0, 31);
                news.add(new NewsItem(
                        1001,
                        "https://fbcdn-sphotos-a-a.akamaihd.net/hphotos-ak-xat1/v/t1.0-9/13779_10153228555392486_8679903887061635913_n.jpg?oh=00b977b776d2b46e53c88f229bc38250&oe=5668F7B7&__gda__=1453937731_0addbe5c62688f1ca9aa12cef23593eb",
                        "Paseo pinoteco al parque de las leyendas",
                        2001,
                        "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/10392539_10153410963797486_885580920541938912_n.png?oh=f05a7187f83b64568b81f9a023552651&oe=56A5DF4D",
                        "Manuel", calendar.getTime().getTime(), false));
                calendar = new GregorianCalendar(2015, 8, 24, 23, 40);
                news.add(new NewsItem(
                        1002,
                        "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xpf1/v/t1.0-9/11024597_10153107115432486_3774679476823351402_n.jpg?oh=2e13703d43f85c64bde46ce3b0ff4738&oe=5697777F",
                        "Voluntarios accederan a puntajes para becas y viviendas",
                        2001,
                        "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/10392539_10153410963797486_885580920541938912_n.png?oh=f05a7187f83b64568b81f9a023552651&oe=56A5DF4D",
                        "Gabriela", calendar.getTime().getTime(), false));
                calendar = new GregorianCalendar(2015, 8, 21, 15, 22);
                news.add(new NewsItem(
                        1003,
                        "https://fbcdn-sphotos-b-a.akamaihd.net/hphotos-ak-xfa1/v/t1.0-9/11150479_10153215037187486_66126204997766216_n.jpg?oh=efc6181115bfcd36dd12eeda1f2be26d&oe=56A16C75&__gda__=1449207363_cde5ddb130a171ea4e9fc3d09933356b",
                        "Recurso multimedia que utiliza el cuento como motivación inicial, dirigido a niños",
                        2001,
                        "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/10392539_10153410963797486_885580920541938912_n.png?oh=f05a7187f83b64568b81f9a023552651&oe=56A5DF4D",
                        "Yuri", calendar.getTime().getTime(), false));
                args.putSerializable(NewsFragment.NEWS_ARG, news);
                fragment = new NewsFragment();
                break;
            case 2:
                args = new Bundle();
                ArrayList<SessionItem> sessions = new ArrayList<>();
                calendar = new GregorianCalendar(2015, 8, 16, 16, 00);
                sessions.add(new SessionItem("Cerro el Pino", calendar.getTime().getTime()));
                calendar = new GregorianCalendar(2015, 8, 16, 16, 00);
                sessions.add(new SessionItem("Cerro el Pino", calendar.getTime().getTime()));
                calendar = new GregorianCalendar(2015, 8, 16, 16, 00);
                sessions.add(new SessionItem("Cerro el Pino", calendar.getTime().getTime()));
                calendar = new GregorianCalendar(2015, 8, 16, 16, 00);
                sessions.add(new SessionItem("Cerro el Pino", calendar.getTime().getTime()));
                calendar = new GregorianCalendar(2015, 8, 16, 16, 00);
                sessions.add(new SessionItem("Cerro el Pino", calendar.getTime().getTime()));
                Collections.sort(sessions);
                args.putSerializable(SessionFragment.SESSION_ARG, sessions);
                fragment = new SessionFragment();
                break;
            case 3:
                args = new Bundle();
                ArrayList<DocumentsItem> documents = new ArrayList<>();
                calendar = new GregorianCalendar(2015, 8, 22, 15, 21);
                documents.add(new DocumentsItem("Guía de actividades 27/09.pdf", R.drawable.ic_docs_pdf, "254 KB", calendar.getTime().getTime()));
                calendar = new GregorianCalendar(2015, 8, 21, 12, 05);
                documents.add(new DocumentsItem("Materiales para 27/09.xlsx", R.drawable.ic_docs_xls, "1.2 MB", calendar.getTime().getTime()));
                calendar = new GregorianCalendar(2015, 8, 18, 13, 14);
                documents.add(new DocumentsItem("Documento sin ícono", R.drawable.ic_docs_generic, "13 KB", calendar.getTime().getTime()));
                calendar = new GregorianCalendar(2015, 8, 22, 15, 24);
                documents.add(new DocumentsItem("Material extra 27/09.docx", R.drawable.ic_docs_doc, "126 KB", calendar.getTime().getTime()));
                Collections.sort(documents);
                args.putSerializable(DocumentsFragment.DOCUMENTS_ARG, documents);
                fragment = new DocumentsFragment();
                break;
            case 6:
                args = new Bundle();
                calendar = new GregorianCalendar(2015, 8, 25, 0, 37);
                NewsArticleItem article = new NewsArticleItem(
                        1001,
                        "https://fbcdn-sphotos-a-a.akamaihd.net/hphotos-ak-xat1/v/t1.0-9/13779_10153228555392486_8679903887061635913_n.jpg?oh=00b977b776d2b46e53c88f229bc38250&oe=5668F7B7&__gda__=1453937731_0addbe5c62688f1ca9aa12cef23593eb",
                        "Paseo pinoteco al parque de las leyendas",
                        "Manuel", calendar.getTime().getTime(),
                        getResources().getString(R.string.article_example)
                );
                args.putSerializable(NewsArticleFragment.NEWS_ARTICLE_ARG, article);
                fragment = new NewsArticleFragment();
                break;
            case 7:
                args = new Bundle();
                ArrayList<AttendanceItem> volunteers = new ArrayList<>();
                volunteers.add(new AttendanceItem(
                        2001,
                        "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/10392539_10153410963797486_885580920541938912_n.png?oh=f05a7187f83b64568b81f9a023552651&oe=56A5DF4D",
                        "Alonso Alvarez", false));
                volunteers.add(new AttendanceItem(
                        2001,
                        "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/10392539_10153410963797486_885580920541938912_n.png?oh=f05a7187f83b64568b81f9a023552651&oe=56A5DF4D",
                        "Fernando Banda", false));
                volunteers.add(new AttendanceItem(
                        2001,
                        "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/10392539_10153410963797486_885580920541938912_n.png?oh=f05a7187f83b64568b81f9a023552651&oe=56A5DF4D",
                        "Luis Barcena", false));
                volunteers.add(new AttendanceItem(
                        2001,
                        "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/10392539_10153410963797486_885580920541938912_n.png?oh=f05a7187f83b64568b81f9a023552651&oe=56A5DF4D",
                        "Daekef Abarca", false));
                volunteers.add(new AttendanceItem(
                        2001,
                        "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/10392539_10153410963797486_885580920541938912_n.png?oh=f05a7187f83b64568b81f9a023552651&oe=56A5DF4D",
                        "Gloria Cisneros", false));
                volunteers.add(new AttendanceItem(
                        2001,
                        "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/10392539_10153410963797486_885580920541938912_n.png?oh=f05a7187f83b64568b81f9a023552651&oe=56A5DF4D",
                        "Diego Malpartida", false));
                volunteers.add(new AttendanceItem(
                        2001,
                        "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/10392539_10153410963797486_885580920541938912_n.png?oh=f05a7187f83b64568b81f9a023552651&oe=56A5DF4D",
                        "Gabriel Tovar", false));
                volunteers.add(new AttendanceItem(
                        2001,
                        "https://scontent-mia1-1.xx.fbcdn.net/hphotos-xaf1/v/t1.0-9/10392539_10153410963797486_885580920541938912_n.png?oh=f05a7187f83b64568b81f9a023552651&oe=56A5DF4D",
                        "Luis Incio", false));
                Collections.sort(volunteers);
                args.putSerializable(AttendanceFragment.ATTENDANCE_ARG, volunteers);
                fragment = new AttendanceFragment();
                break;
            case 8:
                args = new Bundle();
                ArrayList<KidItem> kids = new ArrayList<>();
                kids.add(new KidItem("Eduardo Arenas", 12, true));
                kids.add(new KidItem("Julio Castillo", 12, false));
                kids.add(new KidItem("Juan Reyes", 12, true));
                kids.add(new KidItem("Kevin Brown", 12, true));
                kids.add(new KidItem("Robert Aduviri", 12, false));
                Collections.sort(kids);
                args.putSerializable(KidsFragment.KIDS_ARG, kids);
                fragment = new KidsFragment();
                break;
        }
        if(args != null) {
            fragment.setArguments(args);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(position < 6){
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        }else{
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack(null).commit();
        }

        mDrawerList.setItemChecked(position, true);
        mDrawerLayout.closeDrawer(mDrawerList);

        if(title != null){
            Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_actionbar);
            toolbar.setTitle(title);
        }
        selectedLayout = position;
        invalidateOptionsMenu();
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position, ((TextView) view.findViewById(R.id.list_item_name)).getText());
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    public String getExternalImagesDir(){
        return "/" + getResources().getString(R.string.app_name) + "/Images";
    }

    public void setImage(ImageView v, String URL, String title){
        String path = Environment.getExternalStorageDirectory() + getExternalImagesDir() + "/" + title;
        File file = new File(path);
        if(file.exists()){
            v.setImageURI(Uri.parse(path));
            Log.d("imgs", "Uri set to ImageView already there: " + path);
        }else{
            AsyncTask task = new DetailActivity.DownloadImageTask(v);
            task.execute(this, URL, path);
            Log.d("imgs", "Task created for:" + title);
        }
    }

    public static class DownloadImageTask extends AsyncTask<Object, Void, String>{
        ImageView view;

        public DownloadImageTask(ImageView view){
            this.view = view;
        }

        @Override
        protected String doInBackground(Object... args){
            DetailActivity activity = (DetailActivity)args[0];
            String url = (String)args[1];
            String path = (String)args[2];

            return activity.downloadImage(url, path);
        }

        @Override
        protected void onPostExecute(String uriResult){
            super.onPostExecute(uriResult);
            if(uriResult != null) {
                Log.d("imgs", "Uri set to ImageView just downloaded: " + uriResult);
                view.setImageURI(Uri.parse(uriResult));
            }
        }
    }

    public String downloadImage(String strUrl, String path){
        try{
            URL url = new URL(strUrl);
            HttpURLConnection urlConn = (HttpURLConnection)url.openConnection();
            urlConn.setRequestMethod("GET");
            urlConn.connect();

            File file = new File(path);
            if(!file.exists()){
                file.createNewFile();
            }
            FileOutputStream os = new FileOutputStream(file);
            InputStream is = urlConn.getInputStream();
            int totalSize = urlConn.getContentLength();
            int downloadedSize = 0;
            byte[] buffer = new byte[1024];
            int bufferLength = 0;
            while ( (bufferLength = is.read(buffer)) > 0 )
            {
                os.write(buffer, 0, bufferLength);
                downloadedSize += bufferLength;
            }
            os.close();
            if(downloadedSize==totalSize){
                return path;
            }
        }catch(IOException e){
        }
        return null;
    }

}
