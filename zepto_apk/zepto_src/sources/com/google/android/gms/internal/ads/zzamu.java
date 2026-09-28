package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

/* loaded from: classes4.dex */
final class zzamu {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f23646d = Pattern.compile("\\s+");

    /* renamed from: e, reason: collision with root package name */
    public static final zzgtn f23647e = zzgtn.t(2, "auto", "none");

    /* renamed from: f, reason: collision with root package name */
    public static final zzgtn f23648f = zzgtn.t(3, "dot", "sesame", "circle");

    /* renamed from: g, reason: collision with root package name */
    public static final zzgtn f23649g = zzgtn.t(2, "filled", AbstractCircuitBreaker.PROPERTY_NAME);

    /* renamed from: h, reason: collision with root package name */
    public static final zzgtn f23650h = zzgtn.t(3, "after", "before", "outside");

    /* renamed from: a, reason: collision with root package name */
    public final int f23651a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23652b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23653c;

    public zzamu(int i2, int i3, int i4) {
        this.f23651a = i2;
        this.f23652b = i3;
        this.f23653c = i4;
    }
}
