package com.tuananh.restaurant.manager.database;

import android.content.Context;
import android.database.Cursor;

import com.tuananh.databasehelper.queryhelper.QueryHelper;
import com.tuananh.restaurant.manager.data.Constants;
import com.tuananh.restaurant.manager.model.board.Board;
import com.tuananh.restaurant.manager.model.board.GroupBoard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by framgia on 04/05/2017.
 */
public class DatabaseManager implements DatabaseInterface {
    private static DatabaseManager sInstance;
    private Context mContext;

    private DatabaseManager(Context context) {
        mContext = context;
    }

    public static synchronized DatabaseManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseManager(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public List<Board> getBoardAllByIdGroupBoard(int idGroupBoard) {
        List<Board> boardList = new ArrayList<>();
        QueryHelper queryHelper = new QueryHelper();
        queryHelper.setTableName(DBConstant.TABLE_BOARD)
            .addCondition(DBConstant.KEY_FOR_ID_GROUP_BOARD, idGroupBoard);
        Cursor cursor = DBHelper.getInstance(mContext).query(queryHelper);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Board board = new Board(
                    cursor.getInt(cursor.getColumnIndex(Constants.KEY_ID_BOARD)),
                    cursor.getInt(cursor.getColumnIndex(Constants.KEY_FOR_ID_GROUP_BOARD)),
                    cursor.getString(cursor.getColumnIndex(Constants.KEY_NAME_BOARD)),
                    cursor.getInt(cursor.getColumnIndex(Constants.KEY_IS_SAVE))
                );
                boardList.add(board);
            } while (cursor.moveToNext());
        }
        return boardList;
    }

    @Override
    public List<GroupBoard> getGroupBoardAll() {
        List<GroupBoard> groupBoardList = new ArrayList<>();
        QueryHelper queryHelper = new QueryHelper();
        queryHelper.setTableName(DBConstant.TABLE_GROUP_BOARD);
        Cursor cursor = DBHelper.getInstance(mContext).query(queryHelper);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                GroupBoard groupBoard =
                    new GroupBoard(
                        cursor.getInt(cursor.getColumnIndex(Constants.KEY_ID_GROUP_BOARD)),
                        cursor.getString(cursor.getColumnIndex(Constants.KEY_NAME_GROUP_BOARD))
                    );
                groupBoardList.add(groupBoard);
            } while (cursor.moveToNext());
        }
        return groupBoardList;
    }
}
