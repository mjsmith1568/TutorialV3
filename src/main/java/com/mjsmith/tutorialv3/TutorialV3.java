package com.mjsmith.tutorialv3;

import com.mjsmith.tutorialv3.setup.ClientSetup;
import com.mjsmith.tutorialv3.setup.ModSetup;
import com.mjsmith.tutorialv3.setup.Registration;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("tutorialv3")
public class TutorialV3 {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "tutorialv3";

    public TutorialV3() {

        // Register the deferred registry
        Registration.init();

        // Register the setup method for mod loading
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        modbus.addListener(ModSetup::init);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modbus.addListener(ClientSetup::init));
    }
}
