package com.jack.notepad.service;

import com.jack.notepad.bean.Notepad;
import com.jack.notepad.dao.NotepadDao;
import com.jack.notepad.dao.UserDao;
import com.jack.notepad.utils.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/25.
 */
@Service
public class NotepadService {
    private static final String TAG = "NotepadService ";
    //自动初始化一个实例
    @Autowired
    NotepadDao notepadDao;


    /**
     * 增加一条笔记记录
     * @param uid
     * @param title
     * @param content
     * @return
     */
    public Notepad addNotepad(int uid,String title,String content) {
        Notepad notepad = notepadDao.addNotepad(uid,title,content);
        return notepad;
    }

    /**
     * 获取列表
     * @param uid
     * @return
     */
    public List<Notepad> getNotepadList(int uid) {
        Log.i(TAG+"getNotepadList");
        List<Notepad> notepadList = notepadDao.getNotepadList(uid);
        return notepadList;
    }



}
