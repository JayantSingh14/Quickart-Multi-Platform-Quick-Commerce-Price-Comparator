package ch.qos.logback.classic;

import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.helpers.BasicMarker;

/* loaded from: classes3.dex */
public class ClassicConstants {

    /* renamed from: a, reason: collision with root package name */
    public static final Marker f13232a;

    static {
        ConcurrentHashMap concurrentHashMap = MarkerFactory.f57877a.f57888a;
        Marker basicMarker = (Marker) concurrentHashMap.get("FINALIZE_SESSION");
        if (basicMarker == null) {
            basicMarker = new BasicMarker();
            Marker marker = (Marker) concurrentHashMap.putIfAbsent("FINALIZE_SESSION", basicMarker);
            if (marker != null) {
                basicMarker = marker;
            }
        }
        f13232a = basicMarker;
    }
}
