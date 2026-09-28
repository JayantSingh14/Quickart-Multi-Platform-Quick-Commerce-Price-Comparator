package androidx.activity.result;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;

@Metadata
/* loaded from: classes.dex */
final class ActivityResultRegistry$generateRandomNumber$1 extends Lambda implements Function0<Integer> {

    /* renamed from: c, reason: collision with root package name */
    public static final ActivityResultRegistry$generateRandomNumber$1 f211c = new ActivityResultRegistry$generateRandomNumber$1(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Random.f53818a.getClass();
        return Integer.valueOf(Random.f53819b.e(2147418112) + 65536);
    }
}
