package com.facebook.imagepipeline.core;

import com.amazon.identity.auth.device.authorization.RegionUtil;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class DownsampleMode {

    /* renamed from: a, reason: collision with root package name */
    public static final DownsampleMode f17816a;

    /* renamed from: b, reason: collision with root package name */
    public static final DownsampleMode f17817b;

    /* renamed from: c, reason: collision with root package name */
    public static final DownsampleMode f17818c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ DownsampleMode[] f17819d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f17820e;

    static {
        DownsampleMode downsampleMode = new DownsampleMode("ALWAYS", 0);
        f17816a = downsampleMode;
        DownsampleMode downsampleMode2 = new DownsampleMode(RegionUtil.REGION_STRING_AUTO, 1);
        f17817b = downsampleMode2;
        DownsampleMode downsampleMode3 = new DownsampleMode("NEVER", 2);
        f17818c = downsampleMode3;
        DownsampleMode[] downsampleModeArr = {downsampleMode, downsampleMode2, downsampleMode3};
        f17819d = downsampleModeArr;
        f17820e = EnumEntriesKt.a(downsampleModeArr);
    }

    public static DownsampleMode valueOf(String str) {
        return (DownsampleMode) Enum.valueOf(DownsampleMode.class, str);
    }

    public static DownsampleMode[] values() {
        return (DownsampleMode[]) f17819d.clone();
    }
}
