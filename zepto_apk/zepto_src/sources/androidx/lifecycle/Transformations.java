package androidx.lifecycle;

import androidx.lifecycle.MediatorLiveData;
import com.brentvatne.common.react.r;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
@JvmName
/* loaded from: classes3.dex */
public final class Transformations {
    public static final MediatorLiveData a(LiveData liveData, final Function1 transform) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        final MediatorLiveData mediatorLiveData = liveData.f4835e != LiveData.f4830k ? new MediatorLiveData(transform.invoke(liveData.d())) : new MediatorLiveData();
        mediatorLiveData.l(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Function1<Object, Unit>() { // from class: androidx.lifecycle.Transformations$map$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                mediatorLiveData.k(transform.invoke(obj));
                return Unit.f53572a;
            }
        }));
        return mediatorLiveData;
    }

    public static final MediatorLiveData b(MutableLiveData mutableLiveData, final r transform) {
        LiveData liveData;
        Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Object obj = mutableLiveData.f4835e;
        Object obj2 = LiveData.f4830k;
        final MediatorLiveData mediatorLiveData = (obj == obj2 || (liveData = (LiveData) transform.invoke(mutableLiveData.d())) == null || liveData.f4835e == obj2) ? new MediatorLiveData() : new MediatorLiveData(liveData.d());
        mediatorLiveData.l(mutableLiveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Function1<Object, Unit>() { // from class: androidx.lifecycle.Transformations$switchMap$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                LiveData liveData2 = (LiveData) transform.invoke(obj3);
                Ref.ObjectRef objectRef2 = objectRef;
                Object obj4 = objectRef2.f53801a;
                if (obj4 != liveData2) {
                    final MediatorLiveData mediatorLiveData2 = mediatorLiveData;
                    if (obj4 != null) {
                        MediatorLiveData.Source source = (MediatorLiveData.Source) mediatorLiveData2.f4851l.f((LiveData) obj4);
                        if (source != null) {
                            source.f4852a.j(source);
                        }
                    }
                    objectRef2.f53801a = liveData2;
                    if (liveData2 != null) {
                        mediatorLiveData2.l(liveData2, new Transformations$sam$androidx_lifecycle_Observer$0(new Function1<Object, Unit>() { // from class: androidx.lifecycle.Transformations$switchMap$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj5) {
                                mediatorLiveData2.k(obj5);
                                return Unit.f53572a;
                            }
                        }));
                    }
                }
                return Unit.f53572a;
            }
        }));
        return mediatorLiveData;
    }
}
