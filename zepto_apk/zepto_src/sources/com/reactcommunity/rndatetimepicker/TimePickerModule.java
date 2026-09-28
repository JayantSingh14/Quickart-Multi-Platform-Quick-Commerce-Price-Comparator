package com.reactcommunity.rndatetimepicker;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TimePicker;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.media3.exoplayer.source.h;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import java.util.Calendar;

@ReactModule(name = TimePickerModule.NAME)
/* loaded from: classes4.dex */
public class TimePickerModule extends NativeModuleTimePickerSpec {

    @VisibleForTesting
    public static final String NAME = "RNCTimePicker";

    public class TimePickerDialogListener implements TimePickerDialog.OnTimeSetListener, DialogInterface.OnDismissListener, DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final Promise f46157a;

        /* renamed from: b, reason: collision with root package name */
        public final Bundle f46158b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f46159c = false;

        public TimePickerDialogListener(Promise promise, Bundle bundle) {
            this.f46157a = promise;
            this.f46158b = bundle;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (this.f46159c || !TimePickerModule.this.getReactApplicationContext().hasActiveReactInstance()) {
                return;
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("action", "neutralButtonAction");
            this.f46157a.resolve(writableNativeMap);
            this.f46159c = true;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            if (this.f46159c || !TimePickerModule.this.getReactApplicationContext().hasActiveReactInstance()) {
                return;
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("action", "dismissedAction");
            this.f46157a.resolve(writableNativeMap);
            this.f46159c = true;
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public final void onTimeSet(TimePicker timePicker, int i2, int i3) {
            if (this.f46159c || !TimePickerModule.this.getReactApplicationContext().hasActiveReactInstance()) {
                return;
            }
            Bundle bundle = this.f46158b;
            RNDate rNDate = new RNDate(bundle);
            Calendar calendar = Calendar.getInstance(Common.c(bundle));
            calendar.set(rNDate.f46150a.get(1), rNDate.f46150a.get(2), rNDate.f46150a.get(5), i2, i3, 0);
            calendar.set(14, 0);
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("action", "timeSetAction");
            writableNativeMap.putDouble("timestamp", calendar.getTimeInMillis());
            writableNativeMap.putDouble("utcOffset", (calendar.getTimeZone().getOffset(calendar.getTimeInMillis()) / 1000) / 60);
            this.f46157a.resolve(writableNativeMap);
            this.f46159c = true;
        }
    }

    public TimePickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private Bundle createFragmentArguments(ReadableMap readableMap) {
        Bundle bundleA = Common.a(readableMap);
        if (readableMap.hasKey("is24Hour") && !readableMap.isNull("is24Hour")) {
            bundleA.putBoolean("is24Hour", readableMap.getBoolean("is24Hour"));
        }
        if (readableMap.hasKey("display") && !readableMap.isNull("display")) {
            bundleA.putString("display", readableMap.getString("display"));
        }
        if (readableMap.hasKey("dialogButtons") && !readableMap.isNull("dialogButtons")) {
            bundleA.putBundle("dialogButtons", Arguments.toBundle(readableMap.getMap("dialogButtons")));
        }
        if (readableMap.hasKey("minuteInterval") && !readableMap.isNull("minuteInterval")) {
            bundleA.putInt("minuteInterval", readableMap.getInt("minuteInterval"));
        }
        if (readableMap.hasKey("timeZoneOffsetInMinutes") && !readableMap.isNull("timeZoneOffsetInMinutes")) {
            bundleA.putLong("timeZoneOffsetInMinutes", (long) readableMap.getDouble("timeZoneOffsetInMinutes"));
        }
        return bundleA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$open$0(FragmentManager fragmentManager, ReadableMap readableMap, Promise promise) {
        RNTimePickerDialogFragment rNTimePickerDialogFragment = (RNTimePickerDialogFragment) fragmentManager.E(NAME);
        Bundle bundleCreateFragmentArguments = createFragmentArguments(readableMap);
        if (rNTimePickerDialogFragment != null) {
            RNDate rNDate = new RNDate(bundleCreateFragmentArguments);
            rNTimePickerDialogFragment.Q.updateTime(rNDate.f46150a.get(11), rNDate.f46150a.get(12));
            return;
        }
        RNTimePickerDialogFragment rNTimePickerDialogFragment2 = new RNTimePickerDialogFragment();
        rNTimePickerDialogFragment2.setArguments(bundleCreateFragmentArguments);
        TimePickerDialogListener timePickerDialogListener = new TimePickerDialogListener(promise, bundleCreateFragmentArguments);
        rNTimePickerDialogFragment2.Y = timePickerDialogListener;
        rNTimePickerDialogFragment2.X = timePickerDialogListener;
        rNTimePickerDialogFragment2.Z = timePickerDialogListener;
        rNTimePickerDialogFragment2.show(fragmentManager, NAME);
    }

    @Override // com.reactcommunity.rndatetimepicker.NativeModuleTimePickerSpec
    @ReactMethod
    public void dismiss(Promise promise) {
        Common.b((FragmentActivity) getCurrentActivity(), NAME, promise);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return NAME;
    }

    @Override // com.reactcommunity.rndatetimepicker.NativeModuleTimePickerSpec
    @ReactMethod
    public void open(ReadableMap readableMap, Promise promise) {
        FragmentActivity fragmentActivity = (FragmentActivity) getCurrentActivity();
        if (fragmentActivity == null) {
            promise.reject("E_NO_ACTIVITY", "Tried to open a TimePicker dialog while not attached to an Activity");
        } else {
            UiThreadUtil.runOnUiThread(new h(this, fragmentActivity.getSupportFragmentManager(), readableMap, promise, 7));
        }
    }
}
