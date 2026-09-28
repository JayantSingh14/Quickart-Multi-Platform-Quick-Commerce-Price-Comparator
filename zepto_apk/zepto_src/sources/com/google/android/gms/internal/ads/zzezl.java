package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzezl implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30672a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f30673b;

    /* renamed from: c, reason: collision with root package name */
    public final VersionInfoParcel f30674c;

    /* renamed from: d, reason: collision with root package name */
    public final String f30675d;

    public zzezl(zzgyw zzgywVar, Context context, VersionInfoParcel versionInfoParcel, String str) {
        this.f30672a = zzgywVar;
        this.f30673b = context;
        this.f30674c = versionInfoParcel;
        this.f30675d = str;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30672a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzezk
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzezl zzezlVar = this.f30671a;
                Context context = zzezlVar.f30673b;
                boolean zIsCallerInstantApp = Wrappers.packageManager(context).isCallerInstantApp();
                com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
                boolean zF = com.google.android.gms.ads.internal.util.zzs.f(context);
                String str = zzezlVar.f30674c.f21400a;
                int iMyUid = Process.myUid();
                boolean z = iMyUid == 0 || iMyUid == 1000;
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                return new zzezm(zIsCallerInstantApp, zF, str, z, applicationInfo == null ? 0 : applicationInfo.targetSdkVersion, DynamiteModule.d(context, ModuleDescriptor.MODULE_ID, false), DynamiteModule.a(context, ModuleDescriptor.MODULE_ID), zzezlVar.f30675d);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 35;
    }
}
