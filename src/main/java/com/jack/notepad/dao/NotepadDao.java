package com.jack.notepad.dao;

import com.jack.notepad.db.MyBatisHelper;
import com.jack.notepad.inter.INotepad;
import com.jack.notepad.utils.Log;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/12/25.
 */
@Repository
public class NotepadDao {
    private static final String TAG = "NotepadDao";

    /**
     *增加一条笔记记录
     * @param uid
     * @param title
     * @param content
     * @return
     */
    public com.jack.notepad.bean.Notepad addNotepad(int uid, String title, String content) {
        com.jack.notepad.bean.Notepad notepad = new com.jack.notepad.bean.Notepad();
        notepad.setUid(uid);
        notepad.setTitle(title);
        notepad.setContent(content);
        notepad.setCreateTime(System.currentTimeMillis());

        SqlSession session = MyBatisHelper.getSession();
        INotepad mapper = session.getMapper(INotepad.class);
        mapper.addNotepad(notepad);
        session.commit();
        session.close();
        return notepad;
    }

    /**
     * 获取列表
     * @param uid
     * @return
     */
    public List<com.jack.notepad.bean.Notepad> getNotepadList(int uid){
        Log.i(TAG+"getNotepadList");
        SqlSession session = MyBatisHelper.getSession();
        INotepad mapper = session.getMapper(INotepad.class);
        List<com.jack.notepad.bean.Notepad> notepadList = mapper.getNotepadList(uid);
        session.close();
        Log.i(TAG+"getNotepadList 1");
        return notepadList;
    }


}
