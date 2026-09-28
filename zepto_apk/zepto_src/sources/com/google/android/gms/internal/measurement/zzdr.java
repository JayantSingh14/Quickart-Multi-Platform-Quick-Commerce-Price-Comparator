package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzdr extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Context f36867e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Bundle f36868f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ zzfb f36869g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdr(zzfb zzfbVar, Context context, Bundle bundle) {
        super(zzfbVar, true);
        this.f36867e = context;
        this.f36868f = bundle;
        Objects.requireNonNull(zzfbVar);
        this.f36869g = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        Boolean boolValueOf;
        try {
            Context context = this.f36867e;
            Preconditions.checkNotNull(context);
            String strA = com.google.android.gms.measurement.internal.zzht.a(context);
            Preconditions.checkNotNull(context);
            Resources resources = context.getResources();
            if (TextUtils.isEmpty(strA)) {
                strA = com.google.android.gms.measurement.internal.zzht.a(context);
            }
            int identifier = resources.getIdentifier("google_analytics_force_disable_updates", "bool", strA);
            zzcr zzcrVarAsInterface = null;
            if (identifier == 0) {
                boolValueOf = null;
            } else {
                try {
                    boolValueOf = Boolean.valueOf(resources.getBoolean(identifier));
                } catch (Resources.NotFoundException unused) {
                }
            }
            zzfb zzfbVar = this.f36869g;
            boolean z = boolValueOf == null || !boolValueOf.booleanValue();
            zzfbVar.getClass();
            try {
                zzcrVarAsInterface = zzcq.asInterface(DynamiteModule.c(context, z ? DynamiteModule.f22320d : DynamiteModule.f22319c, ModuleDescriptor.MODULE_ID).b("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
            } catch (DynamiteModule.LoadingException e2) {
                zzfbVar.k(e2, true, false);
            }
            zzfbVar.f36950g = zzcrVarAsInterface;
            if (zzfbVar.f36950g == null) {
                Log.w("FA", "Failed to connect to measurement client.");
                return;
            }
            int iA = DynamiteModule.a(context, ModuleDescriptor.MODULE_ID);
            ((zzcr) Preconditions.checkNotNull(zzfbVar.f36950g)).initialize(new ObjectWrapper(context), new zzdd(130000L, Math.max(iA, r6), Boolean.TRUE.equals(boolValueOf) || DynamiteModule.d(context, ModuleDescriptor.MODULE_ID, false) < iA, this.f36868f, com.google.android.gms.measurement.internal.zzht.a(context)), this.f36917a);
        } catch (Exception e3) {
            this.f36869g.k(e3, true, false);
        }
    }
}
