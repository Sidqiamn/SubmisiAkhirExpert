package com.example.core.data;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class NewsDao_Impl implements NewsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<NewsEntity> __insertionAdapterOfNewsEntity;

  private final EntityDeletionOrUpdateAdapter<NewsEntity> __updateAdapterOfNewsEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public NewsDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNewsEntity = new EntityInsertionAdapter<NewsEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `news` (`title`,`summary`,`penyelenggara`,`time`,`quota`,`link`,`deskripsi`,`publishedAt`,`urlToImage`,`url`,`bookmarked`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NewsEntity entity) {
        statement.bindString(1, entity.getTitle());
        statement.bindString(2, entity.getSummary());
        statement.bindString(3, entity.getPenyelenggaraAcara());
        statement.bindString(4, entity.getWaktu());
        statement.bindLong(5, entity.getQuota());
        statement.bindString(6, entity.getLink());
        statement.bindString(7, entity.getDesckripsi());
        statement.bindString(8, entity.getPublishedAt());
        if (entity.getUrlToImage() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getUrlToImage());
        }
        if (entity.getUrl() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getUrl());
        }
        final int _tmp = entity.isBookmarked() ? 1 : 0;
        statement.bindLong(11, _tmp);
      }
    };
    this.__updateAdapterOfNewsEntity = new EntityDeletionOrUpdateAdapter<NewsEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `news` SET `title` = ?,`summary` = ?,`penyelenggara` = ?,`time` = ?,`quota` = ?,`link` = ?,`deskripsi` = ?,`publishedAt` = ?,`urlToImage` = ?,`url` = ?,`bookmarked` = ? WHERE `title` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final NewsEntity entity) {
        statement.bindString(1, entity.getTitle());
        statement.bindString(2, entity.getSummary());
        statement.bindString(3, entity.getPenyelenggaraAcara());
        statement.bindString(4, entity.getWaktu());
        statement.bindLong(5, entity.getQuota());
        statement.bindString(6, entity.getLink());
        statement.bindString(7, entity.getDesckripsi());
        statement.bindString(8, entity.getPublishedAt());
        if (entity.getUrlToImage() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getUrlToImage());
        }
        if (entity.getUrl() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getUrl());
        }
        final int _tmp = entity.isBookmarked() ? 1 : 0;
        statement.bindLong(11, _tmp);
        statement.bindString(12, entity.getTitle());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM news WHERE bookmarked = 0";
        return _query;
      }
    };
  }

  @Override
  public Object insertNews(final List<NewsEntity> news,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfNewsEntity.insert(news);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateNews(final NewsEntity news, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfNewsEntity.handle(news);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<NewsEntity>> getNews() {
    final String _sql = "SELECT * FROM news ORDER BY publishedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"news"}, new Callable<List<NewsEntity>>() {
      @Override
      @NonNull
      public List<NewsEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfSummary = CursorUtil.getColumnIndexOrThrow(_cursor, "summary");
          final int _cursorIndexOfPenyelenggaraAcara = CursorUtil.getColumnIndexOrThrow(_cursor, "penyelenggara");
          final int _cursorIndexOfWaktu = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfQuota = CursorUtil.getColumnIndexOrThrow(_cursor, "quota");
          final int _cursorIndexOfLink = CursorUtil.getColumnIndexOrThrow(_cursor, "link");
          final int _cursorIndexOfDesckripsi = CursorUtil.getColumnIndexOrThrow(_cursor, "deskripsi");
          final int _cursorIndexOfPublishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "publishedAt");
          final int _cursorIndexOfUrlToImage = CursorUtil.getColumnIndexOrThrow(_cursor, "urlToImage");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(_cursor, "bookmarked");
          final List<NewsEntity> _result = new ArrayList<NewsEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final NewsEntity _item;
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpSummary;
            _tmpSummary = _cursor.getString(_cursorIndexOfSummary);
            final String _tmpPenyelenggaraAcara;
            _tmpPenyelenggaraAcara = _cursor.getString(_cursorIndexOfPenyelenggaraAcara);
            final String _tmpWaktu;
            _tmpWaktu = _cursor.getString(_cursorIndexOfWaktu);
            final int _tmpQuota;
            _tmpQuota = _cursor.getInt(_cursorIndexOfQuota);
            final String _tmpLink;
            _tmpLink = _cursor.getString(_cursorIndexOfLink);
            final String _tmpDesckripsi;
            _tmpDesckripsi = _cursor.getString(_cursorIndexOfDesckripsi);
            final String _tmpPublishedAt;
            _tmpPublishedAt = _cursor.getString(_cursorIndexOfPublishedAt);
            final String _tmpUrlToImage;
            if (_cursor.isNull(_cursorIndexOfUrlToImage)) {
              _tmpUrlToImage = null;
            } else {
              _tmpUrlToImage = _cursor.getString(_cursorIndexOfUrlToImage);
            }
            final String _tmpUrl;
            if (_cursor.isNull(_cursorIndexOfUrl)) {
              _tmpUrl = null;
            } else {
              _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            }
            final boolean _tmpIsBookmarked;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsBookmarked);
            _tmpIsBookmarked = _tmp != 0;
            _item = new NewsEntity(_tmpTitle,_tmpSummary,_tmpPenyelenggaraAcara,_tmpWaktu,_tmpQuota,_tmpLink,_tmpDesckripsi,_tmpPublishedAt,_tmpUrlToImage,_tmpUrl,_tmpIsBookmarked);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<NewsEntity>> getBookmarkedNews() {
    final String _sql = "SELECT * FROM news WHERE bookmarked = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"news"}, new Callable<List<NewsEntity>>() {
      @Override
      @NonNull
      public List<NewsEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfSummary = CursorUtil.getColumnIndexOrThrow(_cursor, "summary");
          final int _cursorIndexOfPenyelenggaraAcara = CursorUtil.getColumnIndexOrThrow(_cursor, "penyelenggara");
          final int _cursorIndexOfWaktu = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfQuota = CursorUtil.getColumnIndexOrThrow(_cursor, "quota");
          final int _cursorIndexOfLink = CursorUtil.getColumnIndexOrThrow(_cursor, "link");
          final int _cursorIndexOfDesckripsi = CursorUtil.getColumnIndexOrThrow(_cursor, "deskripsi");
          final int _cursorIndexOfPublishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "publishedAt");
          final int _cursorIndexOfUrlToImage = CursorUtil.getColumnIndexOrThrow(_cursor, "urlToImage");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(_cursor, "bookmarked");
          final List<NewsEntity> _result = new ArrayList<NewsEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final NewsEntity _item;
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpSummary;
            _tmpSummary = _cursor.getString(_cursorIndexOfSummary);
            final String _tmpPenyelenggaraAcara;
            _tmpPenyelenggaraAcara = _cursor.getString(_cursorIndexOfPenyelenggaraAcara);
            final String _tmpWaktu;
            _tmpWaktu = _cursor.getString(_cursorIndexOfWaktu);
            final int _tmpQuota;
            _tmpQuota = _cursor.getInt(_cursorIndexOfQuota);
            final String _tmpLink;
            _tmpLink = _cursor.getString(_cursorIndexOfLink);
            final String _tmpDesckripsi;
            _tmpDesckripsi = _cursor.getString(_cursorIndexOfDesckripsi);
            final String _tmpPublishedAt;
            _tmpPublishedAt = _cursor.getString(_cursorIndexOfPublishedAt);
            final String _tmpUrlToImage;
            if (_cursor.isNull(_cursorIndexOfUrlToImage)) {
              _tmpUrlToImage = null;
            } else {
              _tmpUrlToImage = _cursor.getString(_cursorIndexOfUrlToImage);
            }
            final String _tmpUrl;
            if (_cursor.isNull(_cursorIndexOfUrl)) {
              _tmpUrl = null;
            } else {
              _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            }
            final boolean _tmpIsBookmarked;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsBookmarked);
            _tmpIsBookmarked = _tmp != 0;
            _item = new NewsEntity(_tmpTitle,_tmpSummary,_tmpPenyelenggaraAcara,_tmpWaktu,_tmpQuota,_tmpLink,_tmpDesckripsi,_tmpPublishedAt,_tmpUrlToImage,_tmpUrl,_tmpIsBookmarked);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
