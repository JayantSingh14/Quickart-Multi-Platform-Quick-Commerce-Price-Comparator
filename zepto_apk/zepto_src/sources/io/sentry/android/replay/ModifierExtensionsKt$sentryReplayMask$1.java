package io.sentry.android.replay;

import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class ModifierExtensionsKt$sentryReplayMask$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    public final void a(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertyKey semanticsPropertyKey = SentryReplayModifiers.f52491a;
        semantics.set(SentryReplayModifiers.f52491a, "mask");
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((SemanticsPropertyReceiver) obj);
        return Unit.f53572a;
    }
}
