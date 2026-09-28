package com.chuckerteam.chucker.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class ExportFormat {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExportFormat[] f16629a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f16630b;

    static {
        ExportFormat[] exportFormatArr = {new ExportFormat("LOG", 0), new ExportFormat("HAR", 1)};
        f16629a = exportFormatArr;
        f16630b = EnumEntriesKt.a(exportFormatArr);
    }

    public static ExportFormat valueOf(String str) {
        return (ExportFormat) Enum.valueOf(ExportFormat.class, str);
    }

    public static ExportFormat[] values() {
        return (ExportFormat[]) f16629a.clone();
    }
}
