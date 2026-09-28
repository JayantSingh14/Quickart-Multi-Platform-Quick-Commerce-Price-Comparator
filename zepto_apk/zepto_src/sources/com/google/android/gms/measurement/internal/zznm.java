package com.google.android.gms.measurement.internal;

import android.content.pm.PackageManager;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public final class zznm extends zzor {

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f39495d;

    /* renamed from: e, reason: collision with root package name */
    public final zzhd f39496e;

    /* renamed from: f, reason: collision with root package name */
    public final zzhd f39497f;

    /* renamed from: g, reason: collision with root package name */
    public final zzhd f39498g;

    /* renamed from: h, reason: collision with root package name */
    public final zzhd f39499h;

    /* renamed from: i, reason: collision with root package name */
    public final zzhd f39500i;

    /* renamed from: j, reason: collision with root package name */
    public final zzhd f39501j;

    public zznm(zzpf zzpfVar) {
        super(zzpfVar);
        this.f39495d = new HashMap();
        zzhg zzhgVar = this.f39180a.f39088e;
        zzib.j(zzhgVar);
        this.f39496e = new zzhd(zzhgVar, "last_delete_stale", 0L);
        zzhg zzhgVar2 = this.f39180a.f39088e;
        zzib.j(zzhgVar2);
        this.f39497f = new zzhd(zzhgVar2, "last_delete_stale_batch", 0L);
        zzhg zzhgVar3 = this.f39180a.f39088e;
        zzib.j(zzhgVar3);
        this.f39498g = new zzhd(zzhgVar3, "backoff", 0L);
        zzhg zzhgVar4 = this.f39180a.f39088e;
        zzib.j(zzhgVar4);
        this.f39499h = new zzhd(zzhgVar4, "last_upload", 0L);
        zzhg zzhgVar5 = this.f39180a.f39088e;
        zzib.j(zzhgVar5);
        this.f39500i = new zzhd(zzhgVar5, "last_upload_attempt", 0L);
        zzhg zzhgVar6 = this.f39180a.f39088e;
        zzib.j(zzhgVar6);
        this.f39501j = new zzhd(zzhgVar6, "midnight_offset", 0L);
    }

    public final Pair k(String str) {
        AdvertisingIdClient.Info infoA;
        zznl zznlVar;
        g();
        zzib zzibVar = this.f39180a;
        long jElapsedRealtime = zzibVar.f39094k.elapsedRealtime();
        HashMap map = this.f39495d;
        zznl zznlVar2 = (zznl) map.get(str);
        if (zznlVar2 != null && jElapsedRealtime < zznlVar2.f39494c) {
            return new Pair(zznlVar2.f39492a, Boolean.valueOf(zznlVar2.f39493b));
        }
        zzfw zzfwVar = zzfx.f38903b;
        zzal zzalVar = zzibVar.f39087d;
        long jN = zzalVar.n(str, zzfwVar) + jElapsedRealtime;
        try {
            try {
                infoA = AdvertisingIdClient.a(zzibVar.f39084a);
            } catch (PackageManager.NameNotFoundException unused) {
                if (zznlVar2 != null && jElapsedRealtime < zznlVar2.f39494c + zzalVar.n(str, zzfx.f38904c)) {
                    return new Pair(zznlVar2.f39492a, Boolean.valueOf(zznlVar2.f39493b));
                }
                infoA = null;
            }
        } catch (Exception e2) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38965m.b(e2, "Unable to get advertising id");
            zznlVar = new zznl(jN, "", false);
        }
        if (infoA == null) {
            return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String strA = infoA.a();
        zznlVar = strA != null ? new zznl(jN, strA, infoA.b()) : new zznl(jN, "", infoA.b());
        map.put(str, zznlVar);
        return new Pair(zznlVar.f39492a, Boolean.valueOf(zznlVar.f39493b));
    }

    public final String l(String str, boolean z) throws NoSuchAlgorithmException {
        g();
        String str2 = z ? (String) k(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest messageDigestX = zzpo.x();
        if (messageDigestX == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestX.digest(str2.getBytes())));
    }

    @Override // com.google.android.gms.measurement.internal.zzor
    public final void j() {
    }
}
