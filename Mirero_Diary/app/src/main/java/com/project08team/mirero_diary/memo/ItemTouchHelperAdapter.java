package com.project08team.mirero_diary.memo;

/**
 *
 */

public interface ItemTouchHelperAdapter {

    void onItemMove(int fromPosition, int toPosition);

    void onItemSwap(int position);

    void onItemMoveFinish();

}
