package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.internal.zzjn;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ObjectArrays;
import in.juspay.airborne.ota.Constants;

/* loaded from: classes.dex */
public final class zzc {

    /* renamed from: a, reason: collision with root package name */
    public static final ImmutableSet f43541a = ImmutableSet.u("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire");

    /* renamed from: b, reason: collision with root package name */
    public static final ImmutableList f43542b;

    /* renamed from: c, reason: collision with root package name */
    public static final ImmutableList f43543c;

    /* renamed from: d, reason: collision with root package name */
    public static final ImmutableList f43544d;

    static {
        Object[] objArr = {"_e", "_f", "_iap", "_s", "_au", "_ui", "_cd"};
        ObjectArrays.a(7, objArr);
        f43542b = ImmutableList.m(7, objArr);
        Object[] objArr2 = {"auto", Constants.APP_DIR, "am"};
        ObjectArrays.a(3, objArr2);
        f43543c = ImmutableList.m(3, objArr2);
        f43544d = ImmutableList.u("_r", "_dbg");
        ImmutableList.Builder builder = new ImmutableList.Builder();
        builder.i(zzjn.f39209a);
        builder.i(zzjn.f39210b);
        builder.j();
        ImmutableList.u("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");
    }
}
