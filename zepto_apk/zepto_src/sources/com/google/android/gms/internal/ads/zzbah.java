package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.common.util.concurrent.ListenableFuture;
import in.juspay.hyper.constants.LogSubCategory;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
public final class zzbah extends zzbbh {

    /* renamed from: k, reason: collision with root package name */
    public static final zzbbi f24630k = new zzbbi();

    /* renamed from: h, reason: collision with root package name */
    public final zzavl f24631h;

    /* renamed from: i, reason: collision with root package name */
    public final Context f24632i;

    /* renamed from: j, reason: collision with root package name */
    public final zzaxn f24633j;

    public zzbah(zzazt zzaztVar, zzavs zzavsVar, int i2, Context context, zzavl zzavlVar, zzaxn zzaxnVar) {
        super(zzaztVar, "yYlfo3JOLIfvdgBq3U3deu0pC6YiXdEdqGnVULE/KCllAkaO/XSsVQU+sKDN/uG0", "5ZNtOO3srzHnbl5PLlxEIuHlg0l+6HDun864hT7P5ko=", zzavsVar, i2, 27);
        this.f24632i = context;
        this.f24631h = zzavlVar;
        this.f24633j = zzaxnVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042 A[Catch: all -> 0x003f, TryCatch #2 {all -> 0x003f, blocks: (B:4:0x000e, B:6:0x0018, B:8:0x001e, B:14:0x002a, B:16:0x0034, B:64:0x00e7, B:65:0x00ed, B:21:0x0042, B:23:0x0048, B:63:0x00e4, B:24:0x004e, B:26:0x0075, B:28:0x007b, B:30:0x0081, B:33:0x0089, B:39:0x0095, B:41:0x009b, B:45:0x00a4, B:47:0x00a9, B:46:0x00a7, B:48:0x00ac, B:50:0x00b2, B:52:0x00b8, B:42:0x009e, B:55:0x00bf, B:57:0x00d4, B:61:0x00dd), top: B:83:0x000e }] */
    @Override // com.google.android.gms.internal.ads.zzbbh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            Method dump skipped, instructions count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbah.a():void");
    }

    public final String b() throws CertificateException {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            zzbgb zzbgbVar = zzbgk.X2;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            byte[] bArrA = zzazw.a((String) zzbdVar.f21153c.a(zzbgbVar));
            ArrayList arrayList = new ArrayList();
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(bArrA)));
            if (!Build.TYPE.equals(LogSubCategory.Action.USER)) {
                arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(zzazw.a((String) zzbdVar.f21153c.a(zzbgk.Y2)))));
            }
            Context context = this.f24632i;
            String packageName = context.getPackageName();
            ExecutorService executorService = this.f24669a.f24559b;
            return zzbbk.a(context, packageName, arrayList);
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }

    public final zzaxk c() {
        String str;
        ListenableFuture listenableFuture;
        zzbgb zzbgbVar = zzbgk.i3;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        int iIntValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() ? ((Integer) zzbdVar.f21153c.a(zzbgk.o3)).intValue() : this.f24631h.D();
        zzaxk zzaxkVar = new zzaxk((String) this.f24673e.invoke(null, this.f24632i, Boolean.FALSE, ""));
        zzaxn zzaxnVar = this.f24633j;
        if (zzaxnVar == null || (listenableFuture = zzaxnVar.f24439a) == null) {
            str = "E";
        } else {
            try {
                str = (String) ((zzgxf) listenableFuture).get(iIntValue, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
            }
        }
        zzaxkVar.f24431a = str;
        return zzaxkVar;
    }
}
