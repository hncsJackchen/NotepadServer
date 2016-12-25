package com.jack.notepad.controller;

import com.alibaba.fastjson.JSON;
import com.jack.notepad.bean.Notepad;
import com.jack.notepad.response.Response;
import com.jack.notepad.service.NotepadService;
import com.jack.notepad.utils.CommUtils;
import com.jack.notepad.utils.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2016/12/25.
 * 笔记记录控制器
 */
@RestController
@RequestMapping("/notepad")
public class NotepadController {

    /**
     * 增加一条笔记记录
     * @param uid 用户id
     * @param title 标题
     * @param content 内容
     * @return
     */
    @RequestMapping("/add")
    public String addNotepad(String uid,String title,String content){
        //参数是否合法
        if (CommUtils.isBlank(uid)) {
            return JSON.toJSONString(Response.writeResult(Response.STATUS_ERROR, "参数不能为空:参数 uid="+uid, null));
        }

        int id = 0;
        try {
            id = Integer.valueOf(uid);
        }catch (Exception e){
            Log.e("参数转化异常：" + e);
            return JSON.toJSONString(Response.writeResult(Response.STATUS_ERROR, "非法参数 uid="+uid+",参数必须为数字", null));
        }

        if (CommUtils.isBlank(title)) {
            return JSON.toJSONString(Response.writeResult(Response.STATUS_ERROR, "参数不能为空:参数 title="+title, null));
        }

        if (CommUtils.isBlank(content)) {
            return JSON.toJSONString(Response.writeResult(Response.STATUS_ERROR, "参数不能为空:参数 content="+content, null));
        }

        Notepad notepad = notepadService.addNotepad(id, title, content);
        return JSON.toJSONString(Response.writeResult(Response.STATUS_SUCCESS, "添加笔记记录成功", notepad));
    }

    @Autowired
    NotepadService notepadService;

    /**
     * 获取列表
     * @param uid 用户id
     * @return
     */
    @RequestMapping(value = "/getList")
    public String  getNotepadList(String uid){
        //参数是否合法
        if (CommUtils.isBlank(uid)) {
            return JSON.toJSONString(Response.writeResult(Response.STATUS_ERROR, "参数不能为空:参数 uid="+uid, null));
        }

        int id = 0;
        try {
            id = Integer.valueOf(uid);
        }catch (Exception e){
            return JSON.toJSONString(Response.writeResult(Response.STATUS_ERROR, "非法参数 uid="+uid+",参数必须为数字，Exception:"+e, null));
        }

        List<Notepad> notepadList = notepadService.getNotepadList(id);
        return JSON.toJSONString(Response.writeResult(Response.STATUS_SUCCESS, "请求笔记记录成功", notepadList));
    }



}
