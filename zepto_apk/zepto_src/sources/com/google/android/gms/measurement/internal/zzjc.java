package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class zzjc extends zzfz {

    /* renamed from: a, reason: collision with root package name */
    public final zzpf f39177a;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f39178b;

    /* renamed from: c, reason: collision with root package name */
    public String f39179c;

    public zzjc(zzpf zzpfVar) {
        Preconditions.checkNotNull(zzpfVar);
        this.f39177a = zzpfVar;
        this.f39179c = null;
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void B8(final zzr zzrVar, final Bundle bundle, final zzgd zzgdVar) throws PackageManager.NameNotFoundException {
        j1(zzrVar);
        final String str = (String) Preconditions.checkNotNull(zzrVar.f39648a);
        this.f39177a.c().p(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzix
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                zzgd zzgdVar2 = zzgdVar;
                zzpf zzpfVar = this.f39155a.f39177a;
                zzpfVar.A();
                try {
                    zzgdVar2.J0(zzpfVar.b0(bundle, zzrVar));
                } catch (RemoteException e2) {
                    zzpfVar.b().f38958f.c("Failed to return trigger URIs for app", str, e2);
                }
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void C1(zzah zzahVar, zzr zzrVar) throws PackageManager.NameNotFoundException {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotNull(zzahVar.f38678c);
        j1(zzrVar);
        zzah zzahVar2 = new zzah(zzahVar);
        zzahVar2.f38676a = zzrVar.f39648a;
        V2(new zzig(this, zzahVar2, zzrVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void D5(zzr zzrVar, final zzon zzonVar, final zzgg zzggVar) throws PackageManager.NameNotFoundException {
        j1(zzrVar);
        final String str = (String) Preconditions.checkNotNull(zzrVar.f39648a);
        this.f39177a.c().p(new Runnable() { // from class: com.google.android.gms.measurement.internal.zziy
            /* JADX WARN: Can't wrap try/catch for region: R(16:43|8|(1:10)(5:11|(4:14|(0)|29|46)|31|29|46)|16|(2:19|17)|48|20|38|21|(2:24|22)|49|25|(1:27)|28|29|46) */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x0167, code lost:
            
                r2.b().f38961i.b(r7, "Failed to parse queued batch. appId");
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void run() throws java.lang.Throwable {
                /*
                    Method dump skipped, instructions count: 434
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziy.run():void");
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void J7(long j2, String str, String str2, String str3) {
        V2(new zzif(this, str2, str3, str, j2));
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void M7(zzr zzrVar) throws PackageManager.NameNotFoundException {
        String str = zzrVar.f39648a;
        Preconditions.checkNotEmpty(str);
        w1(str, false);
        V2(new zzin(this, zzrVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void Nb(zzr zzrVar) {
        Preconditions.checkNotEmpty(zzrVar.f39648a);
        Preconditions.checkNotNull(zzrVar.s);
        z0(new zzio(this, zzrVar));
    }

    public final void V2(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        zzpf zzpfVar = this.f39177a;
        if (zzpfVar.c().m()) {
            runnable.run();
        } else {
            zzpfVar.c().p(runnable);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final zzao V9(zzr zzrVar) throws ExecutionException, InterruptedException, PackageManager.NameNotFoundException, TimeoutException {
        j1(zzrVar);
        String str = zzrVar.f39648a;
        Preconditions.checkNotEmpty(str);
        zzpf zzpfVar = this.f39177a;
        try {
            return (zzao) ((FutureTask) zzpfVar.c().o(new zzip(this, zzrVar))).get(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            zzgt zzgtVarB = zzpfVar.b();
            zzgtVarB.f38958f.c("Failed to get consent. appId", zzgt.o(str), e2);
            return new zzao(null);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void Wa(zzr zzrVar) throws PackageManager.NameNotFoundException {
        j1(zzrVar);
        V2(new zzie(this, zzrVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final List Z2(String str, String str2, String str3) throws ExecutionException, InterruptedException, PackageManager.NameNotFoundException {
        w1(str, true);
        zzpf zzpfVar = this.f39177a;
        try {
            return (List) ((FutureTask) zzpfVar.c().n(new zzil(this, str, str2, str3))).get();
        } catch (InterruptedException | ExecutionException e2) {
            zzpfVar.b().f38958f.b(e2, "Failed to get conditional user properties as");
            return Collections.EMPTY_LIST;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void aa(final Bundle bundle, final zzr zzrVar) throws PackageManager.NameNotFoundException {
        j1(zzrVar);
        final String str = zzrVar.f39648a;
        Preconditions.checkNotNull(str);
        V2(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzja
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                zzpf zzpfVar = this.f39171a.f39177a;
                boolean zQ = zzpfVar.d0().q(null, zzfx.V0);
                Bundle bundle2 = bundle;
                boolean zIsEmpty = bundle2.isEmpty();
                String str2 = str;
                if (zIsEmpty && zQ) {
                    zzav zzavVar = zzpfVar.f39596c;
                    zzpf.S(zzavVar);
                    zzavVar.g();
                    zzavVar.h();
                    try {
                        zzavVar.X().execSQL("delete from default_event_params where app_id=?", new String[]{str2});
                        return;
                    } catch (SQLiteException e2) {
                        zzgt zzgtVar = zzavVar.f39180a.f39089f;
                        zzib.l(zzgtVar);
                        zzgtVar.f38958f.b(e2, "Error clearing default event params");
                        return;
                    }
                }
                zzav zzavVar2 = zzpfVar.f39596c;
                zzpf.S(zzavVar2);
                zzavVar2.g();
                zzavVar2.h();
                zzbb zzbbVar = new zzbb(zzavVar2.f39180a, "", str2, "dep", 0L, 0L, bundle2);
                zzpj zzpjVar = zzavVar2.f39551b.f39600g;
                zzpf.S(zzpjVar);
                byte[] bArrF = zzpjVar.D(zzbbVar).f();
                zzgt zzgtVar2 = zzavVar2.f39180a.f39089f;
                zzib.l(zzgtVar2);
                zzgtVar2.n.c("Saving default event parameters, appId, data size", str2, Integer.valueOf(bArrF.length));
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str2);
                contentValues.put("parameters", bArrF);
                try {
                    if (zzavVar2.X().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                        zzib.l(zzgtVar2);
                        zzgtVar2.f38958f.b(zzgt.o(str2), "Failed to insert default event parameters (got -1). appId");
                    }
                } catch (SQLiteException e3) {
                    zzib.l(zzgtVar2);
                    zzgtVar2.f38958f.c("Error storing default event parameters. appId", zzgt.o(str2), e3);
                }
                zzav zzavVar3 = zzpfVar.f39596c;
                zzpf.S(zzavVar3);
                long j2 = zzrVar.D;
                try {
                    if (zzavVar3.D(0L, "select count(*) from raw_events where app_id=? and timestamp >= ? and name not like '!_%' escape '!' limit 1;", new String[]{str2, String.valueOf(j2)}) > 0) {
                        return;
                    }
                    if (zzavVar3.D(0L, "select count(*) from raw_events where app_id=? and timestamp >= ? and name like '!_%' escape '!' limit 1;", new String[]{str2, String.valueOf(j2)}) > 0) {
                        zzav zzavVar4 = zzpfVar.f39596c;
                        zzpf.S(zzavVar4);
                        zzavVar4.A(str2, Long.valueOf(j2), null, bundle2);
                    }
                } catch (SQLiteException e4) {
                    zzgt zzgtVar3 = zzavVar3.f39180a.f39089f;
                    zzib.l(zzgtVar3);
                    zzgtVar3.f38958f.b(e4, "Error checking backfill conditions");
                }
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void e4(zzbg zzbgVar, zzr zzrVar) throws PackageManager.NameNotFoundException {
        Preconditions.checkNotNull(zzbgVar);
        j1(zzrVar);
        V2(new zziq(this, zzbgVar, zzrVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final List fb(String str, String str2, boolean z, zzr zzrVar) throws ExecutionException, InterruptedException, PackageManager.NameNotFoundException {
        j1(zzrVar);
        String str3 = zzrVar.f39648a;
        Preconditions.checkNotNull(str3);
        zzpf zzpfVar = this.f39177a;
        try {
            List<zzpm> list = (List) ((FutureTask) zzpfVar.c().n(new zzii(this, str3, str, str2))).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzpm zzpmVar : list) {
                if (z || !zzpo.D(zzpmVar.f39635c)) {
                    arrayList.add(new zzpk(zzpmVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            zzgt zzgtVarB = zzpfVar.b();
            zzgtVarB.f38958f.c("Failed to query user properties. appId", zzgt.o(str3), e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e3) {
            e = e3;
            zzgt zzgtVarB2 = zzpfVar.b();
            zzgtVarB2.f38958f.c("Failed to query user properties. appId", zzgt.o(str3), e);
            return Collections.EMPTY_LIST;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void h4(zzr zzrVar) throws PackageManager.NameNotFoundException {
        j1(zzrVar);
        V2(new zzim(this, zzrVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void h9(zzpk zzpkVar, zzr zzrVar) throws PackageManager.NameNotFoundException {
        Preconditions.checkNotNull(zzpkVar);
        j1(zzrVar);
        V2(new zzit(this, zzpkVar, zzrVar));
    }

    public final void j1(zzr zzrVar) throws PackageManager.NameNotFoundException {
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.f39648a;
        Preconditions.checkNotEmpty(str);
        w1(str, false);
        this.f39177a.j0().k(zzrVar.f39649b);
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final String j6(zzr zzrVar) throws ExecutionException, InterruptedException, PackageManager.NameNotFoundException, TimeoutException {
        j1(zzrVar);
        zzpf zzpfVar = this.f39177a;
        try {
            return (String) ((FutureTask) zzpfVar.c().n(new zzoy(zzpfVar, zzrVar))).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            zzgt zzgtVarB = zzpfVar.b();
            zzgtVarB.f38958f.c("Failed to get app instance id. appId", zzgt.o(zzrVar.f39648a), e2);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void m4(final zzr zzrVar) {
        Preconditions.checkNotEmpty(zzrVar.f39648a);
        Preconditions.checkNotNull(zzrVar.s);
        z0(new Runnable() { // from class: com.google.android.gms.measurement.internal.zziw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() throws IOException {
                zzpf zzpfVar = this.f39153a.f39177a;
                zzpfVar.A();
                zzpfVar.m0(zzrVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void p3(final zzr zzrVar) {
        Preconditions.checkNotEmpty(zzrVar.f39648a);
        Preconditions.checkNotNull(zzrVar.s);
        z0(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjb
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() throws IOException {
                zzpf zzpfVar = this.f39175a.f39177a;
                zzpfVar.A();
                zzpfVar.l0(zzrVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final List pb(String str, String str2, zzr zzrVar) throws ExecutionException, InterruptedException, PackageManager.NameNotFoundException {
        j1(zzrVar);
        String str3 = zzrVar.f39648a;
        Preconditions.checkNotNull(str3);
        zzpf zzpfVar = this.f39177a;
        try {
            return (List) ((FutureTask) zzpfVar.c().n(new zzik(this, str3, str, str2))).get();
        } catch (InterruptedException | ExecutionException e2) {
            zzpfVar.b().f38958f.b(e2, "Failed to get conditional user properties");
            return Collections.EMPTY_LIST;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final byte[] v4(zzbg zzbgVar, String str) throws ExecutionException, InterruptedException, PackageManager.NameNotFoundException {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbgVar);
        w1(str, true);
        zzpf zzpfVar = this.f39177a;
        zzgt zzgtVarB = zzpfVar.b();
        zzib zzibVar = zzpfVar.f39605l;
        zzgm zzgmVar = zzibVar.f39093j;
        String str2 = zzbgVar.f38769a;
        zzgtVarB.f38965m.b(zzgmVar.a(str2), "Log and bundle. event");
        long jNanoTime = zzpfVar.f().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) ((FutureTask) zzpfVar.c().o(new zzis(this, zzbgVar, str))).get();
            if (bArr == null) {
                zzpfVar.b().f38958f.b(zzgt.o(str), "Log and bundle returned null. appId");
                bArr = new byte[0];
            }
            zzpfVar.b().f38965m.d("Log and bundle processed. event, size, time_ms", zzibVar.f39093j.a(str2), Integer.valueOf(bArr.length), Long.valueOf((zzpfVar.f().nanoTime() / 1000000) - jNanoTime));
            return bArr;
        } catch (InterruptedException e2) {
            e = e2;
            zzgt zzgtVarB2 = zzpfVar.b();
            zzgtVarB2.f38958f.d("Failed to log and bundle. appId, event, error", zzgt.o(str), zzibVar.f39093j.a(zzbgVar.f38769a), e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            zzgt zzgtVarB22 = zzpfVar.b();
            zzgtVarB22.f38958f.d("Failed to log and bundle. appId, event, error", zzgt.o(str), zzibVar.f39093j.a(zzbgVar.f38769a), e);
            return null;
        }
    }

    public final void w1(String str, boolean z) throws PackageManager.NameNotFoundException {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        zzpf zzpfVar = this.f39177a;
        if (zIsEmpty) {
            zzpfVar.b().f38958f.a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.f39178b == null) {
                    boolean z2 = true;
                    if (!"com.google.android.gms".equals(this.f39179c) && !UidVerifier.isGooglePlayServicesUid(zzpfVar.f39605l.f39084a, Binder.getCallingUid()) && !GoogleSignatureVerifier.getInstance(zzpfVar.f39605l.f39084a).isUidGoogleSigned(Binder.getCallingUid())) {
                        z2 = false;
                    }
                    this.f39178b = Boolean.valueOf(z2);
                }
                if (this.f39178b.booleanValue()) {
                    return;
                }
            } catch (SecurityException e2) {
                zzpfVar.b().f38958f.b(zzgt.o(str), "Measurement Service called with invalid calling package. appId");
                throw e2;
            }
        }
        if (this.f39179c == null && GooglePlayServicesUtilLight.uidHasPackageName(zzpfVar.f39605l.f39084a, Binder.getCallingUid(), str)) {
            this.f39179c = str;
        }
        if (str.equals(this.f39179c)) {
            return;
        }
        throw new SecurityException("Unknown calling package name '" + str + "'.");
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void y9(final zzr zzrVar, final zzaf zzafVar) throws PackageManager.NameNotFoundException {
        j1(zzrVar);
        V2(new Runnable() { // from class: com.google.android.gms.measurement.internal.zziz
            /* JADX WARN: Removed duplicated region for block: B:32:0x00f2  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x00f8  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x0109  */
            /* JADX WARN: Removed duplicated region for block: B:64:0x0216  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void run() throws java.lang.Throwable {
                /*
                    Method dump skipped, instructions count: 538
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziz.run():void");
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final void ya(zzr zzrVar) throws PackageManager.NameNotFoundException {
        j1(zzrVar);
        V2(new zzid(this, zzrVar));
    }

    public final void z0(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        zzpf zzpfVar = this.f39177a;
        if (zzpfVar.c().m()) {
            runnable.run();
        } else {
            zzpfVar.c().r(runnable);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzga
    public final List z1(String str, String str2, String str3, boolean z) throws ExecutionException, InterruptedException, PackageManager.NameNotFoundException {
        w1(str, true);
        zzpf zzpfVar = this.f39177a;
        try {
            List<zzpm> list = (List) ((FutureTask) zzpfVar.c().n(new zzij(this, str, str2, str3))).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzpm zzpmVar : list) {
                if (z || !zzpo.D(zzpmVar.f39635c)) {
                    arrayList.add(new zzpk(zzpmVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            zzgt zzgtVarB = zzpfVar.b();
            zzgtVarB.f38958f.c("Failed to get user properties as. appId", zzgt.o(str), e);
            return Collections.EMPTY_LIST;
        } catch (ExecutionException e3) {
            e = e3;
            zzgt zzgtVarB2 = zzpfVar.b();
            zzgtVarB2.f38958f.c("Failed to get user properties as. appId", zzgt.o(str), e);
            return Collections.EMPTY_LIST;
        }
    }
}
