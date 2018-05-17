package id.renaldirey.daggermvp.network.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kwikku on 13/05/2018.
 */

public class Response<T> {
    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int total_results;
    @SerializedName("total_pages")
    private int total_pages;
    @SerializedName("results")
    private T results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
