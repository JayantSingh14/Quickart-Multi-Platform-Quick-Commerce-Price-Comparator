package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import java.util.HashSet;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzdgj {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f27722a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f27723b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f27724c = new HashSet();

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f27725d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f27726e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public final HashSet f27727f = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    public final HashSet f27728g = new HashSet();

    /* renamed from: h, reason: collision with root package name */
    public final HashSet f27729h = new HashSet();

    /* renamed from: i, reason: collision with root package name */
    public final HashSet f27730i = new HashSet();

    /* renamed from: j, reason: collision with root package name */
    public final HashSet f27731j = new HashSet();

    /* renamed from: k, reason: collision with root package name */
    public final HashSet f27732k = new HashSet();

    /* renamed from: l, reason: collision with root package name */
    public final HashSet f27733l = new HashSet();

    /* renamed from: m, reason: collision with root package name */
    public final HashSet f27734m = new HashSet();
    public final HashSet n = new HashSet();
    public zzfdr o;

    public final void a(zzdan zzdanVar, Executor executor) {
        this.f27730i.add(new zzdij(zzdanVar, executor));
    }

    public final void b(AppEventListener appEventListener, Executor executor) {
        this.f27732k.add(new zzdij(appEventListener, executor));
    }

    public final void c(zzdir zzdirVar, Executor executor) {
        this.f27725d.add(new zzdij(zzdirVar, executor));
    }

    public final void d(zzddq zzddqVar, Executor executor) {
        this.f27723b.add(new zzdij(zzddqVar, executor));
    }
}
