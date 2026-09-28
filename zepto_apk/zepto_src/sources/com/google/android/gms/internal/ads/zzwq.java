package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public final class zzwq {

    /* renamed from: a, reason: collision with root package name */
    public final zzwg f35784a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f35785b;

    public zzwq(CopyOnWriteArrayList copyOnWriteArrayList, zzwg zzwgVar) {
        this.f35785b = copyOnWriteArrayList;
        this.f35784a = zzwgVar;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzwr, java.lang.Object] */
    public final void a(final zzdr zzdrVar) {
        Iterator it = this.f35785b.iterator();
        while (it.hasNext()) {
            zzwj zzwjVar = (zzwj) it.next();
            final ?? r2 = zzwjVar.f35764b;
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzwo
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzdrVar.zza(r2);
                }
            };
            Handler handler = zzwjVar.f35763a;
            String str = zzfj.f31254a;
            Looper looper = handler.getLooper();
            if (looper.getThread().isAlive()) {
                if (looper == Looper.myLooper()) {
                    runnable.run();
                } else {
                    handler.post(runnable);
                }
            }
        }
    }

    public zzwq() {
        this(new CopyOnWriteArrayList(), null);
    }
}
