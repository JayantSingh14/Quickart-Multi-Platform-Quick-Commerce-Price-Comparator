package com.google.android.play.core.splitinstall;

import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class zzo implements zzg {

    /* renamed from: a, reason: collision with root package name */
    public static final zzo f42127a;

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReference f42128b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ zzo[] f42129c;

    static {
        zzo zzoVar = new zzo("INSTANCE", 0);
        f42127a = zzoVar;
        f42129c = new zzo[]{zzoVar};
        f42128b = new AtomicReference(null);
    }

    public static zzo[] values() {
        return (zzo[]) f42129c.clone();
    }

    public final zzh a() {
        return (zzh) f42128b.get();
    }
}
