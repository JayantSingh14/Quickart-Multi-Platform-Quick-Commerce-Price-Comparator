package kotlin.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin
@Metadata
/* loaded from: classes3.dex */
public final class RequireKotlinVersionKind {

    /* renamed from: a, reason: collision with root package name */
    public static final RequireKotlinVersionKind f53717a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ RequireKotlinVersionKind[] f53718b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f53719c;

    static {
        RequireKotlinVersionKind requireKotlinVersionKind = new RequireKotlinVersionKind("LANGUAGE_VERSION", 0);
        f53717a = requireKotlinVersionKind;
        RequireKotlinVersionKind[] requireKotlinVersionKindArr = {requireKotlinVersionKind, new RequireKotlinVersionKind("COMPILER_VERSION", 1), new RequireKotlinVersionKind("API_VERSION", 2)};
        f53718b = requireKotlinVersionKindArr;
        f53719c = EnumEntriesKt.a(requireKotlinVersionKindArr);
    }

    public static RequireKotlinVersionKind valueOf(String str) {
        return (RequireKotlinVersionKind) Enum.valueOf(RequireKotlinVersionKind.class, str);
    }

    public static RequireKotlinVersionKind[] values() {
        return (RequireKotlinVersionKind[]) f53718b.clone();
    }
}
