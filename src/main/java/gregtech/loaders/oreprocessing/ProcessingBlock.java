package gregtech.loaders.oreprocessing;

import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

public class ProcessingBlock implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingBlock() {
        OrePrefixes.block.add(this);
    }

    @Override
    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if (aMaterial != Materials.Clay) {
            GT_Values.RA.addCutterRecipe(GT_Utility.copyAmount(1L, aStack), GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 9L), null, (int) Math.max(aMaterial.getMass() * 10L, 1L), 30);
        }

        ItemStack tStack1 = GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial, 1L);
        ItemStack tStack2 = GT_OreDictUnificator.get(OrePrefixes.gem, aMaterial, 1L);
        ItemStack tStack3 = GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial, 1L);

        GT_ModHandler.removeRecipeDelayed(GT_Utility.copyAmount(1L, aStack));

        if (tStack1 != null)
            GT_ModHandler.removeRecipeDelayed(tStack1, tStack1, tStack1, tStack1, tStack1, tStack1, tStack1, tStack1, tStack1);
        if (tStack2 != null)
            GT_ModHandler.removeRecipeDelayed(tStack2, tStack2, tStack2, tStack2, tStack2, tStack2, tStack2, tStack2, tStack2);
        if (tStack3 != null) {
            GT_ModHandler.removeRecipeDelayed(tStack3, tStack3, tStack3, tStack3, tStack3, tStack3, tStack3, tStack3, tStack3);
        }
        if (aMaterial.mStandardMoltenFluid != null) {
            if (!(aMaterial == Materials.AnnealedCopper || aMaterial == Materials.WroughtIron)) {
            GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Block.get(0L), aMaterial.getMolten(1296L), GT_OreDictUnificator.get(OrePrefixes.block, aMaterial, 1L), 288, 8);
            }
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.storageblockcrafting, OrePrefixes.block.get(aMaterial).toString(), false)) {
            if ((tStack1 == null) && (tStack2 == null) && (tStack3 != null))
                GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.block, aMaterial, 1L), new Object[]{"XXX", "XXX", "XXX", 'X', OrePrefixes.dust.get(aMaterial)});
            if (tStack2 != null)
                GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.block, aMaterial, 1L), new Object[]{"XXX", "XXX", "XXX", 'X', OrePrefixes.gem.get(aMaterial)});
            if (tStack1 != null) {
                GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.block, aMaterial, 1L), new Object[]{"XXX", "XXX", "XXX", 'X', OrePrefixes.ingot.get(aMaterial)});
            }
        }
        if (tStack1 != null)
        	tStack1.stackSize = 9;
        if (tStack2 != null)
        	tStack2.stackSize = 9;
        if (tStack3 != null)
            tStack3.stackSize = 9;
        GT_Values.RA.addForgeHammerRecipe(aStack, tStack2, 100, 24);

        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.storageblockdecrafting, OrePrefixes.block.get(aMaterial).toString(), tStack2 != null)) {
            if (tStack3 != null)
                GT_ModHandler.addShapelessCraftingRecipe(tStack3, new Object[]{OrePrefixes.block.get(aMaterial)});
            if (tStack2 != null)
                GT_ModHandler.addShapelessCraftingRecipe(tStack2, new Object[]{OrePrefixes.block.get(aMaterial)});
            if (tStack1 != null)
                GT_ModHandler.addShapelessCraftingRecipe(tStack1, new Object[]{OrePrefixes.block.get(aMaterial)});
        }
        if (!OrePrefixes.block.isIgnored(aMaterial))
            GT_ModHandler.addCompressionRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial, 9L), GT_OreDictUnificator.get(OrePrefixes.block, aMaterial, 1L));
        switch (aMaterial.mName) {
            case "Mercury":
                System.err.println("'blockQuickSilver'?, In which Ice Desert can you actually place this as a solid Block? On Pluto Greg :)");
                break;
            case "Iron":
            case "WroughtIron":
            case "Steel":
                GT_Values.RA.addAssemblerRecipe(ItemList.IC2_Compressed_Coal_Ball.get(8L), GT_Utility.copyAmount(1L, aStack), ItemList.IC2_Compressed_Coal_Chunk.get(1L), 400, 4);
                break;
        }
    }
}
