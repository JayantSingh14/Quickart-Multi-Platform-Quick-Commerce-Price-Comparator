package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.DelimitedKt", f = "Delimited.kt", l = {WKSRecord.Service.HOSTS2_NS, WKSRecord.Service.AUTH}, m = "readUntilDelimiterSuspend")
/* loaded from: classes3.dex */
final class DelimitedKt$readUntilDelimiterSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f51137a;

    /* renamed from: b, reason: collision with root package name */
    public int f51138b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int iIntValue;
        this.f51137a = obj;
        int i2 = (this.f51138b | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f51138b = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 == 0) {
            ResultKt.b(obj);
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i2 == 1) {
            ResultKt.b(obj);
            iIntValue = ((Number) obj).intValue();
            if (iIntValue > 0 || iIntValue == 0) {
                throw null;
            }
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            int iIntValue2 = ((Number) obj).intValue();
            if (iIntValue2 < 0) {
                iIntValue2 = 0;
            }
            iIntValue = 0 + iIntValue2;
        }
        return new Integer(iIntValue);
    }
}
