package com.project.foodApp.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.foodApp.BusinessBeans.Item;

@Repository
public class MainResourceDaoImpl implements MainResourceDao {


	public List<Item> getBreakfast() throws Exception {
		// TODO Auto-generated method stub
		List<Item> breakfast = new ArrayList<Item>();
		breakfast.add(new Item(121101,"Breakfast","veg","Masala Dosa",85,4.2,308,"/images/breakfast/dosa.jpeg","Masala Dosa",
				"Dosa topped with aloo masala. Served with Spiced Sambar, coconut chutney & Spl chutney of the day","customizable"));
		breakfast.add(new Item(121102,"Breakfast","veg","Set Dosa",85,4.4,128,"/images/breakfast/set dosa.jpeg","Set Dosa",
				"Serves 1| A set of 3 dosas ,the perfect start to any day!","customizable"));
		breakfast.add(new Item(121103,"Breakfast","veg","Onion Dosa",120,4.0,50,"/images/breakfast/onion.jpeg","Onion Dosa",
				"Serves 1| Crispy and delicious dosa topped with onions","customizable"));
		breakfast.add(new Item(121104,"Breakfast","veg","Plain Dosa",70,4.4,91,"/images/breakfast/plaindosa.jpg","Plain Dosa",
				"Serves 1| Irrestibily crispy dosa cooked to perfection served with chutney and sambar","customizable"));
		breakfast.add(new Item(121105,"Breakfast","veg","Idli(2)",50,4.4,239,"/images/breakfast/idly.jpg","Idly(2)",
				"Serves 1| Super-soft steamed rice cakes,the perfectly healthy option!","not customizable"));
		breakfast.add(new Item(121106,"Breakfast","veg","Poori",90,4.2,73,"/images/breakfast/poori.jpeg","Poori",
				"Serves 1| A set of 3 Poori ,the perfect start to any day!","not customizable"));
		breakfast.add(new Item(121107,"Breakfast","veg","(2)Idli(2)Vada",95,4.4,204,"/images/breakfast/idlyvada2.jpeg","(2)Idli(2)Vada",
				"Serves 1| A set of 2 Idly and 2 Vada","not customizable"));
		breakfast.add(new Item(121108,"Breakfast","veg","Vada(2)",70,4.4,117,"/images/breakfast/vada.jpeg","Vada(2)",
				"Serves 1| A deliciously hearty combo with 1 irrestibly crispy vada served with sambar and chutney","not customizable"));
		breakfast.add(new Item(121109,"Breakfast","veg","Upma",95,4.4,114,"/images/breakfast/upma.jpeg","Upma",
				"Serves 1| Upma","not customizable"));
		System.out.println(breakfast);
		return breakfast;
	}
	
	public List<Item> getPureVeg() throws Exception {
		// TODO Auto-generated method stub
		List<Item> pureVeg = new ArrayList<Item>();
		pureVeg.add(new Item(131101,"PureVeg","veg","South Indian Meal",129,4.5,1118,"/images/pureVeg/southIndianMeal.jpg","South Indian Meal",
				"Steam rice, chapati (1 pc), kurma, palya, rasam, sambar or dal, curd rice, sweet, papad","customizable"));
		pureVeg.add(new Item(131102,"PureVeg","veg","North Indian Kulcha Meal",158,4.4,997,"/images/pureVeg/northIndianKulchaMeal.jpg","North Indian kulcha Meal",
				"Steam rice, chapati (1 pc), kurma, palya, rasam, sambar or dal, curd rice, sweet, papad","customizable"));
		pureVeg.add(new Item(131103,"PureVeg","veg","North Indian Naan Meal",158,4.2,689,"/images/pureVeg/northIndianNaanMeal.jpg","North Indian Naan Meal",
				"Steam rice, chapati (1 pc), kurma, palya, rasam, sambar or dal, curd rice, sweet, papad","customizable"));
		pureVeg.add(new Item(131104,"PureVeg","veg","North Indian Roti Meal",158,4.3,956,"/images/pureVeg/northIndianRotiMeal.jpg","North Indian Roti Meal",
				"Tomato soup, naan, dal, curry, pulao, curd rice, sweet, papad","customizable"));
		pureVeg.add(new Item(131105,"PureVeg","veg","Curd Rice",158,4.5,996,"/images/pureVeg/CurdRice.jpg","Curd Rice",
				"Heritage Curd rice with fruits garnished","customizable"));
		pureVeg.add(new Item(131106,"pureVeg","veg","Kulcha Curry",109,4.2,996,"/images/pureVeg/KulchaCurry.jpg","Kulcha Curry",
				"Kulcha,dal,curry,salad","customizable"));
		pureVeg.add(new Item(131107,"PureVeg","veg","Naan Curry",109,4.2,986,"/images/pureVeg/NaanCurry.jpg","Naan Curry",
				"Naan,dal,curry,salad","customizable"));
		pureVeg.add(new Item(131108,"PureVeg","veg","Roti Curry",109,4.4,1012,"/images/pureVeg/RotiCurry.jpg","Roti Curry",
				"Roti(2 pcs),dal,curry,salad","customizable"));
		pureVeg.add(new Item(131109,"PureVeg","veg","Kulcha",49,4.2,588,"/images/pureVeg/Kulcha.jpg","Kulcha",
				"Crispy Kulcha","customizable"));
		pureVeg.add(new Item(131110,"PureVeg","veg","Naan",49,4.2,488,"/images/pureVeg/Naan.jpg","Naan",
				"Crispy Naan","customizable"));
		pureVeg.add(new Item(131111,"PureVeg","veg","Roti[2 Pcs]",49,4.2,488,"/images/pureVeg/Roti.jpg","Roti",
				"Crispy Roti 2 pcs","customizable"));
		System.out.println(pureVeg);
		return pureVeg;
	}
	
	public List<Item> getRefreshments() throws Exception {
		// TODO Auto-generated method stub
		List<Item> refreshments = new ArrayList<Item>();
		refreshments.add(new Item(141101,"Refreshments","veg","Buttermilk(300ml)",39,4.5,111,"/images/refreshments/buttermilk.jpg","Butter Milk",
				"Serves 1 | buttermilk 300ml","customizable"));
		refreshments.add(new Item(141102,"Refreshments","veg","Cold Badam Milk(300ml)",65,4.4,256,"/images/refreshments/coldBadamMilk.jpg","Cold Badam Milk",
				"Serves 1 | cold badam milk 300ml","customizable"));
		refreshments.add(new Item(141103,"Refreshments","veg","Pulpy Grape(300ml)",55,4.2,129,"/images/refreshments/PulpyGrape.jpg","Pulpy Grape",
				"Serves 1 | Pulpy Grape 300ml","customizable"));
		refreshments.add(new Item(141104,"Refreshments","veg","Sweet Lassi",55,4.3,426,"/images/refreshments/sweetLassi.jpg","Sweet Lassi",
				"Serves 1 | Sweet Lassi 300ml","customizable"));
		refreshments.add(new Item(141105,"Refreshments","veg","Oreo Milkshake",99,4.5,143,"/images/refreshments/oreoMilkshake.jpg","Oreo Milkshake",
				"Serves 1 | Oreo milkshake","customizable"));
		System.out.println(refreshments);
		return refreshments;
	}

	@Override
	public List<Item> getStarters() throws Exception {
		// TODO Auto-generated method stub
		List<Item> starters = new ArrayList<Item>();
		starters.add(new Item(151101,"Starters(Veg&NonVeg)","veg","Baby Corn Manchurian(dry)",95,4.5,123,"/images/starters/babyCornManchurian.jpg","Baby Corn Manchurian",
				"Served with tomato sauce(no artificial colours, ajinomoto, msg and its chemical free).","customizable"));
		starters.add(new Item(151102,"Starters(Veg&NonVeg)","nonveg","Chilly Chicken(Boneless)",320,4.9,1023,"/images/starters/chillyChicken.jpg","Chilly Chicken",
				"370 gram | Serves 1 | [Energy: 604.42 kcal, Protein: 50.63g, Carbohydrates: 29.67g, Fat: 30.94g]","customizable"));
		starters.add(new Item(151103,"Starters(Veg&NonVeg)","veg","Gobi Manchurian(dry)",89,4.5,123,"/images/starters/GobiManchurian.jpg","Gobi Manchurian",
				"Served with tomato sauce(no artificial colours, ajinomoto, msg and its chemical free).","customizable"));
		starters.add(new Item(151104,"Starters(Veg&NonVeg)","veg","Mushroom Manchurian(dry)",99,4.5,123,"/images/starters/MushroomManchurian.jpg","Mushroom Manchurian",
				"Served with tomato sauce(no artificial colours, ajinomoto, msg and its chemical free).","customizable"));
		starters.add(new Item(151105,"Starters(Veg&NonVeg)","nonveg","Royals Chicken 555",325,4.9,1023,"/images/starters/royalsChicken555.jpg","Royals Chicken 555",
				"300 gram | Serves 1 | [Energy: 585.13 kcal, Protein: 32.48g, Carbohydrates: 26.88g, Fat: 39.36g]","customizable"));
		starters.add(new Item(151106,"Starters(Veg&NonVeg)","veg","Paneer Manchurian(dry)",119,4.5,123,"/images/starters/paneerManchurian.jpg","PaneerManchurian",
				"Served with tomato sauce(no artificial colours, ajinomoto, msg and its chemical free).","customizable"));
		starters.add(new Item(151107,"Starters(Veg&NonVeg)","nonveg","Lemon Chicken",320,4.9,1023,"/images/starters/lemonChicken.jpg","Lemon Chicken",
				"370 gram | Serves 1 | [Energy: 582.12 kcal, Protein: 44.58g, Carbohydrates: 31.16g, Fat: 30.79g]","customizable"));
		starters.add(new Item(151108,"Starters(Veg&NonVeg)","nonveg","Chicken Lollypop",325,4.9,1023,"/images/starters/chickenLollypop.jpg","Chicken Lollypop",
				"370 gram | Serves 1 | [Energy: 582.12 kcal, Protein: 44.58g, Carbohydrates: 31.16g, Fat: 30.79g]","customizable"));
		starters.add(new Item(151109,"Starters(Veg&NonVeg)","nonveg","Chilly Chicken(Andhra)",325,4.9,1023,"/images/starters/chillyChickenAndhra.jpg","Chilly chicken",
				"450 gram | Serves 1 | [Energy: 912.22 kcal, Protein: 68.75g, Carbohydrates: 5.35g, Fat: 67.98g]","customizable"));
		System.out.println(starters);
		return starters;
	}

	@Override
	public List<Item> getPureNonVeg() throws Exception {
		// TODO Auto-generated method stub
		List<Item> pureNonVeg = new ArrayList<>();
		pureNonVeg.add(new Item(161101,"PureNonVeg","nonveg","Chicken Boneless Biryani",325,4.9,1016,"/images/pureNonVeg/chickenBonelessBiryani.jpg",
				"Chicken Boneless Biryani","1050 gram | Serves 1 | [Energy: 1446.5 kcal, Protein: 64.22g, Carbohydrates: 189.62g, Fat: 44.2g]","customizable"));
		pureNonVeg.add(new Item(161102,"PureNonVeg","nonveg","Lollipop Biryani",325,4.9,1016,"/images/pureNonVeg/lollipopBiryani.jpg",
				"Lollipop Biryani","1050 gram | Serves 1 | [Energy: 1673.09 kcal, Protein: 45.42g, Carbohydrates: 217.95g, Fat: 65.98g]","customizable"));
		pureNonVeg.add(new Item(161103,"PureNonVeg","nonveg","Royals Special Biryani",330,4.9,1016,"/images/pureNonVeg/royalsSpecialBiryani.jpg",
				"Royals Special Biryani","1050 gram | Serves 1 | [Energy: 1456.21 kcal, Protein: 64.65g, Carbohydrates: 190.89g, Fat: 44.5g]","customizable"));
		pureNonVeg.add(new Item(161104,"PureNonVeg","nonveg","Prawns Biryani",415,4.9,1016,"/images/pureNonVeg/prawnsBiryani.jpg",
				"Prawns Biryani","1050 gram | Serves 1 | [Energy: 1431.95 kcal, Protein: 37.34g, Carbohydrates: 213.4g, Fat: 43.56g]","customizable"));
		pureNonVeg.add(new Item(161105,"PureNonVeg","nonveg","Mutton keema Biryani",425,4.9,1016,"/images/pureNonVeg/muttonKeemaBiryani.jpg",
				"Mutton keema Biryani","1050 gram | Serves 1 | [Energy: 1551.26 kcal, Protein: 42.47g, Carbohydrates: 200.46g, Fat: 61.1g]","customizable"));
		
		
		
		return pureNonVeg;
	}

	@Override
	public List<Item> getDesserts() throws Exception {
		// TODO Auto-generated method stub
		List<Item> desserts = new ArrayList<>();
		desserts.add(new Item(171101,"Desserts","veg","Black Forest Pastry",89,4.9,599,"/images/desserts/blackForestCake.jpg",
				"Black Forest","Serves 1 | A crowd favourite and for good reason. Multiple layers of moist chocolate"
						+ "topped with whipped cream and garnished with chocolate flakes.","customizable"));
		desserts.add(new Item(171102,"Desserts","veg","ButterScotch Pastry",89,4.9,599,"/images/desserts/butterScotchPastry.jpg",
				"Butter Scotch","Serves 1 | A childhood favourite combines butterscotch chips with choco sticks, white marbles & whipped cream","customizable"));
		desserts.add(new Item(171103,"Desserts","veg","Chocolate Jar cake",109,4.9,599,"/images/desserts/chocolateJarCake.jpg",
				"Chocolate JarCake","Serves 1 | A thick layered velvety chocolate classic in a jar","customizable"));
		desserts.add(new Item(171104,"Desserts","veg","Red Velvet Jar Cake",129,4.9,599,"/images/desserts/redVelvetJar.jpg",
				"Red velvet jar cake","Serves 1 | A perfct construction of red velvet goodness, carfully layered with vanilla cream and infused with vanilla essence makes for the perfect red velvet cake in a jar","customizable"));
		desserts.add(new Item(171105,"Desserts","veg","Blueberry Jar Cake",129,4.9,599,"/images/desserts/blueBerryJarcake.jpg",
				"Blueberry jarCake","Serves 1 | An exotic mix of fresh blueberry pulp and freshly baked cake in a jar is a seasoal treat","customizable"));
		desserts.add(new Item(171106,"Desserts","veg","BlackForest Cake",449,4.9,599,"/images/desserts/blackForestPastry.jpg",
				"BlackForest Cake","Serves 1 | A crowd favourite and for good reason. Multiple layers of moist chocolate topped with whipped cream and garnished with chocolate flakes & a cherry on top","customizable"));
		desserts.add(new Item(171107,"Desserts","veg","German Black Forest Cake",479,4.9,599,"/images/desserts/germanBlack.jpg",
				"GermanBlack Forest","Serves 1 | A crowd favourite and for good reason. Multiple layers of moist German chocolate topped with whipped cream and garnished with chocolate flakes & a cherry on top","customizable"));
		return desserts;
	}

	@Override
	public List<Item> getRoyalSpecials() throws Exception {
		// TODO Auto-generated method stub
		List<Item> royalSpecials = new ArrayList<>();
		royalSpecials.add(new Item(181101,"Royals Specials","nonveg","Royals Special Biryani",330,4.9,1016,"/images/pureNonVeg/royalsSpecialBiryani.jpg",
				"Royals Special Biryani","1050 gram | Serves 1 | [Energy: 1456.21 kcal, Protein: 64.65g, Carbohydrates: 190.89g, Fat: 44.5g]","customizable"));
		royalSpecials.add(new Item(181102,"Royals Specials","veg","Royals Veg Ball Manchurian",199,4.7,1023,"/images/Specials/vegBallManchurian.jpg",
				"Veg Ball Manchurian","Serves 1 | crispy veg balls","customizable"));
		royalSpecials.add(new Item(181103,"Royals Specials","nonveg","Royals Opera Pastry",109,4.7,1023,"/images/Specials/OperaPastry.jpg",
				"Opera Pastry","Serves 1 | Jocan sponge, coffee, fresh cream, chd 45 chocolate, egg & butter complete this delicacy","customizable"));
		royalSpecials.add(new Item(181104,"Royals Specials","veg","Kit Kat Pastry",99,4.7,1023,"/images/Specials/kitKatPastry.jpg",
				"Kit Kat Pastry","Serves 1 | A perfect match of chocolatty goodness and kit kat crumbs binds together with whipped cream, A bakingo special","customizable"));
		return royalSpecials; 
	}
	
	
	
	
}
