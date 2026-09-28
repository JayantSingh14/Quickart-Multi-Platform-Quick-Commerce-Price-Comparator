package com.google.android.play.core.splitcompat;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
final class zzp implements com.google.android.play.core.splitinstall.zzq {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SplitCompat f41927a;

    public zzp(SplitCompat splitCompat) {
        this.f41927a = splitCompat;
    }

    @Override // com.google.android.play.core.splitinstall.zzq
    public final HashSet zza() {
        HashSet hashSet;
        AtomicReference atomicReference = SplitCompat.f41899e;
        SplitCompat splitCompat = this.f41927a;
        synchronized (splitCompat.f41902c) {
            hashSet = new HashSet(splitCompat.f41902c);
        }
        return hashSet;
    }
}
