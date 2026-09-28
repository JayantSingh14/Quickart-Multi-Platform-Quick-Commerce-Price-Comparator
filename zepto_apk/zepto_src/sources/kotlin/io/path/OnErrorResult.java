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
public final class OnErrorResult {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OnErrorResult[] f53761a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f53762b;

    static {
        OnErrorResult[] onErrorResultArr = {new OnErrorResult("SKIP_SUBTREE", 0), new OnErrorResult("TERMINATE", 1)};
        f53761a = onErrorResultArr;
        f53762b = EnumEntriesKt.a(onErrorResultArr);
    }

    public static OnErrorResult valueOf(String str) {
        return (OnErrorResult) Enum.valueOf(OnErrorResult.class, str);
    }

    public static OnErrorResult[] values() {
        return (OnErrorResult[]) f53761a.clone();
    }
}
