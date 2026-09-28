package androidx.activity;

import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class SystemBarStyle$Companion$auto$1 extends Lambda implements Function1<Resources, Boolean> {

    /* renamed from: c, reason: collision with root package name */
    public static final SystemBarStyle$Companion$auto$1 f178c = new SystemBarStyle$Companion$auto$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Resources resources = (Resources) obj;
        Intrinsics.checkNotNullParameter(resources, "resources");
        return Boolean.valueOf((resources.getConfiguration().uiMode & 48) == 32);
    }
}
