package com.google.android.play.core.appupdate;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* loaded from: classes.dex */
final class zzr {

    /* renamed from: e, reason: collision with root package name */
    public static final com.google.android.play.core.appupdate.internal.zzm f41736e = new com.google.android.play.core.appupdate.internal.zzm("AppUpdateService");

    /* renamed from: f, reason: collision with root package name */
    public static final Intent f41737f = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.play.core.appupdate.internal.zzx f41738a;

    /* renamed from: b, reason: collision with root package name */
    public final String f41739b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f41740c;

    /* renamed from: d, reason: collision with root package name */
    public final zzt f41741d;

    public zzr(Context context, zzt zztVar) throws NoSuchAlgorithmException {
        this.f41739b = context.getPackageName();
        this.f41740c = context;
        this.f41741d = zztVar;
        com.google.android.play.core.appupdate.internal.zzm zzmVar = com.google.android.play.core.appupdate.internal.zzab.f41674a;
        try {
            if (context.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled) {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo("com.android.vending", 64).signatures;
                if (signatureArr == null || (signatureArr.length) == 0) {
                    Object[] objArr = new Object[0];
                    com.google.android.play.core.appupdate.internal.zzm zzmVar2 = com.google.android.play.core.appupdate.internal.zzab.f41674a;
                    zzmVar2.getClass();
                    if (Log.isLoggable("PlayCore", 5)) {
                        Log.w("PlayCore", com.google.android.play.core.appupdate.internal.zzm.d(zzmVar2.f41687a, "Phonesky package is not signed -- possibly self-built package. Could not verify.", objArr));
                        return;
                    }
                    return;
                }
                for (Signature signature : signatureArr) {
                    String strA = com.google.android.play.core.appupdate.internal.zzaa.a(signature.toByteArray());
                    if (!"8P1sW0EPJcslw7UzRsiXL64w-O50Ed-RBICtay1g24M".equals(strA)) {
                        String str = Build.TAGS;
                        if ((!str.contains("dev-keys") && !str.contains("test-keys")) || !"GXWy8XF3vIml3_MfnmSmyuKBpT3B0dWbHRR_4cgq-gA".equals(strA)) {
                        }
                    }
                    Context applicationContext = context.getApplicationContext();
                    this.f41738a = new com.google.android.play.core.appupdate.internal.zzx(applicationContext != null ? applicationContext : context, f41736e, f41737f);
                    return;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static Bundle a(zzr zzrVar, String str) {
        Integer numValueOf;
        Bundle bundle = new Bundle();
        bundle.putAll(b());
        bundle.putString("package.name", str);
        try {
            numValueOf = Integer.valueOf(zzrVar.f41740c.getPackageManager().getPackageInfo(zzrVar.f41740c.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            Object[] objArr = new Object[0];
            com.google.android.play.core.appupdate.internal.zzm zzmVar = f41736e;
            zzmVar.getClass();
            if (Log.isLoggable("PlayCore", 6)) {
                Log.e("PlayCore", com.google.android.play.core.appupdate.internal.zzm.d(zzmVar.f41687a, "The current version of the app could not be retrieved", objArr));
            }
            numValueOf = null;
        }
        if (numValueOf != null) {
            bundle.putInt("app.version.code", numValueOf.intValue());
        }
        return bundle;
    }

    public static Bundle b() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        Map mapA = com.google.android.play.core.appupdate.internal.zzi.a();
        bundle2.putInt("playcore_version_code", ((Integer) mapA.get("java")).intValue());
        if (mapA.containsKey("native")) {
            bundle2.putInt("playcore_native_version", ((Integer) mapA.get("native")).intValue());
        }
        if (mapA.containsKey("unity")) {
            bundle2.putInt("playcore_unity_version", ((Integer) mapA.get("unity")).intValue());
        }
        bundle.putAll(bundle2);
        bundle.putInt("playcore.version.code", 11004);
        return bundle;
    }
}
