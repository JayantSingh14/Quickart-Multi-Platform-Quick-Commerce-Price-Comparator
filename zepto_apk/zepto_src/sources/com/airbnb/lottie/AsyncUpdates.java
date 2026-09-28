package com.airbnb.lottie;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class AsyncUpdates {

    /* renamed from: a, reason: collision with root package name */
    public static final AsyncUpdates f14103a;

    /* renamed from: b, reason: collision with root package name */
    public static final AsyncUpdates f14104b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AsyncUpdates[] f14105c;

    static {
        AsyncUpdates asyncUpdates = new AsyncUpdates("AUTOMATIC", 0);
        f14103a = asyncUpdates;
        AsyncUpdates asyncUpdates2 = new AsyncUpdates("ENABLED", 1);
        f14104b = asyncUpdates2;
        f14105c = new AsyncUpdates[]{asyncUpdates, asyncUpdates2, new AsyncUpdates("DISABLED", 2)};
    }

    public static AsyncUpdates valueOf(String str) {
        return (AsyncUpdates) Enum.valueOf(AsyncUpdates.class, str);
    }

    public static AsyncUpdates[] values() {
        return (AsyncUpdates[]) f14105c.clone();
    }
}
