package androidx.work;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class BackoffPolicy {

    /* renamed from: a, reason: collision with root package name */
    public static final BackoffPolicy f12471a;

    /* renamed from: b, reason: collision with root package name */
    public static final BackoffPolicy f12472b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ BackoffPolicy[] f12473c;

    static {
        BackoffPolicy backoffPolicy = new BackoffPolicy("EXPONENTIAL", 0);
        f12471a = backoffPolicy;
        BackoffPolicy backoffPolicy2 = new BackoffPolicy("LINEAR", 1);
        f12472b = backoffPolicy2;
        f12473c = new BackoffPolicy[]{backoffPolicy, backoffPolicy2};
    }

    public static BackoffPolicy valueOf(String str) {
        return (BackoffPolicy) Enum.valueOf(BackoffPolicy.class, str);
    }

    public static BackoffPolicy[] values() {
        return (BackoffPolicy[]) f12473c.clone();
    }
}
