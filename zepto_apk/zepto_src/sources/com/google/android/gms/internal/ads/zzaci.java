package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.RestrictTo;
import java.util.concurrent.CopyOnWriteArraySet;

@RestrictTo
/* loaded from: classes4.dex */
public final class zzaci implements zzbt {

    /* renamed from: a, reason: collision with root package name */
    public final Context f22715a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbs f22716b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f22717c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f22718d;

    /* renamed from: e, reason: collision with root package name */
    public final zzadl f22719e;

    /* renamed from: f, reason: collision with root package name */
    public final zzfc f22720f;

    /* renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArraySet f22721g;

    /* renamed from: h, reason: collision with root package name */
    public final long f22722h;

    /* renamed from: i, reason: collision with root package name */
    public final zzacn f22723i;

    /* renamed from: j, reason: collision with root package name */
    public zzff f22724j = new zzff(0);

    /* renamed from: k, reason: collision with root package name */
    public zzdx f22725k;

    /* renamed from: l, reason: collision with root package name */
    public Pair f22726l;

    /* renamed from: m, reason: collision with root package name */
    public int f22727m;
    public int n;
    public long o;
    public int p;

    public zzaci(zzaca zzacaVar) {
        this.f22715a = zzacaVar.f22696a;
        zzbs zzbsVar = zzacaVar.f22698c;
        zzbsVar.getClass();
        this.f22716b = zzbsVar;
        this.f22717c = new SparseArray();
        zzgvs zzgvsVar = zzgtd.f33183b;
        zzgtd zzgtdVar = zzguy.f33232e;
        this.f22718d = zzacaVar.f22699d;
        zzfc zzfcVar = zzacaVar.f22700e;
        this.f22720f = zzfcVar;
        long j2 = zzacaVar.f22702g;
        this.f22722h = j2 != -9223372036854775807L ? -j2 : -9223372036854775807L;
        zzacn zzacnVar = zzacaVar.f22703h;
        this.f22723i = zzacnVar;
        this.f22719e = new zzabn(zzacaVar.f22697b, zzacnVar, zzfcVar);
        this.f22721g = new CopyOnWriteArraySet();
        new zzv(new zzt());
        this.o = -9223372036854775807L;
        this.p = -1;
        this.n = 0;
    }
}
