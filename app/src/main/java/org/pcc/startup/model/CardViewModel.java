package org.pcc.startup.model;

import java.util.ArrayList;

/**
 * Created by ptyagi on 7/4/17.
 */

public class CardViewModel {
    int mId;
    String title;
    String description;
    String href;
    String codeTag = "executeDefiningFunctions1";

    public String getCodeTag() {
        return codeTag;
    }

    public void setCodeTag(String codeTag) {
        this.codeTag = codeTag;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }


    ArrayList<CardViewModel> mChildren = new ArrayList<CardViewModel>();

    public CardViewModel(int mId, String title, String description, ArrayList<CardViewModel> mChildren) {
        this.mId = mId;
        this.title = title;
        this.description = description;
        this.mChildren = mChildren;
    }

    public CardViewModel(int mId, String title, String description) {
        this.mId = mId;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<CardViewModel> getChildren() {
        return mChildren;
    }
}
