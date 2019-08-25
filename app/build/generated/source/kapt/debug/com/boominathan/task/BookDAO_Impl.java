package com.boominathan.task;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class BookDAO_Impl implements BookDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BookEntity> __insertionAdapterOfBookEntity;

  private final EntityDeletionOrUpdateAdapter<BookEntity> __deletionAdapterOfBookEntity;

  public BookDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBookEntity = new EntityInsertionAdapter<BookEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `BookEntity` (`productId`,`ProductImage`,`ProductName`,`ProductPrice`,`ProductRatings`,`ProductMerchant`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BookEntity value) {
        stmt.bindLong(1, value.getProductId());
        if (value.getProductImage() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProductImage());
        }
        if (value.getProductName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getProductName());
        }
        if (value.getProductPrice() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getProductPrice());
        }
        if (value.getProductRatings() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getProductRatings());
        }
        if (value.getProductMerchant() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getProductMerchant());
        }
      }
    };
    this.__deletionAdapterOfBookEntity = new EntityDeletionOrUpdateAdapter<BookEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `BookEntity` WHERE `productId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BookEntity value) {
        stmt.bindLong(1, value.getProductId());
      }
    };
  }

  @Override
  public void saveBooks(final BookEntity book) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBookEntity.insert(book);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteRecord(final BookEntity book) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfBookEntity.handle(book);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<BookEntity> getAllBooks() {
    final String _sql = "Select * from BookEntity ORDER BY productId DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "productId");
      final int _cursorIndexOfProductImage = CursorUtil.getColumnIndexOrThrow(_cursor, "ProductImage");
      final int _cursorIndexOfProductName = CursorUtil.getColumnIndexOrThrow(_cursor, "ProductName");
      final int _cursorIndexOfProductPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "ProductPrice");
      final int _cursorIndexOfProductRatings = CursorUtil.getColumnIndexOrThrow(_cursor, "ProductRatings");
      final int _cursorIndexOfProductMerchant = CursorUtil.getColumnIndexOrThrow(_cursor, "ProductMerchant");
      final List<BookEntity> _result = new ArrayList<BookEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BookEntity _item;
        _item = new BookEntity();
        final int _tmpProductId;
        _tmpProductId = _cursor.getInt(_cursorIndexOfProductId);
        _item.setProductId(_tmpProductId);
        final String _tmpProductImage;
        _tmpProductImage = _cursor.getString(_cursorIndexOfProductImage);
        _item.setProductImage(_tmpProductImage);
        final String _tmpProductName;
        _tmpProductName = _cursor.getString(_cursorIndexOfProductName);
        _item.setProductName(_tmpProductName);
        final String _tmpProductPrice;
        _tmpProductPrice = _cursor.getString(_cursorIndexOfProductPrice);
        _item.setProductPrice(_tmpProductPrice);
        final String _tmpProductRatings;
        _tmpProductRatings = _cursor.getString(_cursorIndexOfProductRatings);
        _item.setProductRatings(_tmpProductRatings);
        final String _tmpProductMerchant;
        _tmpProductMerchant = _cursor.getString(_cursorIndexOfProductMerchant);
        _item.setProductMerchant(_tmpProductMerchant);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<BookEntity> searchRecord(final String merchant) {
    final String _sql = "SELECT * FROM BookEntity WHERE ProductMerchant IN (?) UNION ALL SELECT * FROM BookEntity WHERE ProductMerchant NOT IN (?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (merchant == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, merchant);
    }
    _argIndex = 2;
    if (merchant == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, merchant);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfProductId = CursorUtil.getColumnIndexOrThrow(_cursor, "productId");
      final int _cursorIndexOfProductImage = CursorUtil.getColumnIndexOrThrow(_cursor, "ProductImage");
      final int _cursorIndexOfProductName = CursorUtil.getColumnIndexOrThrow(_cursor, "ProductName");
      final int _cursorIndexOfProductPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "ProductPrice");
      final int _cursorIndexOfProductRatings = CursorUtil.getColumnIndexOrThrow(_cursor, "ProductRatings");
      final int _cursorIndexOfProductMerchant = CursorUtil.getColumnIndexOrThrow(_cursor, "ProductMerchant");
      final List<BookEntity> _result = new ArrayList<BookEntity>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BookEntity _item;
        _item = new BookEntity();
        final int _tmpProductId;
        _tmpProductId = _cursor.getInt(_cursorIndexOfProductId);
        _item.setProductId(_tmpProductId);
        final String _tmpProductImage;
        _tmpProductImage = _cursor.getString(_cursorIndexOfProductImage);
        _item.setProductImage(_tmpProductImage);
        final String _tmpProductName;
        _tmpProductName = _cursor.getString(_cursorIndexOfProductName);
        _item.setProductName(_tmpProductName);
        final String _tmpProductPrice;
        _tmpProductPrice = _cursor.getString(_cursorIndexOfProductPrice);
        _item.setProductPrice(_tmpProductPrice);
        final String _tmpProductRatings;
        _tmpProductRatings = _cursor.getString(_cursorIndexOfProductRatings);
        _item.setProductRatings(_tmpProductRatings);
        final String _tmpProductMerchant;
        _tmpProductMerchant = _cursor.getString(_cursorIndexOfProductMerchant);
        _item.setProductMerchant(_tmpProductMerchant);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
