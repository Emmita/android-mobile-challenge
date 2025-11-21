package emmanuel.avila.library.gallery.impl.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import emmanuel.avila.library.gallery.api.GalleryRepository
import emmanuel.avila.library.gallery.impl.data.DefaultGalleryDataSource
import emmanuel.avila.library.gallery.impl.data.DefaultGalleryRepository
import emmanuel.avila.library.gallery.impl.data.GalleryApiService
import emmanuel.avila.library.gallery.impl.data.GalleryDataSource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object GalleryModule {
    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor { chain ->
                val request =
                    chain
                        .request()
                        .newBuilder()
                        .addHeader(CONTENT_TYPE_HEADER, CONTENT_TYPE_VALUE)
                        .build()

                chain.proceed(request)
            }.addInterceptor(
                interceptor =
                    HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    },
            ).build()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshi: Moshi,
    ): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Provides
    @Singleton
    fun provideGallerApiService(retrofit: Retrofit): GalleryApiService = retrofit.create(GalleryApiService::class.java)

    @Provides
    @Singleton
    fun provideGalleryDataSource(galleryApiService: GalleryApiService): GalleryDataSource =
        DefaultGalleryDataSource(galleryApiService = galleryApiService)

    @Provides
    @Singleton
    fun provideGalleryRepository(galleryDataSource: GalleryDataSource): GalleryRepository =
        DefaultGalleryRepository(galleryDataSource = galleryDataSource)
}

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
private const val CONTENT_TYPE_HEADER = "Content-Type"
private const val CONTENT_TYPE_VALUE = "application/json"
