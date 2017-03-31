package com.app.vdlasov.tinkoffschool.ui.model;

import com.app.vdlasov.tinkoffschool.R;

/**
 * Created by Denis on 31.03.2017.
 */

public class MessageItem implements UiItem {
    private String author;
    private String message;
    private String date;

    private int layoutId;

    public MessageItem(final String author, final String message, final String date, int layoutId) {
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
