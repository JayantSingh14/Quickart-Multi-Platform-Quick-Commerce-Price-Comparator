package com.facebook.react.runtime;

import com.facebook.react.runtime.ReactHostImpl;
import com.facebook.react.runtime.internal.bolts.Task;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements ReactHostImpl.ReactInstanceTaskUnwrapper {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReactHostImpl f19297a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f19298b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f19299c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f19300d;

    public /* synthetic */ f(ReactHostImpl reactHostImpl, String str, String str2, String str3) {
        this.f19297a = reactHostImpl;
        this.f19298b = str;
        this.f19299c = str2;
        this.f19300d = str3;
    }

    public final ReactInstance a(Task task, String str) {
        AtomicInteger atomicInteger = ReactHostImpl.A;
        ReactHostImpl reactHostImpl = this.f19297a;
        reactHostImpl.getClass();
        ReactInstance reactInstance = (ReactInstance) task.g();
        ReactInstance reactInstance2 = reactHostImpl.f19250l;
        String strConcat = "Stage: ".concat(str);
        StringBuilder sb = new StringBuilder();
        String str2 = this.f19298b;
        sb.append(str2);
        sb.append(" reason: ");
        sb.append(this.f19299c);
        String string = sb.toString();
        boolean zJ = task.j();
        String str3 = this.f19300d;
        if (zJ) {
            String str4 = "Fault reason: " + task.f().getMessage();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(": ReactInstance task faulted. ");
            sb2.append(strConcat);
            sb2.append(". ");
            sb2.append(str4);
            reactHostImpl.s(str3, android.support.v4.media.b.r(sb2, ". ", string), null);
            return reactInstance2;
        }
        if (task.h()) {
            reactHostImpl.s(str3, str2 + ": ReactInstance task cancelled. " + strConcat + ". " + string, null);
            return reactInstance2;
        }
        if (reactInstance == null) {
            reactHostImpl.s(str3, str2 + ": ReactInstance task returned null. " + strConcat + ". " + string, null);
            return reactInstance2;
        }
        if (reactInstance2 != null && reactInstance != reactInstance2) {
            reactHostImpl.s(str3, str2 + ": Detected two different ReactInstances. Returning old. " + strConcat + ". " + string, null);
        }
        return reactInstance;
    }
}
