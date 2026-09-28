package androidx.core.app;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class FrameMetricsAggregator {

    /* renamed from: a, reason: collision with root package name */
    public final FrameMetricsApi24Impl f2612a;

    @RequiresApi
    public static class FrameMetricsApi24Impl extends FrameMetricsBaseImpl {

        /* renamed from: e, reason: collision with root package name */
        public static HandlerThread f2613e;

        /* renamed from: f, reason: collision with root package name */
        public static Handler f2614f;

        /* renamed from: a, reason: collision with root package name */
        public final int f2615a;

        /* renamed from: b, reason: collision with root package name */
        public SparseIntArray[] f2616b = new SparseIntArray[9];

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f2617c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public final Window.OnFrameMetricsAvailableListener f2618d = new Window.OnFrameMetricsAvailableListener() { // from class: androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl.1
            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public final void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i2) {
                FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl.f2615a & 1) != 0) {
                    FrameMetricsApi24Impl.a(frameMetricsApi24Impl.f2616b[0], frameMetrics.getMetric(8));
                }
                if ((frameMetricsApi24Impl.f2615a & 2) != 0) {
                    FrameMetricsApi24Impl.a(frameMetricsApi24Impl.f2616b[1], frameMetrics.getMetric(1));
                }
                if ((frameMetricsApi24Impl.f2615a & 4) != 0) {
                    FrameMetricsApi24Impl.a(frameMetricsApi24Impl.f2616b[2], frameMetrics.getMetric(3));
                }
                if ((frameMetricsApi24Impl.f2615a & 8) != 0) {
                    FrameMetricsApi24Impl.a(frameMetricsApi24Impl.f2616b[3], frameMetrics.getMetric(4));
                }
                if ((frameMetricsApi24Impl.f2615a & 16) != 0) {
                    FrameMetricsApi24Impl.a(frameMetricsApi24Impl.f2616b[4], frameMetrics.getMetric(5));
                }
                if ((frameMetricsApi24Impl.f2615a & 64) != 0) {
                    FrameMetricsApi24Impl.a(frameMetricsApi24Impl.f2616b[6], frameMetrics.getMetric(7));
                }
                if ((frameMetricsApi24Impl.f2615a & 32) != 0) {
                    FrameMetricsApi24Impl.a(frameMetricsApi24Impl.f2616b[5], frameMetrics.getMetric(6));
                }
                if ((frameMetricsApi24Impl.f2615a & 128) != 0) {
                    FrameMetricsApi24Impl.a(frameMetricsApi24Impl.f2616b[7], frameMetrics.getMetric(0));
                }
                if ((frameMetricsApi24Impl.f2615a & 256) != 0) {
                    FrameMetricsApi24Impl.a(frameMetricsApi24Impl.f2616b[8], frameMetrics.getMetric(2));
                }
            }
        };

        public FrameMetricsApi24Impl(int i2) {
            this.f2615a = i2;
        }

        public static void a(SparseIntArray sparseIntArray, long j2) {
            if (sparseIntArray != null) {
                int i2 = (int) ((500000 + j2) / 1000000);
                if (j2 >= 0) {
                    sparseIntArray.put(i2, sparseIntArray.get(i2) + 1);
                }
            }
        }
    }

    public static class FrameMetricsBaseImpl {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes3.dex */
    public @interface MetricType {
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public final void a(Activity activity) {
        FrameMetricsApi24Impl frameMetricsApi24Impl = this.f2612a;
        frameMetricsApi24Impl.getClass();
        if (FrameMetricsApi24Impl.f2613e == null) {
            HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
            FrameMetricsApi24Impl.f2613e = handlerThread;
            handlerThread.start();
            FrameMetricsApi24Impl.f2614f = new Handler(FrameMetricsApi24Impl.f2613e.getLooper());
        }
        for (int i2 = 0; i2 <= 8; i2++) {
            SparseIntArray[] sparseIntArrayArr = frameMetricsApi24Impl.f2616b;
            if (sparseIntArrayArr[i2] == null && (frameMetricsApi24Impl.f2615a & (1 << i2)) != 0) {
                sparseIntArrayArr[i2] = new SparseIntArray();
            }
        }
        activity.getWindow().addOnFrameMetricsAvailableListener(frameMetricsApi24Impl.f2618d, FrameMetricsApi24Impl.f2614f);
        frameMetricsApi24Impl.f2617c.add(new WeakReference(activity));
    }

    public final SparseIntArray[] b() {
        return this.f2612a.f2616b;
    }

    public final void c(Activity activity) {
        FrameMetricsApi24Impl frameMetricsApi24Impl = this.f2612a;
        ArrayList arrayList = frameMetricsApi24Impl.f2617c;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == activity) {
                arrayList.remove(weakReference);
                break;
            }
        }
        activity.getWindow().removeOnFrameMetricsAvailableListener(frameMetricsApi24Impl.f2618d);
    }

    public final void d() {
        FrameMetricsApi24Impl frameMetricsApi24Impl = this.f2612a;
        SparseIntArray[] sparseIntArrayArr = frameMetricsApi24Impl.f2616b;
        frameMetricsApi24Impl.f2616b = new SparseIntArray[9];
    }

    public final void e() {
        FrameMetricsApi24Impl frameMetricsApi24Impl = this.f2612a;
        ArrayList arrayList = frameMetricsApi24Impl.f2617c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            WeakReference weakReference = (WeakReference) arrayList.get(size);
            Activity activity = (Activity) weakReference.get();
            if (weakReference.get() != null) {
                activity.getWindow().removeOnFrameMetricsAvailableListener(frameMetricsApi24Impl.f2618d);
                arrayList.remove(size);
            }
        }
    }

    public FrameMetricsAggregator(int i2) {
        this.f2612a = new FrameMetricsApi24Impl(i2);
    }
}
