package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class ActivityResultRegistry$register$3 extends ActivityResultLauncher<Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityResultRegistry f215a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f216b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ActivityResultContract f217c;

    public ActivityResultRegistry$register$3(ActivityResultRegistry activityResultRegistry, String str, ActivityResultContract activityResultContract) {
        this.f215a = activityResultRegistry;
        this.f216b = str;
        this.f217c = activityResultContract;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public final void a(Object obj) {
        ActivityResultRegistry activityResultRegistry = this.f215a;
        LinkedHashMap linkedHashMap = activityResultRegistry.f201b;
        String str = this.f216b;
        Object obj2 = linkedHashMap.get(str);
        ActivityResultContract activityResultContract = this.f217c;
        if (obj2 == null) {
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }
        int iIntValue = ((Number) obj2).intValue();
        ArrayList arrayList = activityResultRegistry.f203d;
        arrayList.add(str);
        try {
            activityResultRegistry.c(iIntValue, activityResultContract, obj);
        } catch (Exception e2) {
            arrayList.remove(str);
            throw e2;
        }
    }

    public final void b() {
        this.f215a.g(this.f216b);
    }
}
