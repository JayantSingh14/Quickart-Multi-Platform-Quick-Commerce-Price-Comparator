package kotlinx.datetime.format;

import android.support.v4.media.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;

@Metadata
/* loaded from: classes3.dex */
public final class LocalDateFormatKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f55440a = LazyKt.b(LocalDateFormatKt$ISO_DATE$2.f55443c);

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f55441b = LazyKt.b(LocalDateFormatKt$ISO_DATE_BASIC$2.f55445c);

    /* renamed from: c, reason: collision with root package name */
    public static final IncompleteLocalDate f55442c = new IncompleteLocalDate(0);

    public static final DateTimeFormat a() {
        return (DateTimeFormat) f55440a.getValue();
    }

    public static final void b(Object obj, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (obj == null) {
            throw new DateTimeFormatException(b.m("Can not create a ", name, " from the given input: the field ", name, " is missing"));
        }
    }
}
