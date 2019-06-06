package com.example.doitvoca;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class WordListActivity extends AppCompatActivity {
    static boolean calledAlready = false;
    int Check_num=0;
    private ListView m_oListView=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);
/*        if (!calledAlready)
        {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true); // 다른 인스턴스보다 먼저 실행되어야 한다.
            calledAlready = true;
            Log.i("태그","연결됐다");
        }*/

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseRef = database.getReference("wordlist");

        m_oListView = (ListView)findViewById(R.id.listView);
        ArrayList<Word> oData = new ArrayList<>();
        ListAdapter oAdapter = new ListAdapter(oData);
        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            //단어장 listview 파이어베이스 연동
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Word> oData = new ArrayList<>();
                for (DataSnapshot fileSnapshot : dataSnapshot.getChildren()) {
                    Word oItem = new Word();
                    oItem.EnglishInput=fileSnapshot.child("EnglishInput").getValue(String.class);
                    oItem.MeaningInput=fileSnapshot.child("MeaningInput").getValue(String.class);
                    oData.add(oItem);
                }
                ListAdapter oAdapter = new ListAdapter(oData);
                m_oListView.setAdapter(oAdapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG: ", "Failed to read value", databaseError.toException());
            }
        });
        View footer = getLayoutInflater().inflate(R.layout.wordlist_footer,null,false);
        m_oListView.addFooterView(footer);

    }
    // 암기/비암기 버튼 이벤트
    public void ChangeState(View view) {
        if(Check_num ==0){
            view.setSelected(true);
            Check_num =1;
        }
        else{
            view.setSelected(false);
            Check_num =0;
        }
    }
    // 단어장의 '추가'버튼 이벤트
    public void AddWord(View view) {
        Intent intent = new Intent(WordListActivity.this, Addword.class);
        startActivity(intent);
    }


}
