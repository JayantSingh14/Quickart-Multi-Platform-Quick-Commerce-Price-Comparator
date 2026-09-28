package kotlinx.android.extensions;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes3.dex */
public final class CacheImplementation {

    /* renamed from: a, reason: collision with root package name */
    public static final CacheImplementation f54033a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ CacheImplementation[] f54034b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f54035c;

    @Metadata
    public static final class Companion {
    }

    static {
        CacheImplementation cacheImplementation = new CacheImplementation("SPARSE_ARRAY", 0);
        CacheImplementation cacheImplementation2 = new CacheImplementation("HASH_MAP", 1);
        f54033a = cacheImplementation2;
        CacheImplementation[] cacheImplementationArr = {cacheImplementation, cacheImplementation2, new CacheImplementation("NO_CACHE", 2)};
        f54034b = cacheImplementationArr;
        f54035c = EnumEntriesKt.a(cacheImplementationArr);
    }

    public static CacheImplementation valueOf(String str) {
        return (CacheImplementation) Enum.valueOf(CacheImplementation.class, str);
    }

    public static CacheImplementation[] values() {
        return (CacheImplementation[]) f54034b.clone();
    }
}
