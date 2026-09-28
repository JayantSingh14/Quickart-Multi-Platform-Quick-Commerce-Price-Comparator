package androidx.constraintlayout.core;

import androidx.constraintlayout.core.Pools;

/* loaded from: classes3.dex */
public class Cache {

    /* renamed from: a, reason: collision with root package name */
    public final Pools.SimplePool f1661a;

    /* renamed from: b, reason: collision with root package name */
    public final Pools.SimplePool f1662b;

    /* renamed from: c, reason: collision with root package name */
    public SolverVariable[] f1663c;

    public Cache() {
        new Pools.SimplePool();
        this.f1661a = new Pools.SimplePool();
        this.f1662b = new Pools.SimplePool();
        this.f1663c = new SolverVariable[32];
    }
}
