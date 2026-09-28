package androidx.webkit;

import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class WebViewAssetLoader {

    public static final class AssetsPathHandler implements PathHandler {
    }

    public static final class Builder {
        public Builder() {
            new ArrayList();
        }
    }

    public static final class InternalStoragePathHandler implements PathHandler {
    }

    public interface PathHandler {
    }

    @VisibleForTesting
    public static class PathMatcher {
    }

    public static final class ResourcesPathHandler implements PathHandler {
    }
}
