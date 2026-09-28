package com.google.android.gms.internal.p001authapiphone;

import com.google.android.gms.common.Feature;

/* loaded from: classes4.dex */
public final class zzal {

    /* renamed from: a, reason: collision with root package name */
    public static final Feature f36247a;

    /* renamed from: b, reason: collision with root package name */
    public static final Feature f36248b;

    /* renamed from: c, reason: collision with root package name */
    public static final Feature[] f36249c;

    static {
        Feature feature = new Feature("sms_code_autofill", 2L);
        Feature feature2 = new Feature("sms_code_browser", 2L);
        Feature feature3 = new Feature("sms_retrieve", 1L);
        f36247a = feature3;
        Feature feature4 = new Feature("user_consent", 3L);
        f36248b = feature4;
        f36249c = new Feature[]{feature, feature2, feature3, feature4, new Feature("missed_call_retriever", 2L)};
    }
}
