package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzxb implements zzaav, zzvv {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f35805a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhy f35806b;

    /* renamed from: c, reason: collision with root package name */
    public final zzwz f35807c;

    /* renamed from: d, reason: collision with root package name */
    public final zzaer f35808d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdq f35809e;

    /* renamed from: f, reason: collision with root package name */
    public final zzafo f35810f;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f35811g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f35812h;

    /* renamed from: i, reason: collision with root package name */
    public long f35813i;

    /* renamed from: j, reason: collision with root package name */
    public zzhf f35814j;

    /* renamed from: k, reason: collision with root package name */
    public zzaga f35815k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f35816l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzxk f35817m;

    public zzxb(zzxk zzxkVar, Uri uri, zzhb zzhbVar, zzwz zzwzVar, zzaer zzaerVar, zzdq zzdqVar) {
        Objects.requireNonNull(zzxkVar);
        this.f35817m = zzxkVar;
        this.f35805a = uri;
        this.f35806b = new zzhy(zzhbVar);
        this.f35807c = zzwzVar;
        this.f35808d = zzaerVar;
        this.f35809e = zzdqVar;
        this.f35810f = new zzafo();
        this.f35812h = true;
        zzvx.f35740a.getAndIncrement();
        this.f35814j = b(0L, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0220 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de A[Catch: all -> 0x00c1, TryCatch #3 {all -> 0x00c1, blocks: (B:29:0x008f, B:30:0x0095, B:40:0x00d4, B:42:0x00de, B:44:0x00eb, B:46:0x00f5, B:48:0x0102, B:50:0x010c, B:52:0x0119, B:54:0x0123, B:56:0x0136, B:58:0x0140, B:59:0x0147, B:67:0x0180, B:69:0x0189, B:71:0x0193, B:73:0x0198, B:75:0x01b2, B:77:0x01c7, B:78:0x01ca, B:80:0x01ce, B:62:0x0151, B:65:0x0171, B:34:0x00a1, B:39:0x00c6), top: B:144:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f5 A[Catch: all -> 0x00c1, TryCatch #3 {all -> 0x00c1, blocks: (B:29:0x008f, B:30:0x0095, B:40:0x00d4, B:42:0x00de, B:44:0x00eb, B:46:0x00f5, B:48:0x0102, B:50:0x010c, B:52:0x0119, B:54:0x0123, B:56:0x0136, B:58:0x0140, B:59:0x0147, B:67:0x0180, B:69:0x0189, B:71:0x0193, B:73:0x0198, B:75:0x01b2, B:77:0x01c7, B:78:0x01ca, B:80:0x01ce, B:62:0x0151, B:65:0x0171, B:34:0x00a1, B:39:0x00c6), top: B:144:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010c A[Catch: all -> 0x00c1, TryCatch #3 {all -> 0x00c1, blocks: (B:29:0x008f, B:30:0x0095, B:40:0x00d4, B:42:0x00de, B:44:0x00eb, B:46:0x00f5, B:48:0x0102, B:50:0x010c, B:52:0x0119, B:54:0x0123, B:56:0x0136, B:58:0x0140, B:59:0x0147, B:67:0x0180, B:69:0x0189, B:71:0x0193, B:73:0x0198, B:75:0x01b2, B:77:0x01c7, B:78:0x01ca, B:80:0x01ce, B:62:0x0151, B:65:0x0171, B:34:0x00a1, B:39:0x00c6), top: B:144:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0123 A[Catch: all -> 0x00c1, TryCatch #3 {all -> 0x00c1, blocks: (B:29:0x008f, B:30:0x0095, B:40:0x00d4, B:42:0x00de, B:44:0x00eb, B:46:0x00f5, B:48:0x0102, B:50:0x010c, B:52:0x0119, B:54:0x0123, B:56:0x0136, B:58:0x0140, B:59:0x0147, B:67:0x0180, B:69:0x0189, B:71:0x0193, B:73:0x0198, B:75:0x01b2, B:77:0x01c7, B:78:0x01ca, B:80:0x01ce, B:62:0x0151, B:65:0x0171, B:34:0x00a1, B:39:0x00c6), top: B:144:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0140 A[Catch: all -> 0x00c1, TRY_LEAVE, TryCatch #3 {all -> 0x00c1, blocks: (B:29:0x008f, B:30:0x0095, B:40:0x00d4, B:42:0x00de, B:44:0x00eb, B:46:0x00f5, B:48:0x0102, B:50:0x010c, B:52:0x0119, B:54:0x0123, B:56:0x0136, B:58:0x0140, B:59:0x0147, B:67:0x0180, B:69:0x0189, B:71:0x0193, B:73:0x0198, B:75:0x01b2, B:77:0x01c7, B:78:0x01ca, B:80:0x01ce, B:62:0x0151, B:65:0x0171, B:34:0x00a1, B:39:0x00c6), top: B:144:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0180 A[Catch: all -> 0x00c1, TryCatch #3 {all -> 0x00c1, blocks: (B:29:0x008f, B:30:0x0095, B:40:0x00d4, B:42:0x00de, B:44:0x00eb, B:46:0x00f5, B:48:0x0102, B:50:0x010c, B:52:0x0119, B:54:0x0123, B:56:0x0136, B:58:0x0140, B:59:0x0147, B:67:0x0180, B:69:0x0189, B:71:0x0193, B:73:0x0198, B:75:0x01b2, B:77:0x01c7, B:78:0x01ca, B:80:0x01ce, B:62:0x0151, B:65:0x0171, B:34:0x00a1, B:39:0x00c6), top: B:144:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0193 A[Catch: all -> 0x00c1, TryCatch #3 {all -> 0x00c1, blocks: (B:29:0x008f, B:30:0x0095, B:40:0x00d4, B:42:0x00de, B:44:0x00eb, B:46:0x00f5, B:48:0x0102, B:50:0x010c, B:52:0x0119, B:54:0x0123, B:56:0x0136, B:58:0x0140, B:59:0x0147, B:67:0x0180, B:69:0x0189, B:71:0x0193, B:73:0x0198, B:75:0x01b2, B:77:0x01c7, B:78:0x01ca, B:80:0x01ce, B:62:0x0151, B:65:0x0171, B:34:0x00a1, B:39:0x00c6), top: B:144:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c7 A[Catch: all -> 0x00c1, TryCatch #3 {all -> 0x00c1, blocks: (B:29:0x008f, B:30:0x0095, B:40:0x00d4, B:42:0x00de, B:44:0x00eb, B:46:0x00f5, B:48:0x0102, B:50:0x010c, B:52:0x0119, B:54:0x0123, B:56:0x0136, B:58:0x0140, B:59:0x0147, B:67:0x0180, B:69:0x0189, B:71:0x0193, B:73:0x0198, B:75:0x01b2, B:77:0x01c7, B:78:0x01ca, B:80:0x01ce, B:62:0x0151, B:65:0x0171, B:34:0x00a1, B:39:0x00c6), top: B:144:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ce A[Catch: all -> 0x00c1, TRY_LEAVE, TryCatch #3 {all -> 0x00c1, blocks: (B:29:0x008f, B:30:0x0095, B:40:0x00d4, B:42:0x00de, B:44:0x00eb, B:46:0x00f5, B:48:0x0102, B:50:0x010c, B:52:0x0119, B:54:0x0123, B:56:0x0136, B:58:0x0140, B:59:0x0147, B:67:0x0180, B:69:0x0189, B:71:0x0193, B:73:0x0198, B:75:0x01b2, B:77:0x01c7, B:78:0x01ca, B:80:0x01ce, B:62:0x0151, B:65:0x0171, B:34:0x00a1, B:39:0x00c6), top: B:144:0x008f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 601
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxb.a():void");
    }

    public final zzhf b(long j2, String str) {
        Map mapD = zzxk.Q;
        if (str != null && !str.startsWith("W/")) {
            zzgtf zzgtfVar = new zzgtf();
            zzgtfVar.b(mapD.entrySet());
            zzgtfVar.a("If-Range", str);
            mapD = zzgtfVar.d(false);
        }
        zzhe zzheVar = new zzhe();
        zzheVar.f33634a = this.f35805a;
        zzheVar.f33636c = j2;
        zzheVar.f33638e = 6;
        zzheVar.f33635b = mapD;
        return zzheVar.a();
    }
}
