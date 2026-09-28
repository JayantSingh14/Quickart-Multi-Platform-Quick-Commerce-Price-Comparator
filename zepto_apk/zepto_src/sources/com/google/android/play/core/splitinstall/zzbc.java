package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import com.google.android.play.core.splitinstall.internal.zzbu;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes4.dex */
final class zzbc {

    /* renamed from: c, reason: collision with root package name */
    public static final com.google.android.play.core.splitinstall.internal.zzu f42103c = new com.google.android.play.core.splitinstall.internal.zzu("SplitInstallService");

    /* renamed from: d, reason: collision with root package name */
    public static final Intent f42104d = new Intent("com.google.android.play.core.splitinstall.BIND_SPLIT_INSTALL_SERVICE").setPackage("com.android.vending");

    /* renamed from: a, reason: collision with root package name */
    public final String f42105a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.play.core.splitinstall.internal.zzaf f42106b;

    public zzbc(Context context, String str) throws NoSuchAlgorithmException {
        String strEncodeToString;
        this.f42105a = str;
        com.google.android.play.core.splitinstall.internal.zzu zzuVar = zzbu.f41970a;
        try {
            if (context.getPackageManager().getApplicationInfo("com.android.vending", 0).enabled) {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo("com.android.vending", 64).signatures;
                if (signatureArr == null || (signatureArr.length) == 0) {
                    zzbu.f41970a.e("Phonesky package is not signed -- possibly self-built package. Could not verify.", new Object[0]);
                    return;
                }
                for (Signature signature : signatureArr) {
                    byte[] byteArray = signature.toByteArray();
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
                        messageDigest.update(byteArray);
                        strEncodeToString = Base64.encodeToString(messageDigest.digest(), 11);
                    } catch (NoSuchAlgorithmException unused) {
                        strEncodeToString = "";
                    }
                    if (!"8P1sW0EPJcslw7UzRsiXL64w-O50Ed-RBICtay1g24M".equals(strEncodeToString)) {
                        String str2 = Build.TAGS;
                        if ((!str2.contains("dev-keys") && !str2.contains("test-keys")) || !"GXWy8XF3vIml3_MfnmSmyuKBpT3B0dWbHRR_4cgq-gA".equals(strEncodeToString)) {
                        }
                    }
                    Context applicationContext = context.getApplicationContext();
                    this.f42106b = new com.google.android.play.core.splitinstall.internal.zzaf(applicationContext != null ? applicationContext : context, f42103c, f42104d);
                    return;
                }
            }
        } catch (PackageManager.NameNotFoundException unused2) {
        }
    }

    public static Bundle a(com.google.android.play.core.splitinstall.internal.zzn zznVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 11004);
        ArrayList arrayList = new ArrayList();
        Iterator it = zznVar.f41987a.iterator();
        while (it.hasNext()) {
            com.google.android.play.core.splitinstall.internal.zzp zzpVar = (com.google.android.play.core.splitinstall.internal.zzp) it.next();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("event_type", zzpVar.a());
            bundle2.putLong("event_timestamp", zzpVar.b());
            arrayList.add(bundle2);
        }
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(arrayList));
        return bundle;
    }
}
