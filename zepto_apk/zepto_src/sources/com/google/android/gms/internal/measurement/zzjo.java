package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzjo extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzjq f37002a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjo(zzjq zzjqVar) {
        super(null);
        Objects.requireNonNull(zzjqVar);
        this.f37002a = zzjqVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzjq zzjqVar = this.f37002a;
        synchronized (zzjqVar.f37010e) {
            zzjqVar.f37011f = null;
            zzjqVar.f37008c.run();
        }
        synchronized (zzjqVar) {
            try {
                Iterator it = zzjqVar.f37012g.iterator();
                while (it.hasNext()) {
                    ((zzjr) it.next()).zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
