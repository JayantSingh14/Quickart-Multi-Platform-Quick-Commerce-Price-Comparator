package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class ActivityResultCallerLauncher$resultContract$2 extends Lambda implements Function0 {

    @Metadata
    /* renamed from: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1, reason: invalid class name */
    public final class AnonymousClass1 extends ActivityResultContract<Unit, Object> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent a(Object obj, Context context) {
            Unit input = (Unit) obj;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            throw null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object c(Intent intent, int i2) {
            throw null;
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new AnonymousClass1();
    }
}
