package com.swmansion.rnscreens.utils;

import kotlin.Metadata;

@Metadata
/* loaded from: classes4.dex */
public final class EdgeToEdgePackageDetector {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f47148a;

    static {
        boolean z;
        try {
            Class.forName("com.zoontek.rnedgetoedge.EdgeToEdgePackage");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        f47148a = z;
    }

    public static boolean a() {
        return f47148a;
    }
}
