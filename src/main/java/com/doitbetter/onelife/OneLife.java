package com.doitbetter.onelife;

import com.doitbetter.onelife.block.OneLifeBlocks;
import com.doitbetter.onelife.component.OneLifeComponentRegistryInit;
import com.doitbetter.onelife.component.OneLifeDataComponentTypes;
import com.doitbetter.onelife.event.OneLifeEvents;
import com.doitbetter.onelife.item.OneLifeItemGroups;
import com.doitbetter.onelife.item.OneLifeItems;
import com.doitbetter.onelife.item.OneLifeTools;
import com.doitbetter.onelife.item.OneLifeWeapons;
import com.doitbetter.onelife.util.OneLifeLogger;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OneLife implements ModInitializer {
	public static final String MOD_ID = "onelife";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("[OneLife] Beginning Total Overhaul Initialization Pipeline.");
		long pipelineStart = System.currentTimeMillis();

		OneLifeLogger.executeInitStep("Block Registration",         	OneLifeBlocks::register);
		OneLifeLogger.executeInitStep("Item & Material Registration",	OneLifeItems::register);
		OneLifeLogger.executeInitStep("Weapon Registration", 			OneLifeWeapons::register);
		OneLifeLogger.executeInitStep("Tool Registration",   			OneLifeTools::register);
		OneLifeLogger.executeInitStep("Item Groups",               	OneLifeItemGroups::register);
		OneLifeLogger.executeInitStep("Data Component Registration",	OneLifeDataComponentTypes::register);
		OneLifeLogger.executeInitStep("Component Registry",			OneLifeComponentRegistryInit::register);
		OneLifeLogger.executeInitStep("Sleep Event Registration", 		OneLifeEvents::register);

		long totalDuration = System.currentTimeMillis() - pipelineStart;
		LOGGER.info("[OneLife] Pipeline Complete! Total setup time: {}ms.", totalDuration);
	}
}