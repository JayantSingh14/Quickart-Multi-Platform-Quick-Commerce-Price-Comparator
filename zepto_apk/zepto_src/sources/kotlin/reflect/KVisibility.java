package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin
@Metadata
/* loaded from: classes3.dex */
public final class KVisibility {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KVisibility[] f53880a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f53881b;

    static {
        KVisibility[] kVisibilityArr = {new KVisibility("PUBLIC", 0), new KVisibility("PROTECTED", 1), new KVisibility("INTERNAL", 2), new KVisibility("PRIVATE", 3)};
        f53880a = kVisibilityArr;
        f53881b = EnumEntriesKt.a(kVisibilityArr);
    }

    public static KVisibility valueOf(String str) {
        return (KVisibility) Enum.valueOf(KVisibility.class, str);
    }

    public static KVisibility[] values() {
        return (KVisibility[]) f53880a.clone();
    }
}
