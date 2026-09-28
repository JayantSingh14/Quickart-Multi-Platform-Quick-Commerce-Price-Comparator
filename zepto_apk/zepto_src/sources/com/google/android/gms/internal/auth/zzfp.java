package com.google.android.gms.internal.auth;

import java.nio.charset.Charset;

/* loaded from: classes4.dex */
final class zzfp implements zzgj {

    /* renamed from: b, reason: collision with root package name */
    public static final zzfn f36364b = new zzfn();

    /* renamed from: a, reason: collision with root package name */
    public final zzfo f36365a;

    public zzfp() {
        zzfv zzfvVar;
        try {
            zzfvVar = (zzfv) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzfvVar = f36364b;
        }
        zzfo zzfoVar = new zzfo(zzes.f36350a, zzfvVar);
        Charset charset = zzfa.f36355a;
        this.f36365a = zzfoVar;
    }
}
