package com.google.android.gms.ads.internal.util.client;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* loaded from: classes4.dex */
public final class zzs {
    public static Object a(Context context, String str, zzq zzqVar) throws zzr {
        try {
            return zzqVar.a(b(context).b(str));
        } catch (Exception e2) {
            throw new zzr(e2);
        }
    }

    public static DynamiteModule b(Context context) throws zzr {
        try {
            return DynamiteModule.c(context, DynamiteModule.f22318b, ModuleDescriptor.MODULE_ID);
        } catch (Exception e2) {
            throw new zzr(e2);
        }
    }
}
