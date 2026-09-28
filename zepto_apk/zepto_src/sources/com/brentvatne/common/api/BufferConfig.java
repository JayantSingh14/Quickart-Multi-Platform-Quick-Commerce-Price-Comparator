package com.brentvatne.common.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class BufferConfig {

    /* renamed from: a, reason: collision with root package name */
    public int f15342a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f15343b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f15344c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f15345d = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f15346e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f15347f = -1;

    /* renamed from: g, reason: collision with root package name */
    public double f15348g = -1.0d;

    /* renamed from: h, reason: collision with root package name */
    public double f15349h = -1.0d;

    /* renamed from: i, reason: collision with root package name */
    public double f15350i = -1.0d;

    /* renamed from: j, reason: collision with root package name */
    public int f15351j = -1;

    /* renamed from: k, reason: collision with root package name */
    public Live f15352k = new Live();

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class Live {

        /* renamed from: a, reason: collision with root package name */
        public float f15353a;

        /* renamed from: b, reason: collision with root package name */
        public float f15354b;

        /* renamed from: c, reason: collision with root package name */
        public long f15355c;

        /* renamed from: d, reason: collision with root package name */
        public long f15356d;

        /* renamed from: e, reason: collision with root package name */
        public long f15357e;

        @Metadata
        public static final class Companion {
        }

        public Live() {
            float f2 = (float) (-1.0d);
            this.f15353a = f2;
            this.f15354b = f2;
            long j2 = -1;
            this.f15355c = j2;
            this.f15356d = j2;
            this.f15357e = j2;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof Live)) {
                Live live = (Live) obj;
                if (this.f15353a == live.f15353a && this.f15354b == live.f15354b && this.f15355c == live.f15355c && this.f15356d == live.f15356d && this.f15357e == live.f15357e) {
                    return true;
                }
            }
            return false;
        }
    }

    public final int a() {
        return this.f15351j;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof BufferConfig)) {
            BufferConfig bufferConfig = (BufferConfig) obj;
            if (this.f15342a == bufferConfig.f15342a && this.f15343b == bufferConfig.f15343b && this.f15344c == bufferConfig.f15344c && this.f15345d == bufferConfig.f15345d && this.f15346e == bufferConfig.f15346e && this.f15347f == bufferConfig.f15347f && this.f15348g == bufferConfig.f15348g && this.f15349h == bufferConfig.f15349h && this.f15350i == bufferConfig.f15350i && this.f15351j == bufferConfig.f15351j && Intrinsics.b(this.f15352k, bufferConfig.f15352k)) {
                return true;
            }
        }
        return false;
    }
}
