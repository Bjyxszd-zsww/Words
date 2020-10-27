package com.example.words;

import android.app.Activity;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Word[] words;
    ListView myListView;
    ArrayAdapter<String> adapter;
    Array list;
    String afterMeaning = "";
    String afterExample = "";
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创MyDataBaseHelper对象（params1：上下文环境，params2：数据库名，params3：允许我们在查询数据的时候返回一个cursor，这里添null，就可以了，params4：数据库版本号）
        dbHelper = new MyDatabaseHelper(MainActivity.this);


        //初始化设置三个单词
        list = new Array(1);
        Word animal = new Word();
        animal.setWord("animal");
        animal.setMeaning("动物、动物的");
        animal.setExample("The horse is an animal!");
        Word cat = new Word();
        cat.setWord("cat");
        cat.setMeaning("猫");
        cat.setExample("This is a cat!");
        Word dog = new Word();
        dog.setWord("dog");
        dog.setMeaning("狗");
        dog.setExample("This is a dog!");
        Word lion = new Word();
        lion.setWord("lion");
        lion.setMeaning("狮子");
        lion.setExample("This is a lion!");
        Word monkey = new Word();
        monkey.setWord("monkey");
        monkey.setMeaning("猴子");
        monkey.setExample("孙悟空 is a monkey!");
        Word giraffe= new Word();
        giraffe.setWord("giraffe");
        giraffe.setMeaning("长颈鹿");
        giraffe.setExample("The giraffe's legs are very long!");
        Word tiger = new Word();
        tiger.setWord("tiger");
        tiger.setMeaning("老虎");
        tiger.setExample("This is a tiger!");
        Word bear = new Word();
        bear.setWord("bear");
        bear.setMeaning("熊");
        bear.setExample("This is a bear!");
//        Word hippo = new Word();
//        hippo.setWord("hippo");
//        hippo.setMeaning("河马");
//        hippo.setExample("This is a hippo!");
//        Word rabbit = new Word();
//        rabbit.setWord("rabbit");
//        rabbit.setMeaning("兔子");
//        rabbit.setExample("This is a rabbit!");
//        Word elephant = new Word();
//        elephant.setWord("elephant");
//        elephant.setMeaning("大象");
//        elephant.setExample("This is a elephant!");

        list.add(0, animal);
        list.add(1, cat);
        list.add(2,dog);
        list.add(3,lion);
        list.add(4,monkey);
        list.add(5,giraffe);
        list.add(6,tiger);
        list.add(7,bear);
//        list.add(8,hippo);
//        list.add(9,rabbit);
//        list.add(10,elephant);

        //创建SQLiteDatabase的对象
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //创建ContentValues对象，又来添加数据
        ContentValues values = new ContentValues();
        values.put("word",animal.getWord());
        values.put("meaning", animal.getMeaning());
        values.put("example", animal.getExample());
        //插入数据（param1 :表名，param2：在未指定的数据的情况下赋值为空，params3：值）
        db.insert("words",null,values);
        values.put("word",cat.getWord());
        values.put("meaning", cat.getMeaning());
        values.put("example", cat.getExample());
        //插入数据（param1 :表名，param2：在未指定的数据的情况下赋值为空，params3：值）
        db.insert("words",null,values);
        values.put("word",dog.getWord());
        values.put("meaning", dog.getMeaning());
        values.put("example", dog.getExample());
        //插入数据（param1 :表名，param2：在未指定的数据的情况下赋值为空，params3：值）
        db.insert("words",null,values);
        values.put("word",lion.getWord());
        values.put("meaning", lion.getMeaning());
        values.put("example", lion.getExample());
        //插入数据（param1 :表名，param2：在未指定的数据的情况下赋值为空，params3：值）
        db.insert("words",null,values);
        values.put("word",monkey.getWord());
        values.put("meaning", monkey.getMeaning());
        values.put("example", monkey.getExample());
        //插入数据（param1 :表名，param2：在未指定的数据的情况下赋值为空，params3：值）
        db.insert("words",null,values);
        values.put("word",giraffe.getWord());
        values.put("meaning", giraffe.getMeaning());
        values.put("example", giraffe.getExample());
        //插入数据（param1 :表名，param2：在未指定的数据的情况下赋值为空，params3：值）
        db.insert("words",null,values);
        values.put("word",tiger.getWord());
        values.put("meaning", tiger.getMeaning());
        values.put("example", tiger.getExample());
        //插入数据（param1 :表名，param2：在未指定的数据的情况下赋值为空，params3：值）
        db.insert("words",null,values);
        values.put("word",bear.getWord());
        values.put("meaning", bear.getMeaning());
        values.put("example", bear.getExample());
        //插入数据（param1 :表名，param2：在未指定的数据的情况下赋值为空，params3：值）
        db.insert("words",null,values);
//        values.put("word",hippo.getWord());
//        values.put("meaning", hippo.getMeaning());
//        values.put("example", hippo.getExample());
//        //插入数据（param1 :表名，param2：在未指定的数据的情况下赋值为空，params3：值）
//        db.insert("words",null,values);
//        values.put("word",rabbit.getWord());
//        values.put("meaning", rabbit.getMeaning());
//        values.put("example", rabbit.getExample());
//        //插入数据（param1 :表名，param2：在未指定的数据的情况下赋值为空，params3：值）
//        db.insert("words",null,values);
//        values.put("word",elephant.getWord());
//        values.put("meaning", elephant.getMeaning());
//        values.put("example", elephant.getExample());
//        //插入数据（param1 :表名，param2：在未指定的数据的情况下赋值为空，params3：值）
//        db.insert("words",null,values);
        words = new Word[list.getSize()];
        words = list.getData();
        for(int i = 0; i < words.length; i++) {
            Log.d("output:", words[i].getWord());
            Log.d("output:", words[i].getMeaning());
            Log.d("output:", words[i].getExample());
        }

        ClickList(words);
        addWords();
        //感知横屏状态
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            Intent intent = new Intent(MainActivity.this,showWord_land.class);
            startActivity(intent);

        }
    }
    public void addWords(){
        //添加按钮事件
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final LayoutInflater inflater = getLayoutInflater();
                final View v1 = inflater.inflate(R.layout.add_words, null);
                builder.setView(v1).setTitle("添加单词").setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText word = v1.findViewById(R.id.addWord);
                        EditText meaning = v1.findViewById(R.id.addMeaning);
                        EditText example = v1.findViewById(R.id.addExample);
                        String word_inList = word.getText().toString();
                        String meaning_inList = meaning.getText().toString();
                        String example_inList = example.getText().toString();
                        Word newWord = new Word();
                        if(word_inList != ""){
                            newWord.setWord(word_inList);
                            newWord.setMeaning(meaning_inList);
                            newWord.setExample(example_inList);
                        }

                        //创建SQLiteDatabase的对象
                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        //创建ContentValues对象，又来添加数据
                        ContentValues values = new ContentValues();
                        values.put("word",newWord.getWord());
                        values.put("meaning", newWord.getMeaning());
                        values.put("example", newWord.getExample());
                        //插入数据（param1 :表名，param2：在未指定的数据的情况下赋值为空，params3：值）
                        db.insert("words",null,values);

                        list.add(words.length, newWord);
                        words = list.getData();
                        Word[] update = new Word[words.length];
                        int length = 0;
                        for(int j = 0; j < update.length; j++){
                            if(words[j] != null){
                                length++;
                                update[j] = words[j];
                            }
                        }
                        words = new Word[length];
                        for(int j = 0; j < length; j++){
                            words[j] = update[j];
                        }
                        ClickList(words);
                    }
                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }


    //单词列表listView
    public void ClickList(final Word[] data){
        //data：目前列表的单词表（显示）
        int length = 0;

        for(int i = 0; i < data.length; i++){
            if(data[i] == null)
                break;
            length++;

        }
        final String[] wordShow = new String[length];
        for(int i = 0; i < wordShow.length; i++){
            wordShow[i] = data[i].getWord();
            Log.d("wordShow:", wordShow[i]);
        }
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, wordShow);
        myListView = (ListView)findViewById(R.id.wordList);
        //Log.d("wordList:", adapter.getItem(0));
        myListView.setAdapter(adapter);
        //Log.d("", "成功！！！！！！！！！！！！！！！！！！！！");
        //点击查看&修改
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                showWord(position);
                SQLiteDatabase dbUpdate =dbHelper.getWritableDatabase();
                ContentValues values1 = new ContentValues();
                values1.put("meaning",words[position].getMeaning());
                dbUpdate.update("words",values1,"meaning = ?",new String[]{words[position].getMeaning()});
                values1.put("example",words[position].getExample());
                dbUpdate.update("words",values1,"example = ?",new String[]{words[position].getExample()});
            }
        });

        //长按删除
        myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder delete_builder = new AlertDialog.Builder(MainActivity.this);
                final LayoutInflater inflater2 = getLayoutInflater();
                final View delete_view = inflater2.inflate(R.layout.delete_word, null);
                delete_builder.setView(delete_view).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SQLiteDatabase dbDelete = dbHelper.getWritableDatabase();
                        dbDelete.delete("words","word = ?",new String[] {words[position].getWord()});
                        list.remove(position);
                        words = list.getData();
                        final String[] wordShow = new String[words.length];
                        for(int i = 0; i < words.length; i++){
                            if(words[i] == null)
                                break;
                            wordShow[i] = words[i].getWord();
                        }
                        for(int i = 0; i < wordShow.length; i++){
                            if(wordShow[i] == null)
                                break;
                            Log.d("!wordShow:", wordShow[i]);
                        }
                        ClickList(words);
                        addWords();


                    }
                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                delete_builder.show();
                return true;
            }
        });

    }

    public void showWord(final int position){
        Intent intent = new Intent(MainActivity.this, showWord.class);
        Bundle bundleSimple = new Bundle();
        bundleSimple.putString("word", words[position].getWord());
        bundleSimple.putString("meaning", words[position].getMeaning());
        bundleSimple.putString("example", words[position].getExample());
        intent.putExtras(bundleSimple);
        startActivity(intent);
    }
//
//
//    public void addWords(){
//        //添加按钮事件
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                final LayoutInflater inflater = getLayoutInflater();
//                final View v1 = inflater.inflate(R.layout.add_words, null);
//                builder.setView(v1).setTitle("添加单词").setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        EditText word = v1.findViewById(R.id.addWord);
//                        EditText meaning = v1.findViewById(R.id.addMeaning);
//                        EditText example = v1.findViewById(R.id.addExample);
//                        String word_inList = word.getText().toString();
//                        String meaning_inList = meaning.getText().toString();
//                        String example_inList = example.getText().toString();
//                        Word newWord = new Word();
//                        if(word_inList != ""){
//                            newWord.setWord(word_inList);
//                            newWord.setMeaning(meaning_inList);
//                            newWord.setExample(example_inList);
//                        }
//
//                        //创建SQLiteDatabase的对象
//                        SQLiteDatabase db = dbHelper.getWritableDatabase();
//                        //创建ContentValues对象，又来添加数据
//                        ContentValues values = new ContentValues();
//                        values.put("word",newWord.getWord());
//                        values.put("meaning", newWord.getMeaning());
//                        values.put("example", newWord.getExample());
//                        //插入数据（param1 :表名，param2：在未指定的数据的情况下赋值为空，params3：值）
//                        db.insert("words",null,values);
//
//                        list.add(words.length, newWord);
//                        words = list.getData();
//                        Word[] update = new Word[words.length];
//                        int length = 0;
//                        for(int j = 0; j < update.length; j++){
//                            if(words[j] != null){
//                                length++;
//                                update[j] = words[j];
//                            }
//                        }
//                        words = new Word[length];
//                        for(int j = 0; j < length; j++){
//                            words[j] = update[j];
//                        }
//                        ClickList(words);
//                    }
//                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
//                builder.show();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//
//    }
//

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.wordBook:
                ClickList(words);
                addWords();
                break;
            case R.id.search:
                AlertDialog.Builder searchBuilder = new AlertDialog.Builder(MainActivity.this);
                final LayoutInflater searchInflater = getLayoutInflater();
                final View searchView = searchInflater.inflate(R.layout.search_dialog, null);
                searchBuilder.setView(searchView).setTitle("单词查询").setPositiveButton(R.string.search, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //setContentView(R.layout.activity_main);
                        EditText searchWord = searchView.findViewById(R.id.searchWord);
                        String input = searchWord.getText().toString();
                        Word[] afterSearchWord = suit(input, words);
                        ClickList(afterSearchWord);
                    }
                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                searchBuilder.show();
                break;
            case R.id.newWordBook:
                //setContentView(R.layout.word_book);
                Intent intent = new Intent(MainActivity.this, WordBook.class);
                Bundle bundleSimple = new Bundle();
                bundleSimple.putString("word", "giraffe");
                bundleSimple.putString("meaning", "长颈鹿");
                bundleSimple.putString("example", "The giraffe's legs are very long!");
                intent.putExtras(bundleSimple);

                startActivity(intent);
                break;
//            case R.id.news:
//                setContentView(R.layout.news_view);
//                WebView webView = (WebView)findViewById(R.id.web_view);
//                webView.getSettings().setJavaScriptEnabled(true);
//                webView.setWebViewClient(new WebViewClient());
//                webView.loadUrl("http://www.baidu.com");
//                break;
            case R.id.help:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final LayoutInflater inflater = getLayoutInflater();
                final View v1 = inflater.inflate(R.layout.help_dialog, null);
                builder.setView(v1).setTitle("帮助");
                builder.show();
                break;
        }
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    //字符串匹配
    public static Word[] suit(String input, Word[] a) {
        Word[] afterSearch = new Word[10];
        int num = 0;
        char[] search = input.toCharArray();
        int[] suited = new int[a.length];
        //System.out.println("input length:" + search.length);
        for(int k = 0; k < a.length; k++) {
            char[] word = a[k].getWord().toCharArray();
            suited[k] = 0;
            for(int i = 0; i < search.length; i++) {
                for(int j = i; j < word.length; j++) {
                    //System.out.println("search[" + i + "]:" + search[i]);
                    //System.out.println("word[" + j + "]:" + word[j]);
                    if(search[i] == word[j]) {
                        suited[k]++;
                        //System.out.println("suit" + i + ":" + suited[i]);
                        break;
                    }
                }
            }
        }
        for(int i = 0; i < a.length; i++) {
            //System.out.println("suit" + i + ":" + suited[i]);
            if(suited[i] >= 3)
                afterSearch[num++] = a[i];
        }
        return afterSearch;
    }
}
