package bart.thaumicmachines.lib.handler;

import bart.thaumicmachines.lib.References;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

/**
 * Created by imdutch21 on 16-2-15.
 */
public class ConfigHandler
{

    public static Configuration configuration;
    //essentia vaporizer
    public static boolean enableEssentiaVaporizer;
    public static boolean enablePowerUpgrade;
    public static boolean enableRangeUpgrade;
    public static boolean enableEfficiencyUpgrade;
    public static boolean enableTimeUpgrade;
    public static double efficiencyUpgrade;
    public static double powerUpgrade;
    public static double timeUpgrade;
    public static int rangeUpgrade;
    public static int baseRangeUpgrade;

    //essentia effects
    public static boolean effectAIR;
    public static int effectAIRBasePower;
    public static int effectAIRRangeBoost;
    public static int effectAIRTime;
    public static int effectAIRUses;
    public static int effectAIRRefreshTime;

    public static boolean effectWATER;
    public static int effectWATERBasePower;
    public static int effectWATERRangeBoost;
    public static int effectWATERTime;
    public static int effectWATERUses;
    public static int effectWATERRefreshTime;

    public static boolean effectFIRE;
    public static int effectFIREBasePower;
    public static int effectFIRERangeBoost;
    public static int effectFIRETime;
    public static int effectFIREUses;
    public static int effectFIRERefreshTime;

    public static boolean effectEARTH;
    public static int effectEARTHBasePower;
    public static int effectEARTHRangeBoost;
    public static int effectEARTHTime;
    public static int effectEARTHUses;
    public static int effectEARTHRefreshTime;

    public static boolean effectORDER;
    public static int effectORDERBasePower;
    public static int effectORDERRangeBoost;
    public static int effectORDERTime;
    public static int effectORDERUses;
    public static int effectORDERRefreshTime;

    public static boolean effectENTROPY;
    public static int effectENTROPYBasePower;
    public static int effectENTROPYRangeBoost;
    public static int effectENTROPYTime;
    public static int effectENTROPYUses;
    public static int effectENTROPYRefreshTime;

    public static boolean effectVOID;
    public static int effectVOIDBasePower;
    public static int effectVOIDRangeBoost;
    public static int effectVOIDTime;
    public static int effectVOIDUses;
    public static int effectVOIDRefreshTime;

    public static boolean effectLIGHT;
    public static int effectLIGHTBasePower;
    public static int effectLIGHTRangeBoost;
    public static int effectLIGHTTime;
    public static int effectLIGHTUses;
    public static int effectLIGHTRefreshTime;

    public static boolean effectWEATHER;
    public static int effectWEATHERBasePower;
    public static int effectWEATHERRangeBoost;
    public static int effectWEATHERTime;
    public static int effectWEATHERUses;
    public static int effectWEATHERRefreshTime;

    public static boolean effectMOTION;
    public static int effectMOTIONBasePower;
    public static int effectMOTIONRangeBoost;
    public static int effectMOTIONTime;
    public static int effectMOTIONUses;
    public static int effectMOTIONRefreshTime;

    public static boolean effectCOLD;
    public static int effectCOLDBasePower;
    public static int effectCOLDRangeBoost;
    public static int effectCOLDTime;
    public static int effectCOLDUses;
    public static int effectCOLDRefreshTime;

    public static boolean effectCRYSTAL;
    public static int effectCRYSTALBasePower;
    public static int effectCRYSTALRangeBoost;
    public static int effectCRYSTALTime;
    public static int effectCRYSTALUses;
    public static int effectCRYSTALRefreshTime;

    public static boolean effectLIFE;
    public static int effectLIFEBasePower;
    public static int effectLIFERangeBoost;
    public static int effectLIFETime;
    public static int effectLIFEUses;
    public static int effectLIFERefreshTime;

    public static boolean effectPOISON;
    public static int effectPOISONBasePower;
    public static int effectPOISONRangeBoost;
    public static int effectPOISONTime;
    public static int effectPOISONUses;
    public static int effectPOISONRefreshTime;

    public static boolean effectENERGY;
    public static int effectENERGYBasePower;
    public static int effectENERGYRangeBoost;
    public static int effectENERGYTime;
    public static int effectENERGYUses;
    public static int effectENERGYRefreshTime;

    public static boolean effectEXCHANGE;
    public static int effectEXCHANGEBasePower;
    public static int effectEXCHANGERangeBoost;
    public static int effectEXCHANGETime;
    public static int effectEXCHANGEUses;
    public static int effectEXCHANGERefreshTime;

    public static boolean effectMETAL;
    public static int effectMETALBasePower;
    public static int effectMETALRangeBoost;
    public static int effectMETALTime;
    public static int effectMETALUses;
    public static int effectMETALRefreshTime;

    public static boolean effectDEATH;
    public static int effectDEATHBasePower;
    public static int effectDEATHRangeBoost;
    public static int effectDEATHTime;
    public static int effectDEATHUses;
    public static int effectDEATHRefreshTime;

    public static boolean effectFLIGHT;
    public static int effectFLIGHTBasePower;
    public static int effectFLIGHTRangeBoost;
    public static int effectFLIGHTTime;
    public static int effectFLIGHTUses;
    public static int effectFLIGHTRefreshTime;

    public static boolean effectDARKNESS;
    public static int effectDARKNESSBasePower;
    public static int effectDARKNESSRangeBoost;
    public static int effectDARKNESSTime;
    public static int effectDARKNESSUses;
    public static int effectDARKNESSRefreshTime;

    public static boolean effectSOUL;
    public static int effectSOULBasePower;
    public static int effectSOULRangeBoost;
    public static int effectSOULTime;
    public static int effectSOULUses;
    public static int effectSOULRefreshTime;

    public static boolean effectHEAL;
    public static int effectHEALBasePower;
    public static int effectHEALRangeBoost;
    public static int effectHEALTime;
    public static int effectHEALUses;
    public static int effectHEALRefreshTime;

    public static boolean effectTRAVEL;
    public static int effectTRAVELBasePower;
    public static int effectTRAVELRangeBoost;
    public static int effectTRAVELTime;
    public static int effectTRAVELUses;
    public static int effectTRAVELRefreshTime;

    public static boolean effectELDRITCH;
    public static int effectELDRITCHBasePower;
    public static int effectELDRITCHRangeBoost;
    public static int effectELDRITCHTime;
    public static int effectELDRITCHUses;
    public static int effectELDRITCHRefreshTime;

    public static boolean effectMAGIC;
    public static int effectMAGICBasePower;
    public static int effectMAGICRangeBoost;
    public static int effectMAGICTime;
    public static int effectMAGICUses;
    public static int effectMAGICRefreshTime;

    public static boolean effectAURA;
    public static int effectAURABasePower;
    public static int effectAURARangeBoost;
    public static int effectAURATime;
    public static int effectAURAUses;
    public static int effectAURARefreshTime;

    public static boolean effectTAINT;
    public static int effectTAINTBasePower;
    public static int effectTAINTRangeBoost;
    public static int effectTAINTTime;
    public static int effectTAINTUses;
    public static int effectTAINTRefreshTime;

    public static boolean effectSLIME;
    public static int effectSLIMEBasePower;
    public static int effectSLIMERangeBoost;
    public static int effectSLIMETime;
    public static int effectSLIMEUses;
    public static int effectSLIMERefreshTime;

    public static boolean effectPLANT;
    public static int effectPLANTBasePower;
    public static int effectPLANTRangeBoost;
    public static int effectPLANTTime;
    public static int effectPLANTUses;
    public static int effectPLANTRefreshTime;

    public static boolean effectTREE;
    public static int effectTREEBasePower;
    public static int effectTREERangeBoost;
    public static int effectTREETime;
    public static int effectTREEUses;
    public static int effectTREERefreshTime;

    public static boolean effectBEAST;
    public static int effectBEASTBasePower;
    public static int effectBEASTRangeBoost;
    public static int effectBEASTTime;
    public static int effectBEASTUses;
    public static int effectBEASTRefreshTime;

    public static boolean effectUNDEAD;
    public static int effectUNDEADBasePower;
    public static int effectUNDEADRangeBoost;
    public static int effectUNDEADTime;
    public static int effectUNDEADUses;
    public static int effectUNDEADRefreshTime;

    public static boolean effectMIND;
    public static int effectMINDBasePower;
    public static int effectMINDRangeBoost;
    public static int effectMINDTime;
    public static int effectMINDUses;
    public static int effectMINDRefreshTime;

    public static boolean effectSENSES;
    public static int effectSENSESBasePower;
    public static int effectSENSESRangeBoost;
    public static int effectSENSESTime;
    public static int effectSENSESUses;
    public static int effectSENSESRefreshTime;

    public static boolean effectMAN;
    public static int effectMANBasePower;
    public static int effectMANRangeBoost;
    public static int effectMANTime;
    public static int effectMANUses;
    public static int effectMANRefreshTime;

    public static boolean effectCROP;
    public static int effectCROPBasePower;
    public static int effectCROPRangeBoost;
    public static int effectCROPTime;
    public static int effectCROPUses;
    public static int effectCROPRefreshTime;

    public static boolean effectMINE;
    public static int effectMINEBasePower;
    public static int effectMINERangeBoost;
    public static int effectMINETime;
    public static int effectMINEUses;
    public static int effectMINERefreshTime;

    public static boolean effectTOOL;
    public static int effectTOOLBasePower;
    public static int effectTOOLRangeBoost;
    public static int effectTOOLTime;
    public static int effectTOOLUses;
    public static int effectTOOLRefreshTime;

    public static boolean effectHARVEST;
    public static int effectHARVESTBasePower;
    public static int effectHARVESTRangeBoost;
    public static int effectHARVESTTime;
    public static int effectHARVESTUses;
    public static int effectHARVESTRefreshTime;

    public static boolean effectWEAPON;
    public static int effectWEAPONBasePower;
    public static int effectWEAPONRangeBoost;
    public static int effectWEAPONTime;
    public static int effectWEAPONUses;
    public static int effectWEAPONRefreshTime;

    public static boolean effectARMOR;
    public static int effectARMORBasePower;
    public static int effectARMORRangeBoost;
    public static int effectARMORTime;
    public static int effectARMORUses;
    public static int effectARMORRefreshTime;

    public static boolean effectHUNGER;
    public static int effectHUNGERBasePower;
    public static int effectHUNGERRangeBoost;
    public static int effectHUNGERTime;
    public static int effectHUNGERUses;
    public static int effectHUNGERRefreshTime;

    public static boolean effectGREED;
    public static int effectGREEDBasePower;
    public static int effectGREEDRangeBoost;
    public static int effectGREEDTime;
    public static int effectGREEDUses;
    public static int effectGREEDRefreshTime;

    public static boolean effectCRAFT;
    public static int effectCRAFTBasePower;
    public static int effectCRAFTRangeBoost;
    public static int effectCRAFTTime;
    public static int effectCRAFTUses;
    public static int effectCRAFTRefreshTime;

    public static boolean effectCLOTH;
    public static int effectCLOTHBasePower;
    public static int effectCLOTHRangeBoost;
    public static int effectCLOTHTime;
    public static int effectCLOTHUses;
    public static int effectCLOTHRefreshTime;

    public static boolean effectMECHANISM;
    public static int effectMECHANISMBasePower;
    public static int effectMECHANISMRangeBoost;
    public static int effectMECHANISMTime;
    public static int effectMECHANISMUses;
    public static int effectMECHANISMRefreshTime;

    public static boolean effectTRAP;
    public static int effectTRAPBasePower;
    public static int effectTRAPRangeBoost;
    public static int effectTRAPTime;
    public static int effectTRAPUses;
    public static int effectTRAPRefreshTime;

    //entity

    //mod integration

    //crafting


    public static void Init(File configFile)
    {
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        //stuff for the essentia vaporizer

        Property EssentiaMachine = configuration.get(".EssentiaVaporizer", "Enable Essentia Vaporizer", true);
        EssentiaMachine.comment = "Enable the crafting of the EssentiaVaporizer. Default: true";
        enableEssentiaVaporizer = EssentiaMachine.getBoolean();
        Property EnableEfficiencyUpgrade = configuration.get(".EssentiaVaporizer", "Enable upgrade", true);
        EnableEfficiencyUpgrade.comment = "Enable the crafting of the efficiency upgrade. Default: true";
        enableEfficiencyUpgrade = EnableEfficiencyUpgrade.getBoolean();
        Property EfficiencyUpgrade = configuration.get(".EssentiaVaporizer", "Upgrading efficiency", .25);
        EfficiencyUpgrade.comment = "Set the amount each efficiency upgrade will add (.25 will add 1/4). Default: .25";
        efficiencyUpgrade = EfficiencyUpgrade.getDouble();
        Property EnableRangeUpgrade = configuration.get(".EssentiaVaporizer", "Enable upgrade", true);
        EnableRangeUpgrade.comment = "Enable the crafting of the Ranger upgrade. Default: true";
        enableRangeUpgrade = EnableRangeUpgrade.getBoolean();
        Property RangeUpgrade = configuration.get(".EssentiaVaporizer", "Upgrading range", 2);
        RangeUpgrade.comment = "Set the amount each range upgrade will add to the base range of effect. Default: 2";
        rangeUpgrade = RangeUpgrade.getInt();
        Property BaseRange = configuration.get(".EssentiaVaporizer", "Base range", 5);
        BaseRange.comment = "This sets the base range of effect. Default 5";
        baseRangeUpgrade = BaseRange.getInt();
        Property EnablePowerUpgrade = configuration.get(".EssentiaVaporizer", "Enable upgrade", true);
        EnablePowerUpgrade.comment = "Enable the crafting of the Power upgrade. Default: true";
        enablePowerUpgrade = EnablePowerUpgrade.getBoolean();
        Property PowerUpgrade = configuration.get(".EssentiaVaporizer", "Upgrading power", .5);
        PowerUpgrade.comment = "Set the amount each power upgrade will add (.5 will add 1/2). Default: .5";
        powerUpgrade = PowerUpgrade.getDouble();
        Property EnableTimeUpgrade = configuration.get(".EssentiaVaporizer", "Enable Upgrade", true);
        EnableTimeUpgrade.comment = "Enable the crafting of the Time upgrade. Default: true";
        enableTimeUpgrade = EnableTimeUpgrade.getBoolean();
        Property TimeUpgrade = configuration.get(".EssentiaVaporizer", "Upgrading time", .5);
        PowerUpgrade.comment = "Set the amount each power upgrade will reduce (.5 will add 1/2). Default: .5";
        powerUpgrade = PowerUpgrade.getDouble();
        //all the effect stuff

        //AIR
        Property AIR = configuration.get("AIR", "Effect AIR", true);
        AIR.comment = "Enable effect for AIR. Default: true";
        effectAIR = AIR.getBoolean();
        Property AIRBasePower = configuration.get("AIR", "Base strength AIR", 1);
        AIRBasePower.comment = "Sets the base power for the effects AIR gives. Default 1";
        effectAIRBasePower = AIRBasePower.getInt();
        Property AIRRangeBoost = configuration.get("AIR", "Range boost AIR", 0);
        AIRRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectAIRRangeBoost = AIRRangeBoost.getInt();
        Property AIRTime = configuration.get("AIR", "Base time AIR", 20);
        AIRTime.comment = "Sets the base time effects will last that AIR gives. Default 20";
        effectAIRTime = AIRTime.getInt();
        Property AIRUses = configuration.get("AIR", "Base uses AIR", 150);
        AIRUses.comment = "Sets the base amount of time (by default 1) AIR essentia gives you. Default 100";
        effectAIRUses = AIRUses.getInt();
        Property AIRRefreshTime = configuration.get("AIR", "Base refresh time AIR", 10);
        AIRRefreshTime.comment = "Sets the base amount of time between each time the AIR applies an effect. Default 10";
        effectAIRRefreshTime = AIRRefreshTime.getInt();

        //WATER
        Property WATER = configuration.get("WATER", "Effect WATER", true);
        WATER.comment = "Enable effect for WATER. Default: true";
        effectWATER = WATER.getBoolean();
        Property WATERBasePower = configuration.get("WATER", "Base strength WATER", 2);
        WATERBasePower.comment = "Sets the base power for the effects WATER gives. Default 2";
        effectWATERBasePower = WATERBasePower.getInt();
        Property WATERRangeBoost = configuration.get("WATER", "Range boost WATER", 0);
        WATERRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectWATERRangeBoost = WATERRangeBoost.getInt();
        Property WATERTime = configuration.get("WATER", "Base time WATER", 20);
        WATERTime.comment = "Sets the base time effects will last that WATER gives. Default 20";
        effectWATERTime = WATERTime.getInt();
        Property WATERUses = configuration.get("WATER", "Base uses WATER", 220);
        WATERUses.comment = "Sets the base amount of time (by default 1) WATER essentia gives you. Default 220";
        effectWATERUses = WATERUses.getInt();
        Property WATERRefreshTime = configuration.get("WATER", "Base refresh time WATER", 10);
        WATERRefreshTime.comment = "Sets the base amount of time between each time the WATER applies an effect. Default 10";
        effectWATERRefreshTime = WATERRefreshTime.getInt();

        //FIRE
        Property FIRE = configuration.get("FIRE", "Effect FIRE", true);
        FIRE.comment = "Enable effect for FIRE. Default: true";
        effectFIRE = FIRE.getBoolean();
        Property FIREBasePower = configuration.get("FIRE", "Base strength FIRE", 0);
        FIREBasePower.comment = "Sets the base power for the effects FIRE gives. Default 0 //not used";
        effectFIREBasePower = FIREBasePower.getInt();
        Property FIRERangeBoost = configuration.get("FIRE", "Range boost FIRE", 0);
        FIRERangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectFIRERangeBoost = FIRERangeBoost.getInt();
        Property FIRETime = configuration.get("FIRE", "Base time FIRE", 20);
        FIRETime.comment = "Sets the base time effects will last that FIRE gives. Default 20";
        effectFIRETime = FIRETime.getInt();
        Property FIREUses = configuration.get("FIRE", "Base uses FIRE", 6);
        FIREUses.comment = "Sets the base amount of time (by default 1) FIRE essentia gives you. Default 6";
        effectFIREUses = FIREUses.getInt();
        Property FIRERefreshTime = configuration.get("FIRE", "Base refresh time FIRE", 10);
        FIRERefreshTime.comment = "Sets the base amount of time between each time the FIRE applies an effect. Default 10";
        effectFIRERefreshTime = FIRERefreshTime.getInt();

        //EARTH
        Property EARTH = configuration.get("EARTH", "Effect EARTH", true);
        EARTH.comment = "Enable effect for EARTH. Default: true //does nothing for now";
        effectEARTH = EARTH.getBoolean();
        Property EARTHBasePower = configuration.get("EARTH", "Base strength EARTH", 1);
        EARTHBasePower.comment = "Sets the base power for the effects EARTH gives. Default 1";
        effectEARTHBasePower = EARTHBasePower.getInt();
        Property EARTHRangeBoost = configuration.get("EARTH", "Range boost EARTH", 0);
        EARTHRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectEARTHRangeBoost = EARTHRangeBoost.getInt();
        Property EARTHTime = configuration.get("EARTH", "Base time EARTH", 20);
        EARTHTime.comment = "Sets the base time effects will last that EARTH gives. Default 20";
        effectEARTHTime = EARTHTime.getInt();
        Property EARTHUses = configuration.get("EARTH", "Base uses EARTH", 100);
        EARTHUses.comment = "Sets the base amount of time (by default 1) EARTH essentia gives you. Default 100";
        effectEARTHUses = EARTHUses.getInt();
        Property EARTHRefreshTime = configuration.get("EARTH", "Base refresh time EARTH", 10);
        EARTHRefreshTime.comment = "Sets the base amount of time between each time the EARTH applies an effect. Default 10";
        effectEARTHRefreshTime = EARTHRefreshTime.getInt();

        //ORDER
        Property ORDER = configuration.get("ORDER", "Effect ORDER", true);
        ORDER.comment = "Enable effect for ORDER. Default: true //does nothing for now";
        effectORDER = ORDER.getBoolean();
        Property ORDERBasePower = configuration.get("ORDER", "Base strength ORDER", 1);
        ORDERBasePower.comment = "Sets the base power for the effects ORDER gives. Default 1";
        effectORDERBasePower = ORDERBasePower.getInt();
        Property ORDERRangeBoost = configuration.get("ORDER", "Range boost ORDER", 0);
        ORDERRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectORDERRangeBoost = ORDERRangeBoost.getInt();
        Property ORDERTime = configuration.get("ORDER", "Base time ORDER", 20);
        ORDERTime.comment = "Sets the base time effects will last that ORDER gives. Default 20";
        effectORDERTime = ORDERTime.getInt();
        Property ORDERUses = configuration.get("ORDER", "Base uses ORDER", 100);
        ORDERUses.comment = "Sets the base amount of time (by default 1) ORDER essentia gives you. Default 100";
        effectORDERUses = ORDERUses.getInt();
        Property ORDERRefreshTime = configuration.get("ORDER", "Base refresh time ORDER", 10);
        ORDERRefreshTime.comment = "Sets the base amount of time between each time the ORDER applies an effect. Default 10";
        effectORDERRefreshTime = ORDERRefreshTime.getInt();

        //ENTROPY
        Property ENTROPY = configuration.get("ENTROPY", "Effect ENTROPY", true);
        ENTROPY.comment = "Enable effect for ENTROPY. Default: true";
        effectENTROPY = ENTROPY.getBoolean();
        Property ENTROPYBasePower = configuration.get("ENTROPY", "Base strength ENTROPY", 0);
        ENTROPYBasePower.comment = "Sets the base power for the effects ENTROPY gives. Default 0 //not used";
        effectENTROPYBasePower = ENTROPYBasePower.getInt();
        Property ENTROPYRangeBoost = configuration.get("ENTROPY", "Range boost ENTROPY", 0);
        ENTROPYRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectENTROPYRangeBoost = ENTROPYRangeBoost.getInt();
        Property ENTROPYTime = configuration.get("ENTROPY", "Base time ENTROPY", 0);
        ENTROPYTime.comment = "Sets the base time effects will last that ENTROPY gives. Default 0 //not used";
        effectENTROPYTime = ENTROPYTime.getInt();
        Property ENTROPYUses = configuration.get("ENTROPY", "Base uses ENTROPY", 10);
        ENTROPYUses.comment = "Sets the base amount of time (by default 1) ENTROPY essentia gives you. Default 10";
        effectENTROPYUses = ENTROPYUses.getInt();
        Property ENTROPYRefreshTime = configuration.get("ENTROPY", "Base refresh time ENTROPY", 400);
        ENTROPYRefreshTime.comment = "Sets the base amount of time between each time the ENTROPY applies an effect. Default 10";
        effectENTROPYRefreshTime = ENTROPYRefreshTime.getInt();

        //VOID
        Property VOID = configuration.get("VOID", "Effect VOID", true);
        VOID.comment = "Enable effect for VOID. Default: true //does nothing for now";
        effectVOID = VOID.getBoolean();
        Property VOIDBasePower = configuration.get("VOID", "Base strength VOID", 1);
        VOIDBasePower.comment = "Sets the base power for the effects VOID gives. Default 1";
        effectVOIDBasePower = VOIDBasePower.getInt();
        Property VOIDRangeBoost = configuration.get("VOID", "Range boost VOID", 0);
        VOIDRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectVOIDRangeBoost = VOIDRangeBoost.getInt();
        Property VOIDTime = configuration.get("VOID", "Base time VOID", 20);
        VOIDTime.comment = "Sets the base time effects will last that VOID gives. Default 20";
        effectVOIDTime = VOIDTime.getInt();
        Property VOIDUses = configuration.get("VOID", "Base uses VOID", 100);
        VOIDUses.comment = "Sets the base amount of time (by default 1) VOID essentia gives you. Default 100";
        effectVOIDUses = VOIDUses.getInt();
        Property VOIDRefreshTime = configuration.get("VOID", "Base refresh time VOID", 10);
        VOIDRefreshTime.comment = "Sets the base amount of time between each time the VOID applies an effect. Default 10";
        effectVOIDRefreshTime = VOIDRefreshTime.getInt();

        //LIGHT
        Property LIGHT = configuration.get("LIGHT", "Effect LIGHT", true);
        LIGHT.comment = "Enable effect for LIGHT. Default: true //does nothing for now";
        effectLIGHT = LIGHT.getBoolean();
        Property LIGHTBasePower = configuration.get("LIGHT", "Base strength LIGHT", 1);
        LIGHTBasePower.comment = "Sets the base power for the effects LIGHT gives. Default 1";
        effectLIGHTBasePower = LIGHTBasePower.getInt();
        Property LIGHTRangeBoost = configuration.get("LIGHT", "Range boost LIGHT", 0);
        LIGHTRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectLIGHTRangeBoost = LIGHTRangeBoost.getInt();
        Property LIGHTTime = configuration.get("LIGHT", "Base time LIGHT", 20);
        LIGHTTime.comment = "Sets the base time effects will last that LIGHT gives. Default 20";
        effectLIGHTTime = LIGHTTime.getInt();
        Property LIGHTUses = configuration.get("LIGHT", "Base uses LIGHT", 100);
        LIGHTUses.comment = "Sets the base amount of time (by default 1) LIGHT essentia gives you. Default 100";
        effectLIGHTUses = LIGHTUses.getInt();
        Property LIGHTRefreshTime = configuration.get("LIGHT", "Base refresh time LIGHT", 10);
        LIGHTRefreshTime.comment = "Sets the base amount of time between each time the LIGHT applies an effect. Default 10";
        effectLIGHTRefreshTime = LIGHTRefreshTime.getInt();

        //WEATHER
        Property WEATHER = configuration.get("WEATHER", "Effect WEATHER", true);
        WEATHER.comment = "Enable effect for WEATHER. Default: true";
        effectWEATHER = WEATHER.getBoolean();
        Property WEATHERBasePower = configuration.get("WEATHER", "Base strength WEATHER", 0);
        WEATHERBasePower.comment = "Sets the base power for the effects WEATHER gives. Default 0 //no use";
        effectWEATHERBasePower = WEATHERBasePower.getInt();
        Property WEATHERRangeBoost = configuration.get("LIGT", "Range boost WEATHER", 0);
        WEATHERRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectWEATHERRangeBoost = WEATHERRangeBoost.getInt();
        Property WEATHERTime = configuration.get("WEATHER", "Base time WEATHER", 0);
        WEATHERTime.comment = "Sets the base time effects will last that WEATHER gives. Default 0 //no use";
        effectWEATHERTime = WEATHERTime.getInt();
        Property WEATHERUses = configuration.get("WEATHER", "Base uses WEATHER", 10);
        WEATHERUses.comment = "Sets the base amount of time (by default 1) WEATHER essentia gives you. Default 10";
        effectWEATHERUses = WEATHERUses.getInt();
        Property WEATHERRefreshTime = configuration.get("WEATHER", "Base refresh time WEATHER", 600);
        WEATHERRefreshTime.comment = "Sets the base amount of time between each time the WEATHER applies an effect. Default 600";
        effectWEATHERRefreshTime = WEATHERRefreshTime.getInt();

        //MOTION
        Property MOTION = configuration.get("MOTION", "Effect MOTION", true);
        MOTION.comment = "Enable effect for MOTION. Default: true";
        effectMOTION = MOTION.getBoolean();
        Property MOTIONBasePower = configuration.get("MOTION", "Base strength MOTION", 2);
        MOTIONBasePower.comment = "Sets the base power for the effects MOTION gives. Default 2";
        effectMOTIONBasePower = MOTIONBasePower.getInt();
        Property MOTIONRangeBoost = configuration.get("MOTION", "Range boost MOTION", 0);
        MOTIONRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectMOTIONRangeBoost = MOTIONRangeBoost.getInt();
        Property MOTIONTime = configuration.get("MOTION", "Base time MOTION", 20);
        MOTIONTime.comment = "Sets the base time effects will last that MOTION gives. Default 20";
        effectMOTIONTime = MOTIONTime.getInt();
        Property MOTIONUses = configuration.get("MOTION", "Base uses MOTION", 250);
        MOTIONUses.comment = "Sets the base amount of time (by default 1) MOTION essentia gives you. Default 250";
        effectMOTIONUses = MOTIONUses.getInt();
        Property MOTIONRefreshTime = configuration.get("MOTION", "Base refresh time MOTION", 10);
        MOTIONRefreshTime.comment = "Sets the base amount of time between each time the MOTION applies an effect. Default 10";
        effectMOTIONRefreshTime = MOTIONRefreshTime.getInt();

        //COLD
        Property COLD = configuration.get("COLD", "Effect COLD", true);
        COLD.comment = "Enable effect for COLD. Default: true //does nothing for now";
        effectCOLD = COLD.getBoolean();
        Property COLDBasePower = configuration.get("COLD", "Base strength COLD", 1);
        COLDBasePower.comment = "Sets the base power for the effects COLD gives. Default 1";
        effectCOLDBasePower = COLDBasePower.getInt();
        Property COLDRangeBoost = configuration.get("COLD", "Range boost COLD", 0);
        COLDRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectCOLDRangeBoost = COLDRangeBoost.getInt();
        Property COLDTime = configuration.get("COLD", "Base time COLD", 20);
        COLDTime.comment = "Sets the base time effects will last that COLD gives. Default 20";
        effectCOLDTime = COLDTime.getInt();
        Property COLDUses = configuration.get("COLD", "Base uses COLD", 100);
        COLDUses.comment = "Sets the base amount of time (by default 1) COLD essentia gives you. Default 100";
        effectCOLDUses = COLDUses.getInt();
        Property COLDRefreshTime = configuration.get("COLD", "Base refresh time COLD", 10);
        COLDRefreshTime.comment = "Sets the base amount of time between each time the COLD applies an effect. Default 10";
        effectCOLDRefreshTime = COLDRefreshTime.getInt();

        //CRYSTAL
        Property CRYSTAL = configuration.get("CRYSTAL", "Effect CRYSTAL", true);
        CRYSTAL.comment = "Enable effect for CRYSTAL. Default: true //does nothing for now";
        effectCRYSTAL = CRYSTAL.getBoolean();
        Property CRYSTALBasePower = configuration.get("CRYSTAL", "Base strength CRYSTAL", 1);
        CRYSTALBasePower.comment = "Sets the base power for the effects CRYSTAL gives. Default 1";
        effectCRYSTALBasePower = CRYSTALBasePower.getInt();
        Property CRYSTALRangeBoost = configuration.get("CRYSTAL", "Range boost CRYSTAL", 0);
        CRYSTALRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectCRYSTALRangeBoost = CRYSTALRangeBoost.getInt();
        Property CRYSTALTime = configuration.get("CRYSTAL", "Base time CRYSTAL", 20);
        CRYSTALTime.comment = "Sets the base time effects will last that CRYSTAL gives. Default 20";
        effectCRYSTALTime = CRYSTALTime.getInt();
        Property CRYSTALUses = configuration.get("CRYSTAL", "Base uses CRYSTAL", 100);
        CRYSTALUses.comment = "Sets the base amount of time (by default 1) CRYSTAL essentia gives you. Default 100";
        effectCRYSTALUses = CRYSTALUses.getInt();
        Property CRYSTALRefreshTime = configuration.get("CRYSTAL", "Base refresh time CRYSTAL", 10);
        CRYSTALRefreshTime.comment = "Sets the base amount of time between each time the CRYSTAL applies an effect. Default 10";
        effectCRYSTALRefreshTime = CRYSTALRefreshTime.getInt();

        //LIFE
        Property LIFE = configuration.get("LIFE", "Effect LIFE", true);
        LIFE.comment = "Enable effect for LIFE. Default: true";
        effectLIFE = LIFE.getBoolean();
        Property LIFEBasePower = configuration.get("LIFE", "Base strength LIFE", 1);
        LIFEBasePower.comment = "Sets the base power for the effects LIFE gives. Default 1";
        effectLIFEBasePower = LIFEBasePower.getInt();
        Property LIFERangeBoost = configuration.get("LIFE", "Range boost LIFE", 0);
        LIFERangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectLIFERangeBoost = LIFERangeBoost.getInt();
        Property LIFETime = configuration.get("LIFE", "Base time LIFE", 20);
        LIFETime.comment = "Sets the base time effects will last that LIFE gives. Default 20";
        effectLIFETime = LIFETime.getInt();
        Property LIFEUses = configuration.get("LIFE", "Base uses LIFE", 30);
        LIFEUses.comment = "Sets the base amount of time (by default 1) LIFE essentia gives you. Default 30";
        effectLIFEUses = LIFEUses.getInt();
        Property LIFERefreshTime = configuration.get("LIFE", "Base refresh time LIFE", 10);
        LIFERefreshTime.comment = "Sets the base amount of time between each time the LIFE applies an effect. Default 10";
        effectLIFERefreshTime = LIFERefreshTime.getInt();

        //POISON
        Property POISON = configuration.get("POISON", "Effect POISON", true);
        POISON.comment = "Enable effect for POISON. Default: true";
        effectPOISON = POISON.getBoolean();
        Property POISONBasePower = configuration.get("POISON", "Base strength POISON", 1);
        POISONBasePower.comment = "Sets the base power for the effects POISON gives. Default 1";
        effectPOISONBasePower = POISONBasePower.getInt();
        Property POISONRangeBoost = configuration.get("POISON", "Range boost POISON", 0);
        POISONRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectPOISONRangeBoost = POISONRangeBoost.getInt();
        Property POISONTime = configuration.get("POISON", "Base time POISON", 60);
        POISONTime.comment = "Sets the base time effects will last that POISON gives. Default 60";
        effectPOISONTime = POISONTime.getInt();
        Property POISONUses = configuration.get("POISON", "Base uses POISON", 80);
        POISONUses.comment = "Sets the base amount of time (by default 1) POISON essentia gives you. Default 80";
        effectPOISONUses = POISONUses.getInt();
        Property POISONRefreshTime = configuration.get("POISON", "Base refresh time POISON", 100);
        POISONRefreshTime.comment = "Sets the base amount of time between each time the POISON applies an effect. Default 100";
        effectPOISONRefreshTime = POISONRefreshTime.getInt();

        //ENERGY
        Property ENERGY = configuration.get("ENERGY", "Effect ENERGY", true);
        ENERGY.comment = "Enable effect for ENERGY. Default: true";
        effectENERGY = ENERGY.getBoolean();
        Property ENERGYBasePower = configuration.get("ENERGY", "Base strength ENERGY", 1);
        ENERGYBasePower.comment = "Sets the base power for the effects ENERGY gives. Default 1";
        effectENERGYBasePower = ENERGYBasePower.getInt();
        Property ENERGYRangeBoost = configuration.get("ENERGY", "Range boost ENERGY", 0);
        ENERGYRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectENERGYRangeBoost = ENERGYRangeBoost.getInt();
        Property ENERGYTime = configuration.get("ENERGY", "Base time ENERGY", 15);
        ENERGYTime.comment = "Sets the base time effects will last that ENERGY gives. Default 15";
        effectENERGYTime = ENERGYTime.getInt();
        Property ENERGYUses = configuration.get("ENERGY", "Base uses ENERGY", 180);
        ENERGYUses.comment = "Sets the base amount of time (by default 1) ENERGY essentia gives you. Default 180";
        effectENERGYUses = ENERGYUses.getInt();
        Property ENERGYRefreshTime = configuration.get("ENERGY", "Base refresh time ENERGY", 10);
        ENERGYRefreshTime.comment = "Sets the base amount of time between each time the ENERGY applies an effect. Default 10";
        effectENERGYRefreshTime = ENERGYRefreshTime.getInt();

        //EXCHANGE
        Property EXCHANGE = configuration.get("EXCHANGE", "Effect EXCHANGE", true);
        EXCHANGE.comment = "Enable effect for EXCHANGE. Default: true //does nothing for now";
        effectEXCHANGE = EXCHANGE.getBoolean();
        Property EXCHANGEBasePower = configuration.get("EXCHANGE", "Base strength EXCHANGE", 1);
        EXCHANGEBasePower.comment = "Sets the base power for the effects EXCHANGE gives. Default 1";
        effectEXCHANGEBasePower = EXCHANGEBasePower.getInt();
        Property EXCHANGERangeBoost = configuration.get("EXCHANGE", "Range boost EXCHANGE", 0);
        EXCHANGERangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectEXCHANGERangeBoost = EXCHANGERangeBoost.getInt();
        Property EXCHANGETime = configuration.get("EXCHANGE", "Base time EXCHANGE", 20);
        EXCHANGETime.comment = "Sets the base time effects will last that EXCHANGE gives. Default 20";
        effectEXCHANGETime = EXCHANGETime.getInt();
        Property EXCHANGEUses = configuration.get("EXCHANGE", "Base uses EXCHANGE", 100);
        EXCHANGEUses.comment = "Sets the base amount of time (by default 1) EXCHANGE essentia gives you. Default 100";
        effectEXCHANGEUses = EXCHANGEUses.getInt();
        Property EXCHANGERefreshTime = configuration.get("EXCHANGE", "Base refresh time EXCHANGE", 10);
        EXCHANGERefreshTime.comment = "Sets the base amount of time between each time the EXCHANGE applies an effect. Default 10";
        effectEXCHANGERefreshTime = EXCHANGERefreshTime.getInt();

        //METAL
        Property METAL = configuration.get("METAL", "Effect METAL", true);
        METAL.comment = "Enable effect for METAL. Default: true //does nothing for now";
        effectMETAL = METAL.getBoolean();
        Property METALBasePower = configuration.get("METAL", "Base strength METAL", 1);
        METALBasePower.comment = "Sets the base power for the effects METAL gives. Default 1";
        effectMETALBasePower = METALBasePower.getInt();
        Property METALRangeBoost = configuration.get("METAL", "Range boost METAL", 0);
        METALRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectMETALRangeBoost = METALRangeBoost.getInt();
        Property METALTime = configuration.get("METAL", "Base time METAL", 20);
        METALTime.comment = "Sets the base time effects will last that METAL gives. Default 20";
        effectMETALTime = METALTime.getInt();
        Property METALUses = configuration.get("METAL", "Base uses METAL", 100);
        METALUses.comment = "Sets the base amount of time (by default 1) METAL essentia gives you. Default 100";
        effectMETALUses = METALUses.getInt();
        Property METALRefreshTime = configuration.get("METAL", "Base refresh time METAL", 10);
        METALRefreshTime.comment = "Sets the base amount of time between each time the METAL applies an effect. Default 10";
        effectMETALRefreshTime = METALRefreshTime.getInt();

        //DEATH
        Property DEATH = configuration.get("DEATH", "Effect DEATH", true);
        DEATH.comment = "Enable effect for DEATH. Default: true //does nothing for now";
        effectDEATH = DEATH.getBoolean();
        Property DEATHBasePower = configuration.get("DEATH", "Base strength DEATH", 1);
        DEATHBasePower.comment = "Sets the base power for the effects DEATH gives. Default 1";
        effectDEATHBasePower = DEATHBasePower.getInt();
        Property DEATHRangeBoost = configuration.get("DEATH", "Range boost DEATH", 0);
        DEATHRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectDEATHRangeBoost = DEATHRangeBoost.getInt();
        Property DEATHTime = configuration.get("DEATH", "Base time DEATH", 20);
        DEATHTime.comment = "Sets the base time effects will last that DEATH gives. Default 20";
        effectDEATHTime = DEATHTime.getInt();
        Property DEATHUses = configuration.get("DEATH", "Base uses DEATH", 100);
        DEATHUses.comment = "Sets the base amount of time (by default 1) DEATH essentia gives you. Default 100";
        effectDEATHUses = DEATHUses.getInt();
        Property DEATHRefreshTime = configuration.get("DEATH", "Base refresh time DEATH", 10);
        DEATHRefreshTime.comment = "Sets the base amount of time between each time the DEATH applies an effect. Default 10";
        effectDEATHRefreshTime = DEATHRefreshTime.getInt();

        //FLIGHT
        Property FLIGHT = configuration.get("FLIGHT", "Effect FLIGHT", true);
        FLIGHT.comment = "Enable effect for FLIGHT. Default: true";
        effectFLIGHT = FLIGHT.getBoolean();
        Property FLIGHTBasePower = configuration.get("FLIGHT", "Base strength FLIGHT", 2);
        FLIGHTBasePower.comment = "Sets the base power for the effects FLIGHT gives. Default 2";
        effectFLIGHTBasePower = FLIGHTBasePower.getInt();
        Property FLIGHTRangeBoost = configuration.get("FLIGHT", "Range boost FLIGHT", 0);
        FLIGHTRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectFLIGHTRangeBoost = FLIGHTRangeBoost.getInt();
        Property FLIGHTTime = configuration.get("FLIGHT", "Base time FLIGHT", 210);
        FLIGHTTime.comment = "Sets the base time effects will last that FLIGHT gives. Default 20";
        effectFLIGHTTime = FLIGHTTime.getInt();
        Property FLIGHTUses = configuration.get("FLIGHT", "Base uses FLIGHT", 10);
        FLIGHTUses.comment = "Sets the base amount of time (by default 1) FLIGHT essentia gives you. Default 10";
        effectFLIGHTUses = FLIGHTUses.getInt();
        Property FLIGHTRefreshTime = configuration.get("FLIGHT", "Base refresh time FLIGHT", 200);
        FLIGHTRefreshTime.comment = "Sets the base amount of time between each time the FLIGHT applies an effect. Default 200";
        effectFLIGHTRefreshTime = FLIGHTRefreshTime.getInt();

        //DARKNESS
        Property DARKNESS = configuration.get("DARKNESS", "Effect DARKNESS", true);
        DARKNESS.comment = "Enable effect for DARKNESS. Default: true";
        effectDARKNESS = DARKNESS.getBoolean();
        Property DARKNESSBasePower = configuration.get("DARKNESS", "Base strength DARKNESS", 6);
        DARKNESSBasePower.comment = "Sets the base power for the effects DARKNESS gives. Default 6";
        effectDARKNESSBasePower = DARKNESSBasePower.getInt();
        Property DARKNESSRangeBoost = configuration.get("DARKNESS", "Range boost DARKNESS", 0);
        DARKNESSRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectDARKNESSRangeBoost = DARKNESSRangeBoost.getInt();
        Property DARKNESSTime = configuration.get("DARKNESS", "Base time DARKNESS", 40);
        DARKNESSTime.comment = "Sets the base time effects will last that DARKNESS gives. Default 40";
        effectDARKNESSTime = DARKNESSTime.getInt();
        Property DARKNESSUses = configuration.get("DARKNESS", "Base uses DARKNESS", 200);
        DARKNESSUses.comment = "Sets the base amount of time (by default 1) DARKNESS essentia gives you. Default 200";
        effectDARKNESSUses = DARKNESSUses.getInt();
        Property DARKNESSRefreshTime = configuration.get("DARKNESS", "Base refresh time DARKNESS", 20);
        DARKNESSRefreshTime.comment = "Sets the base amount of time between each time the DARKNESS applies an effect. Default 20";
        effectDARKNESSRefreshTime = DARKNESSRefreshTime.getInt();

        //SOUL
        Property SOUL = configuration.get("SOUL", "Effect SOUL", true);
        SOUL.comment = "Enable effect for SOUL. Default: true //does nothing for now";
        effectSOUL = SOUL.getBoolean();
        Property SOULBasePower = configuration.get("SOUL", "Base strength SOUL", 1);
        SOULBasePower.comment = "Sets the base power for the effects SOUL gives. Default 1";
        effectSOULBasePower = SOULBasePower.getInt();
        Property SOULRangeBoost = configuration.get("SOUL", "Range boost SOUL", 0);
        SOULRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectSOULRangeBoost = SOULRangeBoost.getInt();
        Property SOULTime = configuration.get("SOUL", "Base time SOUL", 20);
        SOULTime.comment = "Sets the base time effects will last that SOUL gives. Default 20";
        effectSOULTime = SOULTime.getInt();
        Property SOULUses = configuration.get("SOUL", "Base uses SOUL", 100);
        SOULUses.comment = "Sets the base amount of time (by default 1) SOUL essentia gives you. Default 100";
        effectSOULUses = SOULUses.getInt();
        Property SOULRefreshTime = configuration.get("SOUL", "Base refresh time SOUL", 10);
        SOULRefreshTime.comment = "Sets the base amount of time between each time the SOUL applies an effect. Default 10";
        effectSOULRefreshTime = SOULRefreshTime.getInt();

        //HEAL
        Property HEAL = configuration.get("HEAL", "Effect HEAL", true);
        HEAL.comment = "Enable effect for HEAL. Default: true";
        effectHEAL = HEAL.getBoolean();
        Property HEALBasePower = configuration.get("HEAL", "Base strength HEAL", 1);
        HEALBasePower.comment = "Sets the base power for the effects HEAL gives. Default 1";
        effectHEALBasePower = HEALBasePower.getInt();
        Property HEALRangeBoost = configuration.get("HEAL", "Range boost HEAL", 0);
        HEALRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectHEALRangeBoost = HEALRangeBoost.getInt();
        Property HEALTime = configuration.get("HEAL", "Base time HEAL", 2);
        HEALTime.comment = "Sets the base time effects will last that HEAL gives. Default 2";
        effectHEALTime = HEALTime.getInt();
        Property HEALUses = configuration.get("HEAL", "Base uses HEAL", 20);
        HEALUses.comment = "Sets the base amount of time (by default 1) HEAL essentia gives you. Default 20";
        effectHEALUses = HEALUses.getInt();
        Property HEALRefreshTime = configuration.get("HEAL", "Base refresh time HEAL", 600);
        HEALRefreshTime.comment = "Sets the base amount of time between each time the HEAL applies an effect. Default 600";
        effectHEALRefreshTime = HEALRefreshTime.getInt();

        //TRAVEL
        Property TRAVEL = configuration.get("TRAVEL", "Effect TRAVEL", true);
        TRAVEL.comment = "Enable effect for TRAVEL. Default: true //does nothing for now";
        effectTRAVEL = TRAVEL.getBoolean();
        Property TRAVELBasePower = configuration.get("TRAVEL", "Base strength TRAVEL", 1);
        TRAVELBasePower.comment = "Sets the base power for the effects TRAVEL gives. Default 1";
        effectTRAVELBasePower = TRAVELBasePower.getInt();
        Property TRAVELRangeBoost = configuration.get("TRAVEL", "Range boost TRAVEL", 0);
        TRAVELRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectTRAVELRangeBoost = TRAVELRangeBoost.getInt();
        Property TRAVELTime = configuration.get("TRAVEL", "Base time TRAVEL", 20);
        TRAVELTime.comment = "Sets the base time effects will last that TRAVEL gives. Default 20";
        effectTRAVELTime = TRAVELTime.getInt();
        Property TRAVELUses = configuration.get("TRAVEL", "Base uses TRAVEL", 100);
        TRAVELUses.comment = "Sets the base amount of time (by default 1) TRAVEL essentia gives you. Default 100";
        effectTRAVELUses = TRAVELUses.getInt();
        Property TRAVELRefreshTime = configuration.get("TRAVEL", "Base refresh time TRAVEL", 10);
        TRAVELRefreshTime.comment = "Sets the base amount of time between each time the TRAVEL applies an effect. Default 10";
        effectTRAVELRefreshTime = TRAVELRefreshTime.getInt();

        //ELDRITCH
        Property ELDRITCH = configuration.get("ELDRITCH", "Effect ELDRITCH", true);
        ELDRITCH.comment = "Enable effect for ELDRITCH. Default: true //does nothing for now";
        effectELDRITCH = ELDRITCH.getBoolean();
        Property ELDRITCHBasePower = configuration.get("ELDRITCH", "Base strength ELDRITCH", 1);
        ELDRITCHBasePower.comment = "Sets the base power for the effects ELDRITCH gives. Default 1";
        effectELDRITCHBasePower = ELDRITCHBasePower.getInt();
        Property ELDRITCHRangeBoost = configuration.get("ELDRITCH", "Range boost ELDRITCH", 0);
        ELDRITCHRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectELDRITCHRangeBoost = ELDRITCHRangeBoost.getInt();
        Property ELDRITCHTime = configuration.get("ELDRITCH", "Base time ELDRITCH", 20);
        ELDRITCHTime.comment = "Sets the base time effects will last that ELDRITCH gives. Default 20";
        effectELDRITCHTime = ELDRITCHTime.getInt();
        Property ELDRITCHUses = configuration.get("ELDRITCH", "Base uses ELDRITCH", 100);
        ELDRITCHUses.comment = "Sets the base amount of time (by default 1) ELDRITCH essentia gives you. Default 100";
        effectELDRITCHUses = ELDRITCHUses.getInt();
        Property ELDRITCHRefreshTime = configuration.get("ELDRITCH", "Base refresh time ELDRITCH", 10);
        ELDRITCHRefreshTime.comment = "Sets the base amount of time between each time the ELDRITCH applies an effect. Default 10";
        effectELDRITCHRefreshTime = ELDRITCHRefreshTime.getInt();

        //MAGIC
        Property MAGIC = configuration.get("MAGIC", "Effect MAGIC", true);
        MAGIC.comment = "Enable effect for MAGIC. Default: true //does nothing for now";
        effectMAGIC = MAGIC.getBoolean();
        Property MAGICBasePower = configuration.get("MAGIC", "Base strength MAGIC", 1);
        MAGICBasePower.comment = "Sets the base power for the effects MAGIC gives. Default 1";
        effectMAGICBasePower = MAGICBasePower.getInt();
        Property MAGICRangeBoost = configuration.get("MAGIC", "Range boost MAGIC", 0);
        MAGICRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectMAGICRangeBoost = MAGICRangeBoost.getInt();
        Property MAGICTime = configuration.get("MAGIC", "Base time MAGIC", 20);
        MAGICTime.comment = "Sets the base time effects will last that MAGIC gives. Default 20";
        effectMAGICTime = MAGICTime.getInt();
        Property MAGICUses = configuration.get("MAGIC", "Base uses MAGIC", 100);
        MAGICUses.comment = "Sets the base amount of time (by default 1) MAGIC essentia gives you. Default 100";
        effectMAGICUses = MAGICUses.getInt();
        Property MAGICRefreshTime = configuration.get("MAGIC", "Base refresh time MAGIC", 10);
        MAGICRefreshTime.comment = "Sets the base amount of time between each time the MAGIC applies an effect. Default 10";
        effectMAGICRefreshTime = MAGICRefreshTime.getInt();

        //AURA
        Property AURA = configuration.get("AURA", "Effect AURA", true);
        AURA.comment = "Enable effect for AURA. Default: true //does nothing for now";
        effectAURA = AURA.getBoolean();
        Property AURABasePower = configuration.get("AURA", "Base strength AURA", 1);
        AURABasePower.comment = "Sets the base power for the effects AURA gives. Default 1";
        effectAURABasePower = AURABasePower.getInt();
        Property AURARangeBoost = configuration.get("AURA", "Range boost AURA", 0);
        AURARangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectAURARangeBoost = AURARangeBoost.getInt();
        Property AURATime = configuration.get("AURA", "Base time AURA", 20);
        AURATime.comment = "Sets the base time effects will last that AURA gives. Default 20";
        effectAURATime = AURATime.getInt();
        Property AURAUses = configuration.get("AURA", "Base uses AURA", 100);
        AURAUses.comment = "Sets the base amount of time (by default 1) AURA essentia gives you. Default 100";
        effectAURAUses = AURAUses.getInt();
        Property AURARefreshTime = configuration.get("AURA", "Base refresh time AURA", 10);
        AURARefreshTime.comment = "Sets the base amount of time between each time the AURA applies an effect. Default 10";
        effectAURARefreshTime = AURARefreshTime.getInt();

        //TAINT
        Property TAINT = configuration.get("TAINT", "Effect TAINT", true);
        TAINT.comment = "Enable effect for TAINT. Default: true //does nothing for now";
        effectTAINT = TAINT.getBoolean();
        Property TAINTBasePower = configuration.get("TAINT", "Base strength TAINT", 1);
        TAINTBasePower.comment = "Sets the base power for the effects TAINT gives. Default 1";
        effectTAINTBasePower = TAINTBasePower.getInt();
        Property TAINTRangeBoost = configuration.get("TAINT", "Range boost TAINT", 0);
        TAINTRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectTAINTRangeBoost = TAINTRangeBoost.getInt();
        Property TAINTTime = configuration.get("TAINT", "Base time TAINT", 20);
        TAINTTime.comment = "Sets the base time effects will last that TAINT gives. Default 20";
        effectTAINTTime = TAINTTime.getInt();
        Property TAINTUses = configuration.get("TAINT", "Base uses TAINT", 100);
        TAINTUses.comment = "Sets the base amount of time (by default 1) TAINT essentia gives you. Default 100";
        effectTAINTUses = TAINTUses.getInt();
        Property TAINTRefreshTime = configuration.get("TAINT", "Base refresh time TAINT", 10);
        TAINTRefreshTime.comment = "Sets the base amount of time between each time the TAINT applies an effect. Default 10";
        effectTAINTRefreshTime = TAINTRefreshTime.getInt();

        //SLIME
        Property SLIME = configuration.get("SLIME", "Effect SLIME", true);
        SLIME.comment = "Enable effect for SLIME. Default: true";
        effectSLIME = SLIME.getBoolean();
        Property SLIMEBasePower = configuration.get("SLIME", "Base strength SLIME", 1);
        SLIMEBasePower.comment = "Sets the base power for the effects SLIME gives. Default 1";
        effectSLIMEBasePower = SLIMEBasePower.getInt();
        Property SLIMERangeBoost = configuration.get("SLIME", "Range boost SLIME", 0);
        SLIMERangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectSLIMERangeBoost = SLIMERangeBoost.getInt();
        Property SLIMETime = configuration.get("SLIME", "Base time SLIME", 30);
        SLIMETime.comment = "Sets the base time effects will last that SLIME gives. Default 30";
        effectSLIMETime = SLIMETime.getInt();
        Property SLIMEUses = configuration.get("SLIME", "Base uses SLIME", 120);
        SLIMEUses.comment = "Sets the base amount of time (by default 1) SLIME essentia gives you. Default 120";
        effectSLIMEUses = SLIMEUses.getInt();
        Property SLIMERefreshTime = configuration.get("SLIME", "Base refresh time SLIME", 10);
        SLIMERefreshTime.comment = "Sets the base amount of time between each time the SLIME applies an effect. Default 10";
        effectSLIMERefreshTime = SLIMERefreshTime.getInt();

        //PLANT
        Property PLANT = configuration.get("PLANT", "Effect PLANT", true);
        PLANT.comment = "Enable effect for PLANT. Default: true //does nothing for now";
        effectPLANT = PLANT.getBoolean();
        Property PLANTBasePower = configuration.get("PLANT", "Base strength PLANT", 1);
        PLANTBasePower.comment = "Sets the base power for the effects PLANT gives. Default 1";
        effectPLANTBasePower = PLANTBasePower.getInt();
        Property PLANTRangeBoost = configuration.get("PLANT", "Range boost PLANT", 0);
        PLANTRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectPLANTRangeBoost = PLANTRangeBoost.getInt();
        Property PLANTTime = configuration.get("PLANT", "Base time PLANT", 20);
        PLANTTime.comment = "Sets the base time effects will last that PLANT gives. Default 20";
        effectPLANTTime = PLANTTime.getInt();
        Property PLANTUses = configuration.get("PLANT", "Base uses PLANT", 100);
        PLANTUses.comment = "Sets the base amount of time (by default 1) PLANT essentia gives you. Default 100";
        effectPLANTUses = PLANTUses.getInt();
        Property PLANTRefreshTime = configuration.get("PLANT", "Base refresh time PLANT", 10);
        PLANTRefreshTime.comment = "Sets the base amount of time between each time the PLANT applies an effect. Default 10";
        effectPLANTRefreshTime = PLANTRefreshTime.getInt();

        //TREE
        Property TREE = configuration.get("TREE", "Effect TREE", true);
        TREE.comment = "Enable effect for TREE. Default: true //does nothing for now";
        effectTREE = TREE.getBoolean();
        Property TREEBasePower = configuration.get("TREE", "Base strength TREE", 1);
        TREEBasePower.comment = "Sets the base power for the effects TREE gives. Default 1";
        effectTREEBasePower = TREEBasePower.getInt();
        Property TREERangeBoost = configuration.get("TREE", "Range boost TREE", 0);
        TREERangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectTREERangeBoost = TREERangeBoost.getInt();
        Property TREETime = configuration.get("TREE", "Base time TREE", 20);
        TREETime.comment = "Sets the base time effects will last that TREE gives. Default 20";
        effectTREETime = TREETime.getInt();
        Property TREEUses = configuration.get("TREE", "Base uses TREE", 100);
        TREEUses.comment = "Sets the base amount of time (by default 1) TREE essentia gives you. Default 100";
        effectTREEUses = TREEUses.getInt();
        Property TREERefreshTime = configuration.get("TREE", "Base refresh time TREE", 10);
        TREERefreshTime.comment = "Sets the base amount of time between each time the TREE applies an effect. Default 10";
        effectTREERefreshTime = TREERefreshTime.getInt();

        //BEAST
        Property BEAST = configuration.get("BEAST", "Effect BEAST", true);
        BEAST.comment = "Enable effect for BEAST. Default: true //does nothing for now";
        effectBEAST = BEAST.getBoolean();
        Property BEASTBasePower = configuration.get("BEAST", "Base strength BEAST", 1);
        BEASTBasePower.comment = "Sets the base power for the effects BEAST gives. Default 1";
        effectBEASTBasePower = BEASTBasePower.getInt();
        Property BEASTRangeBoost = configuration.get("BEAST", "Range boost BEAST", 0);
        BEASTRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectBEASTRangeBoost = BEASTRangeBoost.getInt();
        Property BEASTTime = configuration.get("BEAST", "Base time BEAST", 20);
        BEASTTime.comment = "Sets the base time effects will last that BEAST gives. Default 20";
        effectBEASTTime = BEASTTime.getInt();
        Property BEASTUses = configuration.get("BEAST", "Base uses BEAST", 100);
        BEASTUses.comment = "Sets the base amount of time (by default 1) BEAST essentia gives you. Default 100";
        effectBEASTUses = BEASTUses.getInt();
        Property BEASTRefreshTime = configuration.get("BEAST", "Base refresh time BEAST", 10);
        BEASTRefreshTime.comment = "Sets the base amount of time between each time the BEAST applies an effect. Default 10";
        effectBEASTRefreshTime = BEASTRefreshTime.getInt();

        //UNDEAD
        Property UNDEAD = configuration.get("UNDEAD", "Effect UNDEAD", true);
        UNDEAD.comment = "Enable effect for UNDEAD. Default: true //does nothing for now";
        effectUNDEAD = UNDEAD.getBoolean();
        Property UNDEADBasePower = configuration.get("UNDEAD", "Base strength UNDEAD", 1);
        UNDEADBasePower.comment = "Sets the base power for the effects UNDEAD gives. Default 1";
        effectUNDEADBasePower = UNDEADBasePower.getInt();
        Property UNDEADRangeBoost = configuration.get("UNDEAD", "Range boost UNDEAD", 0);
        UNDEADRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectUNDEADRangeBoost = UNDEADRangeBoost.getInt();
        Property UNDEADTime = configuration.get("UNDEAD", "Base time UNDEAD", 20);
        UNDEADTime.comment = "Sets the base time effects will last that UNDEAD gives. Default 20";
        effectUNDEADTime = UNDEADTime.getInt();
        Property UNDEADUses = configuration.get("UNDEAD", "Base uses UNDEAD", 100);
        UNDEADUses.comment = "Sets the base amount of time (by default 1) UNDEAD essentia gives you. Default 100";
        effectUNDEADUses = UNDEADUses.getInt();
        Property UNDEADRefreshTime = configuration.get("UNDEAD", "Base refresh time UNDEAD", 10);
        UNDEADRefreshTime.comment = "Sets the base amount of time between each time the UNDEAD applies an effect. Default 10";
        effectUNDEADRefreshTime = UNDEADRefreshTime.getInt();

        //MIND
        Property MIND = configuration.get("MIND", "Effect MIND", true);
        MIND.comment = "Enable effect for MIND. Default: true //does nothing for now";
        effectMIND = MIND.getBoolean();
        Property MINDBasePower = configuration.get("MIND", "Base strength MIND", 1);
        MINDBasePower.comment = "Sets the base power for the effects MIND gives. Default 1";
        effectMINDBasePower = MINDBasePower.getInt();
        Property MINDRangeBoost = configuration.get("MIND", "Range boost MIND", 0);
        MINDRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectMINDRangeBoost = MINDRangeBoost.getInt();
        Property MINDTime = configuration.get("MIND", "Base time MIND", 20);
        MINDTime.comment = "Sets the base time effects will last that MIND gives. Default 20";
        effectMINDTime = MINDTime.getInt();
        Property MINDUses = configuration.get("MIND", "Base uses MIND", 100);
        MINDUses.comment = "Sets the base amount of time (by default 1) MIND essentia gives you. Default 100";
        effectMINDUses = MINDUses.getInt();
        Property MINDRefreshTime = configuration.get("MIND", "Base refresh time MIND", 10);
        MINDRefreshTime.comment = "Sets the base amount of time between each time the MIND applies an effect. Default 10";
        effectMINDRefreshTime = MINDRefreshTime.getInt();

        //SENSES
        Property SENSES = configuration.get("SENSES", "Effect SENSES", true);
        SENSES.comment = "Enable effect for SENSES. Default: true //does nothing for now";
        effectSENSES = SENSES.getBoolean();
        Property SENSESBasePower = configuration.get("SENSES", "Base strength SENSES", 1);
        SENSESBasePower.comment = "Sets the base power for the effects SENSES gives. Default 1";
        effectSENSESBasePower = SENSESBasePower.getInt();
        Property SENSESRangeBoost = configuration.get("SENSES", "Range boost SENSES", 0);
        SENSESRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectSENSESRangeBoost = SENSESRangeBoost.getInt();
        Property SENSESTime = configuration.get("SENSES", "Base time SENSES", 20);
        SENSESTime.comment = "Sets the base time effects will last that SENSES gives. Default 20";
        effectSENSESTime = SENSESTime.getInt();
        Property SENSESUses = configuration.get("SENSES", "Base uses SENSES", 100);
        SENSESUses.comment = "Sets the base amount of time (by default 1) SENSES essentia gives you. Default 100";
        effectSENSESUses = SENSESUses.getInt();
        Property SENSESRefreshTime = configuration.get("SENSES", "Base refresh time SENSES", 10);
        SENSESRefreshTime.comment = "Sets the base amount of time between each time the SENSES applies an effect. Default 10";
        effectSENSESRefreshTime = SENSESRefreshTime.getInt();

        //MAN
        Property MAN = configuration.get("MAN", "Effect MAN", true);
        MAN.comment = "Enable effect for MAN. Default: true //does nothing for now";
        effectMAN = MAN.getBoolean();
        Property MANBasePower = configuration.get("MAN", "Base strength MAN", 1);
        MANBasePower.comment = "Sets the base power for the effects MAN gives. Default 1";
        effectMANBasePower = MANBasePower.getInt();
        Property MANRangeBoost = configuration.get("MAN", "Range boost MAN", 0);
        MANRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectMANRangeBoost = MANRangeBoost.getInt();
        Property MANTime = configuration.get("MAN", "Base time MAN", 20);
        MANTime.comment = "Sets the base time effects will last that MAN gives. Default 20";
        effectMANTime = MANTime.getInt();
        Property MANUses = configuration.get("MAN", "Base uses MAN", 100);
        MANUses.comment = "Sets the base amount of time (by default 1) MAN essentia gives you. Default 100";
        effectMANUses = MANUses.getInt();
        Property MANRefreshTime = configuration.get("MAN", "Base refresh time MAN", 10);
        MANRefreshTime.comment = "Sets the base amount of time between each time the MAN applies an effect. Default 10";
        effectMANRefreshTime = MANRefreshTime.getInt();

        //CROP
        Property CROP = configuration.get("CROP", "Effect CROP", true);
        CROP.comment = "Enable effect for CROP. Default: true //does nothing for now";
        effectCROP = CROP.getBoolean();
        Property CROPBasePower = configuration.get("CROP", "Base strength CROP", 1);
        CROPBasePower.comment = "Sets the base power for the effects CROP gives. Default 1";
        effectCROPBasePower = CROPBasePower.getInt();
        Property CROPRangeBoost = configuration.get("CROP", "Range boost CROP", 0);
        CROPRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectCROPRangeBoost = CROPRangeBoost.getInt();
        Property CROPTime = configuration.get("CROP", "Base time CROP", 20);
        CROPTime.comment = "Sets the base time effects will last that CROP gives. Default 20";
        effectCROPTime = CROPTime.getInt();
        Property CROPUses = configuration.get("CROP", "Base uses CROP", 100);
        CROPUses.comment = "Sets the base amount of time (by default 1) CROP essentia gives you. Default 100";
        effectCROPUses = CROPUses.getInt();
        Property CROPRefreshTime = configuration.get("CROP", "Base refresh time CROP", 10);
        CROPRefreshTime.comment = "Sets the base amount of time between each time the CROP applies an effect. Default 10";
        effectCROPRefreshTime = CROPRefreshTime.getInt();

        //MINE
        Property MINE = configuration.get("MINE", "Effect MINE", true);
        MINE.comment = "Enable effect for MINE. Default: true //does nothing for now";
        effectMINE = MINE.getBoolean();
        Property MINEBasePower = configuration.get("MINE", "Base strength MINE", 1);
        MINEBasePower.comment = "Sets the base power for the effects MINE gives. Default 1";
        effectMINEBasePower = MINEBasePower.getInt();
        Property MINERangeBoost = configuration.get("MINE", "Range boost MINE", 0);
        MINERangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectMINERangeBoost = MINERangeBoost.getInt();
        Property MINETime = configuration.get("MINE", "Base time MINE", 20);
        MINETime.comment = "Sets the base time effects will last that MINE gives. Default 20";
        effectMINETime = MINETime.getInt();
        Property MINEUses = configuration.get("MINE", "Base uses MINE", 100);
        MINEUses.comment = "Sets the base amount of time (by default 1) MINE essentia gives you. Default 100";
        effectMINEUses = MINEUses.getInt();
        Property MINERefreshTime = configuration.get("MINE", "Base refresh time MINE", 10);
        MINERefreshTime.comment = "Sets the base amount of time between each time the MINE applies an effect. Default 10";
        effectMINERefreshTime = MINERefreshTime.getInt();

        //TOOL
        Property TOOL = configuration.get("TOOL", "Effect TOOL", true);
        TOOL.comment = "Enable effect for TOOL. Default: true //does nothing for now";
        effectTOOL = TOOL.getBoolean();
        Property TOOLBasePower = configuration.get("TOOL", "Base strength TOOL", 1);
        TOOLBasePower.comment = "Sets the base power for the effects TOOL gives. Default 1";
        effectTOOLBasePower = TOOLBasePower.getInt();
        Property TOOLRangeBoost = configuration.get("TOOL", "Range boost TOOL", 0);
        TOOLRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectTOOLRangeBoost = TOOLRangeBoost.getInt();
        Property TOOLTime = configuration.get("TOOL", "Base time TOOL", 20);
        TOOLTime.comment = "Sets the base time effects will last that TOOL gives. Default 20";
        effectTOOLTime = TOOLTime.getInt();
        Property TOOLUses = configuration.get("TOOL", "Base uses TOOL", 100);
        TOOLUses.comment = "Sets the base amount of time (by default 1) TOOL essentia gives you. Default 100";
        effectTOOLUses = TOOLUses.getInt();
        Property TOOLRefreshTime = configuration.get("TOOL", "Base refresh time TOOL", 10);
        TOOLRefreshTime.comment = "Sets the base amount of time between each time the TOOL applies an effect. Default 10";
        effectTOOLRefreshTime = TOOLRefreshTime.getInt();

        //HARVEST
        Property HARVEST = configuration.get("HARVEST", "Effect HARVEST", true);
        HARVEST.comment = "Enable effect for HARVEST. Default: true //does nothing for now";
        effectHARVEST = HARVEST.getBoolean();
        Property HARVESTBasePower = configuration.get("HARVEST", "Base strength HARVEST", 1);
        HARVESTBasePower.comment = "Sets the base power for the effects HARVEST gives. Default 1";
        effectHARVESTBasePower = HARVESTBasePower.getInt();
        Property HARVESTRangeBoost = configuration.get("HARVEST", "Range boost HARVEST", 0);
        HARVESTRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectHARVESTRangeBoost = HARVESTRangeBoost.getInt();
        Property HARVESTTime = configuration.get("HARVEST", "Base time HARVEST", 20);
        HARVESTTime.comment = "Sets the base time effects will last that HARVEST gives. Default 20";
        effectHARVESTTime = HARVESTTime.getInt();
        Property HARVESTUses = configuration.get("HARVEST", "Base uses HARVEST", 100);
        HARVESTUses.comment = "Sets the base amount of time (by default 1) HARVEST essentia gives you. Default 100";
        effectHARVESTUses = HARVESTUses.getInt();
        Property HARVESTRefreshTime = configuration.get("HARVEST", "Base refresh time HARVEST", 10);
        HARVESTRefreshTime.comment = "Sets the base amount of time between each time the HARVEST applies an effect. Default 10";
        effectHARVESTRefreshTime = HARVESTRefreshTime.getInt();

        //WEAPON
        Property WEAPON = configuration.get("WEAPON", "Effect WEAPON", true);
        WEAPON.comment = "Enable effect for WEAPON. Default: true //does nothing for now";
        effectWEAPON = WEAPON.getBoolean();
        Property WEAPONBasePower = configuration.get("WEAPON", "Base strength WEAPON", 1);
        WEAPONBasePower.comment = "Sets the base power for the effects WEAPON gives. Default 1";
        effectWEAPONBasePower = WEAPONBasePower.getInt();
        Property WEAPONRangeBoost = configuration.get("WEAPON", "Range boost WEAPON", 0);
        WEAPONRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectWEAPONRangeBoost = WEAPONRangeBoost.getInt();
        Property WEAPONTime = configuration.get("WEAPON", "Base time WEAPON", 20);
        WEAPONTime.comment = "Sets the base time effects will last that WEAPON gives. Default 20";
        effectWEAPONTime = WEAPONTime.getInt();
        Property WEAPONUses = configuration.get("WEAPON", "Base uses WEAPON", 100);
        WEAPONUses.comment = "Sets the base amount of time (by default 1) WEAPON essentia gives you. Default 100";
        effectWEAPONUses = WEAPONUses.getInt();
        Property WEAPONRefreshTime = configuration.get("WEAPON", "Base refresh time WEAPON", 10);
        WEAPONRefreshTime.comment = "Sets the base amount of time between each time the WEAPON applies an effect. Default 10";
        effectWEAPONRefreshTime = WEAPONRefreshTime.getInt();

        //ARMOR
        Property ARMOR = configuration.get("ARMOR", "Effect ARMOR", true);
        ARMOR.comment = "Enable effect for ARMOR. Default: true //does nothing for now";
        effectARMOR = ARMOR.getBoolean();
        Property ARMORBasePower = configuration.get("ARMOR", "Base strength ARMOR", 1);
        ARMORBasePower.comment = "Sets the base power for the effects ARMOR gives. Default 1";
        effectARMORBasePower = ARMORBasePower.getInt();
        Property ARMORRangeBoost = configuration.get("ARMOR", "Range boost ARMOR", 0);
        ARMORRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectARMORRangeBoost = ARMORRangeBoost.getInt();
        Property ARMORTime = configuration.get("ARMOR", "Base time ARMOR", 20);
        ARMORTime.comment = "Sets the base time effects will last that ARMOR gives. Default 20";
        effectARMORTime = ARMORTime.getInt();
        Property ARMORUses = configuration.get("ARMOR", "Base uses ARMOR", 100);
        ARMORUses.comment = "Sets the base amount of time (by default 1) ARMOR essentia gives you. Default 100";
        effectARMORUses = ARMORUses.getInt();
        Property ARMORRefreshTime = configuration.get("ARMOR", "Base refresh time ARMOR", 10);
        ARMORRefreshTime.comment = "Sets the base amount of time between each time the ARMOR applies an effect. Default 10";
        effectARMORRefreshTime = ARMORRefreshTime.getInt();

        //HUNGER
        Property HUNGER = configuration.get("HUNGER", "Effect HUNGER", true);
        HUNGER.comment = "Enable effect for HUNGER. Default: true //does nothing for now";
        effectHUNGER = HUNGER.getBoolean();
        Property HUNGERBasePower = configuration.get("HUNGER", "Base strength HUNGER", 1);
        HUNGERBasePower.comment = "Sets the base power for the effects HUNGER gives. Default 1";
        effectHUNGERBasePower = HUNGERBasePower.getInt();
        Property HUNGERRangeBoost = configuration.get("HUNGER", "Range boost HUNGER", 0);
        HUNGERRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectHUNGERRangeBoost = HUNGERRangeBoost.getInt();
        Property HUNGERTime = configuration.get("HUNGER", "Base time HUNGER", 20);
        HUNGERTime.comment = "Sets the base time effects will last that HUNGER gives. Default 20";
        effectHUNGERTime = HUNGERTime.getInt();
        Property HUNGERUses = configuration.get("HUNGER", "Base uses HUNGER", 100);
        HUNGERUses.comment = "Sets the base amount of time (by default 1) HUNGER essentia gives you. Default 100";
        effectHUNGERUses = HUNGERUses.getInt();
        Property HUNGERRefreshTime = configuration.get("HUNGER", "Base refresh time HUNGER", 10);
        HUNGERRefreshTime.comment = "Sets the base amount of time between each time the HUNGER applies an effect. Default 10";
        effectHUNGERRefreshTime = HUNGERRefreshTime.getInt();

        //GREED
        Property GREED = configuration.get("GREED", "Effect GREED", true);
        GREED.comment = "Enable effect for GREED. Default: true //does nothing for now";
        effectGREED = GREED.getBoolean();
        Property GREEDBasePower = configuration.get("GREED", "Base strength GREED", 1);
        GREEDBasePower.comment = "Sets the base power for the effects GREED gives. Default 1";
        effectGREEDBasePower = GREEDBasePower.getInt();
        Property GREEDRangeBoost = configuration.get("GREED", "Range boost GREED", 0);
        GREEDRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectGREEDRangeBoost = GREEDRangeBoost.getInt();
        Property GREEDTime = configuration.get("GREED", "Base time GREED", 20);
        GREEDTime.comment = "Sets the base time effects will last that GREED gives. Default 20";
        effectGREEDTime = GREEDTime.getInt();
        Property GREEDUses = configuration.get("GREED", "Base uses GREED", 100);
        GREEDUses.comment = "Sets the base amount of time (by default 1) GREED essentia gives you. Default 100";
        effectGREEDUses = GREEDUses.getInt();
        Property GREEDRefreshTime = configuration.get("GREED", "Base refresh time GREED", 10);
        GREEDRefreshTime.comment = "Sets the base amount of time between each time the GREED applies an effect. Default 10";
        effectGREEDRefreshTime = GREEDRefreshTime.getInt();

        //CRAFT
        Property CRAFT = configuration.get("CRAFT", "Effect CRAFT", true);
        CRAFT.comment = "Enable effect for CRAFT. Default: true //does nothing for now";
        effectCRAFT = CRAFT.getBoolean();
        Property CRAFTBasePower = configuration.get("CRAFT", "Base strength CRAFT", 1);
        CRAFTBasePower.comment = "Sets the base power for the effects CRAFT gives. Default 1";
        effectCRAFTBasePower = CRAFTBasePower.getInt();
        Property CRAFTRangeBoost = configuration.get("CRAFT", "Range boost CRAFT", 0);
        CRAFTRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectCRAFTRangeBoost = CRAFTRangeBoost.getInt();
        Property CRAFTTime = configuration.get("CRAFT", "Base time CRAFT", 20);
        CRAFTTime.comment = "Sets the base time effects will last that CRAFT gives. Default 20";
        effectCRAFTTime = CRAFTTime.getInt();
        Property CRAFTUses = configuration.get("CRAFT", "Base uses CRAFT", 100);
        CRAFTUses.comment = "Sets the base amount of time (by default 1) CRAFT essentia gives you. Default 100";
        effectCRAFTUses = CRAFTUses.getInt();
        Property CRAFTRefreshTime = configuration.get("CRAFT", "Base refresh time CRAFT", 10);
        CRAFTRefreshTime.comment = "Sets the base amount of time between each time the CRAFT applies an effect. Default 10";
        effectCRAFTRefreshTime = CRAFTRefreshTime.getInt();

        //CLOTH
        Property CLOTH = configuration.get("CLOTH", "Effect CLOTH", true);
        CLOTH.comment = "Enable effect for CLOTH. Default: true //does nothing for now";
        effectCLOTH = CLOTH.getBoolean();
        Property CLOTHBasePower = configuration.get("CLOTH", "Base strength CLOTH", 1);
        CLOTHBasePower.comment = "Sets the base power for the effects CLOTH gives. Default 1";
        effectCLOTHBasePower = CLOTHBasePower.getInt();
        Property CLOTHRangeBoost = configuration.get("CLOTH", "Range boost CLOTH", 0);
        CLOTHRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectCLOTHRangeBoost = CLOTHRangeBoost.getInt();
        Property CLOTHTime = configuration.get("CLOTH", "Base time CLOTH", 20);
        CLOTHTime.comment = "Sets the base time effects will last that CLOTH gives. Default 20";
        effectCLOTHTime = CLOTHTime.getInt();
        Property CLOTHUses = configuration.get("CLOTH", "Base uses CLOTH", 100);
        CLOTHUses.comment = "Sets the base amount of time (by default 1) CLOTH essentia gives you. Default 100";
        effectCLOTHUses = CLOTHUses.getInt();
        Property CLOTHRefreshTime = configuration.get("CLOTH", "Base refresh time CLOTH", 10);
        CLOTHRefreshTime.comment = "Sets the base amount of time between each time the CLOTH applies an effect. Default 10";
        effectCLOTHRefreshTime = CLOTHRefreshTime.getInt();

        //MECHANISM
        Property MECHANISM = configuration.get("MECHANISM", "Effect MECHANISM", true);
        MECHANISM.comment = "Enable effect for MECHANISM. Default: true //does nothing for now";
        effectMECHANISM = MECHANISM.getBoolean();
        Property MECHANISMBasePower = configuration.get("MECHANISM", "Base strength MECHANISM", 1);
        MECHANISMBasePower.comment = "Sets the base power for the effects MECHANISM gives. Default 1";
        effectMECHANISMBasePower = MECHANISMBasePower.getInt();
        Property MECHANISMRangeBoost = configuration.get("MECHANISM", "Range boost MECHANISM", 0);
        MECHANISMRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectMECHANISMRangeBoost = MECHANISMRangeBoost.getInt();
        Property MECHANISMTime = configuration.get("MECHANISM", "Base time MECHANISM", 20);
        MECHANISMTime.comment = "Sets the base time effects will last that MECHANISM gives. Default 20";
        effectMECHANISMTime = MECHANISMTime.getInt();
        Property MECHANISMUses = configuration.get("MECHANISM", "Base uses MECHANISM", 100);
        MECHANISMUses.comment = "Sets the base amount of time (by default 1) MECHANISM essentia gives you. Default 100";
        effectMECHANISMUses = MECHANISMUses.getInt();
        Property MECHANISMRefreshTime = configuration.get("MECHANISM", "Base refresh time MECHANISM", 10);
        MECHANISMRefreshTime.comment = "Sets the base amount of time between each time the MECHANISM applies an effect. Default 10";
        effectMECHANISMRefreshTime = MECHANISMRefreshTime.getInt();

        //TRAP
        Property TRAP = configuration.get("TRAP", "Effect TRAP", true);
        TRAP.comment = "Enable effect for TRAP. Default: true";
        effectTRAP = TRAP.getBoolean();
        Property TRAPBasePower = configuration.get("EARTH", "Base strength TRAP", 1);
        TRAPBasePower.comment = "Sets the base power for the effects TRAP gives. Default 1";
        effectTRAPBasePower = TRAPBasePower.getInt();
        Property TRAPRangeBoost = configuration.get("TRAP", "Range boost TRAP", 0);
        TRAPRangeBoost.comment = "Adds this to the base range of effects (5 by default)(set - to decrease size). Default 0";
        effectTRAPRangeBoost = TRAPRangeBoost.getInt();
        Property TRAPTime = configuration.get("TRAP", "Base time TRAP", 60);
        TRAPTime.comment = "Sets the base time effects will last that TRAP gives. Default 60";
        effectTRAPTime = TRAPTime.getInt();
        Property TRAPUses = configuration.get("TRAP", "Base uses TRAP", 100);
        TRAPUses.comment = "Sets the base amount of time (by default 1) TRAP essentia gives you. Default 100";
        effectTRAPUses = TRAPUses.getInt();
        Property TRAPRefreshTime = configuration.get("TRAP", "Base refresh time TRAP", 120);
        TRAPRefreshTime.comment = "Sets the base amount of time between each time the TRAP applies an effect. Default 10";
        effectTRAPRefreshTime = TRAPRefreshTime.getInt();
        
        
        configuration.save();
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(References.MODID))
        {
            loadConfiguration();
        }
    }
}