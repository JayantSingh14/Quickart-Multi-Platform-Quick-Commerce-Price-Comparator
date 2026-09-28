package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.view.ReactViewManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class FabricNameComponentMapping {

    @NotNull
    public static final FabricNameComponentMapping INSTANCE = new FabricNameComponentMapping();

    @NotNull
    private static final Map<String, String> componentNames = MapsKt.h(new Pair("View", ReactViewManager.REACT_CLASS), new Pair("Image", ReactImageManager.REACT_CLASS), new Pair("ScrollView", ReactScrollViewManager.REACT_CLASS), new Pair("Slider", "RCTSlider"), new Pair("ModalHostView", ReactModalHostManager.REACT_CLASS), new Pair("Paragraph", ReactTextViewManager.REACT_CLASS), new Pair("Text", ReactTextViewManager.REACT_CLASS), new Pair("RawText", ReactRawTextManager.REACT_CLASS), new Pair("ActivityIndicatorView", ReactProgressBarViewManager.REACT_CLASS), new Pair("ShimmeringView", "RKShimmeringView"), new Pair("TemplateView", "RCTTemplateView"), new Pair("AxialGradientView", "RCTAxialGradientView"), new Pair("Video", "RCTVideo"), new Pair("Map", "RCTMap"), new Pair("WebView", "RCTWebView"), new Pair("Keyframes", "RCTKeyframes"), new Pair("ImpressionTrackingView", "RCTImpressionTrackingView"));

    private FabricNameComponentMapping() {
    }

    @JvmStatic
    @NotNull
    public static final String getFabricComponentName(@NotNull String componentName) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        String str = componentNames.get(componentName);
        return str == null ? componentName : str;
    }
}
