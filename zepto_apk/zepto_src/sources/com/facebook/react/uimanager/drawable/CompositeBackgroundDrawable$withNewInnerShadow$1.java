package com.facebook.react.uimanager.drawable;

import android.graphics.drawable.LayerDrawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.reflect.KMutableProperty0;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class CompositeBackgroundDrawable$withNewInnerShadow$1 extends FunctionReferenceImpl implements Function1<LayerDrawable, Unit> {
    public CompositeBackgroundDrawable$withNewInnerShadow$1(Object obj) {
        super(1, obj, KMutableProperty0.class, "set", "set(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ((KMutableProperty0) this.receiver).set((LayerDrawable) obj);
        return Unit.f53572a;
    }
}
