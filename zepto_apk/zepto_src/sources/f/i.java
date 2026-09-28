package f;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes4.dex */
public final class i extends k {
    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS AppInfo (AppFamilyId TEXT NOT NULL, PackageName TEXT NOT NULL, AllowedScopes TEXT, GrantedPermissions TEXT, ClientId TEXT, AppVariantId TEXT,AuthzHost TEXT, ExchangeHost TEXT, Payload TEXT,UNIQUE (PackageName), PRIMARY KEY (AppVariantId))");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS app_info_index_pkg_name ON AppInfo (PackageName)");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS app_info_index_app_variant_id ON AppInfo (AppVariantId)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
