package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collections;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Provider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43616a;

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.f43616a) {
            case 0:
                return Collections.EMPTY_SET;
            default:
                return null;
        }
    }
}
