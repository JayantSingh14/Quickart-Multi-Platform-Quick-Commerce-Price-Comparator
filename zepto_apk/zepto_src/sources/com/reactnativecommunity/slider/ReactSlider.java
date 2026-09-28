package com.reactnativecommunity.slider;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import java.net.URL;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class ReactSlider extends AppCompatSeekBar {

    /* renamed from: b, reason: collision with root package name */
    public double f46208b;

    /* renamed from: c, reason: collision with root package name */
    public double f46209c;

    /* renamed from: d, reason: collision with root package name */
    public double f46210d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f46211e;

    /* renamed from: f, reason: collision with root package name */
    public double f46212f;

    /* renamed from: g, reason: collision with root package name */
    public double f46213g;

    /* renamed from: h, reason: collision with root package name */
    public String f46214h;

    /* renamed from: i, reason: collision with root package name */
    public List f46215i;

    /* renamed from: j, reason: collision with root package name */
    public double f46216j;

    /* renamed from: k, reason: collision with root package name */
    public int f46217k;

    /* renamed from: l, reason: collision with root package name */
    public double f46218l;

    /* renamed from: m, reason: collision with root package name */
    public int f46219m;

    public ReactSlider(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f46208b = 0.0d;
        this.f46209c = 0.0d;
        this.f46210d = 0.0d;
        this.f46211e = false;
        this.f46212f = 0.0d;
        this.f46213g = 0.0d;
        this.f46216j = -9.223372036854776E18d;
        this.f46218l = 9.223372036854776E18d;
        super.setLayoutDirection(I18nUtil.b(context) ? 1 : 0);
        if (Build.VERSION.SDK_INT < 26) {
            super.setStateListAnimator(null);
        }
    }

    private double getStepValue() {
        double d2 = this.f46212f;
        return d2 > 0.0d ? d2 : this.f46213g;
    }

    private int getTotalSteps() {
        return (int) Math.ceil((this.f46209c - this.f46208b) / getStepValue());
    }

    public final double a(int i2) {
        return i2 == getMax() ? this.f46209c : (i2 * getStepValue()) + this.f46208b;
    }

    @Override // android.view.View
    public final void announceForAccessibility(CharSequence charSequence) {
        Context context = getContext();
        final AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            final AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
            accessibilityEventObtain.setEventType(16384);
            accessibilityEventObtain.setClassName(getClass().getName());
            accessibilityEventObtain.setPackageName(context.getPackageName());
            accessibilityEventObtain.getText().add(charSequence);
            new Timer().schedule(new TimerTask() { // from class: com.reactnativecommunity.slider.ReactSlider.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public final void run() {
                    accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
                }
            }, 1000L);
        }
    }

    public final void b() {
        if (this.f46212f == 0.0d) {
            this.f46213g = (this.f46209c - this.f46208b) / 128;
        }
        setMax(getTotalSteps());
        setKeyProgressIncrement(1);
        c();
        d();
        double d2 = this.f46210d;
        double d3 = this.f46208b;
        setProgress((int) Math.round(((d2 - d3) / (this.f46209c - d3)) * getTotalSteps()));
    }

    public final void c() {
        double dMax = Math.max(this.f46216j, this.f46208b);
        double d2 = this.f46208b;
        int iRound = (int) Math.round(((dMax - d2) / (this.f46209c - d2)) * getTotalSteps());
        int i2 = this.f46219m;
        if (iRound > i2) {
            Log.d("Invalid configuration", "upperLimit < lowerLimit; lowerLimit not set");
        } else {
            this.f46217k = Math.min(iRound, i2);
        }
    }

    public final void d() {
        double dMin = Math.min(this.f46218l, this.f46209c);
        double d2 = this.f46208b;
        int iRound = (int) Math.round(((dMin - d2) / (this.f46209c - d2)) * getTotalSteps());
        if (this.f46217k > iRound) {
            Log.d("Invalid configuration", "upperLimit < lowerLimit; upperLimit not set");
        } else {
            this.f46219m = iRound;
        }
    }

    public int getLowerLimit() {
        return this.f46217k;
    }

    public int getUpperLimit() {
        return this.f46219m;
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 32768 || (accessibilityEvent.getEventType() == 4 && isAccessibilityFocused())) {
            setupAccessibility((int) this.f46210d);
        }
    }

    public void setAccessibilityIncrements(List<String> list) {
        this.f46215i = list;
    }

    public void setAccessibilityUnits(String str) {
        this.f46214h = str;
    }

    public void setLowerLimit(double d2) {
        this.f46216j = d2;
        c();
    }

    public void setMaxValue(double d2) {
        this.f46209c = d2;
        b();
    }

    public void setMinValue(double d2) {
        this.f46208b = d2;
        b();
    }

    public void setStep(double d2) {
        this.f46212f = d2;
        b();
    }

    public void setThumbImage(final String str) {
        BitmapDrawable bitmapDrawable;
        if (str == null) {
            setThumb(getThumb());
            return;
        }
        try {
            bitmapDrawable = (BitmapDrawable) Executors.newSingleThreadExecutor().submit(new Callable<BitmapDrawable>() { // from class: com.reactnativecommunity.slider.ReactSlider.2
                @Override // java.util.concurrent.Callable
                public final BitmapDrawable call() {
                    Bitmap bitmapDecodeStream;
                    String str2 = str;
                    try {
                        boolean zStartsWith = str2.startsWith("http://");
                        ReactSlider reactSlider = ReactSlider.this;
                        if (zStartsWith || str2.startsWith("https://") || str2.startsWith("file://") || str2.startsWith("asset://") || str2.startsWith("data:")) {
                            bitmapDecodeStream = BitmapFactory.decodeStream(new URL(str2).openStream());
                        } else {
                            bitmapDecodeStream = BitmapFactory.decodeResource(reactSlider.getResources(), reactSlider.getResources().getIdentifier(str2, "drawable", reactSlider.getContext().getPackageName()));
                        }
                        return new BitmapDrawable(reactSlider.getResources(), bitmapDecodeStream);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return null;
                    }
                }
            }).get();
        } catch (Exception e2) {
            e2.printStackTrace();
            bitmapDrawable = null;
        }
        setThumb(bitmapDrawable);
        setSplitTrack(false);
    }

    public void setUpperLimit(double d2) {
        this.f46218l = d2;
        d();
    }

    public void setValue(double d2) {
        this.f46210d = d2;
        double d3 = this.f46208b;
        setProgress((int) Math.round(((d2 - d3) / (this.f46209c - d3)) * getTotalSteps()));
    }

    public void setupAccessibility(int i2) {
        List list;
        if (this.f46214h == null || (list = this.f46215i) == null || list.size() - 1 != ((int) this.f46209c)) {
            return;
        }
        String str = (String) this.f46215i.get(i2);
        int length = this.f46214h.length();
        String strSubstring = this.f46214h;
        if (str != null && Integer.parseInt(str) == 1) {
            strSubstring = strSubstring.substring(0, length - 1);
        }
        announceForAccessibility(str + StringUtils.SPACE + strSubstring);
    }
}
