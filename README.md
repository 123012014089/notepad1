#Notepad
1.添加时间
2.添加搜索

一丶添加时间
在noteslist_item.xml添加一个Textview用来显示时间
<TextView xmlns:android="http://schemas.android.com/apk/res/android"
            android:id="@android:id/text2"
            android:layout_marginLeft="20dp"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textAppearance="?android:attr/textAppearanceLarge"
            android:gravity="center_vertical"
            android:paddingLeft="7dip"
            android:textSize="25dp"
            />
然后，用Time获取时间戳并转化成系统时间
在NotePadProvide进行更改
代码更改如下
将Long new=Long.valueOf(System.currentTimeMillis());
if (values.containsKey(NotePad.Notes.COLUMN_NAME_CREATE_DATE) == false) {
            values.put(NotePad.Notes.COLUMN_NAME_CREATE_DATE, now);
        }
        if (values.containsKey(NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE) == false) {
            values.put(NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE,now);
        }
改为：
         if (values.containsKey(NotePad.Notes.COLUMN_NAME_CREATE_DATE) == false) {
            values.put(NotePad.Notes.COLUMN_NAME_CREATE_DATE, Time.getTodayTimeStampString());
        }
        if (values.containsKey(NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE) == false) {
            values.put(NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE,Time.getTodayTimeStampString());
        }
二丶添加搜索
建立一个search.xml，添加search控件
<SearchView
            android:id="@+id/searchView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:iconifiedByDefault="false"
            android:queryHint="请输入搜索内容" />
            
 在Notelist中初始化控件，添加方法，关键代码
  Cursor cursor = managedQuery(
                            getIntent().getData(),            
                            PROJECTION,                       
                            NotePad.Notes.COLUMN_NAME_TITLE+ " LIKE '%"+newText+"%' ",                            
                            null,                             
                            NotePad.Notes.DEFAULT_SORT_ORDER  
                    );
  
  
  展示
  ![](https://github.com/123012014089/notepad1/blob/master/NotePad-master/images/XG%24TTD~Y(%7B%7DEM8HJGX356_G.png)
