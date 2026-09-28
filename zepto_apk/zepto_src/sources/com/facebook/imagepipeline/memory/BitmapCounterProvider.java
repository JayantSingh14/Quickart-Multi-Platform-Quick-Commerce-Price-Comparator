package com.facebook.imagepipeline.memory;

import kotlin.Metadata;
import org.xbill.DNS.TTL;

@Metadata
/* loaded from: classes3.dex */
public final class BitmapCounterProvider {

    /* renamed from: a, reason: collision with root package name */
    public static final int f17999a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f18000b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile BitmapCounter f18001c;

    static {
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), TTL.MAX_VALUE);
        f17999a = ((long) iMin) > 16777216 ? (iMin / 4) * 3 : iMin / 2;
        f18000b = 384;
    }
}
