if (serverWorld.getDifficulty() == Difficulty.EASY || serverWorld.getDifficulty() == Difficulty.NORMAL) {
    // 65% chance of dropping Emerald
    if (serverWorld.random.nextFloat() < 0.65F) {
        drops.add(new ItemStack(Items.EMERALD, serverWorld.random.nextInt(2))); // Random amount up to 1 emerald
    }
} else if (serverWorld.getDifficulty() == Difficulty.HARD) {
    // 80% chance of dropping Emerald
    if (serverWorld.random.nextFloat() < 0.80F) {
        drops.add(new ItemStack(Items.EMERALD, serverWorld.random.nextInt(2))); // Random amount up to 1 emerald
    }
}

// Chance for additional loot (Enchanted Book, Iron Axe, etc.)
float rareLootChance = serverWorld.random.nextFloat();
if (rareLootChance < 0.051F) { // Simulate 2/39 chance for enchanted book
    drops.add(new ItemStack(Items.ENCHANTED_BOOK));
} else if (rareLootChance < 0.115F) { // Simulate 5/78 chance for iron axe or shovel
    drops.add(new ItemStack(Items.IRON_AXE));
}
