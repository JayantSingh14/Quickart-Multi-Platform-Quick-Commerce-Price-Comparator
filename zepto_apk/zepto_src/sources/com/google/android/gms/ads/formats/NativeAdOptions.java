package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoOptions;

@Deprecated
/* loaded from: classes4.dex */
public final class NativeAdOptions {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f21045a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21046b;

    /* renamed from: c, reason: collision with root package name */
    public final int f21047c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f21048d;

    /* renamed from: e, reason: collision with root package name */
    public final int f21049e;

    /* renamed from: f, reason: collision with root package name */
    public final VideoOptions f21050f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f21051g;

    public @interface AdChoicesPlacement {
    }

    public static final class Builder {

        /* renamed from: e, reason: collision with root package name */
        public VideoOptions f21056e;

        /* renamed from: a, reason: collision with root package name */
        public boolean f21052a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f21053b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f21054c = 0;

        /* renamed from: d, reason: collision with root package name */
        public boolean f21055d = false;

        /* renamed from: f, reason: collision with root package name */
        public int f21057f = 1;

        /* renamed from: g, reason: collision with root package name */
        public boolean f21058g = false;
    }

    public @interface NativeMediaAspectRatio {
    }

    public /* synthetic */ NativeAdOptions(Builder builder) {
        this.f21045a = builder.f21052a;
        this.f21046b = builder.f21053b;
        this.f21047c = builder.f21054c;
        this.f21048d = builder.f21055d;
        this.f21049e = builder.f21057f;
        this.f21050f = builder.f21056e;
        this.f21051g = builder.f21058g;
    }
}
