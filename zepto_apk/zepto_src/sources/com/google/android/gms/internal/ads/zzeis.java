package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Iterator;

/* loaded from: classes4.dex */
final /* synthetic */ class zzeis implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfrt f29428a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f29429b;

    public /* synthetic */ zzeis(zzfrt zzfrtVar, View view) {
        this.f29428a = zzfrtVar;
        this.f29429b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfro zzfroVar = zzfro.f31736a;
        zzfrt zzfrtVar = this.f29428a;
        Iterator it = zzfrtVar.f31751d.values().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            View view = this.f29429b;
            if (!zHasNext) {
                zzfrtVar.f31752e.a(view, zzfroVar);
                return;
            }
            ((zzfrh) it.next()).c(view, zzfroVar);
        }
    }
}
