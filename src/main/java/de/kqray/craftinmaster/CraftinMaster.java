package de.kqray.craftinmaster;


import de.kqray.craftinmaster.Events.PlaceBlockEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class CraftinMaster extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Config();
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new PlaceBlockEvent(), this);
        supremeDiamondChestPlate();
        SupremeDiamondRecipe();
        SupremeDiamondBlockRecipe();
        supremeStickRecipe();
        supremeDiamondSwordRecipe();
        supremeDiamondPickaxe();
        supremeDiamondAxe();
        supremeDiamondShovel();
        supremeDiamondLeggings();
        supremeDiamondHelmet();
        supremeDiamondBoots();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public void Config(){
        getConfig().options().copyDefaults(true);
        getConfig().addDefault("supreme-Diamond-Sword-Recipe", "true");
        getConfig().addDefault("supreme-Diamond-Pickaxe-Recipe", "true");
        getConfig().addDefault("supreme-Diamond-Axe-Recipe", "true");
        getConfig().addDefault("supreme-Diamond-Shovel-Recipe", "true");
        getConfig().addDefault("supreme-Diamond-Recipe", "true");
        getConfig().addDefault("supreme-Diamond-Block-Recipe", "true");
        getConfig().addDefault("supreme-Diamond-Block-To-8-Supreme-Diamond-Recipe", "true");
        getConfig().addDefault("supreme-Stick-Recipe", "true");
        getConfig().addDefault("supreme-Diamond-Sword-Recipe","true");
        getConfig().addDefault("supreme-Diamond-Helmet-Recipe","true");
        getConfig().addDefault("supreme-Diamond-ChestPlate-Recipe","true");
        getConfig().addDefault("supreme-Diamond-Leggings-Recipe","true");
        getConfig().addDefault("supreme-Diamond-Boots-Recipe","true");
        saveConfig();
    }
    public void SupremeDiamondRecipe(){
        //Itemstack & itemmeta for SUpreme Diamond
        ItemStack supremeDiamondItemStack = new ItemStack(Material.DIAMOND);
        ItemMeta supremeDiamondMeta = supremeDiamondItemStack.getItemMeta();
        //todo:set SupremeDiamondMeta meta
        supremeDiamondMeta.setDisplayName(ChatColor.RED+"Supreme Diamond");
        supremeDiamondMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        supremeDiamondMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
        supremeDiamondItemStack.setItemMeta(supremeDiamondMeta);

        //Supreme Diamond Recipe
        ShapedRecipe supremeDiamondRecipe = new ShapedRecipe(NamespacedKey.minecraft("supreme_diamond"),supremeDiamondItemStack);
        supremeDiamondRecipe.shape("xxx","xyx","xxx");
        supremeDiamondRecipe.setIngredient('x', Material.DIAMOND);
        supremeDiamondRecipe.setIngredient('y', Material.AIR);
        if (getConfig().getString("supreme-Diamond-Recipe").equals("true")){
            Bukkit.getServer().addRecipe(supremeDiamondRecipe);
        }
        if (getConfig().getString("supreme-Diamond-Recipe").equals("false"))
        Bukkit.getServer().removeRecipe(NamespacedKey.minecraft("supreme_diamond"));
    }

    public void SupremeDiamondBlockRecipe() {
        //Itemstack & itemmeta for Supreme Diamond Block
        ItemStack supremeDiamondBlockItemStack = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta supremeDiamondBlockMeta = supremeDiamondBlockItemStack.getItemMeta();
        //Todo:Set SupremeDiamondBlock meta
        supremeDiamondBlockMeta.setDisplayName(ChatColor.RED + "Supreme Diamond Block");
        supremeDiamondBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        supremeDiamondBlockMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
        supremeDiamondBlockItemStack.setItemMeta(supremeDiamondBlockMeta);

        //Itemstack & itemmeta for Supreme Diamond
        ItemStack supremeDiamondItemStack = new ItemStack(Material.DIAMOND);
        ItemMeta supremeDiamondMeta = supremeDiamondItemStack.getItemMeta();
        //todo: set supremeDiamondMeta2
        supremeDiamondMeta.setDisplayName(ChatColor.RED + "Supreme Diamond");
        supremeDiamondMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        supremeDiamondMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
        supremeDiamondItemStack.setItemMeta(supremeDiamondMeta);

        //Itemstack & itemmeta for 8 Supreme Diamond
        ItemStack getSupremeDiamondItemStack = new ItemStack(Material.DIAMOND, 8);
        ItemMeta getSupremeDiamondMeta = getSupremeDiamondItemStack.getItemMeta();
        //todo: set getSupremeDiamondMeta
        getSupremeDiamondMeta.setDisplayName(ChatColor.RED + "Supreme Diamond");
        getSupremeDiamondMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        getSupremeDiamondMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
        getSupremeDiamondItemStack.setItemMeta(getSupremeDiamondMeta);

        //Supreme Diamond Block Recipe
        ShapedRecipe supremeDiamondBlockRecipe = new ShapedRecipe(NamespacedKey.minecraft("supreme_diamond_block"), supremeDiamondBlockItemStack);
        supremeDiamondBlockRecipe.shape("xxx", "xyx", "xxx");
        supremeDiamondBlockRecipe.setIngredient('x', new RecipeChoice.ExactChoice(supremeDiamondItemStack));
        supremeDiamondBlockRecipe.setIngredient('y', Material.AIR);
        if (getConfig().getString("supreme-Diamond-Block-Recipe").equals("true")) {
            Bukkit.getServer().addRecipe(supremeDiamondBlockRecipe);
        }
        if (getConfig().getString("supreme-Diamond-Block-Recipe").equals("false")){
            Bukkit.getServer().removeRecipe(NamespacedKey.minecraft("supreme_diamond_block"));
    }


        //Supreme Diamond Block to 8 Supreme Diamond Recipe
        ShapedRecipe getDiamondBlockRecipe = new ShapedRecipe(NamespacedKey.minecraft("supreme_diamond_block_to_supreme_diamond"),getSupremeDiamondItemStack);
        getDiamondBlockRecipe.shape("x");
        getDiamondBlockRecipe.setIngredient('x',new RecipeChoice.ExactChoice(supremeDiamondBlockItemStack));
        if (getConfig().getString("supreme-Diamond-Block-To-8-Supreme-Diamond-Recipe").equals("true")) {
            Bukkit.getServer().addRecipe(getDiamondBlockRecipe);
        }
        if (getConfig().getString("supreme-Diamond-Block-To-8-Supreme-Diamond-Recipe").equals("false")){
            Bukkit.getServer().removeRecipe(NamespacedKey.minecraft("supreme_diamond_block_to_supreme_diamond"));
        }
    }
    public void supremeStickRecipe(){
        ItemStack supremeStickItemStack = new ItemStack(Material.STICK);
        ItemMeta supremeStickMeta = supremeStickItemStack.getItemMeta();
        supremeStickMeta.setDisplayName(ChatColor.RED+"Supreme Stick");
        supremeStickMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
        supremeStickMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        supremeStickItemStack.setItemMeta(supremeStickMeta);


        ShapedRecipe supremeStickRecipe = new ShapedRecipe(NamespacedKey.minecraft("supreme_stick"),supremeStickItemStack);
        supremeStickRecipe.shape("xxx","xyx","xxx");
        supremeStickRecipe.setIngredient('x', Material.STICK);
        supremeStickRecipe.setIngredient('y', Material.AIR);
        if (getConfig().getString("supreme-Stick-Recipe").equals("true")) {
            Bukkit.getServer().addRecipe(supremeStickRecipe);
        }
        if (getConfig().getString("supreme-Stick-Recipe").equals("false")){
            Bukkit.getServer().removeRecipe(NamespacedKey.minecraft("supreme_stick"));
        }
    }


    public void supremeDiamondSwordRecipe(){
        //Itemstack & Meta for Supreme Diamond Sword
        ItemStack supremeDiamondSwordItemStack = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta supremeDiamondSwordMeta = supremeDiamondSwordItemStack.getItemMeta();
        //todo: set supremeDiamondSwordMeta
        supremeDiamondSwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 8, true);
        supremeDiamondSwordMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        supremeDiamondSwordMeta.addEnchant(Enchantment.MENDING, 1, true);
        supremeDiamondSwordMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
        supremeDiamondSwordMeta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);



        supremeDiamondSwordMeta.setDisplayName(ChatColor.RED+"Supreme Diamond Sword");
        supremeDiamondSwordItemStack.setItemMeta(supremeDiamondSwordMeta);

        ItemStack supremeStickItemStack = new ItemStack(Material.STICK);
        ItemMeta supremeStickMeta = supremeStickItemStack.getItemMeta();
        supremeStickMeta.setDisplayName(ChatColor.RED+"Supreme Stick");
        supremeStickMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
        supremeStickMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        supremeStickItemStack.setItemMeta(supremeStickMeta);

        //Itemstack & itemmeta for Supreme Diamond Block
        ItemStack supremeDiamondBlockItemStack = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta supremeDiamondBlockMeta = supremeDiamondBlockItemStack.getItemMeta();
        //Todo:Set SupremeDiamondBlock meta2
        supremeDiamondBlockMeta.setDisplayName(ChatColor.RED + "Supreme Diamond Block");
        supremeDiamondBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        supremeDiamondBlockMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
        supremeDiamondBlockItemStack.setItemMeta(supremeDiamondBlockMeta);

        ShapedRecipe supremeDiamondSwordRecipe = new ShapedRecipe(NamespacedKey.minecraft("supreme_diamond_sword"), supremeDiamondSwordItemStack);
        supremeDiamondSwordRecipe.shape("y","y","z");
        supremeDiamondSwordRecipe.setIngredient('y',new RecipeChoice.ExactChoice(supremeDiamondBlockItemStack));
        supremeDiamondSwordRecipe.setIngredient('z',new RecipeChoice.ExactChoice(supremeStickItemStack));
        if (getConfig().getString("supreme-Diamond-Sword-Recipe").equals("true")) {
            Bukkit.getServer().addRecipe(supremeDiamondSwordRecipe);
        }
        if (getConfig().getString("supreme-Diamond-Sword-Recipe").equals("false")){
            Bukkit.getServer().removeRecipe(NamespacedKey.minecraft("supreme_diamond_sword"));
        }
    }
    public void supremeDiamondPickaxe(){
        ItemStack supremeDiamonPickaxeItemStack = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta supremeDiamondPickaxeMeta = supremeDiamonPickaxeItemStack.getItemMeta();
        //todo:set supremeDiamondPickaxeMeta
        supremeDiamondPickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 8, true);
        supremeDiamondPickaxeMeta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
        supremeDiamondPickaxeMeta.addEnchant(Enchantment.MENDING, 1, true);
        supremeDiamondPickaxeMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        supremeDiamondPickaxeMeta.setDisplayName(ChatColor.RED+"Supreme Diamond Pickaxe");
        supremeDiamonPickaxeItemStack.setItemMeta(supremeDiamondPickaxeMeta);

        //Itemstack & itemmeta for Supreme Diamond Block
        ItemStack supremeDiamondBlockItemStack = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta supremeDiamondBlockMeta = supremeDiamondBlockItemStack.getItemMeta();
        //Todo:Set SupremeDiamondBlock meta3
        supremeDiamondBlockMeta.setDisplayName(ChatColor.RED + "Supreme Diamond Block");
        supremeDiamondBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        supremeDiamondBlockMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
        supremeDiamondBlockItemStack.setItemMeta(supremeDiamondBlockMeta);

        ItemStack supremeStickItemStack = new ItemStack(Material.STICK);
        ItemMeta supremeStickMeta = supremeStickItemStack.getItemMeta();
        supremeStickMeta.setDisplayName(ChatColor.RED+"Supreme Stick");
        supremeStickMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
        supremeStickMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        supremeStickItemStack.setItemMeta(supremeStickMeta);

        ShapedRecipe supremeDiamondPickaxeRecipe = new ShapedRecipe(NamespacedKey.minecraft("supreme_diamond_pickaxe"), supremeDiamonPickaxeItemStack);
        supremeDiamondPickaxeRecipe.shape("xxx","yzy","yzy");
        supremeDiamondPickaxeRecipe.setIngredient('x', new RecipeChoice.ExactChoice(supremeDiamondBlockItemStack));
        supremeDiamondPickaxeRecipe.setIngredient('y', Material.AIR);
        supremeDiamondPickaxeRecipe.setIngredient('z', new RecipeChoice.ExactChoice(supremeStickItemStack));
        if (getConfig().getString("supreme-Diamond-Pickaxe-Recipe").equals("true")) {
            Bukkit.getServer().addRecipe(supremeDiamondPickaxeRecipe);
        }
        if (getConfig().getString("supreme-Diamond-Pickaxe-Recipe").equals("false")){
            Bukkit.getServer().removeRecipe(NamespacedKey.minecraft("supreme_diamond_pickaxe"));
        }
    }
    public void supremeDiamondAxe(){
        ItemStack supremeDiamondAxeItemStack = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta supremeDiamondAxeMeta = supremeDiamondAxeItemStack.getItemMeta();
        //todo:set supremeDiamondAxeMeta
        supremeDiamondAxeMeta.addEnchant(Enchantment.DIG_SPEED, 8, true);
        supremeDiamondAxeMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        supremeDiamondAxeMeta.addEnchant(Enchantment.MENDING, 1, true);
        supremeDiamondAxeMeta.setDisplayName(ChatColor.RED+"Supreme Diamond Axe");
        supremeDiamondAxeItemStack.setItemMeta(supremeDiamondAxeMeta);

        //Itemstack & itemmeta for Supreme Diamond Block
        ItemStack supremeDiamondBlockItemStack = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta supremeDiamondBlockMeta = supremeDiamondBlockItemStack.getItemMeta();
        //Todo:Set SupremeDiamondBlock meta4
        supremeDiamondBlockMeta.setDisplayName(ChatColor.RED + "Supreme Diamond Block");
        supremeDiamondBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        supremeDiamondBlockMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
        supremeDiamondBlockItemStack.setItemMeta(supremeDiamondBlockMeta);

        ItemStack supremeStickItemStack = new ItemStack(Material.STICK);
        ItemMeta supremeStickMeta = supremeStickItemStack.getItemMeta();
        supremeStickMeta.setDisplayName(ChatColor.RED+"Supreme Stick");
        supremeStickMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
        supremeStickMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        supremeStickItemStack.setItemMeta(supremeStickMeta);

        ShapedRecipe supremeDiamondAxeRecipe = new ShapedRecipe(NamespacedKey.minecraft("supreme_diamond_axe"), supremeDiamondAxeItemStack);
        supremeDiamondAxeRecipe.shape("xxz","xyz","zyz");
        supremeDiamondAxeRecipe.setIngredient('x', new RecipeChoice.ExactChoice(supremeDiamondBlockItemStack));
        supremeDiamondAxeRecipe.setIngredient('y', new RecipeChoice.ExactChoice(supremeStickItemStack));
        supremeDiamondAxeRecipe.setIngredient('z', Material.AIR);
        if (getConfig().getString("supreme-Diamond-Axe-Recipe").equals("true")) {
            Bukkit.getServer().addRecipe(supremeDiamondAxeRecipe);
        }
        if (getConfig().getString("supreme-Diamond-Axe-Recipe").equals("false")){
            Bukkit.getServer().removeRecipe(NamespacedKey.minecraft("supreme_diamond_axe"));
        }
    }
    public void supremeDiamondShovel(){
        ItemStack supremeDiamondShovelItemStack = new ItemStack(Material.DIAMOND_SHOVEL);
        ItemMeta supremeDiamondShovelMeta = supremeDiamondShovelItemStack.getItemMeta();
        //todo: set supremeDiamondShovelMeta
        supremeDiamondShovelMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        supremeDiamondShovelMeta.addEnchant(Enchantment.DURABILITY, 5, true);
        supremeDiamondShovelMeta.addEnchant(Enchantment.MENDING, 1, true);
        supremeDiamondShovelMeta.setDisplayName(ChatColor.RED+"Supreme Diamond Shovel");
        supremeDiamondShovelItemStack.setItemMeta(supremeDiamondShovelMeta);

        //Itemstack & itemmeta for Supreme Diamond Block
        ItemStack supremeDiamondBlockItemStack = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta supremeDiamondBlockMeta = supremeDiamondBlockItemStack.getItemMeta();
        //Todo:Set SupremeDiamondBlock meta5
        supremeDiamondBlockMeta.setDisplayName(ChatColor.RED + "Supreme Diamond Block");
        supremeDiamondBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        supremeDiamondBlockMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
        supremeDiamondBlockItemStack.setItemMeta(supremeDiamondBlockMeta);

        ItemStack supremeStickItemStack = new ItemStack(Material.STICK);
        ItemMeta supremeStickMeta = supremeStickItemStack.getItemMeta();
        supremeStickMeta.setDisplayName(ChatColor.RED+"Supreme Stick");
        supremeStickMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
        supremeStickMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        supremeStickItemStack.setItemMeta(supremeStickMeta);

        ShapedRecipe supremeDiamondShovelRecipe = new ShapedRecipe(NamespacedKey.minecraft("supreme_diamond_shovel"), supremeDiamondShovelItemStack);
        supremeDiamondShovelRecipe.shape("x","y","y");
        supremeDiamondShovelRecipe.setIngredient('x', new RecipeChoice.ExactChoice(supremeDiamondBlockItemStack));
        supremeDiamondShovelRecipe.setIngredient('y', new RecipeChoice.ExactChoice(supremeStickItemStack));
        if (getConfig().getString("supreme-Diamond-Shovel-Recipe").equals("true")) {
            Bukkit.getServer().addRecipe(supremeDiamondShovelRecipe);
        }
        if (getConfig().getString("supreme-Diamond-Shovel-Recipe").equals("false")){
            Bukkit.getServer().removeRecipe(NamespacedKey.minecraft("supreme_diamond_shovel"));
        }
    }
    public void supremeDiamondHelmet(){
        ItemStack supremeDiamondHelmetItemStack = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta supremeDiamondHelmetMeta = supremeDiamondHelmetItemStack.getItemMeta();
        //todo:set supremeDiamondHelmetMeta
        supremeDiamondHelmetMeta.addEnchant(Enchantment.MENDING, 1, true);
        supremeDiamondHelmetMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        supremeDiamondHelmetMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true);
        supremeDiamondHelmetMeta.addEnchant(Enchantment.WATER_WORKER, 3, true);
        supremeDiamondHelmetMeta.addEnchant(Enchantment.OXYGEN , 3, true);

        supremeDiamondHelmetMeta.setDisplayName(ChatColor.RED+"Supreme Diamond Helmet");
        supremeDiamondHelmetItemStack.setItemMeta(supremeDiamondHelmetMeta);

        ItemStack supremeDiamondItemStack = new ItemStack(Material.DIAMOND);
        ItemMeta supremeDiamondMeta = supremeDiamondItemStack.getItemMeta();
        //todo: set supremeDiamondMeta6
        supremeDiamondMeta.setDisplayName(ChatColor.RED+"Supreme Diamond");
        supremeDiamondMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        supremeDiamondMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
        supremeDiamondItemStack.setItemMeta(supremeDiamondMeta);

        ShapedRecipe supremeDiamondHelmetRecipe = new ShapedRecipe(NamespacedKey.minecraft("supreme_diamond_helmet"), supremeDiamondHelmetItemStack);
        supremeDiamondHelmetRecipe.shape("xxx","xyx");
        supremeDiamondHelmetRecipe.setIngredient('x', new RecipeChoice.ExactChoice(supremeDiamondItemStack));
        supremeDiamondHelmetRecipe.setIngredient('y', Material.AIR);
        if (getConfig().getString("supreme-Diamond-Helmet-Recipe").equals("true")) {
            Bukkit.getServer().addRecipe(supremeDiamondHelmetRecipe);
        }
        if (getConfig().getString("supreme-Diamond-Helmet-Recipe").equals("false")){
            Bukkit.getServer().removeRecipe(NamespacedKey.minecraft("supreme_diamond_helmet"));
        }

    }
    public void supremeDiamondChestPlate(){
        ItemStack supremeDiamondChestPlateItemStack = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta supremeDiamondChestPlateMeta = supremeDiamondChestPlateItemStack.getItemMeta();
        //todo:set supremeDiamondChestPlateMeta
        supremeDiamondChestPlateMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true);
        supremeDiamondChestPlateMeta.addEnchant(Enchantment.MENDING, 1, true);
        supremeDiamondChestPlateMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        supremeDiamondChestPlateMeta.setDisplayName(ChatColor.RED+"Supreme Diamond ChestPlate");
        supremeDiamondChestPlateItemStack.setItemMeta(supremeDiamondChestPlateMeta);

        ItemStack supremeDiamondItemStack = new ItemStack(Material.DIAMOND);
        ItemMeta supremeDiamondMeta = supremeDiamondItemStack.getItemMeta();
        //todo: set supremeDiamondMeta7
        supremeDiamondMeta.setDisplayName(ChatColor.RED+"Supreme Diamond");
        supremeDiamondMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        supremeDiamondMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
        supremeDiamondItemStack.setItemMeta(supremeDiamondMeta);

        ShapedRecipe supremeDiamondChestPlateRecipe = new ShapedRecipe(NamespacedKey.minecraft("supreme_diamond_chestplate"), supremeDiamondChestPlateItemStack);
        supremeDiamondChestPlateRecipe.shape("xyx","xxx","xxx");
        supremeDiamondChestPlateRecipe.setIngredient('x', new RecipeChoice.ExactChoice(supremeDiamondItemStack));
        supremeDiamondChestPlateRecipe.setIngredient('y',Material.AIR);

        if (getConfig().getString("supreme-Diamond-ChestPlate-Recipe").equals("true")) {
            Bukkit.getServer().addRecipe(supremeDiamondChestPlateRecipe);
        }
        if (getConfig().getString("supreme-Diamond-ChestPlate-Recipe").equals("false")){
            Bukkit.getServer().removeRecipe(NamespacedKey.minecraft("supreme_diamond_chestplate"));
        }

    }
    public void supremeDiamondLeggings(){
        ItemStack supremeDiamondLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta supremeDiamondLeggingsMeta = supremeDiamondLeggings.getItemMeta();
        //todo:set supremeDiamondLeggingsmeta
        supremeDiamondLeggingsMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        supremeDiamondLeggingsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true);
        supremeDiamondLeggingsMeta.addEnchant(Enchantment.MENDING, 1, true);
        supremeDiamondLeggingsMeta.setDisplayName(ChatColor.RED+"Supreme Diamond Leggings");
        supremeDiamondLeggings.setItemMeta(supremeDiamondLeggingsMeta);

        ItemStack supremeDiamondItemStack = new ItemStack(Material.DIAMOND);
        ItemMeta supremeDiamondMeta = supremeDiamondItemStack.getItemMeta();
        //todo: set supremeDiamondMeta8
        supremeDiamondMeta.setDisplayName(ChatColor.RED+"Supreme Diamond");
        supremeDiamondMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        supremeDiamondMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
        supremeDiamondItemStack.setItemMeta(supremeDiamondMeta);

        ShapedRecipe supremeDiamondLeggingsRecipe = new ShapedRecipe(NamespacedKey.minecraft("supreme_diamond_leggings"), supremeDiamondLeggings);
        supremeDiamondLeggingsRecipe.shape("xxx","xyx","xyx");
        supremeDiamondLeggingsRecipe.setIngredient('x', new RecipeChoice.ExactChoice(supremeDiamondItemStack));
        supremeDiamondLeggingsRecipe.setIngredient('y', Material.AIR);

        if (getConfig().getString("supreme-Diamond-Leggings-Recipe").equals("true")) {
            Bukkit.getServer().addRecipe(supremeDiamondLeggingsRecipe);
        }
        if (getConfig().getString("supreme-Diamond-Leggings-Recipe").equals("false")){
            Bukkit.getServer().removeRecipe(NamespacedKey.minecraft("supreme_diamond_leggings"));
        }

    }



    public void supremeDiamondBoots(){
        ItemStack supremeDiamondBootsItemStack = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta supremeDiamondBootsMeta = supremeDiamondBootsItemStack.getItemMeta();
        //todo:set supremeDiamondBootsMeta
        supremeDiamondBootsMeta.addEnchant(Enchantment.MENDING,1 , true);
        supremeDiamondBootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        supremeDiamondBootsMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        supremeDiamondBootsMeta.addEnchant(Enchantment.DEPTH_STRIDER, 3, true);
        supremeDiamondBootsMeta.addEnchant(Enchantment.PROTECTION_FALL, 4, true);
        supremeDiamondBootsMeta.setDisplayName(ChatColor.RED+"Supreme Diamond Boots");
        supremeDiamondBootsItemStack.setItemMeta(supremeDiamondBootsMeta);

        ItemStack supremeDiamondItemStack = new ItemStack(Material.DIAMOND);
        ItemMeta supremeDiamondMeta = supremeDiamondItemStack.getItemMeta();
        //todo: set supremeDiamondMeta9
        supremeDiamondMeta.setDisplayName(ChatColor.RED+"Supreme Diamond");
        supremeDiamondMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        supremeDiamondMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
        supremeDiamondItemStack.setItemMeta(supremeDiamondMeta);

        ShapedRecipe supremeDiamondBootsRecipe = new ShapedRecipe(NamespacedKey.minecraft("supreme_diamond_boots"), supremeDiamondBootsItemStack);
        supremeDiamondBootsRecipe.shape("xyx", "xyx");
        supremeDiamondBootsRecipe.setIngredient('x', new RecipeChoice.ExactChoice(supremeDiamondItemStack));
        supremeDiamondBootsRecipe.setIngredient('y', Material.AIR);

        if (getConfig().getString("supreme-Diamond-Boots-Recipe").equals("true")) {
            Bukkit.getServer().addRecipe(supremeDiamondBootsRecipe);
        }
        if (getConfig().getString("supreme-Diamond-Boots-Recipe").equals("false")){
            Bukkit.getServer().removeRecipe(NamespacedKey.minecraft("supreme_diamond_boots"));
        }

    }




}
