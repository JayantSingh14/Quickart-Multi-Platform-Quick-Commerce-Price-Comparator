package kotlinx.coroutines.test;

import kotlin.jvm.functions.Function1;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f55322a;

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f55322a) {
            case 0:
                int i2 = StandardTestDispatcherImpl.f55267d;
                break;
            case 1:
                int i3 = TestCoroutineDispatcher.f55297e;
                break;
            default:
                int i4 = TestDispatcher.f55320b;
                break;
        }
        return Boolean.FALSE;
    }
}
