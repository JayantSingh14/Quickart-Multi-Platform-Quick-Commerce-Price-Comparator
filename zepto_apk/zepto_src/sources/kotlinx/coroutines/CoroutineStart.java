package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class CoroutineStart {

    /* renamed from: a, reason: collision with root package name */
    public static final CoroutineStart f54078a;

    /* renamed from: b, reason: collision with root package name */
    public static final CoroutineStart f54079b;

    /* renamed from: c, reason: collision with root package name */
    public static final CoroutineStart f54080c;

    /* renamed from: d, reason: collision with root package name */
    public static final CoroutineStart f54081d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ CoroutineStart[] f54082e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f54083f;

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[CoroutineStart.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                CoroutineStart coroutineStart = CoroutineStart.f54078a;
                iArr[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                CoroutineStart coroutineStart2 = CoroutineStart.f54078a;
                iArr[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                CoroutineStart coroutineStart3 = CoroutineStart.f54078a;
                iArr[1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        CoroutineStart coroutineStart = new CoroutineStart("DEFAULT", 0);
        f54078a = coroutineStart;
        CoroutineStart coroutineStart2 = new CoroutineStart("LAZY", 1);
        f54079b = coroutineStart2;
        CoroutineStart coroutineStart3 = new CoroutineStart("ATOMIC", 2);
        f54080c = coroutineStart3;
        CoroutineStart coroutineStart4 = new CoroutineStart("UNDISPATCHED", 3);
        f54081d = coroutineStart4;
        CoroutineStart[] coroutineStartArr = {coroutineStart, coroutineStart2, coroutineStart3, coroutineStart4};
        f54082e = coroutineStartArr;
        f54083f = EnumEntriesKt.a(coroutineStartArr);
    }

    public static CoroutineStart valueOf(String str) {
        return (CoroutineStart) Enum.valueOf(CoroutineStart.class, str);
    }

    public static CoroutineStart[] values() {
        return (CoroutineStart[]) f54082e.clone();
    }
}
