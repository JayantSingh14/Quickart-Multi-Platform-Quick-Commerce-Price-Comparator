package androidx.dynamicanimation.animation;

import android.os.SystemClock;
import android.view.Choreographer;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* loaded from: classes3.dex */
class AnimationHandler {

    /* renamed from: f, reason: collision with root package name */
    public static final ThreadLocal f4252f = new ThreadLocal();

    /* renamed from: d, reason: collision with root package name */
    public FrameCallbackProvider16 f4256d;

    /* renamed from: a, reason: collision with root package name */
    public final SimpleArrayMap f4253a = new SimpleArrayMap();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f4254b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final AnimationCallbackDispatcher f4255c = new AnimationCallbackDispatcher();

    /* renamed from: e, reason: collision with root package name */
    public boolean f4257e = false;

    public class AnimationCallbackDispatcher {
        public AnimationCallbackDispatcher() {
        }
    }

    public interface AnimationFrameCallback {
        boolean a(long j2);
    }

    public static abstract class AnimationFrameCallbackProvider {

        /* renamed from: a, reason: collision with root package name */
        public final AnimationCallbackDispatcher f4259a;

        public AnimationFrameCallbackProvider(AnimationCallbackDispatcher animationCallbackDispatcher) {
            this.f4259a = animationCallbackDispatcher;
        }
    }

    public static class FrameCallbackProvider14 extends AnimationFrameCallbackProvider {

        /* renamed from: androidx.dynamicanimation.animation.AnimationHandler$FrameCallbackProvider14$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                SystemClock.uptimeMillis();
                throw null;
            }
        }
    }

    @RequiresApi
    public static class FrameCallbackProvider16 extends AnimationFrameCallbackProvider {

        /* renamed from: b, reason: collision with root package name */
        public final Choreographer f4260b;

        /* renamed from: c, reason: collision with root package name */
        public final Choreographer.FrameCallback f4261c;

        public FrameCallbackProvider16(AnimationCallbackDispatcher animationCallbackDispatcher) {
            super(animationCallbackDispatcher);
            this.f4260b = Choreographer.getInstance();
            this.f4261c = new Choreographer.FrameCallback() { // from class: androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider16.1
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j2) {
                    ArrayList arrayList;
                    AnimationCallbackDispatcher animationCallbackDispatcher2 = FrameCallbackProvider16.this.f4259a;
                    animationCallbackDispatcher2.getClass();
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    AnimationHandler animationHandler = AnimationHandler.this;
                    animationHandler.getClass();
                    long jUptimeMillis2 = SystemClock.uptimeMillis();
                    int i2 = 0;
                    while (true) {
                        arrayList = animationHandler.f4254b;
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        AnimationFrameCallback animationFrameCallback = (AnimationFrameCallback) arrayList.get(i2);
                        if (animationFrameCallback != null) {
                            SimpleArrayMap simpleArrayMap = animationHandler.f4253a;
                            Long l2 = (Long) simpleArrayMap.get(animationFrameCallback);
                            if (l2 == null) {
                                animationFrameCallback.a(jUptimeMillis);
                            } else if (l2.longValue() < jUptimeMillis2) {
                                simpleArrayMap.remove(animationFrameCallback);
                                animationFrameCallback.a(jUptimeMillis);
                            }
                        }
                        i2++;
                    }
                    if (animationHandler.f4257e) {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            if (arrayList.get(size) == null) {
                                arrayList.remove(size);
                            }
                        }
                        animationHandler.f4257e = false;
                    }
                    if (arrayList.size() > 0) {
                        if (animationHandler.f4256d == null) {
                            animationHandler.f4256d = new FrameCallbackProvider16(animationHandler.f4255c);
                        }
                        animationHandler.f4256d.a();
                    }
                }
            };
        }

        public final void a() {
            this.f4260b.postFrameCallback(this.f4261c);
        }
    }
}
