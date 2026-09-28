package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public final class zzaaz {

    /* renamed from: d, reason: collision with root package name */
    public static final zzaat f22622d = new zzaat(2, -9223372036854775807L);

    /* renamed from: e, reason: collision with root package name */
    public static final zzaat f22623e = new zzaat(3, -9223372036854775807L);

    /* renamed from: a, reason: collision with root package name */
    public final zzabf f22624a;

    /* renamed from: b, reason: collision with root package name */
    public zzaau f22625b;

    /* renamed from: c, reason: collision with root package name */
    public IOException f22626c;

    public zzaaz() {
        String str = zzfj.f31254a;
        this.f22624a = new zzabe(Executors.newSingleThreadExecutor(new zzfi("ExoPlayer:Loader:ProgressiveMediaPeriod")));
    }
}
