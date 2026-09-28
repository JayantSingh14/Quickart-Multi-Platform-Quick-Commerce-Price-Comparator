package com.facebook.react.views.debuggingoverlay;

import android.graphics.RectF;
import com.facebook.react.bridge.NoSuchKeyException;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UnexpectedNativeTypeException;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.DebuggingOverlayManagerDelegate;
import com.facebook.react.viewmanagers.DebuggingOverlayManagerInterface;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = DebuggingOverlayManager.REACT_CLASS)
@Metadata
/* loaded from: classes3.dex */
public final class DebuggingOverlayManager extends SimpleViewManager<DebuggingOverlay> implements DebuggingOverlayManagerInterface<DebuggingOverlay> {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String REACT_CLASS = "DebuggingOverlay";

    @NotNull
    private final ViewManagerDelegate<DebuggingOverlay> delegate = new DebuggingOverlayManagerDelegate(this);

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ViewManagerDelegate<DebuggingOverlay> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.viewmanagers.DebuggingOverlayManagerInterface
    public void clearElementsHighlights(@NotNull DebuggingOverlay view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.f19930e.clear();
        view.invalidate();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public DebuggingOverlay createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new DebuggingOverlay(context);
    }

    @Override // com.facebook.react.viewmanagers.DebuggingOverlayManagerInterface
    public void highlightElements(@NotNull DebuggingOverlay view, @Nullable ReadableArray readableArray) throws Exception {
        ReadableArray array;
        Intrinsics.checkNotNullParameter(view, "view");
        if (readableArray == null || (array = readableArray.getArray(0)) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size = array.size();
        boolean z = true;
        for (int i2 = 0; i2 < size; i2++) {
            ReadableMap map = array.getMap(i2);
            if (map != null) {
                try {
                    float f2 = (float) map.getDouble("x");
                    float f3 = (float) map.getDouble("y");
                    arrayList.add(new RectF(PixelUtil.b(f2), PixelUtil.b(f3), PixelUtil.b((float) (f2 + map.getDouble(Snapshot.WIDTH))), PixelUtil.b((float) (f3 + map.getDouble(Snapshot.HEIGHT)))));
                } catch (Exception e2) {
                    if (!(e2 instanceof NoSuchKeyException) && !(e2 instanceof UnexpectedNativeTypeException)) {
                        throw e2;
                    }
                    ReactSoftExceptionLogger.logSoftException(REACT_CLASS, new ReactNoCrashSoftException("Unexpected payload for highlighting elements: every element should have x, y, width, height fields"));
                    Unit unit = Unit.f53572a;
                    z = false;
                }
            }
        }
        if (z) {
            view.setHighlightedElementsRectangles(arrayList);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b0, code lost:
    
        if (r3 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b2, code lost:
    
        r21.setTraceUpdates(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b5, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
    
        return;
     */
    @Override // com.facebook.react.viewmanagers.DebuggingOverlayManagerInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void highlightTraceUpdates(@org.jetbrains.annotations.NotNull com.facebook.react.views.debuggingoverlay.DebuggingOverlay r21, @org.jetbrains.annotations.Nullable com.facebook.react.bridge.ReadableArray r22) throws java.lang.Exception {
        /*
            r20 = this;
            r1 = r21
            r0 = r22
            java.lang.String r3 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            if (r0 == 0) goto Lb5
            r3 = 0
            com.facebook.react.bridge.ReadableArray r4 = r0.getArray(r3)
            if (r4 != 0) goto L14
            goto Lb5
        L14:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            int r6 = r4.size()
            r7 = r3
            r0 = 1
        L1f:
            if (r7 >= r6) goto Laf
            com.facebook.react.bridge.ReadableMap r8 = r4.getMap(r7)
            if (r8 != 0) goto L2b
            r16 = 1
            goto Laa
        L2b:
            java.lang.String r9 = "rectangle"
            com.facebook.react.bridge.ReadableMap r9 = r8.getMap(r9)
            java.lang.String r10 = "DebuggingOverlay"
            if (r9 != 0) goto L40
            com.facebook.react.bridge.ReactNoCrashSoftException r0 = new com.facebook.react.bridge.ReactNoCrashSoftException
            java.lang.String r2 = "Unexpected payload for highlighting trace updates: rectangle field is null"
            r0.<init>(r2)
            com.facebook.react.bridge.ReactSoftExceptionLogger.logSoftException(r10, r0)
            goto Lb0
        L40:
            java.lang.String r11 = "id"
            int r11 = r8.getInt(r11)
            java.lang.String r12 = "color"
            int r8 = r8.getInt(r12)
            java.lang.String r12 = "x"
            double r12 = r9.getDouble(r12)     // Catch: java.lang.Exception -> L90
            float r12 = (float) r12     // Catch: java.lang.Exception -> L90
            java.lang.String r13 = "y"
            double r13 = r9.getDouble(r13)     // Catch: java.lang.Exception -> L90
            float r13 = (float) r13
            double r14 = (double) r12
            r16 = 1
            java.lang.String r2 = "width"
            double r17 = r9.getDouble(r2)     // Catch: java.lang.Exception -> L8e
            double r14 = r14 + r17
            float r2 = (float) r14     // Catch: java.lang.Exception -> L8e
            double r14 = (double) r13     // Catch: java.lang.Exception -> L8e
            java.lang.String r3 = "height"
            double r18 = r9.getDouble(r3)     // Catch: java.lang.Exception -> L8e
            double r14 = r14 + r18
            float r3 = (float) r14     // Catch: java.lang.Exception -> L8e
            android.graphics.RectF r9 = new android.graphics.RectF     // Catch: java.lang.Exception -> L8e
            float r12 = com.facebook.react.uimanager.PixelUtil.b(r12)     // Catch: java.lang.Exception -> L8e
            float r13 = com.facebook.react.uimanager.PixelUtil.b(r13)     // Catch: java.lang.Exception -> L8e
            float r2 = com.facebook.react.uimanager.PixelUtil.b(r2)     // Catch: java.lang.Exception -> L8e
            float r3 = com.facebook.react.uimanager.PixelUtil.b(r3)     // Catch: java.lang.Exception -> L8e
            r9.<init>(r12, r13, r2, r3)     // Catch: java.lang.Exception -> L8e
            com.facebook.react.views.debuggingoverlay.TraceUpdate r2 = new com.facebook.react.views.debuggingoverlay.TraceUpdate     // Catch: java.lang.Exception -> L8e
            r2.<init>(r11, r9, r8)     // Catch: java.lang.Exception -> L8e
            r5.add(r2)     // Catch: java.lang.Exception -> L8e
            goto Laa
        L8e:
            r0 = move-exception
            goto L93
        L90:
            r0 = move-exception
            r16 = 1
        L93:
            boolean r2 = r0 instanceof com.facebook.react.bridge.NoSuchKeyException
            if (r2 != 0) goto L9d
            boolean r2 = r0 instanceof com.facebook.react.bridge.UnexpectedNativeTypeException
            if (r2 == 0) goto L9c
            goto L9d
        L9c:
            throw r0
        L9d:
            com.facebook.react.bridge.ReactNoCrashSoftException r0 = new com.facebook.react.bridge.ReactNoCrashSoftException
            java.lang.String r2 = "Unexpected payload for highlighting trace updates: rectangle field should have x, y, width, height fields"
            r0.<init>(r2)
            com.facebook.react.bridge.ReactSoftExceptionLogger.logSoftException(r10, r0)
            kotlin.Unit r0 = kotlin.Unit.f53572a
            r0 = 0
        Laa:
            int r7 = r7 + 1
            r3 = 0
            goto L1f
        Laf:
            r3 = r0
        Lb0:
            if (r3 == 0) goto Lb5
            r1.setTraceUpdates(r5)
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.debuggingoverlay.DebuggingOverlayManager.highlightTraceUpdates(com.facebook.react.views.debuggingoverlay.DebuggingOverlay, com.facebook.react.bridge.ReadableArray):void");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(@NotNull DebuggingOverlay view, @NotNull String commandId, @Nullable ReadableArray readableArray) throws Exception {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(commandId, "commandId");
        int iHashCode = commandId.hashCode();
        if (iHashCode != -1942063165) {
            if (iHashCode != 1326903961) {
                if (iHashCode == 1385348555 && commandId.equals("highlightElements")) {
                    highlightElements(view, readableArray);
                    return;
                }
            } else if (commandId.equals("highlightTraceUpdates")) {
                highlightTraceUpdates(view, readableArray);
                return;
            }
        } else if (commandId.equals("clearElementsHighlights")) {
            clearElementsHighlights(view);
            return;
        }
        ReactSoftExceptionLogger.logSoftException(REACT_CLASS, new ReactNoCrashSoftException("Received unexpected command in DebuggingOverlayManager"));
    }
}
