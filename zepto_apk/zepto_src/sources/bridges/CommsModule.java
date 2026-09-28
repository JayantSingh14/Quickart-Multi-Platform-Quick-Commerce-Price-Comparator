package bridges;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.zeptoconsumerapp.Utils;
import com.zeptoconsumerapp.modules.helper.StorageHelper;
import com.zeptoconsumerapp.modules.notification.utils.NotificationUtils;
import com.zeptoconsumerapp.modules.notification.utils.NotificationUtilsKt;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class CommsModule extends ReactContextBaseJavaModule {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String MODULE_NAME = "CommsModule";

    @NotNull
    public static final String SHARED_PREFERENCE_NAME = "Zepto";

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommsModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @ReactMethod
    public final void dismissStickyNotification(@NotNull String category, @NotNull ReadableMap data) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(data, "data");
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        NotificationUtilsKt.a(reactApplicationContext, data, category);
    }

    @ReactMethod
    public final void getId(@NotNull String key, @NotNull Promise promise) {
        Object objE;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        StorageHelper.f47656a.a();
        String strA = StorageHelper.a(key);
        try {
            objE = Utils.c().e(strA, new TypeToken<String>() { // from class: bridges.CommsModule$getId$$inlined$get$1
            }.f45460b);
        } catch (Exception unused) {
            objE = (String) MapsKt.c();
        }
        String str = (String) objE;
        if (str != null) {
            promise.resolve(str);
        } else {
            promise.resolve(Arguments.createMap());
        }
    }

    @ReactMethod
    public final void getMeta(@NotNull String key, @NotNull Promise promise) {
        Object objC;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(promise, "promise");
        StorageHelper.f47656a.a();
        String strA = StorageHelper.a(key);
        try {
            objC = Utils.c().e(strA, new TypeToken<Map<String, ? extends Object>>() { // from class: bridges.CommsModule$getMeta$$inlined$get$1
            }.f45460b);
        } catch (Exception unused) {
            objC = MapsKt.c();
        }
        Map map = (Map) objC;
        if (map != null) {
            promise.resolve(Arguments.makeNativeMap((Map<String, Object>) map));
        } else {
            promise.resolve(Arguments.createMap());
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return MODULE_NAME;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ReactMethod
    public final void setId(@NotNull String key, @NotNull String id) {
        Object objE;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(id, "id");
        StorageHelper.Companion companion = StorageHelper.f47656a;
        try {
            companion.a();
            try {
                objE = Utils.c().e(StorageHelper.a(key), new TypeToken<String>() { // from class: bridges.CommsModule$setId$$inlined$set$1
                }.f45460b);
            } catch (Exception unused) {
                objE = (String) MapsKt.c();
            }
            JsonElement jsonElementM = Utils.c().m(objE);
            JsonObject jsonObject = (jsonElementM == null || !(jsonElementM instanceof JsonObject)) ? new JsonObject() : jsonElementM.f();
            JsonElement jsonElementM2 = Utils.c().m(id);
            jsonElementM2.getClass();
            if (jsonElementM2 instanceof JsonObject) {
                NotificationUtils.Companion.b(jsonObject, jsonElementM2.f());
            } else {
                jsonObject = jsonElementM2;
            }
            companion.a();
            String strI = Utils.c().i(jsonObject);
            Intrinsics.checkNotNullExpressionValue(strI, "toJson(...)");
            StorageHelper.c(key, strI);
        } catch (Exception unused2) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ReactMethod
    public final void setMeta(@NotNull String key, @NotNull ReadableMap value) {
        Object objE;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            HashMap<String, Object> hashMap = value.toHashMap();
            StorageHelper.Companion companion = StorageHelper.f47656a;
            companion.a();
            try {
                objE = Utils.c().e(StorageHelper.a(key), new TypeToken<HashMap<String, Object>>() { // from class: bridges.CommsModule$setMeta$$inlined$set$1
                }.f45460b);
            } catch (Exception unused) {
                objE = (HashMap) MapsKt.c();
            }
            JsonElement jsonElementM = Utils.c().m(objE);
            JsonObject jsonObject = (jsonElementM == null || !(jsonElementM instanceof JsonObject)) ? new JsonObject() : jsonElementM.f();
            JsonElement jsonElementM2 = Utils.c().m(hashMap);
            jsonElementM2.getClass();
            if (jsonElementM2 instanceof JsonObject) {
                NotificationUtils.Companion.b(jsonObject, jsonElementM2.f());
            } else {
                jsonObject = jsonElementM2;
            }
            companion.a();
            String strI = Utils.c().i(jsonObject);
            Intrinsics.checkNotNullExpressionValue(strI, "toJson(...)");
            StorageHelper.c(key, strI);
        } catch (Exception unused2) {
        }
    }
}
