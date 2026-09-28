package cl.json;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.reactcommunity.rndatetimepicker.DatePickerModule;
import com.reactcommunity.rndatetimepicker.TimePickerModule;
import com.reactnativedocumentpicker.NativeDocumentPickerSpec;
import com.rt2zz.reactnativecontacts.ReactNativeContacts;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements ReactModuleInfoProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13829a;

    public /* synthetic */ a(int i2) {
        this.f13829a = i2;
    }

    @Override // com.facebook.react.module.model.ReactModuleInfoProvider
    public final Map a() {
        switch (this.f13829a) {
            case 0:
                HashMap map = new HashMap();
                map.put("RNShare", new ReactModuleInfo("RNShare", "RNShare", false, false, false, true, 0));
                return map;
            case 1:
                HashMap map2 = new HashMap();
                map2.put("ReactNativeBlobUtil", new ReactModuleInfo("ReactNativeBlobUtil", "ReactNativeBlobUtil", false, false, false, false, 0));
                return map2;
            case 2:
                HashMap map3 = new HashMap();
                map3.put("ImagePicker", new ReactModuleInfo("ImagePicker", "ImagePicker", false, false, false, false, 0));
                return map3;
            case 3:
                HashMap map4 = new HashMap();
                map4.put(DatePickerModule.NAME, new ReactModuleInfo(DatePickerModule.NAME, DatePickerModule.NAME, false, false, false, false, 0));
                map4.put(TimePickerModule.NAME, new ReactModuleInfo(TimePickerModule.NAME, TimePickerModule.NAME, false, false, false, false, 0));
                return map4;
            case 4:
                HashMap map5 = new HashMap();
                map5.put("RNCWebView", new ReactModuleInfo("RNCWebView", "RNCWebView", false, false, false, false, 0));
                return map5;
            case 5:
                HashMap map6 = new HashMap();
                map6.put(NativeDocumentPickerSpec.NAME, new ReactModuleInfo(NativeDocumentPickerSpec.NAME, NativeDocumentPickerSpec.NAME, false, false, false, false, 0));
                return map6;
            case 6:
                return ReactNativeContacts.lambda$getReactModuleInfoProvider$0();
            case 7:
                Annotation annotation = RNGestureHandlerModule.class.getAnnotation(ReactModule.class);
                Intrinsics.c(annotation);
                ReactModule reactModule = (ReactModule) annotation;
                String strName = reactModule.name();
                String name = RNGestureHandlerModule.class.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                return MapsKt.i(new Pair("RNGestureHandlerModule", new ReactModuleInfo(strName, name, reactModule.canOverrideExistingModule(), reactModule.needsEagerInit(), reactModule.isCxxModule(), true)));
            case 8:
                HashMap map7 = new HashMap();
                map7.put("RNSModule", new ReactModuleInfo("RNSModule", "RNSModule", false, false, false, false, 0));
                return map7;
            default:
                HashMap map8 = new HashMap();
                map8.put("RNSentry", new ReactModuleInfo("RNSentry", "RNSentry", false, false, false, false, 0));
                return map8;
        }
    }
}
