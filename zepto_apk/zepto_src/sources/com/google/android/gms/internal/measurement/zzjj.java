package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzjj extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzjl f36990a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjj(zzjl zzjlVar) {
        super(null);
        Objects.requireNonNull(zzjlVar);
        this.f36990a = zzjlVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.f36990a.f36991a.set(true);
    }
}
