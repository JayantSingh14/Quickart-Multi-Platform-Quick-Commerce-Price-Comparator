package f;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes4.dex */
public final class h extends k {
    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS AppInfo (AppFamilyId TEXT NOT NULL, PackageName TEXT NOT NULL, AllowedScopes TEXT, GrantedPermissions TEXT, ClientId TEXT, AppVariantId TEXT,AuthzHost TEXT, ExchangeHost TEXT, Payload TEXT,UNIQUE (PackageName), PRIMARY KEY (AppVariantId))");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS app_info_index_pkg_name ON AppInfo (PackageName)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS app_info_index_app_variant_id ON AppInfo (AppVariantId)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS RequestedScope (Scope TEXT NOT NULL, AppId TEXT NOT NULL, DirectedId TEXT, AtzAccessTokenId INTEGER NOT NULL, AtzRefreshTokenId INTEGER NOT NULL, PRIMARY KEY (Scope,AppId,AtzAccessTokenId,AtzRefreshTokenId))");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS requested_scope_index_scope ON RequestedScope (Scope)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS requested_scope_index_app_id ON RequestedScope (AppId)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS requested_scope_index_atz_access_token_id ON RequestedScope (AtzAccessTokenId)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS requested_scope_index_directed_id ON RequestedScope (DirectedId)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS requested_scope_index_atz_refresh_token_id ON RequestedScope (AtzRefreshTokenId)");
        sQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS requested_scope_valid_atz_access_token_id BEFORE INSERT ON RequestedScope FOR EACH ROW BEGIN SELECT CASE WHEN (new.AtzAccessTokenId != -2 AND new.AtzAccessTokenId != -1 AND new.AtzAccessTokenId < 0) THEN RAISE(ABORT, 'Invalid authorization token ID') END; END;");
        sQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS requested_scope_valid_atz_refresh_token_id BEFORE INSERT ON RequestedScope FOR EACH ROW BEGIN SELECT CASE WHEN (new.AtzRefreshTokenId != -2 AND new.AtzRefreshTokenId != -1 AND new.AtzRefreshTokenId < 0) THEN RAISE(ABORT, 'Invalid authorization token ID') END; END;");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS AuthorizationToken (Id INTEGER PRIMARY KEY AUTOINCREMENT, AppId TEXT NOT NULL, Token TEXT NOT NULL, CreationTime DATETIME NOT NULL, ExpirationTime DATETIME NOT NULL, MiscData BLOB, type INTEGER NOT NULL, directedId TEXT )");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS authz_token_index_app_id ON AuthorizationToken (AppId)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS authz_token_index_directed_id ON AuthorizationToken (directedId)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS AuthorizationCode (Id INTEGER PRIMARY KEY AUTOINCREMENT, Code TEXT NOT NULL, AppId TEXT NOT NULL, AuthorizationTokenId INTEGER NOT NULL )");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS authz_code_index_app_id ON AuthorizationCode (AppId)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS authz_code_index_token_id ON AuthorizationCode (AuthorizationTokenId)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Profile (Id INTEGER PRIMARY KEY AUTOINCREMENT, ExpirationTime DATETIME NOT NULL, AppId TEXT NOT NULL, Data TEXT NOT NULL )");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS profile_index_app_id ON Profile (AppId)");
        sQLiteDatabase.compileStatement("CREATE TABLE IF NOT EXISTS CodePair (Id INTEGER PRIMARY KEY AUTOINCREMENT, UserCode TEXT NOT NULL, DeviceCode TEXT NOT NULL, VerificationUri TEXT NOT NULL, Interval INTEGER NOT NULL, CreationTime DATETIME NOT NULL, ExpirationTime DATETIME NOT NULL, AppId TEXT NOT NULL, Scopes TEXT NOT NULL )").execute();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) throws SQLException {
        if (i2 < 4 && i3 >= 4) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS AuthorizationToken");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS RequestedScope");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS AppInfo");
            sQLiteDatabase.execSQL("DROP INDEX IF EXISTS RequestedScope.requested_scope_index_directed_id");
            sQLiteDatabase.execSQL("DROP INDEX IF EXISTS RequestedScope.requested_scope_index_atz_token_id");
            sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS requested_scope_valid_atz_token_id");
        }
        if (i2 < 6 && i3 >= 6) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS AppInfo");
        }
        if ((i2 < 8 && i3 >= 8) || (i2 < 9 && i3 >= 9)) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS AppInfo");
        }
        if (i3 > 9) {
            throw new IllegalStateException("Database version was updated, but no upgrade was done ver=8");
        }
        onCreate(sQLiteDatabase);
    }
}
