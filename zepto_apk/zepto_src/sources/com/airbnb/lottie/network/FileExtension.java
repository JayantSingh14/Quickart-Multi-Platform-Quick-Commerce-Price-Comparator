package com.airbnb.lottie.network;

import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes3.dex */
public enum FileExtension {
    JSON(".json"),
    ZIP(".zip"),
    GZIP(".gz");


    /* renamed from: a, reason: collision with root package name */
    public final String f14670a;

    FileExtension(String str) {
        this.f14670a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f14670a;
    }
}
