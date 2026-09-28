package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;

/* loaded from: classes4.dex */
public final class zzbfr {

    /* renamed from: a, reason: collision with root package name */
    public final Context f24978a;

    public zzbfr(Context context) {
        Preconditions.checkNotNull(context, "Context can not be null");
        this.f24978a = context;
    }

    public final boolean a() {
        zzbfq zzbfqVar = zzbfq.f24977a;
        Context context = this.f24978a;
        return ((Boolean) com.google.android.gms.ads.internal.util.zzcb.a(context, zzbfqVar)).booleanValue() && Wrappers.packageManager(context).checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public final boolean b(Intent intent) {
        Preconditions.checkNotNull(intent, "Intent can not be null");
        return !this.f24978a.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }
}
