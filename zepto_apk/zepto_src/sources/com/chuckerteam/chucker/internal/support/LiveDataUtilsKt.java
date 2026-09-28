package com.chuckerteam.chucker.internal.support;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.brentvatne.common.react.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: classes3.dex */
public final class LiveDataUtilsKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f16776a = new Object();

    public static final MediatorLiveData a(LiveData liveData, MutableLiveData other, final Function2 func) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(func, "func");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final int i2 = 0;
        mediatorLiveData.l(liveData, new LiveDataUtilsKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.chuckerteam.chucker.internal.support.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                switch (i2) {
                    case 0:
                        objectRef.f53801a = obj;
                        Object obj2 = objectRef2.f53801a;
                        MediatorLiveData mediatorLiveData2 = mediatorLiveData;
                        if (obj == null && mediatorLiveData2.d() != null) {
                            mediatorLiveData2.k(null);
                        } else if (obj != null && obj2 != null) {
                            mediatorLiveData2.k(func.invoke(obj, obj2));
                        }
                        break;
                    default:
                        objectRef.f53801a = obj;
                        Object obj3 = objectRef2.f53801a;
                        MediatorLiveData mediatorLiveData3 = mediatorLiveData;
                        if (obj == null && mediatorLiveData3.d() != null) {
                            mediatorLiveData3.k(null);
                        } else if (obj3 != null && obj != null) {
                            mediatorLiveData3.k(func.invoke(obj3, obj));
                        }
                        break;
                }
                return Unit.f53572a;
            }
        }));
        final int i3 = 1;
        mediatorLiveData.l(other, new LiveDataUtilsKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.chuckerteam.chucker.internal.support.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                switch (i3) {
                    case 0:
                        objectRef2.f53801a = obj;
                        Object obj2 = objectRef.f53801a;
                        MediatorLiveData mediatorLiveData2 = mediatorLiveData;
                        if (obj == null && mediatorLiveData2.d() != null) {
                            mediatorLiveData2.k(null);
                        } else if (obj != null && obj2 != null) {
                            mediatorLiveData2.k(func.invoke(obj, obj2));
                        }
                        break;
                    default:
                        objectRef2.f53801a = obj;
                        Object obj3 = objectRef.f53801a;
                        MediatorLiveData mediatorLiveData3 = mediatorLiveData;
                        if (obj == null && mediatorLiveData3.d() != null) {
                            mediatorLiveData3.k(null);
                        } else if (obj3 != null && obj != null) {
                            mediatorLiveData3.k(func.invoke(obj3, obj));
                        }
                        break;
                }
                return Unit.f53572a;
            }
        }));
        return mediatorLiveData;
    }

    public static MediatorLiveData b(LiveData liveData, com.chuckerteam.chucker.internal.data.repository.a areEqual) {
        androidx.arch.core.executor.a executor = ArchTaskExecutor.f1275c;
        Intrinsics.checkNotNullExpressionValue(executor, "getIOThreadExecutor(...)");
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(areEqual, "areEqual");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f53801a = f16776a;
        mediatorLiveData.l(liveData, new LiveDataUtilsKt$sam$androidx_lifecycle_Observer$0(new l(objectRef, areEqual, mediatorLiveData, 1)));
        return mediatorLiveData;
    }
}
