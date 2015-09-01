
package com.example.android_dp_note;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_dp_note.notemgr.NoteCaretaker;
import com.example.android_dp_note.widgets.NoteEditText;

public class MainActivity extends Activity {

    NoteEditText mNodeEditText;
    TextView mSaveTv;
    ImageView mUndoBtn;
    ImageView mRedoBtn;
    // note备忘录管理器
    NoteCaretaker mCaretaker = new NoteCaretaker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化视图
        initViews();
    }

    private void initViews() {
        mNodeEditText = (NoteEditText) findViewById(R.id.note_edittext);
        mUndoBtn = (ImageView) findViewById(R.id.undo_btn);
        mUndoBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // 返回上一个记录点
                mNodeEditText.restore(mCaretaker.getPrevMemoto());
                makeToast("撤销 : ");
            }
        });

        mRedoBtn = (ImageView) findViewById(R.id.redo_btn);
        mRedoBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // 恢复状态,恢复到下一个记录点
                mNodeEditText.restore(mCaretaker.getNextMemoto());
                makeToast("重做 : ");
            }
        });

        mSaveTv = (TextView) findViewById(R.id.save_btn);
        mSaveTv.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mCaretaker.saveMemoto(mNodeEditText.createMemoto());
                makeToast("保存笔记 : ");
            }
        });
    }

    private void makeToast(String msgPrex) {
        Toast.makeText(this,
                msgPrex + mNodeEditText.getText() + ", 光标位置 : "
                        + mNodeEditText.getSelectionStart(), Toast.LENGTH_LONG).show();
    }
}
