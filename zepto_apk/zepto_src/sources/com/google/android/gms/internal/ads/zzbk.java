package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes4.dex */
public class zzbk {

    /* renamed from: a, reason: collision with root package name */
    public int f25268a = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: b, reason: collision with root package name */
    public int f25269b = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: c, reason: collision with root package name */
    public int f25270c = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: d, reason: collision with root package name */
    public int f25271d = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: e, reason: collision with root package name */
    public int f25272e = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: f, reason: collision with root package name */
    public int f25273f = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: g, reason: collision with root package name */
    public boolean f25274g = true;

    /* renamed from: h, reason: collision with root package name */
    public boolean f25275h = true;

    /* renamed from: i, reason: collision with root package name */
    public zzgtd f25276i;

    /* renamed from: j, reason: collision with root package name */
    public zzgtd f25277j;

    /* renamed from: k, reason: collision with root package name */
    public zzgtd f25278k;

    /* renamed from: l, reason: collision with root package name */
    public zzgtd f25279l;

    /* renamed from: m, reason: collision with root package name */
    public zzgtd f25280m;
    public int n;
    public int o;
    public zzgtd p;
    public zzbj q;
    public zzgtd r;
    public boolean s;
    public zzgtd t;
    public HashMap u;
    public HashSet v;

    public zzbk() {
        zzgvs zzgvsVar = zzgtd.f33183b;
        zzgtd zzgtdVar = zzguy.f33232e;
        this.f25276i = zzgtdVar;
        this.f25277j = zzgtdVar;
        this.f25278k = zzgtdVar;
        this.f25279l = zzgtdVar;
        this.f25280m = zzgtdVar;
        this.n = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.o = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.p = zzgtdVar;
        this.q = zzbj.f25226a;
        this.r = zzgtdVar;
        this.s = true;
        this.t = zzgtdVar;
        this.u = new HashMap();
        this.v = new HashSet();
    }

    public final void a(zzzf zzzfVar) {
        this.f25268a = zzzfVar.f25286a;
        this.f25269b = zzzfVar.f25287b;
        this.f25270c = zzzfVar.f25288c;
        this.f25271d = zzzfVar.f25289d;
        this.f25272e = zzzfVar.f25290e;
        this.f25273f = zzzfVar.f25291f;
        this.f25274g = zzzfVar.f25292g;
        this.f25275h = zzzfVar.f25293h;
        this.f25277j = zzzfVar.f25295j;
        this.f25276i = zzzfVar.f25294i;
        this.f25278k = zzzfVar.f25296k;
        this.f25279l = zzzfVar.f25297l;
        this.f25280m = zzzfVar.f25298m;
        this.n = zzzfVar.n;
        this.o = zzzfVar.o;
        this.p = zzzfVar.p;
        this.q = zzzfVar.q;
        this.r = zzzfVar.r;
        this.s = zzzfVar.t;
        this.t = zzzfVar.s;
        this.v = new HashSet(zzzfVar.v);
        this.u = new HashMap(zzzfVar.u);
    }
}
