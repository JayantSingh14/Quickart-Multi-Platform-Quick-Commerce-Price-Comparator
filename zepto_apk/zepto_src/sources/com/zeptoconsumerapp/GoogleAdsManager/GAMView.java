package com.zeptoconsumerapp.GoogleAdsManager;

import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.fragment.app.e;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.swmansion.gesturehandler.react.b;
import com.zeptoconsumerapp.GoogleAdsManager.constants.GAMConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class GAMView extends FrameLayout {
    public static final /* synthetic */ int r = 0;

    /* renamed from: a, reason: collision with root package name */
    public final ReactContext f47483a;

    /* renamed from: b, reason: collision with root package name */
    public final EventDispatcher f47484b;

    /* renamed from: c, reason: collision with root package name */
    public AdManagerAdView f47485c;

    /* renamed from: d, reason: collision with root package name */
    public AdManagerAdRequest.Builder f47486d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f47487e;

    /* renamed from: f, reason: collision with root package name */
    public String f47488f;

    /* renamed from: g, reason: collision with root package name */
    public String f47489g;

    /* renamed from: h, reason: collision with root package name */
    public String f47490h;

    /* renamed from: i, reason: collision with root package name */
    public final LinkedHashMap f47491i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f47492j;

    /* renamed from: k, reason: collision with root package name */
    public long f47493k;

    /* renamed from: l, reason: collision with root package name */
    public long f47494l;

    /* renamed from: m, reason: collision with root package name */
    public long f47495m;
    public String n;
    public int o;
    public ResponseInfo p;
    public final b q;

    @Metadata
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f47496a;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.String.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Array.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f47496a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GAMView(ThemedReactContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f47483a = context;
        UIManagerModule uIManagerModule = (UIManagerModule) context.getNativeModule(UIManagerModule.class);
        this.f47484b = uIManagerModule != null ? uIManagerModule.getEventDispatcher() : null;
        this.f47486d = new AdManagerAdRequest.Builder();
        this.f47487e = e.i("query_info_type", "requester_type_8");
        this.f47488f = "";
        this.f47489g = "";
        this.f47490h = "";
        this.f47491i = new LinkedHashMap();
        this.f47492j = new ArrayList();
        this.n = "";
        this.q = new b(this, 5);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.Map a(com.zeptoconsumerapp.GoogleAdsManager.GAMView r23, com.google.android.gms.ads.AdSize r24, java.lang.String r25, java.lang.Integer r26) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.GoogleAdsManager.GAMView.a(com.zeptoconsumerapp.GoogleAdsManager.GAMView, com.google.android.gms.ads.AdSize, java.lang.String, java.lang.Integer):java.util.Map");
    }

    private final AdSize getAdSize() {
        AdSize adSizeA;
        float width = getWidth() / getResources().getDisplayMetrics().density;
        if (width < 300.0f) {
            width = 300.0f;
        }
        String upperCase = this.f47490h.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        if (Intrinsics.b(upperCase, GAMConfig.f47509i.a())) {
            adSizeA = AdSize.f20998h;
        } else if (Intrinsics.b(upperCase, GAMConfig.f47510j.a())) {
            adSizeA = AdSize.f21002l;
        } else if (Intrinsics.b(upperCase, GAMConfig.f47511k.a())) {
            adSizeA = AdSize.f21000j;
        } else {
            adSizeA = AdSize.a((int) width, this.f47483a);
        }
        Intrinsics.c(adSizeA);
        return adSizeA;
    }

    public final void b() {
        this.f47486d = (AdManagerAdRequest.Builder) new AdManagerAdRequest.Builder().c(this.f47487e);
        for (Map.Entry entry : this.f47491i.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                this.f47486d.a(str, (String) value);
            } else if (value instanceof List) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : (Iterable) value) {
                    if (obj instanceof String) {
                        arrayList.add(obj);
                    }
                }
                this.f47486d.b(str, arrayList);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.ads.admanager.AdManagerAdView c() {
        /*
            r4 = this;
            com.google.android.gms.ads.AdSize r0 = r4.getAdSize()
            com.google.android.gms.ads.admanager.AdManagerAdView r1 = new com.google.android.gms.ads.admanager.AdManagerAdView
            com.facebook.react.bridge.ReactContext r2 = r4.f47483a
            r1.<init>(r2)
            java.lang.String r2 = r4.f47488f
            r1.setAdUnitId(r2)
            java.lang.String r2 = r4.f47490h
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r2 = r2.toUpperCase(r3)
            java.lang.String r3 = "toUpperCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            com.zeptoconsumerapp.GoogleAdsManager.constants.GAMConfig r3 = com.zeptoconsumerapp.GoogleAdsManager.constants.GAMConfig.f47512l
            java.lang.String r3 = r3.a()
            boolean r2 = kotlin.jvm.internal.Intrinsics.b(r2, r3)
            if (r2 == 0) goto L45
            java.util.ArrayList r2 = r4.f47492j
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L45
            r0 = 0
            com.google.android.gms.ads.AdSize[] r0 = new com.google.android.gms.ads.AdSize[r0]
            java.lang.Object[] r0 = r2.toArray(r0)
            com.google.android.gms.ads.AdSize[] r0 = (com.google.android.gms.ads.AdSize[]) r0
            int r2 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r2)
            com.google.android.gms.ads.AdSize[] r0 = (com.google.android.gms.ads.AdSize[]) r0
            r1.setAdSizes(r0)
            goto L48
        L45:
            r1.setAdSize(r0)
        L48:
            com.zeptoconsumerapp.GoogleAdsManager.GAMView$createAdView$ad$1$1 r0 = new com.zeptoconsumerapp.GoogleAdsManager.GAMView$createAdView$ad$1$1
            r0.<init>()
            r1.setAdListener(r0)
            androidx.media3.exoplayer.analytics.l r0 = new androidx.media3.exoplayer.analytics.l
            r2 = 22
            r0.<init>(r4, r2)
            r1.setOnPaidEventListener(r0)
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r2 = -1
            r0.<init>(r2, r2)
            r4.addView(r1, r0)
            r4.f47485c = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.GoogleAdsManager.GAMView.c():com.google.android.gms.ads.admanager.AdManagerAdView");
    }

    public final void d(final String str, Map map) {
        EventDispatcher eventDispatcher = this.f47484b;
        if (eventDispatcher == null) {
            return;
        }
        final WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(GAMConfig.f47508h.a(), this.f47489g);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    writableMapCreateMap.putString(str2, (String) value);
                } else if (value instanceof Integer) {
                    writableMapCreateMap.putInt(str2, ((Number) value).intValue());
                } else if (value instanceof Long) {
                    writableMapCreateMap.putDouble(str2, ((Number) value).longValue());
                } else if (value instanceof Double) {
                    writableMapCreateMap.putDouble(str2, ((Number) value).doubleValue());
                } else if (value instanceof Boolean) {
                    writableMapCreateMap.putBoolean(str2, ((Boolean) value).booleanValue());
                } else {
                    writableMapCreateMap.putString(str2, value != null ? value.toString() : null);
                }
            }
        }
        final int id = getId();
        eventDispatcher.g(new Event<Event<?>>(id) { // from class: com.zeptoconsumerapp.GoogleAdsManager.GAMView$dispatch$1
            @Override // com.facebook.react.uimanager.events.Event
            public final void dispatch(RCTEventEmitter rctEventEmitter) {
                Intrinsics.checkNotNullParameter(rctEventEmitter, "rctEventEmitter");
                rctEventEmitter.receiveEvent(getViewTag(), str, writableMapCreateMap);
            }

            @Override // com.facebook.react.uimanager.events.Event
            public final String getEventName() {
                return str;
            }
        });
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 <= 0 || i3 <= 0 || this.f47485c != null || StringsKt.z(this.f47488f)) {
            return;
        }
        try {
            b();
            removeAllViews();
            AdManagerAdView adManagerAdView = this.f47485c;
            if (adManagerAdView != null) {
                adManagerAdView.a();
            }
            AdManagerAdView adManagerAdViewC = c();
            AdManagerAdRequest adManagerAdRequestH = !StringsKt.z(this.f47489g) ? ((AdManagerAdRequest.Builder) this.f47486d.e(this.f47489g)).h() : this.f47486d.h();
            Intrinsics.checkNotNullExpressionValue(adManagerAdRequestH, "build(...)");
            this.f47493k = System.currentTimeMillis();
            adManagerAdViewC.e(adManagerAdRequestH);
        } catch (Throwable th) {
            d(GAMConfig.f47507g.a(), MapsKt.g(new Pair(APayConstants.Error.MESSAGE, th.getMessage())));
            Unit unit = Unit.f53572a;
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        post(this.q);
    }

    public final void setAdConfig(@Nullable ReadableMap readableMap) {
        if (readableMap == null) {
            return;
        }
        try {
            String string = readableMap.getString(GAMConfig.f47506f.a());
            String str = "";
            if (string == null) {
                string = "";
            }
            this.f47488f = string;
            String string2 = readableMap.getString(GAMConfig.f47508h.a());
            if (string2 == null) {
                string2 = "";
            }
            this.f47489g = string2;
            String string3 = readableMap.getString(GAMConfig.f47503c.a());
            if (string3 == null) {
                string3 = "";
            }
            this.f47490h = string3;
            String string4 = readableMap.getString(GAMConfig.f47504d.a());
            if (string4 != null) {
                str = string4;
            }
            if (str.length() > 0) {
                this.f47487e.putString("correlator", str);
            }
            ReadableArray array = readableMap.getArray(GAMConfig.f47502b.a());
            if (array != null) {
                ArrayList arrayList = this.f47492j;
                arrayList.clear();
                int size = array.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ReadableArray array2 = array.getArray(i2);
                    if (array2 != null && array2.size() >= 2 && !array2.isNull(0) && !array2.isNull(1)) {
                        int i3 = array2.getInt(0);
                        int i4 = array2.getInt(1);
                        if (i3 > 0 && i4 > 0) {
                            arrayList.add(new AdSize(i3, i4));
                        }
                    }
                }
            }
            ReadableMap map = readableMap.getMap(GAMConfig.f47505e.a());
            if (map != null) {
                setCustomTargeting(map);
            }
        } catch (Throwable th) {
            d(GAMConfig.f47507g.a(), MapsKt.g(new Pair(APayConstants.Error.MESSAGE, th.getMessage())));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7, types: [kotlin.collections.EmptyList] */
    public final void setCustomTargeting(@Nullable ReadableMap readableMap) {
        ?? arrayList;
        ArrayList<Object> arrayList2;
        LinkedHashMap linkedHashMap = this.f47491i;
        linkedHashMap.clear();
        if (readableMap == null) {
            return;
        }
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            int i2 = WhenMappings.f47496a[readableMap.getType(strNextKey).ordinal()];
            if (i2 == 1) {
                String string = readableMap.getString(strNextKey);
                if (string == null) {
                    string = "";
                }
                linkedHashMap.put(strNextKey, string);
            } else if (i2 == 2) {
                ReadableArray array = readableMap.getArray(strNextKey);
                if (array == null || (arrayList2 = array.toArrayList()) == null) {
                    arrayList = 0;
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : arrayList2) {
                        if (obj instanceof String) {
                            arrayList3.add(obj);
                        }
                    }
                    arrayList = new ArrayList();
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (((String) next).length() > 0) {
                            arrayList.add(next);
                        }
                    }
                }
                if (arrayList == 0) {
                    arrayList = EmptyList.f53609a;
                }
                linkedHashMap.put(strNextKey, arrayList);
            }
        }
    }
}
