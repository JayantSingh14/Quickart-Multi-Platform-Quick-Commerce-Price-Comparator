package com.google.android.gms.internal.consent_sdk;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzbz implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f36525a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f36525a.post(runnable);
    }
}
