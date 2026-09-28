package androidx.work;

import android.annotation.SuppressLint;
import java.util.Collections;
import java.util.List;

@SuppressLint({"AddedAbstractMethod"})
/* loaded from: classes.dex */
public abstract class WorkManager {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes3.dex */
    public static final class UpdateResult {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UpdateResult[] f12573a = {new UpdateResult("NOT_APPLIED", 0), new UpdateResult("APPLIED_IMMEDIATELY", 1), new UpdateResult("APPLIED_FOR_NEXT_RUN", 2)};

        /* JADX INFO: Fake field, exist only in values array */
        UpdateResult EF5;

        public static UpdateResult valueOf(String str) {
            return (UpdateResult) Enum.valueOf(UpdateResult.class, str);
        }

        public static UpdateResult[] values() {
            return (UpdateResult[]) f12573a.clone();
        }
    }

    public abstract Operation a(List list);

    public final void b(OneTimeWorkRequest oneTimeWorkRequest) {
        a(Collections.singletonList(oneTimeWorkRequest));
    }

    public final Operation c(String str, ExistingWorkPolicy existingWorkPolicy, OneTimeWorkRequest oneTimeWorkRequest) {
        return d(str, existingWorkPolicy, Collections.singletonList(oneTimeWorkRequest));
    }

    public abstract Operation d(String str, ExistingWorkPolicy existingWorkPolicy, List list);
}
