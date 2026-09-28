package androidx.lifecycle.viewmodel.internal;

import androidx.fragment.app.e;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ViewModelImpl {

    /* renamed from: a, reason: collision with root package name */
    public final SynchronizedObject f4968a = new SynchronizedObject();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f4969b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashSet f4970c = new LinkedHashSet();

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f4971d;

    public static void a(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                e.z(autoCloseable);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }
}
