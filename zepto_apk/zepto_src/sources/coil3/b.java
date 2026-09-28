package coil3;

import coil3.decode.Decoder;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13857a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Decoder.Factory f13858b;

    public /* synthetic */ b(Decoder.Factory factory, int i2) {
        this.f13857a = i2;
        this.f13858b = factory;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f13857a) {
        }
        return CollectionsKt.H(this.f13858b);
    }
}
