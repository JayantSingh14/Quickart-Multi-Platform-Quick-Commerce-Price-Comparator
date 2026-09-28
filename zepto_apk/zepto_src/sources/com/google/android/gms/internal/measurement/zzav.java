package com.google.android.gms.internal.measurement;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class zzav {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f36776a = new ArrayList();

    public abstract zzao a(String str, zzg zzgVar, ArrayList arrayList);

    public final void b(String str) {
        if (!this.f36776a.contains(zzh.e(str))) {
            throw new IllegalArgumentException("Command not supported");
        }
        throw new UnsupportedOperationException("Command not implemented: ".concat(String.valueOf(str)));
    }
}
