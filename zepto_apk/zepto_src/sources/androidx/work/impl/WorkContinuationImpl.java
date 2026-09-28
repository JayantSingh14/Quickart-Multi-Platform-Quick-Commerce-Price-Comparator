package androidx.work.impl;

import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkContinuation;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.EnqueueRunnable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

@RestrictTo
/* loaded from: classes.dex */
public class WorkContinuationImpl extends WorkContinuation {

    /* renamed from: i, reason: collision with root package name */
    public static final String f12632i = Logger.g("WorkContinuationImpl");

    /* renamed from: a, reason: collision with root package name */
    public final WorkManagerImpl f12633a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12634b;

    /* renamed from: c, reason: collision with root package name */
    public final ExistingWorkPolicy f12635c;

    /* renamed from: d, reason: collision with root package name */
    public final List f12636d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f12637e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f12638f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public boolean f12639g;

    /* renamed from: h, reason: collision with root package name */
    public OperationImpl f12640h;

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String str, ExistingWorkPolicy existingWorkPolicy, List list) {
        this.f12633a = workManagerImpl;
        this.f12634b = str;
        this.f12635c = existingWorkPolicy;
        this.f12636d = list;
        this.f12637e = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (existingWorkPolicy == ExistingWorkPolicy.f12516a && ((WorkRequest) list.get(i2)).f12576b.u != Long.MAX_VALUE) {
                throw new IllegalArgumentException("Next Schedule Time Override must be used with ExistingPeriodicWorkPolicyUPDATE (preferably) or KEEP");
            }
            String string = ((WorkRequest) list.get(i2)).f12575a.toString();
            Intrinsics.checkNotNullExpressionValue(string, "id.toString()");
            this.f12637e.add(string);
            this.f12638f.add(string);
        }
    }

    public static HashSet b(WorkContinuationImpl workContinuationImpl) {
        HashSet hashSet = new HashSet();
        workContinuationImpl.getClass();
        return hashSet;
    }

    public final Operation a() {
        if (this.f12639g) {
            Logger.e().h(f12632i, "Already enqueued work ids (" + TextUtils.join(", ", this.f12637e) + ")");
        } else {
            OperationImpl operationImpl = new OperationImpl();
            this.f12633a.f12656d.c(new EnqueueRunnable(this, operationImpl));
            this.f12640h = operationImpl;
        }
        return this.f12640h;
    }
}
