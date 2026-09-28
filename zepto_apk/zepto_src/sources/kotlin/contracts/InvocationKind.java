package kotlin.contracts;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.internal.ContractsDsl;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin
@ContractsDsl
@Metadata
@ExperimentalContracts
/* loaded from: classes3.dex */
public final class InvocationKind {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InvocationKind[] f53677a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f53678b;

    static {
        InvocationKind[] invocationKindArr = {new InvocationKind("AT_MOST_ONCE", 0), new InvocationKind("AT_LEAST_ONCE", 1), new InvocationKind("EXACTLY_ONCE", 2), new InvocationKind("UNKNOWN", 3)};
        f53677a = invocationKindArr;
        f53678b = EnumEntriesKt.a(invocationKindArr);
    }

    public static InvocationKind valueOf(String str) {
        return (InvocationKind) Enum.valueOf(InvocationKind.class, str);
    }

    public static InvocationKind[] values() {
        return (InvocationKind[]) f53677a.clone();
    }
}
