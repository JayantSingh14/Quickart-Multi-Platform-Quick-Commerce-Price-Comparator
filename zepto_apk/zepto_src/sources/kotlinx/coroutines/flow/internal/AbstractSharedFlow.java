package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {

    /* renamed from: a, reason: collision with root package name */
    public AbstractSharedFlowSlot[] f54938a;

    /* renamed from: b, reason: collision with root package name */
    public int f54939b;

    /* renamed from: c, reason: collision with root package name */
    public int f54940c;

    public final AbstractSharedFlowSlot d() {
        AbstractSharedFlowSlot abstractSharedFlowSlotF;
        synchronized (this) {
            try {
                AbstractSharedFlowSlot[] abstractSharedFlowSlotArrG = this.f54938a;
                if (abstractSharedFlowSlotArrG == null) {
                    abstractSharedFlowSlotArrG = g();
                    this.f54938a = abstractSharedFlowSlotArrG;
                } else if (this.f54939b >= abstractSharedFlowSlotArrG.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(abstractSharedFlowSlotArrG, abstractSharedFlowSlotArrG.length * 2);
                    Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
                    this.f54938a = (AbstractSharedFlowSlot[]) objArrCopyOf;
                    abstractSharedFlowSlotArrG = (AbstractSharedFlowSlot[]) objArrCopyOf;
                }
                int i2 = this.f54940c;
                do {
                    abstractSharedFlowSlotF = abstractSharedFlowSlotArrG[i2];
                    if (abstractSharedFlowSlotF == null) {
                        abstractSharedFlowSlotF = f();
                        abstractSharedFlowSlotArrG[i2] = abstractSharedFlowSlotF;
                    }
                    i2++;
                    if (i2 >= abstractSharedFlowSlotArrG.length) {
                        i2 = 0;
                    }
                } while (!abstractSharedFlowSlotF.a(this));
                this.f54940c = i2;
                this.f54939b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        return abstractSharedFlowSlotF;
    }

    public abstract AbstractSharedFlowSlot f();

    public abstract AbstractSharedFlowSlot[] g();

    public final void h(AbstractSharedFlowSlot abstractSharedFlowSlot) {
        int i2;
        Continuation[] continuationArrB;
        synchronized (this) {
            try {
                int i3 = this.f54939b - 1;
                this.f54939b = i3;
                if (i3 == 0) {
                    this.f54940c = 0;
                }
                Intrinsics.d(abstractSharedFlowSlot, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                continuationArrB = abstractSharedFlowSlot.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation continuation : continuationArrB) {
            if (continuation != null) {
                Result.Companion companion = Result.f53538b;
                continuation.resumeWith(Unit.f53572a);
            }
        }
    }
}
