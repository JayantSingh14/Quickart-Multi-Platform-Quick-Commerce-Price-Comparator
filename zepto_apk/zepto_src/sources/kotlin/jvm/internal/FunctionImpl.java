package kotlin.jvm.internal;

import android.support.v4.media.b;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;

@Deprecated
@Deprecated
/* loaded from: classes3.dex */
public abstract class FunctionImpl implements Function, Serializable, Function0, Function1, Function2, Function3, Function4, Function5, Function6, Function7, Function8, Function9, Function10, Function11, Function12, Function13, Function14, Function15, Function16, Function17, Function18, Function19, Function20, Function21, Function22 {
    public final void a(int i2) {
        if (getArity() == i2) {
            return;
        }
        StringBuilder sbU = b.u(i2, "Wrong function arity, expected: ", ", actual: ");
        sbU.append(getArity());
        throw new IllegalStateException(sbU.toString());
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object d(Object obj, Object obj2, Object obj3, Object obj4) {
        a(4);
        throw new UnsupportedOperationException();
    }

    public abstract int getArity();

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        a(0);
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        a(1);
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        a(2);
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        a(3);
        throw new UnsupportedOperationException();
    }
}
