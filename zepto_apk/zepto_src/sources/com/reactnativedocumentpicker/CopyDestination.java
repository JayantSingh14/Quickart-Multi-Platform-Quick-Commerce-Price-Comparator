package com.reactnativedocumentpicker;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes4.dex */
public final class CopyDestination {

    /* renamed from: b, reason: collision with root package name */
    public static final Companion f46325b;

    /* renamed from: c, reason: collision with root package name */
    public static final CopyDestination f46326c;

    /* renamed from: d, reason: collision with root package name */
    public static final CopyDestination f46327d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ CopyDestination[] f46328e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f46329f;

    /* renamed from: a, reason: collision with root package name */
    public final String f46330a;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    static {
        CopyDestination copyDestination = new CopyDestination("CACHES_DIRECTORY", 0, "cachesDirectory");
        f46326c = copyDestination;
        CopyDestination copyDestination2 = new CopyDestination("DOCUMENT_DIRECTORY", 1, "documentDirectory");
        f46327d = copyDestination2;
        CopyDestination[] copyDestinationArr = {copyDestination, copyDestination2};
        f46328e = copyDestinationArr;
        f46329f = EnumEntriesKt.a(copyDestinationArr);
        f46325b = new Companion();
    }

    public CopyDestination(String str, int i2, String str2) {
        this.f46330a = str2;
    }

    public static CopyDestination valueOf(String str) {
        return (CopyDestination) Enum.valueOf(CopyDestination.class, str);
    }

    public static CopyDestination[] values() {
        return (CopyDestination[]) f46328e.clone();
    }
}
