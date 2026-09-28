package in.juspay.hyperlottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import com.airbnb.lottie.b;
import in.juspay.hyper.core.FileProviderInterface;
import in.juspay.hyper.core.JsCallback;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xbill.DNS.KEYRecord;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class LottieAnimation {

    @NotNull
    private static final String ALPHA = "lottieAlpha";

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String LOTTIE_RES_ID = "lottieResourceId";

    @NotNull
    private static final String LOTTIE_URL = "lottieUrl";

    @NotNull
    private static final String MAX_FRAME = "maxFrame";

    @NotNull
    private static final String MAX_PROGRESS = "maxProgress";

    @NotNull
    private static final String MIN_FRAME = "minFrame";

    @NotNull
    private static final String MIN_PROGRESS = "minProgress";

    @NotNull
    private static final String REPEAT_COUNT = "repeatCount";

    @NotNull
    private static final String REPEAT_MODE = "repeatMode";

    @NotNull
    private static final String SAFE_MODE = "safeMode";

    @NotNull
    private static final String SPEED = "speed";

    @NotNull
    private static final String START_LOTTIE = "startLottie";

    @NotNull
    private final Context context;

    @NotNull
    private final JsCallback dynamicUI;

    @NotNull
    private final FileProviderInterface fileProviderInterface;

    @NotNull
    private final WeakHashMap<String, String> jsonStringCache;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public LottieAnimation(@NotNull Context context, @NotNull JsCallback dynamicUI, @NotNull FileProviderInterface fileProviderInterface) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dynamicUI, "dynamicUI");
        Intrinsics.checkNotNullParameter(fileProviderInterface, "fileProviderInterface");
        this.context = context;
        this.dynamicUI = dynamicUI;
        this.fileProviderInterface = fileProviderInterface;
        this.jsonStringCache = new WeakHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyAnimation$lambda$2(LottieAnimation this$0, Object obj, Ref.ObjectRef lottieDrawable, boolean z, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lottieDrawable, "$lottieDrawable");
        this$0.applyLottieComposition(lottieComposition, (View) obj, (LottieDrawable) lottieDrawable.f53801a, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyAnimation$lambda$4(LottieAnimation this$0, Object obj, Ref.ObjectRef lottieDrawable, boolean z, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lottieDrawable, "$lottieDrawable");
        this$0.applyLottieComposition(lottieComposition, (View) obj, (LottieDrawable) lottieDrawable.f53801a, z);
    }

    private final void applyLottieComposition(LottieComposition lottieComposition, View view, LottieDrawable lottieDrawable, boolean z) {
        lottieDrawable.O(lottieComposition);
        view.setBackground(lottieDrawable);
        if (z) {
            lottieDrawable.start();
        } else {
            lottieDrawable.stop();
        }
    }

    public final void applyAnimation(@Nullable Object obj, @NotNull JSONArray animations) throws JSONException, Resources.NotFoundException, IOException {
        String str;
        String str2;
        final boolean z;
        int iOptInt;
        int iOptInt2;
        int iOptInt3;
        String strB;
        Intrinsics.checkNotNullParameter(animations, "animations");
        try {
            if (obj instanceof View) {
                if (animations.length() == 0) {
                    if (((View) obj).getBackground() instanceof LottieDrawable) {
                        ((View) obj).setBackground(null);
                        return;
                    }
                    return;
                }
                if (animations.length() > 1) {
                    this.dynamicUI.addJsToWebView("console.log(\"LottieAnimations Array is > 1\");");
                }
                JSONObject jSONObject = animations.getJSONObject(animations.length() - 1);
                if (jSONObject == null) {
                    return;
                }
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.f53801a = new LottieDrawable();
                final boolean zOptBoolean = jSONObject.optBoolean(START_LOTTIE, true);
                if (jSONObject.has(LOTTIE_RES_ID)) {
                    String id = jSONObject.getString(LOTTIE_RES_ID);
                    if (id != null && id.length() != 0) {
                        Intrinsics.checkNotNullExpressionValue(id, "id");
                        String id2 = StringsKt.c0(id, '\"');
                        Intrinsics.checkNotNullExpressionValue(id2, "id");
                        Integer intOrNull = StringsKt.toIntOrNull(id2);
                        if (intOrNull != null) {
                            strB = this.jsonStringCache.get(id2);
                            if (strB == null) {
                                InputStream inputStreamOpenRawResource = this.context.getResources().openRawResource(intOrNull.intValue());
                                Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "context.resources\n      …  .openRawResource(resId)");
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenRawResource, Charsets.UTF_8), KEYRecord.Flags.FLAG2);
                                try {
                                    strB = TextStreamsKt.b(bufferedReader);
                                    bufferedReader.close();
                                    if (strB.length() > 0) {
                                        this.jsonStringCache.put(id2, strB);
                                    }
                                } finally {
                                }
                            }
                        } else {
                            strB = "";
                        }
                        if (strB.length() == 0) {
                            return;
                        }
                        LottieTask lottieTaskA = LottieCompositionFactory.a(id2, new b(strB, id2), null);
                        final View view = (View) obj;
                        final int i2 = 0;
                        str = SAFE_MODE;
                        str2 = REPEAT_MODE;
                        lottieTaskA.b(new LottieListener(this) { // from class: in.juspay.hyperlottie.a

                            /* renamed from: b, reason: collision with root package name */
                            public final /* synthetic */ LottieAnimation f48476b;

                            {
                                this.f48476b = this;
                            }

                            @Override // com.airbnb.lottie.LottieListener
                            public final void onResult(Object obj2) {
                                LottieComposition lottieComposition = (LottieComposition) obj2;
                                switch (i2) {
                                    case 0:
                                        LottieAnimation.applyAnimation$lambda$2(this.f48476b, view, objectRef, zOptBoolean, lottieComposition);
                                        break;
                                    default:
                                        LottieAnimation.applyAnimation$lambda$4(this.f48476b, view, objectRef, zOptBoolean, lottieComposition);
                                        break;
                                }
                            }
                        });
                        z = zOptBoolean;
                    }
                    return;
                }
                str = SAFE_MODE;
                str2 = REPEAT_MODE;
                if (jSONObject.has(LOTTIE_URL)) {
                    String url = jSONObject.getString(LOTTIE_URL);
                    if (url != null && url.length() != 0) {
                        String fromFile = this.jsonStringCache.get(url);
                        if (fromFile == null) {
                            FileProviderInterface fileProviderInterface = this.fileProviderInterface;
                            Context context = this.context;
                            Intrinsics.checkNotNullExpressionValue(url, "url");
                            fromFile = fileProviderInterface.readFromFile(context, url);
                            if (fromFile.length() > 0) {
                                this.jsonStringCache.put(url, fromFile);
                            }
                        }
                        if (fromFile.length() == 0) {
                            return;
                        }
                        LottieTask lottieTaskA2 = LottieCompositionFactory.a(url, new b(fromFile, url), null);
                        z = zOptBoolean;
                        final View view2 = (View) obj;
                        final int i3 = 1;
                        lottieTaskA2.b(new LottieListener(this) { // from class: in.juspay.hyperlottie.a

                            /* renamed from: b, reason: collision with root package name */
                            public final /* synthetic */ LottieAnimation f48476b;

                            {
                                this.f48476b = this;
                            }

                            @Override // com.airbnb.lottie.LottieListener
                            public final void onResult(Object obj2) {
                                LottieComposition lottieComposition = (LottieComposition) obj2;
                                switch (i3) {
                                    case 0:
                                        LottieAnimation.applyAnimation$lambda$2(this.f48476b, view2, objectRef, z, lottieComposition);
                                        break;
                                    default:
                                        LottieAnimation.applyAnimation$lambda$4(this.f48476b, view2, objectRef, z, lottieComposition);
                                        break;
                                }
                            }
                        });
                    }
                    return;
                }
                z = zOptBoolean;
                if (!(((View) obj).getBackground() instanceof LottieDrawable)) {
                    return;
                }
                Drawable background = ((View) obj).getBackground();
                Intrinsics.d(background, "null cannot be cast to non-null type com.airbnb.lottie.LottieDrawable");
                objectRef.f53801a = (LottieDrawable) background;
                if (jSONObject.has(str2)) {
                    ((LottieDrawable) objectRef.f53801a).l0("reverse".equals(jSONObject.optString(str2, "")) ? 2 : 1);
                }
                if (jSONObject.has(REPEAT_COUNT)) {
                    int iOptInt4 = jSONObject.optInt(REPEAT_COUNT, 0);
                    if (iOptInt4 < 0) {
                        ((LottieDrawable) objectRef.f53801a).k0(-1);
                    } else {
                        ((LottieDrawable) objectRef.f53801a).k0(iOptInt4);
                    }
                }
                if (jSONObject.has(SPEED)) {
                    ((LottieDrawable) objectRef.f53801a).f14153b.f14798d = (float) jSONObject.optDouble(SPEED, 1.0d);
                }
                if (jSONObject.has(MIN_FRAME) && (iOptInt3 = jSONObject.optInt(MIN_FRAME, 0)) >= 0) {
                    ((LottieDrawable) objectRef.f53801a).d0(iOptInt3);
                }
                if (jSONObject.has(MAX_FRAME) && (iOptInt2 = jSONObject.optInt(MAX_FRAME, 0)) >= 0) {
                    ((LottieDrawable) objectRef.f53801a).X(iOptInt2);
                }
                if (jSONObject.has(MIN_PROGRESS)) {
                    float fOptDouble = (float) jSONObject.optDouble(MIN_PROGRESS, 0.0d);
                    if (0.0f <= fOptDouble && fOptDouble <= 1.0f) {
                        ((LottieDrawable) objectRef.f53801a).f0(fOptDouble);
                    }
                }
                if (jSONObject.has(MAX_PROGRESS)) {
                    float fOptDouble2 = (float) jSONObject.optDouble(MAX_PROGRESS, 0.0d);
                    if (0.0f <= fOptDouble2 && fOptDouble2 <= 1.0f) {
                        ((LottieDrawable) objectRef.f53801a).Z(fOptDouble2);
                    }
                }
                String str3 = str;
                if (jSONObject.has(str3)) {
                    ((LottieDrawable) objectRef.f53801a).f14156e = jSONObject.optBoolean(str3, false);
                }
                if (jSONObject.has(ALPHA) && (iOptInt = jSONObject.optInt(ALPHA, 255)) >= 0 && iOptInt < 256) {
                    ((LottieDrawable) objectRef.f53801a).setAlpha(iOptInt);
                }
                if (z) {
                    ((LottieDrawable) objectRef.f53801a).start();
                } else {
                    ((LottieDrawable) objectRef.f53801a).stop();
                }
            }
        } catch (Exception unused) {
        }
    }
}
