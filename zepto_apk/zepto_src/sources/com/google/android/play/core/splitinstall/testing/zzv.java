package com.google.android.play.core.splitinstall.testing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class zzv {

    /* renamed from: a, reason: collision with root package name */
    public static final zzv f42068a;

    static {
        zza zzaVar = new zza();
        zzaVar.f42024b = new HashMap();
        zzaVar.a(Collections.unmodifiableMap(zzaVar.b()));
        Map map = zzaVar.f42024b;
        if (map == null) {
            throw new IllegalStateException("Missing required properties: splitInstallErrorCodeByModule");
        }
        f42068a = new zzc(zzaVar.f42023a, map);
    }

    public abstract Integer a();

    public abstract Map b();
}
