package com.app.vdlasov.tinkoffschool.ui.model;

/**
 * Created by Denis on 31.03.2017.
 */

public class MessageUiItem implements UiItem {

    private String author;

    private String message;

    private String date;

    private int layoutId;

    public MessageUiItem(String author, String message, String date, int layoutId) {
        this.author = author;
        this.message = message;
        this.date = date;
        this.layoutId = layoutId;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    @Override
    public int getLayoutId() {
        return layoutId;
    }
}
