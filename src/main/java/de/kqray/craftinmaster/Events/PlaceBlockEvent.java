package de.kqray.craftinmaster.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.management.Attribute;

public class PlaceBlockEvent implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {

        Player p = event.getPlayer();




        //Itemstack & itemmeta for Supreme Diamond Block
        ItemStack supremeDiamondBlockItemStack = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta supremeDiamondBlockMeta = supremeDiamondBlockItemStack.getItemMeta();
        //Todo:Set SupremeDiamondBlock meta
        supremeDiamondBlockMeta.setDisplayName(ChatColor.RED+"Supreme Diamond Block");
        supremeDiamondBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        supremeDiamondBlockMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, true);
        supremeDiamondBlockItemStack.setItemMeta(supremeDiamondBlockMeta);


        if (event.getItemInHand().isSimilar(supremeDiamondBlockItemStack)){
            p.sendMessage(ChatColor.RED+"Du darfst diesen block nicht setzen");
            event.setCancelled(true);
            p.setHealth(40);
        }
    }

}
