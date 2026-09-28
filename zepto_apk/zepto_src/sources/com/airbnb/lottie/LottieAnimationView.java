package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.facebook.react.uimanager.ThemedReactContext;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;
import javax.net.ssl.SSLException;

/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {
    public static final c q = new LottieListener() { // from class: com.airbnb.lottie.c
        @Override // com.airbnb.lottie.LottieListener
        public final void onResult(Object obj) {
            Throwable th = (Throwable) obj;
            c cVar = LottieAnimationView.q;
            ThreadLocal threadLocal = Utils.f14810a;
            if (!(th instanceof SocketException) && !(th instanceof ClosedChannelException) && !(th instanceof InterruptedIOException) && !(th instanceof ProtocolException) && !(th instanceof SSLException) && !(th instanceof UnknownHostException) && !(th instanceof UnknownServiceException)) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
            Logger.c("Unable to load composition.", th);
        }
    };

    /* renamed from: d, reason: collision with root package name */
    public final LottieListener f14109d;

    /* renamed from: e, reason: collision with root package name */
    public final LottieListener f14110e;

    /* renamed from: f, reason: collision with root package name */
    public LottieListener f14111f;

    /* renamed from: g, reason: collision with root package name */
    public int f14112g;

    /* renamed from: h, reason: collision with root package name */
    public final LottieDrawable f14113h;

    /* renamed from: i, reason: collision with root package name */
    public String f14114i;

    /* renamed from: j, reason: collision with root package name */
    public int f14115j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f14116k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f14117l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f14118m;
    public final HashSet n;
    public final HashSet o;
    public LottieTask p;

    /* renamed from: com.airbnb.lottie.LottieAnimationView$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 extends LottieValueCallback<Object> {
        @Override // com.airbnb.lottie.value.LottieValueCallback
        public final Object a(LottieFrameInfo lottieFrameInfo) {
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public String f14119a;

        /* renamed from: b, reason: collision with root package name */
        public int f14120b;

        /* renamed from: c, reason: collision with root package name */
        public float f14121c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f14122d;

        /* renamed from: e, reason: collision with root package name */
        public String f14123e;

        /* renamed from: f, reason: collision with root package name */
        public int f14124f;

        /* renamed from: g, reason: collision with root package name */
        public int f14125g;

        /* renamed from: com.airbnb.lottie.LottieAnimationView$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                SavedState savedState = new SavedState(parcel);
                savedState.f14119a = parcel.readString();
                savedState.f14121c = parcel.readFloat();
                savedState.f14122d = parcel.readInt() == 1;
                savedState.f14123e = parcel.readString();
                savedState.f14124f = parcel.readInt();
                savedState.f14125g = parcel.readInt();
                return savedState;
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f14119a);
            parcel.writeFloat(this.f14121c);
            parcel.writeInt(this.f14122d ? 1 : 0);
            parcel.writeString(this.f14123e);
            parcel.writeInt(this.f14124f);
            parcel.writeInt(this.f14125g);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes3.dex */
    public static final class UserActionTaken {

        /* renamed from: a, reason: collision with root package name */
        public static final UserActionTaken f14126a;

        /* renamed from: b, reason: collision with root package name */
        public static final UserActionTaken f14127b;

        /* renamed from: c, reason: collision with root package name */
        public static final UserActionTaken f14128c;

        /* renamed from: d, reason: collision with root package name */
        public static final UserActionTaken f14129d;

        /* renamed from: e, reason: collision with root package name */
        public static final UserActionTaken f14130e;

        /* renamed from: f, reason: collision with root package name */
        public static final UserActionTaken f14131f;

        /* renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ UserActionTaken[] f14132g;

        static {
            UserActionTaken userActionTaken = new UserActionTaken("SET_ANIMATION", 0);
            f14126a = userActionTaken;
            UserActionTaken userActionTaken2 = new UserActionTaken("SET_PROGRESS", 1);
            f14127b = userActionTaken2;
            UserActionTaken userActionTaken3 = new UserActionTaken("SET_REPEAT_MODE", 2);
            f14128c = userActionTaken3;
            UserActionTaken userActionTaken4 = new UserActionTaken("SET_REPEAT_COUNT", 3);
            f14129d = userActionTaken4;
            UserActionTaken userActionTaken5 = new UserActionTaken("SET_IMAGE_ASSETS", 4);
            f14130e = userActionTaken5;
            UserActionTaken userActionTaken6 = new UserActionTaken("PLAY_OPTION", 5);
            f14131f = userActionTaken6;
            f14132g = new UserActionTaken[]{userActionTaken, userActionTaken2, userActionTaken3, userActionTaken4, userActionTaken5, userActionTaken6};
        }

        public static UserActionTaken valueOf(String str) {
            return (UserActionTaken) Enum.valueOf(UserActionTaken.class, str);
        }

        public static UserActionTaken[] values() {
            return (UserActionTaken[]) f14132g.clone();
        }
    }

    /* loaded from: classes3.dex */
    public static class WeakFailureListener implements LottieListener<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f14133a;

        public WeakFailureListener(LottieAnimationView lottieAnimationView) {
            this.f14133a = new WeakReference(lottieAnimationView);
        }

        @Override // com.airbnb.lottie.LottieListener
        public final void onResult(Object obj) {
            Throwable th = (Throwable) obj;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f14133a.get();
            if (lottieAnimationView == null) {
                return;
            }
            int i2 = lottieAnimationView.f14112g;
            if (i2 != 0) {
                lottieAnimationView.setImageResource(i2);
            }
            LottieListener lottieListener = lottieAnimationView.f14111f;
            if (lottieListener == null) {
                lottieListener = LottieAnimationView.q;
            }
            lottieListener.onResult(th);
        }
    }

    /* loaded from: classes3.dex */
    public static class WeakSuccessListener implements LottieListener<LottieComposition> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f14134a;

        public WeakSuccessListener(LottieAnimationView lottieAnimationView) {
            this.f14134a = new WeakReference(lottieAnimationView);
        }

        @Override // com.airbnb.lottie.LottieListener
        public final void onResult(Object obj) {
            LottieComposition lottieComposition = (LottieComposition) obj;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f14134a.get();
            if (lottieAnimationView == null) {
                return;
            }
            lottieAnimationView.setComposition(lottieComposition);
        }
    }

    public LottieAnimationView(ThemedReactContext themedReactContext) {
        super(themedReactContext, null);
        this.f14109d = new WeakSuccessListener(this);
        this.f14110e = new WeakFailureListener(this);
        this.f14112g = 0;
        this.f14113h = new LottieDrawable();
        this.f14116k = false;
        this.f14117l = false;
        this.f14118m = true;
        this.n = new HashSet();
        this.o = new HashSet();
        e(null, R.attr.lottieAnimationViewStyle);
    }

    private void setCompositionTask(LottieTask<LottieComposition> lottieTask) {
        LottieResult lottieResultC = lottieTask.c();
        LottieDrawable lottieDrawable = this.f14113h;
        if (lottieResultC != null && lottieDrawable == getDrawable() && lottieDrawable.o() == lottieResultC.a()) {
            return;
        }
        this.n.add(UserActionTaken.f14126a);
        lottieDrawable.f();
        d();
        lottieTask.b(this.f14109d);
        lottieTask.a(this.f14110e);
        this.p = lottieTask;
    }

    public final void c() {
        this.f14117l = false;
        this.n.add(UserActionTaken.f14131f);
        this.f14113h.e();
    }

    public final void d() {
        LottieTask lottieTask = this.p;
        if (lottieTask != null) {
            lottieTask.f(this.f14109d);
            this.p.e(this.f14110e);
        }
    }

    public final void e(AttributeSet attributeSet, int i2) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView, i2, 0);
        this.f14118m = typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_rawRes);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_fileName);
        boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_url);
        if (zHasValue && zHasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (zHasValue) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_rawRes, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (zHasValue2) {
            String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_fileName);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_url)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.f14117l = true;
        }
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false);
        LottieDrawable lottieDrawable = this.f14113h;
        if (z) {
            lottieDrawable.k0(-1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_speed)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_speed, 1.0f));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_clipToCompositionBounds)) {
            setClipToCompositionBounds(typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_clipToCompositionBounds, true));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_clipTextToBoundingBox)) {
            setClipTextToBoundingBox(typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_clipTextToBoundingBox, false));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_defaultFontFileExtension)) {
            setDefaultFontFileExtension(typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_defaultFontFileExtension));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        boolean zHasValue4 = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_progress);
        float f2 = typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f);
        if (zHasValue4) {
            this.n.add(UserActionTaken.f14127b);
        }
        lottieDrawable.i0(f2);
        lottieDrawable.j(typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter)) {
            lottieDrawable.b(new KeyPath("**"), LottieProperty.F, new LottieValueCallback(new SimpleColorFilter(AppCompatResources.a(typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_colorFilter, -1), getContext()).getDefaultColor())));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_renderMode)) {
            int i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_renderMode, 0);
            if (i3 >= RenderMode.values().length) {
                i3 = 0;
            }
            setRenderMode(RenderMode.values()[i3]);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_asyncUpdates)) {
            int i4 = typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_asyncUpdates, 0);
            if (i4 >= RenderMode.values().length) {
                i4 = 0;
            }
            setAsyncUpdates(AsyncUpdates.values()[i4]);
        }
        setIgnoreDisabledSystemAnimations(typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_useCompositionFrameRate)) {
            setUseCompositionFrameRate(typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_useCompositionFrameRate, false));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void f() {
        this.n.add(UserActionTaken.f14131f);
        this.f14113h.G();
    }

    public final void g() {
        this.n.add(UserActionTaken.f14131f);
        this.f14113h.I();
    }

    public AsyncUpdates getAsyncUpdates() {
        return this.f14113h.k();
    }

    public boolean getAsyncUpdatesEnabled() {
        return this.f14113h.l();
    }

    public boolean getClipTextToBoundingBox() {
        return this.f14113h.m();
    }

    public boolean getClipToCompositionBounds() {
        return this.f14113h.n();
    }

    @Nullable
    public LottieComposition getComposition() {
        Drawable drawable = getDrawable();
        LottieDrawable lottieDrawable = this.f14113h;
        if (drawable == lottieDrawable) {
            return lottieDrawable.o();
        }
        return null;
    }

    public long getDuration() {
        LottieComposition composition = getComposition();
        if (composition != null) {
            return (long) composition.b();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f14113h.r();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.f14113h.s();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.f14113h.t();
    }

    public float getMaxFrame() {
        return this.f14113h.u();
    }

    public float getMinFrame() {
        return this.f14113h.v();
    }

    @Nullable
    public PerformanceTracker getPerformanceTracker() {
        return this.f14113h.w();
    }

    @FloatRange
    public float getProgress() {
        return this.f14113h.x();
    }

    public RenderMode getRenderMode() {
        return this.f14113h.y();
    }

    public int getRepeatCount() {
        return this.f14113h.z();
    }

    public int getRepeatMode() {
        return this.f14113h.A();
    }

    public float getSpeed() {
        return this.f14113h.B();
    }

    public final void h(InputStream inputStream, String str) {
        setCompositionTask(LottieCompositionFactory.e(inputStream, str));
    }

    public final void i(ZipInputStream zipInputStream, String str) {
        setCompositionTask(LottieCompositionFactory.m(zipInputStream, str));
    }

    @Override // android.view.View
    public final void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof LottieDrawable) && ((LottieDrawable) drawable).y() == RenderMode.f14204c) {
            this.f14113h.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.f14113h;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public final void j(String str, String str2) {
        setCompositionTask(LottieCompositionFactory.l(getContext(), str, str2));
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.f14117l) {
            return;
        }
        this.f14113h.G();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        int i2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f14114i = savedState.f14119a;
        UserActionTaken userActionTaken = UserActionTaken.f14126a;
        HashSet hashSet = this.n;
        if (!hashSet.contains(userActionTaken) && !TextUtils.isEmpty(this.f14114i)) {
            setAnimation(this.f14114i);
        }
        this.f14115j = savedState.f14120b;
        if (!hashSet.contains(userActionTaken) && (i2 = this.f14115j) != 0) {
            setAnimation(i2);
        }
        if (!hashSet.contains(UserActionTaken.f14127b)) {
            this.f14113h.i0(savedState.f14121c);
        }
        if (!hashSet.contains(UserActionTaken.f14131f) && savedState.f14122d) {
            f();
        }
        if (!hashSet.contains(UserActionTaken.f14130e)) {
            setImageAssetsFolder(savedState.f14123e);
        }
        if (!hashSet.contains(UserActionTaken.f14128c)) {
            setRepeatMode(savedState.f14124f);
        }
        if (hashSet.contains(UserActionTaken.f14129d)) {
            return;
        }
        setRepeatCount(savedState.f14125g);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f14119a = this.f14114i;
        savedState.f14120b = this.f14115j;
        LottieDrawable lottieDrawable = this.f14113h;
        savedState.f14121c = lottieDrawable.x();
        savedState.f14122d = lottieDrawable.D();
        savedState.f14123e = lottieDrawable.s();
        savedState.f14124f = lottieDrawable.A();
        savedState.f14125g = lottieDrawable.z();
        return savedState;
    }

    public void setAnimation(@RawRes final int i2) {
        this.f14115j = i2;
        this.f14114i = null;
        setCompositionTask(isInEditMode() ? new LottieTask<>(new Callable() { // from class: com.airbnb.lottie.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                LottieAnimationView lottieAnimationView = this.f14400a;
                boolean z = lottieAnimationView.f14118m;
                int i3 = i2;
                if (!z) {
                    return LottieCompositionFactory.j(lottieAnimationView.getContext(), i3, null);
                }
                Context context = lottieAnimationView.getContext();
                return LottieCompositionFactory.j(context, i3, LottieCompositionFactory.r(i3, context));
            }
        }, true) : this.f14118m ? LottieCompositionFactory.h(i2, getContext()) : LottieCompositionFactory.i(getContext(), i2, null));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        h(new ByteArrayInputStream(str.getBytes()), null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.f14118m ? LottieCompositionFactory.k(getContext(), str) : LottieCompositionFactory.l(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.f14113h.K(z);
    }

    public void setAsyncUpdates(AsyncUpdates asyncUpdates) {
        this.f14113h.L(asyncUpdates);
    }

    public void setCacheComposition(boolean z) {
        this.f14118m = z;
    }

    public void setClipTextToBoundingBox(boolean z) {
        this.f14113h.M(z);
    }

    public void setClipToCompositionBounds(boolean z) {
        this.f14113h.N(z);
    }

    public void setComposition(@NonNull LottieComposition lottieComposition) {
        NetworkFetcher networkFetcher = L.f14106a;
        LottieDrawable lottieDrawable = this.f14113h;
        lottieDrawable.setCallback(this);
        this.f14116k = true;
        boolean zO = lottieDrawable.O(lottieComposition);
        if (this.f14117l) {
            lottieDrawable.G();
        }
        this.f14116k = false;
        if (getDrawable() != lottieDrawable || zO) {
            if (!zO) {
                boolean zC = lottieDrawable.C();
                setImageDrawable(null);
                setImageDrawable(lottieDrawable);
                if (zC) {
                    lottieDrawable.I();
                }
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator it = this.o.iterator();
            while (it.hasNext()) {
                ((LottieOnCompositionLoadedListener) it.next()).a(lottieComposition);
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        this.f14113h.P(str);
    }

    public void setFailureListener(@Nullable LottieListener<Throwable> lottieListener) {
        this.f14111f = lottieListener;
    }

    public void setFallbackResource(@DrawableRes int i2) {
        this.f14112g = i2;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.f14113h.Q(fontAssetDelegate);
    }

    public void setFontMap(@Nullable Map<String, Typeface> map) {
        this.f14113h.R(map);
    }

    public void setFrame(int i2) {
        this.f14113h.S(i2);
    }

    @Deprecated
    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.f14113h.T(z);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.f14113h.U(imageAssetDelegate);
    }

    public void setImageAssetsFolder(String str) {
        this.f14113h.V(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.f14115j = 0;
        this.f14114i = null;
        d();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.f14115j = 0;
        this.f14114i = null;
        d();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        this.f14115j = 0;
        this.f14114i = null;
        d();
        super.setImageResource(i2);
    }

    public void setMaintainOriginalImageBounds(boolean z) {
        this.f14113h.W(z);
    }

    public void setMaxFrame(int i2) {
        this.f14113h.X(i2);
    }

    public void setMaxProgress(@FloatRange float f2) {
        this.f14113h.Z(f2);
    }

    public void setMinAndMaxFrame(String str) {
        this.f14113h.b0(str);
    }

    public void setMinFrame(int i2) {
        this.f14113h.d0(i2);
    }

    public void setMinProgress(float f2) {
        this.f14113h.f0(f2);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.f14113h.g0(z);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f14113h.h0(z);
    }

    public void setProgress(@FloatRange float f2) {
        this.n.add(UserActionTaken.f14127b);
        this.f14113h.i0(f2);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.f14113h.j0(renderMode);
    }

    public void setRepeatCount(int i2) {
        this.n.add(UserActionTaken.f14129d);
        this.f14113h.k0(i2);
    }

    public void setRepeatMode(int i2) {
        this.n.add(UserActionTaken.f14128c);
        this.f14113h.l0(i2);
    }

    public void setSafeMode(boolean z) {
        this.f14113h.m0(z);
    }

    public void setSpeed(float f2) {
        this.f14113h.n0(f2);
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.f14113h.o0(textDelegate);
    }

    public void setUseCompositionFrameRate(boolean z) {
        this.f14113h.p0(z);
    }

    @Override // android.view.View
    public final void unscheduleDrawable(Drawable drawable) {
        LottieDrawable lottieDrawable;
        if (!this.f14116k && drawable == (lottieDrawable = this.f14113h) && lottieDrawable.C()) {
            this.f14117l = false;
            lottieDrawable.F();
        } else if (!this.f14116k && (drawable instanceof LottieDrawable)) {
            LottieDrawable lottieDrawable2 = (LottieDrawable) drawable;
            if (lottieDrawable2.C()) {
                lottieDrawable2.F();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public void setMaxFrame(String str) {
        this.f14113h.Y(str);
    }

    public void setMinFrame(String str) {
        this.f14113h.e0(str);
    }

    public void setAnimation(String str) {
        LottieTask<LottieComposition> lottieTaskB;
        this.f14114i = str;
        this.f14115j = 0;
        if (isInEditMode()) {
            lottieTaskB = new LottieTask<>(new b(str, 0, this), true);
        } else {
            lottieTaskB = this.f14118m ? LottieCompositionFactory.b(getContext(), str) : LottieCompositionFactory.c(getContext(), str, null);
        }
        setCompositionTask(lottieTaskB);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14109d = new WeakSuccessListener(this);
        this.f14110e = new WeakFailureListener(this);
        this.f14112g = 0;
        this.f14113h = new LottieDrawable();
        this.f14116k = false;
        this.f14117l = false;
        this.f14118m = true;
        this.n = new HashSet();
        this.o = new HashSet();
        e(attributeSet, R.attr.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14109d = new WeakSuccessListener(this);
        this.f14110e = new WeakFailureListener(this);
        this.f14112g = 0;
        this.f14113h = new LottieDrawable();
        this.f14116k = false;
        this.f14117l = false;
        this.f14118m = true;
        this.n = new HashSet();
        this.o = new HashSet();
        e(attributeSet, i2);
    }
}
