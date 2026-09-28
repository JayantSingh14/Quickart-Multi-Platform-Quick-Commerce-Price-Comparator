package fr.greweb.reactnativeviewshot;

import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements ReactModuleInfoProvider {
    @Override // com.facebook.react.module.model.ReactModuleInfoProvider
    public final Map a() {
        HashMap map = new HashMap();
        map.put(NativeRNViewShotSpec.NAME, new ReactModuleInfo(NativeRNViewShotSpec.NAME, NativeRNViewShotSpec.NAME, false, false, false, false));
        return map;
    }
}
