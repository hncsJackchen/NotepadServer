package com.jack.notepad.service;

import com.jack.notepad.bean.Notepad;

import java.util.List;

/**
 * Created by Administrator on 2017/1/13.
 */
public interface INotepadService {
    public Notepad addNotepad(int uid, String title, String content);

    public List<Notepad> getNotepadList(int uid);
}
