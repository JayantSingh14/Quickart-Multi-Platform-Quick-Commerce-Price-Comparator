package io.ktor.utils.io.jvm.javaio;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.InputAdapter$loop$1", f = "Blocking.kt", l = {319, Type.A6}, m = "loop")
/* loaded from: classes3.dex */
final class InputAdapter$loop$1$loop$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public InputAdapter$loop$1 f51317a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f51318b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InputAdapter$loop$1 f51319c;

    /* renamed from: d, reason: collision with root package name */
    public int f51320d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAdapter$loop$1$loop$1(InputAdapter$loop$1 inputAdapter$loop$1, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f51319c = inputAdapter$loop$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51318b = obj;
        this.f51320d |= Integer.MIN_VALUE;
        return this.f51319c.b(this);
    }
}
