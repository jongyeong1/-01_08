package com.project08team.mirero_diary.entries;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.project08team.mirero_diary.R;
import com.project08team.mirero_diary.shared.gui.CommonDialogFragment;

/**
 *
 */

public class EditDiaryBackDialogFragment extends CommonDialogFragment {


    /**
     * Callback
     */
    public interface BackDialogCallback {
        void onBack();
    }

    private BackDialogCallback callback;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        callback = (BackDialogCallback) getTargetFragment();
        this.getDialog().setCanceledOnTouchOutside(true);
        super.onViewCreated(view, savedInstanceState);
        this.TV_common_content.setText(getString(R.string.diary_back_message));
    }

    @Override
    protected void okButtonEvent() {
        callback.onBack();
        dismiss();
    }

    @Override
    protected void cancelButtonEvent() {
        dismiss();
    }
}
