package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public final class zzfij {

    /* renamed from: a, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zzm f31200a;

    /* renamed from: b, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zzr f31201b;

    /* renamed from: c, reason: collision with root package name */
    public String f31202c;

    /* renamed from: d, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zzga f31203d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f31204e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f31205f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f31206g;

    /* renamed from: h, reason: collision with root package name */
    public zzbjn f31207h;

    /* renamed from: i, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zzx f31208i;

    /* renamed from: j, reason: collision with root package name */
    public AdManagerAdViewOptions f31209j;

    /* renamed from: k, reason: collision with root package name */
    public PublisherAdViewOptions f31210k;

    /* renamed from: l, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zzco f31211l;
    public zzbpy n;
    public zzeqp r;
    public Bundle t;
    public com.google.android.gms.ads.internal.client.zzcs w;

    /* renamed from: m, reason: collision with root package name */
    public int f31212m = 1;
    public final zzfhx o = new zzfhx();
    public boolean p = false;
    public boolean q = false;
    public boolean s = false;
    public final AtomicLong u = new AtomicLong();
    public boolean v = false;

    public final zzfik a() {
        Preconditions.checkNotNull(this.f31202c, "ad unit must not be null");
        Preconditions.checkNotNull(this.f31201b, "ad size must not be null");
        Preconditions.checkNotNull(this.f31200a, "ad request must not be null");
        return new zzfik(this);
    }
}
