package androidx.work;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class ExistingWorkPolicy {

    /* renamed from: a, reason: collision with root package name */
    public static final ExistingWorkPolicy f12516a;

    /* renamed from: b, reason: collision with root package name */
    public static final ExistingWorkPolicy f12517b;

    /* renamed from: c, reason: collision with root package name */
    public static final ExistingWorkPolicy f12518c;

    /* renamed from: d, reason: collision with root package name */
    public static final ExistingWorkPolicy f12519d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ ExistingWorkPolicy[] f12520e;

    static {
        ExistingWorkPolicy existingWorkPolicy = new ExistingWorkPolicy("REPLACE", 0);
        f12516a = existingWorkPolicy;
        ExistingWorkPolicy existingWorkPolicy2 = new ExistingWorkPolicy("KEEP", 1);
        f12517b = existingWorkPolicy2;
        ExistingWorkPolicy existingWorkPolicy3 = new ExistingWorkPolicy("APPEND", 2);
        f12518c = existingWorkPolicy3;
        ExistingWorkPolicy existingWorkPolicy4 = new ExistingWorkPolicy("APPEND_OR_REPLACE", 3);
        f12519d = existingWorkPolicy4;
        f12520e = new ExistingWorkPolicy[]{existingWorkPolicy, existingWorkPolicy2, existingWorkPolicy3, existingWorkPolicy4};
    }

    public static ExistingWorkPolicy valueOf(String str) {
        return (ExistingWorkPolicy) Enum.valueOf(ExistingWorkPolicy.class, str);
    }

    public static ExistingWorkPolicy[] values() {
        return (ExistingWorkPolicy[]) f12520e.clone();
    }
}
