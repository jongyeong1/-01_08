package com.project08team.mirero_diary.shared.gui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;

import com.project08team.mirero_diary.R;
import com.project08team.mirero_diary.shared.ColorTools;
import com.project08team.mirero_diary.shared.ScreenHelper;
import com.project08team.mirero_diary.shared.ThemeManager;

/**
 *
 */

public class mirero_diaryButton extends Button {


    public mirero_diaryButton(Context context) {
        super(context);
    }

    public mirero_diaryButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public mirero_diaryButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public mirero_diaryButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.setAllCaps(false);
        this.setBackground(ThemeManager.getInstance().getButtonBgDrawable(getContext()));
        this.setTextColor(ColorTools.getColorStateList(getContext(), R.color.button_default_text_color));
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            this.setStateListAnimator(null);
        }
        this.setMinimumWidth(ScreenHelper.dpToPixel(getContext().getResources(), 80));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

}
