package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.util.Pair;
import coil3.network.internal.UtilsKt;
import dalvik.system.DexClassLoader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
final class zzgex implements zzgev {

    /* renamed from: a, reason: collision with root package name */
    public final Context f32407a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f32408b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgec f32409c;

    /* renamed from: d, reason: collision with root package name */
    public final zzgeu f32410d;

    /* renamed from: e, reason: collision with root package name */
    public final zzgnc f32411e;

    /* renamed from: f, reason: collision with root package name */
    public final zzgtn f32412f;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f32413g = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public final long f32414h;

    /* renamed from: i, reason: collision with root package name */
    public final File f32415i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f32416j;

    /* renamed from: k, reason: collision with root package name */
    public byte[] f32417k;

    /* renamed from: l, reason: collision with root package name */
    public DexClassLoader f32418l;

    public zzgex(Context context, ExecutorService executorService, zzgec zzgecVar, zzgeu zzgeuVar, File file, zzgnc zzgncVar, long j2, zzgtn zzgtnVar) {
        this.f32407a = context;
        this.f32408b = executorService;
        this.f32409c = zzgecVar;
        this.f32410d = zzgeuVar;
        this.f32411e = zzgncVar;
        this.f32412f = zzgtnVar;
        this.f32415i = new File(file, "rbp");
        this.f32414h = j2;
    }

    public static void b(File file) {
        if (file.exists()) {
            file.delete();
        }
    }

    public static void d(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public final void a(File file) throws Throwable {
        FileInputStream fileInputStream;
        if (new File(file.toString().concat("/1762546152805.tmp")).exists()) {
            return;
        }
        File file2 = new File(file.toString().concat("/1762546152805.dex"));
        if (file2.exists()) {
            long length = file2.length();
            if (length > 0) {
                byte[] bArr = new byte[(int) length];
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(file2);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (zzget e2) {
                    e = e2;
                } catch (IOException e3) {
                    e = e3;
                }
                try {
                } catch (zzget e4) {
                    e = e4;
                    fileInputStream2 = fileInputStream;
                    this.f32411e.d(301, e);
                    d(fileInputStream2);
                    b(file2);
                    return;
                } catch (IOException e5) {
                    e = e5;
                    fileInputStream2 = fileInputStream;
                    this.f32411e.d(301, e);
                    d(fileInputStream2);
                    b(file2);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    d(fileInputStream2);
                    b(file2);
                    throw th;
                }
                if (fileInputStream.read(bArr) <= 0) {
                    d(fileInputStream);
                    b(file2);
                    return;
                }
                zzaws zzawsVarH = zzawt.H();
                byte[] bytes = Build.VERSION.SDK.getBytes();
                zzhzl zzhzlVar = zzhzl.f34557b;
                zzhzl zzhzlVarV = zzhzl.v(0, bytes, bytes.length);
                zzawsVarH.j();
                ((zzawt) zzawsVarH.f34638b).L(zzhzlVarV);
                byte[] bytes2 = "1762546152805".getBytes();
                zzhzl zzhzlVarV2 = zzhzl.v(0, bytes2, bytes2.length);
                zzawsVarH.j();
                ((zzawt) zzawsVarH.f34638b).K(zzhzlVarV2);
                throw new zzget();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgev
    public final Method c(String str, String str2) {
        Future future = (Future) this.f32413g.get(new Pair(str, str2));
        zzgnc zzgncVar = this.f32411e;
        if (future == null) {
            zzgncVar.b(302);
            return null;
        }
        try {
            return (Method) future.get(this.f32414h, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException unused) {
            zzgncVar.b(UtilsKt.HTTP_RESPONSE_NOT_MODIFIED);
            return null;
        } catch (TimeoutException unused2) {
            zzgncVar.b(303);
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x027c: INVOKE (r1 I:com.google.android.gms.internal.ads.zzgna) VIRTUAL call: com.google.android.gms.internal.ads.zzgna.c():void A[Catch: all -> 0x027a, MD:():void (m), TRY_ENTER] (LINE:637), block:B:118:0x027c */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0205 A[Catch: all -> 0x0031, zzgaz -> 0x0034, TryCatch #17 {zzgaz -> 0x0034, all -> 0x0031, blocks: (B:5:0x000a, B:8:0x0010, B:10:0x0019, B:12:0x0028, B:22:0x003d, B:23:0x003f, B:34:0x009e, B:83:0x01dd, B:84:0x01f9, B:85:0x01ff, B:87:0x0205, B:89:0x021b, B:90:0x022a, B:93:0x022e, B:94:0x024a, B:37:0x00d5, B:48:0x0122, B:67:0x01a5, B:68:0x01a8, B:77:0x01b9, B:78:0x01bf, B:80:0x01c2, B:26:0x0077, B:33:0x009b, B:99:0x0253, B:98:0x0250, B:100:0x0254, B:101:0x0259, B:102:0x025a, B:103:0x025f, B:104:0x0260, B:105:0x0265, B:106:0x0266, B:107:0x026b), top: B:133:0x000a, outer: #15 }] */
    @Override // com.google.android.gms.internal.ads.zzgev
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void zza() {
        /*
            Method dump skipped, instructions count: 642
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgex.zza():void");
    }

    @Override // com.google.android.gms.internal.ads.zzgev
    public final synchronized boolean zzb() {
        return this.f32416j;
    }
}
