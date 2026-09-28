package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.internal.ads.zzbhk;
import com.google.android.gms.internal.ads.zzbhl;
import com.google.android.gms.internal.ads.zzijw;
import com.google.android.gms.internal.ads.zzijx;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzk implements zzbhk {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbhl f21593a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f21594b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f21595c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Uri f21596d;

    public zzk(zzs zzsVar, zzbhl zzbhlVar, Bundle bundle, Context context, Uri uri) {
        this.f21593a = zzbhlVar;
        this.f21594b = bundle;
        this.f21595c = context;
        this.f21596d = uri;
        Objects.requireNonNull(zzsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbhk
    public final void zza() {
        zzbhl zzbhlVar = this.f21593a;
        CustomTabsClient customTabsClient = zzbhlVar.f25064b;
        if (customTabsClient == null) {
            zzbhlVar.f25063a = null;
        } else if (zzbhlVar.f25063a == null) {
            zzbhlVar.f25063a = customTabsClient.b(null);
        }
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(zzbhlVar.f25063a);
        zzs.z(builder, this.f21594b);
        CustomTabsIntent customTabsIntentA = builder.a();
        Context context = this.f21595c;
        customTabsIntentA.f1341a.setPackage(zzijw.a(context));
        customTabsIntentA.a(context, this.f21596d);
        Activity activity = (Activity) context;
        zzijx zzijxVar = zzbhlVar.f25065c;
        if (zzijxVar == null) {
            return;
        }
        activity.unbindService(zzijxVar);
        zzbhlVar.f25064b = null;
        zzbhlVar.f25063a = null;
        zzbhlVar.f25065c = null;
    }
}
