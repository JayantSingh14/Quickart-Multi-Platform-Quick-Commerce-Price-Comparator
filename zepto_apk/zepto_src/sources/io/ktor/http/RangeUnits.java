package io.ktor.http;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class RangeUnits {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RangeUnits[] f50237a = {new RangeUnits("Bytes", 0), new RangeUnits("None", 1)};

    /* JADX INFO: Fake field, exist only in values array */
    RangeUnits EF5;

    public static RangeUnits valueOf(String str) {
        return (RangeUnits) Enum.valueOf(RangeUnits.class, str);
    }

    public static RangeUnits[] values() {
        return (RangeUnits[]) f50237a.clone();
    }
}
