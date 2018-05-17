package id.renaldirey.daggermvp.ui.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import butterknife.ButterKnife;
import id.renaldirey.daggermvp.App;
import id.renaldirey.daggermvp.di.component.ActivityComponent;
import id.renaldirey.daggermvp.di.component.DaggerActivityComponent;
import id.renaldirey.daggermvp.di.module.ActivityModule;

/**
 * Created by Kwikku on 13/05/2018.
 */

public class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((App) getApplication()).getApplicationComponent()).build();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        injectViews();
    }

    protected void injectViews() {
        ButterKnife.inject(this);
    }

    public void setContentViewWithoutInject(int layoutResId) {
        super.setContentView(layoutResId);
    }

    protected void setTransparentStatusBar() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        // set flags
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    public void setActivityComponent(ActivityComponent activityComponent) {
        this.activityComponent = activityComponent;
    }
}
