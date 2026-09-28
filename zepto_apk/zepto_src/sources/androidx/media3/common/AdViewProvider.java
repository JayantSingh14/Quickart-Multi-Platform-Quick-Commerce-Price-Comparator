package androidx.media3.common;

import android.view.ViewGroup;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* loaded from: classes3.dex */
public interface AdViewProvider {
    default List getAdOverlayInfos() {
        return ImmutableList.r();
    }

    ViewGroup getAdViewGroup();
}
