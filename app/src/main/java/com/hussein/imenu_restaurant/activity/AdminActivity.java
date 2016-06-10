package com.hussein.imenu_restaurant.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hussein.imenu_restaurant.R;
import com.hussein.imenu_restaurant.model.Admin;
import com.hussein.imenu_restaurant.model.Item;
import com.hussein.imenu_restaurant.model.Menu;
import com.hussein.imenu_restaurant.model.Restaurant;
import com.hussein.imenu_restaurant.model.Section;
import com.hussein.imenu_restaurant.model.UserSpec;
import com.hussein.imenu_restaurant.service.AddAdmin;
import com.hussein.imenu_restaurant.service.AddUpdateRestaurant;
import com.hussein.imenu_restaurant.service.AddUserSpecService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdminActivity extends AppCompatActivity {

    Restaurant KFC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Toolbar toolbar = (Toolbar) findViewById(R.id.admin_toolbar);
        setSupportActionBar(toolbar);

        Button addRestaurantButton = (Button) findViewById(R.id.add_restaurants_button);
        addRestaurantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Restaurant> restaurants = createRestaurants();
                for (int i = 0; i < restaurants.size(); i++)
                    new AddUpdateRestaurant(AdminActivity.this, restaurants.get(i),true).execute();
//                new AddUpdateRestaurant(AdminActivity.this, KFC,false).execute();
            }
        });

        final Button addUserSpecsButton = (Button) findViewById(R.id.add_userspecs_button);
        addUserSpecsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<UserSpec> userSpecs= createUserSpecs();
                for(int i=0;i<userSpecs.size();i++)
                    new AddUserSpecService(AdminActivity.this,userSpecs.get(i)).execute();
            }
        });
        Button addAdmin = (Button) findViewById(R.id.add_admin);
        addAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("AdminActivity", "add admin");
                Admin admin = new Admin("AbdelRahman","abdo@gmail.com","11111",KFC);
                new AddAdmin(AdminActivity.this,admin).execute();
            }
        });

    }

    //TODO options menu to be configured
//    @Override
//    public boolean onCreateOptionsMenu(android.view.Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.template_menu, menu);
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle item selection
//        switch (item.getItemId()) {
//            case R.id.action_profile:
//                GetUserByEmailService getUserByEmailService = new GetUserByEmailService(this,true);
//                getUserByEmailService.execute();
//                return true;
//
//            case R.id.action_logout:
//                LogoutDialog logoutDialog = new LogoutDialog(this);
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
    private void addEmployees(){

    }
    private List<Restaurant> createRestaurants() {
        List<Restaurant> restaurants = new ArrayList<Restaurant>();

        Restaurant restaurant_kfc= new Restaurant("KFC","Fast food","KFC Cairo",
                "https://marketing.otlob.com/images/nl/otlob/kfcL.png",
                null,null);

        Menu menu = new Menu();

        String names[] = {"Mighty Bucket Meal","Mighty Popcorn Meal","My Meal","Super Snack Meal","Super Snack Meal",
                "Dinner Box","Dinner Box","Extra Chicken Piece"};
        String urls[]={"https://assets.otlob.com/dynamic/images/products/62/62574_1453380791_ma.png",
                "https://assets.otlob.com/dynamic/images/products/62/62579_1453380790_ma.png",
                "https://assets.otlob.com/dynamic/images/products/62/62580_1453387656_ma.jpg",
                "https://assets.otlob.com/dynamic/images/products/62/62587_1453387656_ma.jpg",
                "https://assets.otlob.com/dynamic/images/products/62/62588_1442482035_ma.jpg",
                "https://assets.otlob.com/dynamic/images/products/62/62612_1448372552_ma.jpg",
                "https://assets.otlob.com/dynamic/images/products/62/62613_1448372552_ma.jpg",
                "https://assets.otlob.com/dynamic/images/products/62/62614_1453381076_ma.jpg",
        };        double prices[] ={48.18,50.00,10.45,23.64,18.64,31.82,39.54,9.54};
        String descriptions[]={"2 pieces chicken + 3 pieces chicken strips + small French fries + small coleslaw salad + bun + garlic mayonnaise sauce + dynamite sauce + soft drink",
                "2 pieces chicken + 2 pieces chicken strips + 10 popcorn + small French fries + small coleslaw salad + bun + garlic mayonnaise sauce + dynamite sauce + soft drink",
                "one chicken piece, served with small French fries + 2 bun bread",
                "2 pieces chicken, served with large rice + small French fries + bun",
                "2 pieces fried chicken + small French fries + bun",
                "3 pieces fried chicken + small French fries + coleslaw salad + bun",
                "3 pieces fried chicken + medium French fries + coleslaw salad + bun",
                ""};
        ArrayList<String> keywords[] = new ArrayList[]{new ArrayList<String>(Arrays.asList("chicken", "strips", "fries",
                "coleslaw", "salad", "bun", "garlic mayonnaise sauce", "dynamite sauce", "drink", "bread", "KFC")),
                new ArrayList<String>(Arrays.asList("chicken","strips","popcorn","fries","coleslaw","bun","garlic mayonnaise sauce","dynamite sauce","drink","bread", "KFC")),
                new ArrayList<String>(Arrays.asList("farkha","one piece","fries","bun","bread", "KFC")),
                new ArrayList<String>(Arrays.asList("chicken","2 pieces","rice","large rice","fries","bun","bread", "KFC")),
                new ArrayList<String>(Arrays.asList("samira","2 pieces","fries","bun","bread", "KFC")),
                new ArrayList<String>(Arrays.asList("chicken","3 pieces","fries","small fries","coleslaw","salad","bun","bread", "KFC")),
                new ArrayList<String>(Arrays.asList("samira","4 pieces","fries","small fries","coleslaw","salad","bun","bread", "KFC")),
                new ArrayList<String>(Arrays.asList("chicken","3 pieces","fries","medium fries","coleslaw","salad","bun","bread", "KFC"))
        };

        ArrayList<Item> items = new ArrayList<Item>();
        for (int i=0;i<names.length;i++) {
            items.add(new Item(names[i],"KFC", "chicken", prices[i], descriptions[i], keywords[i], urls[i]));
        }

        Section section = new Section("Chicken",items);

        menu.addSection(section);

        String names2[] = {" Crispy Strips Light Meal","Crispy Strips Meal","Crispy Strips Meal","Crispy Strips Piece"};
        String urls2[] = {"https://assets.otlob.com/dynamic/images/products/62/62863_1453381191_ma.png",
                "https://assets.otlob.com/dynamic/images/products/62/62864_1453381190_ma.png",
                "https://assets.otlob.com/dynamic/images/products/62/62865_1453381352_ma.png",
                "https://assets.otlob.com/dynamic/images/products/62/62866_1453383366_ma.png"};

        double prices2[] ={18.64,31.82,39.54,6.82};
        String descriptions2 []={"3 pieces crispy strips + small French fries + bun",
                "5 pieces crispy strips + small French fries + coleslaw salad + bun",
                "5 pieces crispy strips + medium French fries + coleslaw salad + bun + soft drink", null};
        ArrayList<String> keyworkds2[] = new ArrayList[]{ new ArrayList<String>(Arrays.asList("chicken","strips","crispy",
                "crispy strips","fries","small fries","bun","bread")),
                new ArrayList<String>(Arrays.asList("chicken","strips","crispy","fries","coleslaw","bun","small fries","5 pieces","bread")),
                new ArrayList<String>(Arrays.asList("chicken","5 pieces","crispy","bun","bread","fries","small fries")),
                null,
        };

        ArrayList<Item> items2 = new ArrayList<Item>();
        Section section2 = new Section("Crispy",items2);
        menu.addSection(section2);
        restaurant_kfc.addMenu(menu);

//        Chef chef = new Chef("Mohamed","mohamed@gmail.com","34567",restaurant_kfc);
//        Waiter waiter = new Waiter("Ahmed","ahmed@gmail.com","12345",restaurant_kfc);
//        Cashier cashier = new Cashier("Amr","Amr@gmail.com","5678",restaurant_kfc);
//        Manager manager = new Manager ("Yasser","Yasser@gmail.com","148952",restaurant_kfc);
//
//        List<ServiceTable> serviceTables = new ArrayList<ServiceTable>();
//        ServiceTable serviceTable1 = new ServiceTable(restaurant_kfc,waiter,1);
//        ServiceTable serviceTable2 = new ServiceTable(restaurant_kfc,waiter,1);
//        ServiceTable serviceTable3 = new ServiceTable(restaurant_kfc,waiter,1);
//        ServiceTable serviceTable4 = new ServiceTable(restaurant_kfc,waiter,1);
//        ServiceTable serviceTable5 = new ServiceTable(restaurant_kfc,waiter,1);
//
//        serviceTables.add(serviceTable1);
//        serviceTables.add(serviceTable2);
//        serviceTables.add(serviceTable3);
//        serviceTables.add(serviceTable4);
//        serviceTables.add(serviceTable5);
//
//        restaurant_kfc.setChef(chef);
//        restaurant_kfc.setCashier(cashier);
//        restaurant_kfc.setManager(manager);
//        restaurant_kfc.setServiceTables(serviceTables);

        KFC=restaurant_kfc;
//        KFC.setWaiter(waiter);
        restaurants.add(restaurant_kfc);

        Restaurant restaurant_mac= new Restaurant("MAC","Fast food","MAC Cairo",
                "https://marketing.otlob.com/images/nl/otlob/mcdlogoL.png",
                null,null);
        Menu menu_mac = new Menu();
        String names_mac[] = {"Big Mac","Big Tasty","Fillet-O-Fish Sandwich","Quarter Pounder with Cheese","Double Cheeseburger Sandwich",
                "Chicken MACDO ++","Cheeseburger Sandwich +","McArabia Beans Sandwich"};
        String urls_mac[]={"https://assets.otlob.com/dynamic/images/products/60/60758_1442409163_ma.jpg",
                "https://assets.otlob.com/dynamic/images/products/60/60759_1442409162_ma.jpg",
                "https://assets.otlob.com/dynamic/images/products/60/60718_1442408805_ma.jpg",
                "https://assets.otlob.com/dynamic/images/products/60/60641_1442408011_ma.jpg",
                "https://assets.otlob.com/dynamic/images/products/60/60655_1442408008_ma.jpg",
                "https://assets.otlob.com/dynamic/images/products/97/97923_1442410681_ma.jpg",
                "https://assets.otlob.com/dynamic/images/products/97/97924_1442410680_ma.jpg",
                "https://assets.otlob.com/dynamic/images/products/60/60642_1442408011_ma.jpg",
        };
        double prices_mac[] ={20.90,31.37,12.72,22.72,18.64,31.82,39.54,9.54};
        String descriptions_mac[]={"100% grilled beef 2 patties, special Big Mac™ sauce, cheese, crunchy lettuce, fresh onions, pickle slices, sesame seed buns",
                "Pure grilled beef patty wrapped in 3 layers of Emmental cheese covered with a special tasty sauce, crunchy lettuce, fresh tomatoes & onions all wrapped in a sesame bun",
                "Pure white fish breaded patty covered with tasty tartar sauce and a layer of cheese - all wrapped in a fresh bun",
                "Pure grilled beef patties between 2 layers of cheese covered with ketchup, mustard, fresh onions & pickles - all wrapped in a sesame seed bun",
                "Two slices of golden American cheese with two 100% all-beef patties, pickles, onions, ketchup and mustard on a toasted bun",
                "100% white meat grilled chicken breast filet covered with crunchy lettuce and tasty mayonnaise - all wrapped in a fresh bun",
                "It doesn`t get better than this.. a grilled beef patty with ketchup, mustard, pickles, onions and a cheese slice in a bun.",
                "Grilled kofta 2 patties covered with tehina sauce, fresh lettuce, tomatoes & onions all wrapped in savory Arabic bread",
        };
        ArrayList<String> keywords_mac[] = new ArrayList[]{new ArrayList<String>(Arrays.asList("Bread","Beef burger","beef","burger", "Cheese", "Lettuce", "Pickles", "Onions", "Our special sauce","sauce", "sesame", "MAC", "macdonalds")),
                new ArrayList<String>(Arrays.asList("Bread","Beef burger","beef","juicy","beef","emmental","cheese","Emmental cheese","Tomato","Lettuce","Onions","sauce", "mac", "macdonalds")),
                new ArrayList<String>(Arrays.asList("Bread","Fillet fish","fish","fillet","Tartar sauce","tartar","Cheese", "mac", "macdonalds")),
                new ArrayList<String>(Arrays.asList("Bread","Beef burger","beef","Cheese","Ketchup","Mustard","Pickles","Onions", "mac", "macdonalds")),
                new ArrayList<String>(Arrays.asList("Bread","Beef burger","beef","ketchup","mustard","onions","pickles","beef", "mac", "macdonalds")),
                new ArrayList<String>(Arrays.asList("Bread","Pork","pork","Beans","beans","Lettuce","Mayo","fresh", "MAC", "macdonalds")),
                new ArrayList<String>(Arrays.asList("Bread","Pork","pork","Burger","beef","Cheese","Ketchup","Onions","Pickles","beef", "mac", "macdonalds")),
                new ArrayList<String>(Arrays.asList("Arabic bread","Beans","beans","beef","Lettuce","Tomatoes","Onions","Garlic","bun","bread", "mac", "macdonalds"))
        };

        ArrayList<Item> items_mac = new ArrayList<Item>();
        for (int i=0;i<names.length;i++) {
            items_mac.add(new Item(names_mac[i],"MAC", "Burger", prices_mac[i], descriptions_mac[i], keywords_mac[i], urls_mac[i]));
        }
        Section section_mac = new Section("Sandwiches",items_mac);
        menu_mac.addSection(section_mac);
        restaurant_mac.addMenu(menu_mac);

        restaurants.add(restaurant_mac);

        return restaurants;
    }

    private List<UserSpec> createUserSpecs() {
        List<UserSpec> userSpecs = new ArrayList<UserSpec>();
        UserSpec halalRestriction = new UserSpec();
        halalRestriction.setName("Halal");
        halalRestriction.setNote("Take care! This is not \"Halal\" !");
        halalRestriction.setType(false);
        ArrayList<String> keywordsForHalal = new ArrayList<String>();
        keywordsForHalal.add("pork");
        keywordsForHalal.add("alcoholic");
        keywordsForHalal.add("alcohol");
        keywordsForHalal.add("wine");
        keywordsForHalal.add("beer");
        keywordsForHalal.add("ham");

        halalRestriction.setKeywords(keywordsForHalal);

        userSpecs.add(halalRestriction);

        UserSpec vegetarianRestriction = new UserSpec();
        vegetarianRestriction.setName("Vegetarian");
        vegetarianRestriction.setNote("Take care! This is not for \"Vegetarians\" !");
        vegetarianRestriction.setType(false);
        ArrayList<String> keywordsForVegetarian = new ArrayList<String>();
        keywordsForVegetarian.add("beef");
        keywordsForVegetarian.add("chicken");
        keywordsForVegetarian.add("meat");
        keywordsForVegetarian.add("pork");
        keywordsForVegetarian.add("ham");
        vegetarianRestriction.setKeywords(keywordsForVegetarian);

        userSpecs.add(vegetarianRestriction);

        UserSpec diabetesHealthIssue = new UserSpec();
        diabetesHealthIssue.setName("Diabetes");
        diabetesHealthIssue.setNote("Take care! This may not be good for you, as for its ingredients");
        diabetesHealthIssue.setType(true);
        ArrayList<String> keywordsForDiabetes = new ArrayList<String>();
        keywordsForDiabetes.add("sugar");
        diabetesHealthIssue.setKeywords(keywordsForDiabetes);

        userSpecs.add(diabetesHealthIssue);

        UserSpec favismHealthIssue = new UserSpec();
        favismHealthIssue.setName("Favism");
        favismHealthIssue.setNote("Take care! This may not be good for you, as for its ingredients");
        favismHealthIssue.setType(true);
        ArrayList<String> keywordsForFavism = new ArrayList<String>();
        keywordsForFavism.add("beans");
        keywordsForFavism.add("bean");
        favismHealthIssue.setKeywords(keywordsForFavism);

        userSpecs.add(favismHealthIssue);

        return userSpecs;
    }

}
