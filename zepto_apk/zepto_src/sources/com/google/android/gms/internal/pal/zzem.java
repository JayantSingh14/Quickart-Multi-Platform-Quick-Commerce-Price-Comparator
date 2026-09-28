package com.google.android.gms.internal.pal;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
public final class zzem extends zzfg {
    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f37723a.f37646m) {
            c();
            return;
        }
        synchronized (this.f37726d) {
            this.f37726d.o((String) this.f37727e.invoke(null, this.f37723a.f37634a));
        }
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void b() throws ExecutionException, InterruptedException, TimeoutException {
        zzdu zzduVar = this.f37723a;
        if (zzduVar.p) {
            super.b();
        } else if (zzduVar.f37646m) {
            c();
        }
    }

    public final void c() throws ExecutionException, InterruptedException, TimeoutException {
        Future future;
        zzdu zzduVar = this.f37723a;
        AdvertisingIdClient advertisingIdClient = null;
        if (zzduVar.f37640g) {
            if (zzduVar.f37639f == null && (future = zzduVar.f37641h) != null) {
                try {
                    future.get(2000L, TimeUnit.MILLISECONDS);
                    zzduVar.f37641h = null;
                } catch (InterruptedException | ExecutionException unused) {
                } catch (TimeoutException unused2) {
                    zzduVar.f37641h.cancel(true);
                }
            }
            advertisingIdClient = zzduVar.f37639f;
        }
        if (advertisingIdClient == null) {
            return;
        }
        try {
            AdvertisingIdClient.Info infoF = advertisingIdClient.f();
            String strB = zzdx.b(infoF.f21070a);
            if (strB != null) {
                synchronized (this.f37726d) {
                    this.f37726d.o(strB);
                    zzr zzrVar = this.f37726d;
                    boolean z = infoF.f21071b;
                    if (zzrVar.f37406c) {
                        zzrVar.k();
                        zzrVar.f37406c = false;
                    }
                    zzaf.X((zzaf) zzrVar.f37405b, z);
                    zzr zzrVar2 = this.f37726d;
                    if (zzrVar2.f37406c) {
                        zzrVar2.k();
                        zzrVar2.f37406c = false;
                    }
                    zzaf.g0((zzaf) zzrVar2.f37405b);
                }
            }
        } catch (IOException unused3) {
        }
    }

    @Override // com.google.android.gms.internal.pal.zzfg, java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws ExecutionException, InterruptedException, TimeoutException {
        b();
        return null;
    }
}
