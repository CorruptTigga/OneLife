# One Life — From Scratch Overview

A gritty, grounded medieval total conversion for Minecraft 1.21.4+.
No magic. No Nether. No End. Just survival, society, and story.

---

## Core Philosophy

- Every system is grounded in medieval reality
- Characters have lives, not players — death is meaningful but not world-ending
- Multiple professions have genuine purpose and interdependence
- No enchanting table, no diamond, no netherite, no fantasy dimensions
- Addon-friendly from day one — JSON-driven, registry-backed, hook-exposed

---

## Target Version

**Minecraft 1.21.4+ with Fabric**

Reasons over 1.21.1:
- New item model system (minecraft:select, minecraft:condition) eliminates custom_model_data hacks entirely
- Cleaner data component APIs
- More stable long-term target

---

## Architecture Principles

1. **Data-driven over code-driven** — component effects, recipes, structures all in JSON
2. **Registry-backed everything** — components, effects, skills, factions all registered so addons can extend
3. **Fail gracefully** — orphaned data logs warnings, never crashes
4. **Pipeline initialization** — every system registers in order with timing and error isolation
5. **Source verification first** — always read decompiled source before writing mixins

---

## Build Order

### Phase 1 — Foundation
*Get the engine running clean before adding content.*

- [X] <span style="color:green">Project scaffold — mod ID, fabric.mod.json, build.gradle, dependencies
- [X] <span style="color:green">Logger utility — pipeline tracking, lifecycle logging, mixin intercept helper
- [X] <span style="color:green">Dimension lock — Nether portal mixin (NetherPortal.createPortal), no End via datapack
- [X] <span style="color:green">Recipe removal — strip vanilla iron/gold/diamond/netherite tools, armor, enchanting table, anvil
- [X] <span style="color:green">Block/item tag system — incorrect_for_x_tool, repair ingredient tags per tier
- [X] <span style="color:green">Custom item group — OneLife creative tab

### Phase 2 — Materials & Tiers
*Define the material progression before registering any items that use it.*

- [X] <span style="color:green">Tool material tiers — Wood, Flint, Copper, Bronze, Iron, Wrought Iron, Steel, Damascus, Tempered Steel
- [X] <span style="color:green">Ore items & blocks — Tin, Silver, Sulfur with worldgen
- [X] <span style="color:green">Ingot items — Tin, Silver, Bronze, Wrought Iron, Steel, Damascus, Tempered Steel
- [X] <span style="color:green">Coin items — Copper, Silver, Gold, Platinum
- [X] <span style="color:green">Gem items — raw and cut variants (Ruby, Sapphire, Emerald, Amethyst, Onyx)

### Phase 3 — Component System
*The backbone of all weapon and tool customization.*

- [X] <span style="color:green">WeaponFamily enum — BLADE_SWORD, BLADE_DAGGER, WAR_AXE, TOOL_AXE, POLEARM, BLUNT, TOOL
- [X] <span style="color:green">ComponentQuality enum — ROUGH, STANDARD, FINE, MASTERWORK with level scaling
- [X] <span style="color:green">ComponentEffect record — effect identifier + base level + quality resolution
- [X] <span style="color:green">OneLifeEffects registry — parallel effect identifiers (onelife:sharpness, onelife:looting, etc.)
- [X] <span style="color:green">WeaponComponent interface — effectsFor(family), supportsFamily(), getComponentDurability()
- [X] <span style="color:green">HandleComponent, HiltComponent, PommelComponent, WrapComponent, GemComponent records with codecs
- [X] <span style="color:green">AttachedComponent record — lightweight identifier + quality stored on ItemStack
- [X] <span style="color:green">DataComponentTypes — HANDLE, HILT, POMMEL, WRAP, GEM registered
- [X] <span style="color:green">ComponentRegistry — runtime lookup store, singleton, reloads with datapacks
- [X] <span style="color:green">ComponentLoader — datapack JSON reader, scans data/*/onelife/components/
- [X] <span style="color:green">ComponentRegistryInit — Fabric resource reload hook
- [X] <span style="color:green">Starter component JSON files — all variants from initial roster`

### Phase 4 — Effect Application
*Make socketed components actually do something.*

- [X] <span style="color:green">ComponentAttributeApplicator — Sharpness, Knockback, Swiftness, Efficiency, Sweeping Edge via AttributeModifiers
- [X] <span style="color:green">ComponentEventApplicator — Fire Aspect, Stagger, Precision, Smite, Bane via Fabric events
- [X] <span style="color:green">OneLifeEnchantments — register all custom enchantments with enchantability 0:
  - onelife:swift_strike — attack speed bonus
  - onelife:stagger — chance to interrupt actions on hit
  - onelife:precision — increased critical hit chance
  - onelife:cleave — sweeping area damage
  - onelife:temper — durability recovery rate
  - onelife:hone — mining speed beyond efficiency
  - onelife:bleed — damage over time on hit
  - onelife:penetrate — partial armor bypass
  - onelife:cripple — movement slow on hit
  - onelife:warding — defensive damage reduction
  - onelife:tracking — bow target highlight on hit
  - onelife:resonance — staff area effect on hit
  - onelife:stun — chance based stun lock, scales with quality
- [X] <span style="color:green">Enchantment JSON datagen — data-driven enchantment definitions
- [X] <span style="color:green">ComponentLootApplicator — Looting/Fortune/Silk Touch via loot table hooks

### Phase 5 — Weapons & Tools
*Register items, then craft them.*

- [X] <span style="color:green">FamilyItem interface — getWeaponFamily() for renderer and applicator lookup
- [X] <span style="color:green">Base weapon classes — OneLifeSwordItem, OneLifeDaggerItem, OneLifeWarAxeItem, OneLifeSpearItem, OneLifeHammerItem
- [X] <span style="color:green">Base tool classes — OneLifePickaxeItem, OneLifeShovelItem, OneLifeHoeItem, OneLifeToolAxeItem
- [X] <span style="color:green">OneLifeWeapons — 45 weapons registered (5 families x 9 tiers)
- [X] <span style="color:green">OneLifeTools — 36 tools registered (4 types x 9 tiers)
- [X] <span style="color:green">Wood stick variants — one per tree type for handle crafting

### Phase 6 — Crafting Stations
*Each profession gets their own block.*

- [ ] Blacksmith's Workbench
- [ ] Carpenter's Workbench
- [ ] Tanner's Workbench
- [ ] Jeweler's Workbench
- [ ] Armorer's Workbench
- [ ] Binding Table
- [ ] Tanner's Assembly Table
- [ ] Armorer's Assembly Table
- [ ] Smelter
- [ ] Forge (upgraded Smelter)
- [ ] Tanning Rack
- [ ] All blocks registered with block entities, screen handlers, client screens

### Phase 7 — Datagen Recipes
*Replace every removed vanilla recipe with our own.*

- [ ] RecipeProvider wired into OneLifeDataGenerator
- [ ] Flint tool recipes (crafting table)
- [ ] Copper tool recipes
- [ ] Bronze alloy recipe (copper + tin in smelter)
- [ ] Iron tool recipes
- [ ] Wrought Iron forging recipe (smelter)
- [ ] Steel recipe (wrought iron + charcoal in forge)
- [ ] Damascus and Tempered Steel recipes
- [ ] All component item recipes (hilts at forge, wraps at tanner, handles at carpenter, gems at jeweler)
- [ ] Coin minting recipes
- [ ] Armor recipes (armorer's stand)

### Phase 8 — Visual System
*Using 1.21.4's native model system.*

- [ ] Layered item model JSONs — layer0 blade, layer1 handle, layer2 wrap, layer3 hilt, layer4 pommel, layer5 gem
- [ ] Model selection via minecraft:select on AttachedComponent data
- [ ] One model file per valid combination generated by datagen
- [ ] Textures — all component layer PNGs (transparent, designed to composite)

### Phase 9 — Seasons
*Time-of-year affects the entire world.*

- [ ] Season state — day counter mapped to Spring/Summer/Autumn/Winter
- [ ] Season data component on ServerWorld (or persistent state)
- [ ] Crop growth modifiers per season
- [ ] Weather probability modifiers per season
- [ ] NPC schedule modifiers per season
- [ ] Visual sky/fog tinting per season (client)
- [ ] Seasonal crop availability — some crops only plantable in certain seasons

### Phase 10 — Character Lives
*Hardcore per-character, not per-world.*

- [ ] CharacterData record — UUID, name, skills, relationships, faction standing, death timestamp
- [ ] Character persistence — saved per world, multiple characters per world
- [ ] Death handler — on player death, archive character, trigger character select screen
- [ ] Character select screen — view past characters, create new one
- [ ] Character creation screen — name, appearance choices
- [ ] New character world spawn — placed in world with starter items

### Phase 11 — Skill System
*Profession skills gate content and quality.*

- [ ] Skill registry — Blacksmith, Tanner, Jeweler, Carpenter, Armorer, Farmer, Merchant, etc.
- [ ] Skill XP tracking per character — gained by relevant actions
- [ ] Skill level thresholds — Novice, Apprentice, Journeyman, Master
- [ ] Skill gating at crafting stations — quality and recipe availability locked by level
- [ ] Component swap gating — Journeyman+ Blacksmith/Tanner to swap socketed components
- [ ] Skill display — character screen shows all skill levels

### Phase 12 — NPC Overhaul
*Human-looking villagers with personality and purpose.*

- [ ] GeckoLib human NPC models — proportioned correctly, animated
- [ ] Personality system — procedural traits (friendly, suspicious, greedy, etc.) per NPC
- [ ] NPC professions mapped to our skill system — Blacksmith NPC, Tanner NPC, etc.
- [ ] Villager trading overhaul — coin-based, profession-appropriate inventory
- [ ] NPC schedules — work, eat, sleep, socialize based on time of day and season
- [ ] NPC names — procedurally generated medieval names per culture

### Phase 13 — Marriage System
*Player-player, player-NPC, NPC-NPC.*

- [ ] Relationship tracking per character — friendships, romances, marriages
- [ ] Courtship mechanics — gift giving, reputation building
- [ ] Marriage ceremony — requires officiant NPC, rings (jewelry system)
- [ ] Marriage benefits — shared inventory access, NPC spouse behavior, buffs
- [ ] NPC-NPC marriage — villagers form families independently
- [ ] Divorce/widowing — handled gracefully on character death

### Phase 14 — Faction System
*Player-created guilds and NPC allegiances.*

- [ ] Faction registry — data-driven faction definitions
- [ ] Player faction creation — name, charter, rank structure
- [ ] NPC faction alignment — each NPC belongs to a faction
- [ ] Reputation per faction per character — affects trading, dialogue, access
- [ ] Faction diplomacy — alliances, rivalries, wars between factions
- [ ] Guild halls — structures tied to faction type

### Phase 15 — Clothing & Cosmetics
*Look like whoever your character is.*

- [ ] Clothing items — merchant, farmer, guard, warrior, thief, noble variants
- [ ] Clothing provides no armor — purely cosmetic with minor stat flavoring
- [ ] Armor system — grounded metal tiers via Armorer's Stand
- [ ] Trinkets integration — rings, necklaces, earrings, brooches in accessory slots
- [ ] Backpacks — inventory expansion in Trinkets back slot
- [ ] Dyeable clothing — fabric colors via natural dye system

### Phase 16 — Structures & World
*A world that looks and feels medieval.*

- [ ] Integrated datapack — all structures defined in bundled datapack
- [ ] Villages — redesigned medieval layout, profession-specific buildings
- [ ] Keeps & castles — faction headquarters structures
- [ ] Markets — trading post structures with NPC merchants
- [ ] Inns — rest and information structures
- [ ] Guildhalls — faction-specific structures
- [ ] Loot tables — grounded medieval loot, no fantasy items
- [ ] End portal frame removal — overridden in datapack structures

### Phase 17 — Technical Polish
*Make it solid for release and addon support.*

- [ ] Addon API — documented hooks for component types, skills, factions, structures
- [ ] Config system — per-component durability toggle, other optional systems
- [ ] JEI/REI integration — all custom stations visible, component effects in tooltips
- [ ] Item group overhaul — rebuild all vanilla creative tabs for One Life context
- [ ] Advancements — progression milestones, profession tracking, secret discoveries, datagen driven
- [ ] Performance pass — profile and optimize hot paths (component resolution, render layers)
- [ ] Server compatibility — verify all systems work correctly in multiplayer
- [ ] Documentation — addon maker guide, wiki structure

---

## Dependencies

| Library | Purpose |
|---|---|
| Fabric API | Core events, resource loading, item groups |
| GeckoLib | NPC models and animations |
| Trinkets | Accessory slots (rings, jewelry, backpacks) |

---

## Intentionally Excluded

- Magic of any kind
- Nether access
- End access
- Diamond, Gold, Netherite tools and armor
- Enchanting table
- Vanilla anvil repair
- OptiFine (Iris/Sodium are fine)

---

## Addon Support Target

Every major system exposes hooks:
- Register new component types via JSON + optional Java interface
- Register new skills via JSON
- Register new faction types via JSON
- Add new structures to the datapack layer
- Extend NPC personality traits
- Add new clothing/armor sets

Goal: an addon maker should never need to touch One Life's source code
to add meaningful content that integrates with all existing systems.