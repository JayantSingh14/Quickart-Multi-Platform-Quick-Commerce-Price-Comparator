package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes4.dex */
public final class zzfjd {

    /* renamed from: a, reason: collision with root package name */
    public final Pattern f31264a;

    @VisibleForTesting
    public zzfjd() {
        Pattern patternCompile;
        try {
            patternCompile = Pattern.compile((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.y7));
        } catch (PatternSyntaxException unused) {
            patternCompile = null;
        }
        this.f31264a = patternCompile;
    }
}
