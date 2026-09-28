package kotlin.io.path;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin
@Metadata
@ExperimentalPathApi
/* loaded from: classes3.dex */
public final class CopyActionResult {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CopyActionResult[] f53757a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f53758b;

    static {
        CopyActionResult[] copyActionResultArr = {new CopyActionResult("CONTINUE", 0), new CopyActionResult("SKIP_SUBTREE", 1), new CopyActionResult("TERMINATE", 2)};
        f53757a = copyActionResultArr;
        f53758b = EnumEntriesKt.a(copyActionResultArr);
    }

    public static CopyActionResult valueOf(String str) {
        return (CopyActionResult) Enum.valueOf(CopyActionResult.class, str);
    }

    public static CopyActionResult[] values() {
        return (CopyActionResult[]) f53757a.clone();
    }
}
