package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements SQLiteEventStore.Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20960a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f20961b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f20962c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f20963d;

    public /* synthetic */ c(SQLiteEventStore sQLiteEventStore, Object obj, Object obj2, int i2) {
        this.f20960a = i2;
        this.f20961b = sQLiteEventStore;
        this.f20963d = obj;
        this.f20962c = obj2;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) throws Throwable {
        long jInsert;
        Cursor cursor;
        int i2;
        LogEventDropped.Reason reason;
        LogEventDropped.Reason reason2;
        int i3 = 5;
        int i4 = 4;
        int i5 = 3;
        LogEventDropped.Reason reason3 = LogEventDropped.Reason.CACHE_FULL;
        int i6 = 2;
        Object obj2 = this.f20962c;
        int i7 = 0;
        Object obj3 = this.f20963d;
        SQLiteEventStore sQLiteEventStore = this.f20961b;
        int i8 = 1;
        switch (this.f20960a) {
            case 0:
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                Encoding encoding = SQLiteEventStore.f20937f;
                long jSimpleQueryForLong = sQLiteEventStore.l().compileStatement("PRAGMA page_size").simpleQueryForLong() * sQLiteEventStore.l().compileStatement("PRAGMA page_count").simpleQueryForLong();
                EventStoreConfig eventStoreConfig = sQLiteEventStore.f20941d;
                EventInternal eventInternal = (EventInternal) obj3;
                if (jSimpleQueryForLong >= eventStoreConfig.e()) {
                    sQLiteEventStore.e(1L, reason3, eventInternal.l());
                    return -1L;
                }
                TransportContext transportContext = (TransportContext) obj2;
                Long lR = SQLiteEventStore.r(sQLiteDatabase, transportContext);
                if (lR != null) {
                    jInsert = lR.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", transportContext.b());
                    contentValues.put("priority", Integer.valueOf(PriorityMapping.a(transportContext.d())));
                    contentValues.put("next_request_ms", (Integer) 0);
                    if (transportContext.c() != null) {
                        contentValues.put("extras", Base64.encodeToString(transportContext.c(), 0));
                    }
                    jInsert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                int iD = eventStoreConfig.d();
                byte[] bArr = eventInternal.e().f20746b;
                boolean z = bArr.length <= iD;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(jInsert));
                contentValues2.put("transport_name", eventInternal.l());
                contentValues2.put("timestamp_ms", Long.valueOf(eventInternal.f()));
                contentValues2.put("uptime_ms", Long.valueOf(eventInternal.m()));
                contentValues2.put("payload_encoding", eventInternal.e().f20745a.f20513a);
                contentValues2.put("code", eventInternal.d());
                contentValues2.put("num_attempts", (Integer) 0);
                contentValues2.put("inline", Boolean.valueOf(z));
                contentValues2.put(PaymentConstants.PAYLOAD, z ? bArr : new byte[0]);
                contentValues2.put("product_id", eventInternal.j());
                contentValues2.put("pseudonymous_id", eventInternal.k());
                contentValues2.put("experiment_ids_clear_blob", eventInternal.g());
                contentValues2.put("experiment_ids_encrypted_blob", eventInternal.h());
                long jInsert2 = sQLiteDatabase.insert("events", null, contentValues2);
                if (!z) {
                    int iCeil = (int) Math.ceil(bArr.length / iD);
                    for (int i9 = 1; i9 <= iCeil; i9++) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, (i9 - 1) * iD, Math.min(i9 * iD, bArr.length));
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("event_id", Long.valueOf(jInsert2));
                        contentValues3.put("sequence_num", Integer.valueOf(i9));
                        contentValues3.put("bytes", bArrCopyOfRange);
                        sQLiteDatabase.insert("event_payloads", null, contentValues3);
                    }
                }
                for (Map.Entry entry : Collections.unmodifiableMap(eventInternal.c()).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(jInsert2));
                    contentValues4.put(CLConstants.FIELD_PAY_INFO_NAME, (String) entry.getKey());
                    contentValues4.put(CLConstants.FIELD_PAY_INFO_VALUE, (String) entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(jInsert2);
            case 1:
                Cursor cursor2 = (Cursor) obj;
                Encoding encoding2 = SQLiteEventStore.f20937f;
                sQLiteEventStore.getClass();
                while (cursor2.moveToNext()) {
                    long j2 = cursor2.getLong(0);
                    int i10 = cursor2.getInt(7) != 0 ? i8 : 0;
                    EventInternal.Builder builderA = EventInternal.a();
                    builderA.k(cursor2.getString(i8));
                    builderA.f(cursor2.getLong(i6));
                    builderA.l(cursor2.getLong(3));
                    if (i10 != 0) {
                        String string = cursor2.getString(4);
                        builderA.e(new EncodedPayload(string == null ? SQLiteEventStore.f20937f : new Encoding(string), cursor2.getBlob(5)));
                        i2 = i8;
                    } else {
                        String string2 = cursor2.getString(4);
                        Encoding encoding3 = string2 == null ? SQLiteEventStore.f20937f : new Encoding(string2);
                        Cursor cursorQuery = sQLiteEventStore.l().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j2)}, null, null, "sequence_num");
                        try {
                            Cursor cursor3 = cursorQuery;
                            Encoding encoding4 = SQLiteEventStore.f20937f;
                            ArrayList arrayList = new ArrayList();
                            int length = 0;
                            while (cursor3.moveToNext()) {
                                byte[] blob = cursor3.getBlob(0);
                                arrayList.add(blob);
                                length += blob.length;
                                i8 = i8;
                            }
                            i2 = i8;
                            byte[] bArr2 = new byte[length];
                            int i11 = 0;
                            int length2 = 0;
                            while (i11 < arrayList.size()) {
                                byte[] bArr3 = (byte[]) arrayList.get(i11);
                                cursor = cursorQuery;
                                try {
                                    int i12 = i11;
                                    System.arraycopy(bArr3, 0, bArr2, length2, bArr3.length);
                                    length2 += bArr3.length;
                                    i11 = i12 + 1;
                                    cursorQuery = cursor;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor.close();
                                    throw th;
                                }
                            }
                            cursorQuery.close();
                            builderA.e(new EncodedPayload(encoding3, bArr2));
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = cursorQuery;
                        }
                    }
                    if (!cursor2.isNull(6)) {
                        builderA.d(Integer.valueOf(cursor2.getInt(6)));
                    }
                    if (!cursor2.isNull(8)) {
                        builderA.i(Integer.valueOf(cursor2.getInt(8)));
                    }
                    if (!cursor2.isNull(9)) {
                        builderA.j(cursor2.getString(9));
                    }
                    if (!cursor2.isNull(10)) {
                        builderA.g(cursor2.getBlob(10));
                    }
                    if (!cursor2.isNull(11)) {
                        builderA.h(cursor2.getBlob(11));
                    }
                    ((ArrayList) obj3).add(new AutoValue_PersistedEvent(j2, (TransportContext) obj2, builderA.b()));
                    i8 = i2;
                    i6 = 2;
                }
                return null;
            default:
                Cursor cursor4 = (Cursor) obj;
                Encoding encoding5 = SQLiteEventStore.f20937f;
                sQLiteEventStore.getClass();
                while (true) {
                    HashMap map = (HashMap) obj3;
                    if (cursor4.moveToNext()) {
                        String string3 = cursor4.getString(i7);
                        int i13 = cursor4.getInt(1);
                        LogEventDropped.Reason reason4 = LogEventDropped.Reason.REASON_UNKNOWN;
                        if (i13 == 0) {
                            reason2 = reason3;
                            reason = reason4;
                        } else {
                            LogEventDropped.Reason reason5 = LogEventDropped.Reason.MESSAGE_TOO_OLD;
                            if (i13 == 1) {
                                reason2 = reason3;
                                reason = reason5;
                            } else if (i13 == 2) {
                                reason = reason3;
                                reason2 = reason;
                            } else {
                                reason5 = LogEventDropped.Reason.PAYLOAD_TOO_BIG;
                                if (i13 != i5) {
                                    reason5 = LogEventDropped.Reason.MAX_RETRIES_REACHED;
                                    if (i13 != i4) {
                                        reason5 = LogEventDropped.Reason.INVALID_PAYLOD;
                                        if (i13 != i3) {
                                            reason5 = LogEventDropped.Reason.SERVER_ERROR;
                                            if (i13 != 6) {
                                                Logging.a("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i13));
                                                reason2 = reason3;
                                                reason = reason4;
                                            }
                                        }
                                    }
                                }
                                reason2 = reason3;
                                reason = reason5;
                            }
                        }
                        long j3 = cursor4.getLong(2);
                        if (!map.containsKey(string3)) {
                            map.put(string3, new ArrayList());
                        }
                        List list = (List) map.get(string3);
                        int i14 = LogEventDropped.f20812c;
                        LogEventDropped.Builder builder = new LogEventDropped.Builder();
                        builder.f20816b = reason;
                        builder.f20815a = j3;
                        list.add(builder.a());
                        reason3 = reason2;
                        i3 = 5;
                        i4 = 4;
                        i5 = 3;
                        i7 = 0;
                    } else {
                        Iterator it = map.entrySet().iterator();
                        while (true) {
                            ClientMetrics.Builder builder2 = (ClientMetrics.Builder) obj2;
                            if (!it.hasNext()) {
                                final long jA = sQLiteEventStore.f20939b.a();
                                builder2.f20805a = (TimeWindow) sQLiteEventStore.s(new SQLiteEventStore.Function() { // from class: com.google.android.datatransport.runtime.scheduling.persistence.b
                                    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
                                    public final Object apply(Object obj4) {
                                        Encoding encoding6 = SQLiteEventStore.f20937f;
                                        Cursor cursorRawQuery = ((SQLiteDatabase) obj4).rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]);
                                        long j4 = jA;
                                        try {
                                            Cursor cursor5 = cursorRawQuery;
                                            Encoding encoding7 = SQLiteEventStore.f20937f;
                                            cursor5.moveToNext();
                                            long j5 = cursor5.getLong(0);
                                            TimeWindow.Builder builderA2 = TimeWindow.a();
                                            builderA2.f20838a = j5;
                                            builderA2.f20839b = j4;
                                            return builderA2.a();
                                        } finally {
                                            cursorRawQuery.close();
                                        }
                                    }
                                });
                                int i15 = GlobalMetrics.f20809b;
                                GlobalMetrics.Builder builder3 = new GlobalMetrics.Builder();
                                int i16 = StorageMetrics.f20831c;
                                StorageMetrics.Builder builder4 = new StorageMetrics.Builder();
                                builder4.f20834a = sQLiteEventStore.l().compileStatement("PRAGMA page_size").simpleQueryForLong() * sQLiteEventStore.l().compileStatement("PRAGMA page_count").simpleQueryForLong();
                                builder4.f20835b = EventStoreConfig.f20932a.f20919b;
                                builder3.f20811a = builder4.a();
                                builder2.f20807c = builder3.a();
                                builder2.f20808d = (String) sQLiteEventStore.f20942e.get();
                                return builder2.a();
                            }
                            Map.Entry entry2 = (Map.Entry) it.next();
                            int i17 = LogSourceMetrics.f20826c;
                            LogSourceMetrics.Builder builder5 = new LogSourceMetrics.Builder();
                            builder5.f20829a = (String) entry2.getKey();
                            builder5.f20830b = (List) entry2.getValue();
                            builder2.f20806b.add(builder5.a());
                        }
                    }
                }
        }
    }
}
