package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements SQLiteEventStore.Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20968a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f20969b;

    public /* synthetic */ f(Object obj, int i2) {
        this.f20968a = i2;
        this.f20969b = obj;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        Object obj2 = this.f20969b;
        switch (this.f20968a) {
            case 0:
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                Encoding encoding = SQLiteEventStore.f20937f;
                SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) obj2;
                sQLiteEventStore.getClass();
                sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
                sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + sQLiteEventStore.f20939b.a()).execute();
                break;
            default:
                Cursor cursor = (Cursor) obj;
                Encoding encoding2 = SQLiteEventStore.f20937f;
                while (cursor.moveToNext()) {
                    long j2 = cursor.getLong(0);
                    HashMap map = (HashMap) obj2;
                    Set hashSet = (Set) map.get(Long.valueOf(j2));
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        map.put(Long.valueOf(j2), hashSet);
                    }
                    hashSet.add(new SQLiteEventStore.Metadata(cursor.getString(1), cursor.getString(2)));
                }
                break;
        }
        return null;
    }
}
