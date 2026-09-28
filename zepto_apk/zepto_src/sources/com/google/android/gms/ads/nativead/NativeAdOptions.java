package com.google.android.gms.ads.nativead;

import com.google.android.gms.ads.VideoOptions;

/* loaded from: classes4.dex */
public final class NativeAdOptions {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f21721a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21722b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f21723c;

    /* renamed from: d, reason: collision with root package name */
    public final int f21724d;

    /* renamed from: e, reason: collision with root package name */
    public final VideoOptions f21725e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f21726f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f21727g;

    /* renamed from: h, reason: collision with root package name */
    public final int f21728h;

    /* renamed from: i, reason: collision with root package name */
    public final int f21729i;

    public @interface AdChoicesPlacement {
    }

    public static final class Builder {

        /* renamed from: d, reason: collision with root package name */
        public VideoOptions f21733d;

        /* renamed from: a, reason: collision with root package name */
        public boolean f21730a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f21731b = 0;

        /* renamed from: c, reason: collision with root package name */
        public boolean f21732c = false;

        /* renamed from: e, reason: collision with root package name */
        public int f21734e = 1;

        /* renamed from: f, reason: collision with root package name */
        public boolean f21735f = false;

        /* renamed from: g, reason: collision with root package name */
        public boolean f21736g = false;

        /* renamed from: h, reason: collision with root package name */
        public int f21737h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f21738i = 1;
    }

    public @interface NativeMediaAspectRatio {
    }

    public @interface SwipeGestureDirection {
    }

    public /* synthetic */ NativeAdOptions(Builder builder) {
        this.f21721a = builder.f21730a;
        this.f21722b = builder.f21731b;
        this.f21723c = builder.f21732c;
        this.f21724d = builder.f21734e;
        this.f21725e = builder.f21733d;
        this.f21726f = builder.f21735f;
        this.f21727g = builder.f21736g;
        this.f21728h = builder.f21737h;
        this.f21729i = builder.f21738i;
    }
}
