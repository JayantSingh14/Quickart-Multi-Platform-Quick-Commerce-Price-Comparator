package androidx.work;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class OutOfQuotaPolicy {

    /* renamed from: a, reason: collision with root package name */
    public static final OutOfQuotaPolicy f12549a;

    /* renamed from: b, reason: collision with root package name */
    public static final OutOfQuotaPolicy f12550b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ OutOfQuotaPolicy[] f12551c;

    static {
        OutOfQuotaPolicy outOfQuotaPolicy = new OutOfQuotaPolicy("RUN_AS_NON_EXPEDITED_WORK_REQUEST", 0);
        f12549a = outOfQuotaPolicy;
        OutOfQuotaPolicy outOfQuotaPolicy2 = new OutOfQuotaPolicy("DROP_WORK_REQUEST", 1);
        f12550b = outOfQuotaPolicy2;
        f12551c = new OutOfQuotaPolicy[]{outOfQuotaPolicy, outOfQuotaPolicy2};
    }

    public static OutOfQuotaPolicy valueOf(String str) {
        return (OutOfQuotaPolicy) Enum.valueOf(OutOfQuotaPolicy.class, str);
    }

    public static OutOfQuotaPolicy[] values() {
        return (OutOfQuotaPolicy[]) f12551c.clone();
    }
}
