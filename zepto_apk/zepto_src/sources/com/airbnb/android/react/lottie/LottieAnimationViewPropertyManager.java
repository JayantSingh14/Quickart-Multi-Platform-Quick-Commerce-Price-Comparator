package com.airbnb.android.react.lottie;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import coil3.util.UtilsKt;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.RenderMode;
import com.airbnb.lottie.SimpleColorFilter;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.assets.ReactFontManager;
import com.facebook.react.util.RNLog;
import com.facebook.react.views.text.ReactFontManager;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class LottieAnimationViewPropertyManager {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f14079a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f14080b;

    /* renamed from: c, reason: collision with root package name */
    public String f14081c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView.ScaleType f14082d;

    /* renamed from: e, reason: collision with root package name */
    public String f14083e;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f14084f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f14085g;

    /* renamed from: h, reason: collision with root package name */
    public ReadableArray f14086h;

    /* renamed from: i, reason: collision with root package name */
    public ReadableArray f14087i;

    /* renamed from: j, reason: collision with root package name */
    public RenderMode f14088j;

    /* renamed from: k, reason: collision with root package name */
    public Integer f14089k;

    /* renamed from: l, reason: collision with root package name */
    public String f14090l;

    /* renamed from: m, reason: collision with root package name */
    public String f14091m;
    public String n;
    public Float o;
    public Boolean p;
    public Boolean q;
    public Float r;

    public LottieAnimationViewPropertyManager(final LottieAnimationView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f14079a = new WeakReference(view);
        view.setFontAssetDelegate(new FontAssetDelegate() { // from class: com.airbnb.android.react.lottie.LottieAnimationViewPropertyManager.1
            @Override // com.airbnb.lottie.FontAssetDelegate
            public final Typeface a(String fontFamilyName) {
                Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamily");
                ReactFontManager reactFontManagerA = ReactFontManager.Companion.a();
                AssetManager assetManager = view.getContext().getAssets();
                Intrinsics.checkNotNullExpressionValue(assetManager, "getAssets(...)");
                Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
                Intrinsics.checkNotNullParameter(assetManager, "assetManager");
                com.facebook.react.common.assets.ReactFontManager reactFontManager = reactFontManagerA.f20096a;
                reactFontManager.getClass();
                Intrinsics.checkNotNullParameter(fontFamilyName, "fontFamilyName");
                return reactFontManager.a(fontFamilyName, new ReactFontManager.TypefaceStyle(-1, -1), assetManager);
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
            @Override // com.airbnb.lottie.FontAssetDelegate
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final android.graphics.Typeface b(java.lang.String r5, java.lang.String r6, java.lang.String r7) {
                /*
                    r4 = this;
                    java.lang.String r0 = "fontFamily"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                    java.lang.String r5 = "fontStyle"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r5)
                    java.lang.String r5 = "fontName"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r5)
                    int r5 = r6.hashCode()
                    r0 = -1
                    switch(r5) {
                        case -1994163307: goto L5c;
                        case -1955878649: goto L50;
                        case -1543850116: goto L47;
                        case 2076325: goto L3b;
                        case 2605753: goto L30;
                        case 64266207: goto L24;
                        case 73417974: goto L18;
                        default: goto L17;
                    }
                L17:
                    goto L64
                L18:
                    java.lang.String r5 = "Light"
                    boolean r5 = r6.equals(r5)
                    if (r5 != 0) goto L21
                    goto L64
                L21:
                    r5 = 200(0xc8, float:2.8E-43)
                    goto L68
                L24:
                    java.lang.String r5 = "Black"
                    boolean r5 = r6.equals(r5)
                    if (r5 != 0) goto L2d
                    goto L64
                L2d:
                    r5 = 900(0x384, float:1.261E-42)
                    goto L68
                L30:
                    java.lang.String r5 = "Thin"
                    boolean r5 = r6.equals(r5)
                    if (r5 == 0) goto L64
                    r5 = 100
                    goto L68
                L3b:
                    java.lang.String r5 = "Bold"
                    boolean r5 = r6.equals(r5)
                    if (r5 != 0) goto L44
                    goto L64
                L44:
                    r5 = 700(0x2bc, float:9.81E-43)
                    goto L68
                L47:
                    java.lang.String r5 = "Regular"
                    boolean r5 = r6.equals(r5)
                    if (r5 != 0) goto L59
                    goto L64
                L50:
                    java.lang.String r5 = "Normal"
                    boolean r5 = r6.equals(r5)
                    if (r5 != 0) goto L59
                    goto L64
                L59:
                    r5 = 400(0x190, float:5.6E-43)
                    goto L68
                L5c:
                    java.lang.String r5 = "Medium"
                    boolean r5 = r6.equals(r5)
                    if (r5 != 0) goto L66
                L64:
                    r5 = r0
                    goto L68
                L66:
                    r5 = 500(0x1f4, float:7.0E-43)
                L68:
                    com.facebook.react.views.text.ReactFontManager r6 = com.facebook.react.views.text.ReactFontManager.Companion.a()
                    com.airbnb.lottie.LottieAnimationView r1 = r1
                    android.content.Context r1 = r1.getContext()
                    android.content.res.AssetManager r1 = r1.getAssets()
                    java.lang.String r2 = "getAssets(...)"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                    java.lang.String r2 = "fontFamilyName"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
                    java.lang.String r3 = "assetManager"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
                    com.facebook.react.common.assets.ReactFontManager r6 = r6.f20096a
                    r6.getClass()
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
                    com.facebook.react.common.assets.ReactFontManager$TypefaceStyle r2 = new com.facebook.react.common.assets.ReactFontManager$TypefaceStyle
                    r2.<init>(r0, r5)
                    android.graphics.Typeface r5 = r6.a(r7, r2, r1)
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.airbnb.android.react.lottie.LottieAnimationViewPropertyManager.AnonymousClass1.b(java.lang.String, java.lang.String, java.lang.String):android.graphics.Typeface");
            }
        });
    }

    public final void a() {
        int iIntValue;
        Collection collectionZ;
        Object objA;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f14079a.get();
        if (lottieAnimationView == null) {
            return;
        }
        ReadableArray readableArray = this.f14087i;
        if (readableArray != null && readableArray.size() > 0) {
            TextDelegate textDelegate = new TextDelegate(lottieAnimationView);
            int size = readableArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                ReadableMap map = readableArray.getMap(i2);
                if (map != null) {
                    textDelegate.a(map.getString("find"), map.getString("replace"));
                }
            }
            lottieAnimationView.setTextDelegate(textDelegate);
        }
        String str = this.f14090l;
        if (str != null) {
            lottieAnimationView.h(new ByteArrayInputStream(str.getBytes()), String.valueOf(str.hashCode()));
            this.f14090l = null;
        }
        String str2 = this.f14091m;
        if (str2 != null) {
            File file = new File(str2);
            if (file.exists()) {
                lottieAnimationView.h(new FileInputStream(file), String.valueOf(str2.hashCode()));
            } else {
                lottieAnimationView.j(str2, String.valueOf(str2.hashCode()));
            }
            this.f14091m = null;
        }
        String str3 = this.n;
        if (str3 != null) {
            File file2 = new File(str3);
            if (file2.exists()) {
                lottieAnimationView.i(new ZipInputStream(new FileInputStream(file2)), String.valueOf(str3.hashCode()));
                this.n = null;
                return;
            }
            try {
                Result.Companion companion = Result.f53538b;
                objA = Uri.parse(str3).getScheme();
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f53538b;
                objA = ResultKt.a(th);
            }
            if (objA instanceof Result.Failure) {
                objA = null;
            }
            String str4 = (String) objA;
            if (str4 != null) {
                if (str4.equals(UtilsKt.SCHEME_FILE)) {
                    String path = Uri.parse(str3).getPath();
                    if (path != null) {
                        lottieAnimationView.i(new ZipInputStream(new FileInputStream(new File(path))), String.valueOf(str3.hashCode()));
                    } else {
                        Log.w("lottie-react-native", "URI path is null for asset: ".concat(str3));
                    }
                } else {
                    lottieAnimationView.setAnimationFromUrl(str3);
                }
                this.n = null;
                return;
            }
            int identifier = lottieAnimationView.getResources().getIdentifier(str3, "raw", lottieAnimationView.getContext().getPackageName());
            if (identifier == 0) {
                RNLog.a("Animation for " + str3 + " was not found in raw resources");
                return;
            }
            lottieAnimationView.setAnimation(identifier);
            this.f14080b = false;
            this.n = null;
        }
        if (this.f14080b) {
            lottieAnimationView.setAnimation(this.f14081c);
            this.f14080b = false;
        }
        Float f2 = this.o;
        if (f2 != null) {
            lottieAnimationView.setProgress(f2.floatValue());
            this.o = null;
        }
        Boolean bool = this.p;
        if (bool != null) {
            lottieAnimationView.setRepeatCount(bool.booleanValue() ? -1 : 0);
            this.p = null;
        }
        Boolean bool2 = this.q;
        LottieDrawable lottieDrawable = lottieAnimationView.f14113h;
        if (bool2 != null && bool2.booleanValue() && !lottieDrawable.C()) {
            lottieAnimationView.f();
        }
        Float f3 = this.r;
        if (f3 != null) {
            lottieAnimationView.setSpeed(f3.floatValue());
            this.r = null;
        }
        ImageView.ScaleType scaleType = this.f14082d;
        if (scaleType != null) {
            lottieAnimationView.setScaleType(scaleType);
            this.f14082d = null;
        }
        RenderMode renderMode = this.f14088j;
        if (renderMode != null) {
            lottieAnimationView.setRenderMode(renderMode);
            this.f14088j = null;
        }
        Integer num = this.f14089k;
        if (num != null) {
            lottieAnimationView.setLayerType(num.intValue(), null);
        }
        String str5 = this.f14083e;
        if (str5 != null) {
            lottieAnimationView.setImageAssetsFolder(str5);
            this.f14083e = null;
        }
        Boolean bool3 = this.f14084f;
        if (bool3 != null) {
            lottieDrawable.j(bool3.booleanValue());
            this.f14084f = null;
        }
        Boolean bool4 = this.f14085g;
        if (bool4 != null) {
            lottieAnimationView.setSafeMode(bool4.booleanValue());
            this.f14085g = null;
        }
        ReadableArray readableArray2 = this.f14086h;
        if (readableArray2 == null || readableArray2.size() <= 0) {
            return;
        }
        int size2 = readableArray2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            ReadableMap map2 = readableArray2.getMap(i3);
            if (map2 != null) {
                if (map2.getType("color") == ReadableType.Map) {
                    Integer color = ColorPropConverter.getColor(map2.getMap("color"), lottieAnimationView.getContext());
                    Intrinsics.c(color);
                    iIntValue = color.intValue();
                } else {
                    iIntValue = map2.getInt("color");
                }
                String strK = android.support.v4.media.b.k(map2.getString("keypath"), ".**");
                String strQuote = Pattern.quote(CLConstants.DOT_SALT_DELIMETER);
                Intrinsics.checkNotNullExpressionValue(strQuote, "quote(...)");
                List listE = new Regex(strQuote).e(strK);
                if (listE.isEmpty()) {
                    collectionZ = EmptyList.f53609a;
                    String[] strArr = (String[]) collectionZ.toArray(new String[0]);
                    lottieDrawable.b(new KeyPath((String[]) Arrays.copyOf(strArr, strArr.length)), LottieProperty.F, new LottieValueCallback(new SimpleColorFilter(iIntValue)));
                } else {
                    ListIterator listIterator = listE.listIterator(listE.size());
                    while (listIterator.hasPrevious()) {
                        if (((String) listIterator.previous()).length() != 0) {
                            collectionZ = CollectionsKt.Z(listE, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                    collectionZ = EmptyList.f53609a;
                    String[] strArr2 = (String[]) collectionZ.toArray(new String[0]);
                    lottieDrawable.b(new KeyPath((String[]) Arrays.copyOf(strArr2, strArr2.length)), LottieProperty.F, new LottieValueCallback(new SimpleColorFilter(iIntValue)));
                }
            }
        }
    }
}
