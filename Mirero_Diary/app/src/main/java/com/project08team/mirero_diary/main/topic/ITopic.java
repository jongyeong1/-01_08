package com.project08team.mirero_diary.main.topic;

import android.support.annotation.DrawableRes;

/**
 *
 */

public interface ITopic {

    /**
     * Mitsuha and Taki write daily diary when their soul change.
     */
    int TYPE_DIARY = 1;

    /**
     * Mitsuha and Taki add some memo to notice that something can't do.
     */
    int TYPE_MEMO = 2;

    String getTitle();

    /**
     * For update topic
     */
    void setTitle(String title);

    int getType();

    long getId();

    @DrawableRes
    int getIcon();

    /**
     * For update count in Main Page
     */
    void setCount(long count);

    long getCount();

    int getColor();

    /**
     * For update topic
     */
    void setColor(int color);

    /**
     * For the left swipe
     */

    void setPinned(boolean pinned);

    boolean isPinned();
}
