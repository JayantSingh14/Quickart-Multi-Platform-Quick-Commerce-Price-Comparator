package com.google.android.gms.ads.internal.util.client;

import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class zzt {

    /* renamed from: a, reason: collision with root package name */
    public static final zzt f21443a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzt f21444b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzt f21445c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzt f21446d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ zzt[] f21447e;

    static {
        zzt zztVar = new zzt(MerchantConstants.SUCCESS, 0);
        f21443a = zztVar;
        zzt zztVar2 = new zzt("PERMANENT_FAILURE", 1);
        f21444b = zztVar2;
        zzt zztVar3 = new zzt("RETRIABLE_FAILURE", 2);
        f21445c = zztVar3;
        zzt zztVar4 = new zzt("BUFFERED", 3);
        f21446d = zztVar4;
        f21447e = new zzt[]{zztVar, zztVar2, zztVar3, zztVar4};
    }

    public static zzt[] values() {
        return (zzt[]) f21447e.clone();
    }
}
