package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
final class zzgfg extends zzgfz {

    /* renamed from: f, reason: collision with root package name */
    public final Map f32446f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f32447g;

    /* renamed from: h, reason: collision with root package name */
    public final zzgba f32448h;

    /* renamed from: i, reason: collision with root package name */
    public final long f32449i;

    /* renamed from: j, reason: collision with root package name */
    public final long f32450j;

    public zzgfg(zzavs zzavsVar, zzgev zzgevVar, Map map, Context context, zzgba zzgbaVar, zzgad zzgadVar, zzgnc zzgncVar) {
        super("psdxhJQzj8JPGxUndFNRSuISrw/zf4LHyLEfW3r2aQ42o49HP5NqkxdFySNU3Xfl", "izTl1LmxrTMVVIqTN/Y0k7CnXfH3YKnExw0TgvQ6jLg=", zzavsVar, zzgevVar, zzgncVar.a(WKSRecord.Service.AUTH));
        this.f32447g = context;
        this.f32446f = map;
        this.f32448h = zzgbaVar;
        this.f32449i = zzgadVar.P();
        this.f32450j = zzgadVar.Q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzgfz
    public final void a(Method method, zzavs zzavsVar) {
        zzawp zzawpVar;
        Object[] objArr = (Object[]) method.invoke("", this.f32447g, Integer.valueOf(this.f32448h.ordinal()));
        objArr.getClass();
        String strY0 = "E";
        int i2 = 1;
        try {
            ListenableFuture listenableFuture = (ListenableFuture) this.f32446f.get("gs");
            if (listenableFuture != null && ((Build.VERSION.SDK_INT < 31 || listenableFuture.isDone()) && (zzawpVar = (zzawp) listenableFuture.get(this.f32449i, TimeUnit.MILLISECONDS)) != null && zzawpVar.y0().length() > 1)) {
                strY0 = zzawpVar.y0();
            }
        } catch (ClassCastException | InterruptedException | ExecutionException | TimeoutException unused) {
        }
        if (strY0.equals("E")) {
            try {
                ListenableFuture listenableFuture2 = (ListenableFuture) this.f32446f.get("ai");
                if (listenableFuture2 != null) {
                    String str = (String) listenableFuture2.get(this.f32450j, TimeUnit.MILLISECONDS);
                    if (!zzgpz.a(str)) {
                        strY0 = str;
                    }
                }
            } catch (ClassCastException | InterruptedException | ExecutionException | TimeoutException unused2) {
            }
        }
        Boolean bool = (Boolean) objArr[5];
        synchronized (zzavsVar) {
            try {
                long jLongValue = ((Long) objArr[0]).longValue();
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).H(jLongValue);
                String str2 = (String) objArr[1];
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).G(str2);
                String str3 = (String) objArr[2];
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).Q(str3);
                String str4 = (String) objArr[3];
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).R(str4);
                zzgvy zzgvyVarF = zzgvy.f33277c.f();
                byte[] bArr = (byte[]) objArr[4];
                String strG = zzgvyVarF.g(bArr.length, bArr);
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).C(strG);
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).V0(strY0);
                if (bool != null) {
                    if (true == bool.booleanValue()) {
                        i2 = 2;
                    }
                    zzavsVar.j();
                    ((zzawp) zzavsVar.f34638b).w0(i2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
