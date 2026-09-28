package in.juspay.hypersdk.core;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.PopupMenu;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyperlottie.LottieAnimation;
import in.juspay.hypersdk.mystique.AccordionLayout;
import in.juspay.hypersdk.mystique.AnimationHolder;
import in.juspay.hypersdk.mystique.BottomSheetLayout;
import in.juspay.hypersdk.mystique.SwypeLayout;
import in.juspay.hypersdk.mystique.SwypeScroll;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class InflateView {
    private static final String ARG_TYPE_SPLIT = "_";
    private static final Pattern COMMAND_SPLIT;
    private static final String FUNCTION_ARG_SPLIT = ",";
    private static final Pattern FUNCTION_ARG_SPLIT_ESCAPE;
    private static final String FUNCTION_ARG_START = ":";
    private static final String KEYWORD_SPLIT = "->";
    private static final String LOG_TAG = "in.juspay.hypersdk.core.InflateView";
    private static final Map<Class<?>, Class<?>> PRIMITIVE_TYPES;
    private static final String SETTER_EQUALS = "=";

    @NonNull
    private final AnimationHolder animationHolder;

    @NonNull
    private final DuiCallback duiCallback;

    @NonNull
    protected final DynamicUI dynamicUI;

    @Nullable
    private LottieAnimation lottieAnimation;

    @Nullable
    private PopupMenu popUpMenu;
    private float swipeEndX;
    private float swipeEndY;
    private float swipeStartX;
    private float swipeStartY;

    @NonNull
    private final HashMap<Cmd, Method> functionCache = new HashMap<>();

    @NonNull
    protected HashMap<String, Object> state = new HashMap<>();

    @Nullable
    private String currViewId = "-1";

    @Nullable
    private String lastCommand = "";

    @Nullable
    private String currView = "";

    @Nullable
    private String fileOrigin = "";
    private boolean useAppContext = false;

    /* renamed from: in.juspay.hypersdk.core.InflateView$2, reason: invalid class name */
    public class AnonymousClass2 implements TextureView.SurfaceTextureListener {
        private boolean isDrawn = false;
        final /* synthetic */ Context val$context;
        final /* synthetic */ MediaPlayer val$mMediaPlayer;
        final /* synthetic */ JSONObject val$properties;
        final /* synthetic */ Uri val$uri;

        public AnonymousClass2(MediaPlayer mediaPlayer, Context context, Uri uri, JSONObject jSONObject) {
            this.val$mMediaPlayer = mediaPlayer;
            this.val$context = context;
            this.val$uri = uri;
            this.val$properties = jSONObject;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surfaceTexture, int i2, int i3) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
            if (this.isDrawn) {
                return;
            }
            try {
                this.isDrawn = true;
                this.val$mMediaPlayer.reset();
                this.val$mMediaPlayer.setDataSource(this.val$context, this.val$uri);
                this.val$mMediaPlayer.setSurface(new Surface(surfaceTexture));
                this.val$mMediaPlayer.prepareAsync();
                if (this.val$properties.optBoolean("autoloop", false)) {
                    this.val$mMediaPlayer.setLooping(true);
                }
                final MediaPlayer mediaPlayer = this.val$mMediaPlayer;
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: in.juspay.hypersdk.core.d0
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public final void onPrepared(MediaPlayer mediaPlayer2) throws IllegalStateException {
                        mediaPlayer.start();
                    }
                });
            } catch (Exception e2) {
                InflateView.this.dynamicUI.getLogger().e("TextureView", "Exception in TextureView: " + e2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surfaceTexture) throws IllegalStateException {
            try {
                this.val$mMediaPlayer.stop();
                this.val$mMediaPlayer.release();
                return true;
            } catch (Exception unused) {
                return true;
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surfaceTexture, int i2, int i3) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surfaceTexture) {
        }
    }

    public static class Cmd {
        private final Class<?>[] args;
        private final Class<?> clazz;
        private final String functionName;

        public Cmd(Class<?> cls, String str, Class<?>[] clsArr) {
            this.clazz = cls;
            this.functionName = str;
            this.args = clsArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Cmd cmd = (Cmd) obj;
            if (this.clazz.equals(cmd.clazz) && this.functionName.equals(cmd.functionName)) {
                return Arrays.equals(this.args, cmd.args);
            }
            return false;
        }

        public int hashCode() {
            int iE = androidx.fragment.app.e.e(this.clazz.hashCode() * 31, 31, this.functionName);
            Class<?>[] clsArr = this.args;
            return iE + (clsArr != null ? Arrays.hashCode(clsArr) : 0);
        }
    }

    static {
        Hashtable hashtable = new Hashtable();
        PRIMITIVE_TYPES = hashtable;
        FUNCTION_ARG_SPLIT_ESCAPE = Pattern.compile("(?<!\\\\)" + Pattern.quote(FUNCTION_ARG_SPLIT));
        COMMAND_SPLIT = Pattern.compile("(?<!\\\\)" + Pattern.quote(";"));
        hashtable.put(Boolean.class, Boolean.TYPE);
        hashtable.put(Character.class, Character.TYPE);
        hashtable.put(Byte.class, Byte.TYPE);
        hashtable.put(Short.class, Short.TYPE);
        hashtable.put(Integer.class, Integer.TYPE);
        hashtable.put(Long.class, Long.TYPE);
        hashtable.put(Float.class, Float.TYPE);
        hashtable.put(Double.class, Double.TYPE);
        hashtable.put(Void.class, Void.TYPE);
    }

    public InflateView(@NonNull final DynamicUI dynamicUI) {
        this.lottieAnimation = null;
        this.dynamicUI = dynamicUI;
        DuiCallback duiCallback = new DuiCallback() { // from class: in.juspay.hypersdk.core.InflateView.1
            @Override // in.juspay.hyper.core.JsCallback
            public void addJsToWebView(@NonNull String str) {
                dynamicUI.addJsToWebView(str);
            }

            @Override // in.juspay.hypersdk.core.DuiCallback
            public InflateView getInflateView() {
                return dynamicUI.getInflateView();
            }

            @Override // in.juspay.hypersdk.core.DuiCallback
            public DuiLogger getLogger() {
                return dynamicUI.getLogger();
            }

            @Override // in.juspay.hypersdk.core.DuiCallback
            public void setInGlobalState(String str, Object obj) {
                dynamicUI.setGlobalState(str, obj);
            }
        };
        this.duiCallback = duiCallback;
        this.state.put("duiObj", dynamicUI);
        this.animationHolder = new AnimationHolder(duiCallback, dynamicUI.getAppContext().getResources().getDisplayMetrics().density);
        if (PaymentUtils.isClassAvailable("in.juspay.hyperlottie.LottieAnimation")) {
            this.lottieAnimation = new LottieAnimation(dynamicUI.getAppContext(), dynamicUI, dynamicUI.getBridgeComponents().getFileProviderInterface());
        }
    }

    private Object findAndSetField(Object obj, String str, String str2, boolean z) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field field;
        try {
            field = obj.getClass().getField(str);
        } catch (NoSuchFieldException unused) {
            Field field2 = null;
            for (Field field3 : obj.getClass().getFields()) {
                if (field3.getName().equals(str)) {
                    field2 = field3;
                }
            }
            field = field2;
        }
        if (field != null) {
            field.set(obj, getValue(str2, z));
        } else {
            this.dynamicUI.getLogger().d(LOG_TAG, "Couldn't set field for " + str);
        }
        return obj;
    }

    private Method findMethodInClass(Class<?> cls, String str) {
        String str2;
        String str3;
        if (cls == null) {
            return null;
        }
        if (indexOf(str, FUNCTION_ARG_START, 0) != -1) {
            String[] strArrSubstr = substr(str, FUNCTION_ARG_START);
            str2 = strArrSubstr[0];
            str3 = strArrSubstr[1];
        } else {
            str2 = str;
            str3 = null;
        }
        return findMethodWithCmd(new Cmd(cls, str2, str3 != null ? parseTypeArguments(str3) : null));
    }

    private ObjectAnimator getAnimator(Object obj, PropertyValuesHolder[] propertyValuesHolderArr, JSONObject jSONObject) {
        float f2 = jSONObject.has("duration") ? (float) jSONObject.getDouble("duration") : 0.0f;
        float f3 = jSONObject.has("delay") ? (float) jSONObject.getDouble("delay") : 0.0f;
        boolean z = false;
        int i2 = jSONObject.has("repeatCount") ? jSONObject.getInt("repeatCount") : 0;
        if (jSONObject.has("startImmediate") && jSONObject.getBoolean("startImmediate")) {
            z = true;
        }
        String string = jSONObject.has("easing") ? jSONObject.getString("easing") : "linear";
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(obj, propertyValuesHolderArr);
        objectAnimatorOfPropertyValuesHolder.setDuration((long) f2);
        objectAnimatorOfPropertyValuesHolder.setStartDelay((long) f3);
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(i2);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(getEasing(string));
        if (z) {
            objectAnimatorOfPropertyValuesHolder.start();
        }
        return objectAnimatorOfPropertyValuesHolder;
    }

    private int getArgsLength(String str) {
        return FUNCTION_ARG_SPLIT_ESCAPE.split(str).length;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private <Any> Any getClassType(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.InflateView.getClassType(java.lang.String):java.lang.Object");
    }

    private Context getContext() {
        return this.useAppContext ? this.dynamicUI.getAppContext() : this.dynamicUI.getActivity();
    }

    private TimeInterpolator getCustomEasing(String str, final float[] fArr) {
        str.getClass();
        return !str.equals("bezier") ? !str.equals("spring") ? new LinearInterpolator() : new TimeInterpolator() { // from class: in.juspay.hypersdk.core.t
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f2) {
                return InflateView.lambda$getCustomEasing$11(fArr, f2);
            }
        } : new PathInterpolator(fArr[0], fArr[1], fArr[2], fArr[3]);
    }

    private TimeInterpolator getEasing(String str) {
        int i2;
        str.getClass();
        switch (str) {
            case "ease-in":
                return new AccelerateInterpolator();
            case "bounce":
                return new BounceInterpolator();
            case "linear":
                return new LinearInterpolator();
            case "ease-out":
                return new DecelerateInterpolator();
            case "ease-in-out":
                return new AccelerateDecelerateInterpolator();
            default:
                try {
                    if (str.contains("[")) {
                        String strSubstring = str.substring(0, str.indexOf("["));
                        JSONArray jSONArray = new JSONArray(str.substring(str.indexOf("[")));
                        int length = jSONArray.length();
                        float[] fArr = new float[length];
                        for (i2 = 0; i2 < length; i2++) {
                            fArr[i2] = (float) jSONArray.getDouble(i2);
                        }
                        return getCustomEasing(strSubstring, fArr);
                    }
                } catch (JSONException unused) {
                }
                return new LinearInterpolator();
        }
    }

    private <Any> Any getValue(String str, boolean z) {
        if (str == null) {
            this.dynamicUI.getLogger().e("WARNING", " isNull : fn__getValue - value " + getErrorDetails());
            this.dynamicUI.getErrorCallback().onError("WARNING", " isNull : fn__getValue - value " + getErrorDetails());
            return null;
        }
        this.dynamicUI.getLogger().d("getValue!", str);
        String[] strArrSubstr = substr(str, "_");
        String str2 = strArrSubstr[0];
        String strReplace = strArrSubstr[1];
        if (strReplace.indexOf(92) != -1 && strReplace.contains(";")) {
            strReplace = strReplace.replace("\\\\;", ";");
        }
        if (strReplace.indexOf(92) != -1 && strReplace.contains("_")) {
            strReplace = strReplace.replace("\\\\_", "_");
        }
        if (strReplace.indexOf(92) != -1 && strReplace.contains(FUNCTION_ARG_START)) {
            strReplace = strReplace.replace("\\\\:", FUNCTION_ARG_START);
        }
        if (strReplace.indexOf(92) != -1 && strReplace.contains(FUNCTION_ARG_SPLIT)) {
            strReplace = strReplace.replace("\\\\,", FUNCTION_ARG_SPLIT);
        }
        if (strReplace.indexOf(92) != -1 && strReplace.contains(SETTER_EQUALS)) {
            strReplace = strReplace.replace("\\\\=", SETTER_EQUALS);
        }
        return (Any) getValueNew(str2, strReplace);
    }

    private int indexOf(String str, String str2, int i2) {
        int iIndexOf = str.substring(i2).indexOf(str2);
        if (iIndexOf != -1 && iIndexOf != 0 && iIndexOf < str.length()) {
            int i3 = iIndexOf + i2;
            if (str.charAt(i3 - 1) == '\\') {
                return indexOf(str, str2, str2.length() + i3);
            }
        }
        return iIndexOf == -1 ? iIndexOf : iIndexOf + i2;
    }

    public static boolean isWrappedPrimitiveType(Class<?> cls) {
        return PRIMITIVE_TYPES.containsKey(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dismissPopUp$12() {
        PopupMenu popupMenu = this.popUpMenu;
        if (popupMenu != null) {
            popupMenu.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float lambda$getCustomEasing$11(float[] fArr, float f2) {
        return ((float) (Math.sin((6.283185307179586d / fArr[0]) * (f2 - (r6 / 4.0f))) * Math.pow(2.0d, (-10.0f) * f2))) + 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CharSequence lambda$parseKeys$0(String str, CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        while (i2 < i3) {
            if (!Pattern.compile(str).matcher(String.valueOf(charSequence.charAt(i2))).matches()) {
                return "";
            }
            i2++;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CharSequence lambda$parseKeys$1(String str, CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        Matcher matcher = Pattern.compile(str).matcher(spanned.subSequence(0, i4).toString() + ((Object) charSequence.subSequence(i2, i3)) + ((Object) spanned.subSequence(i5, spanned.length())));
        if (matcher.matches() || matcher.hitEnd()) {
            return null;
        }
        return (!charSequence.equals("") || i4 == i5) ? "" : spanned.subSequence(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$parseKeys$2(String str, View view, int i2, KeyEvent keyEvent) {
        this.dynamicUI.addJsToWebView("window.callUICallback('" + str + "','" + i2 + "');");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$parseKeys$3(String str, View view) {
        this.dynamicUI.addJsToWebView(android.support.v4.media.b.D("window.callUICallback('", str, "');"));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$parseKeys$4(String str, View view) {
        this.dynamicUI.addJsToWebView(android.support.v4.media.b.D("window.callUICallback('", str, "');"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$parseKeys$5(String str) {
        this.dynamicUI.addJsToWebView(android.support.v4.media.b.D("window.callUICallback('", str, "');"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$parseKeys$6(String str, AdapterView adapterView, View view, int i2, long j2) {
        this.dynamicUI.addJsToWebView("window.callUICallback('" + str + "'," + i2 + ");");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$parseKeys$7(String str, View view, boolean z) {
        this.dynamicUI.addJsToWebView("window.callUICallback('" + str + "','" + z + "');");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$parseKeys$8(String str, CalendarView calendarView, int i2, int i3, int i4) {
        this.dynamicUI.addJsToWebView("window.callUICallback('" + str + "','" + i2 + "','" + i3 + "','" + i4 + "');");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$parseKeys$9(String str, MenuItem menuItem) {
        DynamicUI dynamicUI = this.dynamicUI;
        StringBuilder sbY = android.support.v4.media.b.y("window.callUICallback('", str, "', '");
        sbY.append(menuItem.getItemId());
        sbY.append("');");
        dynamicUI.addJsToWebView(sbY.toString());
        return true;
    }

    private void normalTextChange(JSONObject jSONObject, Object obj) throws JSONException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method = obj.getClass().getMethod("addTextChangedListener", TextWatcher.class);
        final String string = jSONObject.getString("onChange");
        method.invoke(obj, new TextWatcher() { // from class: in.juspay.hypersdk.core.InflateView.7
            private String previousText;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                this.previousText = charSequence.toString();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (this.previousText.equals(charSequence.toString())) {
                    return;
                }
                InflateView.this.dynamicUI.addJsToWebView("window.callUICallback('" + string + "', '" + ((Object) charSequence) + "');");
            }
        });
    }

    private Object[] parseArguments(String str, boolean z) {
        if (str == null || str.trim().equals("")) {
            return new Object[0];
        }
        ArrayList arrayList = new ArrayList();
        String[] strArrSplit = str.split("_");
        if (indexOf(str, FUNCTION_ARG_SPLIT, 0) == -1 || strArrSplit.length == 2) {
            arrayList.add(getValue(str, z));
        } else {
            for (String str2 : FUNCTION_ARG_SPLIT_ESCAPE.split(str)) {
                arrayList.add(getValue(str2, z));
            }
        }
        return arrayList.toArray();
    }

    private Class<?>[] parseTypeArguments(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("_");
        if (indexOf(str, FUNCTION_ARG_SPLIT, 0) != -1 && strArrSplit.length != 2) {
            String[] strArrSplit2 = FUNCTION_ARG_SPLIT_ESCAPE.split(str);
            if (strArrSplit2.length > 1) {
                Class<?>[] clsArr = new Class[strArrSplit2.length];
                for (int i2 = 0; i2 < strArrSplit2.length; i2++) {
                    clsArr[i2] = (Class) getClassType(strArrSplit2[i2]);
                }
                return clsArr;
            }
        }
        return new Class[]{(Class) getClassType(str)};
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:128:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object runCommand(java.lang.Object r19, java.lang.Object r20, java.lang.String r21, boolean r22) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 1416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.InflateView.runCommand(java.lang.Object, java.lang.Object, java.lang.String, boolean):java.lang.Object");
    }

    private void separatorTextChange(JSONObject jSONObject, Object obj) throws JSONException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        obj.getClass().getMethod("addTextChangedListener", TextWatcher.class).invoke(obj, new TextWatcher(jSONObject, jSONObject.getString("onChange"), (EditText) obj) { // from class: in.juspay.hypersdk.core.InflateView.8
            private static final int TOTAL_DIGITS = 21;
            private static final int TOTAL_SYMBOLS = 26;
            private final char DIVIDER;
            private final int DIVIDER_MODULO;
            private final int DIVIDER_POSITION;
            private boolean executeTextChange;
            private String previousText;
            final /* synthetic */ EditText val$cardField;
            final /* synthetic */ String val$js;
            final /* synthetic */ JSONObject val$properties;

            {
                this.val$properties = jSONObject;
                this.val$js = str;
                this.val$cardField = editText;
                int i2 = jSONObject.getInt("separatorRepeat");
                this.DIVIDER_POSITION = i2;
                this.DIVIDER_MODULO = i2 + 1;
                this.DIVIDER = jSONObject.getString("separator").charAt(0);
                this.executeTextChange = true;
            }

            private String buildCorrectString(char[] cArr, int i2) {
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < cArr.length; i3++) {
                    char c2 = cArr[i3];
                    if (c2 != 0) {
                        sb.append(c2);
                        if (i3 > 0 && i3 < i2 - 1 && (i3 + 1) % this.DIVIDER_POSITION == 0) {
                            sb.append(this.DIVIDER);
                        }
                    }
                }
                return sb.toString();
            }

            private char[] getDigitArray(Editable editable) {
                char[] cArr = new char[21];
                int i2 = 0;
                for (int i3 = 0; i3 < editable.length() && i2 < 21; i3++) {
                    char cCharAt = editable.charAt(i3);
                    if (Character.isDigit(cCharAt)) {
                        cArr[i2] = cCharAt;
                        i2++;
                    }
                }
                return cArr;
            }

            private boolean isInputCorrect(Editable editable) {
                boolean zIsDigit = editable.length() <= 26;
                int i2 = 0;
                while (i2 < editable.length()) {
                    zIsDigit &= (i2 <= 0 || (i2 + 1) % this.DIVIDER_MODULO != 0) ? Character.isDigit(editable.charAt(i2)) : this.DIVIDER == editable.charAt(i2);
                    i2++;
                }
                return zIsDigit;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() != 0 && this.val$cardField.isFocused() && !this.previousText.equals(editable.toString()) && this.executeTextChange) {
                    boolean z = this.previousText.length() > editable.length();
                    InputFilter[] filters = editable.getFilters();
                    editable.setFilters(new InputFilter[0]);
                    int selectionStart = this.val$cardField.getSelectionStart();
                    this.executeTextChange = false;
                    int i2 = selectionStart + 1;
                    if (i2 % this.DIVIDER_MODULO == 0 && z) {
                        editable.delete(selectionStart - 1, selectionStart);
                    }
                    if (!isInputCorrect(editable)) {
                        editable.replace(0, editable.length(), buildCorrectString(getDigitArray(editable), editable.length()));
                        if (editable.length() > 0 && this.DIVIDER == editable.charAt(editable.length() - 1) && z) {
                            editable.delete(editable.length() - 1, editable.length());
                        }
                    }
                    if (selectionStart != 0 && selectionStart % this.DIVIDER_MODULO == 0 && editable.length() > selectionStart && !z) {
                        this.val$cardField.setSelection(i2);
                    }
                    this.executeTextChange = true;
                    editable.setFilters(filters);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                this.previousText = charSequence.toString();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (this.previousText.equals(charSequence.toString()) || !this.executeTextChange) {
                    return;
                }
                InflateView.this.dynamicUI.addJsToWebView("window.callUICallback('" + this.val$js + "', '" + ((Object) charSequence) + "');");
            }
        });
    }

    private String[] substr(String str, String str2) {
        int iIndexOf = indexOf(str, str2, 0);
        return iIndexOf == -1 ? new String[]{str} : new String[]{str.substring(0, iIndexOf), str.substring(str2.length() + iIndexOf)};
    }

    private Method tryExactMatch(Class<?> cls, String str, Class<?>[] clsArr) {
        return cls.getMethod(str, clsArr);
    }

    private Method tryMultiAgrumentDeepMatch(Class<?> cls, String str, Class<?>[] clsArr) throws SecurityException {
        if ("undefined".equals(str)) {
            return null;
        }
        this.dynamicUI.getLogger().d(LOG_TAG, "tryMultiAgrumentDeepMatch reached. Beware slow function.. " + cls.toString() + " : " + str + " : " + clsArr.length);
        for (Method method : cls.getMethods()) {
            if (method.getName().equals(str) && method.getParameterTypes().length == clsArr.length && matchTypes(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    private Method trySingleArgumentDeepMatch(Class<?> cls, String str, Class<?> cls2) {
        if (isWrappedPrimitiveType(cls2)) {
            try {
                return cls.getMethod(str, PRIMITIVE_TYPES.get(cls2));
            } catch (NoSuchMethodException unused) {
            }
        }
        do {
            for (Class<?> cls3 : cls2.getInterfaces()) {
                try {
                    return cls.getMethod(str, cls3);
                } catch (NoSuchMethodException unused2) {
                }
            }
            try {
                return cls.getMethod(str, cls2);
            } catch (NoSuchMethodException unused3) {
                cls2 = cls2.getSuperclass();
            }
        } while (cls2 != null);
        this.dynamicUI.getLogger().e(LOG_TAG, "Never reach here");
        return null;
    }

    @NonNull
    @Keep
    public Boolean containsInState(String str) {
        return Boolean.valueOf(this.state.containsKey(str));
    }

    @Keep
    public void convertAndStoreArray(ArrayList<?> arrayList, Class<?> cls, String str, boolean z) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        int size = arrayList.size();
        if (z) {
            cls = PRIMITIVE_TYPES.get(cls);
        }
        if (cls != null) {
            Object objNewInstance = Array.newInstance(cls, size);
            for (int i2 = 0; i2 < size; i2++) {
                Array.set(objNewInstance, i2, arrayList.get(i2));
            }
            this.state.put(str, objNewInstance);
        }
    }

    @Nullable
    @Keep
    public Class<?> createPrimitiveClass(String str) {
        str.getClass();
        switch (str) {
            case "b":
                return Boolean.TYPE;
            case "c":
                return Character.TYPE;
            case "d":
                return Double.TYPE;
            case "f":
                return Float.TYPE;
            case "i":
                return Integer.TYPE;
            case "l":
                return Long.TYPE;
            case "s":
                return Short.TYPE;
            case "v":
                return Void.TYPE;
            case "by":
                return Byte.TYPE;
            default:
                return null;
        }
    }

    public void dismissPopUp() {
        ExecutorManager.runOnMainThread(new v(this, 0));
    }

    public int dpToPx(int i2) {
        if (i2 > 0) {
            return Math.round(i2 * this.dynamicUI.getAppContext().getResources().getDisplayMetrics().density);
        }
        return 0;
    }

    public Pair<String, ObjectAnimator> findAnimationById(String str) {
        String strC = android.support.v4.media.b.C("M_anim_", str);
        if (this.state.containsKey(strC)) {
            return (Pair) this.state.get(strC);
        }
        return null;
    }

    public Method findMethodWithCmd(Cmd cmd) {
        Method methodTryMultiAgrumentDeepMatch;
        if (this.functionCache.containsKey(cmd)) {
            return this.functionCache.get(cmd);
        }
        try {
            methodTryMultiAgrumentDeepMatch = tryExactMatch(cmd.clazz, cmd.functionName, cmd.args);
        } catch (NoSuchMethodException unused) {
            methodTryMultiAgrumentDeepMatch = (cmd.args == null || cmd.args.length != 1) ? tryMultiAgrumentDeepMatch(cmd.clazz, cmd.functionName, cmd.args) : trySingleArgumentDeepMatch(cmd.clazz, cmd.functionName, cmd.args[0]);
        }
        this.functionCache.put(cmd, methodTryMultiAgrumentDeepMatch);
        return methodTryMultiAgrumentDeepMatch;
    }

    public Class<?> getClassName(String str) {
        str.getClass();
        switch (str) {
            case "in.juspay.mystique.BottomSheetLayout":
                return BottomSheetLayout.class;
            case "in.juspay.mystique.SwypeLayout":
                return SwypeLayout.class;
            case "in.juspay.mystique.SwypeScroll":
                return SwypeScroll.class;
            case "in.juspay.mystique.AccordionLayout":
                return AccordionLayout.class;
            default:
                return Class.forName(str);
        }
    }

    public DynamicUI getDUI() {
        return this.dynamicUI;
    }

    public String getErrorDetails() {
        return this.currViewId + " - " + this.currView + "-" + this.fileOrigin + " - " + this.lastCommand;
    }

    @NonNull
    public HashMap<String, Object> getState() {
        return this.state;
    }

    public <T> T getStateValFromKey(String str) {
        return (T) this.state.get(str);
    }

    public boolean getUseAppContext() {
        return this.useAppContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <Any> Any getValueNew(String str, String str2) {
        str.getClass();
        switch (str) {
            case "strget":
                return (Any) (this.state.get(str2) + "");
            case "b":
                return (Any) Boolean.valueOf(Boolean.parseBoolean(str2));
            case "f":
                return (Any) Float.valueOf(Float.parseFloat(str2));
            case "i":
                return (Any) Integer.valueOf(Integer.parseInt(str2));
            case "l":
                return (Any) Long.valueOf(Long.parseLong(str2));
            case "dp":
                return (Any) Integer.valueOf(dpToPx(Integer.parseInt(str2)));
            case "sp":
                return (Any) Float.valueOf(Float.parseFloat(str2) * this.dynamicUI.getAppContext().getResources().getDisplayMetrics().scaledDensity);
            case "apm":
                return (Any) this.dynamicUI.getApplicationManager();
            case "ctx":
                return (this.dynamicUI.getActivity() == null || this.useAppContext) ? (Any) this.dynamicUI.getAppContext() : (Any) this.dynamicUI.getActivity();
            case "dpf":
                return (Any) Float.valueOf(dpToPx(Float.parseFloat(str2)));
            case "get":
                return (Any) this.state.get(str2);
            case "infl":
                return this;
            case "null":
                return null;
            default:
                return str2;
        }
    }

    public void handleAnimation(Object obj, JSONArray jSONArray) {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            JSONArray jSONArray2 = new JSONArray(jSONObject.getString("props"));
            String string = jSONObject.has(CLConstants.SHARED_PREFERENCE_ITEM_ID) ? jSONObject.getString(CLConstants.SHARED_PREFERENCE_ITEM_ID) : "";
            String string2 = jSONObject.has("onEnd") ? jSONObject.getString("onEnd") : "";
            PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[jSONArray2.length()];
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                propertyValuesHolderArr[i3] = PropertyValuesHolder.ofFloat(jSONObject2.getString("prop"), (float) jSONObject2.getDouble("from"), (float) jSONObject2.getDouble("to"));
            }
            final ObjectAnimator animator = getAnimator(obj, propertyValuesHolderArr, jSONObject);
            Pair pair = new Pair(Integer.valueOf(((View) obj).getId()), animator);
            this.state.put("M_anim_" + string, pair);
            if (jSONObject.has("onEnd")) {
                final String strC = android.support.v4.media.b.C("M_anim_", string2);
                animator.addListener(new Animator.AnimatorListener() { // from class: in.juspay.hypersdk.core.InflateView.6
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(@NonNull Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(@NonNull Animator animator2) {
                        ObjectAnimator objectAnimator;
                        if (!InflateView.this.state.containsKey(strC) || (objectAnimator = (ObjectAnimator) ((Pair) InflateView.this.state.get(strC)).second) == null || objectAnimator == animator) {
                            return;
                        }
                        objectAnimator.start();
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(@NonNull Animator animator2) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(@NonNull Animator animator2) {
                    }
                });
            }
        }
    }

    public boolean matchTypes(Class<?>[] clsArr, Class<?>[] clsArr2) {
        Class<?> cls;
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if (clsArr2[i2] != null && (cls = clsArr[i2]) != null && ((!cls.equals(Object.class) || clsArr2[i2].isPrimitive()) && !clsArr[i2].equals(clsArr2[i2]))) {
                if (clsArr[i2].isPrimitive() && !clsArr2[i2].isArray()) {
                    try {
                        Class cls2 = (Class) clsArr2[i2].getField("TYPE").get(null);
                        if (cls2 != null && !cls2.equals(clsArr[i2])) {
                            return false;
                        }
                    } catch (NoSuchFieldException unused) {
                        return false;
                    } catch (Exception unused2) {
                        return true;
                    }
                } else if (clsArr[i2].equals(ClassLoader.class)) {
                    if (clsArr2[i2].getName().equals("dalvik.system.PathClassLoader")) {
                        return true;
                    }
                } else if (!clsArr[i2].equals(clsArr2[i2]) && !clsArr[i2].isAssignableFrom(clsArr2[i2])) {
                    return false;
                }
            }
        }
        return true;
    }

    public Object parseAndRunPipe(Object obj, String str, boolean z) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Object objRunCommand = null;
        for (String str2 : COMMAND_SPLIT.split(str)) {
            if (!str2.equals("")) {
                if (indexOf(str2, SETTER_EQUALS, 0) != -1) {
                    String[] strArrSubstr = substr(str2, SETTER_EQUALS);
                    String str3 = substr(strArrSubstr[0], "_")[1];
                    Object objRunCommand2 = runCommand(obj, objRunCommand, strArrSubstr[1], z);
                    this.state.put(str3, objRunCommand2);
                    this.dynamicUI.getLogger().d(LOG_TAG, "setting " + str3 + " to " + objRunCommand2);
                } else {
                    objRunCommand = runCommand(obj, objRunCommand, str2, z);
                }
            }
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0628  */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void parseKeys(java.lang.String r40, org.json.JSONObject r41, java.lang.Object r42, boolean r43) {
        /*
            Method dump skipped, instructions count: 1638
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.InflateView.parseKeys(java.lang.String, org.json.JSONObject, java.lang.Object, boolean):void");
    }

    public void putInState(String str, Object obj) {
        this.state.put(str, obj);
    }

    public void resetState() {
        this.state = new HashMap<>();
    }

    public void setCurrView(@Nullable String str) {
        this.currView = str;
    }

    public void setCurrViewId(@Nullable String str) {
        this.currViewId = str;
    }

    public void setFileOrigin(@Nullable String str) {
        this.fileOrigin = str;
    }

    public void setUseAppContext(boolean z) {
        this.useAppContext = z;
    }

    public float dpToPx(float f2) {
        if (f2 > 0.0f) {
            return Math.round(f2 * this.dynamicUI.getAppContext().getResources().getDisplayMetrics().density);
        }
        return 0.0f;
    }
}
