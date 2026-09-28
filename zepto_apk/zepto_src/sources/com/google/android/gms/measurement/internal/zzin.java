package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzin implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzr f39131a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzjc f39132b;

    public zzin(zzjc zzjcVar, zzr zzrVar) {
        this.f39131a = zzrVar;
        Objects.requireNonNull(zzjcVar);
        this.f39132b = zzjcVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzjc zzjcVar = this.f39132b;
        zzjcVar.f39177a.A();
        zzpf zzpfVar = zzjcVar.f39177a;
        if (zzpfVar.y != null) {
            ArrayList arrayList = new ArrayList();
            zzpfVar.z = arrayList;
            arrayList.addAll(zzpfVar.y);
        }
        zzav zzavVar = zzpfVar.f39596c;
        zzpf.S(zzavVar);
        zzib zzibVar = zzavVar.f39180a;
        zzr zzrVar = this.f39131a;
        String str = (String) Preconditions.checkNotNull(zzrVar.f39648a);
        Preconditions.checkNotEmpty(str);
        zzavVar.g();
        zzavVar.h();
        try {
            SQLiteDatabase sQLiteDatabaseX = zzavVar.X();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseX.delete("apps", "app_id=?", strArr) + sQLiteDatabaseX.delete("events", "app_id=?", strArr) + sQLiteDatabaseX.delete("events_snapshot", "app_id=?", strArr) + sQLiteDatabaseX.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseX.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseX.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseX.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseX.delete("queue", "app_id=?", strArr) + sQLiteDatabaseX.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseX.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseX.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseX.delete("trigger_uris", "app_id=?", strArr) + sQLiteDatabaseX.delete("upload_queue", "app_id=?", strArr);
            ((com.google.android.gms.internal.measurement.zzpl) com.google.android.gms.internal.measurement.zzpk.f37246b.f37247a.get()).getClass();
            if (zzibVar.f39087d.q(null, zzfx.i1)) {
                iDelete += sQLiteDatabaseX.delete("no_data_mode_events", "app_id=?", strArr);
            }
            if (iDelete > 0) {
                zzgt zzgtVar = zzibVar.f39089f;
                zzib.l(zzgtVar);
                zzgtVar.n.c("Reset analytics data. app, records", str, Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e2) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.c("Error resetting analytics data. appId, error", zzgt.o(str), e2);
        }
        if (zzrVar.f39655h) {
            zzpfVar.W(zzrVar);
        }
    }
}
