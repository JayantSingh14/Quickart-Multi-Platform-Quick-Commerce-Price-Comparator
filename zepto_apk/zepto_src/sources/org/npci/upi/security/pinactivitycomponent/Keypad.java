package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public class Keypad extends TableLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f57478a;

    /* renamed from: b, reason: collision with root package name */
    private int f57479b;

    /* renamed from: c, reason: collision with root package name */
    private int f57480c;

    /* renamed from: d, reason: collision with root package name */
    private float f57481d;

    /* renamed from: e, reason: collision with root package name */
    private a f57482e;

    public interface a {
        void a(View view, int i2);
    }

    public Keypad(Context context) {
        this(context, null);
    }

    private int a(float f2) {
        return (int) (f2 * (getResources().getDisplayMetrics().densityDpi / 160));
    }

    @NonNull
    private TableRow.LayoutParams getItemParams() {
        return new TableRow.LayoutParams(0, a(this.f57478a), 1.0f);
    }

    private void setClickFeedback(View view) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
        view.setBackgroundResource(typedValue.resourceId);
    }

    public void setOnKeyPressCallback(a aVar) {
        this.f57482e = aVar;
    }

    public Keypad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f57478a = 61;
        a(attributeSet);
        a();
    }

    private void a() {
        setBackgroundColor(this.f57479b);
        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(-1, 0, 1.0f);
        final int i2 = 1;
        for (int i3 = 0; i3 < 3; i3++) {
            TableRow tableRow = new TableRow(getContext());
            tableRow.setLayoutParams(layoutParams);
            tableRow.setWeightSum(3.0f);
            for (int i4 = 0; i4 < 3; i4++) {
                TextView textView = new TextView(getContext());
                textView.setGravity(17);
                textView.setLayoutParams(getItemParams());
                textView.setTextColor(this.f57480c);
                textView.setTextSize(2, this.f57481d);
                textView.setText(String.valueOf(i2));
                textView.setClickable(true);
                setClickFeedback(textView);
                textView.setOnClickListener(new View.OnClickListener() { // from class: org.npci.upi.security.pinactivitycomponent.Keypad.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Keypad.this.f57482e != null) {
                            Keypad.this.f57482e.a(view, i2 + 7);
                        }
                    }
                });
                tableRow.addView(textView);
                i2++;
            }
            addView(tableRow);
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.ic_action_backspace);
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_INSIDE;
        imageView.setScaleType(scaleType);
        imageView.setAdjustViewBounds(true);
        TableRow.LayoutParams itemParams = getItemParams();
        itemParams.height = (int) (a(this.f57478a) * 1.2f);
        imageView.setLayoutParams(itemParams);
        imageView.setClickable(true);
        setClickFeedback(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: org.npci.upi.security.pinactivitycomponent.Keypad.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Keypad.this.f57482e != null) {
                    Keypad.this.f57482e.a(view, 67);
                }
            }
        });
        TextView textView2 = new TextView(getContext());
        textView2.setLayoutParams(getItemParams());
        textView2.setGravity(17);
        textView2.setText(String.valueOf(0));
        textView2.setTextColor(this.f57480c);
        textView2.setTextSize(2, this.f57481d);
        textView2.setClickable(true);
        setClickFeedback(textView2);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: org.npci.upi.security.pinactivitycomponent.Keypad.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Keypad.this.f57482e != null) {
                    Keypad.this.f57482e.a(view, 7);
                }
            }
        });
        ImageView imageView2 = new ImageView(getContext());
        imageView2.setImageResource(R.drawable.ic_action_submit);
        imageView2.setScaleType(scaleType);
        imageView2.setAdjustViewBounds(true);
        TableRow.LayoutParams itemParams2 = getItemParams();
        itemParams2.height = (int) (a(this.f57478a) * 1.1f);
        imageView2.setLayoutParams(itemParams2);
        imageView2.setClickable(true);
        setClickFeedback(imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: org.npci.upi.security.pinactivitycomponent.Keypad.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Keypad.this.f57482e != null) {
                    Keypad.this.f57482e.a(view, 66);
                }
            }
        });
        TableRow tableRow2 = new TableRow(getContext());
        tableRow2.setLayoutParams(layoutParams);
        tableRow2.setWeightSum(3.0f);
        tableRow2.addView(imageView);
        tableRow2.addView(textView2);
        tableRow2.addView(imageView2);
        addView(tableRow2);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Keypad, 0, 0);
        this.f57479b = typedArrayObtainStyledAttributes.getColor(R.styleable.Keypad_keypad_bg_color, getContext().getColor(R.color.npci_keypad_bg_color));
        this.f57480c = typedArrayObtainStyledAttributes.getColor(R.styleable.Keypad_key_digit_color, getContext().getColor(R.color.npci_key_digit_color));
        this.f57481d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Keypad_key_digit_size, 33);
        this.f57478a = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Keypad_key_digit_height, this.f57478a);
        typedArrayObtainStyledAttributes.recycle();
    }
}
