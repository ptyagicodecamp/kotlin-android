package org.pcc.startup.model;

import java.util.ArrayList;

/**
 * Created by ptyagi on 7/4/17.
 */

public class CardViewModel {
    int rowId;
    String title;
    String description;
    String codeHref;
    String codeTag;
    String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getCodeTag() {
        return codeTag;
    }

    public void setCodeTag(String codeTag) {
        this.codeTag = codeTag;
    }

    public String getCodeHref() {
        return codeHref;
    }

    public void setCodeHref(String codeHref) {
        this.codeHref = codeHref;
    }


    ArrayList<CardViewModel> children = new ArrayList<CardViewModel>();

    public CardViewModel() {}

    public CardViewModel(int rowId, String title, String description, ArrayList<CardViewModel> children) {
        this.rowId = rowId;
        this.title = title;
        this.description = description;
        this.children = children;
    }

    public CardViewModel(int rowId, String title, String description) {
        this.rowId = rowId;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return rowId;
    }

    public void setId(int id) {
        this.rowId = id;
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
        return children;
    }
}
