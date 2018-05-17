package id.renaldirey.daggermvp.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import id.renaldirey.daggermvp.R;
import id.renaldirey.daggermvp.network.response.Response;
import id.renaldirey.daggermvp.network.response.ResponsePopular;
import id.renaldirey.daggermvp.ui.base.BaseActivity;
import id.renaldirey.daggermvp.ui.presenter.MoviePresenter;
import id.renaldirey.daggermvp.ui.view.ListMovieView;

public class MainActivity extends BaseActivity implements ListMovieView<Response<List<ResponsePopular>>> {

    @Inject
    MoviePresenter<ListMovieView> moviePresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        getData();
    }

    private void getData(){
        moviePresenter.attachView(this);
        if(moviePresenter.isViewAttached()){
            moviePresenter.getPopularMovie(1);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        moviePresenter.detachView();
        moviePresenter.destroy();
    }

    @Override
    public void showData(Response<List<ResponsePopular>> data) {
        Log.e("size data", String.valueOf(data.getResults().size()));
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public Context getContext() {
        return MainActivity.this;
    }

    @Override
    public void isError(String message) {
        Log.e("", "");
    }
}
