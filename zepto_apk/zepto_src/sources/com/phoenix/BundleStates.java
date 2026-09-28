package com.phoenix;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes4.dex */
public final class BundleStates {

    /* renamed from: a, reason: collision with root package name */
    public static final BundleStates f46100a;

    /* renamed from: b, reason: collision with root package name */
    public static final BundleStates f46101b;

    /* renamed from: c, reason: collision with root package name */
    public static final BundleStates f46102c;

    /* renamed from: d, reason: collision with root package name */
    public static final BundleStates f46103d;

    /* renamed from: e, reason: collision with root package name */
    public static final BundleStates f46104e;

    /* renamed from: f, reason: collision with root package name */
    public static final BundleStates f46105f;

    /* renamed from: g, reason: collision with root package name */
    public static final BundleStates f46106g;

    /* renamed from: h, reason: collision with root package name */
    public static final BundleStates f46107h;

    /* renamed from: i, reason: collision with root package name */
    public static final BundleStates f46108i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ BundleStates[] f46109j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f46110k;

    static {
        BundleStates bundleStates = new BundleStates("PATCH_UNZIPPED", 0);
        f46100a = bundleStates;
        BundleStates bundleStates2 = new BundleStates("PATCH_UNZIPPED_FAILED", 1);
        f46101b = bundleStates2;
        BundleStates bundleStates3 = new BundleStates("PATCH_APPLIED", 2);
        f46102c = bundleStates3;
        BundleStates bundleStates4 = new BundleStates("PATCH_FAILED", 3);
        f46103d = bundleStates4;
        BundleStates bundleStates5 = new BundleStates("BUNDLE_UNZIPPED_FAILED", 4);
        f46104e = bundleStates5;
        BundleStates bundleStates6 = new BundleStates("BUNDLE_UNZIPPED", 5);
        f46105f = bundleStates6;
        BundleStates bundleStates7 = new BundleStates("READY_TO_INSTALL", 6);
        f46106g = bundleStates7;
        BundleStates bundleStates8 = new BundleStates("INSTALLED", 7);
        f46107h = bundleStates8;
        BundleStates bundleStates9 = new BundleStates("ROLL_BACK", 8);
        f46108i = bundleStates9;
        BundleStates[] bundleStatesArr = {bundleStates, bundleStates2, bundleStates3, bundleStates4, bundleStates5, bundleStates6, bundleStates7, bundleStates8, bundleStates9};
        f46109j = bundleStatesArr;
        f46110k = EnumEntriesKt.a(bundleStatesArr);
    }

    public static BundleStates valueOf(String str) {
        return (BundleStates) Enum.valueOf(BundleStates.class, str);
    }

    public static BundleStates[] values() {
        return (BundleStates[]) f46109j.clone();
    }
}
