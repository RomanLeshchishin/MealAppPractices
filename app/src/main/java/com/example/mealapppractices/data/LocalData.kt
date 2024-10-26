package com.example.mealapppractices.data

class CategoryDB(
  val idCategory: String,
  val strCategory: String,
  val strCategoryThumb: String,
  val strCategoryDescription: String
)

class MealItemDB(
  val idMeal: String,
  val strMeal: String,
  val strMealThumb: String
)

class MealItemDetailsDB(
  val idMeal: String,
  val strMeal: String,
  val strDrinkAlternate: String?,
  val strCategory: String,
  val strArea: String,
  val strInstructions: String,
  val strMealThumb: String,
  val strTags: String,
  val strYoutube: String,
  val strIngredient1: String,
  val strIngredient2: String,
  val strIngredient3: String,
  val strIngredient4: String,
  val strIngredient5: String,
  val strMeasure1: String,
  val strMeasure2: String,
  val strMeasure3: String,
  val strMeasure4: String,
  val strMeasure5: String
)

val MealItemDetailsExample = listOf(
  MealItemDetailsDB(
    idMeal = "52874",
    strMeal = "Beef and Mustard Pie",
    strDrinkAlternate = null,
    strCategory = "Beef",
    strArea = "British",
    strInstructions = "Preheat the oven to 150C/300F/Gas 2.\r\nToss the beef and flour together in a bowl with some salt and black pepper.\r\nHeat a large casserole until hot, add half of the rapeseed oil and enough of the beef to just cover the bottom of the casserole.\r\nFry until browned on each side, then remove and set aside. Repeat with the remaining oil and beef.\r\nReturn the beef to the pan, add the wine and cook until the volume of liquid has reduced by half, then add the stock, onion, carrots, thyme and mustard, and season well with salt and pepper.\r\nCover with a lid and place in the oven for two hours.\r\nRemove from the oven, check the seasoning and set aside to cool. Remove the thyme.\r\nWhen the beef is cool and you're ready to assemble the pie, preheat the oven to 200C/400F/Gas 6.\r\nTransfer the beef to a pie dish, brush the rim with the beaten egg yolks and lay the pastry over the top. Brush the top of the pastry with more beaten egg.\r\nTrim the pastry so there is just enough excess to crimp the edges, then place in the oven and bake for 30 minutes, or until the pastry is golden-brown and cooked through.\r\nFor the green beans, bring a saucepan of salted water to the boil, add the beans and cook for 4-5 minutes, or until just tender.\r\nDrain and toss with the butter, then season with black pepper.\r\nTo serve, place a large spoonful of pie onto each plate with some green beans alongside.",
    strMealThumb = "https://www.themealdb.com/images/media/meals/sytuqu1511553755.jpg",
    strTags = "Meat,Pie",
    strYoutube = "https://www.youtube.com/watch?v=nMyBC9staMU",
    strIngredient1 = "Beef",
    strIngredient2 = "Plain Flour",
    strIngredient3 = "Rapeseed Oil",
    strIngredient4 = "Red Wine",
    strIngredient5 = "Beef Stock",
    strMeasure1 = "1kg",
    strMeasure2 = "2 tbs",
    strMeasure3 = "2 tbs",
    strMeasure4 = "200ml",
    strMeasure5 = "400ml"
  ),
  MealItemDetailsDB(
    idMeal = "52878",
    strMeal = "Beef and Oyster pie",
    strDrinkAlternate = null,
    strCategory = "Beef",
    strArea = "British",
    strInstructions = "Season the beef cubes with salt and black pepper. Heat a tablespoon of oil in the frying pan and fry the meat over a high heat. Do this in three batches so that you don’t overcrowd the pan, transferring the meat to a large flameproof casserole dish once it is browned all over. Add extra oil if the pan seems dry.\r\nIn the same pan, add another tablespoon of oil and cook the shallots for 4-5 minutes, then add the garlic and fry for 30 seconds. Add the bacon and fry until slightly browned. Transfer the onion and bacon mixture to the casserole dish and add the herbs.\r\nPreheat the oven to 180C/350F/Gas 4.\r\nPour the stout into the frying pan and bring to the boil, stirring to lift any stuck-on browned bits from the bottom of the pan. Pour the stout over the beef in the casserole dish and add the stock. Cover the casserole and place it in the oven for 1½-2 hours, or until the beef is tender and the sauce is reduced.\r\nSkim off any surface fat, taste and add salt and pepper if necessary, then stir in the cornflour paste. Put the casserole dish on the hob – don’t forget that it will be hot – and simmer for 1-2 minutes, stirring, until thickened. Leave to cool.\r\nIncrease the oven to 200C/400F/Gas 6. To make the pastry, put the flour and salt in a very large bowl. Grate the butter and stir it into the flour in three batches. Gradually add 325ml/11fl oz cold water – you may not need it all – and stir with a round-bladed knife until the mixture just comes together. Knead the pastry lightly into a ball on a lightly floured surface and set aside 250g/9oz for the pie lid.\r\nRoll the rest of the pastry out until about 2cm/¾in larger than the dish you’re using. Line the dish with the pastry then pile in the filling, tucking the oysters in as well. Brush the edge of the pastry with beaten egg.\r\nRoll the remaining pastry until slightly larger than your dish and gently lift over the filling, pressing the edges firmly to seal, then trim with a sharp knife. Brush with beaten egg to glaze. Put the dish on a baking tray and bake for 25-30 minutes, or until the pastry is golden-brown and the filling is bubbling.",
    strMealThumb = "https://www.themealdb.com/images/media/meals/wrssvt1511556563.jpg",
    strTags = "Pie",
    strYoutube = "https://www.youtube.com/watch?v=ONX74yP6JnI",
    strIngredient1 = "Beef",
    strIngredient2 = "Olive Oil",
    strIngredient3 = "Shallots",
    strIngredient4 = "Garlic",
    strIngredient5 = "Bacon",
    strMeasure1 = "900g",
    strMeasure2 = "3 tbs",
    strMeasure3 = "3",
    strMeasure4 = "2 cloves minced",
    strMeasure5 = "125g"
  )
)