    package com.example.collegefinder.Utilities;

    import com.example.collegefinder.Model.ResponseModel;

    import java.util.List;

    import retrofit2.Call;
    import retrofit2.http.GET;

    public interface apiset {
        @GET("college.php")
        Call<List<ResponseModel>> getData();
    }
