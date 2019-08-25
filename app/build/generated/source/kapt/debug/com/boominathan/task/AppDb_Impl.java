package com.boominathan.task;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDb_Impl extends AppDb {
  private volatile BookDAO _bookDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `BookEntity` (`productId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `ProductImage` TEXT NOT NULL, `ProductName` TEXT NOT NULL, `ProductPrice` TEXT NOT NULL, `ProductRatings` TEXT NOT NULL, `ProductMerchant` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5b932a7ac585e736c02233fa294d1195')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `BookEntity`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsBookEntity = new HashMap<String, TableInfo.Column>(6);
        _columnsBookEntity.put("productId", new TableInfo.Column("productId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookEntity.put("ProductImage", new TableInfo.Column("ProductImage", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookEntity.put("ProductName", new TableInfo.Column("ProductName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookEntity.put("ProductPrice", new TableInfo.Column("ProductPrice", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookEntity.put("ProductRatings", new TableInfo.Column("ProductRatings", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookEntity.put("ProductMerchant", new TableInfo.Column("ProductMerchant", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBookEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBookEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBookEntity = new TableInfo("BookEntity", _columnsBookEntity, _foreignKeysBookEntity, _indicesBookEntity);
        final TableInfo _existingBookEntity = TableInfo.read(_db, "BookEntity");
        if (! _infoBookEntity.equals(_existingBookEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "BookEntity(com.boominathan.task.BookEntity).\n"
                  + " Expected:\n" + _infoBookEntity + "\n"
                  + " Found:\n" + _existingBookEntity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "5b932a7ac585e736c02233fa294d1195", "0f466d74ceeea548ac89963d41ccd065");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "BookEntity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `BookEntity`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public BookDAO bookDao() {
    if (_bookDAO != null) {
      return _bookDAO;
    } else {
      synchronized(this) {
        if(_bookDAO == null) {
          _bookDAO = new BookDAO_Impl(this);
        }
        return _bookDAO;
      }
    }
  }
}
