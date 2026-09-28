package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.fragment.app.e;
import androidx.room.Entity;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.OverwritingInputMerger;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.xbill.DNS.KEYRecord;

@Metadata
@Entity
@RestrictTo
@SourceDebugExtension
/* loaded from: classes.dex */
public final class WorkSpec {
    public static final String x;
    public static final a y;

    /* renamed from: a, reason: collision with root package name */
    public final String f12905a;

    /* renamed from: b, reason: collision with root package name */
    public WorkInfo.State f12906b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12907c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12908d;

    /* renamed from: e, reason: collision with root package name */
    public Data f12909e;

    /* renamed from: f, reason: collision with root package name */
    public final Data f12910f;

    /* renamed from: g, reason: collision with root package name */
    public long f12911g;

    /* renamed from: h, reason: collision with root package name */
    public long f12912h;

    /* renamed from: i, reason: collision with root package name */
    public long f12913i;

    /* renamed from: j, reason: collision with root package name */
    public Constraints f12914j;

    /* renamed from: k, reason: collision with root package name */
    public final int f12915k;

    /* renamed from: l, reason: collision with root package name */
    public BackoffPolicy f12916l;

    /* renamed from: m, reason: collision with root package name */
    public long f12917m;
    public long n;
    public final long o;
    public final long p;
    public boolean q;
    public final OutOfQuotaPolicy r;
    public final int s;
    public final int t;
    public final long u;
    public final int v;
    public final int w;

    @Metadata
    public static final class Companion {
        public static long a(boolean z, int i2, BackoffPolicy backoffPolicy, long j2, long j3, int i3, boolean z2, long j4, long j5, long j6, long j7) {
            Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
            if (j7 != Long.MAX_VALUE && z2) {
                if (i3 != 0) {
                    long j8 = j3 + 900000;
                    if (j7 < j8) {
                        return j8;
                    }
                }
                return j7;
            }
            if (z) {
                long jScalb = backoffPolicy == BackoffPolicy.f12472b ? j2 * i2 : (long) Math.scalb(j2, i2 - 1);
                if (jScalb > 18000000) {
                    jScalb = 18000000;
                }
                return j3 + jScalb;
            }
            if (z2) {
                long j9 = i3 == 0 ? j3 + j4 : j3 + j6;
                return (j5 == j6 || i3 != 0) ? j9 : (j6 - j5) + j9;
            }
            if (j3 == -1) {
                return Long.MAX_VALUE;
            }
            return j3 + j4;
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class IdAndState {

        /* renamed from: a, reason: collision with root package name */
        public String f12918a;

        /* renamed from: b, reason: collision with root package name */
        public WorkInfo.State f12919b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            return Intrinsics.b(this.f12918a, idAndState.f12918a) && this.f12919b == idAndState.f12919b;
        }

        public final int hashCode() {
            return this.f12919b.hashCode() + (this.f12918a.hashCode() * 31);
        }

        public final String toString() {
            return "IdAndState(id=" + this.f12918a + ", state=" + this.f12919b + ')';
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class WorkInfoPojo {

        /* renamed from: a, reason: collision with root package name */
        public final String f12920a;

        /* renamed from: b, reason: collision with root package name */
        public final WorkInfo.State f12921b;

        /* renamed from: c, reason: collision with root package name */
        public final Data f12922c;

        /* renamed from: d, reason: collision with root package name */
        public final long f12923d;

        /* renamed from: e, reason: collision with root package name */
        public final long f12924e;

        /* renamed from: f, reason: collision with root package name */
        public final long f12925f;

        /* renamed from: g, reason: collision with root package name */
        public final Constraints f12926g;

        /* renamed from: h, reason: collision with root package name */
        public final int f12927h;

        /* renamed from: i, reason: collision with root package name */
        public final BackoffPolicy f12928i;

        /* renamed from: j, reason: collision with root package name */
        public final long f12929j;

        /* renamed from: k, reason: collision with root package name */
        public final long f12930k;

        /* renamed from: l, reason: collision with root package name */
        public final int f12931l;

        /* renamed from: m, reason: collision with root package name */
        public final int f12932m;
        public final long n;
        public final int o;
        public final ArrayList p;
        public final ArrayList q;

        public WorkInfoPojo(String id, WorkInfo.State state, Data output, long j2, long j3, long j4, Constraints constraints, int i2, BackoffPolicy backoffPolicy, long j5, long j6, int i3, int i4, long j7, int i5, ArrayList tags, ArrayList progress) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(output, "output");
            Intrinsics.checkNotNullParameter(constraints, "constraints");
            Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
            Intrinsics.checkNotNullParameter(tags, "tags");
            Intrinsics.checkNotNullParameter(progress, "progress");
            this.f12920a = id;
            this.f12921b = state;
            this.f12922c = output;
            this.f12923d = j2;
            this.f12924e = j3;
            this.f12925f = j4;
            this.f12926g = constraints;
            this.f12927h = i2;
            this.f12928i = backoffPolicy;
            this.f12929j = j5;
            this.f12930k = j6;
            this.f12931l = i3;
            this.f12932m = i4;
            this.n = j7;
            this.o = i5;
            this.p = tags;
            this.q = progress;
        }

        public final WorkInfo a() {
            WorkInfo.PeriodicityInfo periodicityInfo;
            int i2;
            long j2;
            long jA;
            boolean z;
            ArrayList arrayList = this.q;
            Data progress = !arrayList.isEmpty() ? (Data) arrayList.get(0) : Data.f12509c;
            UUID uuidFromString = UUID.fromString(this.f12920a);
            Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(id)");
            HashSet hashSet = new HashSet(this.p);
            Intrinsics.checkNotNullExpressionValue(progress, "progress");
            long j3 = this.f12924e;
            WorkInfo.PeriodicityInfo periodicityInfo2 = j3 != 0 ? new WorkInfo.PeriodicityInfo(j3, this.f12925f) : null;
            WorkInfo.State state = WorkInfo.State.f12566a;
            int i3 = this.f12927h;
            long j4 = this.f12923d;
            WorkInfo.State state2 = this.f12921b;
            if (state2 == state) {
                String str = WorkSpec.x;
                boolean z2 = true;
                if (state2 != state || i3 <= 0) {
                    z = true;
                    z2 = false;
                } else {
                    z = true;
                }
                periodicityInfo = periodicityInfo2;
                j2 = j4;
                jA = Companion.a(z2, i3, this.f12928i, this.f12929j, this.f12930k, this.f12931l, j3 != 0 ? z : false, j2, this.f12925f, j3, this.n);
                i2 = i3;
            } else {
                periodicityInfo = periodicityInfo2;
                i2 = i3;
                j2 = j4;
                jA = Long.MAX_VALUE;
            }
            return new WorkInfo(uuidFromString, this.f12921b, hashSet, this.f12922c, progress, i2, this.f12932m, this.f12926g, j2, periodicityInfo, jA, this.o);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WorkInfoPojo)) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) obj;
            return Intrinsics.b(this.f12920a, workInfoPojo.f12920a) && this.f12921b == workInfoPojo.f12921b && Intrinsics.b(this.f12922c, workInfoPojo.f12922c) && this.f12923d == workInfoPojo.f12923d && this.f12924e == workInfoPojo.f12924e && this.f12925f == workInfoPojo.f12925f && this.f12926g.equals(workInfoPojo.f12926g) && this.f12927h == workInfoPojo.f12927h && this.f12928i == workInfoPojo.f12928i && this.f12929j == workInfoPojo.f12929j && this.f12930k == workInfoPojo.f12930k && this.f12931l == workInfoPojo.f12931l && this.f12932m == workInfoPojo.f12932m && this.n == workInfoPojo.n && this.o == workInfoPojo.o && this.p.equals(workInfoPojo.p) && this.q.equals(workInfoPojo.q);
        }

        public final int hashCode() {
            return this.q.hashCode() + ((this.p.hashCode() + android.support.v4.media.a.b(this.o, android.support.v4.media.a.d(android.support.v4.media.a.b(this.f12932m, android.support.v4.media.a.b(this.f12931l, android.support.v4.media.a.d(android.support.v4.media.a.d((this.f12928i.hashCode() + android.support.v4.media.a.b(this.f12927h, (this.f12926g.hashCode() + android.support.v4.media.a.d(android.support.v4.media.a.d(android.support.v4.media.a.d((this.f12922c.hashCode() + ((this.f12921b.hashCode() + (this.f12920a.hashCode() * 31)) * 31)) * 31, 31, this.f12923d), 31, this.f12924e), 31, this.f12925f)) * 31, 31)) * 31, 31, this.f12929j), 31, this.f12930k), 31), 31), 31, this.n), 31)) * 31);
        }

        public final String toString() {
            return "WorkInfoPojo(id=" + this.f12920a + ", state=" + this.f12921b + ", output=" + this.f12922c + ", initialDelay=" + this.f12923d + ", intervalDuration=" + this.f12924e + ", flexDuration=" + this.f12925f + ", constraints=" + this.f12926g + ", runAttemptCount=" + this.f12927h + ", backoffPolicy=" + this.f12928i + ", backoffDelayDuration=" + this.f12929j + ", lastEnqueueTime=" + this.f12930k + ", periodCount=" + this.f12931l + ", generation=" + this.f12932m + ", nextScheduleTimeOverride=" + this.n + ", stopReason=" + this.o + ", tags=" + this.p + ", progress=" + this.q + ')';
        }
    }

    static {
        String strG = Logger.g("WorkSpec");
        Intrinsics.checkNotNullExpressionValue(strG, "tagWithPrefix(\"WorkSpec\")");
        x = strG;
        y = new a(0);
    }

    public WorkSpec(String id, WorkInfo.State state, String workerClassName, String inputMergerClassName, Data input, Data output, long j2, long j3, long j4, Constraints constraints, int i2, BackoffPolicy backoffPolicy, long j5, long j6, long j7, long j8, boolean z, OutOfQuotaPolicy outOfQuotaPolicy, int i3, int i4, long j9, int i5, int i6) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(workerClassName, "workerClassName");
        Intrinsics.checkNotNullParameter(inputMergerClassName, "inputMergerClassName");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(constraints, "constraints");
        Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
        Intrinsics.checkNotNullParameter(outOfQuotaPolicy, "outOfQuotaPolicy");
        this.f12905a = id;
        this.f12906b = state;
        this.f12907c = workerClassName;
        this.f12908d = inputMergerClassName;
        this.f12909e = input;
        this.f12910f = output;
        this.f12911g = j2;
        this.f12912h = j3;
        this.f12913i = j4;
        this.f12914j = constraints;
        this.f12915k = i2;
        this.f12916l = backoffPolicy;
        this.f12917m = j5;
        this.n = j6;
        this.o = j7;
        this.p = j8;
        this.q = z;
        this.r = outOfQuotaPolicy;
        this.s = i3;
        this.t = i4;
        this.u = j9;
        this.v = i5;
        this.w = i6;
    }

    public final long a() {
        return Companion.a(this.f12906b == WorkInfo.State.f12566a && this.f12915k > 0, this.f12915k, this.f12916l, this.f12917m, this.n, this.s, c(), this.f12911g, this.f12913i, this.f12912h, this.u);
    }

    public final boolean b() {
        return !Intrinsics.b(Constraints.f12486i, this.f12914j);
    }

    public final boolean c() {
        return this.f12912h != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkSpec)) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        return Intrinsics.b(this.f12905a, workSpec.f12905a) && this.f12906b == workSpec.f12906b && Intrinsics.b(this.f12907c, workSpec.f12907c) && Intrinsics.b(this.f12908d, workSpec.f12908d) && Intrinsics.b(this.f12909e, workSpec.f12909e) && Intrinsics.b(this.f12910f, workSpec.f12910f) && this.f12911g == workSpec.f12911g && this.f12912h == workSpec.f12912h && this.f12913i == workSpec.f12913i && Intrinsics.b(this.f12914j, workSpec.f12914j) && this.f12915k == workSpec.f12915k && this.f12916l == workSpec.f12916l && this.f12917m == workSpec.f12917m && this.n == workSpec.n && this.o == workSpec.o && this.p == workSpec.p && this.q == workSpec.q && this.r == workSpec.r && this.s == workSpec.s && this.t == workSpec.t && this.u == workSpec.u && this.v == workSpec.v && this.w == workSpec.w;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iD = android.support.v4.media.a.d(android.support.v4.media.a.d(android.support.v4.media.a.d(android.support.v4.media.a.d((this.f12916l.hashCode() + android.support.v4.media.a.b(this.f12915k, (this.f12914j.hashCode() + android.support.v4.media.a.d(android.support.v4.media.a.d(android.support.v4.media.a.d((this.f12910f.hashCode() + ((this.f12909e.hashCode() + e.e(e.e((this.f12906b.hashCode() + (this.f12905a.hashCode() * 31)) * 31, 31, this.f12907c), 31, this.f12908d)) * 31)) * 31, 31, this.f12911g), 31, this.f12912h), 31, this.f12913i)) * 31, 31)) * 31, 31, this.f12917m), 31, this.n), 31, this.o), 31, this.p);
        boolean z = this.q;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return Integer.hashCode(this.w) + android.support.v4.media.a.b(this.v, android.support.v4.media.a.d(android.support.v4.media.a.b(this.t, android.support.v4.media.a.b(this.s, (this.r.hashCode() + ((iD + i2) * 31)) * 31, 31), 31), 31, this.u), 31);
    }

    public final String toString() {
        return e.t(new StringBuilder("{WorkSpec: "), this.f12905a, '}');
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WorkSpec(String str, WorkInfo.State state, String str2, String str3, Data data, Data data2, long j2, long j3, long j4, Constraints constraints, int i2, BackoffPolicy backoffPolicy, long j5, long j6, long j7, long j8, boolean z, OutOfQuotaPolicy outOfQuotaPolicy, int i3, long j9, int i4, int i5, int i6) {
        String str4;
        Data data3;
        Data data4;
        WorkInfo.State state2 = (i6 & 2) != 0 ? WorkInfo.State.f12566a : state;
        if ((i6 & 8) != 0) {
            String name = OverwritingInputMerger.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "OverwritingInputMerger::class.java.name");
            str4 = name;
        } else {
            str4 = str3;
        }
        if ((i6 & 16) != 0) {
            Data EMPTY = Data.f12509c;
            Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
            data3 = EMPTY;
        } else {
            data3 = data;
        }
        if ((i6 & 32) != 0) {
            Data EMPTY2 = Data.f12509c;
            Intrinsics.checkNotNullExpressionValue(EMPTY2, "EMPTY");
            data4 = EMPTY2;
        } else {
            data4 = data2;
        }
        this(str, state2, str2, str4, data3, data4, (i6 & 64) != 0 ? 0L : j2, (i6 & 128) != 0 ? 0L : j3, (i6 & 256) != 0 ? 0L : j4, (i6 & 512) != 0 ? Constraints.f12486i : constraints, (i6 & 1024) != 0 ? 0 : i2, (i6 & 2048) != 0 ? BackoffPolicy.f12471a : backoffPolicy, (i6 & 4096) != 0 ? 30000L : j5, (i6 & KEYRecord.Flags.FLAG2) != 0 ? -1L : j6, (i6 & 16384) == 0 ? j7 : 0L, (32768 & i6) != 0 ? -1L : j8, (65536 & i6) != 0 ? false : z, (131072 & i6) != 0 ? OutOfQuotaPolicy.f12549a : outOfQuotaPolicy, (262144 & i6) != 0 ? 0 : i3, 0, (1048576 & i6) != 0 ? Long.MAX_VALUE : j9, (2097152 & i6) != 0 ? 0 : i4, (i6 & 4194304) != 0 ? -256 : i5);
    }
}
