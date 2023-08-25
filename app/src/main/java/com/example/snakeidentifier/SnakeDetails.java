package com.example.snakeidentifier;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SnakeDetails extends AppCompatActivity {

    String snake_name;

    String Russell_viper = "Russell’s viper (Daboia russelii) (Sinhala: Thith Polanga/ " +
            "Tamil: Kannadi viriyan)\n\n" +
            "• Russell’s Viper (Daboia russelli): Russell’s Viper, also known as “Tith Polonga” in " +
            "Sinhala and “Kannadi Virian” in Tamil, is a highly venomous snake found in Sri " +
            "Lanka\n\n" +
            "• Russell’s vipers live in a wide range of environments, including forests, grasslands, " +
            "and agricultural regions.\n\n" +
            "• They ambush hunters and eat small mammals, birds, and reptiles.\n\n" +
            "• These are very famous for their unique moving style, which is known to form an ‘S’ " +
            "shape while moving.\n\n" +
            "• Can grow to a maximum length of 166cm.\n\n" +
            "• They do come out more during the cooler seasons of Sri Lanka.\n\n" +
            "• The Russell’s Viper has an arrow-shaped, pointed head, while the python, too, has a " +
            "triangular-shaped head, but a blunt snout.";

    String Russell_viper_topic = "Russell’s viper (Thith Polanga)";
    String Russell_viper_scientific_name = "Daboia russelii";



    String SL_Cobra = "• Sri Lankan Cobra (Naja polyoccelata; Naja naja) Sinhala:" +
            "Nagaya; Tami: Nalla pambu\n\n" +
            "• Cobra (Naja Naja): The cobra, known as “Naya” in Sinhala and “Nalla" +
            "Pambu” in Tamil.\n\n" +
            "• Cobras are found on plantations and in home gardens, forests, grasslands, and" +
            "paddy fields.\n\n" +
            "• The Hood has a spectacle marking on the dorsal side and has two black spots, and" +
            "the neck usually has three black bands on the ventral side.\n\n" +
            "• They are known to be active hunters and eat small animals, birds, and reptiles.";

    String SL_Cobra_topic = "Cobra (Nagaya)";
    String SL_Cobra_scientific_name = "Naja polyoccelata";



    String Saw_scaled_viper = "Saw-scaled viper (Echis carinatus), Sinhala: Weli " +
            "Polanga; Tamil: Surutai Viriyan\n\n" +
            "• One of the most dangerous snakes in the country.\n\n" +
            "• This snake grows up to 40-50cm.\n\n" +
            "• This viper can be found mostly in coastal areas, and also in the arid zone.\n\n" +
            "• It is restricted to dry coastal regions such as Mannar, Puttalam, the Jaffna" +
            "peninsula, and Batticaloa. In Sri Lanka.\n\n" +
            "• They are identifiable by the pattern on their heads, which resembles a bird’s" +
            "footprint. The sides of their bodies display a lateral zig-zag pattern.";

    String Saw_scaled_viper_topic = "Saw-scaled viper (Weli Polanga)";
    String Saw_scaled_viper_scientific_name = "Echis carinatus";



    String  Common_Krait = "• Common Krait (Bungarus caeruleus): The Common Krait, known as “Thel" +
            "Karawalaya” in Sinhala and “Katu Viriyan” in Tamil.\n\n" +
            "• The Common Krait is the most dangerous land snake in Sri Lanka.\n\n" +
            "• The average length is around 90 cm. Generally black or bluish-black color.\n\n" +
            "• The Sri Lankan krait lives in a wide variety of ecosystems, including forests," +
            "grasslands, and agricultural regions.\n\n" +
            "• The body shines just like oil on it. Likes to wander near water bodies.\n\n";

    String Common_Krait_viper_topic = " Common Krait (Thel Karawalaya)";
    String Common_Krait_scientific_name = "Bungarus caeruleus";



    String  SL_Krait = "• Sri Lankan Krait (Bungarus ceylonicus): The Sri Lankan Krait, also known as “Dhunu" +
            "Karawalaya” in Sinhala and “Yettadi Virian” in Tamil.\n\n" +
            "• Commonly found in hilly areas such as Kandy, Gampola, and Balangoda.\n\n" +
            "• Most traits are similar to Common Kraits. But a little smaller in size (average 75cm).\n\n" +
            "• The most highlighted trait of this snake is the prominent white band pattern that can" +
            "be seen on the skin.";

    String SL_Krait_viper_topic = " Sri Lankan Krait (Dhunu Karawalaya)";
    String SL_Krait_scientific_name = "Bungarus ceylonicus";



    String  HM_Pitviper = "• Although not on the original list of five highly venomous snakes on land, the hump nosed pit viper (Hypnale hypnale) is now considered highly venomous.\n\n" +
            "• These vipers can grow up to about 1–1.5 feet.\n\n" +
            "• It has a small, pointy, arrow-shaped head, with an elongated nose. It is often found " +
            "coiled up, its head at a 45-degree angle from the ground.\n\n" +
            "• They are commonly distributed in forest/rainforest areas, as well as in suburbs (in the " +
            "West, around Homagama, Kottawa, and beyond) and are usually found amidst leaf " +
            "litter.\n\n" +
            "• Has an average length of 30-45 cm.\n\n" +
            "• If you ever see a hump–nosed viper vibrating its tail, better to step back. Because it’s a " +
            "sign that it’s annoyed.";

    String HM_Pitviper_viper_topic = " hump nosed pit viper";
    String HM_Pitviper_scientific_name = "Hypnale hypnale";
/*
    public  void  openSeeMore(){
        Intent intent = new Intent(SnakeDetails.this, MainActivity.class);
        startActivity(intent);
    }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snake_details);
        getSupportActionBar().hide();

        TextView snakeName = findViewById(R.id.snake_name);
        ImageView snakeImage = findViewById(R.id.snake_image);
        TextView snakeNameTopic = findViewById(R.id.snake_name_topic);
        TextView snakeNameScientificName = findViewById(R.id.snake_scientific_name);
        TextView snakeDescription = findViewById(R.id.textViewDescription);
        ImageView seeMore = findViewById(R.id.see_more);

        Intent intent = getIntent();
        snake_name  = intent.getStringExtra("snakeName");
        String responseJson = intent.getStringExtra("response");


        byte[] byteArray = intent.getByteArrayExtra("imageByteArray");

        // Convert the byte array back to a Bitmap image

        try {
            Bitmap imageBitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            snakeImage.setImageBitmap(imageBitmap);

        }catch (Exception e){
            e.printStackTrace();
        }


        try {
                if (snake_name.equals("Russell's Viper")) {
                    snakeDescription.setText(Russell_viper);
                    snakeName.setText(" Thith Polanga");
                    snakeImage.setImageResource(R.drawable.thith_polaga);
                    snakeNameTopic.setText(Russell_viper_topic);
                    snakeNameScientificName.setText(Russell_viper_scientific_name);

                }else if (snake_name.equals("Nagaya")){
                    snakeDescription.setText(SL_Cobra);
                    snakeName.setText("Nagaya");
                    snakeImage.setImageResource(R.drawable.cobra);
                    snakeNameTopic.setText(SL_Cobra_topic);
                    snakeNameScientificName.setText(SL_Cobra_scientific_name);

                }else if (snake_name.equals("veliPolanga")){
                    snakeDescription.setText(Saw_scaled_viper);
                    snakeName.setText(" veli Polanga");
                    snakeImage.setImageResource(R.drawable.vele_polaga);
                    snakeNameTopic.setText(Saw_scaled_viper_topic);
                    snakeNameScientificName.setText(Saw_scaled_viper_scientific_name);

                }else if (snake_name.equals("thelKarawalaya")){
                    snakeDescription.setText(Common_Krait);
                    snakeName.setText("Thel Karawalaya");
                    snakeImage.setImageResource(R.drawable.karavalaya_2);
                    snakeNameTopic.setText(Common_Krait_viper_topic);
                    snakeNameScientificName.setText(Common_Krait_scientific_name);

                }else if (snake_name.equals("dhunuKarawalaya")){
                    snakeDescription.setText(SL_Krait);
                    snakeName.setText("DhunuKarawalaya");
                    snakeImage.setImageResource(R.drawable.karavalaya);
                    snakeNameTopic.setText(SL_Krait_viper_topic);
                    snakeNameScientificName.setText(SL_Krait_scientific_name);

                }else if (snake_name.equals("humpNoseViper")){
                    snakeDescription.setText(HM_Pitviper);
                    snakeName.setText("Hump Noseed Viper");
                    snakeImage.setImageResource(R.drawable.hm_viper);
                    snakeNameTopic.setText(HM_Pitviper_viper_topic);
                    snakeNameScientificName.setText(HM_Pitviper_scientific_name);

                }else if (snake_name.equals("non venomous")){
                    snakeDescription.setText("Non Venomous Snake");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        try {

            JsonObject responseObj = JsonParser.parseString(responseJson).getAsJsonObject();

            String name = responseObj.get("class_label").getAsString();

            if (name.equals("Russell's Viper")) {
                snakeDescription.setText(Russell_viper);
                snakeName.setText(" Thith Polanga");
                //snakeImage.setImageResource(R.drawable.thith_polaga);
                snakeNameTopic.setText(Russell_viper_topic);
                snakeNameScientificName.setText(Russell_viper_scientific_name);

            }else if (name.equals("Cobra")){
                snakeDescription.setText(SL_Cobra);
                snakeName.setText("Nagaya");
                //snakeImage.setImageResource(R.drawable.cobra);
                snakeNameTopic.setText(SL_Cobra_topic);
                snakeNameScientificName.setText(SL_Cobra_scientific_name);

            }else if (name.equals("saw- scaled viper")){
                snakeDescription.setText(Saw_scaled_viper);
                snakeName.setText(" veli Polanga");
                //snakeImage.setImageResource(R.drawable.vele_polaga);
                snakeNameTopic.setText(Saw_scaled_viper_topic);
                snakeNameScientificName.setText(Saw_scaled_viper_scientific_name);

            }else if (name.equals("Common Krait")){
                snakeDescription.setText(Common_Krait);
                snakeName.setText("Thel Karawalaya");
                //snakeImage.setImageResource(R.drawable.karavalaya_2);
                snakeNameTopic.setText(Common_Krait_viper_topic);
                snakeNameScientificName.setText(Common_Krait_scientific_name);

            }else if (name.equals("krait Bungarus ceylonicus")){
                snakeDescription.setText(SL_Krait);
                snakeName.setText("DhunuKarawalaya");
                //snakeImage.setImageResource(R.drawable.karavalaya);
                snakeNameTopic.setText(SL_Krait_viper_topic);
                snakeNameScientificName.setText(SL_Krait_scientific_name);

            }else if (name.equals("hump - nosed pit viper")){
                snakeDescription.setText(HM_Pitviper);
                snakeName.setText("Hump Nosed Viper");
                //snakeImage.setImageResource(R.drawable.hm_viper);
                snakeNameTopic.setText(HM_Pitviper_viper_topic);
                snakeNameScientificName.setText(HM_Pitviper_scientific_name);

            }else{
                snakeDescription.setText("Non Venomous Snake");
                snakeName.setText("Non Venomous Snake");
            }
            // Update TextViews here with the parsed data
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}