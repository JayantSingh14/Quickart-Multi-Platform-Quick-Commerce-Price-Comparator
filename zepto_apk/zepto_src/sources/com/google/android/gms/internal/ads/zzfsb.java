package com.google.android.gms.internal.ads;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzfsb extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f31767a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f31768b;

    /* renamed from: c, reason: collision with root package name */
    public final AudioManager f31769c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f31770d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f31771e;

    /* renamed from: f, reason: collision with root package name */
    public final ExecutorService f31772f;

    /* renamed from: g, reason: collision with root package name */
    public final zzfsn f31773g;

    public zzfsb(Handler handler, Context context, zzfsn zzfsnVar) {
        super(handler);
        this.f31770d = new AtomicReference(Float.valueOf(-1.0f));
        this.f31771e = new AtomicBoolean(false);
        this.f31772f = Executors.newSingleThreadExecutor();
        this.f31767a = handler;
        this.f31768b = context;
        this.f31769c = (AudioManager) context.getSystemService("audio");
        this.f31773g = zzfsnVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        if (this.f31771e.getAndSet(true)) {
            return;
        }
        this.f31772f.submit(new zzfsa(this));
    }
}
