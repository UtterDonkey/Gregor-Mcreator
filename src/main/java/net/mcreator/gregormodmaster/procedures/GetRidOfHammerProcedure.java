package net.mcreator.gregormodmaster.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.gregormodmaster.item.HammerItem;
import net.mcreator.gregormodmaster.GregormodmasterElements;

@GregormodmasterElements.ModElement.Tag
public class GetRidOfHammerProcedure extends GregormodmasterElements.ModElement {
	public GetRidOfHammerProcedure(GregormodmasterElements instance) {
		super(instance, 29);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GetRidOfHammer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(HammerItem.block, (int) (1)).getItem() == p.getItem(), (int) 1);
	}
}
