package com.facebook.react.views.textinput;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.method.QwertyKeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import com.facebook.react.views.text.DefaultStyleValuesUtil;
import com.facebook.react.views.text.ReactBaseTextShadowNode;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.ReactTextViewManagerCallback;
import com.facebook.react.views.text.ReactTypefaceUtils;
import com.facebook.react.views.text.TextAttributeProps;
import com.facebook.react.views.text.TextLayoutManager;
import com.facebook.react.views.text.TextTransform;
import com.facebook.react.views.text.internal.span.TextInlineImageSpan;
import com.google.android.gms.common.Scopes;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import com.zeptoconsumerapp.BuildConfig;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.KEYRecord;

@ReactModule(name = ReactTextInputManager.REACT_CLASS)
/* loaded from: classes.dex */
public class ReactTextInputManager extends BaseViewManager<ReactEditText, LayoutShadowNode> {
    private static final int AUTOCAPITALIZE_FLAGS = 28672;
    private static final int BLUR_TEXT_INPUT = 2;
    private static final String[] DRAWABLE_HANDLE_FIELDS;
    private static final String[] DRAWABLE_HANDLE_RESOURCES;
    private static final InputFilter[] EMPTY_FILTERS;
    private static final int FOCUS_TEXT_INPUT = 1;
    private static final int IME_ACTION_ID = 1648;
    private static final int INPUT_TYPE_KEYBOARD_DECIMAL_PAD = 8194;
    private static final int INPUT_TYPE_KEYBOARD_NUMBERED = 12290;
    private static final int INPUT_TYPE_KEYBOARD_NUMBER_PAD = 2;
    private static final String KEYBOARD_TYPE_DECIMAL_PAD = "decimal-pad";
    private static final String KEYBOARD_TYPE_EMAIL_ADDRESS = "email-address";
    private static final String KEYBOARD_TYPE_NUMBER_PAD = "number-pad";
    private static final String KEYBOARD_TYPE_NUMERIC = "numeric";
    private static final String KEYBOARD_TYPE_PHONE_PAD = "phone-pad";
    private static final String KEYBOARD_TYPE_URI = "url";
    private static final String KEYBOARD_TYPE_VISIBLE_PASSWORD = "visible-password";
    private static final int PASSWORD_VISIBILITY_FLAG = 16;
    public static final String REACT_CLASS = "AndroidTextInput";
    private static final Map<String, String> REACT_PROPS_AUTOFILL_HINTS_MAP;
    private static final int SET_MOST_RECENT_EVENT_COUNT = 3;
    private static final int SET_TEXT_AND_SELECTION = 4;
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};
    public static final String TAG = "ReactTextInputManager";
    private static final short TX_STATE_KEY_ATTRIBUTED_STRING = 0;
    private static final short TX_STATE_KEY_HASH = 2;
    private static final short TX_STATE_KEY_MOST_RECENT_EVENT_COUNT = 3;
    private static final short TX_STATE_KEY_PARAGRAPH_ATTRIBUTES = 1;
    private static final int UNSET = -1;

    @Nullable
    protected ReactTextViewManagerCallback mReactTextViewManagerCallback;

    /* renamed from: com.facebook.react.views.textinput.ReactTextInputManager$1, reason: invalid class name */
    public class AnonymousClass1 extends HashMap<String, String> {
    }

    /* loaded from: classes3.dex */
    public static class ReactContentSizeWatcher implements ContentSizeWatcher {

        /* renamed from: a, reason: collision with root package name */
        public final ReactEditText f20206a;

        /* renamed from: b, reason: collision with root package name */
        public final EventDispatcher f20207b;

        /* renamed from: c, reason: collision with root package name */
        public final int f20208c;

        /* renamed from: d, reason: collision with root package name */
        public int f20209d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f20210e = 0;

        public ReactContentSizeWatcher(ReactEditText reactEditText) {
            this.f20206a = reactEditText;
            ReactContext reactContextC = UIManagerHelper.c(reactEditText);
            this.f20207b = ReactTextInputManager.getEventDispatcher(reactContextC, reactEditText);
            this.f20208c = UIManagerHelper.d(reactContextC);
        }

        @Override // com.facebook.react.views.textinput.ContentSizeWatcher
        public final void a() {
            EventDispatcher eventDispatcher = this.f20207b;
            if (eventDispatcher == null) {
                return;
            }
            ReactEditText reactEditText = this.f20206a;
            int width = reactEditText.getWidth();
            int height = reactEditText.getHeight();
            if (reactEditText.getLayout() != null) {
                width = reactEditText.getCompoundPaddingRight() + reactEditText.getLayout().getWidth() + reactEditText.getCompoundPaddingLeft();
                height = reactEditText.getCompoundPaddingBottom() + reactEditText.getLayout().getHeight() + reactEditText.getCompoundPaddingTop();
            }
            if (width == this.f20209d && height == this.f20210e) {
                return;
            }
            this.f20210e = height;
            this.f20209d = width;
            int id = reactEditText.getId();
            float fA = PixelUtil.a(width);
            float fA2 = PixelUtil.a(height);
            ReactContentSizeChangedEvent reactContentSizeChangedEvent = new ReactContentSizeChangedEvent(this.f20208c, id);
            reactContentSizeChangedEvent.f20179a = fA;
            reactContentSizeChangedEvent.f20180b = fA2;
            eventDispatcher.g(reactContentSizeChangedEvent);
        }
    }

    public static class ReactScrollWatcher implements ScrollWatcher {

        /* renamed from: a, reason: collision with root package name */
        public final ReactEditText f20211a;

        /* renamed from: b, reason: collision with root package name */
        public final EventDispatcher f20212b;

        /* renamed from: c, reason: collision with root package name */
        public final int f20213c;

        /* renamed from: d, reason: collision with root package name */
        public int f20214d;

        /* renamed from: e, reason: collision with root package name */
        public int f20215e;

        public ReactScrollWatcher(ReactEditText reactEditText) {
            this.f20211a = reactEditText;
            ReactContext reactContextC = UIManagerHelper.c(reactEditText);
            this.f20212b = ReactTextInputManager.getEventDispatcher(reactContextC, reactEditText);
            this.f20213c = UIManagerHelper.d(reactContextC);
        }

        @Override // com.facebook.react.views.textinput.ScrollWatcher
        public final void a(int i2, int i3) {
            if (this.f20214d == i2 && this.f20215e == i3) {
                return;
            }
            ReactEditText reactEditText = this.f20211a;
            int width = reactEditText.getWidth();
            int height = reactEditText.getHeight();
            Pools.SynchronizedPool synchronizedPool = ScrollEvent.f20072k;
            this.f20212b.g(ScrollEvent.Companion.a(this.f20213c, reactEditText.getId(), ScrollEventType.f20086d, i2, i3, 0.0f, 0.0f, 0, 0, width, height));
            this.f20214d = i2;
            this.f20215e = i3;
        }
    }

    public static class ReactSelectionWatcher implements SelectionWatcher {

        /* renamed from: a, reason: collision with root package name */
        public final ReactEditText f20216a;

        /* renamed from: b, reason: collision with root package name */
        public final EventDispatcher f20217b;

        /* renamed from: c, reason: collision with root package name */
        public final int f20218c;

        /* renamed from: d, reason: collision with root package name */
        public int f20219d;

        /* renamed from: e, reason: collision with root package name */
        public int f20220e;

        public ReactSelectionWatcher(ReactEditText reactEditText) {
            this.f20216a = reactEditText;
            ReactContext reactContextC = UIManagerHelper.c(reactEditText);
            this.f20217b = ReactTextInputManager.getEventDispatcher(reactContextC, reactEditText);
            this.f20218c = UIManagerHelper.d(reactContextC);
        }

        @Override // com.facebook.react.views.textinput.SelectionWatcher
        public final void a(int i2, int i3) {
            int iMin = Math.min(i2, i3);
            int iMax = Math.max(i2, i3);
            if (this.f20219d == iMin && this.f20220e == iMax) {
                return;
            }
            this.f20217b.g(new ReactTextInputSelectionEvent(this.f20218c, this.f20216a.getId(), iMin, iMax));
            this.f20219d = iMin;
            this.f20220e = iMax;
        }
    }

    public final class ReactTextInputTextWatcher implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        public final ReactEditText f20221a;

        /* renamed from: b, reason: collision with root package name */
        public final EventDispatcher f20222b;

        /* renamed from: c, reason: collision with root package name */
        public final int f20223c;

        /* renamed from: d, reason: collision with root package name */
        public String f20224d = null;

        public ReactTextInputTextWatcher(ThemedReactContext themedReactContext, ReactEditText reactEditText) {
            this.f20222b = ReactTextInputManager.getEventDispatcher(themedReactContext, reactEditText);
            this.f20221a = reactEditText;
            this.f20223c = UIManagerHelper.d(themedReactContext);
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            this.f20224d = charSequence.toString();
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            ReactEditText reactEditText = this.f20221a;
            if (reactEditText.L) {
                return;
            }
            if (i4 == 0 && i3 == 0) {
                return;
            }
            Assertions.c(this.f20224d);
            String strSubstring = charSequence.toString().substring(i2, i2 + i4);
            String strSubstring2 = this.f20224d.substring(i2, i2 + i3);
            if (i4 == i3 && strSubstring.equals(strSubstring2)) {
                return;
            }
            StateWrapper stateWrapper = reactEditText.getStateWrapper();
            if (stateWrapper != null) {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                int i5 = reactEditText.f20186l + 1;
                reactEditText.f20186l = i5;
                writableNativeMap.putInt("mostRecentEventCount", i5);
                writableNativeMap.putInt("opaqueCacheId", reactEditText.getId());
                stateWrapper.updateState(writableNativeMap);
            }
            int id = reactEditText.getId();
            String string = charSequence.toString();
            int i6 = reactEditText.f20186l + 1;
            reactEditText.f20186l = i6;
            this.f20222b.g(new ReactTextChangedEvent(this.f20223c, id, i6, string));
        }
    }

    static {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        anonymousClass1.put("birthdate-day", "birthDateDay");
        anonymousClass1.put("birthdate-full", "birthDateFull");
        anonymousClass1.put("birthdate-month", "birthDateMonth");
        anonymousClass1.put("birthdate-year", "birthDateYear");
        anonymousClass1.put("cc-csc", "creditCardSecurityCode");
        anonymousClass1.put("cc-exp", "creditCardExpirationDate");
        anonymousClass1.put("cc-exp-day", "creditCardExpirationDay");
        anonymousClass1.put("cc-exp-month", "creditCardExpirationMonth");
        anonymousClass1.put("cc-exp-year", "creditCardExpirationYear");
        anonymousClass1.put("cc-number", "creditCardNumber");
        anonymousClass1.put(Scopes.EMAIL, "emailAddress");
        anonymousClass1.put("gender", "gender");
        anonymousClass1.put(CLConstants.FIELD_PAY_INFO_NAME, "personName");
        anonymousClass1.put("name-family", "personFamilyName");
        anonymousClass1.put("name-given", "personGivenName");
        anonymousClass1.put("name-middle", "personMiddleName");
        anonymousClass1.put("name-middle-initial", "personMiddleInitial");
        anonymousClass1.put("name-prefix", "personNamePrefix");
        anonymousClass1.put("name-suffix", "personNameSuffix");
        anonymousClass1.put("password", "password");
        anonymousClass1.put("password-new", "newPassword");
        anonymousClass1.put("postal-address", "postalAddress");
        anonymousClass1.put("postal-address-country", "addressCountry");
        anonymousClass1.put("postal-address-extended", "extendedAddress");
        anonymousClass1.put("postal-address-extended-postal-code", "extendedPostalCode");
        anonymousClass1.put("postal-address-locality", "addressLocality");
        anonymousClass1.put("postal-address-region", "addressRegion");
        anonymousClass1.put("postal-code", "postalCode");
        anonymousClass1.put("street-address", "streetAddress");
        anonymousClass1.put("sms-otp", "smsOTPCode");
        anonymousClass1.put("tel", "phoneNumber");
        anonymousClass1.put("tel-country-code", "phoneCountryCode");
        anonymousClass1.put("tel-national", "phoneNational");
        anonymousClass1.put("tel-device", "phoneNumberDevice");
        anonymousClass1.put("username", "username");
        anonymousClass1.put("username-new", "newUsername");
        REACT_PROPS_AUTOFILL_HINTS_MAP = anonymousClass1;
        EMPTY_FILTERS = new InputFilter[0];
        DRAWABLE_HANDLE_RESOURCES = new String[]{"mTextSelectHandleLeftRes", "mTextSelectHandleRightRes", "mTextSelectHandleRes"};
        DRAWABLE_HANDLE_FIELDS = new String[]{"mSelectHandleLeft", "mSelectHandleRight", "mSelectHandleCenter"};
    }

    private static void checkPasswordType(ReactEditText reactEditText) {
        if ((reactEditText.getStagedInputType() & INPUT_TYPE_KEYBOARD_NUMBERED) == 0 || (reactEditText.getStagedInputType() & 128) == 0) {
            return;
        }
        updateStagedInputTypeFlag(reactEditText, 128, 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static EventDispatcher getEventDispatcher(ReactContext reactContext, ReactEditText reactEditText) {
        return UIManagerHelper.b(reactContext, reactEditText.getId());
    }

    private ReactTextUpdate getReactTextUpdate(String str, int i2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) TextTransform.a(str, TextTransform.f20142f));
        return new ReactTextUpdate(spannableStringBuilder, i2, false, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$addEventEmitters$0(ThemedReactContext themedReactContext, ReactEditText reactEditText, View view, boolean z) {
        int i2 = themedReactContext.f19481c;
        EventDispatcher eventDispatcher = getEventDispatcher(themedReactContext, reactEditText);
        if (z) {
            eventDispatcher.g(new ReactTextInputFocusEvent(i2, reactEditText.getId()));
        } else {
            eventDispatcher.g(new ReactTextInputBlurEvent(i2, reactEditText.getId()));
            eventDispatcher.g(new ReactTextInputEndEditingEvent(i2, reactEditText.getId(), reactEditText.getText().toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean lambda$addEventEmitters$1(ReactEditText reactEditText, ThemedReactContext themedReactContext, TextView textView, int i2, KeyEvent keyEvent) {
        if ((i2 & 255) != 0 || i2 == 0) {
            boolean zE = reactEditText.e();
            boolean zJ = reactEditText.j();
            String submitBehavior = reactEditText.getSubmitBehavior();
            boolean zEquals = submitBehavior == null ? !reactEditText.e() : submitBehavior.equals("blurAndSubmit");
            if (zJ) {
                getEventDispatcher(themedReactContext, reactEditText).g(new ReactTextInputSubmitEditingEvent(themedReactContext.f19481c, reactEditText.getId(), reactEditText.getText().toString()));
            }
            if (zEquals) {
                reactEditText.clearFocus();
            }
            if (!zEquals && !zJ && zE && i2 != 5 && i2 != 7) {
                return false;
            }
        }
        return true;
    }

    private void setAutofillHints(ReactEditText reactEditText, String... strArr) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        reactEditText.setAutofillHints(strArr);
    }

    private static boolean shouldHideCursorForEmailTextInput() {
        return Build.VERSION.SDK_INT == 29 && Build.MANUFACTURER.toLowerCase(Locale.ROOT).contains("xiaomi");
    }

    private static void updateStagedInputTypeFlag(ReactEditText reactEditText, int i2, int i3) {
        reactEditText.setStagedInputType(((~i2) & reactEditText.getStagedInputType()) | i3);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.d("focusTextInput", 1, "blurTextInput", 2);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        Map<String, Object> exportedCustomBubblingEventTypeConstants = super.getExportedCustomBubblingEventTypeConstants();
        if (exportedCustomBubblingEventTypeConstants == null) {
            exportedCustomBubblingEventTypeConstants = new HashMap<>();
        }
        MapBuilder.Builder builderA = MapBuilder.a();
        builderA.b("topSubmitEditing", MapBuilder.c("phasedRegistrationNames", MapBuilder.d("bubbled", "onSubmitEditing", "captured", "onSubmitEditingCapture")));
        builderA.b("topEndEditing", MapBuilder.c("phasedRegistrationNames", MapBuilder.d("bubbled", "onEndEditing", "captured", "onEndEditingCapture")));
        builderA.b("topFocus", MapBuilder.c("phasedRegistrationNames", MapBuilder.d("bubbled", "onFocus", "captured", "onFocusCapture")));
        builderA.b("topBlur", MapBuilder.c("phasedRegistrationNames", MapBuilder.d("bubbled", "onBlur", "captured", "onBlurCapture")));
        builderA.b("topKeyPress", MapBuilder.c("phasedRegistrationNames", MapBuilder.d("bubbled", "onKeyPress", "captured", "onKeyPressCapture")));
        exportedCustomBubblingEventTypeConstants.putAll(builderA.a());
        return exportedCustomBubblingEventTypeConstants;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        MapBuilder.Builder builderA = MapBuilder.a();
        ScrollEventType scrollEventType = ScrollEventType.f20086d;
        ScrollEventType.f20083a.getClass();
        builderA.b(ScrollEventType.Companion.a(scrollEventType), MapBuilder.c("registrationName", "onScroll"));
        exportedCustomDirectEventTypeConstants.putAll(builderA.a());
        return exportedCustomDirectEventTypeConstants;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedViewConstants() {
        return MapBuilder.c("AutoCapitalizationType", MapBuilder.b("none", 0, "characters", 4096, "words", Integer.valueOf(KEYRecord.Flags.FLAG2), "sentences", 16384));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return ReactTextInputShadowNode.class;
    }

    @ReactProp(defaultBoolean = BuildConfig.IS_HERMES_ENABLED, name = "allowFontScaling")
    public void setAllowFontScaling(ReactEditText reactEditText, boolean z) {
        reactEditText.setAllowFontScaling(z);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "autoCapitalize")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setAutoCapitalize(com.facebook.react.views.textinput.ReactEditText r5, com.facebook.react.bridge.Dynamic r6) {
        /*
            r4 = this;
            r0 = 0
            com.facebook.react.bridge.ReadableType r1 = r6.getType()
            com.facebook.react.bridge.ReadableType r2 = com.facebook.react.bridge.ReadableType.Number
            if (r1 != r2) goto Le
            int r0 = r6.asInt()
            goto L5e
        Le:
            com.facebook.react.bridge.ReadableType r1 = r6.getType()
            com.facebook.react.bridge.ReadableType r2 = com.facebook.react.bridge.ReadableType.String
            r3 = 16384(0x4000, float:2.2959E-41)
            if (r1 != r2) goto L5a
            java.lang.String r6 = r6.asString()
            r6.getClass()
            r1 = -1
            int r2 = r6.hashCode()
            switch(r2) {
                case 3387192: goto L49;
                case 113318569: goto L3e;
                case 490141296: goto L33;
                case 1245424234: goto L28;
                default: goto L27;
            }
        L27:
            goto L53
        L28:
            java.lang.String r2 = "characters"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L31
            goto L53
        L31:
            r1 = 3
            goto L53
        L33:
            java.lang.String r2 = "sentences"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L3c
            goto L53
        L3c:
            r1 = 2
            goto L53
        L3e:
            java.lang.String r2 = "words"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L47
            goto L53
        L47:
            r1 = 1
            goto L53
        L49:
            java.lang.String r2 = "none"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L52
            goto L53
        L52:
            r1 = r0
        L53:
            switch(r1) {
                case 0: goto L5e;
                case 1: goto L5c;
                case 2: goto L5a;
                case 3: goto L57;
                default: goto L56;
            }
        L56:
            goto L5a
        L57:
            r0 = 4096(0x1000, float:5.74E-42)
            goto L5e
        L5a:
            r0 = r3
            goto L5e
        L5c:
            r0 = 8192(0x2000, float:1.14794E-41)
        L5e:
            r6 = 28672(0x7000, float:4.0178E-41)
            updateStagedInputTypeFlag(r5, r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.textinput.ReactTextInputManager.setAutoCapitalize(com.facebook.react.views.textinput.ReactEditText, com.facebook.react.bridge.Dynamic):void");
    }

    @ReactProp(name = "autoCorrect")
    public void setAutoCorrect(ReactEditText reactEditText, @Nullable Boolean bool) {
        updateStagedInputTypeFlag(reactEditText, 557056, bool != null ? bool.booleanValue() ? 32768 : 524288 : 0);
    }

    @ReactProp(defaultBoolean = false, name = "autoFocus")
    public void setAutoFocus(ReactEditText reactEditText, boolean z) {
        reactEditText.setAutoFocus(z);
    }

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(ReactEditText reactEditText, int i2, @Nullable Integer num) {
        BackgroundStyleApplicator.k(reactEditText, LogicalEdge.f19899b, num);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {Snapshot.BORDER_RADIUS, Snapshot.BORDER_TOP_LEFT_RADIUS, Snapshot.BORDER_TOP_RIGHT_RADIUS, Snapshot.BORDER_BOTTOM_RIGHT_RADIUS, Snapshot.BORDER_BOTTOM_LEFT_RADIUS})
    public void setBorderRadius(ReactEditText reactEditText, int i2, float f2) {
        BackgroundStyleApplicator.l(reactEditText, BorderRadiusProp.values()[i2], Float.isNaN(f2) ? null : new LengthPercentage(f2, LengthPercentageType.f19394a));
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ReactEditText reactEditText, @Nullable String str) {
        BackgroundStyleApplicator.m(reactEditText, str == null ? null : BorderStyle.a(str));
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(ReactEditText reactEditText, int i2, float f2) {
        BackgroundStyleApplicator.n(reactEditText, LogicalEdge.values()[i2], Float.valueOf(f2));
    }

    @ReactProp(defaultBoolean = false, name = "caretHidden")
    public void setCaretHidden(ReactEditText reactEditText, boolean z) {
        if (reactEditText.getStagedInputType() == 32 && shouldHideCursorForEmailTextInput()) {
            return;
        }
        reactEditText.setCursorVisible(!z);
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(ReactEditText reactEditText, @Nullable Integer num) {
        if (num != null) {
            reactEditText.setTextColor(num.intValue());
            return;
        }
        ColorStateList colorStateListB = DefaultStyleValuesUtil.b(reactEditText.getContext());
        if (colorStateListB != null) {
            reactEditText.setTextColor(colorStateListB);
            return;
        }
        Context context = reactEditText.getContext();
        String str = TAG;
        StringBuilder sb = new StringBuilder("Could not get default text color from View Context: ");
        sb.append(context != null ? context.getClass().getCanonicalName() : "null");
        ReactSoftExceptionLogger.logSoftException(str, new IllegalStateException(sb.toString()));
    }

    @ReactProp(defaultBoolean = false, name = "contextMenuHidden")
    public void setContextMenuHidden(ReactEditText reactEditText, boolean z) {
        reactEditText.setContextMenuHidden(z);
    }

    @ReactProp(customType = "Color", name = "cursorColor")
    public void setCursorColor(ReactEditText reactEditText, @Nullable Integer num) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            Drawable textCursorDrawable = reactEditText.getTextCursorDrawable();
            if (textCursorDrawable != null) {
                if (num != null) {
                    com.facebook.react.uimanager.a.h();
                    int iIntValue = num.intValue();
                    BlendMode.SRC_IN;
                    BlendMode blendMode = BlendMode.SRC_IN;
                    textCursorDrawable.setColorFilter(com.facebook.react.uimanager.a.e(iIntValue));
                } else {
                    textCursorDrawable.clearColorFilter();
                }
                reactEditText.setTextCursorDrawable(textCursorDrawable);
                return;
            }
            return;
        }
        if (i2 == 28) {
            return;
        }
        try {
            Field declaredField = reactEditText.getClass().getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i3 = declaredField.getInt(reactEditText);
            if (i3 == 0) {
                return;
            }
            Drawable drawableMutate = reactEditText.getContext().getDrawable(i3).mutate();
            if (num != null) {
                drawableMutate.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
            } else {
                drawableMutate.clearColorFilter();
            }
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(reactEditText);
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            declaredField3.set(obj, new Drawable[]{drawableMutate, drawableMutate});
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
    }

    @ReactProp(defaultBoolean = false, name = "disableFullscreenUI")
    public void setDisableFullscreenUI(ReactEditText reactEditText, boolean z) {
        reactEditText.setDisableFullscreenUI(z);
    }

    @ReactProp(defaultBoolean = BuildConfig.IS_HERMES_ENABLED, name = "editable")
    public void setEditable(ReactEditText reactEditText, boolean z) {
        reactEditText.setEnabled(z);
    }

    @ReactProp(name = "fontFamily")
    public void setFontFamily(ReactEditText reactEditText, String str) {
        reactEditText.setFontFamily(str);
    }

    @ReactProp(defaultFloat = 14.0f, name = "fontSize")
    public void setFontSize(ReactEditText reactEditText, float f2) {
        reactEditText.setFontSize(f2);
    }

    @ReactProp(name = "fontStyle")
    public void setFontStyle(ReactEditText reactEditText, @Nullable String str) {
        reactEditText.setFontStyle(str);
    }

    @ReactProp(name = "fontVariant")
    public void setFontVariant(ReactEditText reactEditText, @Nullable ReadableArray readableArray) {
        reactEditText.setFontFeatureSettings(ReactTypefaceUtils.c(readableArray));
    }

    @ReactProp(name = "fontWeight")
    public void setFontWeight(ReactEditText reactEditText, @Nullable String str) {
        reactEditText.setFontWeight(str);
    }

    @ReactProp(name = "importantForAutofill")
    public void setImportantForAutofill(ReactEditText reactEditText, @Nullable String str) {
        setImportantForAutofill(reactEditText, "no".equals(str) ? 2 : "noExcludeDescendants".equals(str) ? 8 : "yes".equals(str) ? 1 : "yesExcludeDescendants".equals(str) ? 4 : 0);
    }

    @ReactProp(defaultBoolean = BuildConfig.IS_HERMES_ENABLED, name = "includeFontPadding")
    public void setIncludeFontPadding(ReactEditText reactEditText, boolean z) {
        reactEditText.setIncludeFontPadding(z);
    }

    @ReactProp(name = "inlineImageLeft")
    public void setInlineImageLeft(ReactEditText reactEditText, @Nullable String str) {
        reactEditText.setCompoundDrawablesWithIntrinsicBounds(ResourceDrawableIdHelper.a().c(reactEditText.getContext(), str), 0, 0, 0);
    }

    @ReactProp(name = "inlineImagePadding")
    public void setInlineImagePadding(ReactEditText reactEditText, int i2) {
        reactEditText.setCompoundDrawablePadding(i2);
    }

    @ReactProp(name = "keyboardType")
    public void setKeyboardType(ReactEditText reactEditText, @Nullable String str) {
        int i2;
        if (KEYBOARD_TYPE_NUMERIC.equalsIgnoreCase(str)) {
            i2 = INPUT_TYPE_KEYBOARD_NUMBERED;
        } else if (KEYBOARD_TYPE_NUMBER_PAD.equalsIgnoreCase(str)) {
            i2 = 2;
        } else if (KEYBOARD_TYPE_DECIMAL_PAD.equalsIgnoreCase(str)) {
            i2 = INPUT_TYPE_KEYBOARD_DECIMAL_PAD;
        } else if (KEYBOARD_TYPE_EMAIL_ADDRESS.equalsIgnoreCase(str)) {
            if (shouldHideCursorForEmailTextInput()) {
                reactEditText.setCursorVisible(false);
            }
            i2 = 33;
        } else {
            i2 = KEYBOARD_TYPE_PHONE_PAD.equalsIgnoreCase(str) ? 3 : KEYBOARD_TYPE_VISIBLE_PASSWORD.equalsIgnoreCase(str) ? 144 : "url".equalsIgnoreCase(str) ? 16 : 1;
        }
        updateStagedInputTypeFlag(reactEditText, 15, i2);
        checkPasswordType(reactEditText);
    }

    @ReactProp(defaultFloat = 0.0f, name = "letterSpacing")
    public void setLetterSpacing(ReactEditText reactEditText, float f2) {
        reactEditText.setLetterSpacingPt(f2);
    }

    @ReactProp(defaultFloat = 0.0f, name = "lineHeight")
    public void setLineHeight(ReactEditText reactEditText, int i2) {
        reactEditText.setLineHeight(i2);
    }

    @ReactProp(defaultFloat = Float.NaN, name = "maxFontSizeMultiplier")
    public void setMaxFontSizeMultiplier(ReactEditText reactEditText, float f2) {
        reactEditText.setMaxFontSizeMultiplier(f2);
    }

    @ReactProp(name = "maxLength")
    public void setMaxLength(ReactEditText reactEditText, @Nullable Integer num) {
        InputFilter[] filters = reactEditText.getFilters();
        InputFilter[] inputFilterArr = EMPTY_FILTERS;
        if (num == null) {
            if (filters.length > 0) {
                LinkedList linkedList = new LinkedList();
                for (InputFilter inputFilter : filters) {
                    if (!(inputFilter instanceof InputFilter.LengthFilter)) {
                        linkedList.add(inputFilter);
                    }
                }
                if (!linkedList.isEmpty()) {
                    inputFilterArr = (InputFilter[]) linkedList.toArray(new InputFilter[linkedList.size()]);
                }
            }
        } else if (filters.length > 0) {
            boolean z = false;
            for (int i2 = 0; i2 < filters.length; i2++) {
                if (filters[i2] instanceof InputFilter.LengthFilter) {
                    filters[i2] = new InputFilter.LengthFilter(num.intValue());
                    z = true;
                }
            }
            if (!z) {
                InputFilter[] inputFilterArr2 = new InputFilter[filters.length + 1];
                System.arraycopy(filters, 0, inputFilterArr2, 0, filters.length);
                filters[filters.length] = new InputFilter.LengthFilter(num.intValue());
                filters = inputFilterArr2;
            }
            inputFilterArr = filters;
        } else {
            inputFilterArr = new InputFilter[]{new InputFilter.LengthFilter(num.intValue())};
        }
        reactEditText.setFilters(inputFilterArr);
    }

    @ReactProp(defaultBoolean = false, name = "multiline")
    public void setMultiline(ReactEditText reactEditText, boolean z) {
        updateStagedInputTypeFlag(reactEditText, z ? 0 : 131072, z ? 131072 : 0);
    }

    @ReactProp(defaultInt = 1, name = "numberOfLines")
    public void setNumLines(ReactEditText reactEditText, int i2) {
        reactEditText.setLines(i2);
    }

    @ReactProp(defaultBoolean = false, name = "onContentSizeChange")
    public void setOnContentSizeChange(ReactEditText reactEditText, boolean z) {
        if (z) {
            reactEditText.setContentSizeWatcher(new ReactContentSizeWatcher(reactEditText));
        } else {
            reactEditText.setContentSizeWatcher(null);
        }
    }

    @ReactProp(defaultBoolean = false, name = "onKeyPress")
    public void setOnKeyPress(ReactEditText reactEditText, boolean z) {
        reactEditText.setOnKeyPress(z);
    }

    @ReactProp(defaultBoolean = false, name = "onScroll")
    public void setOnScroll(ReactEditText reactEditText, boolean z) {
        if (z) {
            reactEditText.setScrollWatcher(new ReactScrollWatcher(reactEditText));
        } else {
            reactEditText.setScrollWatcher(null);
        }
    }

    @ReactProp(defaultBoolean = false, name = "onSelectionChange")
    public void setOnSelectionChange(ReactEditText reactEditText, boolean z) {
        if (z) {
            reactEditText.setSelectionWatcher(new ReactSelectionWatcher(reactEditText));
        } else {
            reactEditText.setSelectionWatcher(null);
        }
    }

    @ReactProp(name = "overflow")
    public void setOverflow(ReactEditText reactEditText, @Nullable String str) {
        reactEditText.setOverflow(str);
    }

    @ReactProp(name = "placeholder")
    public void setPlaceholder(ReactEditText reactEditText, String str) {
        reactEditText.setPlaceholder(str);
    }

    @ReactProp(customType = "Color", name = "placeholderTextColor")
    public void setPlaceholderTextColor(ReactEditText reactEditText, @Nullable Integer num) {
        if (num == null) {
            reactEditText.setHintTextColor(DefaultStyleValuesUtil.d(reactEditText.getContext()));
        } else {
            reactEditText.setHintTextColor(num.intValue());
        }
    }

    @ReactProp(name = "returnKeyLabel")
    public void setReturnKeyLabel(ReactEditText reactEditText, String str) {
        reactEditText.setImeActionLabel(str, IME_ACTION_ID);
    }

    @ReactProp(name = "returnKeyType")
    public void setReturnKeyType(ReactEditText reactEditText, String str) {
        reactEditText.setReturnKeyType(str);
    }

    @ReactProp(defaultBoolean = false, name = "secureTextEntry")
    public void setSecureTextEntry(ReactEditText reactEditText, boolean z) {
        updateStagedInputTypeFlag(reactEditText, 144, z ? 128 : 0);
        checkPasswordType(reactEditText);
    }

    @ReactProp(defaultBoolean = false, name = "selectTextOnFocus")
    public void setSelectTextOnFocus(ReactEditText reactEditText, boolean z) {
        reactEditText.setSelectTextOnFocus(z);
    }

    @ReactProp(customType = "Color", name = "selectionColor")
    public void setSelectionColor(ReactEditText reactEditText, @Nullable Integer num) {
        if (num == null) {
            reactEditText.setHighlightColor(DefaultStyleValuesUtil.c(reactEditText.getContext()));
        } else {
            reactEditText.setHighlightColor(num.intValue());
        }
    }

    @ReactProp(customType = "Color", name = "selectionHandleColor")
    public void setSelectionHandleColor(ReactEditText reactEditText, @Nullable Integer num) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        int i2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            Drawable drawableMutate = reactEditText.getTextSelectHandle().mutate();
            Drawable drawableMutate2 = reactEditText.getTextSelectHandleLeft().mutate();
            Drawable drawableMutate3 = reactEditText.getTextSelectHandleRight().mutate();
            if (num != null) {
                com.facebook.react.uimanager.a.h();
                int iIntValue = num.intValue();
                BlendMode.SRC_IN;
                BlendMode blendMode = BlendMode.SRC_IN;
                BlendModeColorFilter blendModeColorFilterE = com.facebook.react.uimanager.a.e(iIntValue);
                drawableMutate.setColorFilter(blendModeColorFilterE);
                drawableMutate2.setColorFilter(blendModeColorFilterE);
                drawableMutate3.setColorFilter(blendModeColorFilterE);
            } else {
                drawableMutate.clearColorFilter();
                drawableMutate2.clearColorFilter();
                drawableMutate3.clearColorFilter();
            }
            reactEditText.setTextSelectHandle(drawableMutate);
            reactEditText.setTextSelectHandleLeft(drawableMutate2);
            reactEditText.setTextSelectHandleRight(drawableMutate3);
            return;
        }
        if (i3 == 28) {
            return;
        }
        int i4 = 0;
        while (true) {
            String[] strArr = DRAWABLE_HANDLE_RESOURCES;
            if (i4 >= strArr.length) {
                return;
            }
            try {
                Field declaredField = reactEditText.getClass().getDeclaredField(strArr[i4]);
                declaredField.setAccessible(true);
                i2 = declaredField.getInt(reactEditText);
            } catch (IllegalAccessException | NoSuchFieldException unused) {
            }
            if (i2 == 0) {
                return;
            }
            Drawable drawableMutate4 = reactEditText.getContext().getDrawable(i2).mutate();
            if (num != null) {
                drawableMutate4.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
            } else {
                drawableMutate4.clearColorFilter();
            }
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(reactEditText);
            Field declaredField3 = obj.getClass().getDeclaredField(DRAWABLE_HANDLE_FIELDS[i4]);
            declaredField3.setAccessible(true);
            declaredField3.set(obj, drawableMutate4);
            i4++;
        }
    }

    @ReactProp(name = "submitBehavior")
    public void setSubmitBehavior(ReactEditText reactEditText, @Nullable String str) {
        reactEditText.setSubmitBehavior(str);
    }

    @ReactProp(name = "textAlign")
    public void setTextAlign(ReactEditText reactEditText, @Nullable String str) {
        if ("justify".equals(str)) {
            if (Build.VERSION.SDK_INT >= 26) {
                reactEditText.setJustificationMode(1);
            }
            reactEditText.setGravityHorizontal(3);
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            reactEditText.setJustificationMode(0);
        }
        if (str == null || "auto".equals(str)) {
            reactEditText.setGravityHorizontal(0);
            return;
        }
        if ("left".equals(str)) {
            reactEditText.setGravityHorizontal(3);
            return;
        }
        if ("right".equals(str)) {
            reactEditText.setGravityHorizontal(5);
        } else if ("center".equals(str)) {
            reactEditText.setGravityHorizontal(1);
        } else {
            FLog.q("ReactNative", "Invalid textAlign: ".concat(str));
            reactEditText.setGravityHorizontal(0);
        }
    }

    @ReactProp(name = "textAlignVertical")
    public void setTextAlignVertical(ReactEditText reactEditText, @Nullable String str) {
        if (str == null || "auto".equals(str)) {
            reactEditText.setGravityVertical(0);
            return;
        }
        if ("top".equals(str)) {
            reactEditText.setGravityVertical(48);
            return;
        }
        if ("bottom".equals(str)) {
            reactEditText.setGravityVertical(80);
        } else if ("center".equals(str)) {
            reactEditText.setGravityVertical(16);
        } else {
            FLog.q("ReactNative", "Invalid textAlignVertical: ".concat(str));
            reactEditText.setGravityVertical(0);
        }
    }

    @ReactProp(name = "autoComplete")
    public void setTextContentType(ReactEditText reactEditText, @Nullable String str) {
        if (str == null) {
            setImportantForAutofill(reactEditText, 2);
            return;
        }
        if ("off".equals(str)) {
            setImportantForAutofill(reactEditText, 2);
            return;
        }
        Map<String, String> map = REACT_PROPS_AUTOFILL_HINTS_MAP;
        if (map.containsKey(str)) {
            setAutofillHints(reactEditText, map.get(str));
        } else {
            FLog.q("ReactNative", "Invalid autoComplete: ".concat(str));
            setImportantForAutofill(reactEditText, 2);
        }
    }

    @ReactProp(name = "textDecorationLine")
    public void setTextDecorationLine(ReactEditText reactEditText, @Nullable String str) {
        reactEditText.setPaintFlags(reactEditText.getPaintFlags() & (-25));
        if (str == null) {
            return;
        }
        for (String str2 : str.split(StringUtils.SPACE)) {
            if (str2.equals("underline")) {
                reactEditText.setPaintFlags(reactEditText.getPaintFlags() | 8);
            } else if (str2.equals("line-through")) {
                reactEditText.setPaintFlags(reactEditText.getPaintFlags() | 16);
            }
        }
    }

    @ReactProp(customType = "Color", name = "underlineColorAndroid")
    public void setUnderlineColor(ReactEditText reactEditText, @Nullable Integer num) {
        Drawable background = reactEditText.getBackground();
        if (background == null) {
            return;
        }
        if (background.getConstantState() != null) {
            try {
                background = background.mutate();
            } catch (NullPointerException e2) {
                FLog.h(TAG, "NullPointerException when setting underlineColorAndroid for TextInput", e2);
            }
        }
        if (num == null) {
            background.clearColorFilter();
        } else {
            background.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        }
    }

    @ReactProp(defaultBoolean = BuildConfig.IS_HERMES_ENABLED, name = "showSoftInputOnFocus")
    public void showKeyboardOnFocus(ReactEditText reactEditText, boolean z) {
        reactEditText.setShowSoftInputOnFocus(z);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(final ThemedReactContext themedReactContext, final ReactEditText reactEditText) {
        reactEditText.setEventDispatcher(getEventDispatcher(themedReactContext, reactEditText));
        reactEditText.addTextChangedListener(new ReactTextInputTextWatcher(themedReactContext, reactEditText));
        reactEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.facebook.react.views.textinput.a
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ReactTextInputManager.lambda$addEventEmitters$0(themedReactContext, reactEditText, view, z);
            }
        });
        reactEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.facebook.react.views.textinput.b
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                return ReactTextInputManager.lambda$addEventEmitters$1(reactEditText, themedReactContext, textView, i2, keyEvent);
            }
        });
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ReactBaseTextShadowNode createShadowNodeInstance() {
        return new ReactTextInputShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ReactEditText createViewInstance(ThemedReactContext themedReactContext) {
        ReactEditText reactEditText = new ReactEditText(themedReactContext);
        reactEditText.setInputType(reactEditText.getInputType() & (-131073));
        reactEditText.setReturnKeyType("done");
        reactEditText.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        return reactEditText;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(ReactEditText reactEditText) {
        super.onAfterUpdateTransaction((ReactTextInputManager) reactEditText);
        if (reactEditText.A) {
            reactEditText.A = false;
            reactEditText.setTypeface(ReactTypefaceUtils.a(reactEditText.getTypeface(), reactEditText.D, reactEditText.C, reactEditText.B, reactEditText.getContext().getAssets()));
            if (reactEditText.D == -1 && reactEditText.C == -1 && reactEditText.B == null && reactEditText.getFontFeatureSettings() == null) {
                reactEditText.setPaintFlags(reactEditText.getPaintFlags() & (-129));
            } else {
                reactEditText.setPaintFlags(reactEditText.getPaintFlags() | 128);
            }
        }
        if (reactEditText.getInputType() != reactEditText.o) {
            int selectionStart = reactEditText.getSelectionStart();
            int selectionEnd = reactEditText.getSelectionEnd();
            reactEditText.setInputType(reactEditText.o);
            reactEditText.f(selectionStart, selectionEnd);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void setPadding(ReactEditText reactEditText, int i2, int i3, int i4, int i5) {
        reactEditText.setPadding(i2, i3, i4, i5);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(ReactEditText reactEditText, Object obj) {
        if (obj instanceof ReactTextUpdate) {
            ReactTextUpdate reactTextUpdate = (ReactTextUpdate) obj;
            int paddingLeft = (int) reactTextUpdate.f20102d;
            int paddingTop = (int) reactTextUpdate.f20103e;
            int paddingRight = (int) reactTextUpdate.f20104f;
            int paddingBottom = (int) reactTextUpdate.f20105g;
            int length = -1;
            if (paddingLeft != -1 || paddingTop != -1 || paddingRight != -1 || paddingBottom != -1) {
                if (paddingLeft == -1) {
                    paddingLeft = reactEditText.getPaddingLeft();
                }
                if (paddingTop == -1) {
                    paddingTop = reactEditText.getPaddingTop();
                }
                if (paddingRight == -1) {
                    paddingRight = reactEditText.getPaddingRight();
                }
                if (paddingBottom == -1) {
                    paddingBottom = reactEditText.getPaddingBottom();
                }
                reactEditText.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
            boolean z = reactTextUpdate.f20101c;
            Spannable spannable = reactTextUpdate.f20099a;
            if (z) {
                int i2 = TextInlineImageSpan.f20175a;
                TextInlineImageSpan.Companion.a(spannable, reactEditText);
            }
            if (reactEditText.getSelectionStart() == reactEditText.getSelectionEnd()) {
                length = spannable.length() - ((reactEditText.getText() == null ? 0 : reactEditText.getText().length()) - reactEditText.getSelectionStart());
            }
            int i3 = length;
            reactEditText.g(reactTextUpdate);
            if (reactTextUpdate.f20100b >= reactEditText.f20186l) {
                reactEditText.f(length, i3);
            }
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Object updateState(ReactEditText reactEditText, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        QwertyKeyListener qwertyKeyListener = ReactEditText.Q;
        if (reactEditText.getStateWrapper() == null) {
            reactEditText.setPadding(0, 0, 0, 0);
        }
        reactEditText.setStateWrapper(stateWrapper);
        ReadableMapBuffer stateDataMapBuffer = stateWrapper.getStateDataMapBuffer();
        if (stateDataMapBuffer != null) {
            return getReactTextUpdate(reactEditText, reactStylesDiffMap, stateDataMapBuffer);
        }
        return null;
    }

    public ReactBaseTextShadowNode createShadowNodeInstance(@Nullable ReactTextViewManagerCallback reactTextViewManagerCallback) {
        return new ReactTextInputShadowNode(reactTextViewManagerCallback);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(ReactEditText reactEditText, int i2, @Nullable ReadableArray readableArray) {
        if (i2 == 1) {
            receiveCommand(reactEditText, "focus", readableArray);
        } else if (i2 == 2) {
            receiveCommand(reactEditText, "blur", readableArray);
        } else {
            if (i2 != 4) {
                return;
            }
            receiveCommand(reactEditText, "setTextAndSelection", readableArray);
        }
    }

    @Nullable
    public Object getReactTextUpdate(ReactEditText reactEditText, ReactStylesDiffMap reactStylesDiffMap, MapBuffer mapBuffer) {
        if (mapBuffer.getCount() == 0) {
            return null;
        }
        MapBuffer mapBufferJ0 = mapBuffer.j0(0);
        MapBuffer mapBufferJ02 = mapBuffer.j0(1);
        Spannable text = TextLayoutManager.d(reactEditText.getContext(), mapBufferJ0, this.mReactTextViewManagerCallback);
        int iM = TextAttributeProps.m(mapBufferJ02.getString(2));
        int justificationMode = Build.VERSION.SDK_INT >= 26 ? reactEditText.getJustificationMode() : 0;
        int i2 = mapBuffer.getInt(3);
        int iL = TextAttributeProps.l(reactStylesDiffMap, TextLayoutManager.g(mapBufferJ0), reactEditText.getGravityHorizontal());
        int iH = TextAttributeProps.h(justificationMode, reactStylesDiffMap);
        Intrinsics.checkNotNullParameter(text, "text");
        return new ReactTextUpdate(text, i2, iL, iM, iH);
    }

    private void setImportantForAutofill(ReactEditText reactEditText, int i2) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        reactEditText.setImportantForAutofill(i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000f  */
    @Override // com.facebook.react.uimanager.ViewManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void receiveCommand(com.facebook.react.views.textinput.ReactEditText r7, java.lang.String r8, @androidx.annotation.Nullable com.facebook.react.bridge.ReadableArray r9) {
        /*
            r6 = this;
            r0 = 3
            r1 = 2
            r2 = 1
            r3 = 0
            r8.getClass()
            r4 = -1
            int r5 = r8.hashCode()
            switch(r5) {
                case -1699362314: goto L3d;
                case 3027047: goto L32;
                case 97604824: goto L27;
                case 1427010500: goto L1c;
                case 1690703013: goto L11;
                default: goto Lf;
            }
        Lf:
            r8 = r4
            goto L47
        L11:
            java.lang.String r5 = "focusTextInput"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L1a
            goto Lf
        L1a:
            r8 = 4
            goto L47
        L1c:
            java.lang.String r5 = "setTextAndSelection"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L25
            goto Lf
        L25:
            r8 = r0
            goto L47
        L27:
            java.lang.String r5 = "focus"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L30
            goto Lf
        L30:
            r8 = r1
            goto L47
        L32:
            java.lang.String r5 = "blur"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L3b
            goto Lf
        L3b:
            r8 = r2
            goto L47
        L3d:
            java.lang.String r5 = "blurTextInput"
            boolean r8 = r8.equals(r5)
            if (r8 != 0) goto L46
            goto Lf
        L46:
            r8 = r3
        L47:
            switch(r8) {
                case 0: goto L7e;
                case 1: goto L7e;
                case 2: goto L7a;
                case 3: goto L4b;
                case 4: goto L7a;
                default: goto L4a;
            }
        L4a:
            goto L79
        L4b:
            int r8 = r9.getInt(r3)
            if (r8 != r4) goto L52
            goto L79
        L52:
            int r1 = r9.getInt(r1)
            int r0 = r9.getInt(r0)
            if (r0 != r4) goto L5d
            r0 = r1
        L5d:
            boolean r4 = r9.isNull(r2)
            if (r4 != 0) goto L72
            java.lang.String r9 = r9.getString(r2)
            com.facebook.react.views.text.ReactTextUpdate r9 = r6.getReactTextUpdate(r9, r8)
            r7.f20183i = r2
            r7.g(r9)
            r7.f20183i = r3
        L72:
            int r9 = r7.f20186l
            if (r8 < r9) goto L79
            r7.f(r1, r0)
        L79:
            return
        L7a:
            r7.i()
            return
        L7e:
            r7.clearFocus()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.textinput.ReactTextInputManager.receiveCommand(com.facebook.react.views.textinput.ReactEditText, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }
}
