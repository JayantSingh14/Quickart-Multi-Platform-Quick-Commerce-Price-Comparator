package bridges;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class CommonAppPackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public final List createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TruecallerAuthModule(reactApplicationContext));
        arrayList.add(new CoreNativeModule(reactApplicationContext));
        arrayList.add(new AppInfoModule(reactApplicationContext));
        arrayList.add(new CommsModule(reactApplicationContext));
        arrayList.add(new GAMInitializerModule(reactApplicationContext));
        arrayList.add(new JSIModules(reactApplicationContext));
        return arrayList;
    }

    @Override // com.facebook.react.ReactPackage
    public final List createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.EMPTY_LIST;
    }
}
