package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin
@Metadata
@PublishedApi
/* loaded from: classes.dex */
public final class CoroutineSingletons {

    /* renamed from: a, reason: collision with root package name */
    public static final CoroutineSingletons f53689a;

    /* renamed from: b, reason: collision with root package name */
    public static final CoroutineSingletons f53690b;

    /* renamed from: c, reason: collision with root package name */
    public static final CoroutineSingletons f53691c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ CoroutineSingletons[] f53692d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f53693e;

    static {
        CoroutineSingletons coroutineSingletons = new CoroutineSingletons("COROUTINE_SUSPENDED", 0);
        f53689a = coroutineSingletons;
        CoroutineSingletons coroutineSingletons2 = new CoroutineSingletons("UNDECIDED", 1);
        f53690b = coroutineSingletons2;
        CoroutineSingletons coroutineSingletons3 = new CoroutineSingletons("RESUMED", 2);
        f53691c = coroutineSingletons3;
        CoroutineSingletons[] coroutineSingletonsArr = {coroutineSingletons, coroutineSingletons2, coroutineSingletons3};
        f53692d = coroutineSingletonsArr;
        f53693e = EnumEntriesKt.a(coroutineSingletonsArr);
    }

    public static CoroutineSingletons valueOf(String str) {
        return (CoroutineSingletons) Enum.valueOf(CoroutineSingletons.class, str);
    }

    public static CoroutineSingletons[] values() {
        return (CoroutineSingletons[]) f53692d.clone();
    }
}
