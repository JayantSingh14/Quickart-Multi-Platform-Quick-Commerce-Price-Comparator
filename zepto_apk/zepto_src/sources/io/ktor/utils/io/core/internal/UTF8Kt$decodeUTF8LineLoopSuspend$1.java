package io.ktor.utils.io.core.internal;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.core.internal.UTF8Kt", f = "UTF8.kt", l = {37}, m = "decodeUTF8LineLoopSuspend")
/* loaded from: classes3.dex */
final class UTF8Kt$decodeUTF8LineLoopSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Appendable f51219a;

    /* renamed from: b, reason: collision with root package name */
    public Function2 f51220b;

    /* renamed from: c, reason: collision with root package name */
    public Function1 f51221c;

    /* renamed from: d, reason: collision with root package name */
    public Ref.IntRef f51222d;

    /* renamed from: e, reason: collision with root package name */
    public Ref.IntRef f51223e;

    /* renamed from: f, reason: collision with root package name */
    public Ref.BooleanRef f51224f;

    /* renamed from: g, reason: collision with root package name */
    public Ref.BooleanRef f51225g;

    /* renamed from: h, reason: collision with root package name */
    public int f51226h;

    /* renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f51227i;

    /* renamed from: j, reason: collision with root package name */
    public int f51228j;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f51227i = obj;
        this.f51228j |= Integer.MIN_VALUE;
        return UTF8Kt.a(null, 0, null, null, this);
    }
}
