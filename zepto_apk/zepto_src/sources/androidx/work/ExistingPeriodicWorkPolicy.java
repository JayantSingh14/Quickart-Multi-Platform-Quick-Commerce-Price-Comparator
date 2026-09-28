package androidx.work;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class ExistingPeriodicWorkPolicy {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExistingPeriodicWorkPolicy[] f12515a = {new ExistingPeriodicWorkPolicy("REPLACE", 0), new ExistingPeriodicWorkPolicy("KEEP", 1), new ExistingPeriodicWorkPolicy("UPDATE", 2), new ExistingPeriodicWorkPolicy("CANCEL_AND_REENQUEUE", 3)};

    /* JADX INFO: Fake field, exist only in values array */
    ExistingPeriodicWorkPolicy EF5;

    public static ExistingPeriodicWorkPolicy valueOf(String str) {
        return (ExistingPeriodicWorkPolicy) Enum.valueOf(ExistingPeriodicWorkPolicy.class, str);
    }

    public static ExistingPeriodicWorkPolicy[] values() {
        return (ExistingPeriodicWorkPolicy[]) f12515a.clone();
    }
}
