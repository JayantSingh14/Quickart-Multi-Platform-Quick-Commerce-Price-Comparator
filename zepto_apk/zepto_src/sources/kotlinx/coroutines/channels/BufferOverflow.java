package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class BufferOverflow {

    /* renamed from: a, reason: collision with root package name */
    public static final BufferOverflow f54203a;

    /* renamed from: b, reason: collision with root package name */
    public static final BufferOverflow f54204b;

    /* renamed from: c, reason: collision with root package name */
    public static final BufferOverflow f54205c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ BufferOverflow[] f54206d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f54207e;

    static {
        BufferOverflow bufferOverflow = new BufferOverflow("SUSPEND", 0);
        f54203a = bufferOverflow;
        BufferOverflow bufferOverflow2 = new BufferOverflow("DROP_OLDEST", 1);
        f54204b = bufferOverflow2;
        BufferOverflow bufferOverflow3 = new BufferOverflow("DROP_LATEST", 2);
        f54205c = bufferOverflow3;
        BufferOverflow[] bufferOverflowArr = {bufferOverflow, bufferOverflow2, bufferOverflow3};
        f54206d = bufferOverflowArr;
        f54207e = EnumEntriesKt.a(bufferOverflowArr);
    }

    public static BufferOverflow valueOf(String str) {
        return (BufferOverflow) Enum.valueOf(BufferOverflow.class, str);
    }

    public static BufferOverflow[] values() {
        return (BufferOverflow[]) f54206d.clone();
    }
}
