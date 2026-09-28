package com.zeptonow.horizon.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class CompressionType {

    /* renamed from: a, reason: collision with root package name */
    public static final CompressionType f48232a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ CompressionType[] f48233b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f48234c;

    static {
        CompressionType compressionType = new CompressionType("LZ4", 0);
        f48232a = compressionType;
        CompressionType[] compressionTypeArr = {compressionType};
        f48233b = compressionTypeArr;
        f48234c = EnumEntriesKt.a(compressionTypeArr);
    }

    public static CompressionType valueOf(String str) {
        return (CompressionType) Enum.valueOf(CompressionType.class, str);
    }

    public static CompressionType[] values() {
        return (CompressionType[]) f48233b.clone();
    }
}
