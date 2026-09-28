package com.google.android.gms.location;

import com.google.android.gms.common.Feature;

/* loaded from: classes4.dex */
public final class zzm {

    /* renamed from: a, reason: collision with root package name */
    public static final Feature f38385a;

    /* renamed from: b, reason: collision with root package name */
    public static final Feature f38386b;

    /* renamed from: c, reason: collision with root package name */
    public static final Feature f38387c;

    /* renamed from: d, reason: collision with root package name */
    public static final Feature f38388d;

    /* renamed from: e, reason: collision with root package name */
    public static final Feature f38389e;

    /* renamed from: f, reason: collision with root package name */
    public static final Feature[] f38390f;

    static {
        Feature feature = new Feature("name_ulr_private", 1L);
        Feature feature2 = new Feature("name_sleep_segment_request", 1L);
        Feature feature3 = new Feature("get_last_activity_feature_id", 1L);
        Feature feature4 = new Feature("support_context_feature_id", 1L);
        Feature feature5 = new Feature("get_current_location", 2L);
        f38385a = feature5;
        Feature feature6 = new Feature("get_last_location_with_request", 1L);
        f38386b = feature6;
        Feature feature7 = new Feature("set_mock_mode_with_callback", 1L);
        f38387c = feature7;
        Feature feature8 = new Feature("set_mock_location_with_callback", 1L);
        f38388d = feature8;
        Feature feature9 = new Feature("inject_location_with_callback", 1L);
        Feature feature10 = new Feature("location_updates_with_callback", 1L);
        f38389e = feature10;
        f38390f = new Feature[]{feature, feature2, feature3, feature4, feature5, feature6, feature7, feature8, feature9, feature10, new Feature("use_safe_parcelable_in_intents", 1L)};
    }
}
