package com.facebook.react.shell;

import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.swmansion.reanimated.ReanimatedPackage;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements ReactModuleInfoProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19362a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashMap f19363b;

    public /* synthetic */ a(HashMap map, int i2) {
        this.f19362a = i2;
        this.f19363b = map;
    }

    @Override // com.facebook.react.module.model.ReactModuleInfoProvider
    public final Map a() {
        switch (this.f19362a) {
            case 0:
                return (LinkedHashMap) this.f19363b;
            default:
                return ReanimatedPackage.lambda$getReactModuleInfoProvider$0(this.f19363b);
        }
    }
}
