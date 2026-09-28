package org.npci.upi.security.pinactivitycomponent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes5.dex */
public class UserAuthInfoActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_auth_info);
        findViewById(R.id.settings_button).setOnClickListener(new View.OnClickListener() { // from class: org.npci.upi.security.pinactivitycomponent.UserAuthInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserAuthInfoActivity.this.startActivity(new Intent("android.settings.SETTINGS"));
            }
        });
        findViewById(R.id.image_back).setOnClickListener(new View.OnClickListener() { // from class: org.npci.upi.security.pinactivitycomponent.UserAuthInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserAuthInfoActivity.this.finish();
            }
        });
    }
}
