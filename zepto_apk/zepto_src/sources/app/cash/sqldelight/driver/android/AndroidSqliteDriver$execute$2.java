package app.cash.sqldelight.driver.android;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes.dex */
final class AndroidSqliteDriver$execute$2 extends Lambda implements Function1<AndroidStatement, Long> {

    /* renamed from: c, reason: collision with root package name */
    public static final AndroidSqliteDriver$execute$2 f13165c = new AndroidSqliteDriver$execute$2(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        AndroidStatement execute = (AndroidStatement) obj;
        Intrinsics.checkNotNullParameter(execute, "$this$execute");
        return Long.valueOf(execute.d());
    }
}
