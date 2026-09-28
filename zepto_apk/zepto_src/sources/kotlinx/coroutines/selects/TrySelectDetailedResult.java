package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class TrySelectDetailedResult {

    /* renamed from: a, reason: collision with root package name */
    public static final TrySelectDetailedResult f55212a;

    /* renamed from: b, reason: collision with root package name */
    public static final TrySelectDetailedResult f55213b;

    /* renamed from: c, reason: collision with root package name */
    public static final TrySelectDetailedResult f55214c;

    /* renamed from: d, reason: collision with root package name */
    public static final TrySelectDetailedResult f55215d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ TrySelectDetailedResult[] f55216e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f55217f;

    static {
        TrySelectDetailedResult trySelectDetailedResult = new TrySelectDetailedResult("SUCCESSFUL", 0);
        f55212a = trySelectDetailedResult;
        TrySelectDetailedResult trySelectDetailedResult2 = new TrySelectDetailedResult("REREGISTER", 1);
        f55213b = trySelectDetailedResult2;
        TrySelectDetailedResult trySelectDetailedResult3 = new TrySelectDetailedResult("CANCELLED", 2);
        f55214c = trySelectDetailedResult3;
        TrySelectDetailedResult trySelectDetailedResult4 = new TrySelectDetailedResult("ALREADY_SELECTED", 3);
        f55215d = trySelectDetailedResult4;
        TrySelectDetailedResult[] trySelectDetailedResultArr = {trySelectDetailedResult, trySelectDetailedResult2, trySelectDetailedResult3, trySelectDetailedResult4};
        f55216e = trySelectDetailedResultArr;
        f55217f = EnumEntriesKt.a(trySelectDetailedResultArr);
    }

    public static TrySelectDetailedResult valueOf(String str) {
        return (TrySelectDetailedResult) Enum.valueOf(TrySelectDetailedResult.class, str);
    }

    public static TrySelectDetailedResult[] values() {
        return (TrySelectDetailedResult[]) f55216e.clone();
    }
}
