package com.facebook.react;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class JSEngineResolutionAlgorithm {

    /* renamed from: a, reason: collision with root package name */
    public static final JSEngineResolutionAlgorithm f18424a;

    /* renamed from: b, reason: collision with root package name */
    public static final JSEngineResolutionAlgorithm f18425b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ JSEngineResolutionAlgorithm[] f18426c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f18427d;

    static {
        JSEngineResolutionAlgorithm jSEngineResolutionAlgorithm = new JSEngineResolutionAlgorithm("JSC", 0);
        f18424a = jSEngineResolutionAlgorithm;
        JSEngineResolutionAlgorithm jSEngineResolutionAlgorithm2 = new JSEngineResolutionAlgorithm("HERMES", 1);
        f18425b = jSEngineResolutionAlgorithm2;
        JSEngineResolutionAlgorithm[] jSEngineResolutionAlgorithmArr = {jSEngineResolutionAlgorithm, jSEngineResolutionAlgorithm2};
        f18426c = jSEngineResolutionAlgorithmArr;
        f18427d = EnumEntriesKt.a(jSEngineResolutionAlgorithmArr);
    }

    public static JSEngineResolutionAlgorithm valueOf(String str) {
        return (JSEngineResolutionAlgorithm) Enum.valueOf(JSEngineResolutionAlgorithm.class, str);
    }

    public static JSEngineResolutionAlgorithm[] values() {
        return (JSEngineResolutionAlgorithm[]) f18426c.clone();
    }
}
