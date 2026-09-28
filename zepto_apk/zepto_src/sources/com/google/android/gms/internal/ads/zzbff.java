package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;

/* loaded from: classes4.dex */
public final class zzbff {

    /* renamed from: a, reason: collision with root package name */
    public zzbeu f24881a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f24882b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f24883c = new Object();

    public zzbff(Context context) {
    }

    public final /* synthetic */ void a() {
        synchronized (this.f24883c) {
            try {
                zzbeu zzbeuVar = this.f24881a;
                if (zzbeuVar == null) {
                    return;
                }
                zzbeuVar.disconnect();
                this.f24881a = null;
                Binder.flushPendingCommands();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
