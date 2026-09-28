package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class zzat {

    /* renamed from: a, reason: collision with root package name */
    public final String f38719a;

    /* renamed from: b, reason: collision with root package name */
    public long f38720b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzav f38721c;

    public zzat(zzav zzavVar, String str) {
        Objects.requireNonNull(zzavVar);
        this.f38721c = zzavVar;
        Preconditions.checkNotEmpty(str);
        this.f38719a = str;
        this.f38720b = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    public final List a() {
        ArrayList arrayList;
        zzav zzavVar = this.f38721c;
        ArrayList arrayList2 = new ArrayList();
        String strValueOf = String.valueOf(this.f38720b);
        String str = this.f38719a;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = zzavVar.X().query("raw_events", new String[]{"rowid", CLConstants.FIELD_PAY_INFO_NAME, "timestamp", "metadata_fingerprint", "data", "realtime"}, "app_id = ? and rowid > ?", new String[]{str, strValueOf}, null, null, "rowid", "1000");
                if (cursorQuery.moveToFirst()) {
                    do {
                        long j2 = cursorQuery.getLong(0);
                        long j3 = cursorQuery.getLong(3);
                        boolean z = cursorQuery.getLong(5) == 1;
                        byte[] blob = cursorQuery.getBlob(4);
                        if (j2 > this.f38720b) {
                            this.f38720b = j2;
                        }
                        try {
                            com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzpj.O(com.google.android.gms.internal.measurement.zzhs.C(), blob);
                            String string = cursorQuery.getString(1);
                            if (string == null) {
                                string = "";
                            }
                            zzhrVar.i();
                            ((com.google.android.gms.internal.measurement.zzhs) zzhrVar.f37107b).I(string);
                            long j4 = cursorQuery.getLong(2);
                            zzhrVar.i();
                            ((com.google.android.gms.internal.measurement.zzhs) zzhrVar.f37107b).J(j4);
                            arrayList2.add(new zzas(j2, j3, z, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.l()));
                        } catch (IOException e2) {
                            zzgt zzgtVar = zzavVar.f39180a.f39089f;
                            zzib.l(zzgtVar);
                            zzgtVar.f38958f.c("Data loss. Failed to merge raw event. appId", zzgt.o(str), e2);
                        }
                    } while (cursorQuery.moveToNext());
                } else {
                    arrayList = Collections.EMPTY_LIST;
                }
            } catch (SQLiteException e3) {
                zzgt zzgtVar2 = zzavVar.f39180a.f39089f;
                zzib.l(zzgtVar2);
                zzgtVar2.f38958f.c("Data loss. Error querying raw events batch. appId", zzgt.o(str), e3);
                arrayList = arrayList2;
            }
            return arrayList;
        } finally {
            if (0 != 0) {
                cursorQuery.close();
            }
        }
    }

    public zzat(zzav zzavVar, String str, long j2) {
        Objects.requireNonNull(zzavVar);
        this.f38721c = zzavVar;
        Preconditions.checkNotEmpty(str);
        this.f38719a = str;
        this.f38720b = zzavVar.D(-1L, "select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j2)});
    }
}
