package com.facebook.react.uimanager;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.facebook.react.common.SingleThreadAsserter;

/* loaded from: classes.dex */
class ShadowNodeRegistry {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f19471a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public final SparseBooleanArray f19472b = new SparseBooleanArray();

    /* renamed from: c, reason: collision with root package name */
    public final SingleThreadAsserter f19473c = new SingleThreadAsserter();

    public final ReactShadowNode a(int i2) {
        this.f19473c.a();
        return (ReactShadowNode) this.f19471a.get(i2);
    }
}
