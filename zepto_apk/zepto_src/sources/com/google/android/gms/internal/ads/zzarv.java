package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzarv {

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f24243c = zzarw.f24246a;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f24244a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public boolean f24245b = false;

    public final synchronized void a(long j2, String str) {
        if (this.f24245b) {
            throw new IllegalStateException("Marker added to finished log");
        }
        this.f24244a.add(new zzaru(j2, SystemClock.elapsedRealtime(), str));
    }

    public final synchronized void b(String str) {
        long j2;
        this.f24245b = true;
        ArrayList arrayList = this.f24244a;
        if (arrayList.size() == 0) {
            j2 = 0;
        } else {
            j2 = ((zzaru) arrayList.get(arrayList.size() - 1)).f24242c - ((zzaru) arrayList.get(0)).f24242c;
        }
        if (j2 > 0) {
            long j3 = ((zzaru) arrayList.get(0)).f24242c;
            zzarw.b("(%-4d ms) %s", Long.valueOf(j2), str);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                zzaru zzaruVar = (zzaru) it.next();
                long j4 = zzaruVar.f24242c;
                zzarw.b("(+%-4d) [%2d] %s", Long.valueOf(j4 - j3), Long.valueOf(zzaruVar.f24241b), zzaruVar.f24240a);
                j3 = j4;
            }
        }
    }

    public final void finalize() {
        if (this.f24245b) {
            return;
        }
        b("Request on the loose");
        zzarw.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
    }
}
