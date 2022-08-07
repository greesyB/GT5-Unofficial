package gregtech.api.enums;

import gregtech.api.fluid.FluidTankGT;
import gregtech.api.interfaces.IIconContainer;
import gregtech.api.interfaces.internal.IGT_Mod;
import gregtech.api.interfaces.internal.IGT_RecipeAdder;
import gregtech.api.net.IGT_NetworkHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Made for static imports, this Class is just a Helper.
 * <p/>
 * I am doing this to have a better Table alike view on my Code, so I can change things faster using the Block Selection Mode of eclipse.
 * <p/>
 * Go to "Window > Preferences > Java > Editor > Content Assist > Favorites" to set static importable Constant Classes such as this one as AutoCompleteable.
 */
@SuppressWarnings("ALL")
public class GT_Values {
    // unused: A, C, D, G, H, I, J, K, N, O, Q, R, S, T

    // TODO: Rename Material Units to 'U'
    // TODO: Rename OrePrefixes Class to 'P'
    // TODO: Rename Materials Class to 'M'

    /**
     * Empty String for an easier Call Hierarchy
     */
    public static final String E = "";

    /**
     * The first 32 Bits
     */
    public static final int[] B = new int[]{
            1 << 0, 1 << 1, 1 << 2,
            1 << 3, 1 << 4, 1 << 5,
            1 << 6, 1 << 7, 1 << 8,
            1 << 9, 1 << 10, 1 << 11,
            1 << 12, 1 << 13, 1 << 14,
            1 << 15, 1 << 16, 1 << 17,
            1 << 18, 1 << 19, 1 << 20,
            1 << 21, 1 << 22, 1 << 23,
            1 << 24, 1 << 25, 1 << 26,
            1 << 27, 1 << 28, 1 << 29,
            1 << 30, 1 << 31};

    /**
     * Renamed from "MATERIAL_UNIT" to just "M"
     * <p/>
     * This is worth exactly one normal Item.
     * This Constant can be divided by many commonly used Numbers such as
     * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 24, ... 64 or 81
     * without losing precision and is for that reason used as Unit of Amount.
     * But it is also small enough to be multiplied with larger Numbers.
     * <p/>
     * This is used to determine the amount of Material contained inside a prefixed Ore.
     * For example Nugget = M / 9 as it contains out of 1/9 of an Ingot.
     */
    public static final long M = 3628800;

    /**
     * Renamed from "FLUID_MATERIAL_UNIT" to just "L"
     * <p/>
     * Fluid per Material Unit (Prime Factors: 3 * 3 * 2 * 2 * 2 * 2)
     */
    public static final long L = 144;

    /**
     * The Item WildCard Tag. Even shorter than the "-1" of the past
     */
    public static final short W = OreDictionary.WILDCARD_VALUE;

    /**
     * The Voltage Tiers. Use this Array instead of the old named Voltage Variables
     */
    public static final long[] V =
            new long[]{
                    8L, 32L, 128L,
                    512L, 2048L, 8192L,
                    32_768L, 131_072L, 524_288L,
                    2_097_152L, 8_388_608L, 33_554_432L,
                    134_217_728L, 536_870_912L, Integer.MAX_VALUE - 7,
                    // Error tier to prevent out of bounds errors. Not really a real tier (for now).
                    8_589_934_592L};
    // Why -7? Mystery of the universe. Something may break if you change this so please do not without extensive testing.
    //TODO:Adding that in coremod!!!
    //TODO:tier 14,15 wires and transformers only (not even cables !!!)
    //TODO:tier 12,13 the above + batteries, battery buffers, (maybe cables,12 also works for machines)
    //TODO:tier 10,11 the above + chargers and other machines, (cables would be nice)
    //TODO:tier 9     machines and batteries

    //TODO:AND ALL THE MATERIALS... for that
    //TODO:LIST OF MACHINES WITH POINTLESS TIERS (unless you implement some other tiering mechanism like reducing eu cost if time=1tick)
    //Macerator/Compressor/Furnace... and for cheap recipes any

    /**
     * keeping Voltage*Amps < Integer.MAX_VALUE-7 for machines (and tier logic 4x EUt 2/ time)
     * AMV[4]= max amps at tier 4
     */
    public static final long[] AatV =
            new long[]{
                    268435455, 67108863, 16777215,
                    4194303, 1048575, 262143,
                    65535, 16383, 4095,
                    1023, 255, 63,
                    15, 3, 1,
                    1};
    /**
     * The short Names for the Voltages
     */
    public static final String[] VN =
            new String[]{
                "ULV", // 0
                "LV",  // 1
                "MV",  // 2
                "HV",  // 3
                "EV",  // 4
                "IV",  // 5
                "LuV", // 6
                "ZPM", // 7
                "UV",  // 8
                "UHV", // 9
                "UEV", // 10
                "UIV", // 11
                "UMV", // 12
                "UXV", // 13
                "MAX", // 14
                "ERROR VOLTAGE" // 15
    };

    /**
     * The long Names for the Voltages
     */
    public static final String[] VOLTAGE_NAMES =
            new String[]{
                "Ultra Low Voltage",              // 0
                "Low Voltage",                    // 1
                "Medium Voltage",                 // 2
                "High Voltage",                   // 3
                "Extreme Voltage",                // 4
                "Insane Voltage",                 // 5
                "Ludicrous Voltage",              // 6
                "ZPM Voltage",                    // 7
                "Ultimate Voltage",               // 8
                "Ultimate High Voltage",          // 9
                "Ultimate Extreme Voltage",       // 10
                "Ultimate Insane Voltage",        // 11
                "Ultimate Mega Voltage",          // 12
                "Ultimate Extended Mega Voltage", // 13
                "Maximum Voltage",                // 14
                "Error Voltage, report this"      // 15
    };

    public static final String[] TIER_COLORS =
            new String[]{
                EnumChatFormatting.RED.toString(),          // ULV, 0
                EnumChatFormatting.GRAY.toString(),         // LV,  1
                EnumChatFormatting.AQUA.toString(),         // MV,  2
                EnumChatFormatting.GOLD.toString(),         // HV,  3
                EnumChatFormatting.DARK_PURPLE.toString(),  // EV,  4
                EnumChatFormatting.DARK_BLUE.toString(),    // IV,  5
                EnumChatFormatting.LIGHT_PURPLE.toString(), // LuV, 6
                EnumChatFormatting.WHITE.toString(),        // ZPM, 7
                EnumChatFormatting.DARK_AQUA.toString(),    // UV,  8
                EnumChatFormatting.DARK_RED.toString(),     // UHV, 9
                EnumChatFormatting.GREEN.toString(),        // UEV, 10
                EnumChatFormatting.DARK_GREEN.toString(),   // UIV, 11
                EnumChatFormatting.YELLOW.toString(),       // UMV, 12
                EnumChatFormatting.UNDERLINE.toString(),    // UXV, 13
                EnumChatFormatting.BOLD.toString(),         // MAX, 14
                EnumChatFormatting.OBFUSCATED.toString()    // ~~~, 15
    };

    /**
     * This way it is possible to have a Call Hierarchy of NullPointers in ItemStack based Functions, and also because most of the time I don't know what kind of Data Type the "null" stands for
     */
    public static final ItemStack NI = null;
    /**
     * This way it is possible to have a Call Hierarchy of NullPointers in FluidStack based Functions, and also because most of the time I don't know what kind of Data Type the "null" stands for
     */
    public static final FluidStack NF = null;
    /**
     * MOD ID Strings, since they are very common Parameters.
     */
    public static final String
            MOD_ID = "gregtech",
            MOD_ID_IC2 = "IC2",
            MOD_ID_NC = "IC2NuclearControl",
            MOD_ID_TC = "Thaumcraft",
            MOD_ID_TF = "TwilightForest",
            MOD_ID_RC = "Railcraft",
            MOD_ID_TE = "ThermalExpansion",
            MOD_ID_AE = "appliedenergistics2",
            MOD_ID_TFC = "terrafirmacraft",
            MOD_ID_PFAA = "PFAAGeologica",
            MOD_ID_FR = "Forestry",
            MOD_ID_HaC = "harvestcraft",
            MOD_ID_APC = "AppleCore",
            MOD_ID_MaCr = "magicalcrops",
            MOD_ID_GaEn = "ganysend",
            MOD_ID_GaSu = "ganyssurface",
            MOD_ID_GaNe = "ganysnether",
            MOD_ID_BC_SILICON = "BuildCraft|Silicon",
            MOD_ID_BC_TRANSPORT = "BuildCraft|Transport",
            MOD_ID_BC_FACTORY = "BuildCraft|Factory",
            MOD_ID_BC_ENERGY = "BuildCraft|Energy",
            MOD_ID_BC_BUILDERS = "BuildCraft|Builders",
            MOD_ID_BC_CORE = "BuildCraft|Core",
            MOD_ID_GC_CORE = "GalacticraftCore",
            MOD_ID_GC_MARS = "GalacticraftMars",
            MOD_ID_GC_PLANETS = "GalacticraftPlanets",
            MOD_ID_DC = "dreamcraft";
    /**
     * File Paths and Resource Paths
     */
    public static final String
            TEX_DIR = "textures/",
            TEX_DIR_GUI = TEX_DIR + "gui/",
            TEX_DIR_ITEM = TEX_DIR + "items/",
            TEX_DIR_BLOCK = TEX_DIR + "blocks/",
            TEX_DIR_ENTITY = TEX_DIR + "entity/",
            TEX_DIR_ASPECTS = TEX_DIR + "aspects/",
            RES_PATH = MOD_ID + ":" + TEX_DIR,
            RES_PATH_GUI = MOD_ID + ":" + TEX_DIR_GUI,
            RES_PATH_ITEM = MOD_ID + ":",
            RES_PATH_BLOCK = MOD_ID + ":",
            RES_PATH_ENTITY = MOD_ID + ":" + TEX_DIR_ENTITY,
            RES_PATH_ASPECTS = MOD_ID + ":" + TEX_DIR_ASPECTS,
            RES_PATH_IC2 = MOD_ID_IC2.toLowerCase(Locale.ENGLISH) + ":",
            RES_PATH_MODEL = MOD_ID + ":" + TEX_DIR + "models/";

    /**
     * NBT String Keys
     */
    public static class NBT {
        public static final String
            COLOR               = "gt.color",                // Integer
            CUSTOM_NAME         = "name",                    // String
            DISPAY              = "gt.display",              // String
            FACING              = "gt.facing",               // Byte
            LOCK_UPGRADE        = "gt.locked",               // Boolean
            MATERIAL            = "gt.material",             // String containing the Material Name.
            MODE                = "gt.mode",                 // Number
            ALLOWED_MODES       = "gt.amode",                // Number
            MTE_ID              = "gt.mte.id",               // Containing the MTE ID
            MTE_REG             = "gt.mte.reg",              // Containing the MTE Registry ID
            OWNER               = "gt.owner",                // String
            OWNER_UUID          = "gt.ownerUuid",            // UUID (String)

            // Machines
            ACTIVE              = "gt.active",               // Boolean
            FLUID_OUT           = "gt.fluidout",             // Output Fluid
            INV_OUT             = "gt.invout",               // ItemStack
            PARALLEL            = "gt.parallel",             // Number
            TANK_CAPACITY       = "gt.tankcap",              // Number
            TANK_IN             = "gt.tank.in.",             // FluidStack
            TANK_OUT            = "gt.tank.out.",            // FluidStack
            TEXTURE             = "gt.texture",              // String
            INV_SIZE            = "gt.invsize",              // Number
            INV_LIST            = "gt.invlist",              // NBT List

            // MultiBlock
            STRUCTURE_OK        = "gt.structure.ok",
            ROTATION            = "gt.eRotation",
            FLIP                = "gt.eFlip",
        	TARGET              = "gt.target",               // Boolean
            TARGET_X            = "gt.target.x",             // Number
            TARGET_Y            = "gt.target.y",             // Number
            TARGET_Z            = "gt.target.z",             // Number

            empty_              = "";
    }


    /** The Color White as RGB Short Array. */
    public static final short[] UNCOLORED_RBGA = {255, 255, 255, 255};
    /** The Color White as simple Integer (0x00ffffff). */
    public static final int UNCOLORED = 0x00ffffff;

    /**
     * Sides
     */
    public static final byte
        SIDE_BOTTOM    = 0, SIDE_DOWN      = 0,
        SIDE_TOP       = 1, SIDE_UP        = 1,
        SIDE_NORTH     = 2, // Also a Side with a stupidly mirrored Texture
        SIDE_SOUTH     = 3,
        SIDE_WEST      = 4,
        SIDE_EAST      = 5, // Also a Side with a stupidly mirrored Texture
        SIDE_ANY    = 6, SIDE_UNKNOWN   = 6, SIDE_INVALID = 6, SIDE_INSIDE = 6, SIDE_UNDEFINED = 6;

    /** Compass alike Array for the proper ordering of North, East, South and West. */
    public static final byte[] COMPASS_DIRECTIONS = {SIDE_NORTH, SIDE_EAST, SIDE_SOUTH, SIDE_WEST};


    /**
     * An Array containing all Sides which follow the Condition, in order to iterate over them for example.
     */
    public static final byte[]
        ALL_SIDES                    =  {0,1,2,3,4,5,6},
        ALL_VALID_SIDES              =  {0,1,2,3,4,5  };

    /**
     * For Facing Checks.
     */

    public static final boolean[]
        INVALID_SIDES           = { false, false, false, false, false, false, true  },
        VALID_SIDES             = { true,  true,  true,  true,  true,  true,  false };


    /**
     *  Side->Offset Mappings.
     */
    public static final byte[]
        OFFX = { 0, 0, 0, 0,-1,+1, 0},
        OFFY = {-1,+1, 0, 0, 0, 0, 0},
        OFFZ = { 0, 0,-1,+1, 0, 0, 0};

    /**
     *  Side->Opposite Mappings.
     **/
    public static final byte[]
        OPOS = { 1, 0, 3, 2, 5, 4, 6};

    /**
     * [Facing,Side]->Side Mappings for Blocks, which don't face up- and downwards.
     * 0 = bottom, 1 = top, 2 = left, 3 = front, 4 = right, 5 = back, 6 = undefined.
     */
    public static final byte[][] FACING_ROTATIONS = {
        {0,1,2,3,4,5,6},
        {0,1,2,3,4,5,6},
        {0,1,3,5,4,2,6},
        {0,1,5,3,2,4,6},
        {0,1,2,4,3,5,6},
        {0,1,4,2,5,3,6},
        {0,1,2,3,4,5,6}
    };

    /**
     * The Mod Object itself. That is the GT_Mod-Object. It's needed to open GUI's and similar.
     */
    public static IGT_Mod GT;
    /**
     * Use this Object to add Recipes. (Recipe Adder)
     */
    public static IGT_RecipeAdder RA;
    /**
     * For Internal Usage (Network)
     */
    public static IGT_NetworkHandler NW;
    /**
     * Control percentage of filled 3x3 chunks. Lower number means less oreveins spawn
     */
    public static int oreveinPercentage;
    /**
     * Control number of attempts to find a valid orevein. Generally this maximum limit isn't hit, selecting a vein is cheap
     */
    public static int oreveinAttempts;
    /**
     * Control number of attempts to place a valid orevein.  If a vein wasn't placed due to height restrictions, completely in the water, etc, another attempt is tried.
     */
    public static int oreveinMaxPlacementAttempts;
    /**
     * Whether or not to place small ores as placer ores for an orevein
     */
    public static boolean oreveinPlacerOres;
    /**
     * Multiplier to control how many placer ores get generated.
     */
    public static int oreveinPlacerOresMultiplier;
    /**
     * How wide to look for oreveins that affect a requested chunk. Trying to use oreveins larger than this will not work correctly. Increasing the size will cause additional worldgenerator lag.
     * Disabled for now, using 64 in Deep Dark, 32 elsewhere
     */
    // public static int oreveinMaxSize;
    /**
     * Not really Constants, but they set using the Config and therefore should be constant (those are for the Debug Mode)
     */
    public static boolean D1 = false, D2 = false;
    /**
     * Debug parameter for cleanroom testing.
     */
    public static boolean debugCleanroom = false;
    /**
     * Debug parameter for driller testing.
     */
    public static boolean debugDriller = false;
    /**
     * Debug parameter for world generation. Tracks chunks added/removed from run queue.
     */
    public static boolean debugWorldGen = false;
    /**
     * Debug parameter for orevein generation.
     */
    public static boolean debugOrevein = false;
    /**
     * Debug parameter for small ore generation.
     */
    public static boolean debugSmallOres = false;
    /**
     * Debug parameter for stones generation.
     */
    public static boolean debugStones = false;
    /**
     * Debug parameter for single block pump
     */
    public static boolean debugBlockPump = false;
    /**
     * Debug parameter for single block miner
     */
    public static boolean debugBlockMiner = false;
    /**
     * Debug parameter for entity cramming reduction
     */
    public static boolean debugEntityCramming = false;
    /**
     * Debug parameter for {@link gregtech.api.util.GT_ChunkAssociatedData}
     */
    public static boolean debugWorldData = false;
    /**
     * Number of ticks between sending sound packets to clients for electric machines. Default is 1.5 seconds. Trying to mitigate lag and FPS drops.
     */
    public static int ticksBetweenSounds = 30;
    /**
     * If you have to give something a World Parameter but there is no World... (Dummy World)
     */
    public static World DW;

    /**
     * This will prevent NEI from crashing but spams the Log.
     */
    public static boolean allow_broken_recipemap = false;
    /**
     * This will set the percentage how much ReinforcedGlass is Allowed in Cleanroom Walls.
     */
    public static float cleanroomGlass = 5.0f;
    /**
     * This will let machines such as drills and pumps chunkload their work area.
     */
    public static boolean enableChunkloaders = true;
    /**
     * This will make all chunkloading machines act as World Anchors (true) or Passive Anchors (false)
     */
    public static boolean alwaysReloadChunkloaders = false;

    public static boolean debugChunkloaders = false;
    public static boolean cls_enabled;
    public static final Set<String> mCTMEnabledBlock = new HashSet<>();
    public static final Set<String> mCTMDisabledBlock = new HashSet<>();

    public static boolean hideAssLineRecipes = false;
    public static boolean updateFluidDisplayItems = true;
    public static final int STEAM_PER_WATER = 160;
    /**
     *  If true, then digital chest with AE2 storage bus will be accessible only through AE2
     */
    public static boolean disableDigitalChestsExternalAccess = false;
    public static boolean lateConfigSave = true;
    public static boolean worldTickHappened = false;

    public static final int[] emptyIntArray = new int[0];


    public static final IFluidTank[] emptyFluidTank = new IFluidTank[0];
    public static final FluidTankGT[] emptyFluidTankGT = new FluidTankGT[0];
    public static final FluidTankInfo[] emptyFluidTankInfo = new FluidTankInfo[0];
    public static final FluidStack[] emptyFluidStack = new FluidStack[0];
    public static final ItemStack[] emptyItemStackArray = new ItemStack[0];
    public static final IIconContainer[] emptyIconContainerArray = new IIconContainer[3];

    /**
     *  Pretty formatting for author names.
     */
    public static final String AuthorColen = "Author: " +
        EnumChatFormatting.DARK_RED + EnumChatFormatting.BOLD + EnumChatFormatting.ITALIC + EnumChatFormatting.UNDERLINE + "C" +
        EnumChatFormatting.GOLD + EnumChatFormatting.BOLD + EnumChatFormatting.ITALIC + EnumChatFormatting.UNDERLINE + "o" +
        EnumChatFormatting.GREEN + EnumChatFormatting.BOLD + EnumChatFormatting.ITALIC + EnumChatFormatting.UNDERLINE + "l" +
        EnumChatFormatting.DARK_AQUA + EnumChatFormatting.BOLD + EnumChatFormatting.ITALIC + EnumChatFormatting.UNDERLINE + "e" +
        EnumChatFormatting.DARK_PURPLE + EnumChatFormatting.BOLD + EnumChatFormatting.ITALIC + EnumChatFormatting.UNDERLINE + "n";

}
