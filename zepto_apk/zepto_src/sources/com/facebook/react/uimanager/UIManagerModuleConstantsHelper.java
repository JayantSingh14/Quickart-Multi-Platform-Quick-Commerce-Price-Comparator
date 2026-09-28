package com.facebook.react.uimanager;

import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Nullsafe
/* loaded from: classes.dex */
public class UIManagerModuleConstantsHelper {
    public static HashMap a(List list, Map map, Map map2) {
        HashMap mapB = UIManagerModuleConstants.b();
        HashMap mapA = UIManagerModuleConstants.a();
        HashMap mapC = UIManagerModuleConstants.c();
        if (map != null) {
            map.putAll(mapA);
        }
        if (map2 != null) {
            map2.putAll(mapC);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ViewManager viewManager = (ViewManager) it.next();
            String name = viewManager.getName();
            HashMap mapB2 = b(viewManager, map, map2);
            if (!mapB2.isEmpty()) {
                mapB.put(name, mapB2);
            }
        }
        mapB.put("genericBubblingEventTypes", mapA);
        mapB.put("genericDirectEventTypes", mapC);
        return mapB;
    }

    public static HashMap b(ViewManager viewManager, Map map, Map map2) {
        HashMap map3 = new HashMap();
        Map<String, Object> exportedCustomBubblingEventTypeConstants = viewManager.getExportedCustomBubblingEventTypeConstants();
        if (exportedCustomBubblingEventTypeConstants != null) {
            ReactNativeFeatureFlagsAccessor reactNativeFeatureFlagsAccessor = ReactNativeFeatureFlags.f18968a;
            if (reactNativeFeatureFlagsAccessor.enableFabricRenderer() && reactNativeFeatureFlagsAccessor.useFabricInterop()) {
                exportedCustomBubblingEventTypeConstants = d(exportedCustomBubblingEventTypeConstants);
            }
            e(map, exportedCustomBubblingEventTypeConstants);
            e(exportedCustomBubblingEventTypeConstants, null);
            map3.put("bubblingEventTypes", exportedCustomBubblingEventTypeConstants);
        }
        Map<String, Object> exportedCustomDirectEventTypeConstants = viewManager.getExportedCustomDirectEventTypeConstants();
        viewManager.getName();
        if (exportedCustomDirectEventTypeConstants != null) {
            ReactNativeFeatureFlagsAccessor reactNativeFeatureFlagsAccessor2 = ReactNativeFeatureFlags.f18968a;
            if (reactNativeFeatureFlagsAccessor2.enableFabricRenderer() && reactNativeFeatureFlagsAccessor2.useFabricInterop()) {
                exportedCustomDirectEventTypeConstants = d(exportedCustomDirectEventTypeConstants);
            }
            e(map2, exportedCustomDirectEventTypeConstants);
            e(exportedCustomDirectEventTypeConstants, null);
            map3.put("directEventTypes", exportedCustomDirectEventTypeConstants);
        }
        Map<String, Object> exportedViewConstants = viewManager.getExportedViewConstants();
        if (exportedViewConstants != null) {
            map3.put("Constants", exportedViewConstants);
        }
        Map<String, Integer> commandsMap = viewManager.getCommandsMap();
        if (commandsMap != null) {
            map3.put("Commands", commandsMap);
        }
        Map<String, String> nativeProps = viewManager.getNativeProps();
        if (!nativeProps.isEmpty()) {
            map3.put("NativeProps", nativeProps);
        }
        return map3;
    }

    public static HashMap c() {
        return MapBuilder.d("bubblingEventTypes", UIManagerModuleConstants.a(), "directEventTypes", UIManagerModuleConstants.c());
    }

    public static Map d(Map map) {
        HashSet hashSet = new HashSet();
        for (Object obj : map.keySet()) {
            if (obj instanceof String) {
                String str = (String) obj;
                if (!str.startsWith("top")) {
                    hashSet.add(str);
                }
            }
        }
        if (!(map instanceof HashMap)) {
            map = new HashMap(map);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            map.put("top" + (str2.startsWith("on") ? str2.substring(2) : str2.substring(0, 1).toUpperCase() + str2.substring(1)), map.get(str2));
        }
        return map;
    }

    public static void e(Map map, Map map2) {
        if (map == null || map2 == null || map2.isEmpty()) {
            return;
        }
        for (Object obj : map2.keySet()) {
            Object obj2 = map2.get(obj);
            Object obj3 = map.get(obj);
            if (obj3 != null && (obj2 instanceof Map) && (obj3 instanceof Map)) {
                if (!(obj3 instanceof HashMap)) {
                    HashMap map3 = new HashMap((Map) obj3);
                    map.replace(obj, map3);
                    obj3 = map3;
                }
                e((Map) obj3, (Map) obj2);
            } else {
                map.put(obj, obj2);
            }
        }
    }
}
