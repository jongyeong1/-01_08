package com.project08team.mirero_diary.entries.diary;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.project08team.mirero_diary.R;
import com.project08team.mirero_diary.shared.gui.CommonDialogFragment;

/**
 *
 */

public class ClearDialogFragment extends CommonDialogFragment {


    /**
     * Callback
     */
    public interface ClearDialogCallback {
        void onClear();
    }

    private ClearDialogCallback callback;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        try {
            callback = (ClearDialogCallback) getTargetFragment();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        this.getDialog().setCanceledOnTouchOutside(true);
        super.onViewCreated(view, savedInstanceState);
        this.TV_common_content.setText(getString(R.string.diary_clear_message));
    }

    @Override
    protected void okButtonEvent() {
        callback.onClear();
        dismiss();
    }

    @Override
    protected void cancelButtonEvent() {
        dismiss();
    }
}
