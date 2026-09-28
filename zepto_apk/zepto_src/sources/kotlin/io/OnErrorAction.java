package kotlin.io;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class OnErrorAction {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OnErrorAction[] f53752a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f53753b;

    static {
        OnErrorAction[] onErrorActionArr = {new OnErrorAction("SKIP", 0), new OnErrorAction("TERMINATE", 1)};
        f53752a = onErrorActionArr;
        f53753b = EnumEntriesKt.a(onErrorActionArr);
    }

    public static OnErrorAction valueOf(String str) {
        return (OnErrorAction) Enum.valueOf(OnErrorAction.class, str);
    }

    public static OnErrorAction[] values() {
        return (OnErrorAction[]) f53752a.clone();
    }
}
