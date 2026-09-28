package com.facebook.fresco.ui.common;

import android.util.Log;
import com.facebook.fresco.ui.common.ControllerListener2;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public class ForwardingControllerListener2<I> extends BaseControllerListener2<I> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f17467a = new ArrayList(2);

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public final void a(Object obj, String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        ArrayList arrayList = this.f17467a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                try {
                    ((ControllerListener2) arrayList.get(i2)).a(obj, id);
                    Unit unit = Unit.f53572a;
                } catch (Exception e2) {
                    Log.e("FwdControllerListener2", "InternalListener exception in onIntermediateImageSet", e2);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public final void b(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        ArrayList arrayList = this.f17467a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                try {
                    ((ControllerListener2) arrayList.get(i2)).b(id);
                    Unit unit = Unit.f53572a;
                } catch (Exception e2) {
                    Log.e("FwdControllerListener2", "InternalListener exception in onIntermediateImageFailed", e2);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public final void c(String id, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
        ArrayList arrayList = this.f17467a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                try {
                    ((ControllerListener2) arrayList.get(i2)).c(id, extras);
                    Unit unit = Unit.f53572a;
                } catch (Exception e2) {
                    Log.e("FwdControllerListener2", "InternalListener exception in onRelease", e2);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public final void e(String id, Object obj, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
        ArrayList arrayList = this.f17467a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                try {
                    ((ControllerListener2) arrayList.get(i2)).e(id, obj, extras);
                    Unit unit = Unit.f53572a;
                } catch (Exception e2) {
                    Log.e("FwdControllerListener2", "InternalListener exception in onSubmit", e2);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public final void l(String id, Throwable th, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
        ArrayList arrayList = this.f17467a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                try {
                    ((ControllerListener2) arrayList.get(i2)).l(id, th, extras);
                    Unit unit = Unit.f53572a;
                } catch (Exception e2) {
                    Log.e("FwdControllerListener2", "InternalListener exception in onFailure", e2);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.BaseControllerListener2, com.facebook.fresco.ui.common.ControllerListener2
    public final void r(String id, Object obj, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(id, "id");
        ArrayList arrayList = this.f17467a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                try {
                    ((ControllerListener2) arrayList.get(i2)).r(id, obj, extras);
                    Unit unit = Unit.f53572a;
                } catch (Exception e2) {
                    Log.e("FwdControllerListener2", "InternalListener exception in onFinalImageSet", e2);
                }
            } catch (IndexOutOfBoundsException unused) {
                return;
            }
        }
    }
}
