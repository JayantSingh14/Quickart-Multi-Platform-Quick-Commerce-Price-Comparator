package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SpringAnimation extends AnimationDriver {

    /* renamed from: e, reason: collision with root package name */
    public long f18648e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f18649f;

    /* renamed from: g, reason: collision with root package name */
    public double f18650g;

    /* renamed from: h, reason: collision with root package name */
    public double f18651h;

    /* renamed from: i, reason: collision with root package name */
    public double f18652i;

    /* renamed from: j, reason: collision with root package name */
    public double f18653j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f18654k;

    /* renamed from: l, reason: collision with root package name */
    public final PhysicsState f18655l;

    /* renamed from: m, reason: collision with root package name */
    public double f18656m;
    public double n;
    public double o;
    public double p;
    public double q;
    public int r;
    public int s;
    public double t;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class PhysicsState {

        /* renamed from: a, reason: collision with root package name */
        public double f18657a;

        /* renamed from: b, reason: collision with root package name */
        public double f18658b;

        public PhysicsState() {
            this(0);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PhysicsState)) {
                return false;
            }
            PhysicsState physicsState = (PhysicsState) obj;
            return Double.compare(this.f18657a, physicsState.f18657a) == 0 && Double.compare(this.f18658b, physicsState.f18658b) == 0;
        }

        public final int hashCode() {
            return Double.hashCode(this.f18658b) + (Double.hashCode(this.f18657a) * 31);
        }

        public final String toString() {
            return "PhysicsState(position=" + this.f18657a + ", velocity=" + this.f18658b + ")";
        }

        public PhysicsState(int i2) {
            this.f18657a = 0.0d;
            this.f18658b = 0.0d;
        }
    }

    public SpringAnimation(ReadableMap config) {
        Intrinsics.checkNotNullParameter(config, "config");
        PhysicsState physicsState = new PhysicsState(0);
        this.f18655l = physicsState;
        physicsState.f18658b = config.getDouble("initialVelocity");
        a(config);
    }

    @Override // com.facebook.react.animated.AnimationDriver
    public final void a(ReadableMap config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.f18650g = config.getDouble("stiffness");
        this.f18651h = config.getDouble("damping");
        this.f18652i = config.getDouble("mass");
        this.f18653j = this.f18655l.f18658b;
        this.n = config.getDouble("toValue");
        this.o = config.getDouble("restSpeedThreshold");
        this.p = config.getDouble("restDisplacementThreshold");
        this.f18654k = config.getBoolean("overshootClamping");
        int i2 = config.hasKey("iterations") ? config.getInt("iterations") : 1;
        this.r = i2;
        this.f18525a = i2 == 0;
        this.s = 0;
        this.q = 0.0d;
        this.f18649f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x012c  */
    @Override // com.facebook.react.animated.AnimationDriver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(long r27) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.SpringAnimation.b(long):void");
    }

    public final boolean c() {
        PhysicsState physicsState = this.f18655l;
        if (Math.abs(physicsState.f18658b) <= this.o) {
            return Math.abs(this.n - physicsState.f18657a) <= this.p || this.f18650g == 0.0d;
        }
        return false;
    }
}
