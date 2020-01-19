package com.decoderssquad.ekrishisheba;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.decoderssquad.ekrishisheba.fragment.Frag_One;
import com.decoderssquad.ekrishisheba.fragment.Frag_Two;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    BoomMenuButton bmb;
    ArrayList<Integer> imageIdList;
    ArrayList<String> titleList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bmb = findViewById(R.id.bmb);
        imageIdList = new ArrayList<>();
        titleList = new ArrayList<>();
        setInitialData();
        setTitle("ই-কৃষি সেবা");


        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            int position = i;
            if (position == 0) {
                TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                        .normalImageRes(imageIdList.get(i))
                        .normalText(titleList.get(i))
                        .normalTextColor(Color.BLACK)
                        .textSize(12)
                        .pieceColor(Color.WHITE)
                        .unableColor(Color.BLACK)

                        .listener(new OnBMClickListener() {
                            @Override
                            public void onBoomButtonClick(int index) {


                                Intent intent = new Intent(MainActivity.this, AjkerKrishi.class);
                                startActivity(intent);


                            }

                        });
                bmb.addBuilder(builder);
            }
//             else if (position == 1) {
//                TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
//                        .normalImageRes(imageIdList.get(i))
//                        .normalText(titleList.get(i))
//                        .normalTextColor(Color.BLACK)
//                        .textSize(12)
//
//                        .listener(new OnBMClickListener() {
//                            @Override
//                            public void onBoomButtonClick(int index) {
//
//
//                                Intent intent = new Intent(MainActivity.this,Dev.class);
//                                startActivity(intent);
//
//
//
//
//
//
//
//
//
//                                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//
//                                    ActivityCompat.requestPermissions(MainActivity.this,
//                                            new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
//
//
//

//                                    //    ActivityCompat#requestPermissions
//                                    // here to request the missing permissions, and then overriding
//                                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                                    //                                          int[] grantResults)
//                                    // to handle the case where the user grants the permission. See the documentation
//                                    // for ActivityCompat#requestPermissions for more details.
//                                }
//                                else {
//                                    Intent myIntent = new Intent(Intent.ACTION_CALL);
//                                    String phNum = "tel:" + "01771625252";
//                                    myIntent.setData(Uri.parse(phNum));
//                                    startActivity(myIntent);
//                                }
//
//
//                            }
//
//                        });
//                bmb.addBuilder(builder);
//            }

            else if (position == 1) {
                TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                        .normalImageRes(imageIdList.get(i))
                        .normalText(titleList.get(i))
                        .normalTextColor(Color.BLACK)
                        .textSize(12)

                        .listener(new OnBMClickListener() {
                            @Override
                            public void onBoomButtonClick(int index) {


                                finish();


                            }

                        });
                bmb.addBuilder(builder);
            }


        }


        ViewPager viewPager = findViewById(R.id.pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add Fragments to adapter one by one
        adapter.addFragment(new Frag_One(), "Recent");
        adapter.addFragment(new Frag_Two(), "Category");





        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }


    // Adapter for the viewpager using FragmentPagerAdapter
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    private void setInitialData() {

        imageIdList.add(R.drawable.about);
       // imageIdList.add(R.drawable.de);
        imageIdList.add(R.drawable.ex);

        titleList.add("About");
       // titleList.add("Developer");
        titleList.add("Exit");

    }
}