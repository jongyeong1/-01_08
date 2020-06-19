package com.project08team.mirero_diary.entries.entries;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.project08team.mirero_diary.R;
import com.project08team.mirero_diary.db.DBManager;
import com.project08team.mirero_diary.shared.FileManager;
import com.project08team.mirero_diary.shared.gui.CommonDialogFragment;

import java.io.IOException;

import static org.apache.commons.io.FileUtils.deleteDirectory;

/**
 *
 */

public class DiaryDeleteDialogFragment extends CommonDialogFragment {

    private DeleteCallback callback;

    /**
     * Callback
     */
    public interface DeleteCallback {
        void onDiaryDelete();
    }

    private long diaryId;
    private long topicId;

    public static DiaryDeleteDialogFragment newInstance(long topicId, long diaryId) {
        Bundle args = new Bundle();
        DiaryDeleteDialogFragment fragment = new DiaryDeleteDialogFragment();
        args.putLong("topicId", topicId);
        args.putLong("diaryId", diaryId);
        fragment.setArguments(args);
        return fragment;
    }

    private void deleteDiary() {
        //Delete the db
        DBManager dbManager = new DBManager(getActivity());
        dbManager.opeDB();
        dbManager.delDiary(diaryId);
        dbManager.closeDB();
        //Delete photo data
        try {
            deleteDirectory(new FileManager(getActivity(), topicId, diaryId).getDir());
        } catch (IOException e) {
            //just do nothing
            e.printStackTrace();
        }

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        callback = (DeleteCallback) getTargetFragment();
        this.getDialog().setCanceledOnTouchOutside(false);
        super.onViewCreated(view, savedInstanceState);
        topicId = getArguments().getLong("topicId", -1L);
        diaryId = getArguments().getLong("diaryId", -1L);
        this.TV_common_content.setText(getString(R.string.entries_edit_dialog_delete_content));
    }

    @Override
    protected void okButtonEvent() {
        if (diaryId != -1) {
            deleteDiary();
            this.callback.onDiaryDelete();
        }
        dismiss();
    }

    @Override
    protected void cancelButtonEvent() {
        dismiss();
    }
}
