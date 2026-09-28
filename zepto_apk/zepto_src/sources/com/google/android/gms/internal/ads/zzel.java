package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
final class zzel {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f29595a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f29596b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzep f29597c;

    public zzel(zzep zzepVar, zzej zzejVar, Executor executor) {
        this.f29597c = zzepVar;
        this.f29595a = new WeakReference(zzejVar);
        this.f29596b = executor;
    }
}
