package com.doitbetter.onelife;

import com.doitbetter.onelife.datagen.*;
import com.doitbetter.onelife.datagen.lang.OneLifeEnglishLangProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class OneLifeDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(OneLifeModelProvider::new);
		pack.addProvider(OneLifeBlockTagProvider::new);
		pack.addProvider(OneLifeItemTagProvider::new);
		pack.addProvider(OneLifeComponentProvider::new);
		pack.addProvider(OneLifeEnchantmentProvider::new);

		pack.addProvider(OneLifeEnglishLangProvider::new);
	}
}
