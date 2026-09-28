package io.ktor.util;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class Platform {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Platform[] f50502a = {new Platform("Jvm", 0), new Platform("Native", 1), new Platform("Browser", 2), new Platform("Node", 3)};

    /* JADX INFO: Fake field, exist only in values array */
    Platform EF5;

    public static Platform valueOf(String str) {
        return (Platform) Enum.valueOf(Platform.class, str);
    }

    public static Platform[] values() {
        return (Platform[]) f50502a.clone();
    }
}
