package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public abstract class ActivityResultContract<I, O> {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class SynchronousResult<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Serializable f230a;

        public SynchronousResult(Serializable serializable) {
            this.f230a = serializable;
        }
    }

    public abstract Intent a(Object obj, Context context);

    public SynchronousResult b(Object obj, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    public abstract Object c(Intent intent, int i2);
}
