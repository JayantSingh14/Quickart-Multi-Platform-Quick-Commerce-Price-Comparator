package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class WhenToOutput {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WhenToOutput[] f55519a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f55520b;

    static {
        WhenToOutput[] whenToOutputArr = {new WhenToOutput("NEVER", 0), new WhenToOutput("IF_NONZERO", 1), new WhenToOutput("ALWAYS", 2)};
        f55519a = whenToOutputArr;
        f55520b = EnumEntriesKt.a(whenToOutputArr);
    }

    public static WhenToOutput valueOf(String str) {
        return (WhenToOutput) Enum.valueOf(WhenToOutput.class, str);
    }

    public static WhenToOutput[] values() {
        return (WhenToOutput[]) f55519a.clone();
    }
}
