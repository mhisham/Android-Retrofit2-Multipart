# Android-DocumentHelper
- AppUtils to prepare file part (Multipart file)
- Document Helper class to get real path

Example of using Rerofit2:

```java
		@Multipart
    @POST("create-profile")
    Call<JsonObject> create_profile(
            @Part("full_name") RequestBody full_name,
            @Part MultipartBody.Part profileImage);
```
```java
Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BaseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
MyAPI api = retrofit.create(MyApi.class);

```

```java             
RequestBody full_name_body = RequestBody.create(okhttp3.MultipartBody.FORM, "Mohamed Hisham");
Call<JsonObject> call = Api.getInstance().create_profile(
                full_name_body,
                AppUtils.prepareFilePart(this,"image",profileImageUri))
```
