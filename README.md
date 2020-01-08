# Slider Image Arrow
This is a simple image slider in android with images as a thumbnails,
It uses simple viewpager and recyclerview to display images in collapsible toolbar.

This library supports AndroidX

# DEMO
![Alt text](https://github.com/sunnag7/SampleSlider/blob/master/demo.gif?raw=true "Working")

#Integration Guide
```xml
    <androidx.constraintlayout.widget.ConstraintLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".SliderSampleActivity">
    
        <com.felipepalma14.sliderimagearrow.view.SliderView
            android:id="@+id/sliderView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent">
    
        </com.felipepalma14.sliderimagearrow.view.SliderView>
    </androidx.constraintlayout.widget.ConstraintLayout>
 ```
 
# Slider Adapter
```java
    public class SliderAdapterExample extends SliderViewAdapter<SliderAdapterExample.SliderAdapterViewHolder> {
        
            private List<String> photoList;
        
            public SliderAdapterExample(List<String> photoList) {
                this.photoList = photoList;
            }
        
            @Override
            public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
                @SuppressLint("InflateParams") View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_slider, null);
                return new SliderAdapterViewHolder(inflate);
            }
        
            @Override
            public void onBindViewHolder(SliderAdapterViewHolder viewHolder, int position) {
        
                Glide.with(viewHolder.itemView)
                        .load(photoList.get(position))
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(viewHolder.backgroundImageView);
            }
        
            @Override
            public int getCount() {
                return photoList.size();
            }
        
        
            class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {
        
                View itemView;
                ImageView backgroundImageView;
        
                SliderAdapterViewHolder(View itemView) {
                    super(itemView);
                    backgroundImageView = itemView.findViewById(R.id.iv_auto_image_slider);
                    this.itemView = itemView;
                }
            }
        }
        
    
```
# Set the adapter to the Sliderview

```java
    sliderView.setSliderAdapter(new SliderAdapterExample(context));
```

# In Activity
```java
    public class SliderSampleActivity extends AppCompatActivity {
    
        SliderView sliderView;
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_slider_sample);
    
            sliderView = findViewById(R.id.sliderView);
            List<String> images =  Arrays.asList( getResources().getStringArray(R.array.user_photos));
            final SliderAdapterExample adapter  = new SliderAdapterExample(images);
    
            sliderView.setSliderAdapter(adapter);
    
    
        }
    }
```
# Change thumbnails lines color 
```xml
    <color name="colorAccent">#ccb3ff</color>
```