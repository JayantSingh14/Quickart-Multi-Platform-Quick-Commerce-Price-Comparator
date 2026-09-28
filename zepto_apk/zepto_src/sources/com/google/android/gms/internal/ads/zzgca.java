package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;

/* loaded from: classes4.dex */
public final class zzgca {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f32243a;

    public zzgca(ExecutorService executorService) {
        this.f32243a = executorService;
    }

    public final zzgbz a(File file, byte[] bArr, Function function) {
        return new zzgbz(file, this.f32243a, new zzgbt(bArr), function);
    }
}
