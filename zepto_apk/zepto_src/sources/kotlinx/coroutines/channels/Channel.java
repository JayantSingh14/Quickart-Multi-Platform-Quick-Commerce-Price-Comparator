package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata
/* loaded from: classes.dex */
public interface Channel<E> extends SendChannel<E>, ReceiveChannel<E> {
    public static final Factory z0 = Factory.f54249a;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Factory {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Factory f54249a = new Factory();

        /* renamed from: b, reason: collision with root package name */
        public static final int f54250b = (int) SystemPropsKt.b(64, 1, 2147483646, "kotlinx.coroutines.channels.defaultBuffer");

        public static int a() {
            return f54250b;
        }
    }
}
