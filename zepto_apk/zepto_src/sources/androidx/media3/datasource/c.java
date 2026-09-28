package androidx.media3.datasource;

import com.google.common.base.Predicate;
import java.util.Map;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5950a;

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        switch (this.f5950a) {
            case 0:
                if (((Map.Entry) obj).getKey() != null) {
                }
                break;
            default:
                if (((String) obj) != null) {
                }
                break;
        }
        return false;
    }
}
