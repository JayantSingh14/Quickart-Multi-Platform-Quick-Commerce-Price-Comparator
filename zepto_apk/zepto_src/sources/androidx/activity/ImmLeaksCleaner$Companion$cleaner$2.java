package androidx.activity;

import android.view.inputmethod.InputMethodManager;
import androidx.activity.ImmLeaksCleaner;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
public final class ImmLeaksCleaner$Companion$cleaner$2 extends Lambda implements Function0<ImmLeaksCleaner.Cleaner> {

    /* renamed from: c, reason: collision with root package name */
    public static final ImmLeaksCleaner$Companion$cleaner$2 f149c = new ImmLeaksCleaner$Companion$cleaner$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws NoSuchFieldException, SecurityException {
        try {
            Field servedViewField = InputMethodManager.class.getDeclaredField("mServedView");
            servedViewField.setAccessible(true);
            Field nextServedViewField = InputMethodManager.class.getDeclaredField("mNextServedView");
            nextServedViewField.setAccessible(true);
            Field hField = InputMethodManager.class.getDeclaredField("mH");
            hField.setAccessible(true);
            Intrinsics.checkNotNullExpressionValue(hField, "hField");
            Intrinsics.checkNotNullExpressionValue(servedViewField, "servedViewField");
            Intrinsics.checkNotNullExpressionValue(nextServedViewField, "nextServedViewField");
            Intrinsics.checkNotNullParameter(hField, "hField");
            Intrinsics.checkNotNullParameter(servedViewField, "servedViewField");
            Intrinsics.checkNotNullParameter(nextServedViewField, "nextServedViewField");
            return new ImmLeaksCleaner.ValidCleaner();
        } catch (NoSuchFieldException unused) {
            return ImmLeaksCleaner.FailedInitialization.f150a;
        }
    }
}
