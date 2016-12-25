package com.jack.notepad.inter;

import com.jack.notepad.bean.Notepad;

import java.util.List;

/**
 * Created by Administrator on 2016/12/25.
 * 笔记记录接口
 */
public interface INotepad {

    /**
     * 插入一条记录
     * @param notepad
     */
    public void addNotepad(Notepad notepad);

    /**
     * 根据用户uid获取对应的列表
     * @param uid
     * @return
     */
    public List<Notepad> getNotepadList(int uid);


}
