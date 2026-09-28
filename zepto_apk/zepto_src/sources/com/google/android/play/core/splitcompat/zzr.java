package com.google.android.play.core.splitcompat;

import android.util.Log;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
final class zzr implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HashSet f41929a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SplitCompat f41930b;

    public zzr(SplitCompat splitCompat, HashSet hashSet) {
        this.f41930b = splitCompat;
        this.f41929a = hashSet;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            SplitCompat splitCompat = this.f41930b;
            HashSet hashSet = this.f41929a;
            AtomicReference atomicReference = SplitCompat.f41899e;
            splitCompat.b(hashSet);
        } catch (Exception e2) {
            Log.e("SplitCompat", "Failed to remove from splitcompat storage split that is already installed", e2);
        }
    }
}
