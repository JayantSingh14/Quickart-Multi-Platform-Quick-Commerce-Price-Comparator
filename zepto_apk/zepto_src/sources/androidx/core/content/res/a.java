package androidx.core.content.res;

import androidx.core.content.res.ResourcesCompat;
import androidx.tracing.Trace;
import com.facebook.react.uimanager.ReactRoot;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2787a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2788b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2789c;

    public /* synthetic */ a(int i2, ReactRoot reactRoot) {
        this.f2788b = i2;
        this.f2789c = reactRoot;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        switch (this.f2787a) {
            case 0:
                ((ResourcesCompat.FontCallback) this.f2789c).b(this.f2788b);
                break;
            default:
                Intrinsics.checkNotNullParameter("pre_rootView.onAttachedToReactInstance", "sectionName");
                Trace.c(this.f2788b, "pre_rootView.onAttachedToReactInstance");
                ((ReactRoot) this.f2789c).c();
                break;
        }
    }

    public /* synthetic */ a(ResourcesCompat.FontCallback fontCallback, int i2) {
        this.f2789c = fontCallback;
        this.f2788b = i2;
    }
}
