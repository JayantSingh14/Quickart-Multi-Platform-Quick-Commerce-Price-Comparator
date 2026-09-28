package io.ktor.util.pipeline;

import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.pipeline.PipelinePhaseRelation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableList;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class Pipeline<TSubject, TContext> {

    @NotNull
    private volatile /* synthetic */ Object _interceptors;

    /* renamed from: a, reason: collision with root package name */
    public final Attributes f50582a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f50583b;

    /* renamed from: c, reason: collision with root package name */
    public int f50584c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f50585d;

    /* renamed from: e, reason: collision with root package name */
    public PipelinePhase f50586e;

    public Pipeline(PipelinePhase... phases) {
        Intrinsics.checkNotNullParameter(phases, "phases");
        this.f50582a = AttributesJvmKt.a();
        this.f50583b = CollectionsKt.J(Arrays.copyOf(phases, phases.length));
        this._interceptors = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.Object r13, java.lang.Object r14, kotlin.coroutines.jvm.internal.ContinuationImpl r15) {
        /*
            r12 = this;
            kotlin.coroutines.CoroutineContext r0 = r15.getContext()
            java.lang.Object r1 = r12._interceptors
            java.util.List r1 = (java.util.List) r1
            r2 = 1
            if (r1 != 0) goto L99
            int r1 = r12.f50584c
            r3 = 0
            r4 = 0
            if (r1 != 0) goto L1b
            kotlin.collections.EmptyList r1 = kotlin.collections.EmptyList.f53609a
            r12._interceptors = r1
            r12.f50585d = r4
            r12.f50586e = r3
            goto L99
        L1b:
            java.util.ArrayList r5 = r12.f50583b
            if (r1 != r2) goto L4f
            int r1 = kotlin.collections.CollectionsKt.B(r5)
            if (r1 < 0) goto L4f
            r6 = r4
        L26:
            java.lang.Object r7 = r5.get(r6)
            boolean r8 = r7 instanceof io.ktor.util.pipeline.PhaseContent
            if (r8 == 0) goto L31
            io.ktor.util.pipeline.PhaseContent r7 = (io.ktor.util.pipeline.PhaseContent) r7
            goto L32
        L31:
            r7 = r3
        L32:
            if (r7 != 0) goto L35
            goto L4a
        L35:
            java.util.List r8 = r7.f50580c
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L4a
            java.util.List r1 = r7.f50580c
            r7.f50581d = r2
            r12._interceptors = r1
            r12.f50585d = r4
            io.ktor.util.pipeline.PipelinePhase r1 = r7.f50578a
            r12.f50586e = r1
            goto L99
        L4a:
            if (r6 == r1) goto L4f
            int r6 = r6 + 1
            goto L26
        L4f:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r6 = kotlin.collections.CollectionsKt.B(r5)
            if (r6 < 0) goto L93
            r7 = r4
        L5b:
            java.lang.Object r8 = r5.get(r7)
            boolean r9 = r8 instanceof io.ktor.util.pipeline.PhaseContent
            if (r9 == 0) goto L66
            io.ktor.util.pipeline.PhaseContent r8 = (io.ktor.util.pipeline.PhaseContent) r8
            goto L67
        L66:
            r8 = r3
        L67:
            if (r8 != 0) goto L6a
            goto L8e
        L6a:
            java.lang.String r9 = "destination"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r9)
            java.util.List r8 = r8.f50580c
            int r9 = r1.size()
            int r10 = r8.size()
            int r10 = r10 + r9
            r1.ensureCapacity(r10)
            int r9 = r8.size()
            r10 = r4
        L82:
            if (r10 >= r9) goto L8e
            java.lang.Object r11 = r8.get(r10)
            r1.add(r11)
            int r10 = r10 + 1
            goto L82
        L8e:
            if (r7 == r6) goto L93
            int r7 = r7 + 1
            goto L5b
        L93:
            r12._interceptors = r1
            r12.f50585d = r4
            r12.f50586e = r3
        L99:
            r12.f50585d = r2
            java.lang.Object r1 = r12._interceptors
            java.util.List r1 = (java.util.List) r1
            kotlin.jvm.internal.Intrinsics.c(r1)
            boolean r2 = r12.d()
            java.lang.String r3 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r3)
            java.lang.String r3 = "interceptors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "subject"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r3)
            java.lang.String r3 = "coroutineContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            boolean r3 = io.ktor.util.pipeline.PipelineContext_jvmKt.f50588a
            if (r3 != 0) goto Lc7
            if (r2 == 0) goto Lc1
            goto Lc7
        Lc1:
            io.ktor.util.pipeline.SuspendFunctionGun r0 = new io.ktor.util.pipeline.SuspendFunctionGun
            r0.<init>(r14, r13, r1)
            goto Lcd
        Lc7:
            io.ktor.util.pipeline.DebugPipelineContext r2 = new io.ktor.util.pipeline.DebugPipelineContext
            r2.<init>(r13, r1, r14, r0)
            r0 = r2
        Lcd:
            java.lang.Object r13 = r0.a(r14, r15)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.pipeline.Pipeline.a(java.lang.Object, java.lang.Object, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final PhaseContent b(PipelinePhase pipelinePhase) {
        ArrayList arrayList = this.f50583b;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = arrayList.get(i2);
            if (obj == pipelinePhase) {
                PhaseContent phaseContent = new PhaseContent(pipelinePhase, PipelinePhaseRelation.Last.f50592a);
                arrayList.set(i2, phaseContent);
                return phaseContent;
            }
            if (obj instanceof PhaseContent) {
                PhaseContent phaseContent2 = (PhaseContent) obj;
                if (phaseContent2.f50578a == pipelinePhase) {
                    return phaseContent2;
                }
            }
        }
        return null;
    }

    public final int c(PipelinePhase pipelinePhase) {
        ArrayList arrayList = this.f50583b;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = arrayList.get(i2);
            if (obj == pipelinePhase || ((obj instanceof PhaseContent) && ((PhaseContent) obj).f50578a == pipelinePhase)) {
                return i2;
            }
        }
        return -1;
    }

    public boolean d() {
        return false;
    }

    public final boolean e(PipelinePhase pipelinePhase) {
        ArrayList arrayList = this.f50583b;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = arrayList.get(i2);
            if (obj == pipelinePhase) {
                return true;
            }
            if ((obj instanceof PhaseContent) && ((PhaseContent) obj).f50578a == pipelinePhase) {
                return true;
            }
        }
        return false;
    }

    public final void f(PipelinePhase reference, PipelinePhase phase) throws InvalidPhaseException {
        PipelinePhaseRelation pipelinePhaseRelation;
        PipelinePhase pipelinePhase;
        Intrinsics.checkNotNullParameter(reference, "reference");
        Intrinsics.checkNotNullParameter(phase, "phase");
        if (e(phase)) {
            return;
        }
        int iC = c(reference);
        if (iC == -1) {
            throw new InvalidPhaseException("Phase " + reference + " was not registered for this pipeline");
        }
        int i2 = iC + 1;
        ArrayList arrayList = this.f50583b;
        int iB = CollectionsKt.B(arrayList);
        if (i2 <= iB) {
            while (true) {
                Object obj = arrayList.get(i2);
                PhaseContent phaseContent = obj instanceof PhaseContent ? (PhaseContent) obj : null;
                if (phaseContent != null && (pipelinePhaseRelation = phaseContent.f50579b) != null) {
                    PipelinePhaseRelation.After after = pipelinePhaseRelation instanceof PipelinePhaseRelation.After ? (PipelinePhaseRelation.After) pipelinePhaseRelation : null;
                    if (after != null && (pipelinePhase = after.f50591a) != null && pipelinePhase.equals(reference)) {
                        iC = i2;
                    }
                    if (i2 == iB) {
                        break;
                    } else {
                        i2++;
                    }
                } else {
                    break;
                }
            }
        }
        arrayList.add(iC + 1, new PhaseContent(phase, new PipelinePhaseRelation.After(reference)));
    }

    public final void g(PipelinePhase phase, Function3 block) {
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(block, "block");
        PhaseContent phaseContentB = b(phase);
        if (phaseContentB == null) {
            throw new InvalidPhaseException("Phase " + phase + " was not registered for this pipeline");
        }
        TypeIntrinsics.b(3, block);
        List list = (List) this._interceptors;
        if (!this.f50583b.isEmpty() && list != null && !this.f50585d && (list instanceof List) && (!(list instanceof KMappedMarker) || (list instanceof KMutableList))) {
            if (Intrinsics.b(this.f50586e, phase)) {
                list.add(block);
            } else if (Intrinsics.b(phase, CollectionsKt.F(this.f50583b)) || c(phase) == CollectionsKt.B(this.f50583b)) {
                PhaseContent phaseContentB2 = b(phase);
                Intrinsics.c(phaseContentB2);
                phaseContentB2.a(block);
                list.add(block);
            }
            this.f50584c++;
            return;
        }
        phaseContentB.a(block);
        this.f50584c++;
        this._interceptors = null;
        this.f50585d = false;
        this.f50586e = null;
    }
}
