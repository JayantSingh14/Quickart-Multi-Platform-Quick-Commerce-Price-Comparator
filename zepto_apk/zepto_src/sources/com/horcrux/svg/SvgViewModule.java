package com.horcrux.svg;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import javax.annotation.Nonnull;

@ReactModule(name = "RNSVGSvgViewModule")
/* loaded from: classes.dex */
class SvgViewModule extends NativeSvgViewModuleSpec {
    public static final String NAME = "RNSVGSvgViewModule";

    /* renamed from: com.horcrux.svg.SvgViewModule$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f45860a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ReadableMap f45861b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Callback f45862c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f45863d;

        public AnonymousClass1(int i2, ReadableMap readableMap, Callback callback, int i3) {
            this.f45860a = i2;
            this.f45861b = readableMap;
            this.f45862c = callback;
            this.f45863d = i3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i2 = this.f45860a;
            SvgView svgViewByTag = SvgViewManager.getSvgViewByTag(i2);
            if (svgViewByTag == null) {
                SvgViewManager.runWhenViewIsAvailable(i2, new Runnable() { // from class: com.horcrux.svg.SvgViewModule.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        SvgView svgViewByTag2 = SvgViewManager.getSvgViewByTag(AnonymousClass1.this.f45860a);
                        if (svgViewByTag2 == null) {
                            return;
                        }
                        svgViewByTag2.setToDataUrlTask(new Runnable() { // from class: com.horcrux.svg.SvgViewModule.1.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                SvgViewModule.toDataURL(anonymousClass1.f45860a, anonymousClass1.f45861b, anonymousClass1.f45862c, anonymousClass1.f45863d + 1);
                            }
                        });
                    }
                });
                return;
            }
            if (svgViewByTag.notRendered()) {
                svgViewByTag.setToDataUrlTask(new Runnable() { // from class: com.horcrux.svg.SvgViewModule.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        SvgViewModule.toDataURL(anonymousClass1.f45860a, anonymousClass1.f45861b, anonymousClass1.f45862c, anonymousClass1.f45863d + 1);
                    }
                });
                return;
            }
            Callback callback = this.f45862c;
            ReadableMap readableMap = this.f45861b;
            if (readableMap != null) {
                callback.invoke(svgViewByTag.toDataURL(readableMap.getInt(Snapshot.WIDTH), readableMap.getInt(Snapshot.HEIGHT)));
            } else {
                callback.invoke(svgViewByTag.toDataURL());
            }
        }
    }

    public SvgViewModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void toDataURL(int i2, ReadableMap readableMap, Callback callback, int i3) {
        UiThreadUtil.runOnUiThread(new AnonymousClass1(i2, readableMap, callback, i3));
    }

    @Override // com.horcrux.svg.NativeSvgViewModuleSpec, com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RNSVGSvgViewModule";
    }

    @Override // com.horcrux.svg.NativeSvgViewModuleSpec
    @ReactMethod
    public void toDataURL(Double d2, ReadableMap readableMap, Callback callback) {
        toDataURL(d2.intValue(), readableMap, callback, 0);
    }
}
