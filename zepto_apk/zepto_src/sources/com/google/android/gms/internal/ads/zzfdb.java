package com.google.android.gms.internal.ads;

import android.content.Context;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public abstract class zzfdb implements zzerf {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30870a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f30871b;

    /* renamed from: c, reason: collision with root package name */
    public final zzclg f30872c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfdr f30873d;

    /* renamed from: e, reason: collision with root package name */
    public final zzffj f30874e;

    /* renamed from: f, reason: collision with root package name */
    public final VersionInfoParcel f30875f;

    /* renamed from: g, reason: collision with root package name */
    public final FrameLayout f30876g;

    /* renamed from: h, reason: collision with root package name */
    public final zzfnr f30877h;

    /* renamed from: i, reason: collision with root package name */
    public final zzfij f30878i;

    /* renamed from: j, reason: collision with root package name */
    public ListenableFuture f30879j;

    public zzfdb(Context context, Executor executor, zzclg zzclgVar, zzffj zzffjVar, zzfdr zzfdrVar, zzfij zzfijVar, VersionInfoParcel versionInfoParcel) {
        this.f30870a = context;
        this.f30871b = executor;
        this.f30872c = zzclgVar;
        this.f30874e = zzffjVar;
        this.f30873d = zzfdrVar;
        this.f30878i = zzfijVar;
        this.f30875f = versionInfoParcel;
        this.f30876g = new FrameLayout(context);
        this.f30877h = zzclgVar.z();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean a(com.google.android.gms.ads.internal.client.zzm r10, java.lang.String r11, com.google.android.gms.internal.ads.zzerd r12, com.google.android.gms.internal.ads.zzere r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfdb.a(com.google.android.gms.ads.internal.client.zzm, java.lang.String, com.google.android.gms.internal.ads.zzerd, com.google.android.gms.internal.ads.zzere):boolean");
    }

    public abstract zzcsp b(zzczt zzcztVar, zzdgk zzdgkVar);

    public final synchronized zzczq c(zzffh zzffhVar) {
        zzfcy zzfcyVar = (zzfcy) zzffhVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.h9)).booleanValue()) {
            zzczs zzczsVar = new zzczs();
            zzczsVar.f27511a = this.f30870a;
            zzczsVar.f27512b = zzfcyVar.f30866a;
            zzczt zzcztVar = new zzczt(zzczsVar);
            zzdgj zzdgjVar = new zzdgj();
            zzfdr zzfdrVar = this.f30873d;
            Executor executor = this.f30871b;
            zzdgjVar.f27733l.add(new zzdij(zzfdrVar, executor));
            zzdgjVar.c(zzfdrVar, executor);
            return b(zzcztVar, new zzdgk(zzdgjVar));
        }
        zzfdr zzfdrVar2 = this.f30873d;
        zzfdr zzfdrVar3 = new zzfdr(zzfdrVar2.f30895a);
        zzfdrVar3.f30902h = zzfdrVar2;
        zzdgj zzdgjVar2 = new zzdgj();
        Executor executor2 = this.f30871b;
        zzdgjVar2.a(zzfdrVar3, executor2);
        zzdgjVar2.f27728g.add(new zzdij(zzfdrVar3, executor2));
        zzdgjVar2.n.add(new zzdij(zzfdrVar3, executor2));
        zzdgjVar2.f27734m.add(new zzdij(zzfdrVar3, executor2));
        zzdgjVar2.f27733l.add(new zzdij(zzfdrVar3, executor2));
        zzdgjVar2.c(zzfdrVar3, executor2);
        zzdgjVar2.o = zzfdrVar3;
        zzczs zzczsVar2 = new zzczs();
        zzczsVar2.f27511a = this.f30870a;
        zzczsVar2.f27512b = zzfcyVar.f30866a;
        return b(new zzczt(zzczsVar2), new zzdgk(zzdgjVar2));
    }
}
