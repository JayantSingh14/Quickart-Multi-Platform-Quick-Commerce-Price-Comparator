package com.facebook.react.views.progressbar;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.AndroidProgressBarManagerDelegate;
import com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@ReactModule(name = ReactProgressBarViewManager.REACT_CLASS)
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ReactProgressBarViewManager extends BaseViewManager<ProgressBarContainerView, ProgressBarShadowNode> implements AndroidProgressBarManagerInterface<ProgressBarContainerView> {

    @NotNull
    public static final String DEFAULT_STYLE = "Normal";

    @NotNull
    public static final String PROP_ANIMATING = "animating";

    @NotNull
    public static final String PROP_ATTR = "typeAttr";

    @NotNull
    public static final String PROP_INDETERMINATE = "indeterminate";

    @NotNull
    public static final String PROP_PROGRESS = "progress";

    @NotNull
    public static final String PROP_STYLE = "styleAttr";

    @NotNull
    public static final String REACT_CLASS = "AndroidProgressBar";

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final Object progressBarCtorLock = new Object();

    @NotNull
    private final WeakHashMap<Integer, Pair<Integer, Integer>> measuredStyles = new WeakHashMap<>();

    @NotNull
    private final ViewManagerDelegate<ProgressBarContainerView> delegate = new AndroidProgressBarManagerDelegate(this);

    @Metadata
    public static final class Companion {
        public static ProgressBar a(int i2, Context context) {
            ProgressBar progressBar;
            synchronized (ReactProgressBarViewManager.progressBarCtorLock) {
                progressBar = new ProgressBar(context, null, i2);
            }
            return progressBar;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
         */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int b(java.lang.String r3) {
            /*
                java.lang.String r0 = "ReactNative"
                r1 = 16842871(0x1010077, float:2.3693892E-38)
                if (r3 == 0) goto L6f
                int r2 = r3.hashCode()
                switch(r2) {
                    case -1955878649: goto L5d;
                    case -1414214583: goto L50;
                    case -913872828: goto L43;
                    case -670403824: goto L36;
                    case -142408811: goto L29;
                    case 73190171: goto L1c;
                    case 79996135: goto Lf;
                    default: goto Le;
                }
            Le:
                goto L65
            Lf:
                java.lang.String r2 = "Small"
                boolean r2 = r3.equals(r2)
                if (r2 != 0) goto L18
                goto L65
            L18:
                r3 = 16842873(0x1010079, float:2.3693897E-38)
                return r3
            L1c:
                java.lang.String r2 = "Large"
                boolean r2 = r3.equals(r2)
                if (r2 != 0) goto L25
                goto L65
            L25:
                r3 = 16842874(0x101007a, float:2.36939E-38)
                return r3
            L29:
                java.lang.String r2 = "LargeInverse"
                boolean r2 = r3.equals(r2)
                if (r2 != 0) goto L32
                goto L65
            L32:
                r3 = 16843401(0x1010289, float:2.3695377E-38)
                return r3
            L36:
                java.lang.String r2 = "Inverse"
                boolean r2 = r3.equals(r2)
                if (r2 != 0) goto L3f
                goto L65
            L3f:
                r3 = 16843399(0x1010287, float:2.369537E-38)
                return r3
            L43:
                java.lang.String r2 = "Horizontal"
                boolean r2 = r3.equals(r2)
                if (r2 != 0) goto L4c
                goto L65
            L4c:
                r3 = 16842872(0x1010078, float:2.3693894E-38)
                return r3
            L50:
                java.lang.String r2 = "SmallInverse"
                boolean r2 = r3.equals(r2)
                if (r2 != 0) goto L59
                goto L65
            L59:
                r3 = 16843400(0x1010288, float:2.3695374E-38)
                return r3
            L5d:
                java.lang.String r2 = "Normal"
                boolean r2 = r3.equals(r2)
                if (r2 != 0) goto L6e
            L65:
                java.lang.String r2 = "Unknown ProgressBar style: "
                java.lang.String r3 = r2.concat(r3)
                com.facebook.common.logging.FLog.q(r0, r3)
            L6e:
                return r1
            L6f:
                java.lang.String r3 = "ProgressBar needs to have a style, null received"
                com.facebook.common.logging.FLog.q(r0, r3)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.progressbar.ReactProgressBarViewManager.Companion.b(java.lang.String):int");
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ViewManagerDelegate<ProgressBarContainerView> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public Class<ProgressBarShadowNode> getShadowNodeClass() {
        return ProgressBarShadowNode.class;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public long measure(@NotNull Context context, @NotNull ReadableMap localData, @NotNull ReadableMap props, @NotNull ReadableMap state, float f2, @NotNull YogaMeasureMode widthMode, float f3, @NotNull YogaMeasureMode heightMode, @Nullable float[] fArr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(localData, "localData");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(widthMode, "widthMode");
        Intrinsics.checkNotNullParameter(heightMode, "heightMode");
        Companion companion = Companion;
        String string = props.getString(PROP_STYLE);
        companion.getClass();
        int iB = Companion.b(string);
        WeakHashMap<Integer, Pair<Integer, Integer>> weakHashMap = this.measuredStyles;
        Integer numValueOf = Integer.valueOf(iB);
        Pair<Integer, Integer> pairCreate = weakHashMap.get(numValueOf);
        if (pairCreate == null) {
            ProgressBar progressBarA = Companion.a(iB, context);
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            progressBarA.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            pairCreate = Pair.create(Integer.valueOf(progressBarA.getMeasuredWidth()), Integer.valueOf(progressBarA.getMeasuredHeight()));
            weakHashMap.put(numValueOf, pairCreate);
        }
        Pair<Integer, Integer> pair = pairCreate;
        return YogaMeasureOutput.a(PixelUtil.a(((Number) pair.first).intValue()), PixelUtil.a(((Number) pair.second).intValue()));
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    @ReactProp(name = PROP_ATTR)
    public void setTypeAttr(@NotNull ProgressBarContainerView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(@NotNull ProgressBarContainerView root, @NotNull Object extraData) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ProgressBarShadowNode createShadowNodeInstance() {
        return new ProgressBarShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ProgressBarContainerView createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        ProgressBarContainerView progressBarContainerView = new ProgressBarContainerView(context);
        progressBarContainerView.f19994b = true;
        progressBarContainerView.f19995c = true;
        return progressBarContainerView;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(@NotNull ProgressBarContainerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.a();
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    @ReactProp(name = PROP_ANIMATING)
    public void setAnimating(@NotNull ProgressBarContainerView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setAnimating$ReactAndroid_release(z);
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    @ReactProp(customType = "Color", name = "color")
    public void setColor(@NotNull ProgressBarContainerView view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setColor$ReactAndroid_release(num);
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    @ReactProp(name = PROP_INDETERMINATE)
    public void setIndeterminate(@NotNull ProgressBarContainerView view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setIndeterminate$ReactAndroid_release(z);
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    @ReactProp(name = PROP_PROGRESS)
    public void setProgress(@NotNull ProgressBarContainerView view, double d2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setProgress$ReactAndroid_release(d2);
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    @ReactProp(name = PROP_STYLE)
    public void setStyleAttr(@NotNull ProgressBarContainerView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setStyle$ReactAndroid_release(str);
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    public void setTestID(@NotNull ProgressBarContainerView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setTestId(view, str);
    }
}
