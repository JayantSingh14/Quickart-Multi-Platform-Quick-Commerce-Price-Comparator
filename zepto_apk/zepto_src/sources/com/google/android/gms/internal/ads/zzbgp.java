package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@Deprecated
/* loaded from: classes4.dex */
public final class zzbgp {

    /* renamed from: d, reason: collision with root package name */
    public String f25032d;

    /* renamed from: e, reason: collision with root package name */
    public Context f25033e;

    /* renamed from: f, reason: collision with root package name */
    public String f25034f;

    /* renamed from: h, reason: collision with root package name */
    public AtomicBoolean f25036h;

    /* renamed from: i, reason: collision with root package name */
    public File f25037i;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayBlockingQueue f25029a = new ArrayBlockingQueue(100);

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f25030b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f25031c = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public final HashSet f25035g = new HashSet(Arrays.asList("noop", "activeViewPingSent", "viewabilityChanged", "visibilityChanged"));

    public final LinkedHashMap a(LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2) {
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(linkedHashMap);
        for (Map.Entry entry : linkedHashMap2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            String str3 = (String) linkedHashMap3.get(str);
            zzbgv zzbgvVar = (zzbgv) this.f25031c.get(str);
            if (zzbgvVar == null) {
                zzbgvVar = zzbgv.f25038a;
            }
            linkedHashMap3.put(str, zzbgvVar.a(str3, str2));
        }
        return linkedHashMap3;
    }

    public final void b(LinkedHashMap linkedHashMap, zzbgy zzbgyVar) throws Throwable {
        FileOutputStream fileOutputStream;
        Uri.Builder builderBuildUpon = Uri.parse(this.f25032d).buildUpon();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            builderBuildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        String string = builderBuildUpon.build().toString();
        if (zzbgyVar != null) {
            StringBuilder sb = new StringBuilder(string);
            String str = zzbgyVar.f25046a;
            if (!TextUtils.isEmpty(str)) {
                sb.append("&it=");
                sb.append(str);
            }
            String str2 = zzbgyVar.f25047b;
            if (!TextUtils.isEmpty(str2)) {
                sb.append("&blat=");
                sb.append(str2);
            }
            string = sb.toString();
        }
        FileOutputStream fileOutputStream2 = null;
        if (!this.f25036h.get()) {
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
            new com.google.android.gms.ads.internal.util.zzbt(this.f25033e, this.f25034f, string, null).b();
            return;
        }
        File file = this.f25037i;
        if (file == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("CsiReporter: File doesn't exist. Cannot write CSI data to file.");
            return;
        }
        try {
            try {
                fileOutputStream = new FileOutputStream(file, true);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(string.getBytes());
            fileOutputStream.write(10);
            try {
                fileOutputStream.close();
            } catch (IOException e3) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.g("CsiReporter: Cannot close file: sdk_csi_data.txt.", e3);
            }
        } catch (IOException e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    com.google.android.gms.ads.internal.util.client.zzo.g("CsiReporter: Cannot close file: sdk_csi_data.txt.", e5);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e6) {
                    int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.g("CsiReporter: Cannot close file: sdk_csi_data.txt.", e6);
                }
            }
            throw th;
        }
    }
}
